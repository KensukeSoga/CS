package jp.co.isid.kkh.customer.lion.model.report.detaillist;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jp.co.isid.kkh.integ.tbl.TBTHB11WLTVK;
import jp.co.isid.kkh.integ.tbl.TBTHB1DOWN;
import jp.co.isid.kkh.integ.tbl.TBTHB2KMEI;
import jp.co.isid.kkh.integ.tbl.TBTHB9WLTVB;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.customer.lion.model.report.DetailListLionCondition;
import jp.co.isid.kkh.customer.lion.model.report.DetailListLionDaoInterface;
import jp.co.isid.kkh.customer.lion.model.report.DetailListLionVO;
import jp.co.isid.kkh.customer.lion.util.LionConstants;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractRdbDao;
import jp.co.isid.nj.model.ModelUtils;

/**
 *
 * <P>
 * ライオン明細一覧帳票(テレビタイム)検索DAO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2013/02/07)<BR>
 * </P>
 *
 * @author
 */

public class DetailListLionTvTimeDAO extends AbstractRdbDao implements  DetailListLionDaoInterface{

    /** 汎用マスタ検索条件 */
    private DetailListLionCondition _cond;

    /** 汎用マスタ：媒体種別：テレビ局マスタ */
    public static final String C_HBAMST_SYBT_TV_KYOKU = LionConstants.MastBaitaiShubetsu.TV_KYOKU.getCode();
    //public static final String C_HBAMST_SYBT_TV_KYOKU = "401";

    /** 汎用マスタ：媒体種別：テレビ番組マスタ */
    public static final String C_HBAMST_SYBT_TV_BANGUMI =  LionConstants.MastBaitaiShubetsu.TV_BANGUMI.getCode();
    //public static final String C_HBAMST_SYBT_TV_BANGUMI = "601";

    /** getSelectSQLで発行するSQLのモード() */
//	private enum SqlMode {
//		KIND, ITEM,
//	};

    //private SqlMode _sqlMode = SqlMode.KIND;

    /**
     * デフォルトコンストラクタ。
     */
    public DetailListLionTvTimeDAO() {
        super.setPoolConnectClass(KKHPoolConnect.class);
        super.setDBModelInterface(KKHOracleModel.getInstance());
        super.setBigDecimalMode(true);
    }

    /**
     * プライマリキーを返します。
     *
     * @return String[] プライマリキー
     */
    @Override
    public String[] getPrimryKeyNames() {
        return null;
    }

    /**
     * 更新日付フィールドを返します。
     *
     * @return String 更新日付フィールド
     */
    public String getTimeStampKeyName() {
        // new String[] {};
        return null;
    }

    /**
     * テーブル名を返します。
     *
     * @return String テーブル名
     */
    @Override
    public String getTableName() {
        return TBTHB2KMEI.TBNAME;
    }

    /**
     * テーブル列名を返します。
     *
     * @return String[] テーブル列名
     */
    @Override
    public String[] getTableColumnNames() {
        return null;
    }

    /**
     * デフォルトのSQL文を返します。
     *
     * @return String SQL文
     */
    @Override
    public String getSelectSQL() {
        return getSelectSQLForItem();
    }

    private String getSelectSQLForItem() {

        // SQL.
        StringBuffer sql = new StringBuffer();

        // 各媒体共通項目↓.
        sql.append(" SELECT ");
        sql.append("  " + TBTHB2KMEI.YYMM		+ " ");	//検索年月
        sql.append(" ," + TBTHB2KMEI.CODE1		+ " ");	//媒体区分
        sql.append(" ," + TBTHB2KMEI.CODE4 		+ " ");	//代理店コード
        sql.append(" ," + TBTHB2KMEI.CODE6 		+ " ");	//カードNo
        sql.append(" ," + TBTHB2KMEI.SONOTA5 	+ " ");	//本数
        sql.append(" ," + TBTHB2KMEI.KNGK2 		+ " ");	//ネット料
        sql.append(" ," + TBTHB2KMEI.KNGK3 		+ " ");	//制作費
        sql.append(" ," + TBTHB2KMEI.SEIGAK 	+ " ");	//請求額
        sql.append(" ," + TBTHB2KMEI.NEBIGAK 	+ " ");	//値引額
//		sql.append(" ," + "TRUNC("
//						+ "DECODE(TRIM(" + TBTHB2KMEI.SEIGAK + ") , NULL , 0 , " + TBTHB2KMEI.SEIGAK  + ")" + " * "
//						+ "TRIM(" + TBTHB2KMEI.RITU1  + ")  / 100  )" + " AS SHOHIZEI_GAK " 	+ " ");	//消費税額
        sql.append(" ,TO_NUMBER(" + TBTHB2KMEI.NAME1 + ") AS SHOHIZEI_GAK "); // 消費税額
        sql.append(" ," + "mast3.HB11_KYOKUCD" 	+ " AS " + DetailListLionVO.KYOKU_CD	+ " ");	//局コード
        sql.append(" ," + "mast3.HB11_KYOKUNAME" 	+ " AS " + DetailListLionVO.KYOKU_MEI	+ " ");	//局名
        sql.append(" ," + "mast1.HB9_BANCD" 	+ " AS " + DetailListLionVO.BANGUMI_CD	+ " ");	//番組コード
        sql.append(" ," + "mast1.HB9_BANNAME" 	+ " AS " + DetailListLionVO.BANGUMI_MEI	+ " ");	//番組名

        //*************************************************************************************************
        //FROM
        //*************************************************************************************************
        sql.append(" FROM ");
        sql.append(TBTHB1DOWN.TBNAME  + " , ");
        sql.append(TBTHB2KMEI.TBNAME  + " , ");
        sql.append(TBTHB9WLTVB.TBNAME + " mast1  , ");
        sql.append(TBTHB11WLTVK.TBNAME + " mast3 ");

        //*************************************************************************************************
        //WHERE句
        //*************************************************************************************************
        sql.append(" WHERE ");
        sql.append(TBTHB1DOWN.EGCD 			+ " = '" + _cond.getEgCd() 				+ "' AND ");
        sql.append(TBTHB1DOWN.TKSKGYCD 		+ " = '" + _cond.getTksKgyCd() 			+ "' AND ");
        sql.append(TBTHB1DOWN.TKSBMNSEQNO 	+ " = '" + _cond.getTksBmnSeqNo() 		+ "' AND ");
        sql.append(TBTHB1DOWN.TKSTNTSEQNO 	+ " = '" + _cond.getTksTntSeqNo() 		+ "' AND ");
        sql.append(TBTHB1DOWN.YYMM + " BETWEEN '" + _cond.getymfrom() + "' AND '" + _cond.getymto() + "' AND ");

        sql.append(TBTHB1DOWN.EGCD 			+ " =  " + TBTHB2KMEI.EGCD  			+ "  AND ");
        sql.append(TBTHB1DOWN.TKSKGYCD 		+ " =  " + TBTHB2KMEI.TKSKGYCD 			+ "  AND ");
        sql.append(TBTHB1DOWN.TKSBMNSEQNO 	+ " =  " + TBTHB2KMEI.TKSBMNSEQNO 		+ "  AND ");
        sql.append(TBTHB1DOWN.TKSTNTSEQNO 	+ " =  " + TBTHB2KMEI.TKSTNTSEQNO 		+ "  AND ");
        sql.append(TBTHB1DOWN.YYMM 			+ " =  " + TBTHB2KMEI.YYMM 				+ "  AND ");
        sql.append(TBTHB1DOWN.JYUTNO 		+ " =  " + TBTHB2KMEI.JYUTNO  			+ "  AND ");
        sql.append(TBTHB1DOWN.JYMEINO 		+ " =  " + TBTHB2KMEI.JYMEINO 			+ "  AND ");
        sql.append(TBTHB1DOWN.URMEINO 		+ " =  " + TBTHB2KMEI.URMEINO 			+ "  AND ");
        sql.append(TBTHB1DOWN.TJYUTNO 		+ " =  " + "' '" 						+ "  AND ");

        sql.append(TBTHB9WLTVB.EGCD			+ " =  " + TBTHB2KMEI.EGCD  			+ "  AND ");
        sql.append(TBTHB9WLTVB.TKSKGYCD		+ " =  " + TBTHB2KMEI.TKSKGYCD 			+ "  AND ");
        sql.append(TBTHB9WLTVB.TKSBMNSEQNO	+ " =  " + TBTHB2KMEI.TKSBMNSEQNO 		+ "  AND ");
        sql.append(TBTHB9WLTVB.TKSTNTSEQNO	+ " =  " + TBTHB2KMEI.TKSTNTSEQNO 		+ "  AND ");
        sql.append(TBTHB9WLTVB.BANCD		+ " =  " + "TRIM(" + TBTHB2KMEI.CODE5	+ ") AND ");

        sql.append(TBTHB11WLTVK.EGCD 		+ " =  " + TBTHB2KMEI.EGCD  			+ "  AND ");
        sql.append(TBTHB11WLTVK.TKSKGYCD 	+ " =  " + TBTHB2KMEI.TKSKGYCD 			+ "  AND ");
        sql.append(TBTHB11WLTVK.TKSBMNSEQNO	+ " =  " + TBTHB2KMEI.TKSBMNSEQNO 		+ "  AND ");
        sql.append(TBTHB11WLTVK.TKSTNTSEQNO	+ " =  " + TBTHB2KMEI.TKSTNTSEQNO 		+ "  AND ");
        sql.append(TBTHB11WLTVK.KYOKUCD		+ " =  " + "TRIM(" + TBTHB2KMEI.CODE2	+ ") AND ");

        sql.append("TRIM("+ TBTHB2KMEI.CODE6	+ ")" + " IN "+ " ('001' , '002' ) "	+ "  AND ");
        sql.append("TRIM("+ TBTHB2KMEI.CODE1	+ ")" + " = " + " '01' "				+ "      ");

        //*************************************************************************************************
        //OREDER BY
        //*************************************************************************************************
        sql.append(" ORDER BY ");
        sql.append("  " + TBTHB2KMEI.YYMM + ", ");
        sql.append(TBTHB2KMEI.CODE6 				+ ", ");
//		sql.append("mast1."	+ TBTHB9WLTVB.HYOJIJYUN	+ ", ");
        sql.append(""	+ TBTHB2KMEI.CODE5 		+ ", ");
        sql.append(""	+ TBTHB2KMEI.CODE2 		+ "  ");

        return sql.toString();
    }

    /**
     * 帳票データ(ライオン)の検索を行います。
     *
     * @return 汎用テーブルマスタVOリスト
     * @throws UserException
     *             データアクセス中にエラーが発生した場合。
     */
    @SuppressWarnings("unchecked")
    public List<DetailListLionVO> findDetailListLionByCondition(DetailListLionCondition cond)
            throws KKHException {

        super.setModel(new DetailListLionVO());

        try {
            _cond = cond;
            return super.find();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0002");
        }
    }

    /**
     * Modelの生成を行う<br>
     * 検索結果のVOのKEYが大文字のため変換処理を行う<br>
     * AbstractRdbDaoのcreateFindedModelInstancesをオーバーライド<br>
     *
     * @param hashList
     *            List 検索結果
     * @return List<CommonCodeMasterVO> 変換後の検索結果
     */
    @Override
    protected List<DetailListLionVO> createFindedModelInstances(List hashList) {
        List<DetailListLionVO> list = new ArrayList<DetailListLionVO>();
        if (getModel() instanceof DetailListLionVO) {
            for (int i = 0; i < hashList.size(); i++) {
                Map result = (Map) hashList.get(i);
                DetailListLionVO vo = new DetailListLionVO();
                vo.setYymm((String) result.get(TBTHB2KMEI.YYMM.toUpperCase()));							//検索年月
                vo.setCode1((String) result.get(TBTHB2KMEI.CODE1.toUpperCase().trim()));				//媒体区分
                vo.setCode4((String) result.get(TBTHB2KMEI.CODE4.toUpperCase().trim()));				//代理店コード
                vo.setCode6((String) result.get(TBTHB2KMEI.CODE6.toUpperCase().trim()));				//カードNo
                vo.setSonota5((String) result.get(TBTHB2KMEI.SONOTA5.toUpperCase().trim()));			//本数
                vo.setKngk2((BigDecimal) result.get(TBTHB2KMEI.KNGK2.toUpperCase()));					//ネット料
                vo.setKngk3((BigDecimal) result.get(TBTHB2KMEI.KNGK3.toUpperCase()));					//制作費
                vo.setSeiGak((BigDecimal) result.get(TBTHB2KMEI.SEIGAK.toUpperCase()));					//請求額
                vo.setNebigak((BigDecimal) result.get(TBTHB2KMEI.NEBIGAK.toUpperCase()));				//値引額
                vo.setShohizeiGak((BigDecimal) result.get(DetailListLionVO.SHOHIZEI_GAK.toUpperCase()));	//消費税額
                vo.setByosuGokei((BigDecimal) result.get(DetailListLionVO.BYOSU_GOKEI.toUpperCase()));		//CM秒数合計
                vo.setKyokuCd((String) result.get(DetailListLionVO.KYOKU_CD.toUpperCase()));				//局コード
                vo.setKyokuMei((String) result.get(DetailListLionVO.KYOKU_MEI.toUpperCase()));				//局名称
                vo.setBangumiCd((String) result.get(DetailListLionVO.BANGUMI_CD.toUpperCase()));			//番組コード
                vo.setBangumiMei((String) result.get(DetailListLionVO.BANGUMI_MEI.toUpperCase()));			//番組名称

                // 検索結果直後の状態にする
                ModelUtils.copyMemberSearchAfterInstace(vo);
                list.add(vo);
            }
        }

        return list;
    }

}

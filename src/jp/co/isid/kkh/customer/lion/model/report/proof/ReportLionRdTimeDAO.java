package jp.co.isid.kkh.customer.lion.model.report.proof;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jp.co.isid.kkh.integ.tbl.TBTHB10WLRDB;
import jp.co.isid.kkh.integ.tbl.TBTHB12WLRDK;
import jp.co.isid.kkh.integ.tbl.TBTHB1DOWN;
import jp.co.isid.kkh.integ.tbl.TBTHB2KMEI;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.customer.lion.model.report.ReportLionCondition;
import jp.co.isid.kkh.customer.lion.model.report.ReportLionProofDaoInterface;
import jp.co.isid.kkh.customer.lion.model.report.ReportLionVO;
import jp.co.isid.kkh.customer.lion.util.LionConstants;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractRdbDao;
import jp.co.isid.nj.model.ModelUtils;
/**
 *
 * <P>
 * ライオンプルーフリスト帳票(ラジオタイム)検索DAO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/01/11)<BR>
 * </P>
 *
 * @author
 */

public class ReportLionRdTimeDAO extends AbstractRdbDao implements  ReportLionProofDaoInterface{

    /** 汎用マスタ検索条件 */
    private ReportLionCondition _cond;

    /** 汎用マスタ：媒体種別：ラジオ局マスタ */
    public static final String C_HBAMST_SYBT_RD_KYOKU = LionConstants.MastBaitaiShubetsu.RD_KYOKU.getCode();
    //public static final String C_HBAMST_SYBT_RD_KYOKU = "402";

    /** 汎用マスタ：媒体種別：ラジオ番組マスタ */
    public static final String C_HBAMST_SYBT_RD_BANGUMI = LionConstants.MastBaitaiShubetsu.RD_BANGUMI.getCode();
   // public static final String C_HBAMST_SYBT_RD_BANGUMI = "602";

    /** getSelectSQLで発行するSQLのモード() */
//	private enum SqlMode {
//		KIND, ITEM,
//	};

    //private SqlMode _sqlMode = SqlMode.KIND;

    /**
     * デフォルトコンストラクタ。
     */
    public ReportLionRdTimeDAO() {
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
        sql.append(" ,(" + TBTHB2KMEI.RITU1 + "* 0.01) AS SHOHIZEI_RITU" ); //消費税率
        sql.append(" ," + TBTHB2KMEI.SEIGAK 	+ " ");	//請求額
        sql.append(" ," + TBTHB2KMEI.NEBIGAK 	+ " ");	//値引額
//		sql.append(" ," + "TRUNC("
//						+ "DECODE(TRIM(" + TBTHB2KMEI.SEIGAK + ") , NULL , 0 , " + TBTHB2KMEI.SEIGAK  + ")" + " * "
//						+ "DECODE(TRIM(" + TBTHB2KMEI.RITU1  + ") , NULL , 5 , " + TBTHB2KMEI.RITU1   + ")" + "/ 100 )" + " AS SHOHIZEI_GAK " + " ");	//消費税額
        sql.append(" ,TO_NUMBER(" + TBTHB2KMEI.NAME1 + ") AS SHOHIZEI_GAK "); // 消費税額
        sql.append(" ," + "mast3.HB12_KYOKUCD" 	+ " AS " + ReportLionVO.KYOKU_CD	+ " ");	//局コード
        sql.append(" ," + "mast3.HB12_KYOKUNAME" 	+ " AS " + ReportLionVO.KYOKU_MEI	+ " ");	//局名
        sql.append(" ," + "mast1.HB10_BANCD" 	+ " AS " + ReportLionVO.BANGUMI_CD	+ " ");	//番組コード
        sql.append(" ," + "mast1.HB10_BANNAME" 	+ " AS " + ReportLionVO.BANGUMI_MEI	+ " ");	//番組名

        //*************************************************************************************************
        //FROM
        //*************************************************************************************************
        sql.append(" FROM ");
        sql.append(TBTHB1DOWN.TBNAME +  " , ");
        sql.append(TBTHB2KMEI.TBNAME +" , ");
        sql.append(TBTHB10WLRDB.TBNAME + " mast1 ,");
        sql.append(TBTHB12WLRDK.TBNAME + " mast3");

        //*************************************************************************************************
        //WHERE句
        //*************************************************************************************************
        sql.append(" WHERE ");
        sql.append(TBTHB1DOWN.EGCD 			+ " = '" + _cond.getEgCd()				+ "' AND ");
        sql.append(TBTHB1DOWN.TKSKGYCD 		+ " = '" + _cond.getTksKgyCd()			+ "' AND ");
        sql.append(TBTHB1DOWN.TKSBMNSEQNO 	+ " = '" + _cond.getTksBmnSeqNo()		+ "' AND ");
        sql.append(TBTHB1DOWN.TKSTNTSEQNO 	+ " = '" + _cond.getTksTntSeqNo()		+ "' AND ");
        sql.append(TBTHB1DOWN.YYMM 			+ " = '" + _cond.getYm()				+ "' AND ");

        sql.append(TBTHB1DOWN.EGCD 			+ " =  " + TBTHB2KMEI.EGCD				+ "  AND ");
        sql.append(TBTHB1DOWN.TKSKGYCD 		+ " =  " + TBTHB2KMEI.TKSKGYCD			+ "  AND ");
        sql.append(TBTHB1DOWN.TKSBMNSEQNO 	+ " =  " + TBTHB2KMEI.TKSBMNSEQNO		+ "  AND ");
        sql.append(TBTHB1DOWN.TKSTNTSEQNO 	+ " =  " + TBTHB2KMEI.TKSTNTSEQNO		+ "  AND ");
        sql.append(TBTHB1DOWN.YYMM 			+ " =  " + TBTHB2KMEI.YYMM				+ "  AND ");
        sql.append(TBTHB1DOWN.JYUTNO 		+ " =  " + TBTHB2KMEI.JYUTNO			+ "  AND ");
        sql.append(TBTHB1DOWN.JYMEINO 		+ " =  " + TBTHB2KMEI.JYMEINO			+ "  AND ");
        sql.append(TBTHB1DOWN.URMEINO 		+ " =  " + TBTHB2KMEI.URMEINO			+ "  AND ");
        sql.append(TBTHB1DOWN.TJYUTNO 		+ " =  " + "' '"						+ "  AND ");

        sql.append(TBTHB10WLRDB.EGCD 		+ " =  " + TBTHB2KMEI.EGCD				+ "  AND ");
        sql.append(TBTHB10WLRDB.TKSKGYCD 	+ " =  " + TBTHB2KMEI.TKSKGYCD			+ "  AND ");
        sql.append(TBTHB10WLRDB.TKSBMNSEQNO	+ " =  " + TBTHB2KMEI.TKSBMNSEQNO		+ "  AND ");
        sql.append(TBTHB10WLRDB.TKSTNTSEQNO	+ " =  " + TBTHB2KMEI.TKSTNTSEQNO		+ "  AND ");
        sql.append(TBTHB10WLRDB.BANCD 		+ " =  " + "TRIM(" + TBTHB2KMEI.CODE5	+ ") AND ");

        sql.append(TBTHB12WLRDK.EGCD 		+ " =  " + TBTHB2KMEI.EGCD				+ "  AND ");
        sql.append(TBTHB12WLRDK.TKSKGYCD 	+ " =  " + TBTHB2KMEI.TKSKGYCD			+ "  AND ");
        sql.append(TBTHB12WLRDK.TKSBMNSEQNO	+ " =  " + TBTHB2KMEI.TKSBMNSEQNO		+ "  AND ");
        sql.append(TBTHB12WLRDK.TKSTNTSEQNO	+ " =  " + TBTHB2KMEI.TKSTNTSEQNO		+ "  AND ");
        sql.append(TBTHB12WLRDK.KYOKUCD		+ " =  " + "TRIM(" + TBTHB2KMEI.CODE2	+ ") AND ");

        sql.append("TRIM("+ TBTHB2KMEI.CODE6	+ ")" + " IN "+ " ('003' , '004' ) "	+ "  AND ");
        sql.append("TRIM("+ TBTHB2KMEI.CODE1	+ ")" + " = " + " '04' "				+ "      ");

        //*************************************************************************************************
        //OREDER BY
        //*************************************************************************************************
        sql.append(" ORDER BY ");
        sql.append(TBTHB2KMEI.CODE6 					+ ", ");
//		sql.append("mast1."	+ TBTHB10WLRDB.HYOJIJYUN 		+ ", ");
        sql.append("mast3."	+ TBTHB12WLRDK.HYOJIJYUN 		+ ", ");
        sql.append(" "	+ TBTHB2KMEI.CODE5 			+ ", ");
        sql.append(" "	+ TBTHB2KMEI.CODE2 			+ "  ");

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
    public List<ReportLionVO> findReportLionByCondition(ReportLionCondition cond)
            throws KKHException {

        super.setModel(new ReportLionVO());

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
    protected List<ReportLionVO> createFindedModelInstances(List hashList) {
        List<ReportLionVO> list = new ArrayList<ReportLionVO>();
        if (getModel() instanceof ReportLionVO) {
            for (int i = 0; i < hashList.size(); i++) {
                Map result = (Map) hashList.get(i);
                ReportLionVO vo = new ReportLionVO();
                vo.setYymm((String) result.get(TBTHB2KMEI.YYMM.toUpperCase()));							//検索年月
                vo.setCode1((String) result.get(TBTHB2KMEI.CODE1.toUpperCase().trim()));				//媒体区分
                vo.setCode4((String) result.get(TBTHB2KMEI.CODE4.toUpperCase().trim()));				//代理店コード
                vo.setCode6((String) result.get(TBTHB2KMEI.CODE6.toUpperCase().trim()));				//カードNo
                vo.setSonota5((String) result.get(TBTHB2KMEI.SONOTA5.toUpperCase().trim()));			//本数
                vo.setKngk2((BigDecimal) result.get(TBTHB2KMEI.KNGK2.toUpperCase()));					//ネット料
                vo.setKngk3((BigDecimal) result.get(TBTHB2KMEI.KNGK3.toUpperCase()));					//制作費
                vo.setSeiGak((BigDecimal) result.get(TBTHB2KMEI.SEIGAK.toUpperCase()));					//請求額
                vo.setNebigak((BigDecimal) result.get(TBTHB2KMEI.NEBIGAK.toUpperCase()));				//値引額
                vo.setShohizeiRitu((BigDecimal) result.get(ReportLionVO.SHOHIZEI_RITU.toUpperCase()));  //消費税率
                vo.setShohizeiGak((BigDecimal) result.get(ReportLionVO.SHOHIZEI_GAK.toUpperCase()));	//消費税額
                vo.setByosuGokei((BigDecimal) result.get(ReportLionVO.BYOSU_GOKEI.toUpperCase()));		//CM秒数合計
                vo.setKyokuCd((String) result.get(ReportLionVO.KYOKU_CD.toUpperCase()));				//局コード
                vo.setKyokuMei((String) result.get(ReportLionVO.KYOKU_MEI.toUpperCase()));				//局名称
                vo.setBangumiCd((String) result.get(ReportLionVO.BANGUMI_CD.toUpperCase()));			//番組コード
                vo.setBangumiMei((String) result.get(ReportLionVO.BANGUMI_MEI.toUpperCase()));			//番組名称

                // 検索結果直後の状態にする
                ModelUtils.copyMemberSearchAfterInstace(vo);
                list.add(vo);
            }
        }

        return list;
    }

}

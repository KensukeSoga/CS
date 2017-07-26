package jp.co.isid.kkh.customer.lion.model.report.detaillist;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jp.co.isid.kkh.integ.tbl.TBTHB1DOWN;
import jp.co.isid.kkh.integ.tbl.TBTHB2KMEI;
import jp.co.isid.kkh.integ.tbl.TBTHBAMST;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.customer.lion.model.report.DetailListLionCondition;
import jp.co.isid.kkh.customer.lion.model.report.DetailListLionDaoInterface;
import jp.co.isid.kkh.customer.lion.model.report.DetailListLionVO;
import jp.co.isid.kkh.customer.lion.model.report.detaillist.LionDetailListConstants;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractRdbDao;
import jp.co.isid.nj.model.ModelUtils;

/**
 *
 * <P>
 * 帳票（Lion)検索DAO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2013/02/07)<BR>
 * </P>
 *
 * @author
 */

public class DetailListLionZashiDAO extends AbstractRdbDao implements  DetailListLionDaoInterface{

    /** 汎用マスタ検索条件 */
    private DetailListLionCondition _cond;

    /** 汎用マスタ：媒体種別：テレビ局マスタ */
    public static final String C_HBAMST_SYBT_TV_KYOKU = LionDetailListConstants.MastBaitaiShubetsu.TV_KYOKU.getCode();
    //public static final String C_HBAMST_SYBT_TV_KYOKU = "401";

    /** 汎用マスタ：媒体種別：テレビ番組マスタ */
    public static final String C_HBAMST_SYBT_TV_BANGUMI =  LionDetailListConstants.MastBaitaiShubetsu.TV_BANGUMI.getCode();
    //public static final String C_HBAMST_SYBT_TV_BANGUMI = "601";

    /** getSelectSQLで発行するSQLのモード() */
//	private enum SqlMode {
//		KIND, ITEM,
//	};

    //private SqlMode _sqlMode = SqlMode.KIND;

    /**
     * デフォルトコンストラクタ。
     */
    public DetailListLionZashiDAO() {
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

        sql.append(" SELECT ");
        sql.append(" " + TBTHB2KMEI.CODE6 + ", ");
        sql.append(" " + TBTHB2KMEI.YYMM + ", ");
        sql.append(" " + TBTHB2KMEI.CODE4 + ", ");
        sql.append(" " + TBTHB2KMEI.CODE1 + ", ");
        sql.append(" " + TBTHB2KMEI.CODE3 + ", ");
        sql.append(" " + TBTHB2KMEI.CODE2 + " " + DetailListLionVO.ZASHI_CD + ", ");
        sql.append(" " + TBTHB2KMEI.NAME2 + " " + DetailListLionVO.SPACE + ", ");
        sql.append(" " + TBTHB2KMEI.NAME4 + ", ");
        sql.append(" " + TBTHB2KMEI.SEIGAK + ", ");
        sql.append(" " + TBTHB2KMEI.NAME8 + ", ");
        sql.append(" " + TBTHB2KMEI.NAME1 + ", ");
        sql.append(" " + TBTHB2KMEI.KNGK3 + ", ");
        sql.append("  mast2." + TBTHBAMST.FIELD2 + " " + DetailListLionVO.BRAND_MEI + ", ");
        sql.append("  mast1." + TBTHBAMST.FIELD2 + " " + DetailListLionVO.ZASHI_NAME + " ");
        sql.append(" FROM ");
        sql.append(" " + TBTHB2KMEI.TBNAME + " , ");
        sql.append(" " + TBTHB1DOWN.TBNAME + " , ");
        sql.append(" " + TBTHBAMST.TBNAME + "  mast1, ");
        sql.append(" " + TBTHBAMST.TBNAME + "  mast2 ");
        sql.append(" WHERE ");
        sql.append(" " + TBTHB2KMEI.EGCD + " = '" +_cond.getEgCd() +"'AND ");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = '" +_cond.getTksKgyCd() +"' AND ");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = '" +_cond.getTksBmnSeqNo() +"' AND ");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = '" +_cond.getTksTntSeqNo() +"' AND ");
        sql.append(" " + TBTHB2KMEI.YYMM + " BETWEEN '" + _cond.getymfrom() + "' AND '" + _cond.getymto() + "' AND ");
        sql.append(" " + TBTHB2KMEI.CODE6 + " IN ('008') AND ");
        sql.append(" mast1." + TBTHBAMST.SYBT + " =  '106' AND ");
        sql.append(" TRIM(" + TBTHB2KMEI.CODE2 + ")  = mast1." + TBTHBAMST.FIELD1 + " AND");
        sql.append(" mast2." + TBTHBAMST.SYBT + " =  '201' AND ");
        sql.append(" TRIM(" + TBTHB2KMEI.CODE3 + ")  = mast2." + TBTHBAMST.FIELD1 + " AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = mast1." + TBTHBAMST.TKSKGYCD + " AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = mast1." + TBTHBAMST.TKSBMNSEQNO + " AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = mast1." + TBTHBAMST.TKSTNTSEQNO + " AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = mast2." + TBTHBAMST.TKSKGYCD + " AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = mast2." + TBTHBAMST.TKSBMNSEQNO + " AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = mast2." + TBTHBAMST.TKSTNTSEQNO + " AND");
        sql.append(" " + TBTHB2KMEI.EGCD  + " =  " +  TBTHB1DOWN.EGCD + " AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD  + " =  " +  TBTHB1DOWN.TKSKGYCD + " AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO  + " =  " +  TBTHB1DOWN.TKSBMNSEQNO+ " AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO  + " =  " +  TBTHB1DOWN.TKSTNTSEQNO + " AND");
        sql.append(" " + TBTHB2KMEI.YYMM  + " =  " +  TBTHB1DOWN.YYMM + " AND");
        sql.append(" " + TBTHB2KMEI.JYUTNO  + " =  " +  TBTHB1DOWN.JYUTNO + " AND");
        sql.append(" " + TBTHB2KMEI.JYMEINO + " =  " +  TBTHB1DOWN.JYMEINO+ " AND");
        sql.append(" " + TBTHB2KMEI.URMEINO  + " =  " +  TBTHB1DOWN.URMEINO + " AND");
        sql.append(" " + TBTHB1DOWN.TJYUTNO + " =  ' ' ");
        sql.append(" ORDER BY ");
        sql.append("  " + TBTHB2KMEI.YYMM + ", ");
        sql.append(" " + TBTHB2KMEI.CODE3 + ", ");
        sql.append(" " + TBTHB2KMEI.CODE2 + ", ");
        sql.append("  " + TBTHB2KMEI.JYUTNO + ", ");
        sql.append("  " + TBTHB2KMEI.JYMEINO + ", ");
        sql.append("  " + TBTHB2KMEI.URMEINO + " ");

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
                vo.setCode6((String) result.get(TBTHB2KMEI.CODE6.toUpperCase().trim()));
                vo.setYymm((String) result.get(TBTHB2KMEI.YYMM.toUpperCase()));
                vo.setCode4((String) result.get(TBTHB2KMEI.CODE4.toUpperCase().trim()));
                vo.setCode1((String) result.get(TBTHB2KMEI.CODE1.toUpperCase().trim()));
                vo.setBrandCd((String) result.get(TBTHB2KMEI.CODE3.toUpperCase().trim()));
                vo.setZashiCd((String) result.get(DetailListLionVO.ZASHI_CD.toUpperCase().trim()));
                vo.setSpace((String) result.get(DetailListLionVO.SPACE.toUpperCase().trim()));
                vo.setName4((String) result.get(TBTHB2KMEI.NAME4.toUpperCase().trim()));
                vo.setSeiGak((BigDecimal) result.get(TBTHB2KMEI.SEIGAK.toUpperCase()));
                vo.setName8((String) result.get(TBTHB2KMEI.NAME8.toUpperCase().trim()));
                vo.setName1((String) result.get(TBTHB2KMEI.NAME1.toUpperCase().trim()));
                vo.setKngk3((BigDecimal) result.get(TBTHB2KMEI.KNGK3.toUpperCase()));
                vo.setZashiName((String) result.get(DetailListLionVO.ZASHI_NAME.toUpperCase().trim()));	//雑誌名
                vo.setBrandMei((String) result.get(DetailListLionVO.BRAND_MEI.toUpperCase().trim()));	//ブランド名

//				vo.setNebigak((BigDecimal) result.get(TBTHB2KMEI.NEBIGAK.toUpperCase()));				//値引額
//				vo.setSonota5((String) result.get(TBTHB2KMEI.SONOTA5.toUpperCase().trim()));			//本数
//				vo.setSonota7((String) result.get(TBTHB2KMEI.SONOTA7.toUpperCase().trim()));			//秒数
//				vo.setShohizeiGak((BigDecimal) result.get(DetailListLionVO.SHOHIZEI_GAK.toUpperCase().trim()));			//消費税
//
//				vo.setShinMei((String) result.get(DetailListLionVO.SHINBUN_MEI.toUpperCase().trim())); //新聞名
//				vo.setBrandCd((String) result.get(DetailListLionVO.BRAND_CD.toUpperCase().trim())); //ブランドコード
//				vo.setBrandMei((String) result.get(DetailListLionVO.BRAND_MEI.toUpperCase().trim())); //ブランド名
//
//				vo.setKngk2((BigDecimal) result.get(TBTHB2KMEI.KNGK2.toUpperCase()));					//ネット料
//				vo.setKngk3((BigDecimal) result.get(TBTHB2KMEI.KNGK3.toUpperCase()));					//制作費
//
//
//				vo.setShohizeiGak((BigDecimal) result.get(DetailListLionVO.SHOHIZEI_GAK.toUpperCase()));	//消費税額
//				vo.setByosuGokei((BigDecimal) result.get(DetailListLionVO.BYOSU_GOKEI.toUpperCase()));		//CM秒数合計
//				vo.setKyokuCd((String) result.get(DetailListLionVO.KYOKU_CD.toUpperCase()));				//局コード
//				vo.setKyokuMei((String) result.get(DetailListLionVO.KYOKU_MEI.toUpperCase()));				//局名称
//				vo.setBangumiCd((String) result.get(DetailListLionVO.BANGUMI_CD.toUpperCase()));			//番組コード
//				vo.setBangumiMei((String) result.get(DetailListLionVO.BANGUMI_MEI.toUpperCase()));			//番組名称

                // 検索結果直後の状態にする
                ModelUtils.copyMemberSearchAfterInstace(vo);
                list.add(vo);
            }
        }

        return list;
    }

}

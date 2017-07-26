package jp.co.isid.kkh.customer.lion.model.report.proof;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jp.co.isid.kkh.integ.tbl.TBTHB11WLTVK;
import jp.co.isid.kkh.integ.tbl.TBTHB1DOWN;
import jp.co.isid.kkh.integ.tbl.TBTHB2KMEI;
import jp.co.isid.kkh.integ.tbl.TBTHBAMST;
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
 * ライオン帳票(プルーフリスト、テレビスポット)検索DAO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/01/11)<BR>
 * ・消費税端数調整対応(2014/07/31 HLC S.Fujimoto)<BR>
 * </P>
 *
 * @author
 */

public class ReportLionTvSpotDAO extends AbstractRdbDao implements  ReportLionProofDaoInterface{

    /** ライオン帳票検索条件 */
    private ReportLionCondition _cond;

    /** 汎用マスタ：媒体種別：テレビ局マスタ */
    public static final String C_HBAMST_SYBT_TV_KYOKU = LionConstants.MastBaitaiShubetsu.TV_KYOKU.getCode();
    //public static final String C_HBAMST_SYBT_TV_KYOKU = "401";

    /** 汎用マスタ：媒体種別：ブランドマスタ */
    public static final String C_HBAMST_SYBT_BRAND =  LionConstants.MastBaitaiShubetsu.BRAND.getCode();

    /**
     * デフォルトコンストラクタ。
     */
    public ReportLionTvSpotDAO() {
        super.setPoolConnectClass(KKHPoolConnect.class);
        super.setDBModelInterface(KKHOracleModel.getInstance());
        super.setBigDecimalMode(true);
    }

    /**
     * プライマリキーを返します。
     * @return String[] プライマリキー
     */
    @Override
    public String[] getPrimryKeyNames() {
        return null;
    }

    /**
     * 更新日付フィールドを返します。
     * @return String 更新日付フィールド
     */
    public String getTimeStampKeyName() {
        // new String[] {};
        return null;
    }

    /**
     * テーブル名を返します。
     * @return String テーブル名
     */
    @Override
    public String getTableName() {
        return TBTHB2KMEI.TBNAME;
    }

    /**
     * テーブル列名を返します。
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
        /* 2014/07/31 消費税端数調整対応 HLC fujimoto ADD start */
        sql.append("/*+ ordered */");
        /* 2014/07/31 消費税端数調整対応 HLC fujimoto ADD end */
        sql.append("  " + TBTHB2KMEI.YYMM		+ " ");	//検索年月
        sql.append(" ," + TBTHB2KMEI.CODE1		+ " ");	//媒体区分
        sql.append(" ," + TBTHB2KMEI.CODE4 		+ " ");	//代理店コード
        sql.append(" ," + TBTHB2KMEI.CODE6 		+ " ");	//カードNo
        sql.append(" ," + TBTHB2KMEI.NAME7 		+ " ");	//期間
        sql.append(" ," + TBTHB2KMEI.SONOTA5 	+ " ");	//回数
        sql.append(" ," + TBTHB2KMEI.SONOTA7 	+ " ");	//CM1本の秒数
        sql.append(" ," + TBTHB2KMEI.SEIGAK 	+ " ");	//請求額
        sql.append(" ," + TBTHB2KMEI.RITU1		+ " ");	//消費税率
        sql.append(" ,(" + TBTHB2KMEI.RITU1 + "* 0.01) AS SHOHIZEI_RITU" ); //消費税率
        sql.append(" ," + TBTHB2KMEI.NAME7 		+ " ");	//期間
        sql.append(" ," + "DECODE(TRIM(" + TBTHB2KMEI.SONOTA5	+ ") , NULL , 0 , " + TBTHB2KMEI.SONOTA5 + ")"	+ " * "
                        + "DECODE(TRIM(" + TBTHB2KMEI.SONOTA7	+ ") , NULL , 0 , " + TBTHB2KMEI.SONOTA7 + ")"	+ "  AS BYOSU_GOKEI " + " ");	//回数 * CM1本の秒数
//		sql.append(" ," + "TRUNC("
//						+ "DECODE(TRIM(" + TBTHB2KMEI.SEIGAK	+ ") , NULL , 0 , " + TBTHB2KMEI.SEIGAK  + ")" + " * "
//						+ "TRIM(" + TBTHB2KMEI.RITU1 + ")" + " / 100 )" +  " AS SHOHIZEI_GAK " + " ");	//消費税額
        sql.append(" ,TO_NUMBER(" + TBTHB2KMEI.NAME1 + ") AS SHOHIZEI_GAK "); // 消費税額
        sql.append(" ," + "mast3.HB11_KYOKUCD" 	+ " AS " + ReportLionVO.KYOKU_CD	+ " ");	//局コード
        sql.append(" ," + "mast3.HB11_KYOKUNAME" 	+ " AS " + ReportLionVO.KYOKU_MEI	+ " ");	//局名
        sql.append(" ," + "mast5.HBA_FIELD1" 	+ " AS " + ReportLionVO.BRAND_CD	+ " ");	//ブランドコード
        sql.append(" ," + "mast5.HBA_FIELD2" 	+ " AS " + ReportLionVO.BRAND_MEI	+ " ");	//ブランド名

        //*************************************************************************************************
        //FROM
        //*************************************************************************************************
        sql.append(" FROM ");
        sql.append(TBTHB1DOWN.TBNAME +  " , ");
        sql.append(TBTHB2KMEI.TBNAME +  " , ");
        sql.append(TBTHB11WLTVK.TBNAME + " mast3 ,");
        //*************************************************************************************************
        //ブランドマスタ
        //*************************************************************************************************
        sql.append(" ( SELECT");
        sql.append("  " + TBTHBAMST.FIELD1);
        sql.append(" ," + TBTHBAMST.FIELD2 );
        sql.append(" FROM " );
        sql.append(TBTHBAMST.TBNAME);
        sql.append(" WHERE ");
        sql.append(TBTHBAMST.EGCD 			+ " = '" + _cond.getEgCd()  		+ "' AND ");
        sql.append(TBTHBAMST.TKSKGYCD 		+ " = '" + _cond.getTksKgyCd()  	+ "' AND ");
        sql.append(TBTHBAMST.TKSBMNSEQNO 	+ " = '" + _cond.getTksBmnSeqNo() 		+ "' AND ");
        sql.append(TBTHBAMST.TKSTNTSEQNO 	+ " = '" + _cond.getTksTntSeqNo() 		+ "' AND ");
        sql.append(TBTHBAMST.SYBT 			+ " = '" + C_HBAMST_SYBT_BRAND		+ "'     ");	//ブランドマスタ
        sql.append(") mast5 "	+	"  ");

        //*************************************************************************************************
        //WHERE句
        //*************************************************************************************************
        sql.append(" WHERE ");
        sql.append(TBTHB1DOWN.EGCD 			+ " = '" + _cond.getEgCd() 			+ "' AND ");
        sql.append(TBTHB1DOWN.TKSKGYCD 		+ " = '" + _cond.getTksKgyCd() 		+ "' AND ");
        sql.append(TBTHB1DOWN.TKSBMNSEQNO 	+ " = '" + _cond.getTksBmnSeqNo() 		+ "' AND ");
        sql.append(TBTHB1DOWN.TKSTNTSEQNO 	+ " = '" + _cond.getTksTntSeqNo() 		+ "' AND ");
        sql.append(TBTHB1DOWN.YYMM 			+ " = '" + _cond.getYm() 			+ "' AND ");

        sql.append(TBTHB1DOWN.EGCD 			+ " = " + TBTHB2KMEI.EGCD  			+ "  AND ");
        sql.append(TBTHB1DOWN.TKSKGYCD 		+ " = " + TBTHB2KMEI.TKSKGYCD 		+ "  AND ");
        sql.append(TBTHB1DOWN.TKSBMNSEQNO 	+ " = " + TBTHB2KMEI.TKSBMNSEQNO 	+ "  AND ");
        sql.append(TBTHB1DOWN.TKSTNTSEQNO 	+ " = " + TBTHB2KMEI.TKSTNTSEQNO 	+ "  AND ");
        sql.append(TBTHB1DOWN.YYMM 			+ " = " + TBTHB2KMEI.YYMM 			+ "  AND ");

        sql.append(TBTHB1DOWN.JYUTNO 		+ " = " + TBTHB2KMEI.JYUTNO  		+ "  AND ");
        sql.append(TBTHB1DOWN.JYMEINO 		+ " = " + TBTHB2KMEI.JYMEINO 		+ "  AND ");
        sql.append(TBTHB1DOWN.URMEINO 		+ " = " + TBTHB2KMEI.URMEINO 		+ "  AND ");
        sql.append(TBTHB1DOWN.TJYUTNO 		+ " = " + "' '" 					+ "  AND ");
        sql.append(				  TBTHB2KMEI.CODE6 		 + " = " + " '005' "  							+ "  AND ");
        sql.append(" TRIM("+ TBTHB2KMEI.CODE1 	+")" + " = " + " '02' "								+ "  AND ");
        sql.append(" TRIM("+ TBTHB2KMEI.CODE2 	+")" + " = " + "mast3." +TBTHB11WLTVK.KYOKUCD			+ "  AND ");
        sql.append(" TRIM("+ TBTHB2KMEI.CODE3 	+")" + " = " + "mast5." +TBTHBAMST.FIELD1			+ "      ");

        //*************************************************************************************************
        //OREDER BY
        //*************************************************************************************************
        sql.append(" ORDER BY ");
        sql.append(""	+ TBTHB2KMEI.CODE3 			+ ", ");              //ブランドコード
//		sql.append("mast3."	+ TBTHB11WLTVK.KYOKUCD			+ ", ");      //局コード
//		sql.append("mast3."	+ TBTHB11WLTVK.KEIRETSU  			+ ", ");  //系列
        sql.append(" mast3." + TBTHB11WLTVK.TIKU           + ", ");       //地区
        sql.append(" mast3." + TBTHB11WLTVK.THYOJIJYUN          + ", ");  //地区表示順
        sql.append(""	+ TBTHB2KMEI.CODE2 			+ " ");

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
                vo.setYymm((String) result.get(TBTHB2KMEI.YYMM.toUpperCase()));                         //検索年月
                vo.setCode1((String) result.get(TBTHB2KMEI.CODE1.toUpperCase().trim()));                //媒体区分
                vo.setCode4((String) result.get(TBTHB2KMEI.CODE4.toUpperCase().trim()));                //代理店コード
                vo.setCode6((String) result.get(TBTHB2KMEI.CODE6.toUpperCase().trim()));                //カードNo

                vo.setName7((String) result.get(TBTHB2KMEI.NAME7.toUpperCase().trim()));                //期間
                vo.setSonota5((String) result.get(TBTHB2KMEI.SONOTA5.toUpperCase().trim()));            //回数
                vo.setSonota7((String) result.get(TBTHB2KMEI.SONOTA7.toUpperCase().trim()));            //CM1本の秒数
                vo.setSeiGak((BigDecimal) result.get(TBTHB2KMEI.SEIGAK.toUpperCase()));                 //請求額
                vo.setShohizeiRitu((BigDecimal) result.get(ReportLionVO.SHOHIZEI_RITU.toUpperCase()));  //消費税率
                vo.setShohizeiGak((BigDecimal) result.get(ReportLionVO.SHOHIZEI_GAK.toUpperCase()));    //消費税額
                vo.setByosuGokei((BigDecimal) result.get(ReportLionVO.BYOSU_GOKEI.toUpperCase()));      //CM秒数合計
                vo.setKyokuCd((String) result.get(ReportLionVO.KYOKU_CD.toUpperCase()));                //局コード
                vo.setKyokuMei((String) result.get(ReportLionVO.KYOKU_MEI.toUpperCase()));              //局名称
                vo.setBrandCd((String) result.get(ReportLionVO.BRAND_CD.toUpperCase()));                //ブランドコード
                vo.setBrandMei((String) result.get(ReportLionVO.BRAND_MEI.toUpperCase()));              //ブランド名称

                // 検索結果直後の状態にする
                ModelUtils.copyMemberSearchAfterInstace(vo);
                list.add(vo);
            }
        }

        return list;
    }

}

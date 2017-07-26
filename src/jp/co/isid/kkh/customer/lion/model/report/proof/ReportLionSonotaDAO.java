package jp.co.isid.kkh.customer.lion.model.report.proof;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jp.co.isid.kkh.integ.tbl.TBTHB1DOWN;
import jp.co.isid.kkh.integ.tbl.TBTHB2KMEI;
import jp.co.isid.kkh.integ.tbl.TBTHBAMST;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.customer.lion.model.report.ReportLionCondition;
import jp.co.isid.kkh.customer.lion.model.report.ReportLionProofDaoInterface;
import jp.co.isid.kkh.customer.lion.model.report.ReportLionVO;
import jp.co.isid.kkh.customer.lion.model.report.proof.LionProofConstants;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractRdbDao;
import jp.co.isid.nj.model.ModelUtils;

/**
 *
 * <P>
 * ライオン帳票(プルーフリスト、その他)検索DAO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/01/11)<BR>
 * ・消費税端数調整対応(2014/07/31 HLC S.Fujimoto)<BR>
 * </P>
 *
 * @author
 */

public class ReportLionSonotaDAO extends AbstractRdbDao implements  ReportLionProofDaoInterface{

    /** 汎用マスタ検索条件 */
    private ReportLionCondition _cond;

    private enum SqlMode{DATA,SYOHIZEI};
    private SqlMode _sqlMode = SqlMode.DATA;

    /** 汎用マスタ：媒体種別：テレビ局マスタ */
    public static final String C_HBAMST_SYBT_TV_KYOKU = LionProofConstants.MastBaitaiShubetsu.TV_KYOKU.getCode();
    //public static final String C_HBAMST_SYBT_TV_KYOKU = "401";

    /** 汎用マスタ：媒体種別：テレビ番組マスタ */
    public static final String C_HBAMST_SYBT_TV_BANGUMI =  LionProofConstants.MastBaitaiShubetsu.TV_BANGUMI.getCode();
    //public static final String C_HBAMST_SYBT_TV_BANGUMI = "601";

    /** getSelectSQLで発行するSQLのモード() */
//	private enum SqlMode {
//		KIND, ITEM,
//	};

    //private SqlMode _sqlMode = SqlMode.KIND;

    /**
     * デフォルトコンストラクタ。
     */
    public ReportLionSonotaDAO() {
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
        if(_sqlMode.equals(SqlMode.DATA))
        {
            return getSelectSQLForItem();
        }else if(_sqlMode.equals(SqlMode.SYOHIZEI))
        {
            return getSelectSQLForSyohizei();
        }

        return "";
    }

    private String getSelectSQLForItem() {

        // SQL.
        StringBuffer sql = new StringBuffer();

        sql.append(" SELECT ");
        /* 2014/07/31 消費税端数調整対応 HLC fujimoto ADD start */
        sql.append("/*+ ordered */");
        /* 2014/07/31 消費税端数調整対応 HLC fujimoto ADD end */
        sql.append("  " + TBTHB2KMEI.CODE6 + ", ");
        sql.append("  " + TBTHB2KMEI.YYMM + ", ");
        sql.append("  " + TBTHB2KMEI.CODE4 + ", ");
        sql.append("  " + TBTHB2KMEI.CODE1 + ", ");
        sql.append("  " + TBTHB2KMEI.CODE3 + " " + ReportLionVO.BRAND_CD + ", ");
        sql.append(" " + TBTHBAMST.FIELD2 + " " + ReportLionVO.BRAND_MEI + ", ");
        sql.append("  " + TBTHB2KMEI.SEIGAK + ", ");
        sql.append("  TRIM(" + TBTHB2KMEI.NAME10 + ") " + ReportLionVO.KEN_MEI + ", ");
        sql.append("  " + TBTHB2KMEI.NAME1 +  " ");
        sql.append(" ,(" + TBTHB2KMEI.RITU1 + "* 0.01) AS " + ReportLionVO.SHOHIZEI_RITU + " "); //消費税率
        sql.append(" FROM ");
        sql.append("  " + TBTHB2KMEI.TBNAME + ", ");
        sql.append("  " + TBTHB1DOWN.TBNAME + ", ");
        sql.append("  " + TBTHBAMST.TBNAME + " ");
        sql.append(" WHERE ");
        sql.append(" " + TBTHB2KMEI.EGCD + " = '" + _cond.getEgCd() + "' AND ");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND ");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND ");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND ");
        sql.append(" " + TBTHB2KMEI.YYMM + " = '" + _cond.getYm() + "' AND ");
        sql.append(" " + TBTHB2KMEI.CODE6 + " IN ('010') AND ");
        sql.append(" TRIM(" + TBTHB2KMEI.CODE3 + ") = " + TBTHBAMST.FIELD1 + " AND ");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = " + TBTHBAMST.TKSKGYCD + " AND ");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = " + TBTHBAMST.TKSBMNSEQNO + " AND ");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = " + TBTHBAMST.TKSTNTSEQNO + " AND ");
        sql.append(" " + TBTHB2KMEI.EGCD + " = " + TBTHB1DOWN.EGCD + " AND ");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = " + TBTHB1DOWN.TKSKGYCD + " AND ");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = " + TBTHB1DOWN.TKSBMNSEQNO + " AND ");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = " + TBTHB1DOWN.TKSTNTSEQNO + " AND ");
        sql.append(" " + TBTHB2KMEI.YYMM + " = " + TBTHB1DOWN.YYMM + " AND ");
        sql.append(" " + TBTHB2KMEI.JYUTNO + " = " + TBTHB1DOWN.JYUTNO + " AND ");
        sql.append(" " + TBTHB2KMEI.JYMEINO + " = " + TBTHB1DOWN.JYMEINO + " AND ");
        sql.append(" " + TBTHB2KMEI.URMEINO + " = " + TBTHB1DOWN.URMEINO + " AND ");
        sql.append(" " + TBTHB1DOWN.TJYUTNO + " = ' '  ");
        sql.append(" ORDER BY ");
        sql.append("  " + TBTHB2KMEI.CODE3 + ", ");
        sql.append("  " + TBTHB2KMEI.JYUTNO + ", ");
        sql.append("  " + TBTHB2KMEI.JYMEINO + ", ");
        sql.append("  " + TBTHB2KMEI.URMEINO + " ");

        return sql.toString();
    }

    private String getSelectSQLForSyohizei() {

        // SQL.
        StringBuffer sql = new StringBuffer();
        sql.append(" SELECT ");
        sql.append("  " + TBTHB2KMEI.CODE6 + ", ");
//		sql.append(" sum(" + TBTHB2KMEI.SEIGAK + " * " +TBTHB2KMEI.RITU1 + " / 100) " + ReportLionVO.SHOHIZEI_GAK  + " ");
//		sql.append(" sum(" + TBTHB2KMEI.NAME1 + ") " + ReportLionVO.SHOHIZEI_GAK  + " ");
        sql.append(" sum(" + TBTHB2KMEI.SEIGAK + ") " + ReportLionVO.SHOHIZEI_GAK  + " ");
        //消費税対応 2014/1/28 update HLC sonobe start
        sql.append(",    (" + TBTHB2KMEI.RITU1 + "*0.01) SHOHIZEI_RITU ");
        //消費税対応 2014/1/28 update HLC sonobe end
        sql.append(" FROM ");
        sql.append("  " + TBTHB2KMEI.TBNAME + ", ");
        sql.append("  " + TBTHB1DOWN.TBNAME + " ");
        sql.append(" WHERE ");
        sql.append(" " + TBTHB2KMEI.EGCD + " = '" + _cond.getEgCd() + "' AND ");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND ");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND ");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND ");
        sql.append(" " + TBTHB2KMEI.YYMM + " = '" + _cond.getYm() + "' AND ");
        sql.append(" " + TBTHB2KMEI.CODE6 + " IN ('001','002','003','004','005','007','008','009','010','014','015','016','017','018','019') AND ");
        sql.append(" " + TBTHB2KMEI.EGCD + " = " + TBTHB1DOWN.EGCD + " AND ");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = " + TBTHB1DOWN.TKSKGYCD + " AND ");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = " + TBTHB1DOWN.TKSBMNSEQNO + " AND ");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = " + TBTHB1DOWN.TKSTNTSEQNO + " AND ");
        sql.append(" " + TBTHB2KMEI.YYMM + " = " + TBTHB1DOWN.YYMM + " AND ");
        sql.append(" " + TBTHB2KMEI.JYUTNO + " = " + TBTHB1DOWN.JYUTNO + " AND ");
        sql.append(" " + TBTHB2KMEI.JYMEINO + " = " + TBTHB1DOWN.JYMEINO + " AND ");
        sql.append(" " + TBTHB2KMEI.URMEINO + " = " + TBTHB1DOWN.URMEINO + " AND ");
        sql.append(" " + TBTHB1DOWN.TJYUTNO + " = ' '  ");
        sql.append(" GROUP BY ");
        sql.append("  " + TBTHB2KMEI.CODE6 + ", ");
        //消費税対応 2014/1/28 update HLC sonobe start
        //sql.append("  " + TBTHB2KMEI.CODE1 + " ");
        sql.append("    " + TBTHB2KMEI.CODE1 + ", ");
        sql.append("    (" + TBTHB2KMEI.RITU1 + "*0.01)");
        //消費税対応 2014/1/28 update HLC sonobe end
        sql.append(" ORDER BY ");
        sql.append("  " + TBTHB2KMEI.CODE6 + " ");

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
            _sqlMode = SqlMode.DATA;
            return super.find();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0002");
        }
    }

    @SuppressWarnings("unchecked")
    public List<ReportLionVO> findReportLionSyohiZeiByCondition(ReportLionCondition cond)
            throws KKHException {

        super.setModel(new ReportLionVO());

        try {
            _cond = cond;
            _sqlMode = SqlMode.SYOHIZEI;
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

        if(_sqlMode.equals(SqlMode.DATA))
        {
            if (getModel() instanceof ReportLionVO) {
                for (int i = 0; i < hashList.size(); i++) {
                    Map result = (Map) hashList.get(i);
                    ReportLionVO vo = new ReportLionVO();
                    vo.setCode6((String) result.get(TBTHB2KMEI.CODE6.toUpperCase().trim()));	//カードNO
                    vo.setYymm((String) result.get(TBTHB2KMEI.YYMM.toUpperCase()));				//検索年月
                    vo.setCode4((String) result.get(TBTHB2KMEI.CODE4.toUpperCase().trim()));	//代理店コード
                    vo.setCode1((String) result.get(TBTHB2KMEI.CODE1.toUpperCase().trim()));	//媒体区分
                    vo.setBrandCd((String) result.get(ReportLionVO.BRAND_CD.toUpperCase().trim()));    //ブランドコード
                    vo.setBrandMei((String) result.get(ReportLionVO.BRAND_MEI.toUpperCase().trim())); //ブランド名
                    vo.setSeiGak((BigDecimal) result.get(TBTHB2KMEI.SEIGAK.toUpperCase()));					//請求額
                    vo.setKenMei((String) result.get(ReportLionVO.KEN_MEI.toUpperCase()));							//件名
                    vo.setShohizeiRitu((BigDecimal) result.get(ReportLionVO.SHOHIZEI_RITU.toUpperCase()));  //消費税率
                    vo.setName1((String) result.get(TBTHB2KMEI.NAME1.toUpperCase()));	//消費税額

                    // 検索結果直後の状態にする
                    ModelUtils.copyMemberSearchAfterInstace(vo);
                    list.add(vo);
                }
            }
            return list;
        }else if(_sqlMode.equals(SqlMode.SYOHIZEI)){
            if (getModel() instanceof ReportLionVO) {
                for (int i = 0; i < hashList.size(); i++) {
                    Map result = (Map) hashList.get(i);
                    ReportLionVO vo = new ReportLionVO();
                    vo.setCode6((String) result.get(TBTHB2KMEI.CODE6.toUpperCase().trim()));	//カードNO
                    vo.setShohizeiGak((BigDecimal) result.get(ReportLionVO.SHOHIZEI_GAK.toUpperCase()));	//消費税額
                    //2014/01/28 hlc sonobe add 消費税対応　Start
                    vo.setShohizeiRitu((BigDecimal) result.get(ReportLionVO.SHOHIZEI_RITU.toUpperCase())); //消費税率
                    //2014/01/28 hlc sonobe add 消費税対応　End

                    // 検索結果直後の状態にする
                    ModelUtils.copyMemberSearchAfterInstace(vo);
                    list.add(vo);
                }
            }

            return list;
        }

        return list;
    }

}

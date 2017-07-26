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
 * ライオンプルーフリスト帳票(制作)検索DAO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/01/11)<BR>
 * </P>
 *
 * @author
 */

public class ReportLionSeisakDAO extends AbstractRdbDao implements  ReportLionProofDaoInterface{

    /** 汎用マスタ検索条件 */
    private ReportLionCondition _cond;

    private enum SqlMode{DATA,BAITAI};
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
    public ReportLionSeisakDAO() {
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
        }else if(_sqlMode.equals(SqlMode.BAITAI))
        {
            return getSelectSQLForBaitai();
        }

        return "";
    }

    private String getSelectSQLForItem() {

        // SQL.
        StringBuffer sql = new StringBuffer();

        sql.append(" SELECT ");
        sql.append("  " + TBTHB2KMEI.CODE6 + ", ");
        sql.append("  " + TBTHB2KMEI.YYMM + ", ");
        sql.append("  " + TBTHB2KMEI.CODE4 + ", ");
        sql.append("  mast1." + TBTHBAMST.FIELD1 + " " + ReportLionVO.JANLE_CD + ", ");
        sql.append("  mast1." + TBTHBAMST.FIELD2 + " " + ReportLionVO.JANLE_NAME + ", ");
        sql.append("  " + TBTHB2KMEI.CODE1 + ", ");
        sql.append("  " + TBTHB2KMEI.CODE3 + " " + ReportLionVO.BRAND_CD + ", ");
        sql.append("  mast2." + TBTHBAMST.FIELD2 + " " + ReportLionVO.BRAND_MEI + ", ");
        sql.append(" (" + TBTHB2KMEI.RITU1 + "* 0.01) AS SHOHIZEI_RITU ,"); //消費税率
        sql.append("  " + TBTHB2KMEI.SEIGAK + ", ");
        sql.append("  " + TBTHB2KMEI.NAME1   + ", ");
        sql.append("  mast3." + TBTHBAMST.FIELD2 + " " + ReportLionVO.BAITAI_NAME+ " ");
    //2013/07/01　HLCsonobe 件名追加 Start
        sql.append(",  " + TBTHB2KMEI.NAME10   + " ");
    //2013/07/01　HLCsonobe 件名追加 End
        sql.append(" FROM ");
        sql.append("  " + TBTHB2KMEI.TBNAME + ", ");
        sql.append("  " + TBTHB1DOWN.TBNAME + ", ");
        sql.append("  " + TBTHBAMST.TBNAME + " mast1, ");
        sql.append("  " + TBTHBAMST.TBNAME + " mast2, ");
        sql.append("  " + TBTHBAMST.TBNAME + " mast3 ");
        sql.append(" WHERE ");
        sql.append(" " + TBTHB2KMEI.EGCD + " = '" + _cond.getEgCd() + "' AND ");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND ");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND ");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND ");
        sql.append(" " + TBTHB2KMEI.YYMM + " = '" + _cond.getYm() + "' AND ");
        sql.append(" " + TBTHB2KMEI.CODE6 + " IN ('012') AND ");
        sql.append(" mast2." + TBTHBAMST.SYBT + " = '201' AND ");
        sql.append(" TRIM(" + TBTHB2KMEI.CODE3 + ") = mast2." + TBTHBAMST.FIELD1 + " AND ");
        sql.append(" mast1." + TBTHBAMST.SYBT + " = '103' AND ");
        sql.append(" mast2." + TBTHBAMST.FIELD4 + " =  mast1." + TBTHBAMST.FIELD1 +" AND ");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = mast2." + TBTHBAMST.TKSKGYCD + " AND ");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = mast2." + TBTHBAMST.TKSBMNSEQNO + " AND ");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = mast2." + TBTHBAMST.TKSTNTSEQNO + " AND ");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = mast1." + TBTHBAMST.TKSKGYCD + " AND ");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = mast1." + TBTHBAMST.TKSBMNSEQNO + " AND ");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = mast1." + TBTHBAMST.TKSTNTSEQNO + " AND ");
        sql.append(" " + TBTHB2KMEI.EGCD + " = " + TBTHB1DOWN.EGCD + " AND ");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = " + TBTHB1DOWN.TKSKGYCD + " AND ");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = " + TBTHB1DOWN.TKSBMNSEQNO + " AND ");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = " + TBTHB1DOWN.TKSTNTSEQNO + " AND ");
        sql.append(" " + TBTHB2KMEI.YYMM + " = " + TBTHB1DOWN.YYMM + " AND ");
        sql.append(" " + TBTHB2KMEI.JYUTNO + " = " + TBTHB1DOWN.JYUTNO + " AND ");
        sql.append(" " + TBTHB2KMEI.JYMEINO + " = " + TBTHB1DOWN.JYMEINO + " AND ");
        sql.append(" " + TBTHB2KMEI.URMEINO + " = " + TBTHB1DOWN.URMEINO + " AND ");
        sql.append(" " + TBTHB1DOWN.TJYUTNO + " = ' '  AND ");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = mast3." + TBTHBAMST.TKSKGYCD + " AND ");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = mast3." + TBTHBAMST.TKSBMNSEQNO + " AND ");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = mast3." + TBTHBAMST.TKSTNTSEQNO + " AND ");
        sql.append(" mast3." + TBTHBAMST.SYBT + " = '104' AND ");
        sql.append(" TRIM(" + TBTHB2KMEI.CODE1 + ") = mast3." + TBTHBAMST.FIELD1 + " ");
        sql.append(" ORDER BY ");
        sql.append(" " + ReportLionVO.JANLE_CD + ", ");
        sql.append(" " + ReportLionVO.BRAND_CD + ", ");
        sql.append("  " + TBTHB2KMEI.CODE1 + ", ");
        sql.append("  " + TBTHB2KMEI.JYUTNO + ", ");
        sql.append("  " + TBTHB2KMEI.JYMEINO + ", ");
        sql.append("  " + TBTHB2KMEI.URMEINO + " ");

        return sql.toString();
    }


    private String getSelectSQLForBaitai() {

        // SQL.
        StringBuffer sql = new StringBuffer();

        sql.append(" SELECT ");
        sql.append("  " + TBTHBAMST.FIELD1 + " " + ReportLionVO.BAITAI_CD + ", ");
        sql.append("  " + TBTHBAMST.FIELD2 + " " + ReportLionVO.BAITAI_NAME  + " ");
        sql.append(" FROM ");
        sql.append("  " + TBTHBAMST.TBNAME + " ");
        sql.append(" WHERE ");
        sql.append("  " + TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND ");
        sql.append("  " + TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND ");
        sql.append("  " + TBTHBAMST.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND ");
        sql.append("  " + TBTHBAMST.SYBT+ " = '104' ");
        sql.append(" ORDER BY ");
        sql.append("  " + TBTHBAMST.FIELD1 + " ");

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
    public List<ReportLionVO> findReportLionBaitaiCdName(ReportLionCondition cond)
            throws KKHException {

        super.setModel(new ReportLionVO());

        try {
            _cond = cond;
            _sqlMode = SqlMode.BAITAI;
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
                    vo.setJanleCd((String) result.get(ReportLionVO.JANLE_CD.toUpperCase().trim()));	//ジャンルコード
                    vo.setJanleName((String) result.get(ReportLionVO.JANLE_NAME.toUpperCase().trim()));	//ジャンル名
                    vo.setCode1((String) result.get(TBTHB2KMEI.CODE1.toUpperCase().trim()));	//媒体区分
                    vo.setBrandCd((String) result.get(ReportLionVO.BRAND_CD.toUpperCase().trim()));    //ブランドコード
                    vo.setBrandMei((String) result.get(ReportLionVO.BRAND_MEI.toUpperCase().trim())); //ブランド名
                    vo.setSeiGak((BigDecimal) result.get(TBTHB2KMEI.SEIGAK.toUpperCase()));					//請求額
                    vo.setShohizeiRitu((BigDecimal) result.get(ReportLionVO.SHOHIZEI_RITU.toUpperCase()));  //消費税率
                    vo.setName1((String) result.get(TBTHB2KMEI.NAME1.toUpperCase().trim()));		//消費税
                    vo.setBaitaiName((String) result.get(ReportLionVO.BAITAI_NAME.toUpperCase().trim()));	//媒体名
                //2013/07/01　HLCsonobe 件名追加 Start
                    vo.setKenMei((String) result.get(TBTHB2KMEI.NAME10.toUpperCase().trim()));	//件名
                //2013/07/01　HLCsonobe 件名追加 End
                    // 検索結果直後の状態にする
                    ModelUtils.copyMemberSearchAfterInstace(vo);
                    list.add(vo);
                }
            }
        }else if(_sqlMode.equals(SqlMode.BAITAI))
        {
            if (getModel() instanceof ReportLionVO) {
                for (int i = 0; i < hashList.size(); i++) {
                    Map result = (Map) hashList.get(i);
                    ReportLionVO vo = new ReportLionVO();
                    vo.setBaitaiCd((String) result.get(ReportLionVO.BAITAI_CD.toUpperCase().trim()));	//媒体コード
                    vo.setBaitaiName((String) result.get(ReportLionVO.BAITAI_NAME.toUpperCase().trim()));	//媒体名

                    // 検索結果直後の状態にする
                    ModelUtils.copyMemberSearchAfterInstace(vo);
                    list.add(vo);
                }
            }
        }

        return list;
    }

}

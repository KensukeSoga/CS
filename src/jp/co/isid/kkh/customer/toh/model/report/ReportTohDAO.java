package jp.co.isid.kkh.customer.toh.model.report;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jp.co.isid.kkh.integ.tbl.TBTHB1DOWN;
import jp.co.isid.kkh.integ.tbl.TBTHB2KMEI;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractRdbDao;
import jp.co.isid.nj.model.ModelUtils;

/**
 *
 * <P>
 * 帳票（TOH)検索DAO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2011/11/07 JSE KT)<BR>
 * </P>
 * @author
 */
public class ReportTohDAO extends AbstractRdbDao {

    /**汎用マスタ検索条件 */
    private ReportTohCondition _cond;

    /** getSelectSQLで発行するSQLのモード() */
//    private enum SqlMode{KIND,ITEM,};
//    private SqlMode _sqlMode = SqlMode.KIND;

    /**
     * デフォルトコンストラクタ。
     */
    public ReportTohDAO() {
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
        return new String[]{
                TBTHB2KMEI.EGCD,
                TBTHB2KMEI.TKSKGYCD,
                TBTHB2KMEI.TKSBMNSEQNO,
                TBTHB2KMEI.TKSTNTSEQNO,
                TBTHB2KMEI.YYMM,
                TBTHB2KMEI.JYUTNO,
                TBTHB2KMEI.JYMEINO,
                TBTHB2KMEI.URMEINO,
                TBTHB2KMEI.RENBN
        };
    }

    /**
     * 更新日付フィールドを返します。
     *
     * @return String 更新日付フィールド
     */
    public String getTimeStampKeyName() {
        //new String[] {};
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
        return new String[]{
                TBTHB2KMEI.TIMSTMP,
                TBTHB2KMEI.UPDAPL,
                TBTHB2KMEI.UPDTNT,
                TBTHB2KMEI.EGCD,
                TBTHB2KMEI.TKSKGYCD,
                TBTHB2KMEI.TKSBMNSEQNO,
                TBTHB2KMEI.TKSTNTSEQNO,
                TBTHB2KMEI.YYMM,
                TBTHB2KMEI.JYUTNO,
                TBTHB2KMEI.JYMEINO,
                TBTHB2KMEI.URMEINO,
                TBTHB2KMEI.HIMKCD,
                TBTHB2KMEI.RENBN,
                TBTHB2KMEI.DATEFROM,
                TBTHB2KMEI.DATETO,
                TBTHB2KMEI.SEIGAK,
                TBTHB2KMEI.HNNERT,
                TBTHB2KMEI.HNMAEGAK,
                TBTHB2KMEI.NEBIGAK,
                TBTHB2KMEI.DATE1,
                TBTHB2KMEI.DATE2,
                TBTHB2KMEI.DATE3,
                TBTHB2KMEI.DATE4,
                TBTHB2KMEI.DATE5,
                TBTHB2KMEI.DATE6,
                TBTHB2KMEI.KBN1,
                TBTHB2KMEI.KBN2,
                TBTHB2KMEI.KBN3,
                TBTHB2KMEI.CODE1,
                TBTHB2KMEI.CODE2,
                TBTHB2KMEI.CODE3,
                TBTHB2KMEI.CODE4,
                TBTHB2KMEI.CODE5,
                TBTHB2KMEI.CODE6,
                TBTHB2KMEI.NAME1,
                TBTHB2KMEI.NAME2,
                TBTHB2KMEI.NAME3,
                TBTHB2KMEI.NAME4,
                TBTHB2KMEI.NAME5,
                TBTHB2KMEI.NAME6,
                TBTHB2KMEI.NAME7,
                TBTHB2KMEI.NAME8,
                TBTHB2KMEI.NAME9,
                TBTHB2KMEI.NAME10,
                TBTHB2KMEI.KNGK1,
                TBTHB2KMEI.KNGK2,
                TBTHB2KMEI.KNGK3,
                TBTHB2KMEI.RITU1,
                TBTHB2KMEI.RITU2,
                TBTHB2KMEI.SONOTA1,
                TBTHB2KMEI.SONOTA2,
                TBTHB2KMEI.SONOTA3,
                TBTHB2KMEI.SONOTA4,
                TBTHB2KMEI.SONOTA5,
                TBTHB2KMEI.SONOTA6,
                TBTHB2KMEI.SONOTA7,
                TBTHB2KMEI.SONOTA8,
                TBTHB2KMEI.SONOTA9,
                TBTHB2KMEI.SONOTA10,
                TBTHB2KMEI.BUNFLG,
                TBTHB2KMEI.MEIHNFLG,
                TBTHB2KMEI.NEBHNFLG
        };
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

    private String getSelectSQLForItem(){

        StringBuffer sql = new StringBuffer();

        sql.append(" SELECT ");
        sql.append("  " + TBTHB2KMEI.JYUTNO + " ");
        sql.append(" ," + TBTHB2KMEI.JYMEINO + " ");
        sql.append(" ," + TBTHB2KMEI.URMEINO + " ");
        sql.append(" ," + TBTHB2KMEI.DATE1 + " ");
        sql.append(" ," + TBTHB2KMEI.CODE1 + " ");
        sql.append(" ," + TBTHB2KMEI.NAME8 + " ");
        sql.append(" ," + TBTHB2KMEI.NAME2 + " ");
        sql.append(" ," + TBTHB2KMEI.SEIGAK + " ");
        // 消費税対応 2013/10/09 add HLC H.Watabe start
        sql.append(" ,(" + TBTHB2KMEI.RITU1 + " * 0.01) AS "+ TBTHB2KMEI.RITU1 + " ");
        // 消費税対応 2013/10/09 add HLC H.Watabe end
        sql.append(" ," + TBTHB2KMEI.KBN1 + " ");
        sql.append(" ," + TBTHB2KMEI.KBN2 + " ");
        sql.append(" ," + TBTHB2KMEI.KNGK1 + " ");
        sql.append(" FROM ");
        sql.append("  " + TBTHB2KMEI.TBNAME + " ");
        sql.append(" ," + TBTHB1DOWN.TBNAME + " ");
        sql.append(" WHERE ");
        sql.append(TBTHB2KMEI.EGCD + " = '" + _cond.getEgCd()  + "'  AND ");
        sql.append(TBTHB2KMEI.TKSKGYCD + " = '" + _cond.getTksKgyCd()  + "'  AND "); //得意先
        sql.append(TBTHB2KMEI.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo()  + "'  AND "); ///部門
        sql.append(TBTHB2KMEI.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo()  + "'  AND ");//担当
        sql.append(TBTHB2KMEI.YYMM + " = '" + _cond.getYm()  + "'  AND "); //HB2_YYMM
        sql.append(TBTHB2KMEI.JYUTNO + " = " +  TBTHB1DOWN.JYUTNO  + " AND "); //HB2_JYUTNO = HB1_JYUTNO  AND
        sql.append(TBTHB2KMEI.JYMEINO + " = " +  TBTHB1DOWN.JYMEINO  + " AND ");//HB2_JYMEINO = HB1_JYMEINO  AND
        sql.append(TBTHB2KMEI.URMEINO + " = " +  TBTHB1DOWN.URMEINO  + " AND ");//HB2_URMEINO = HB1_URMEINO  AND
        sql.append(TBTHB2KMEI.EGCD + " = " +  TBTHB1DOWN.EGCD  + " AND ");//HB2_EGCD = HB1_EGCD  AND
        sql.append(TBTHB2KMEI.TKSKGYCD + " = " +  TBTHB1DOWN.TKSKGYCD  + " AND ");//HB2_TKSKGYCD = HB1_TKSKGYCD  AND
        sql.append(TBTHB2KMEI.TKSBMNSEQNO + " = " +  TBTHB1DOWN.TKSBMNSEQNO  + " AND ");//HB2_TKSBMNSEQNO = HB1_TKSBMNSEQNO  AND
        sql.append(TBTHB2KMEI.TKSTNTSEQNO + " = " +  TBTHB1DOWN.TKSTNTSEQNO  + " AND ");//HB2_TKSTNTSEQNO = HB1_TKSTNTSEQNO  AND
        sql.append(TBTHB2KMEI.YYMM + " = " +  TBTHB1DOWN.YYMM  + " AND ");//HB2_YYMM = HB1_YYMM  AND
        sql.append(TBTHB1DOWN.TJYUTNO +  " = ' '   ");//HB1_TJYUTNO = ' '
        //納品区分が"1""2"の場合は条件とする。
        if (_cond.getKbn().equals("1") || _cond.getKbn().equals("2")){
            sql.append(" AND " + TBTHB2KMEI.KBN2 +  " = '" + _cond.getKbn()  + "' ");// AND  HB2_KBN2 = '
        }
        //納品区分が３は全てが対象とする。
        //if (_cond.getKbn().equals("3")){}
//        else{
//            sql.append(" AND " + TBTHB2KMEI.KBN2 +  " = '" + _cond.getKbn()  + "' ");// AND  HB2_KBN2 = '
//        }
        sql.append("  ORDER BY ");
        //件名順か媒体順か 1：件名　２：媒体
        if (_cond.getKenbaikbn().equals("1")){
            sql.append(TBTHB2KMEI.NAME8 + ", ");//HB2_NAME8,
            sql.append(TBTHB2KMEI.CODE2 + ", ");//HB2_CODE2,
        }
        else{
            sql.append(TBTHB2KMEI.CODE2 + ", ");//HB2_CODE2,
            sql.append(TBTHB2KMEI.NAME8 + ", ");//HB2_NAME8,
        }

        sql.append(" " + TBTHB2KMEI.DATE1 + " ");//HB2_DATE1

        return sql.toString();
    }

    /**
     * 帳票データ（TOH)の検索を行います。
     *
     * @return 汎用テーブルマスタVOリスト
     * @throws UserException データアクセス中にエラーが発生した場合。
     */
    @SuppressWarnings("unchecked")
    public List<ReportTohVO> findReportTohByCondition(ReportTohCondition cond) throws KKHException {

        super.setModel(new ReportTohVO());

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
     * @param hashList List 検索結果
     * @return List<CommonCodeMasterVO> 変換後の検索結果
     */
    @Override
    protected List<ReportTohVO> createFindedModelInstances(List hashList) {
        List<ReportTohVO> list = new ArrayList<ReportTohVO>();
        if (getModel() instanceof ReportTohVO) {
            for (int i = 0; i < hashList.size(); i++) {
                Map result = (Map) hashList.get(i);
                ReportTohVO vo = new ReportTohVO();
                vo.setCode1((String)result.get(TBTHB2KMEI.CODE1.toUpperCase()));
                vo.setDate1((String)result.get(TBTHB2KMEI.DATE1.toUpperCase()));
                vo.setJyMeiNo((String)result.get(TBTHB2KMEI.JYMEINO.toUpperCase()));
                vo.setJyutNo((String)result.get(TBTHB2KMEI.JYUTNO.toUpperCase()));
                vo.setKbn1((String)result.get(TBTHB2KMEI.KBN1.toUpperCase()));
                vo.setKbn2((String)result.get(TBTHB2KMEI.KBN2.toUpperCase()));
                vo.setKngk1((BigDecimal)result.get(TBTHB2KMEI.KNGK1.toUpperCase()));
                vo.setName2((String)result.get(TBTHB2KMEI.NAME2.toUpperCase()));
                vo.setName8((String)result.get(TBTHB2KMEI.NAME8.toUpperCase()));
                vo.setSeiGak((BigDecimal)result.get(TBTHB2KMEI.SEIGAK.toUpperCase()));
                // 消費税対応 2013/10/09 add HLC H.Watabe start
                vo.setRitu1((BigDecimal)result.get(TBTHB2KMEI.RITU1.toUpperCase()));
                // 消費税対応 2013/10/09 add HLC H.Watabe end
                vo.setUrMeiNo((String)result.get(TBTHB2KMEI.URMEINO.toUpperCase()));

                // 検索結果直後の状態にする
                ModelUtils.copyMemberSearchAfterInstace(vo);
                list.add(vo);
            }
        }

        return list;
    }

}

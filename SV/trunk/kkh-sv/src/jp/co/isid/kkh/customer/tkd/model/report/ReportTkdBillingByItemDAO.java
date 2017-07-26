package jp.co.isid.kkh.customer.tkd.model.report;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jp.co.isid.kkh.integ.tbl.TBTHB1DOWN;
import jp.co.isid.kkh.integ.tbl.TBTHB2KMEI;
import jp.co.isid.kkh.integ.tbl.TBTHBAMST;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractRdbDao;
import jp.co.isid.nj.model.ModelUtils;

/**
 * <P>
 * 武田請求明細（品目別）取得DAO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/01/23 JSE Hitoshi Sasaki)<BR>
 * </P>
 *
 * @author JSE Hitoshi Sasaki
 */
public class ReportTkdBillingByItemDAO extends AbstractRdbDao {

    /** 汎用マスタ検索条件 */
    private ReportTkdBillingByItemCondition _cond;

    /** サイト１２０ or サイト３０ */
    private static final String SITE_TYPE_120_OR_30 = "0";

    /** サイトその他 */
    private static final String SITE_TYPE_OTHER = "1";

    /**
     * デフォルトコンストラクタ。
     */
    public ReportTkdBillingByItemDAO() {
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
        return null;
    }

    /**
     * テーブル名を返します。
     *
     * @return String テーブル名
     */
    @Override
    public String getTableName() {
        return null;
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

        StringBuffer sql = new StringBuffer();

        if (_cond.getKbn().equals(SITE_TYPE_120_OR_30)) {
            sql.append("SELECT ");
            sql.append("    1 AS SQLNO, ");
            sql.append("    " + TBTHB2KMEI.CODE4 + " AS SITE, ");
            sql.append("    " + TBTHB2KMEI.CODE1 + ", ");
            sql.append("    " + TBTHB2KMEI.DATE1 + ", ");
            sql.append("    " + TBTHB2KMEI.CODE5 + ", ");
            sql.append("    MST01." + TBTHBAMST.INTVALUE1 + " AS CYBNO, ");
            sql.append("    " + TBTHB2KMEI.NAME4 + ", ");
            sql.append("    " + TBTHB2KMEI.NAME2 + ", ");
            sql.append("    " + TBTHB2KMEI.CODE3 + ", ");
            sql.append("    MST02." + TBTHBAMST.INTVALUE1 + " AS HNMKCD, ");
            sql.append("    " + TBTHB2KMEI.KBN2 + " AS KNRKBN, ");
            sql.append("    sum(" + TBTHB2KMEI.SEIGAK + ") AS " + TBTHB2KMEI.SEIGAK + ", ");
            sql.append("    Null AS FEECD ");
            sql.append("FROM ");
            sql.append("    " + TBTHB1DOWN.TBNAME + ", ");
            sql.append("    " + TBTHB2KMEI.TBNAME + ", ");
            sql.append("    (SELECT ");
            sql.append("        " + TBTHBAMST.FIELD1 + ", ");
            sql.append("        " + TBTHBAMST.FIELD2 + ", ");
            sql.append("        " + TBTHBAMST.INTVALUE1 + " ");
            sql.append("    FROM ");
            sql.append("        " + TBTHBAMST.TBNAME + " ");
            sql.append("    WHERE ");
            sql.append("        " + TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND ");
            sql.append("        " + TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND ");
            sql.append("        " + TBTHBAMST.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND ");
            sql.append("        " + TBTHBAMST.SYBT + " = '107' ");
            sql.append("    ORDER BY ");
            sql.append("        " + TBTHBAMST.INTVALUE1 + " ");
            sql.append("    ) MST01, ");
            sql.append("    (SELECT ");
            sql.append("        " + TBTHBAMST.FIELD1 + ", ");
            sql.append("        " + TBTHBAMST.FIELD2 + ", ");
            sql.append("        " + TBTHBAMST.INTVALUE1 + " ");
            sql.append("    FROM ");
            sql.append("        " + TBTHBAMST.TBNAME + " ");
            sql.append("    WHERE ");
            sql.append("        " + TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND ");
            sql.append("        " + TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND ");
            sql.append("        " + TBTHBAMST.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND ");
            sql.append("        " + TBTHBAMST.SYBT + " = '104' ");
            sql.append("    ORDER BY ");
            sql.append("        " + TBTHBAMST.INTVALUE1 + " ");
            sql.append("    ) MST02 ");
            sql.append("WHERE ");
            sql.append("    " + TBTHB1DOWN.YYMM + " = '" + _cond.getYm() + "' AND ");
            sql.append("    " + TBTHB1DOWN.EGCD + " = '" + _cond.getEgCd() + "' AND ");
            sql.append("    " + TBTHB1DOWN.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND ");
            sql.append("    " + TBTHB1DOWN.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND ");
            sql.append("    " + TBTHB1DOWN.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND ");
            sql.append("    " + TBTHB1DOWN.TJYUTNO + " = ' ' AND ");
            sql.append("    " + TBTHB2KMEI.JYUTNO + " = " + TBTHB1DOWN.JYUTNO + " AND ");
            sql.append("    " + TBTHB2KMEI.JYMEINO + " = " + TBTHB1DOWN.JYMEINO + " AND ");
            sql.append("    " + TBTHB2KMEI.URMEINO + " = " + TBTHB1DOWN.URMEINO + " AND ");
            sql.append("    " + TBTHB2KMEI.EGCD + " = " + TBTHB1DOWN.EGCD + " AND ");
            sql.append("    " + TBTHB2KMEI.TKSKGYCD + " = " + TBTHB1DOWN.TKSKGYCD + " AND ");
            sql.append("    " + TBTHB2KMEI.TKSBMNSEQNO + " = " + TBTHB1DOWN.TKSBMNSEQNO + " AND ");
            sql.append("    " + TBTHB2KMEI.TKSTNTSEQNO + " = " + TBTHB1DOWN.TKSTNTSEQNO + " AND ");
            sql.append("    " + TBTHB2KMEI.YYMM + " = " + TBTHB1DOWN.YYMM + " AND ");
            sql.append("    " + TBTHB2KMEI.KBN1 + " <> '1' AND ");
            sql.append("    TRIM(" + TBTHB2KMEI.CODE5 + ") = TRIM(MST01." + TBTHBAMST.FIELD1 + "(+)) AND ");
            sql.append("    TRIM(" + TBTHB2KMEI.CODE3 + ") = TRIM(MST02." + TBTHBAMST.FIELD1 + "(+)) AND ");
            sql.append("    " + TBTHB2KMEI.CODE2 + " NOT IN ('FEE01', 'FEE02','FEE16','FEE18') AND ");
            sql.append("    " + TBTHB2KMEI.CODE4 + " IN ('120', '30' ) ");
            sql.append("GROUP BY ");
            sql.append("    " + TBTHB2KMEI.CODE4 + ", ");
            sql.append("    " + TBTHB2KMEI.CODE1 + ", ");
            sql.append("    " + TBTHB2KMEI.DATE1 + ", ");
            sql.append("    " + TBTHB2KMEI.CODE5 + ", ");
            sql.append("    " + TBTHB2KMEI.NAME4 + ", ");
            sql.append("    " + TBTHB2KMEI.NAME2 + ", ");
            sql.append("    " + TBTHB2KMEI.CODE3 + ", ");
            sql.append("    " + TBTHB2KMEI.KBN2 + ", ");
            sql.append("    MST01." + TBTHBAMST.INTVALUE1 + ", ");
            sql.append("    MST02." + TBTHBAMST.INTVALUE1 + " ");
            sql.append("UNION  ");
            sql.append("SELECT ");
            sql.append("    2 AS SQLNO, ");
            sql.append("    " + TBTHB2KMEI.CODE4 + " AS SITE, ");
            sql.append("    " + TBTHB2KMEI.CODE1 + ", ");
            sql.append("    " + TBTHB2KMEI.DATE1 + ", ");
            sql.append("    " + TBTHB2KMEI.CODE5 + ", ");
            sql.append("    MST01." + TBTHBAMST.INTVALUE1 + " AS CYBNO, ");
            sql.append("    " + TBTHB2KMEI.NAME4 + ", ");
            sql.append("    " + TBTHB2KMEI.NAME10 + ", ");
            sql.append("    NULL, ");
            sql.append("    MST02." + TBTHBAMST.INTVALUE1 + " AS HNMKCD, ");
            sql.append("    " + TBTHB2KMEI.KBN2 + " AS KNRKBN, ");
            sql.append("    sum(" + TBTHB2KMEI.SEIGAK + ") AS " + TBTHB2KMEI.SEIGAK + ", ");
            sql.append("    " + TBTHB2KMEI.CODE2 + " AS FEECD ");
            sql.append("FROM ");
            sql.append("    " + TBTHB1DOWN.TBNAME + ", ");
            sql.append("    " + TBTHB2KMEI.TBNAME + ", ");
            sql.append("    (SELECT ");
            sql.append("        " + TBTHBAMST.FIELD1 + ", ");
            sql.append("        " + TBTHBAMST.FIELD2 + ", ");
            sql.append("        " + TBTHBAMST.INTVALUE1 + " ");
            sql.append("    FROM ");
            sql.append("        " + TBTHBAMST.TBNAME + " ");
            sql.append("    WHERE ");
            sql.append("        " + TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND ");
            sql.append("        " + TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND ");
            sql.append("        " + TBTHBAMST.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND ");
            sql.append("        " + TBTHBAMST.SYBT + " = '107' ");
            sql.append("    ORDER BY ");
            sql.append("        " + TBTHBAMST.INTVALUE1 + " ");
            sql.append("    ) MST01, ");
            sql.append("    (SELECT ");
            sql.append("        " + TBTHBAMST.FIELD1 + ", ");
            sql.append("        " + TBTHBAMST.FIELD2 + ", ");
            sql.append("        " + TBTHBAMST.INTVALUE1 + " ");
            sql.append("    FROM ");
            sql.append("        " + TBTHBAMST.TBNAME + " ");
            sql.append("    WHERE ");
            sql.append("        " + TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND ");
            sql.append("        " + TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND ");
            sql.append("        " + TBTHBAMST.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND ");
            sql.append("        " + TBTHBAMST.SYBT + " = '104' ");
            sql.append("    ORDER BY ");
            sql.append("        " + TBTHBAMST.INTVALUE1 + " ");
            sql.append("    ) MST02 ");
            sql.append("WHERE ");
            sql.append("    " + TBTHB1DOWN.YYMM + " = '" + _cond.getYm() + "' AND ");
            sql.append("    " + TBTHB1DOWN.EGCD + " = '" + _cond.getEgCd() + "' AND ");
            sql.append("    " + TBTHB1DOWN.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND ");
            sql.append("    " + TBTHB1DOWN.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND ");
            sql.append("    " + TBTHB1DOWN.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND ");
            sql.append("    " + TBTHB1DOWN.TJYUTNO + " = ' ' AND ");
            sql.append("    " + TBTHB2KMEI.JYUTNO + " = " + TBTHB1DOWN.JYUTNO + " AND ");
            sql.append("    " + TBTHB2KMEI.JYMEINO + " = " + TBTHB1DOWN.JYMEINO + " AND ");
            sql.append("    " + TBTHB2KMEI.URMEINO + " = " + TBTHB1DOWN.URMEINO + " AND ");
            sql.append("    " + TBTHB2KMEI.EGCD + " = " + TBTHB1DOWN.EGCD + " AND ");
            sql.append("    " + TBTHB2KMEI.TKSKGYCD + " = " + TBTHB1DOWN.TKSKGYCD + " AND ");
            sql.append("    " + TBTHB2KMEI.TKSBMNSEQNO + " = " + TBTHB1DOWN.TKSBMNSEQNO + " AND ");
            sql.append("    " + TBTHB2KMEI.TKSTNTSEQNO + " = " + TBTHB1DOWN.TKSTNTSEQNO + " AND ");
            sql.append("    " + TBTHB2KMEI.YYMM + " = " + TBTHB1DOWN.YYMM + " AND ");
            sql.append("    " + TBTHB2KMEI.KBN1 + " <> '1' AND ");
            sql.append("    TRIM(" + TBTHB2KMEI.CODE5 + ") = TRIM(MST01." + TBTHBAMST.FIELD1 + "(+)) AND ");
            sql.append("    TRIM(" + TBTHB2KMEI.CODE3 + ") = TRIM(MST02." + TBTHBAMST.FIELD1 + "(+)) AND ");
            sql.append("    " + TBTHB2KMEI.CODE2 + " IN ('FEE01', 'FEE02','FEE16','FEE18') AND ");
            sql.append("    " + TBTHB2KMEI.CODE4 + " IN ('120', '30' ) ");
            sql.append("GROUP BY ");
            sql.append("    " + TBTHB2KMEI.CODE4 + ", ");
            sql.append("    " + TBTHB2KMEI.CODE1 + ", ");
            sql.append("    " + TBTHB2KMEI.DATE1 + ", ");
            sql.append("    " + TBTHB2KMEI.CODE5 + ", ");
            sql.append("    " + TBTHB2KMEI.NAME4 + ", ");
            sql.append("    " + TBTHB2KMEI.NAME10 + ", ");
            sql.append("    " + TBTHB2KMEI.CODE3 + ", ");
            sql.append("    " + TBTHB2KMEI.KBN2 + ", ");
            sql.append("    MST01." + TBTHBAMST.INTVALUE1 + ", ");
            sql.append("    MST02." + TBTHBAMST.INTVALUE1 + ", ");
            sql.append("    " + TBTHB2KMEI.CODE2 + " ");
            sql.append("ORDER BY ");
            sql.append("    SITE, ");
            sql.append("    CYBNO, ");
            sql.append("    KNRKBN, ");
            sql.append("    HNMKCD ");
        } else if (_cond.getKbn().equals(SITE_TYPE_OTHER)) {
            sql.append("SELECT ");
            sql.append("    1 AS SQLNO, ");
            sql.append("    " + TBTHB2KMEI.CODE4 + " AS SITE, ");
            sql.append("    " + TBTHB2KMEI.CODE1 + ", ");
            sql.append("    " + TBTHB2KMEI.DATE1 + ", ");
            sql.append("    " + TBTHB2KMEI.CODE5 + ", ");
            sql.append("    MST01." + TBTHBAMST.INTVALUE1 + " AS CYBNO, ");
            sql.append("    " + TBTHB2KMEI.NAME4 + ", ");
            sql.append("    " + TBTHB2KMEI.NAME2 + ", ");
            sql.append("    " + TBTHB2KMEI.CODE3 + ", ");
            sql.append("    MST02." + TBTHBAMST.INTVALUE1 + " AS HNMKCD, ");
            sql.append("    " + TBTHB2KMEI.KBN2 + " AS KNRKBN, ");
            sql.append("    sum(" + TBTHB2KMEI.SEIGAK + ") AS " + TBTHB2KMEI.SEIGAK + ", ");
            sql.append("    Null AS FEECD ");
            sql.append("FROM ");
            sql.append("    " + TBTHB1DOWN.TBNAME + ", ");
            sql.append("    " + TBTHB2KMEI.TBNAME + ", ");
            sql.append("    (SELECT ");
            sql.append("        " + TBTHBAMST.FIELD1 + ", ");
            sql.append("        " + TBTHBAMST.FIELD2 + ", ");
            sql.append("        " + TBTHBAMST.INTVALUE1 + " ");
            sql.append("    FROM ");
            sql.append("        " + TBTHBAMST.TBNAME + " ");
            sql.append("    WHERE ");
            sql.append("        " + TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND ");
            sql.append("        " + TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND ");
            sql.append("        " + TBTHBAMST.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND ");
            sql.append("        " + TBTHBAMST.SYBT + " = '107' ");
            sql.append("    ORDER BY ");
            sql.append("        " + TBTHBAMST.INTVALUE1 + " ");
            sql.append("    ) MST01, ");
            sql.append("    (SELECT ");
            sql.append("        " + TBTHBAMST.FIELD1 + ", ");
            sql.append("        " + TBTHBAMST.FIELD2 + ", ");
            sql.append("        " + TBTHBAMST.INTVALUE1 + " ");
            sql.append("    FROM ");
            sql.append("        " + TBTHBAMST.TBNAME + " ");
            sql.append("    WHERE ");
            sql.append("        " + TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND ");
            sql.append("        " + TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND ");
            sql.append("        " + TBTHBAMST.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND ");
            sql.append("        " + TBTHBAMST.SYBT + " = '104' ");
            sql.append("    ORDER BY ");
            sql.append("        " + TBTHBAMST.INTVALUE1 + " ");
            sql.append("    ) MST02 ");
            sql.append("WHERE ");
            sql.append("    " + TBTHB1DOWN.YYMM + " = '" + _cond.getYm() + "' AND ");
            sql.append("    " + TBTHB1DOWN.EGCD + " = '" + _cond.getEgCd() + "' AND ");
            sql.append("    " + TBTHB1DOWN.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND ");
            sql.append("    " + TBTHB1DOWN.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND ");
            sql.append("    " + TBTHB1DOWN.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND ");
            sql.append("    " + TBTHB1DOWN.TJYUTNO + " = ' ' AND ");
            sql.append("    " + TBTHB2KMEI.JYUTNO + " = " + TBTHB1DOWN.JYUTNO + " AND ");
            sql.append("    " + TBTHB2KMEI.JYMEINO + " = " + TBTHB1DOWN.JYMEINO + " AND ");
            sql.append("    " + TBTHB2KMEI.URMEINO + " = " + TBTHB1DOWN.URMEINO + " AND ");
            sql.append("    " + TBTHB2KMEI.EGCD + " = " + TBTHB1DOWN.EGCD + " AND ");
            sql.append("    " + TBTHB2KMEI.TKSKGYCD + " = " + TBTHB1DOWN.TKSKGYCD + " AND ");
            sql.append("    " + TBTHB2KMEI.TKSBMNSEQNO + " = " + TBTHB1DOWN.TKSBMNSEQNO + " AND ");
            sql.append("    " + TBTHB2KMEI.TKSTNTSEQNO + " = " + TBTHB1DOWN.TKSTNTSEQNO + " AND ");
            sql.append("    " + TBTHB2KMEI.YYMM + " = " + TBTHB1DOWN.YYMM + " AND ");
            sql.append("    " + TBTHB2KMEI.KBN1 + " <> '1' AND ");
            sql.append("    TRIM(" + TBTHB2KMEI.CODE5 + ") = TRIM(MST01." + TBTHBAMST.FIELD1 + "(+)) AND ");
            sql.append("    TRIM(" + TBTHB2KMEI.CODE3 + ") = TRIM(MST02." + TBTHBAMST.FIELD1 + "(+)) AND ");
            sql.append("    " + TBTHB2KMEI.CODE2 + " NOT IN ('FEE01', 'FEE02','FEE16','FEE18') AND ");
            sql.append("    " + TBTHB2KMEI.CODE4 + " NOT IN ('120', '30' ) ");
            sql.append("GROUP BY ");
            sql.append("    " + TBTHB2KMEI.CODE4 + ", ");
            sql.append("    " + TBTHB2KMEI.CODE1 + ", ");
            sql.append("    " + TBTHB2KMEI.DATE1 + ", ");
            sql.append("    " + TBTHB2KMEI.CODE5 + ", ");
            sql.append("    " + TBTHB2KMEI.NAME4 + ", ");
            sql.append("    " + TBTHB2KMEI.NAME2 + ", ");
            sql.append("    " + TBTHB2KMEI.CODE3 + ", ");
            sql.append("    " + TBTHB2KMEI.KBN2 + ", ");
            sql.append("    MST01." + TBTHBAMST.INTVALUE1 + ", ");
            sql.append("    MST02." + TBTHBAMST.INTVALUE1 + " ");
            sql.append("UNION  ");
            sql.append("SELECT ");
            sql.append("    2 AS SQLNO, ");
            sql.append("    " + TBTHB2KMEI.CODE4 + " AS SITE, ");
            sql.append("    " + TBTHB2KMEI.CODE1 + ", ");
            sql.append("    " + TBTHB2KMEI.DATE1 + ", ");
            sql.append("    " + TBTHB2KMEI.CODE5 + ", ");
            sql.append("    MST01." + TBTHBAMST.INTVALUE1 + " AS CYBNO, ");
            sql.append("    " + TBTHB2KMEI.NAME4 + ", ");
            sql.append("    " + TBTHB2KMEI.NAME10 + ", ");
            sql.append("    NULL, ");
            sql.append("    MST02." + TBTHBAMST.INTVALUE1 + " AS HNMKCD, ");
            sql.append("    " + TBTHB2KMEI.KBN2 + " AS KNRKBN, ");
            sql.append("    sum(" + TBTHB2KMEI.SEIGAK + ") AS " + TBTHB2KMEI.SEIGAK + ", ");
            sql.append("    " + TBTHB2KMEI.CODE2 + " AS FEECD ");
            sql.append("FROM ");
            sql.append("    " + TBTHB1DOWN.TBNAME + ", ");
            sql.append("    " + TBTHB2KMEI.TBNAME + ", ");
            sql.append("    (SELECT ");
            sql.append("        " + TBTHBAMST.FIELD1 + ", ");
            sql.append("        " + TBTHBAMST.FIELD2 + ", ");
            sql.append("        " + TBTHBAMST.INTVALUE1 + " ");
            sql.append("    FROM ");
            sql.append("        " + TBTHBAMST.TBNAME + " ");
            sql.append("    WHERE ");
            sql.append("        " + TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND ");
            sql.append("        " + TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND ");
            sql.append("        " + TBTHBAMST.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND ");
            sql.append("        " + TBTHBAMST.SYBT + " = '107' ");
            sql.append("    ORDER BY ");
            sql.append("        " + TBTHBAMST.INTVALUE1 + " ");
            sql.append("    ) MST01, ");
            sql.append("    (SELECT ");
            sql.append("        " + TBTHBAMST.FIELD1 + ", ");
            sql.append("        " + TBTHBAMST.FIELD2 + ", ");
            sql.append("        " + TBTHBAMST.INTVALUE1 + " ");
            sql.append("    FROM ");
            sql.append("        " + TBTHBAMST.TBNAME + " ");
            sql.append("    WHERE ");
            sql.append("        " + TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND ");
            sql.append("        " + TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND ");
            sql.append("        " + TBTHBAMST.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND ");
            sql.append("        " + TBTHBAMST.SYBT + " = '104' ");
            sql.append("    ORDER BY ");
            sql.append("        " + TBTHBAMST.INTVALUE1 + " ");
            sql.append("    ) MST02 ");
            sql.append("WHERE ");
            sql.append("    " + TBTHB1DOWN.YYMM + " = '" + _cond.getYm() + "' AND ");
            sql.append("    " + TBTHB1DOWN.EGCD + " = '" + _cond.getEgCd() + "' AND ");
            sql.append("    " + TBTHB1DOWN.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND ");
            sql.append("    " + TBTHB1DOWN.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND ");
            sql.append("    " + TBTHB1DOWN.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND ");
            sql.append("    " + TBTHB1DOWN.TJYUTNO + " = ' ' AND ");
            sql.append("    " + TBTHB2KMEI.JYUTNO + " = " + TBTHB1DOWN.JYUTNO + " AND ");
            sql.append("    " + TBTHB2KMEI.JYMEINO + " = " + TBTHB1DOWN.JYMEINO + " AND ");
            sql.append("    " + TBTHB2KMEI.URMEINO + " = " + TBTHB1DOWN.URMEINO + " AND ");
            sql.append("    " + TBTHB2KMEI.EGCD + " = " + TBTHB1DOWN.EGCD + " AND ");
            sql.append("    " + TBTHB2KMEI.TKSKGYCD + " = " + TBTHB1DOWN.TKSKGYCD + " AND ");
            sql.append("    " + TBTHB2KMEI.TKSBMNSEQNO + " = " + TBTHB1DOWN.TKSBMNSEQNO + " AND ");
            sql.append("    " + TBTHB2KMEI.TKSTNTSEQNO + " = " + TBTHB1DOWN.TKSTNTSEQNO + " AND ");
            sql.append("    " + TBTHB2KMEI.YYMM + " = " + TBTHB1DOWN.YYMM + " AND ");
            sql.append("    " + TBTHB2KMEI.KBN1 + " <> '1' AND ");
            sql.append("    TRIM(" + TBTHB2KMEI.CODE5 + ") = TRIM(MST01." + TBTHBAMST.FIELD1 + "(+)) AND ");
            sql.append("    TRIM(" + TBTHB2KMEI.CODE3 + ") = TRIM(MST02." + TBTHBAMST.FIELD1 + "(+)) AND ");
            sql.append("    " + TBTHB2KMEI.CODE2 + " IN ('FEE01', 'FEE02','FEE16','FEE18') AND ");
            sql.append("    " + TBTHB2KMEI.CODE4 + " NOT IN ('120', '30' ) ");
            sql.append("GROUP BY ");
            sql.append("    " + TBTHB2KMEI.CODE4 + ", ");
            sql.append("    " + TBTHB2KMEI.CODE1 + ", ");
            sql.append("    " + TBTHB2KMEI.DATE1 + ", ");
            sql.append("    " + TBTHB2KMEI.CODE5 + ", ");
            sql.append("    " + TBTHB2KMEI.NAME4 + ", ");
            sql.append("    " + TBTHB2KMEI.NAME10 + ", ");
            sql.append("    " + TBTHB2KMEI.CODE3 + ", ");
            sql.append("    " + TBTHB2KMEI.KBN2 + ", ");
            sql.append("    MST01." + TBTHBAMST.INTVALUE1 + ", ");
            sql.append("    MST02." + TBTHBAMST.INTVALUE1 + ", ");
            sql.append("    " + TBTHB2KMEI.CODE2 + " ");
            sql.append("ORDER BY ");
            sql.append("    CYBNO, ");
            sql.append("    KNRKBN, ");
            sql.append("    HNMKCD ");
        }

        return sql.toString();
    }

    /**
     * 帳票データ（TOH)の検索を行います。
     *
     * @return 汎用テーブルマスタVOリスト
     * @throws UserException
     *             データアクセス中にエラーが発生した場合。
     */
    @SuppressWarnings("unchecked")
    public List<ReportTkdBillingByItemVO> findReportTkdBillingByCondition(ReportTkdBillingByItemCondition cond) throws KKHException {

        super.setModel(new ReportTkdBillingByItemVO());

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
    protected List<ReportTkdBillingByItemVO> createFindedModelInstances(List hashList) {
        List<ReportTkdBillingByItemVO> list = new ArrayList<ReportTkdBillingByItemVO>();
        if (getModel() instanceof ReportTkdBillingByItemVO) {
            for (int i = 0; i < hashList.size(); i++) {
                Map result = (Map) hashList.get(i);
                ReportTkdBillingByItemVO vo = new ReportTkdBillingByItemVO();

                vo.setSQLNO((BigDecimal) result.get(ReportTkdBillingByItemVO.SQLNO.toUpperCase()));
                vo.setSITE((String) result.get(ReportTkdBillingByItemVO.SITE.toUpperCase()));
                vo.setStrDairitenCD((String) result.get(TBTHB2KMEI.CODE1.toUpperCase()));
                vo.setStrYM((String) result.get(TBTHB2KMEI.DATE1.toUpperCase()));
                vo.setStrCYBNCD((String) result.get(TBTHB2KMEI.CODE5.toUpperCase()));
                vo.setCYBNO((BigDecimal) result.get(ReportTkdBillingByItemVO.CYBNO.toUpperCase()));
                vo.setStrCYBNNM((String) result.get(TBTHB2KMEI.NAME4.toUpperCase()));
                vo.setStrHinmokuNM((String) result.get(TBTHB2KMEI.NAME2.toUpperCase()));
                vo.setStrHinmokuCD((String) result.get(TBTHB2KMEI.CODE3.toUpperCase()));
                vo.setHNMKCD((BigDecimal) result.get(ReportTkdBillingByItemVO.HNMKCD.toUpperCase()));
                vo.setKNRKBN((String) result.get(ReportTkdBillingByItemVO.KNRKBN.toUpperCase()));
                vo.setCurKingaku((BigDecimal) result.get(TBTHB2KMEI.SEIGAK.toUpperCase()));
                vo.setFEECD((String) result.get(ReportTkdBillingByItemVO.FEECD.toUpperCase()));

                // 検索結果直後の状態にする
                ModelUtils.copyMemberSearchAfterInstace(vo);
                list.add(vo);
            }
        }

        return list;
    }

}

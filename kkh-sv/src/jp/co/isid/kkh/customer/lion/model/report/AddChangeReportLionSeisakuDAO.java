package jp.co.isid.kkh.customer.lion.model.report;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jp.co.isid.kkh.integ.tbl.TBTHB1DOWN;
import jp.co.isid.kkh.integ.tbl.TBTHB2KMEI;
import jp.co.isid.kkh.integ.tbl.TBTHB91RRKDOWN;
import jp.co.isid.kkh.integ.tbl.TBTHB92RRKKMEI;
import jp.co.isid.kkh.integ.tbl.TBTHBAMST;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractRdbDao;
import jp.co.isid.nj.model.ModelUtils;

/**
 *
 * <P>
 * ライオン帳票(制作室リスト)検索DAO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2014/07/31 HLC S.Fujimoto)<BR>
 * </P>
 *
 * @author HLC S.Fujimoto
 */

public class AddChangeReportLionSeisakuDAO extends AbstractRdbDao {

    /** ライオン帳票(制作室リスト)検索条件 */
    AddChangeReportLionSeisakuCondition _cond = null;
    /** ライオン帳票(制作室リスト)VO */
    AddChangeReportLionSeisakuVO _vo = null;

    /**
     *  getSelectSQLで発行するSQLモード
     */
    /** 履歴タイムスタンプ */
    private static final String RRKTIMSTMP = "RRKTIMSTMP";
    /** 制作室リスト(AD1) */
    private static final String SEISAKUAD1 = "SEISAKUAD1";
    /** 制作室リスト(AD2) */
    private static final String SEISAKUAD2 = "SEISAKUAD2";
    /** 制作室リスト(AD1/AD2差分) */
    private static final String SEISAKUDIFF = "SEISAKUDIFF";

    //デフォルトSQLモード
    String _sqlMode = RRKTIMSTMP;

    /** インラインビュー(AD1) */
    private static final String VWNAME_AD1 = "AD1";
    /** インラインビュー(AD2) */
    private static final String VWNAME_AD2 = "AD2";

    /**
     * 媒体区分
     */
    /** 制作 */
    private static final String SEISAKU = "012";

    /**
     * 変更点
     */
    /** 区分変更 */
    private static final String CHGPNT_BAITAIKBN = "01";
    /** コード変更 */
    private static final String CHGPNT_BRDCD = "02";
    /** 件名変更 */
    private static final String CHGPNT_KENNM = "03";
    /** 金額変更 */
    private static final String CHGPNT_SEIGAK = "04";
    /** 区分変更、コード変更 */
    private static final String CHGPNT_BAITAIKBN_BRDCD = "05";
    /** 区分変更、件名変更 */
    private static final String CHGPNT_BAITAIKBN_KENNM = "06";
    /** 区分変更、金額変更 */
    private static final String CHGPNT_BAITAIKBN_SEIGAK = "07";
    /** コード変更、件名変更 */
    private static final String CHGPNT_BRDCD_KENNM = "08";
    /** コード変更、金額変更 */
    private static final String CHGPNT_BRDCD_SEIGAK = "09";
    /** 件名変更、金額変更 */
    private static final String CHGPNT_KENNM_SEIGAK = "10";
    /** 区分変更、件名変更、金額変更 */
    private static final String CHGPNT_BAITAIKBN_KENNM_SEIGAK = "11";
    /** 区分変更、コード変更、金額変更 */
    private static final String CHGPNT_BAITAIKBN_BRDCD_SEIGAK = "12";
    /** 区分変更、コード変更、件名変更 */
    private static final String CHGPNT_BAITAIKBN_BRDCD_KENNM = "13";
    /** コード変更、件名変更、金額変更 */
    private static final String CHGPNT_BRDCD_KENNM_SEIGAK = "14";
    /** 区分変更、コード変更、件名変更、金額変更 */
    private static final String CHGPNT_ALL = "15";

    /**
     * デフォルトコンストラクタ。
     */
    public AddChangeReportLionSeisakuDAO() {
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
        return null;
    }

    /**
     * テーブル名を返します。
     * @return String テーブル名
     */
    @Override
    public String getTableName() {
        return TBTHB91RRKDOWN.TBNAME;
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
     * SQL文生成
     */
    public String getSelectSQL() {

        String sql = "";

        //履歴タイムスタンプの場合
        if (_sqlMode.equals(RRKTIMSTMP)) {
            sql = getSelectSQLRrkTimStmp();
        }
        //制作室リスト(AD1)の場合
        else if (_sqlMode.equals(SEISAKUAD1)) {
            sql = getSelectSQLAD2Seisaku();
        }
        //制作室リスト(AD2)の場合
        else if (_sqlMode.equals(SEISAKUAD2)) {
            if (_cond.getRrkTimStmp() == null) {
                sql = getSelectSQLAD2Seisaku();
            } else {
                sql = getSelectSQLAD1Seisaku();
            }
        }
        //制作室リスト(AD1/AD2差分)の場合
        else if (_sqlMode.equals(SEISAKUDIFF)) {
            sql = getSelectSQLSeisakuDiff();
        }
        else {
            sql = "";
        }

        return sql;
    }

    /**
     * 履歴日時取得SQL文生成
     * @return SQL文
     */
    private String getSelectSQLRrkTimStmp() {

        //SQL
        StringBuffer sql = new StringBuffer();

        sql.append(" SELECT");
        sql.append(" TO_CHAR(" + TBTHB92RRKKMEI.RRKTIMSTMP + ", 'YYYY/MM/DD HH24:MI:SS') " + AddChangeReportLionSeisakuVO.RRKTIMSTMP);
        sql.append(" FROM");
        sql.append(" " + TBTHB92RRKKMEI.TBNAME);
        sql.append(" WHERE");
        sql.append(" " + TBTHB92RRKKMEI.EGCD + " = '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB92RRKKMEI.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB92RRKKMEI.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB92RRKKMEI.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB92RRKKMEI.YYMM + " = '" + _cond.getYymm() + "'");
        sql.append(" GROUP BY");
        sql.append(" " + TBTHB92RRKKMEI.RRKTIMSTMP);
        sql.append(" ORDER BY");
        sql.append(" " + TBTHB92RRKKMEI.RRKTIMSTMP);

        return sql.toString();
    }

    /**
     * 制作室リスト(AD1)取得SQL文生成
     * @return SQL文
     */
    private String getSelectSQLAD1Seisaku() {

        //SQL
        StringBuffer sql = new StringBuffer();

        sql.append(" SELECT");
        sql.append(" /*+ ORDERED */");
        sql.append(" " + TBTHB92RRKKMEI.JYUTNO + " " + AddChangeReportLionSeisakuVO.JYUTNO + ",");
        sql.append(" " + TBTHB92RRKKMEI.JYMEINO + " " + AddChangeReportLionSeisakuVO.JYMEINO + ",");
        sql.append(" " + TBTHB92RRKKMEI.URMEINO + " " + AddChangeReportLionSeisakuVO.URMEINO + ",");
        sql.append(" " + TBTHB92RRKKMEI.CODE1 + " " + AddChangeReportLionSeisakuVO.BAITAIKBN + ",");
        sql.append(" MST3." + TBTHBAMST.FIELD2 + " " + AddChangeReportLionSeisakuVO.BAITAINM + ",");
        sql.append(" MST1." + TBTHBAMST.FIELD1 + " " + AddChangeReportLionSeisakuVO.JUNLECD + ",");
        sql.append(" " + TBTHB92RRKKMEI.CODE3 + " " + AddChangeReportLionSeisakuVO.BRDCD + ",");
        sql.append(" MST2." + TBTHBAMST.FIELD2 + " " + AddChangeReportLionSeisakuVO.BRDNM + ",");
        sql.append(" TRIM(" + TBTHB92RRKKMEI.NAME10 + ") " + AddChangeReportLionSeisakuVO.KENNM + ",");
        sql.append(" " + TBTHB92RRKKMEI.SEIGAK + " " + AddChangeReportLionSeisakuVO.SEIGAK + ",");
        sql.append(" TO_NUMBER(" + TBTHB92RRKKMEI.NAME1 + ") " + AddChangeReportLionSeisakuVO.TAXAMT);
        sql.append(" FROM");
        sql.append(" " + TBTHB91RRKDOWN.TBNAME + ",");
        sql.append(" " + TBTHB92RRKKMEI.TBNAME + ",");
        sql.append(" " + TBTHBAMST.TBNAME + " MST1,");
        sql.append(" " + TBTHBAMST.TBNAME + " MST2,");
        sql.append(" " + TBTHBAMST.TBNAME + " MST3");
        sql.append(" WHERE");
        sql.append(" " + TBTHB92RRKKMEI.EGCD + " = '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB92RRKKMEI.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB92RRKKMEI.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB92RRKKMEI.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB92RRKKMEI.YYMM + " = '" + _cond.getYymm() + "' AND");
        sql.append(" " + TBTHB92RRKKMEI.RRKTIMSTMP + " = TO_DATE('" + _cond.getRrkTimStmp() + "', 'yyyy/MM/dd HH24:MI:SS') AND");
        sql.append(" " + TBTHB92RRKKMEI.CODE6 + " = '" + SEISAKU + "' AND");
        sql.append(" " + TBTHB91RRKDOWN.EGCD + " = " + TBTHB92RRKKMEI.EGCD + " AND");
        sql.append(" " + TBTHB91RRKDOWN.TKSKGYCD + " = " + TBTHB92RRKKMEI.TKSKGYCD + " AND");
        sql.append(" " + TBTHB91RRKDOWN.TKSBMNSEQNO + " = " + TBTHB92RRKKMEI.TKSBMNSEQNO + " AND");
        sql.append(" " + TBTHB91RRKDOWN.TKSTNTSEQNO + " = " + TBTHB92RRKKMEI.TKSTNTSEQNO + " AND");
        sql.append(" " + TBTHB91RRKDOWN.YYMM + "  = " + TBTHB92RRKKMEI.YYMM + " AND");
        sql.append(" " + TBTHB91RRKDOWN.RRKTIMSTMP + " = " + TBTHB92RRKKMEI.RRKTIMSTMP + " AND");
        sql.append(" " + TBTHB91RRKDOWN.JYUTNO + " = " + TBTHB92RRKKMEI.JYUTNO + " AND");
        sql.append(" " + TBTHB91RRKDOWN.JYMEINO + " = " + TBTHB92RRKKMEI.JYMEINO + " AND");
        sql.append(" " + TBTHB91RRKDOWN.URMEINO + " = " + TBTHB92RRKKMEI.URMEINO + " AND");
        sql.append(" " + TBTHB91RRKDOWN.TJYUTNO + " = ' ' AND");
        sql.append(" " + TBTHB92RRKKMEI.EGCD + " = MST1." + TBTHBAMST.EGCD + "(+) AND");
        sql.append(" " + TBTHB92RRKKMEI.TKSKGYCD + " = MST1." + TBTHBAMST.TKSKGYCD + "(+) AND");
        sql.append(" " + TBTHB92RRKKMEI.TKSBMNSEQNO + " = MST1." + TBTHBAMST.TKSBMNSEQNO + "(+) AND");
        sql.append(" " + TBTHB92RRKKMEI.TKSTNTSEQNO + " = MST1." + TBTHBAMST.TKSTNTSEQNO + "(+) AND");
        sql.append(" MST1." + TBTHBAMST.SYBT + " = '103' AND");
        sql.append(" " + TBTHB92RRKKMEI.EGCD + " = MST2." + TBTHBAMST.EGCD + "(+) AND");
        sql.append(" MST2." + TBTHBAMST.FIELD4 + " = MST1." + TBTHBAMST.FIELD1 + " AND");
        sql.append(" " + TBTHB92RRKKMEI.TKSKGYCD + " = MST2." + TBTHBAMST.TKSKGYCD + "(+) AND");
        sql.append(" " + TBTHB92RRKKMEI.TKSBMNSEQNO + " = MST2." + TBTHBAMST.TKSBMNSEQNO + "(+) AND");
        sql.append(" " + TBTHB92RRKKMEI.TKSTNTSEQNO + " = MST2." + TBTHBAMST.TKSTNTSEQNO + "(+) AND");
        sql.append(" MST2." + TBTHBAMST.SYBT + " = '201' AND");
        sql.append(" TRIM(" + TBTHB92RRKKMEI.CODE3 + ") = MST2." + TBTHBAMST.FIELD1 + " AND");
        sql.append(" " + TBTHB92RRKKMEI.EGCD + " = MST3." + TBTHBAMST.EGCD + "(+) AND");
        sql.append(" " + TBTHB92RRKKMEI.TKSKGYCD + " = MST3." + TBTHBAMST.TKSKGYCD + "(+) AND");
        sql.append(" " + TBTHB92RRKKMEI.TKSBMNSEQNO + " = MST3." + TBTHBAMST.TKSBMNSEQNO + "(+) AND");
        sql.append(" " + TBTHB92RRKKMEI.TKSTNTSEQNO + " = MST3." + TBTHBAMST.TKSTNTSEQNO + "(+) AND");
        sql.append(" MST3." + TBTHBAMST.SYBT + " = '104' AND");
        sql.append(" TRIM(" + TBTHB92RRKKMEI.CODE1 + ") = MST3." + TBTHBAMST.FIELD1 + "(+)");
        sql.append(" ORDER BY");
        sql.append(" " + AddChangeReportLionSeisakuVO.JUNLECD + ",");
        sql.append(" " + AddChangeReportLionSeisakuVO.BRDCD + ",");
        sql.append(" " + AddChangeReportLionSeisakuVO.BAITAIKBN + ",");
        sql.append(" " + TBTHB92RRKKMEI.JYUTNO + ",");
        sql.append(" " + TBTHB92RRKKMEI.JYMEINO + ",");
        sql.append(" " + TBTHB92RRKKMEI.URMEINO);

        return sql.toString();
    }

    /**
     * 制作室リスト(AD2)取得SQL文生成
     * @return SQL文
     */
    private String getSelectSQLAD2Seisaku() {

        //SQL
        StringBuffer sql = new StringBuffer();

        sql.append(" SELECT");
        sql.append(" /*+ ORDERED */");
        sql.append(" " + TBTHB2KMEI.JYUTNO + " " + AddChangeReportLionSeisakuVO.JYUTNO + ",");
        sql.append(" " + TBTHB2KMEI.JYMEINO + " " + AddChangeReportLionSeisakuVO.JYMEINO + ",");
        sql.append(" " + TBTHB2KMEI.URMEINO + " " + AddChangeReportLionSeisakuVO.URMEINO + ",");
        sql.append(" " + TBTHB2KMEI.CODE1 + " " + AddChangeReportLionSeisakuVO.BAITAIKBN + ",");
        sql.append(" MST3." + TBTHBAMST.FIELD2 + " " + AddChangeReportLionSeisakuVO.BAITAINM + ",");
        sql.append(" MST1." + TBTHBAMST.FIELD1 + " " + AddChangeReportLionSeisakuVO.JUNLECD + ",");
        sql.append(" " + TBTHB2KMEI.CODE3 + " " + AddChangeReportLionSeisakuVO.BRDCD + ",");
        sql.append(" MST2." + TBTHBAMST.FIELD2 + " " + AddChangeReportLionSeisakuVO.BRDNM + ",");
        sql.append(" TRIM(" + TBTHB2KMEI.NAME10 + ") " + AddChangeReportLionSeisakuVO.KENNM + ",");
        sql.append(" " + TBTHB2KMEI.SEIGAK + " " + AddChangeReportLionSeisakuVO.SEIGAK + ",");
        sql.append(" TO_NUMBER(" + TBTHB2KMEI.NAME1 + ") " + AddChangeReportLionSeisakuVO.TAXAMT);
        sql.append(" FROM");
        sql.append(" " + TBTHB1DOWN.TBNAME + ",");
        sql.append(" " + TBTHB2KMEI.TBNAME + ",");
        sql.append(" " + TBTHBAMST.TBNAME + " MST1,");
        sql.append(" " + TBTHBAMST.TBNAME + " MST2,");
        sql.append(" " + TBTHBAMST.TBNAME + " MST3");
        sql.append(" WHERE");
        sql.append(" " + TBTHB2KMEI.EGCD + " = '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.YYMM + " = '" + _cond.getYymm() + "' AND");
        sql.append(" " + TBTHB2KMEI.CODE6 + " = '" + SEISAKU + "' AND");
        sql.append(" " + TBTHB1DOWN.EGCD + " = " + TBTHB2KMEI.EGCD + " AND");
        sql.append(" " + TBTHB1DOWN.TKSKGYCD + " = " + TBTHB2KMEI.TKSKGYCD + " AND");
        sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + " = " + TBTHB2KMEI.TKSBMNSEQNO + " AND");
        sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + " = " + TBTHB2KMEI.TKSTNTSEQNO + " AND");
        sql.append(" " + TBTHB1DOWN.YYMM + "  = " + TBTHB2KMEI.YYMM + " AND");
        sql.append(" " + TBTHB1DOWN.JYUTNO + " = " + TBTHB2KMEI.JYUTNO + " AND");
        sql.append(" " + TBTHB1DOWN.JYMEINO + " = " + TBTHB2KMEI.JYMEINO + " AND");
        sql.append(" " + TBTHB1DOWN.URMEINO + " = " + TBTHB2KMEI.URMEINO + " AND");
        sql.append(" " + TBTHB1DOWN.TJYUTNO + " = ' ' AND");
        sql.append(" MST2." + TBTHBAMST.SYBT + " = '201' AND");
        sql.append(" " + TBTHB2KMEI.EGCD + " = MST2." + TBTHBAMST.EGCD + " AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = MST2." + TBTHBAMST.TKSKGYCD + "(+) AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = MST2." + TBTHBAMST.TKSBMNSEQNO + "(+) AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = MST2." + TBTHBAMST.TKSTNTSEQNO + "(+) AND");
        sql.append(" TRIM(" + TBTHB2KMEI.CODE3 + ") = MST2." + TBTHBAMST.FIELD1 + " AND");
        sql.append(" MST1." + TBTHBAMST.SYBT + " = '103' AND");
        sql.append(" MST2." + TBTHBAMST.EGCD + " = MST1." + TBTHBAMST.EGCD + "(+) AND");
        sql.append(" MST2." + TBTHBAMST.TKSKGYCD + " = MST1." + TBTHBAMST.TKSKGYCD + "(+) AND");
        sql.append(" MST2." + TBTHBAMST.TKSBMNSEQNO + " = MST1." + TBTHBAMST.TKSBMNSEQNO + "(+) AND");
        sql.append(" MST2." + TBTHBAMST.TKSTNTSEQNO + " = MST1." + TBTHBAMST.TKSTNTSEQNO + "(+) AND");
        sql.append(" MST2." + TBTHBAMST.FIELD4 + " = MST1." + TBTHBAMST.FIELD1 + "(+) AND");
        sql.append(" " + TBTHB2KMEI.EGCD + " = MST3." + TBTHBAMST.EGCD + "(+) AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = MST3." + TBTHBAMST.TKSKGYCD + "(+) AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = MST3." + TBTHBAMST.TKSBMNSEQNO + "(+) AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = MST3." + TBTHBAMST.TKSTNTSEQNO + "(+) AND");
        sql.append(" MST3." + TBTHBAMST.SYBT + " = '104' AND");
        sql.append(" TRIM(" + TBTHB2KMEI.CODE1 + ") = MST3." + TBTHBAMST.FIELD1 + "(+)");
        sql.append(" ORDER BY");
        sql.append(" " + AddChangeReportLionSeisakuVO.JUNLECD + ",");
        sql.append(" " + AddChangeReportLionSeisakuVO.BRDCD + ",");
        sql.append(" " + AddChangeReportLionSeisakuVO.BAITAIKBN + ",");
        sql.append(" " + TBTHB2KMEI.JYUTNO + ",");
        sql.append(" " + TBTHB2KMEI.JYMEINO + ",");
        sql.append(" " + TBTHB2KMEI.URMEINO);

        return sql.toString();
    }

    /**
     * 制作室リスト(AD1/AD2差分)取得SQL文生成
     * @return SQL文
     */
    private String getSelectSQLSeisakuDiff() {

        //SQL文
        StringBuffer sql = new StringBuffer();

        //AD1
        sql.append(" WITH " + VWNAME_AD1 + " AS");
        sql.append(" (");
        sql.append(" SELECT");
        sql.append(" /*+ ORDERED */");
        sql.append(" " + TBTHB92RRKKMEI.JYUTNO + " " + AddChangeReportLionSeisakuVO.JYUTNO + ",");
        sql.append(" " + TBTHB92RRKKMEI.JYMEINO + " " + AddChangeReportLionSeisakuVO.JYMEINO + ",");
        sql.append(" " + TBTHB92RRKKMEI.URMEINO + " " + AddChangeReportLionSeisakuVO.URMEINO + ",");
        sql.append(" " + TBTHB92RRKKMEI.CODE1 + " " + AddChangeReportLionSeisakuVO.AD1BAITAIKBN + ",");
        sql.append(" MST3." + TBTHBAMST.FIELD2 + " " + AddChangeReportLionSeisakuVO.AD1BAITAINM + ",");
        sql.append(" MST1." + TBTHBAMST.FIELD1 + " " + AddChangeReportLionSeisakuVO.AD1JUNLECD + ",");
        sql.append(" " + TBTHB92RRKKMEI.CODE3 + " " + AddChangeReportLionSeisakuVO.AD1BRDCD + ",");
        sql.append(" MST2." + TBTHBAMST.FIELD2 + " " + AddChangeReportLionSeisakuVO.AD1BRDNM + ",");
        sql.append(" TRIM(" + TBTHB92RRKKMEI.NAME10 + ") " + AddChangeReportLionSeisakuVO.AD1KENNM + ",");
        sql.append(" " + TBTHB92RRKKMEI.SEIGAK + " " + AddChangeReportLionSeisakuVO.AD1SEIGAK + ",");
        sql.append(" TO_NUMBER(" + TBTHB92RRKKMEI.NAME1 + ") " + AddChangeReportLionSeisakuVO.AD1TAXAMT);
        sql.append(" FROM");
        sql.append(" " + TBTHB91RRKDOWN.TBNAME + ",");
        sql.append(" " + TBTHB92RRKKMEI.TBNAME + ",");
        sql.append(" " + TBTHBAMST.TBNAME + " MST1,");
        sql.append(" " + TBTHBAMST.TBNAME + " MST2,");
        sql.append(" " + TBTHBAMST.TBNAME + " MST3");
        sql.append(" WHERE");
        sql.append(" " + TBTHB92RRKKMEI.EGCD + " = '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB92RRKKMEI.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB92RRKKMEI.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB92RRKKMEI.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB92RRKKMEI.YYMM + " = '" + _cond.getYymm() + "' AND");
        sql.append(" " + TBTHB92RRKKMEI.RRKTIMSTMP + " = TO_DATE('" + _cond.getRrkTimStmp() + "', 'yyyy/MM/dd HH24:MI:SS') AND");
        sql.append(" " + TBTHB92RRKKMEI.CODE6 + " = '" + SEISAKU + "' AND");
        sql.append(" " + TBTHB91RRKDOWN.EGCD + " = " + TBTHB92RRKKMEI.EGCD + " AND");
        sql.append(" " + TBTHB91RRKDOWN.TKSKGYCD + " = " + TBTHB92RRKKMEI.TKSKGYCD + " AND");
        sql.append(" " + TBTHB91RRKDOWN.TKSBMNSEQNO + " = " + TBTHB92RRKKMEI.TKSBMNSEQNO + " AND");
        sql.append(" " + TBTHB91RRKDOWN.TKSTNTSEQNO + " = " + TBTHB92RRKKMEI.TKSTNTSEQNO + " AND");
        sql.append(" " + TBTHB91RRKDOWN.YYMM + " = " + TBTHB92RRKKMEI.YYMM + " AND");
        sql.append(" " + TBTHB91RRKDOWN.RRKTIMSTMP + " = " + TBTHB92RRKKMEI.RRKTIMSTMP + " AND");
        sql.append(" " + TBTHB91RRKDOWN.JYUTNO + " = " + TBTHB92RRKKMEI.JYUTNO + " AND");
        sql.append(" " + TBTHB91RRKDOWN.JYMEINO + " = " + TBTHB92RRKKMEI.JYMEINO + " AND");
        sql.append(" " + TBTHB91RRKDOWN.URMEINO + " = " + TBTHB92RRKKMEI.URMEINO + " AND");
        sql.append(" " + TBTHB91RRKDOWN.TJYUTNO + " = ' ' AND");
        sql.append(" " + TBTHB92RRKKMEI.EGCD + " = MST2." + TBTHBAMST.EGCD + "(+) AND");
        sql.append(" " + TBTHB92RRKKMEI.TKSKGYCD + " = MST2." + TBTHBAMST.TKSKGYCD + "(+) AND");
        sql.append(" " + TBTHB92RRKKMEI.TKSBMNSEQNO + " = MST2." + TBTHBAMST.TKSBMNSEQNO + "(+) AND");
        sql.append(" " + TBTHB92RRKKMEI.TKSTNTSEQNO + " = MST2." + TBTHBAMST.TKSTNTSEQNO + "(+) AND");
        sql.append(" MST2." + TBTHBAMST.SYBT + " = '201' AND");
        sql.append(" TRIM(" + TBTHB92RRKKMEI.CODE3 + ") = MST2." + TBTHBAMST.FIELD1 + "(+) AND");
        sql.append(" MST2." + TBTHBAMST.EGCD + " = MST1." + TBTHBAMST.EGCD + "(+) AND");
        sql.append(" MST2." + TBTHBAMST.TKSKGYCD + " = MST1." + TBTHBAMST.TKSKGYCD + "(+) AND");
        sql.append(" MST2." + TBTHBAMST.TKSBMNSEQNO + " = MST1." + TBTHBAMST.TKSBMNSEQNO + "(+) AND");
        sql.append(" MST2." + TBTHBAMST.TKSTNTSEQNO + " = MST1." + TBTHBAMST.TKSTNTSEQNO + "(+) AND");
        sql.append(" MST1." + TBTHBAMST.SYBT + " = '103' AND");
        sql.append(" MST2." + TBTHBAMST.FIELD4 + " = MST1." + TBTHBAMST.FIELD1 + "(+) AND");
        sql.append(" " + TBTHB92RRKKMEI.EGCD + " = MST3." + TBTHBAMST.EGCD + "(+) AND");
        sql.append(" " + TBTHB92RRKKMEI.TKSKGYCD + " = MST3." + TBTHBAMST.TKSKGYCD + "(+) AND");
        sql.append(" " + TBTHB92RRKKMEI.TKSBMNSEQNO + " = MST3." + TBTHBAMST.TKSBMNSEQNO + "(+) AND");
        sql.append(" " + TBTHB92RRKKMEI.TKSTNTSEQNO + " = MST3." + TBTHBAMST.TKSTNTSEQNO + "(+) AND");
        sql.append(" MST3." + TBTHBAMST.SYBT + " = '104' AND");
        sql.append(" TRIM(" + TBTHB92RRKKMEI.CODE1 + ") = MST3." + TBTHBAMST.FIELD1 + "(+)");
        sql.append(" ),");

        //AD2
        sql.append(" " + VWNAME_AD2 + " AS");
        sql.append(" (");
        sql.append(" SELECT");
        sql.append(" /*+ ORDERED */");
        sql.append(" " + TBTHB2KMEI.JYUTNO + " " + AddChangeReportLionSeisakuVO.JYUTNO + ",");
        sql.append(" " + TBTHB2KMEI.JYMEINO + " " + AddChangeReportLionSeisakuVO.JYMEINO + ",");
        sql.append(" " + TBTHB2KMEI.URMEINO + " " + AddChangeReportLionSeisakuVO.URMEINO + ",");
        sql.append(" " + TBTHB2KMEI.CODE1 + " " + AddChangeReportLionSeisakuVO.AD2BAITAIKBN + ",");
        sql.append(" MST3." + TBTHBAMST.FIELD2 + " " + AddChangeReportLionSeisakuVO.AD2BAITAINM + ",");
        sql.append(" MST1." + TBTHBAMST.FIELD1 +" " + AddChangeReportLionSeisakuVO.AD2JUNLECD + ",");
        sql.append(" " + TBTHB2KMEI.CODE3 + " " + AddChangeReportLionSeisakuVO.AD2BRDCD + ",");
        sql.append(" MST2." + TBTHBAMST.FIELD2 + " " + AddChangeReportLionSeisakuVO.AD2BRDNM + ",");
        sql.append(" TRIM(" + TBTHB2KMEI.NAME10 + ") " + AddChangeReportLionSeisakuVO.AD2KENNM + ",");
        sql.append(" " + TBTHB2KMEI.SEIGAK + " " + AddChangeReportLionSeisakuVO.AD2SEIGAK + ",");
        sql.append(" TO_NUMBER(" + TBTHB2KMEI.NAME1 + ") " + AddChangeReportLionSeisakuVO.AD2TAXAMT);
        sql.append(" FROM");
        sql.append(" " + TBTHB1DOWN.TBNAME + ",");
        sql.append(" " + TBTHB2KMEI.TBNAME + ",");
        sql.append(" " + TBTHBAMST.TBNAME + " MST1,");
        sql.append(" " + TBTHBAMST.TBNAME + " MST2,");
        sql.append(" " + TBTHBAMST.TBNAME + " MST3");
        sql.append(" WHERE");
        sql.append(" " + TBTHB2KMEI.EGCD + " = '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.YYMM + " = '" + _cond.getYymm() + "' AND");
        sql.append(" " + TBTHB2KMEI.CODE6 + " = '" + SEISAKU + "' AND");
        sql.append(" " + TBTHB1DOWN.EGCD + " = " + TBTHB2KMEI.EGCD + " AND");
        sql.append(" " + TBTHB1DOWN.TKSKGYCD + " = " + TBTHB2KMEI.TKSKGYCD + " AND");
        sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + " = " + TBTHB2KMEI.TKSBMNSEQNO + " AND");
        sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + " = " + TBTHB2KMEI.TKSTNTSEQNO + " AND");
        sql.append(" " + TBTHB1DOWN.YYMM + " = " + TBTHB2KMEI.YYMM + " AND");
        sql.append(" " + TBTHB1DOWN.JYUTNO + " = " + TBTHB2KMEI.JYUTNO + " AND");
        sql.append(" " + TBTHB1DOWN.JYMEINO + " = " + TBTHB2KMEI.JYMEINO + " AND");
        sql.append(" " + TBTHB1DOWN.URMEINO + " = " + TBTHB2KMEI.URMEINO + " AND");
        sql.append(" " + TBTHB1DOWN.TJYUTNO + " = ' ' AND");
        sql.append(" MST2." + TBTHBAMST.SYBT + " = '201' AND");
        sql.append(" " + TBTHB2KMEI.EGCD + " = MST2." + TBTHBAMST.EGCD + "(+) AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = MST2." + TBTHBAMST.TKSKGYCD + "(+) AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = MST2." + TBTHBAMST.TKSBMNSEQNO + "(+) AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = MST2." + TBTHBAMST.TKSTNTSEQNO + "(+) AND");
        sql.append(" TRIM(" + TBTHB2KMEI.CODE3 + ") = MST2." + TBTHBAMST.FIELD1 + "(+) AND");
        sql.append(" MST1." + TBTHBAMST.SYBT + " = '103' AND");
        sql.append(" MST2." + TBTHBAMST.EGCD + " = MST1." + TBTHBAMST.EGCD + "(+) AND");
        sql.append(" MST2." + TBTHBAMST.TKSKGYCD + " = MST1." + TBTHBAMST.TKSKGYCD + "(+) AND");
        sql.append(" MST2." + TBTHBAMST.TKSBMNSEQNO + " = MST1." + TBTHBAMST.TKSBMNSEQNO + "(+) AND");
        sql.append(" MST2." + TBTHBAMST.TKSTNTSEQNO + " = MST1." + TBTHBAMST.TKSTNTSEQNO + "(+) AND");
        sql.append(" MST2." + TBTHBAMST.FIELD4 + " = MST1." + TBTHBAMST.FIELD1 + "(+) AND");
        sql.append(" " + TBTHB2KMEI.EGCD + " = MST3." + TBTHBAMST.EGCD + "(+) AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = MST3." + TBTHBAMST.TKSKGYCD + "(+) AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = MST3." + TBTHBAMST.TKSBMNSEQNO + "(+) AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = MST3." + TBTHBAMST.TKSTNTSEQNO + "(+) AND");
        sql.append(" MST3." + TBTHBAMST.SYBT + " = '104' AND");
        sql.append(" TRIM(" + TBTHB2KMEI.CODE1 + ") = MST3." + TBTHBAMST.FIELD1 + "(+)");
        sql.append(" )");

        sql.append(" SELECT");
        sql.append(" " + AddChangeReportLionSeisakuVO.JYUTNO + ",");
        sql.append(" " + AddChangeReportLionSeisakuVO.JYMEINO + ",");
        sql.append(" " + AddChangeReportLionSeisakuVO.URMEINO + ",");
        sql.append(" " + AddChangeReportLionSeisakuVO.BAITAIKBN + ",");
        sql.append(" " + AddChangeReportLionSeisakuVO.BAITAINM + ",");
        sql.append(" " + AddChangeReportLionSeisakuVO.JUNLECD + ",");
        sql.append(" " + AddChangeReportLionSeisakuVO.BRDCD + ",");
        sql.append(" " + AddChangeReportLionSeisakuVO.BRDNM + ",");
        sql.append(" " + AddChangeReportLionSeisakuVO.KENNM + ",");
        sql.append(" " + AddChangeReportLionSeisakuVO.SEIGAK + ",");
        sql.append(" " + AddChangeReportLionSeisakuVO.TAXAMT + ",");
        sql.append(" " + AddChangeReportLionSeisakuVO.CHGPNT + ",");
        sql.append(" " + AddChangeReportLionSeisakuVO.SEQ);
        sql.append(" FROM");
        sql.append(" (");

        //追加
        sql.append(" SELECT");
        sql.append(" /*+ ORDERED */");
        sql.append(" " + AddChangeReportLionSeisakuVO.JYUTNO + ",");
        sql.append(" " + AddChangeReportLionSeisakuVO.JYMEINO + ",");
        sql.append(" " + AddChangeReportLionSeisakuVO.URMEINO + ",");
        sql.append(" " + AddChangeReportLionSeisakuVO.AD2BAITAIKBN + " " + AddChangeReportLionSeisakuVO.BAITAIKBN + ",");
        sql.append(" " + AddChangeReportLionSeisakuVO.AD2BAITAINM + " " + AddChangeReportLionSeisakuVO.BAITAINM + ",");
        sql.append(" " + AddChangeReportLionSeisakuVO.AD2JUNLECD + " " + AddChangeReportLionSeisakuVO.JUNLECD + ",");
        sql.append(" " + AddChangeReportLionSeisakuVO.AD2BRDCD + " " + AddChangeReportLionSeisakuVO.BRDCD + ",");
        sql.append(" " + AddChangeReportLionSeisakuVO.AD2BRDNM + " " + AddChangeReportLionSeisakuVO.BRDNM + ",");
        sql.append(" " + AddChangeReportLionSeisakuVO.AD2KENNM + " " + AddChangeReportLionSeisakuVO.KENNM + ",");
        sql.append(" " + AddChangeReportLionSeisakuVO.AD2SEIGAK + " " + AddChangeReportLionSeisakuVO.SEIGAK + ",");
        sql.append(" " + AddChangeReportLionSeisakuVO.AD2TAXAMT + " " + AddChangeReportLionSeisakuVO.TAXAMT + ",");
        sql.append(" '' " + AddChangeReportLionSeisakuVO.CHGPNT + ",");
        sql.append(" '1' " + AddChangeReportLionSeisakuVO.SEQ);
        sql.append(" FROM");
        sql.append(" " + VWNAME_AD2 + " A");
        sql.append(" WHERE");
        sql.append(" NOT EXISTS");
        sql.append(" (");
        sql.append(" SELECT");
        sql.append(" 1");
        sql.append(" FROM");
        sql.append(" " + VWNAME_AD1 + " B");
        sql.append(" WHERE");
        sql.append(" A." + AddChangeReportLionSeisakuVO.JYUTNO + " = B." + AddChangeReportLionSeisakuVO.JYUTNO + " AND");
        sql.append(" A." + AddChangeReportLionSeisakuVO.JYMEINO + " = B." + AddChangeReportLionSeisakuVO.JYMEINO + " AND");
        sql.append(" A." + AddChangeReportLionSeisakuVO.URMEINO + " = B." + AddChangeReportLionSeisakuVO.URMEINO);
        sql.append(" )");

        sql.append(" UNION ALL");

        //削除
        sql.append(" SELECT");
        sql.append(" /*+ ORDERED */");
        sql.append(" " + AddChangeReportLionSeisakuVO.JYUTNO + ",");
        sql.append(" " + AddChangeReportLionSeisakuVO.JYMEINO + ",");
        sql.append(" " + AddChangeReportLionSeisakuVO.URMEINO + ",");
        sql.append(" " + AddChangeReportLionSeisakuVO.AD1BAITAIKBN + ",");
        sql.append(" " + AddChangeReportLionSeisakuVO.AD1BAITAINM + ",");
        sql.append(" " + AddChangeReportLionSeisakuVO.AD1JUNLECD + ",");
        sql.append(" " + AddChangeReportLionSeisakuVO.AD1BRDCD + ",");
        sql.append(" " + AddChangeReportLionSeisakuVO.AD1BRDNM + ",");
        sql.append(" " + AddChangeReportLionSeisakuVO.AD1KENNM + ",");
        sql.append(" " + AddChangeReportLionSeisakuVO.AD1SEIGAK + " * (-1),");
        sql.append(" " + AddChangeReportLionSeisakuVO.AD1TAXAMT + " * (-1),");
        sql.append(" '' " + AddChangeReportLionSeisakuVO.CHGPNT + ",");
        sql.append(" '2' " + AddChangeReportLionSeisakuVO.SEQ);
        sql.append(" FROM");
        sql.append(" " + VWNAME_AD1 + " C");
        sql.append(" WHERE");
        sql.append(" NOT EXISTS");
        sql.append(" (");
        sql.append(" SELECT");
        sql.append(" 1");
        sql.append(" FROM");
        sql.append(" " + VWNAME_AD2 + " D");
        sql.append(" WHERE");
        sql.append(" C." + AddChangeReportLionSeisakuVO.JYUTNO + " = D." + AddChangeReportLionSeisakuVO.JYUTNO + " AND");
        sql.append(" C." + AddChangeReportLionSeisakuVO.JYMEINO + " = D." + AddChangeReportLionSeisakuVO.JYMEINO + " AND");
        sql.append(" C." + AddChangeReportLionSeisakuVO.URMEINO + " = D." + AddChangeReportLionSeisakuVO.URMEINO);
        sql.append(" )");

        sql.append(" UNION ALL");

        //変更
        sql.append(" SELECT");
        sql.append(" " + AddChangeReportLionSeisakuVO.JYUTNO + ",");
        sql.append(" " + AddChangeReportLionSeisakuVO.JYMEINO + ",");
        sql.append(" " + AddChangeReportLionSeisakuVO.URMEINO + ",");
        sql.append(" " + AddChangeReportLionSeisakuVO.AD2BAITAIKBN + ",");
        sql.append(" " + AddChangeReportLionSeisakuVO.AD2BAITAINM + ",");
        sql.append(" " + AddChangeReportLionSeisakuVO.AD2JUNLECD + ",");
        sql.append(" " + AddChangeReportLionSeisakuVO.AD2BRDCD + ",");
        sql.append(" " + AddChangeReportLionSeisakuVO.AD2BRDNM + ",");
        sql.append(" " + AddChangeReportLionSeisakuVO.AD2KENNM + ",");
        sql.append(" " + AddChangeReportLionSeisakuVO.AD2SEIGAK + " - " + AddChangeReportLionSeisakuVO.AD1SEIGAK + ",");
        sql.append(" " + AddChangeReportLionSeisakuVO.AD2TAXAMT + " - " + AddChangeReportLionSeisakuVO.AD1TAXAMT + ",");
        sql.append(" CASE");
        sql.append(" WHEN " + AddChangeReportLionSeisakuVO.AD1BAITAIKBN + " <> " + AddChangeReportLionSeisakuVO.AD2BAITAIKBN);
        sql.append(" THEN");
        sql.append(" CASE");
        sql.append(" WHEN " + AddChangeReportLionSeisakuVO.AD1BRDCD + " <> " + AddChangeReportLionSeisakuVO.AD2BRDCD);
        sql.append(" THEN");
        sql.append(" CASE");
        sql.append(" WHEN " + AddChangeReportLionSeisakuVO.AD1KENNM + " <> " + AddChangeReportLionSeisakuVO.AD2KENNM);
        sql.append(" THEN");
        sql.append(" CASE");
        sql.append(" WHEN " + AddChangeReportLionSeisakuVO.AD1SEIGAK + " <> " + AddChangeReportLionSeisakuVO.AD2SEIGAK);
        sql.append(" THEN '" + CHGPNT_ALL + "'");
        sql.append(" ELSE '" + CHGPNT_BAITAIKBN_BRDCD_KENNM + "'");
        sql.append(" END");
        sql.append(" ELSE");
        sql.append(" CASE");
        sql.append(" WHEN " + AddChangeReportLionSeisakuVO.AD1SEIGAK + " <> " + AddChangeReportLionSeisakuVO.AD2SEIGAK);
        sql.append(" THEN '" + CHGPNT_BAITAIKBN_BRDCD_SEIGAK + "'");
        sql.append(" ELSE '" + CHGPNT_BAITAIKBN_BRDCD + "'");
        sql.append(" END");
        sql.append(" END");
        sql.append(" ELSE");
        sql.append(" CASE");
        sql.append(" WHEN " + AddChangeReportLionSeisakuVO.AD1KENNM + " <> " + AddChangeReportLionSeisakuVO.AD2KENNM);
        sql.append(" THEN");
        sql.append(" CASE");
        sql.append(" WHEN " + AddChangeReportLionSeisakuVO.AD1SEIGAK + " <> " + AddChangeReportLionSeisakuVO.AD2SEIGAK);
        sql.append(" THEN '" + CHGPNT_BAITAIKBN_KENNM_SEIGAK + "'");
        sql.append(" ELSE '" + CHGPNT_BAITAIKBN_KENNM + "'");
        sql.append(" END");
        sql.append(" ELSE");
        sql.append(" CASE");
        sql.append(" WHEN " + AddChangeReportLionSeisakuVO.AD1SEIGAK + " <> " + AddChangeReportLionSeisakuVO.AD2SEIGAK);
        sql.append(" THEN '" + CHGPNT_BAITAIKBN_SEIGAK + "'");
        sql.append(" ELSE '" + CHGPNT_BAITAIKBN + "'");
        sql.append(" END");
        sql.append(" END");
        sql.append(" END");
        sql.append(" ELSE");
        sql.append(" CASE");
        sql.append(" WHEN " + AddChangeReportLionSeisakuVO.AD1BRDCD + " <> " + AddChangeReportLionSeisakuVO.AD2BRDCD);
        sql.append(" THEN");
        sql.append(" CASE");
        sql.append(" WHEN " + AddChangeReportLionSeisakuVO.AD1KENNM + " <> " + AddChangeReportLionSeisakuVO.AD2KENNM);
        sql.append(" THEN");
        sql.append(" CASE");
        sql.append(" WHEN " + AddChangeReportLionSeisakuVO.AD1SEIGAK + " <> " + AddChangeReportLionSeisakuVO.AD2SEIGAK);
        sql.append(" THEN '" + CHGPNT_BRDCD_KENNM_SEIGAK + "'");
        sql.append(" ELSE '" + CHGPNT_BRDCD_KENNM + "'");
        sql.append(" END");
        sql.append(" ELSE");
        sql.append(" CASE");
        sql.append(" WHEN " + AddChangeReportLionSeisakuVO.AD1SEIGAK + " <> " + AddChangeReportLionSeisakuVO.AD2SEIGAK);
        sql.append(" THEN '" + CHGPNT_BRDCD_SEIGAK + "'");
        sql.append(" ELSE '" + CHGPNT_BRDCD + "'");
        sql.append(" END");
        sql.append(" END");
        sql.append(" ELSE");
        sql.append(" CASE");
        sql.append(" WHEN " + AddChangeReportLionSeisakuVO.AD1KENNM + " <> " + AddChangeReportLionSeisakuVO.AD2KENNM);
        sql.append(" THEN");
        sql.append(" CASE");
        sql.append(" WHEN " + AddChangeReportLionSeisakuVO.AD1SEIGAK + " <> " + AddChangeReportLionSeisakuVO.AD2SEIGAK);
        sql.append(" THEN '" + CHGPNT_KENNM_SEIGAK + "'");
        sql.append(" ELSE '" + CHGPNT_KENNM + "'");
        sql.append(" END");
        sql.append(" ELSE");
        sql.append(" CASE");
        sql.append(" WHEN " + AddChangeReportLionSeisakuVO.AD1SEIGAK + " <> " + AddChangeReportLionSeisakuVO.AD2SEIGAK);
        sql.append(" THEN '" + CHGPNT_SEIGAK + "'");
        sql.append(" END");
        sql.append(" END");
        sql.append(" END");
        sql.append(" END " + AddChangeReportLionSeisakuVO.CHGPNT + ",");
        sql.append(" SEQ");
        sql.append(" FROM");
        sql.append(" (");
        sql.append(" SELECT");
        sql.append(" /*+ ORDERED */");
        sql.append(" E." + AddChangeReportLionSeisakuVO.JYUTNO + ",");
        sql.append(" E." + AddChangeReportLionSeisakuVO.JYMEINO + ",");
        sql.append(" E." + AddChangeReportLionSeisakuVO.URMEINO + ",");
        sql.append(" E." + AddChangeReportLionSeisakuVO.AD1BAITAIKBN + ",");
        sql.append(" E." + AddChangeReportLionSeisakuVO.AD1BAITAINM + ",");
        sql.append(" E." + AddChangeReportLionSeisakuVO.AD1JUNLECD + ",");
        sql.append(" E." + AddChangeReportLionSeisakuVO.AD1BRDCD + ",");
        sql.append(" E." + AddChangeReportLionSeisakuVO.AD1BRDNM + ",");
        sql.append(" E." + AddChangeReportLionSeisakuVO.AD1KENNM + ",");
        sql.append(" E." + AddChangeReportLionSeisakuVO.AD1SEIGAK + ",");
        sql.append(" E." + AddChangeReportLionSeisakuVO.AD1TAXAMT + ",");
        sql.append(" F." + AddChangeReportLionSeisakuVO.AD2BAITAIKBN + ",");
        sql.append(" F." + AddChangeReportLionSeisakuVO.AD2BAITAINM + ",");
        sql.append(" F." + AddChangeReportLionSeisakuVO.AD2JUNLECD + ",");
        sql.append(" F." + AddChangeReportLionSeisakuVO.AD2BRDCD + ",");
        sql.append(" F." + AddChangeReportLionSeisakuVO.AD2BRDNM + ",");
        sql.append(" F." + AddChangeReportLionSeisakuVO.AD2KENNM + ",");
        sql.append(" F." + AddChangeReportLionSeisakuVO.AD2SEIGAK + ",");
        sql.append(" F." + AddChangeReportLionSeisakuVO.AD2TAXAMT + ",");
        sql.append(" '3'" + AddChangeReportLionSeisakuVO.SEQ);
        sql.append(" FROM");
        sql.append(" " + VWNAME_AD1 + " E,");
        sql.append(" " + VWNAME_AD2 + " F");
        sql.append(" WHERE");
        sql.append(" E." + AddChangeReportLionSeisakuVO.JYUTNO + " = F." + AddChangeReportLionSeisakuVO.JYUTNO + " AND");
        sql.append(" E." + AddChangeReportLionSeisakuVO.JYMEINO + " = F." + AddChangeReportLionSeisakuVO.JYMEINO + " AND");
        sql.append(" E." + AddChangeReportLionSeisakuVO.URMEINO + " = F." + AddChangeReportLionSeisakuVO.URMEINO + " AND");
        sql.append("  (");
        sql.append(" E." + AddChangeReportLionSeisakuVO.AD1BAITAIKBN + " <> F." + AddChangeReportLionSeisakuVO.AD2BAITAIKBN + " OR");
        sql.append(" E." + AddChangeReportLionSeisakuVO.AD1BRDCD + " <> F." + AddChangeReportLionSeisakuVO.AD2BRDCD + " OR");
        sql.append(" E." + AddChangeReportLionSeisakuVO.AD1KENNM + " <> F." + AddChangeReportLionSeisakuVO.AD2KENNM + " OR");
        sql.append(" E." + AddChangeReportLionSeisakuVO.AD1SEIGAK + " <> F." + AddChangeReportLionSeisakuVO.AD2SEIGAK + " OR");
        sql.append(" E." + AddChangeReportLionSeisakuVO.AD1TAXAMT + " <> F." + AddChangeReportLionSeisakuVO.AD2TAXAMT);
        sql.append(" )");
        sql.append(" )");

        sql.append(" )");
        sql.append(" ORDER BY");
        sql.append(" " + AddChangeReportLionSeisakuVO.JUNLECD + ",");
        sql.append(" " + AddChangeReportLionSeisakuVO.BRDCD + ",");
        sql.append(" " + AddChangeReportLionSeisakuVO.BAITAIKBN + ",");
        sql.append(" " + AddChangeReportLionSeisakuVO.JYUTNO + ",");
        sql.append(" " + AddChangeReportLionSeisakuVO.JYMEINO + ",");
        sql.append(" " + AddChangeReportLionSeisakuVO.URMEINO);

        return sql.toString();
    }

    /**
     * ライオン制作室リストデータの検索を行います。
     * @param cond ライオン帳票(制作室リスト・追加変更リスト)検索条件
     * @return ライオン制作室リストデータ取得VOリスト
     * @throws KKHException データアクセス中にエラーが発生した場合
     */
    @SuppressWarnings("unchecked")
    public List<AddChangeReportLionSeisakuVO> findAddChangeReportSeisaku(AddChangeReportLionSeisakuCondition cond) throws KKHException {
        super.setModel(new AddChangeReportLionSeisakuVO());

        try {
            _cond = cond;
            _sqlMode = cond.getFindType();
            return (List<AddChangeReportLionSeisakuVO>)super.find();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0002");
        }
    }

    /**
     * ライオン制作室リスト差分データの検索を行います。
     * @param cond ライオン帳票(制作室リスト・追加変更リスト)検索条件
     * @return ライオン制作室リストデータ取得VOリスト
     * @throws KKHException データアクセス中にエラーが発生した場合
     */
    @SuppressWarnings("unchecked")
    public List<AddChangeReportLionSeisakuVO> findAddChangeReportSeisakuDiff(AddChangeReportLionSeisakuCondition cond) throws KKHException {
        super.setModel(new AddChangeReportLionSeisakuVO());

        try {
            _cond = cond;
            _sqlMode = SEISAKUDIFF;
            return (List<AddChangeReportLionSeisakuVO>)super.find();
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
     * @return List<AddChangeReportLionSeisakuVO> 変換後の検索結果
     */
    @Override
    protected List<AddChangeReportLionSeisakuVO> createFindedModelInstances(List hashList) {
        List<AddChangeReportLionSeisakuVO> list = new ArrayList<AddChangeReportLionSeisakuVO>();
        for (int i = 0; i < hashList.size(); i++) {
            Map result = (Map) hashList.get(i);
            AddChangeReportLionSeisakuVO vo = new AddChangeReportLionSeisakuVO();

            //履歴タイムスタンプの場合
            if (_sqlMode.equals(RRKTIMSTMP)) {
                //履歴タイムスタンプ
                vo.setRrkTimStmp((String) result.get(AddChangeReportLionSeisakuVO.RRKTIMSTMP.toUpperCase()));
            }
            //制作室リスト(AD1)の場合
            else if (_sqlMode.equals(SEISAKUAD1)) {
                //受注No
                vo.setJyutno((String) result.get(AddChangeReportLionSeisakuVO.JYUTNO.toUpperCase()));
                //受注明細No
                vo.setJymeino((String) result.get(AddChangeReportLionSeisakuVO.JYMEINO.toUpperCase()));
                //売上明細No
                vo.setUrmeino((String) result.get(AddChangeReportLionSeisakuVO.URMEINO.toUpperCase()));
                //媒体区分コード
                vo.setBaitaiKbn((String) result.get(AddChangeReportLionSeisakuVO.BAITAIKBN.toUpperCase()));
                //媒体区分名
                vo.setBaitaiNm((String) result.get(AddChangeReportLionSeisakuVO.BAITAINM.toUpperCase()));
                //ブランドコード
                vo.setBrdCd((String) result.get(AddChangeReportLionSeisakuVO.BRDCD.toUpperCase()));
                //ブランド名
                vo.setBrdNm((String) result.get(AddChangeReportLionSeisakuVO.BRDNM.toUpperCase()));
                //件名
                vo.setKenNm((String) result.get(AddChangeReportLionSeisakuVO.KENNM.toUpperCase()));
                //請求金額
                vo.setSeigak((BigDecimal) result.get(AddChangeReportLionSeisakuVO.SEIGAK.toUpperCase()));
                //消費税額
                vo.setTaxAmt((BigDecimal) result.get(AddChangeReportLionSeisakuVO.TAXAMT.toUpperCase()));
            }
            //制作室リスト(AD2)の場合
            else if (_sqlMode.equals(SEISAKUAD2)) {
                //受注No
                vo.setJyutno((String) result.get(AddChangeReportLionSeisakuVO.JYUTNO.toUpperCase()));
                //受注明細No
                vo.setJymeino((String) result.get(AddChangeReportLionSeisakuVO.JYMEINO.toUpperCase()));
                //売上明細No
                vo.setUrmeino((String) result.get(AddChangeReportLionSeisakuVO.URMEINO.toUpperCase()));
                //媒体区分コード
                vo.setBaitaiKbn((String) result.get(AddChangeReportLionSeisakuVO.BAITAIKBN.toUpperCase()));
                //媒体区分名
                vo.setBaitaiNm((String) result.get(AddChangeReportLionSeisakuVO.BAITAINM.toUpperCase()));
                //ブランドコード
                vo.setBrdCd((String) result.get(AddChangeReportLionSeisakuVO.BRDCD.toUpperCase()));
                //ブランド名
                vo.setBrdNm((String) result.get(AddChangeReportLionSeisakuVO.BRDNM.toUpperCase()));
                //件名
                vo.setKenNm((String) result.get(AddChangeReportLionSeisakuVO.KENNM.toUpperCase()));
                //請求金額
                vo.setSeigak((BigDecimal) result.get(AddChangeReportLionSeisakuVO.SEIGAK.toUpperCase()));
                //消費税額
                vo.setTaxAmt((BigDecimal) result.get(AddChangeReportLionSeisakuVO.TAXAMT.toUpperCase()));
            }
            //制作室リスト差分の場合
            else if (_sqlMode.equals(SEISAKUDIFF)) {
                //受注No
                vo.setJyutno((String) result.get(AddChangeReportLionSeisakuVO.JYUTNO.toUpperCase()));
                //受注明細No
                vo.setJymeino((String) result.get(AddChangeReportLionSeisakuVO.JYMEINO.toUpperCase()));
                //売上明細No
                vo.setUrmeino((String) result.get(AddChangeReportLionSeisakuVO.URMEINO.toUpperCase()));
                //媒体区分コード
                vo.setBaitaiKbn((String) result.get(AddChangeReportLionSeisakuVO.BAITAIKBN.toUpperCase()));
                //媒体区分名
                vo.setBaitaiNm((String) result.get(AddChangeReportLionSeisakuVO.BAITAINM.toUpperCase()));
                //ブランドコード
                vo.setBrdCd((String) result.get(AddChangeReportLionSeisakuVO.BRDCD.toUpperCase()));
                //ブランド名
                vo.setBrdNm((String) result.get(AddChangeReportLionSeisakuVO.BRDNM.toUpperCase()));
                //件名
                vo.setKenNm((String) result.get(AddChangeReportLionSeisakuVO.KENNM.toUpperCase()));
                //請求金額
                vo.setSeigak((BigDecimal) result.get(AddChangeReportLionSeisakuVO.SEIGAK.toUpperCase()));
                //消費税額
                vo.setTaxAmt((BigDecimal) result.get(AddChangeReportLionSeisakuVO.TAXAMT.toUpperCase()));
                //変更点
                vo.setChgPnt((String) result.get(AddChangeReportLionSeisakuVO.CHGPNT.toUpperCase()));
                //SEQ
                vo.setSEQ((String) result.get(AddChangeReportLionSeisakuVO.SEQ.toUpperCase()));
            }

            //検索結果直後の状態にする
            ModelUtils.copyMemberSearchAfterInstace(vo);
            list.add(vo);
        }

        return list;
    }

}

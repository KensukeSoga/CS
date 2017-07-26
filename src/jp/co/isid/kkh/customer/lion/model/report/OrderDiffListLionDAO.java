package jp.co.isid.kkh.customer.lion.model.report;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jp.co.isid.kkh.integ.tbl.TBRCMN_MEU29CC;
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
 *
 * <P>
 * ライオン受注差異一覧検索DAO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2014/11/10 HLC S.Fujimoto)<BR>
 * </P>
 *
 * @author HLC S.Fujimoto
 */

public class OrderDiffListLionDAO extends AbstractRdbDao {

    /** ライオン受注差異一覧検索条件 */
    private OrderDiffListLionCondition _cond;

    private enum SqlMode { ORDERDIFF, NEWORDER, AMOUNTDIFF }
    private SqlMode _sqlMode = SqlMode.ORDERDIFF;

    /**
     * デフォルトコンストラクタ。
     */
    public OrderDiffListLionDAO() {
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
        return null;
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

        //明細なし受注一覧取得
        if (_sqlMode.equals(SqlMode.ORDERDIFF)) {
            sql = getSelectSQLOrderDiff();
        }
        //新規受注一覧取得
        else if (_sqlMode.equals(SqlMode.NEWORDER)) {
            sql = getSelectSQLNewOrder();
        }
        //金額変更受注一覧
        else if (_sqlMode.equals(SqlMode.AMOUNTDIFF)) {
            sql = getSelectSQLAmountDiff();
        } else {
            sql = "";
        }

        return sql;
    }

    /**
     * 明細なし受注一覧取得SQL文生成
     * @return String SQL文
     */
    private String getSelectSQLOrderDiff() {

        //SQL
        StringBuffer sql = new StringBuffer();

        sql.append(" SELECT");
        sql.append(" A." + TBTHB1DOWN.JYUTNO + " " + OrderDiffListLionVO.JYUTNO + ",");
        sql.append(" A." + TBTHB1DOWN.JYMEINO + " " + OrderDiffListLionVO.JYMEINO + ",");
        sql.append(" A." + TBTHB1DOWN.URMEINO + " " + OrderDiffListLionVO.URMEINO + ",");
        sql.append(" A." + TBTHB1DOWN.KKNAMEKJ + " " + OrderDiffListLionVO.KKNAMEKJ + ",");
        sql.append(" A." + TBTHB1DOWN.GYOMKBN + " " + OrderDiffListLionVO.GYOMKBN + ",");
        sql.append(" B." + TBRCMN_MEU29CC.MEU29_NAIYJ + " " + OrderDiffListLionVO.GYOMKBNKJ + ",");
        sql.append(" A." + TBTHB1DOWN.HIMKCD + " " + OrderDiffListLionVO.HIMKCD + ",");
        sql.append(" A." + TBTHB1DOWN.HIMKNMKJ + " " + OrderDiffListLionVO.HIMKNMKJ + ",");
        sql.append(" A." + TBTHB1DOWN.TORIGAK + " " + OrderDiffListLionVO.TORIGAK + ",");
        sql.append(" A." + TBTHB1DOWN.NEBIGAK + " " + OrderDiffListLionVO.NEBIGAK + ",");
        sql.append(" A." + TBTHB1DOWN.SEIGAK + " " + OrderDiffListLionVO.SEIGAK + ",");
        sql.append(" A." + TBTHB1DOWN.SZEIGAK + " " + OrderDiffListLionVO.SZEIGAK + ",");
        sql.append(" '1' " + OrderDiffListLionVO.SEQ);
        sql.append(" FROM");
        sql.append(" " + TBTHB1DOWN.TBNAME + " A,");
        sql.append(" " + TBRCMN_MEU29CC.TBNAME + " B");
        sql.append(" WHERE");
        sql.append(" A." + TBTHB1DOWN.EGCD + " = '" + _cond.getEgCd() + "' AND");
        sql.append(" A." + TBTHB1DOWN.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" A." + TBTHB1DOWN.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" A." + TBTHB1DOWN.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" A." + TBTHB1DOWN.YYMM + " = '" + _cond.getYymm() + "' AND");
        sql.append(" A." + TBTHB1DOWN.TOUFLG + " = '1' AND");
        sql.append(" TRIM(A." + TBTHB1DOWN.HIMKCD + ") IS NOT NULL AND");
        sql.append(" B." + TBRCMN_MEU29CC.MEU29_KYCDKND + " = '87' AND");
        sql.append(" B." + TBRCMN_MEU29CC.MEU29_HKYMD + " <= '" + _cond.getYymm() + "01' AND");
        sql.append(" B." + TBRCMN_MEU29CC.MEU29_HAISYMD + " >= '" + _cond.getYymm() + "01' AND");
        sql.append(" A." + TBTHB1DOWN.GYOMKBN + " = B." + TBRCMN_MEU29CC.MEU29_KYCD + " AND");
        sql.append(" NOT EXISTS");
        sql.append(" (");
        sql.append(" SELECT");
        sql.append(" 1");
        sql.append(" FROM");
        sql.append(" " + TBTHB2KMEI.TBNAME);
        sql.append(" WHERE");
        sql.append(" A." + TBTHB1DOWN.EGCD + " = " +  TBTHB2KMEI.EGCD + " AND");
        sql.append(" A." + TBTHB1DOWN.TKSKGYCD + " = " +  TBTHB2KMEI.TKSKGYCD + " AND");
        sql.append(" A." + TBTHB1DOWN.TKSBMNSEQNO + " = " +  TBTHB2KMEI.TKSBMNSEQNO+ " AND");
        sql.append(" A." + TBTHB1DOWN.TKSTNTSEQNO + " = " +  TBTHB2KMEI.TKSTNTSEQNO + " AND");
        sql.append(" A." + TBTHB1DOWN.YYMM + " = " + TBTHB2KMEI.YYMM + " AND");;
        sql.append(" A." + TBTHB1DOWN.JYUTNO + " = " +  TBTHB2KMEI.JYUTNO + " AND");
        sql.append(" A." + TBTHB1DOWN.JYMEINO + " = " +  TBTHB2KMEI.JYMEINO + " AND");
        sql.append(" A." + TBTHB1DOWN.URMEINO + " = " +  TBTHB2KMEI.URMEINO);
        sql.append(" )");

        sql.append(" UNION ALL");

        sql.append(" SELECT");
        sql.append(" A." + TBTHB1DOWN.JYUTNO + ",");
        sql.append(" A." + TBTHB1DOWN.JYMEINO + ",");
        sql.append(" A." + TBTHB1DOWN.URMEINO + ",");
        sql.append(" A." + TBTHB1DOWN.KKNAMEKJ + ",");
        sql.append(" A." + TBTHB1DOWN.GYOMKBN + ",");
        sql.append(" B." + TBRCMN_MEU29CC.MEU29_NAIYJ + ",");
        sql.append(" A." + TBTHB1DOWN.HIMKCD + ",");
        sql.append(" A." + TBTHB1DOWN.HIMKNMKJ + ",");
        sql.append(" A." + TBTHB1DOWN.TORIGAK + ",");
        sql.append(" A." + TBTHB1DOWN.NEBIGAK + ",");
        sql.append(" A." + TBTHB1DOWN.SEIGAK + ",");
        sql.append(" A." + TBTHB1DOWN.SZEIGAK + ",");
        sql.append(" '2'");
        sql.append(" FROM");
        sql.append(" " + TBTHB1DOWN.TBNAME + " A,");
        sql.append(" " + TBRCMN_MEU29CC.TBNAME + " B");
        sql.append(" WHERE");
        sql.append(" A." + TBTHB1DOWN.EGCD + " = '" + _cond.getEgCd() + "' AND");
        sql.append(" A." + TBTHB1DOWN.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" A." + TBTHB1DOWN.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" A." + TBTHB1DOWN.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" A." + TBTHB1DOWN.YYMM + " = '" + _cond.getYymm() + "' AND");
        sql.append(" A." + TBTHB1DOWN.TOUFLG + " = ' ' AND");
        sql.append(" TRIM(A." + TBTHB1DOWN.HIMKCD + ") IS NOT NULL AND");
        sql.append(" B." + TBRCMN_MEU29CC.MEU29_KYCDKND + " = '87' AND");
        sql.append(" B." + TBRCMN_MEU29CC.MEU29_HKYMD + " <= '" + _cond.getYymm() + "01' AND");
        sql.append(" B." + TBRCMN_MEU29CC.MEU29_HAISYMD + " >= '" + _cond.getYymm() + "01' AND");
        sql.append(" A." + TBTHB1DOWN.GYOMKBN + " = B." + TBRCMN_MEU29CC.MEU29_KYCD + " AND");
        sql.append(" NOT EXISTS");
        sql.append(" (");
        sql.append(" SELECT");
        sql.append(" 1");
        sql.append(" FROM");
        sql.append(" " + TBTHB2KMEI.TBNAME);
        sql.append(" WHERE");
        sql.append(" A." + TBTHB1DOWN.EGCD + " = " +  TBTHB2KMEI.EGCD + " AND");
        sql.append(" A." + TBTHB1DOWN.TKSKGYCD + " = " +  TBTHB2KMEI.TKSKGYCD + " AND");
        sql.append(" A." + TBTHB1DOWN.TKSBMNSEQNO + " = " +  TBTHB2KMEI.TKSBMNSEQNO+ " AND");
        sql.append(" A." + TBTHB1DOWN.TKSTNTSEQNO + " = " +  TBTHB2KMEI.TKSTNTSEQNO + " AND");
        sql.append(" A." + TBTHB1DOWN.YYMM + " = " + TBTHB2KMEI.YYMM + " AND");;
        sql.append(" A." + TBTHB1DOWN.JYUTNO + " = " +  TBTHB2KMEI.JYUTNO + " AND");
        sql.append(" A." + TBTHB1DOWN.JYMEINO + " = " +  TBTHB2KMEI.JYMEINO + " AND");
        sql.append(" A." + TBTHB1DOWN.URMEINO + " = " +  TBTHB2KMEI.URMEINO);
        sql.append(" )");
        sql.append(" ORDER BY");
        sql.append(" " +  OrderDiffListLionVO.SEQ + ",");
        sql.append(" " +  OrderDiffListLionVO.JYUTNO + ",");
        sql.append(" " +  OrderDiffListLionVO.JYMEINO + ",");
        sql.append(" " +  OrderDiffListLionVO.URMEINO);

        return sql.toString();
    }

    /**
     * 新規受注一覧取得SQL分生成
     * @return String SQL文
     */
    private String getSelectSQLNewOrder() {

        //SQL
        StringBuffer sql = new StringBuffer();

        sql.append(" SELECT");
        sql.append(" /*+ ORDERED */");
        sql.append(" A." + TBTHB1DOWN.JYUTNO + " " + OrderDiffListLionVO.JYUTNO + ",");
        sql.append(" A." + TBTHB1DOWN.JYMEINO + " " + OrderDiffListLionVO.JYMEINO + ",");
        sql.append(" A." + TBTHB1DOWN.URMEINO + " " + OrderDiffListLionVO.URMEINO + ",");
        sql.append(" A." + TBTHB1DOWN.KKNAMEKJ + " " + OrderDiffListLionVO.KKNAMEKJ + ",");
        sql.append(" A." + TBTHB1DOWN.GYOMKBN + " " + OrderDiffListLionVO.GYOMKBN + ",");
        sql.append(" B." + TBRCMN_MEU29CC.MEU29_NAIYJ + " " + OrderDiffListLionVO.GYOMKBNKJ + ",");
        sql.append(" M1." + TBTHBAMST.FIELD2 + " " + OrderDiffListLionVO.BAITAIKBN + ",");
        sql.append(" TRIM(C." + TBTHB2KMEI.CODE3 + ") " + OrderDiffListLionVO.BRANDCD + ",");
        sql.append(" M2." + TBTHBAMST.FIELD2 + " " + OrderDiffListLionVO.BRANDNM + ",");
        sql.append(" SUM(C." + TBTHB2KMEI.SEIGAK + ") " + OrderDiffListLionVO.SEIGAK2 + ",");
        sql.append(" SUM(TO_NUMBER(C." + TBTHB2KMEI.NAME1 + ")) " + OrderDiffListLionVO.SZEIGAK2 + ",");
        sql.append(" '1' " + OrderDiffListLionVO.SEQ);
        sql.append(" FROM");
        sql.append(" " + TBTHB1DOWN.TBNAME + " A,");
        sql.append(" " + TBRCMN_MEU29CC.TBNAME + " B,");
        sql.append(" " + TBTHB2KMEI.TBNAME + " C,");
        sql.append(" " + TBTHBAMST.TBNAME + " M1,");
        sql.append(" " + TBTHBAMST.TBNAME + " M2");
        sql.append(" WHERE");
        sql.append(" A." + TBTHB1DOWN.EGCD + " = '" + _cond.getEgCd() + "' AND");
        sql.append(" A." + TBTHB1DOWN.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" A." + TBTHB1DOWN.TKSBMNSEQNO  + " = '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" A." + TBTHB1DOWN.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" A." + TBTHB1DOWN.YYMM  + "= '" + _cond.getYymm() + "' AND");
        sql.append(" A." + TBTHB1DOWN.TOUFLG + " = '1' AND");
        sql.append(" TRIM(A." + TBTHB1DOWN.HIMKCD + ") IS NULL AND");
        sql.append(" B." + TBRCMN_MEU29CC.MEU29_KYCDKND + " = '87' AND");
        sql.append(" B." + TBRCMN_MEU29CC.MEU29_HKYMD + " <= '" + _cond.getYymm() + "01' AND");
        sql.append(" B." + TBRCMN_MEU29CC.MEU29_HAISYMD + " >= '" + _cond.getYymm() + "01' AND");
        sql.append(" A." + TBTHB1DOWN.GYOMKBN + " = B." + TBRCMN_MEU29CC.MEU29_KYCD + " AND");
        sql.append(" A." + TBTHB1DOWN.EGCD + " = C." + TBTHB2KMEI.EGCD + " AND");
        sql.append(" A." + TBTHB1DOWN.TKSKGYCD + " = C." + TBTHB2KMEI.TKSKGYCD + " AND");
        sql.append(" A." + TBTHB1DOWN.TKSBMNSEQNO + " = C." + TBTHB2KMEI.TKSBMNSEQNO + " AND");
        sql.append(" A." + TBTHB1DOWN.TKSTNTSEQNO + " = C." + TBTHB2KMEI.TKSTNTSEQNO + " AND");
        sql.append(" A." + TBTHB1DOWN.YYMM + " = C." + TBTHB2KMEI.YYMM + " AND");
        sql.append(" A." + TBTHB1DOWN.JYUTNO + " = C." + TBTHB2KMEI.JYUTNO + " AND");
        sql.append(" A." + TBTHB1DOWN.JYMEINO + " = C." + TBTHB2KMEI.JYMEINO + " AND");
        sql.append(" A." + TBTHB1DOWN.URMEINO + " = C." + TBTHB2KMEI.URMEINO + " AND");
        sql.append(" M1." + TBTHBAMST.SYBT + " = '104' AND");
        sql.append(" C." + TBTHB2KMEI.EGCD + " = M1." + TBTHBAMST.EGCD + " AND");
        sql.append(" C." + TBTHB2KMEI.TKSKGYCD + " = M1." + TBTHBAMST.TKSKGYCD + " AND");
        sql.append(" C." + TBTHB2KMEI.TKSBMNSEQNO + " = M1." + TBTHBAMST.TKSBMNSEQNO + " AND");
        sql.append(" C." + TBTHB2KMEI.TKSTNTSEQNO + " = M1." + TBTHBAMST.TKSTNTSEQNO + " AND");
        sql.append(" TRIM(C." + TBTHB2KMEI.CODE1 + ") = M1." + TBTHBAMST.FIELD1 + " AND");
        sql.append(" M2." + TBTHBAMST.SYBT + " = '201' AND");
        sql.append(" C." + TBTHB2KMEI.EGCD + " = M2." + TBTHBAMST.EGCD + " AND");
        sql.append(" C." + TBTHB2KMEI.TKSKGYCD + " = M2." + TBTHBAMST.TKSKGYCD + " AND");
        sql.append(" C." + TBTHB2KMEI.TKSBMNSEQNO + " = M2." + TBTHBAMST.TKSBMNSEQNO + " AND");
        sql.append(" C." + TBTHB2KMEI.TKSTNTSEQNO + " = M2." + TBTHBAMST.TKSTNTSEQNO + " AND");
        sql.append(" TRIM(C." + TBTHB2KMEI.CODE3 + ") = M2." + TBTHBAMST.FIELD1);
        sql.append(" GROUP BY");
        sql.append(" A." + TBTHB1DOWN.JYUTNO + ",");
        sql.append(" A." + TBTHB1DOWN.JYMEINO  + ",");
        sql.append(" A." + TBTHB1DOWN.URMEINO + ",");;
        sql.append(" A." + TBTHB1DOWN.KKNAMEKJ + ",");
        sql.append(" A." + TBTHB1DOWN.GYOMKBN + ",");
        sql.append(" B." + TBRCMN_MEU29CC.MEU29_NAIYJ + ",");
        sql.append(" M1." + TBTHBAMST.FIELD2 + ",");
        sql.append(" TRIM(C." + TBTHB2KMEI.CODE3 + "),");
        sql.append(" M2." + TBTHBAMST.FIELD2);

        sql.append(" UNION ALL");

        sql.append(" SELECT");
        sql.append(" /*+ ORDERED */");
        sql.append(" A." + TBTHB1DOWN.JYUTNO + ",");
        sql.append(" A." + TBTHB1DOWN.JYMEINO + ",");
        sql.append(" A." + TBTHB1DOWN.URMEINO + ",");
        sql.append(" A." + TBTHB1DOWN.KKNAMEKJ + ",");
        sql.append(" A." + TBTHB1DOWN.GYOMKBN + ",");
        sql.append(" B." + TBRCMN_MEU29CC.MEU29_NAIYJ + ",");
        sql.append(" M1." + TBTHBAMST.FIELD2 + ",");
        sql.append(" TRIM(C." + TBTHB2KMEI.CODE3 + "),");
        sql.append(" M2." + TBTHBAMST.FIELD2 + ",");
        sql.append(" SUM(C." + TBTHB2KMEI.SEIGAK + "),");
        sql.append(" SUM(TO_NUMBER(C." + TBTHB2KMEI.NAME1 + ")),");
        sql.append(" '2'");
        sql.append(" FROM");
        sql.append(" " + TBTHB1DOWN.TBNAME + " A,");
        sql.append(" " + TBRCMN_MEU29CC.TBNAME + " B,");
        sql.append(" " + TBTHB2KMEI.TBNAME + " C,");
        sql.append(" " + TBTHBAMST.TBNAME + " M1,");
        sql.append(" " + TBTHBAMST.TBNAME + " M2");
        sql.append(" WHERE");
        sql.append(" A." + TBTHB1DOWN.EGCD + " = '" + _cond.getEgCd() + "' AND");
        sql.append(" A." + TBTHB1DOWN.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" A." + TBTHB1DOWN.TKSBMNSEQNO  + " = '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" A." + TBTHB1DOWN.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" A." + TBTHB1DOWN.YYMM  + "= '" + _cond.getYymm() + "' AND");
        sql.append(" A." + TBTHB1DOWN.TOUFLG + " = ' ' AND");
        sql.append(" TRIM(A." + TBTHB1DOWN.HIMKCD + ") IS NULL AND");
        sql.append(" B." + TBRCMN_MEU29CC.MEU29_KYCDKND + " = '87' AND");
        sql.append(" B." + TBRCMN_MEU29CC.MEU29_HKYMD + " <= '" + _cond.getYymm() + "01' AND");
        sql.append(" B." + TBRCMN_MEU29CC.MEU29_HAISYMD + " >= '" + _cond.getYymm() + "01' AND");
        sql.append(" A." + TBTHB1DOWN.GYOMKBN + " = B." + TBRCMN_MEU29CC.MEU29_KYCD + " AND");
        sql.append(" A." + TBTHB1DOWN.EGCD + " = C." + TBTHB2KMEI.EGCD + " AND");
        sql.append(" A." + TBTHB1DOWN.TKSKGYCD + " = C." + TBTHB2KMEI.TKSKGYCD + " AND");
        sql.append(" A." + TBTHB1DOWN.TKSBMNSEQNO + " = C." + TBTHB2KMEI.TKSBMNSEQNO + " AND");
        sql.append(" A." + TBTHB1DOWN.TKSTNTSEQNO + " = C." + TBTHB2KMEI.TKSTNTSEQNO + " AND");
        sql.append(" A." + TBTHB1DOWN.YYMM + " = C." + TBTHB2KMEI.YYMM + " AND");
        sql.append(" A." + TBTHB1DOWN.JYUTNO + " = C." + TBTHB2KMEI.JYUTNO + " AND");
        sql.append(" A." + TBTHB1DOWN.JYMEINO + " = C." + TBTHB2KMEI.JYMEINO + " AND");
        sql.append(" A." + TBTHB1DOWN.URMEINO + " = C." + TBTHB2KMEI.URMEINO + " AND");
        sql.append(" M1." + TBTHBAMST.SYBT + " = '104' AND");
        sql.append(" C." + TBTHB2KMEI.EGCD + " = M1." + TBTHBAMST.EGCD + " AND");
        sql.append(" C." + TBTHB2KMEI.TKSKGYCD + " = M1." + TBTHBAMST.TKSKGYCD + " AND");
        sql.append(" C." + TBTHB2KMEI.TKSBMNSEQNO + " = M1." + TBTHBAMST.TKSBMNSEQNO + " AND");
        sql.append(" C." + TBTHB2KMEI.TKSTNTSEQNO + " = M1." + TBTHBAMST.TKSTNTSEQNO + " AND");
        sql.append(" TRIM(C." + TBTHB2KMEI.CODE1 + ") = M1." + TBTHBAMST.FIELD1 + " AND");
        sql.append(" M2." + TBTHBAMST.SYBT + " = '201' AND");
        sql.append(" C." + TBTHB2KMEI.EGCD + " = M2." + TBTHBAMST.EGCD + " AND");
        sql.append(" C." + TBTHB2KMEI.TKSKGYCD + " = M2." + TBTHBAMST.TKSKGYCD + " AND");
        sql.append(" C." + TBTHB2KMEI.TKSBMNSEQNO + " = M2." + TBTHBAMST.TKSBMNSEQNO + " AND");
        sql.append(" C." + TBTHB2KMEI.TKSTNTSEQNO + " = M2." + TBTHBAMST.TKSTNTSEQNO + " AND");
        sql.append(" TRIM(C." + TBTHB2KMEI.CODE3 + ") = M2." + TBTHBAMST.FIELD1);
        sql.append(" GROUP BY");
        sql.append(" A." + TBTHB1DOWN.JYUTNO + ",");
        sql.append(" A." + TBTHB1DOWN.JYMEINO  + ",");
        sql.append(" A." + TBTHB1DOWN.URMEINO + ",");;
        sql.append(" A." + TBTHB1DOWN.KKNAMEKJ + ",");
        sql.append(" A." + TBTHB1DOWN.GYOMKBN + ",");
        sql.append(" B." + TBRCMN_MEU29CC.MEU29_NAIYJ + ",");
        sql.append(" M1." + TBTHBAMST.FIELD2 + ",");
        sql.append(" TRIM(C." + TBTHB2KMEI.CODE3 + "),");
        sql.append(" M2." + TBTHBAMST.FIELD2);
        sql.append(" ORDER BY");
        sql.append(" " +  OrderDiffListLionVO.SEQ + ",");
        sql.append(" " +  OrderDiffListLionVO.JYUTNO + ",");
        sql.append(" " +  OrderDiffListLionVO.JYMEINO + ",");
        sql.append(" " +  OrderDiffListLionVO.URMEINO);

        return sql.toString();
    }

    /**
     * 金額変更受注一覧取得SQL分生成
     * @return String SQL文
     */
    private String getSelectSQLAmountDiff() {

        //SQL
        StringBuffer sql = new StringBuffer();

        sql.append(" SELECT");
        sql.append(" /*+ ORDERED */");
        sql.append(" A." + TBTHB1DOWN.JYUTNO + " " + OrderDiffListLionVO.JYUTNO + ",");
        sql.append(" A." + TBTHB1DOWN.JYMEINO + " " + OrderDiffListLionVO.JYMEINO + ",");
        sql.append(" A." + TBTHB1DOWN.URMEINO + " " + OrderDiffListLionVO.URMEINO + ",");
        sql.append(" A." + TBTHB1DOWN.KKNAMEKJ + " " + OrderDiffListLionVO.KKNAMEKJ + ",");
        sql.append(" A." + TBTHB1DOWN.GYOMKBN + " " + OrderDiffListLionVO.GYOMKBN + ",");
        sql.append(" C." + TBRCMN_MEU29CC.MEU29_NAIYJ + " " + OrderDiffListLionVO.GYOMKBNKJ + ",");
        sql.append(" M1." + TBTHBAMST.FIELD2 + " " + OrderDiffListLionVO.BAITAIKBN + ",");
        sql.append(" TRIM(B." + TBTHB2KMEI.CODE3 + ") " + OrderDiffListLionVO.BRANDCD + ",");
        sql.append(" M2." + TBTHBAMST.FIELD2 + " " + OrderDiffListLionVO.BRANDNM + ",");
        sql.append(" A." + TBTHB1DOWN.SEIGAK + " " + OrderDiffListLionVO.SEIGAK + ",");
        sql.append(" SUM(B." + TBTHB2KMEI.SEIGAK + ") " + OrderDiffListLionVO.SEIGAK2 + ",");
        sql.append(" A." + TBTHB1DOWN.SZEIGAK + " " + OrderDiffListLionVO.SZEIGAK + ",");
        sql.append(" SUM(TO_NUMBER(B." + TBTHB2KMEI.NAME1 + ")) " + OrderDiffListLionVO.SZEIGAK2 + ",");
        sql.append(" '1' " + OrderDiffListLionVO.SEQ);
        sql.append(" FROM");
        sql.append(" " + TBTHB1DOWN.TBNAME + " A,");
        sql.append(" " + TBTHB2KMEI.TBNAME + " B,");
        sql.append(" " + TBRCMN_MEU29CC.TBNAME + " C,");
        sql.append(" " + TBTHBAMST.TBNAME + " M1,");
        sql.append(" " + TBTHBAMST.TBNAME + " M2");
        sql.append(" WHERE");
        sql.append(" A." + TBTHB1DOWN.EGCD + " = '" + _cond.getEgCd() + "' AND");
        sql.append(" A." + TBTHB1DOWN.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" A." + TBTHB1DOWN.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" A." + TBTHB1DOWN.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" A." + TBTHB1DOWN.YYMM + " = '" + _cond.getYymm() + "' AND");
        sql.append(" A." + TBTHB1DOWN.TOUFLG + " = '1' AND");
        sql.append(" TRIM(A." + TBTHB1DOWN.HIMKCD + ") IS NOT NULL AND");
        sql.append(" A." + TBTHB1DOWN.EGCD + " = B." + TBTHB2KMEI.EGCD + " AND");
        sql.append(" A." + TBTHB1DOWN.TKSKGYCD + " = B." + TBTHB2KMEI.TKSKGYCD + " AND");
        sql.append(" A." + TBTHB1DOWN.TKSBMNSEQNO + " = B." + TBTHB2KMEI.TKSBMNSEQNO + " AND");
        sql.append(" A." + TBTHB1DOWN.TKSTNTSEQNO + " = B." + TBTHB2KMEI.TKSTNTSEQNO + " AND");
        sql.append(" A." + TBTHB1DOWN.YYMM + " = B." + TBTHB2KMEI.YYMM + " AND");
        sql.append(" A." + TBTHB1DOWN.JYUTNO + " = B." + TBTHB2KMEI.JYUTNO + " AND");
        sql.append(" A." + TBTHB1DOWN.JYMEINO + " = B." + TBTHB2KMEI.JYMEINO + " AND");
        sql.append(" A." + TBTHB1DOWN.URMEINO + " = B." + TBTHB2KMEI.URMEINO + " AND");
        sql.append(" C." + TBRCMN_MEU29CC.MEU29_KYCDKND + " = '87' AND");
        sql.append(" C." + TBRCMN_MEU29CC.MEU29_HKYMD + " <= '" + _cond.getYymm() + "01' AND");
        sql.append(" C." + TBRCMN_MEU29CC.MEU29_HAISYMD + " >= '" + _cond.getYymm() + "01' AND");
        sql.append(" A." + TBTHB1DOWN.GYOMKBN + " = C." + TBRCMN_MEU29CC.MEU29_KYCD + " AND");
        sql.append(" M1." + TBTHBAMST.SYBT + " = '104' AND");
        sql.append(" B." + TBTHB2KMEI.EGCD + " = M1." + TBTHBAMST.EGCD + " AND");
        sql.append(" B." + TBTHB2KMEI.TKSKGYCD + " = M1." + TBTHBAMST.TKSKGYCD + " AND");
        sql.append(" B." + TBTHB2KMEI.TKSBMNSEQNO + " = M1." + TBTHBAMST.TKSBMNSEQNO + " AND");
        sql.append(" B." + TBTHB2KMEI.TKSTNTSEQNO + " = M1." + TBTHBAMST.TKSTNTSEQNO + " AND");
        sql.append(" TRIM(B." + TBTHB2KMEI.CODE1 + ") = M1." + TBTHBAMST.FIELD1 + " AND");
        sql.append(" M2." + TBTHBAMST.SYBT + " = '201' AND");
        sql.append(" B." + TBTHB2KMEI.EGCD + " = M2." + TBTHBAMST.EGCD + " AND");
        sql.append(" B." + TBTHB2KMEI.TKSKGYCD + " = M2." + TBTHBAMST.TKSKGYCD + " AND");
        sql.append(" B." + TBTHB2KMEI.TKSBMNSEQNO + " = M2." + TBTHBAMST.TKSBMNSEQNO + " AND");
        sql.append(" B." + TBTHB2KMEI.TKSTNTSEQNO + " = M2." + TBTHBAMST.TKSTNTSEQNO + " AND");
        sql.append(" TRIM(B." + TBTHB2KMEI.CODE3 + ") = M2." + TBTHBAMST.FIELD1);
        sql.append(" GROUP BY");
        sql.append(" A." + TBTHB1DOWN.JYUTNO + ",");
        sql.append(" A." + TBTHB1DOWN.JYMEINO + ",");
        sql.append(" A." + TBTHB1DOWN.URMEINO + ",");
        sql.append(" A." + TBTHB1DOWN.KKNAMEKJ + ",");
        sql.append(" A." + TBTHB1DOWN.GYOMKBN + ",");
        sql.append(" C." + TBRCMN_MEU29CC.MEU29_NAIYJ + ",");
        sql.append(" M1." + TBTHBAMST.FIELD2 + ",");
        sql.append(" TRIM(B." + TBTHB2KMEI.CODE3 + "),");
        sql.append(" M2." + TBTHBAMST.FIELD2 + ",");
        sql.append(" A." + TBTHB1DOWN.SEIGAK + ",");
        sql.append(" A." + TBTHB1DOWN.SZEIGAK);
        sql.append(" HAVING");
        sql.append(" " + TBTHB1DOWN.SEIGAK + " <> SUM(" + TBTHB2KMEI.SEIGAK + ")");

        sql.append(" UNION ALL");

        sql.append(" SELECT");
        sql.append(" /*+ ORDERED */");
        sql.append(" A." + TBTHB1DOWN.JYUTNO + ",");
        sql.append(" A." + TBTHB1DOWN.JYMEINO + ",");
        sql.append(" A." + TBTHB1DOWN.URMEINO + ",");
        sql.append(" A." + TBTHB1DOWN.KKNAMEKJ + ",");
        sql.append(" A." + TBTHB1DOWN.GYOMKBN + ",");
        sql.append(" C." + TBRCMN_MEU29CC.MEU29_NAIYJ + ",");
        sql.append(" M1." + TBTHBAMST.FIELD2 + ",");
        sql.append(" TRIM(B." + TBTHB2KMEI.CODE3 + "),");
        sql.append(" M2." + TBTHBAMST.FIELD2 + ",");
        sql.append(" A." + TBTHB1DOWN.SEIGAK + ",");
        sql.append(" SUM(B." + TBTHB2KMEI.SEIGAK + "),");
        sql.append(" A." + TBTHB1DOWN.SZEIGAK + ",");
        sql.append(" SUM(TO_NUMBER(B." + TBTHB2KMEI.NAME1 + ")),");
        sql.append(" '2' ");
        sql.append(" FROM");
        sql.append(" " + TBTHB1DOWN.TBNAME + " A,");
        sql.append(" " + TBTHB2KMEI.TBNAME + " B,");
        sql.append(" " + TBRCMN_MEU29CC.TBNAME + " C,");
        sql.append(" " + TBTHBAMST.TBNAME + " M1,");
        sql.append(" " + TBTHBAMST.TBNAME + " M2");
        sql.append(" WHERE");
        sql.append(" A." + TBTHB1DOWN.EGCD + " = '" + _cond.getEgCd() + "' AND");
        sql.append(" A." + TBTHB1DOWN.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" A." + TBTHB1DOWN.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" A." + TBTHB1DOWN.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" A." + TBTHB1DOWN.YYMM + " = '" + _cond.getYymm() + "' AND");
        sql.append(" A." + TBTHB1DOWN.TOUFLG + " = ' ' AND");
        sql.append(" TRIM(A." + TBTHB1DOWN.TJYUTNO + ") IS NULL AND");
        sql.append(" TRIM(A." + TBTHB1DOWN.HIMKCD + ") IS NOT NULL AND");
        sql.append(" A." + TBTHB1DOWN.EGCD + " = B." + TBTHB2KMEI.EGCD + " AND");
        sql.append(" A." + TBTHB1DOWN.TKSKGYCD + " = B." + TBTHB2KMEI.TKSKGYCD + " AND");
        sql.append(" A." + TBTHB1DOWN.TKSBMNSEQNO + " = B." + TBTHB2KMEI.TKSBMNSEQNO + " AND");
        sql.append(" A." + TBTHB1DOWN.TKSTNTSEQNO + " = B." + TBTHB2KMEI.TKSTNTSEQNO + " AND");
        sql.append(" A." + TBTHB1DOWN.YYMM + " = B." + TBTHB2KMEI.YYMM + " AND");
        sql.append(" A." + TBTHB1DOWN.JYUTNO + " = B." + TBTHB2KMEI.JYUTNO + " AND");
        sql.append(" A." + TBTHB1DOWN.JYMEINO + " = B." + TBTHB2KMEI.JYMEINO + " AND");
        sql.append(" A." + TBTHB1DOWN.URMEINO + " = B." + TBTHB2KMEI.URMEINO + " AND");
        sql.append(" C." + TBRCMN_MEU29CC.MEU29_KYCDKND + " = '87' AND");
        sql.append(" C." + TBRCMN_MEU29CC.MEU29_HKYMD + " <= '" + _cond.getYymm() + "01' AND");
        sql.append(" C." + TBRCMN_MEU29CC.MEU29_HAISYMD + " >= '" + _cond.getYymm() + "01' AND");
        sql.append(" A." + TBTHB1DOWN.GYOMKBN + " = C." + TBRCMN_MEU29CC.MEU29_KYCD + " AND");
        sql.append(" M1." + TBTHBAMST.SYBT + " = '104' AND");
        sql.append(" B." + TBTHB2KMEI.EGCD + " = M1." + TBTHBAMST.EGCD + " AND");
        sql.append(" B." + TBTHB2KMEI.TKSKGYCD + " = M1." + TBTHBAMST.TKSKGYCD + " AND");
        sql.append(" B." + TBTHB2KMEI.TKSBMNSEQNO + " = M1." + TBTHBAMST.TKSBMNSEQNO + " AND");
        sql.append(" B." + TBTHB2KMEI.TKSTNTSEQNO + " = M1." + TBTHBAMST.TKSTNTSEQNO + " AND");
        sql.append(" TRIM(B." + TBTHB2KMEI.CODE1 + ") = M1." + TBTHBAMST.FIELD1 + " AND");
        sql.append(" M2." + TBTHBAMST.SYBT + " = '201' AND");
        sql.append(" B." + TBTHB2KMEI.EGCD + " = M2." + TBTHBAMST.EGCD + " AND");
        sql.append(" B." + TBTHB2KMEI.TKSKGYCD + " = M2." + TBTHBAMST.TKSKGYCD + " AND");
        sql.append(" B." + TBTHB2KMEI.TKSBMNSEQNO + " = M2." + TBTHBAMST.TKSBMNSEQNO + " AND");
        sql.append(" B." + TBTHB2KMEI.TKSTNTSEQNO + " = M2." + TBTHBAMST.TKSTNTSEQNO + " AND");
        sql.append(" TRIM(B." + TBTHB2KMEI.CODE3 + ") = M2." + TBTHBAMST.FIELD1);
        sql.append(" GROUP BY");
        sql.append(" A." + TBTHB1DOWN.JYUTNO + ",");
        sql.append(" A." + TBTHB1DOWN.JYMEINO + ",");
        sql.append(" A." + TBTHB1DOWN.URMEINO + ",");
        sql.append(" A." + TBTHB1DOWN.KKNAMEKJ + ",");
        sql.append(" A." + TBTHB1DOWN.GYOMKBN + ",");
        sql.append(" C." + TBRCMN_MEU29CC.MEU29_NAIYJ + ",");
        sql.append(" M1." + TBTHBAMST.FIELD2 + ",");
        sql.append(" TRIM(B." + TBTHB2KMEI.CODE3 + "),");
        sql.append(" M2." + TBTHBAMST.FIELD2 + ",");
        sql.append(" A." + TBTHB1DOWN.SEIGAK + ",");
        sql.append(" A." + TBTHB1DOWN.SZEIGAK);
        sql.append(" HAVING");
        sql.append(" " + TBTHB1DOWN.SEIGAK + " <> SUM(" + TBTHB2KMEI.SEIGAK + ")");
        sql.append(" ORDER BY");
        sql.append(" " +  OrderDiffListLionVO.SEQ + ",");
        sql.append(" " +  OrderDiffListLionVO.JYUTNO + ",");
        sql.append(" " +  OrderDiffListLionVO.JYMEINO + ",");
        sql.append(" " +  OrderDiffListLionVO.URMEINO);

        return sql.toString();
    }

    /**
     * ライオン受注差異一覧データの検索を行います
     * @param cond OrderDiffListLionCondition ライオン受注差異一覧帳票検索条件
     * @return ライオン受注差異一覧取得VOリスト
     * @throws KKHException KKHエラークラス
     */
    @SuppressWarnings("unchecked")
    public List<OrderDiffListLionVO> findOrderDiffList(OrderDiffListLionCondition cond) throws KKHException {
        super.setModel(new OrderDiffListLionVO());

        try {
            _cond = cond;
            _sqlMode = SqlMode.ORDERDIFF;
            return (List<OrderDiffListLionVO>)super.find();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0002");
        }
    }

    /**
     * ライオン新規受注一覧データの検索を行います
     * @param cond OrderDiffListLionCondition ライオン受注差異一覧帳票検索条件
     * @return ライオン受注差異一覧取得VOリスト
     * @throws KKHException KKHエラークラス
     */
    @SuppressWarnings("unchecked")
    public List<OrderDiffListLionVO> findNewOrderList(OrderDiffListLionCondition cond) throws KKHException {
        super.setModel(new OrderDiffListLionVO());

        try {
            _cond = cond;
            _sqlMode = SqlMode.NEWORDER;
            return (List<OrderDiffListLionVO>)super.find();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0002");
        }
    }

    /**
     * ライオン受注金額差異一覧データの検索を行います
     * @param cond OrderDiffListLionCondition ライオン受注差異一覧帳票検索条件
     * @return ライオン受注差異一覧取得VOリスト
     * @throws KKHException KKHエラークラス
     */
    @SuppressWarnings("unchecked")
    public List<OrderDiffListLionVO> findOrderAmtDiffList(OrderDiffListLionCondition cond) throws KKHException {
        super.setModel(new OrderDiffListLionVO());

        try {
            _cond = cond;
            _sqlMode = SqlMode.AMOUNTDIFF;
            return (List<OrderDiffListLionVO>)super.find();
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
     * @return List<AddChangeReportVO> 変換後の検索結果
     */
    @Override
    protected List<OrderDiffListLionVO> createFindedModelInstances(List hashList) {
        List<OrderDiffListLionVO> list = new ArrayList<OrderDiffListLionVO>();
        for (int i = 0; i < hashList.size(); i++) {
            Map result = (Map) hashList.get(i);
            OrderDiffListLionVO vo = new OrderDiffListLionVO();

            if (_sqlMode.equals(SqlMode.ORDERDIFF)){
                //明細なし受注

                //受注No
                vo.setJyutno((String) result.get(OrderDiffListLionVO.JYUTNO.toUpperCase()));
                //受注明細No
                vo.setJymeino((String) result.get(OrderDiffListLionVO.JYMEINO.toUpperCase()));
                //売上明細No
                vo.setUrmeino((String) result.get(OrderDiffListLionVO.URMEINO.toUpperCase()));
                //件名
                vo.setKknamekj((String) result.get(OrderDiffListLionVO.KKNAMEKJ.toUpperCase()));
                //業務区分コード
                vo.setGyomkbn((String) result.get(OrderDiffListLionVO.GYOMKBN.toUpperCase()));
                //業務区分名称
                vo.setGyomkbnkj((String) result.get(OrderDiffListLionVO.GYOMKBNKJ.toUpperCase()));
                //費目コード
                vo.setHimkcd((String) result.get(OrderDiffListLionVO.HIMKCD.toUpperCase()));
                //費目名称
                vo.setHimknmkj((String) result.get(OrderDiffListLionVO.HIMKNMKJ.toUpperCase()));
                //取料金
                vo.setTorigak((BigDecimal) result.get(OrderDiffListLionVO.TORIGAK.toUpperCase()));
                //請求金額
                vo.setSeigak((BigDecimal) result.get(OrderDiffListLionVO.SEIGAK.toUpperCase()));
                //値引金額
                vo.setNebigak((BigDecimal) result.get(OrderDiffListLionVO.NEBIGAK.toUpperCase()));
                //消費税額
                vo.setSzeigak((BigDecimal) result.get(OrderDiffListLionVO.SZEIGAK.toUpperCase()));
                //SEQ
                vo.setSeq((String) result.get(OrderDiffListLionVO.SEQ.toUpperCase()));

            } else if (_sqlMode.equals(SqlMode.NEWORDER)) {
                //新規受注

                //受注No
                vo.setJyutno((String) result.get(OrderDiffListLionVO.JYUTNO.toUpperCase()));
                //受注明細No
                vo.setJymeino((String) result.get(OrderDiffListLionVO.JYMEINO.toUpperCase()));
                //売上明細No
                vo.setUrmeino((String) result.get(OrderDiffListLionVO.URMEINO.toUpperCase()));
                //件名
                vo.setKknamekj((String) result.get(OrderDiffListLionVO.KKNAMEKJ.toUpperCase()));
                //業務区分コード
                vo.setGyomkbn((String) result.get(OrderDiffListLionVO.GYOMKBN.toUpperCase()));
                //業務区分名称
                vo.setGyomkbnkj((String) result.get(OrderDiffListLionVO.GYOMKBNKJ.toUpperCase()));
                //媒体区分
                vo.setBaitaikbn((String) result.get(OrderDiffListLionVO.BAITAIKBN.toUpperCase()));
                //ブランドコード
                vo.setBrandcd((String) result.get(OrderDiffListLionVO.BRANDCD.toUpperCase()));
                //ブランド名称
                vo.setBrandnm((String) result.get(OrderDiffListLionVO.BRANDNM.toUpperCase()));
                //明細請求金額合計
                vo.setSeigak2((BigDecimal) result.get(OrderDiffListLionVO.SEIGAK2.toUpperCase()));
                //明細消費税額合計
                vo.setSzeigak2((BigDecimal) result.get(OrderDiffListLionVO.SZEIGAK2.toUpperCase()));
                //SEQ
                vo.setSeq((String) result.get(OrderDiffListLionVO.SEQ.toUpperCase()));

            } else if (_sqlMode.equals(SqlMode.AMOUNTDIFF)) {
                //金額差異受注

                //受注No
                vo.setJyutno((String) result.get(OrderDiffListLionVO.JYUTNO.toUpperCase()));
                //受注明細No
                vo.setJymeino((String) result.get(OrderDiffListLionVO.JYMEINO.toUpperCase()));
                //売上明細No
                vo.setUrmeino((String) result.get(OrderDiffListLionVO.URMEINO.toUpperCase()));
                //件名
                vo.setKknamekj((String) result.get(OrderDiffListLionVO.KKNAMEKJ.toUpperCase()));
                //業務区分コード
                vo.setGyomkbn((String) result.get(OrderDiffListLionVO.GYOMKBN.toUpperCase()));
                //業務区分名称
                vo.setGyomkbnkj((String) result.get(OrderDiffListLionVO.GYOMKBNKJ.toUpperCase()));
                //媒体区分
                vo.setBaitaikbn((String) result.get(OrderDiffListLionVO.BAITAIKBN.toUpperCase()));
                //ブランドコード
                vo.setBrandcd((String) result.get(OrderDiffListLionVO.BRANDCD.toUpperCase()));
                //ブランド名称
                vo.setBrandnm((String) result.get(OrderDiffListLionVO.BRANDNM.toUpperCase()));
                //請求金額
                vo.setSeigak((BigDecimal) result.get(OrderDiffListLionVO.SEIGAK.toUpperCase()));
                //明細請求金額合計
                vo.setSeigak2((BigDecimal) result.get(OrderDiffListLionVO.SEIGAK2.toUpperCase()));
                //消費税額
                vo.setSzeigak((BigDecimal) result.get(OrderDiffListLionVO.SZEIGAK.toUpperCase()));
                //明細消費税額合計
                vo.setSzeigak2((BigDecimal) result.get(OrderDiffListLionVO.SZEIGAK2.toUpperCase()));
                //SEQ
                vo.setSeq((String) result.get(OrderDiffListLionVO.SEQ.toUpperCase()));
            }

            //検索結果直後の状態にする
            ModelUtils.copyMemberSearchAfterInstace(vo);
            list.add(vo);
        }

        return list;
    }

}

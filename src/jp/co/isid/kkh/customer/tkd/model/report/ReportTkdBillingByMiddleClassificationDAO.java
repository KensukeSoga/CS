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
 * ���c�������ׁi�����ޕʁj�擾DAO
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/01/23 JSE Hitoshi Sasaki)<BR>
 * </P>
 *
 * @author JSE Hitoshi Sasaki
 */
public class ReportTkdBillingByMiddleClassificationDAO extends AbstractRdbDao {

    /** �ėp�}�X�^�������� */
    private ReportTkdBillingByMiddleClassificationCondition _cond;

    /** �T�C�g�P�Q�O or �T�C�g�R�O */
    private static final String SITE_TYPE_120_OR_30 = "0";

    /** �T�C�g���̑� */
    private static final String SITE_TYPE_OTHER = "1";

    /**
     * �f�t�H���g�R���X�g���N�^�B
     */
    public ReportTkdBillingByMiddleClassificationDAO() {
        super.setPoolConnectClass(KKHPoolConnect.class);
        super.setDBModelInterface(KKHOracleModel.getInstance());
        super.setBigDecimalMode(true);
    }

    /**
     * �v���C�}���L�[��Ԃ��܂��B
     *
     * @return String[] �v���C�}���L�[
     */
    @Override
    public String[] getPrimryKeyNames() {
        return null;
    }

    /**
     * �X�V���t�t�B�[���h��Ԃ��܂��B
     *
     * @return String �X�V���t�t�B�[���h
     */
    public String getTimeStampKeyName() {
        return null;
    }

    /**
     * �e�[�u������Ԃ��܂��B
     *
     * @return String �e�[�u����
     */
    @Override
    public String getTableName() {
        return null;
    }

    /**
     * �e�[�u���񖼂�Ԃ��܂��B
     *
     * @return String[] �e�[�u����
     */
    @Override
    public String[] getTableColumnNames() {
        return null;
    }

    /**
     * �f�t�H���g��SQL����Ԃ��܂��B
     *
     * @return String SQL��
     */
    @Override
    public String getSelectSQL() {
        return getSelectSQLForItem();
    }

    private String getSelectSQLForItem() {

        StringBuffer sql = new StringBuffer();

        if (_cond.getKbn().equals(SITE_TYPE_120_OR_30)) {
            // �ʏ�
            sql.append("SELECT ");
            sql.append("    1 AS SQLNO, ");
            sql.append("    " + TBTHB2KMEI.CODE1 + ", ");
            sql.append("    " + TBTHB2KMEI.DATE1 + ", ");
            sql.append("    " + TBTHB2KMEI.CODE5 + ", ");
            sql.append("    " + TBTHB2KMEI.NAME4 + ", ");
            sql.append("    MST01." + TBTHBAMST.INTVALUE1 + " AS CYBNO, ");
            sql.append("    RTRIM(" + TBTHB2KMEI.NAME10 + ") AS " + TBTHB2KMEI.NAME10 + ", ");
            sql.append("    " + TBTHB2KMEI.CODE2 + ", ");
            sql.append("    MST02." + TBTHBAMST.INTVALUE1 + " AS BAINO, ");
            sql.append("    TO_CHAR(" + TBTHB2KMEI.KNGK1 + ",'9999') AS RENNO, ");
            sql.append("    " + TBTHB2KMEI.NAME2 + ", ");
            sql.append("    " + TBTHB2KMEI.CODE3 + ", ");
            sql.append("    MST03." + TBTHBAMST.INTVALUE1 + " AS HINNO, ");
            sql.append("    " + TBTHB2KMEI.KBN2 + ", ");
            sql.append("    " + TBTHB2KMEI.RITU1 + ", ");
            sql.append("    sum(" + TBTHB2KMEI.SEIGAK + ") AS " + TBTHB2KMEI.SEIGAK + ", ");
            sql.append("    " + TBTHB2KMEI.CODE4 + ", ");
            sql.append("    RTRIM(" + TBTHB2KMEI.NAME8 + ") AS " + TBTHB2KMEI.NAME8 + " ");
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
            sql.append("        TRIM(" + TBTHBAMST.FIELD2 + ") AS " + TBTHBAMST.FIELD2 + ", ");
            sql.append("        " + TBTHBAMST.FIELD5 + ", ");
            sql.append("        " + TBTHBAMST.FIELD1 + ", ");
            sql.append("        " + TBTHBAMST.INTVALUE1 + " ");
            sql.append("    FROM ");
            sql.append("        " + TBTHBAMST.TBNAME + " ");
            sql.append("    WHERE ");
            sql.append("        " + TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND ");
            sql.append("        " + TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND ");
            sql.append("        " + TBTHBAMST.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND ");
            sql.append("        " + TBTHBAMST.SYBT + " = '203' ");
            sql.append("    ORDER BY ");
            sql.append("        " + TBTHBAMST.INTVALUE1 + " ");
            sql.append("    ) MST02, ");
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
            sql.append("    ) MST03 ");
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
            sql.append("    TRIM(" + TBTHB2KMEI.CODE2 + ") = TRIM(MST02." + TBTHBAMST.FIELD2 + "(+)) AND ");
            sql.append("    TRIM(" + TBTHB2KMEI.CODE3 + ") = TRIM(MST03." + TBTHBAMST.FIELD1 + "(+)) AND ");
            sql.append("    " + TBTHB2KMEI.CODE2 + " NOT IN ('FEE01', 'FEE02') AND ");
            sql.append("    " + TBTHB2KMEI.CODE4 + " IN ('120', '30' ) ");
            sql.append("GROUP BY ");
            sql.append("    " + TBTHB2KMEI.CODE1 + ", ");
            sql.append("    " + TBTHB2KMEI.DATE1 + ", ");
            sql.append("    " + TBTHB2KMEI.CODE5 + ", ");
            sql.append("    " + TBTHB2KMEI.NAME4 + ", ");
            sql.append("    " + TBTHB2KMEI.NAME10 + ", ");
            sql.append("    " + TBTHB2KMEI.CODE2 + ", ");
            sql.append("    " + TBTHB2KMEI.KNGK1 + ", ");
            sql.append("    " + TBTHB2KMEI.NAME2 + ", ");
            sql.append("    " + TBTHB2KMEI.CODE3 + ", ");
            sql.append("    " + TBTHB2KMEI.KBN2 + ", ");
            sql.append("    " + TBTHB2KMEI.RITU1 + ", ");
            sql.append("    " + TBTHB2KMEI.CODE4 + ", ");
            sql.append("    " + TBTHB2KMEI.NAME8 + ", ");
            sql.append("    MST01." + TBTHBAMST.INTVALUE1 + ", ");
            sql.append("    MST02." + TBTHBAMST.INTVALUE1 + ", ");
            sql.append("    MST03." + TBTHBAMST.INTVALUE1 + " ");
            sql.append("UNION  ");
            sql.append("SELECT ");
            sql.append("    2 AS SQLNO, ");
            sql.append("    " + TBTHB2KMEI.CODE1 + ", ");
            sql.append("    " + TBTHB2KMEI.DATE1 + ", ");
            sql.append("    " + TBTHB2KMEI.CODE5 + ", ");
            sql.append("    " + TBTHB2KMEI.NAME4 + ", ");
            sql.append("    MST01." + TBTHBAMST.INTVALUE1 + " AS CYBNO, ");
            sql.append("    RTRIM(" + TBTHB2KMEI.NAME10 + "), ");
            sql.append("    " + TBTHB2KMEI.CODE2 + ", ");
            sql.append("    MST02." + TBTHBAMST.INTVALUE1 + " AS BAINO, ");
            sql.append("    TO_CHAR(" + TBTHB2KMEI.KNGK1 + ",'9999') AS RENNO, ");
            sql.append("    " + TBTHB2KMEI.NAME2 + ", ");
            sql.append("    " + TBTHB2KMEI.CODE3 + ", ");
            sql.append("    MST03." + TBTHBAMST.INTVALUE1 + " AS HINNO, ");
            sql.append("    " + TBTHB2KMEI.KBN2 + ", ");
            sql.append("    " + TBTHB2KMEI.RITU1 + ", ");
            sql.append("    sum(" + TBTHB2KMEI.SEIGAK + "), ");
            sql.append("    " + TBTHB2KMEI.CODE4 + ", ");
            sql.append("    RTRIM(" + TBTHB2KMEI.NAME8 + ") ");
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
            sql.append("        TRIM(" + TBTHBAMST.FIELD2 + ") AS " + TBTHBAMST.FIELD2 + ", ");
            sql.append("        " + TBTHBAMST.FIELD5 + ", ");
            sql.append("        " + TBTHBAMST.FIELD1 + ", ");
            sql.append("        " + TBTHBAMST.INTVALUE1 + " ");
            sql.append("    FROM ");
            sql.append("        " + TBTHBAMST.TBNAME + " ");
            sql.append("    WHERE ");
            sql.append("        " + TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND ");
            sql.append("        " + TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND ");
            sql.append("        " + TBTHBAMST.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND ");
            sql.append("        " + TBTHBAMST.SYBT + " = '203' ");
            sql.append("    ORDER BY ");
            sql.append("        " + TBTHBAMST.INTVALUE1 + " ");
            sql.append("    ) MST02, ");
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
            sql.append("    ) MST03 ");
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
            sql.append("    TRIM(" + TBTHB2KMEI.CODE2 + ") = TRIM(MST02." + TBTHBAMST.FIELD2 + "(+)) AND ");
            sql.append("    TRIM(" + TBTHB2KMEI.CODE3 + ") = TRIM(MST03." + TBTHBAMST.FIELD1 + "(+)) AND ");
            sql.append("    " + TBTHB2KMEI.CODE2 + " IN ('FEE01', 'FEE02') AND ");
            sql.append("    " + TBTHB2KMEI.CODE4 + " IN ('120', '30' ) ");
            sql.append("GROUP BY ");
            sql.append("    " + TBTHB2KMEI.CODE1 + ", ");
            sql.append("    " + TBTHB2KMEI.DATE1 + ", ");
            sql.append("    " + TBTHB2KMEI.CODE5 + ", ");
            sql.append("    " + TBTHB2KMEI.NAME4 + ", ");
            sql.append("    " + TBTHB2KMEI.NAME10 + ", ");
            sql.append("    " + TBTHB2KMEI.CODE2 + ", ");
            sql.append("    " + TBTHB2KMEI.KNGK1 + ", ");
            sql.append("    " + TBTHB2KMEI.NAME2 + ", ");
            sql.append("    " + TBTHB2KMEI.CODE3 + ", ");
            sql.append("    " + TBTHB2KMEI.KBN2 + ", ");
            sql.append("    " + TBTHB2KMEI.RITU1 + ", ");
            sql.append("    " + TBTHB2KMEI.CODE4 + ", ");
            sql.append("    " + TBTHB2KMEI.NAME8 + ", ");
            sql.append("    MST01." + TBTHBAMST.INTVALUE1 + ", ");
            sql.append("    MST02." + TBTHBAMST.INTVALUE1 + ", ");
            sql.append("    MST03." + TBTHBAMST.INTVALUE1 + " ");
            sql.append("ORDER BY ");
            sql.append("    " + TBTHB2KMEI.CODE4 + ", ");
            sql.append("    CYBNO, ");
            sql.append("    SQLNO, ");
            sql.append("    RENNO, ");
            sql.append("    HINNO, ");
            sql.append("    BAINO ");
        } else if (_cond.getKbn().equals(SITE_TYPE_OTHER)) {
            // ���̑�
            sql.append("SELECT ");
            sql.append("    1 AS SQLNO, ");
            sql.append("    " + TBTHB2KMEI.CODE1 + ", ");
            sql.append("    " + TBTHB2KMEI.DATE1 + ", ");
            sql.append("    " + TBTHB2KMEI.CODE5 + ", ");
            sql.append("    " + TBTHB2KMEI.NAME4 + ", ");
            sql.append("    MST01." + TBTHBAMST.INTVALUE1 + " AS CYBNO, ");
            sql.append("    RTRIM(" + TBTHB2KMEI.NAME10 + ") AS " + TBTHB2KMEI.NAME10 + ", ");
            sql.append("    " + TBTHB2KMEI.CODE2 + ", ");
            sql.append("    MST02." + TBTHBAMST.INTVALUE1 + " AS BAINO, ");
            sql.append("    TO_CHAR(" + TBTHB2KMEI.KNGK1 + ",'9999') AS RENNO, ");
            sql.append("    " + TBTHB2KMEI.NAME2 + ", ");
            sql.append("    " + TBTHB2KMEI.CODE3 + ", ");
            sql.append("    MST03." + TBTHBAMST.INTVALUE1 + " AS HINNO, ");
            sql.append("    " + TBTHB2KMEI.KBN2 + ", ");
            sql.append("    " + TBTHB2KMEI.RITU1 + ", ");
            sql.append("    sum(" + TBTHB2KMEI.SEIGAK + ") AS " + TBTHB2KMEI.SEIGAK + ", ");
            sql.append("    " + TBTHB2KMEI.CODE4 + ", ");
            sql.append("    RTRIM(" + TBTHB2KMEI.NAME8 + ") AS " + TBTHB2KMEI.NAME8 + " ");
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
            sql.append("        TRIM(" + TBTHBAMST.FIELD2 + ") AS " + TBTHBAMST.FIELD2 + ", ");
            sql.append("        " + TBTHBAMST.FIELD5 + ", ");
            sql.append("        " + TBTHBAMST.FIELD1 + ", ");
            sql.append("        " + TBTHBAMST.INTVALUE1 + " ");
            sql.append("    FROM ");
            sql.append("        " + TBTHBAMST.TBNAME + " ");
            sql.append("    WHERE ");
            sql.append("        " + TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND ");
            sql.append("        " + TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND ");
            sql.append("        " + TBTHBAMST.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' ");
            sql.append("    ORDER BY ");
            sql.append("        " + TBTHBAMST.INTVALUE1 + " ");
            sql.append("    ) MST02, ");
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
            sql.append("    ) MST03 ");
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
            sql.append("    TRIM(" + TBTHB2KMEI.CODE2 + ") = TRIM(MST02." + TBTHBAMST.FIELD2 + "(+)) AND ");
            sql.append("    TRIM(" + TBTHB2KMEI.CODE3 + ") = TRIM(MST03." + TBTHBAMST.FIELD1 + "(+)) AND ");
            sql.append("    " + TBTHB2KMEI.CODE2 + " NOT IN ('FEE01', 'FEE02') AND ");
            sql.append("    " + TBTHB2KMEI.CODE4 + " NOT IN ('120', '30' ) ");
            sql.append("GROUP BY ");
            sql.append("    " + TBTHB2KMEI.CODE1 + ", ");
            sql.append("    " + TBTHB2KMEI.DATE1 + ", ");
            sql.append("    " + TBTHB2KMEI.CODE5 + ", ");
            sql.append("    " + TBTHB2KMEI.NAME4 + ", ");
            sql.append("    " + TBTHB2KMEI.NAME10 + ", ");
            sql.append("    " + TBTHB2KMEI.CODE2 + ", ");
            sql.append("    " + TBTHB2KMEI.KNGK1 + ", ");
            sql.append("    " + TBTHB2KMEI.NAME2 + ", ");
            sql.append("    " + TBTHB2KMEI.CODE3 + ", ");
            sql.append("    " + TBTHB2KMEI.KBN2 + ", ");
            sql.append("    " + TBTHB2KMEI.RITU1 + ", ");
            sql.append("    " + TBTHB2KMEI.SEIGAK + ", ");
            sql.append("    " + TBTHB2KMEI.CODE4 + ", ");
            sql.append("    " + TBTHB2KMEI.NAME8 + ", ");
            sql.append("    MST01." + TBTHBAMST.INTVALUE1 + ", ");
            sql.append("    MST02." + TBTHBAMST.INTVALUE1 + ", ");
            sql.append("    MST03." + TBTHBAMST.INTVALUE1 + " ");
            sql.append("UNION  ");
            sql.append("SELECT ");
            sql.append("    2 AS SQLNO, ");
            sql.append("    " + TBTHB2KMEI.CODE1 + ", ");
            sql.append("    " + TBTHB2KMEI.DATE1 + ", ");
            sql.append("    " + TBTHB2KMEI.CODE5 + ", ");
            sql.append("    " + TBTHB2KMEI.NAME4 + ", ");
            sql.append("    MST01." + TBTHBAMST.INTVALUE1 + " AS CYBNO, ");
            sql.append("    RTRIM(" + TBTHB2KMEI.NAME10 + "), ");
            sql.append("    " + TBTHB2KMEI.CODE2 + ", ");
            sql.append("    MST02." + TBTHBAMST.INTVALUE1 + " AS BAINO, ");
            sql.append("    TO_CHAR(" + TBTHB2KMEI.KNGK1 + ",'9999') AS RENNO, ");
            sql.append("    " + TBTHB2KMEI.NAME2 + ", ");
            sql.append("    " + TBTHB2KMEI.CODE3 + ", ");
            sql.append("    MST03." + TBTHBAMST.INTVALUE1 + " AS HINNO, ");
            sql.append("    " + TBTHB2KMEI.KBN2 + ", ");
            sql.append("    " + TBTHB2KMEI.RITU1 + ", ");
            sql.append("    sum(" + TBTHB2KMEI.SEIGAK + "), ");
            sql.append("    " + TBTHB2KMEI.CODE4 + ", ");
            sql.append("    RTRIM(" + TBTHB2KMEI.NAME8 + ") ");
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
            sql.append("        TRIM(" + TBTHBAMST.FIELD2 + ") AS " + TBTHBAMST.FIELD2 + ", ");
            sql.append("        " + TBTHBAMST.FIELD5 + ", ");
            sql.append("        " + TBTHBAMST.FIELD1 + ", ");
            sql.append("        " + TBTHBAMST.INTVALUE1 + " ");
            sql.append("    FROM ");
            sql.append("        " + TBTHBAMST.TBNAME + " ");
            sql.append("    WHERE ");
            sql.append("        " + TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND ");
            sql.append("        " + TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND ");
            sql.append("        " + TBTHBAMST.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND ");
            sql.append("        " + TBTHBAMST.SYBT + " = '203' ");
            sql.append("    ORDER BY ");
            sql.append("        " + TBTHBAMST.INTVALUE1 + " ");
            sql.append("    ) MST02, ");
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
            sql.append("    ) MST03 ");
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
            sql.append("    TRIM(" + TBTHB2KMEI.CODE2 + ") = TRIM(MST02." + TBTHBAMST.FIELD2 + "(+)) AND ");
            sql.append("    TRIM(" + TBTHB2KMEI.CODE3 + ") = TRIM(MST03." + TBTHBAMST.FIELD1 + "(+)) AND ");
            sql.append("    " + TBTHB2KMEI.CODE2 + " IN ('FEE01', 'FEE02') AND ");
            sql.append("    " + TBTHB2KMEI.CODE4 + " NOT IN ('120', '30' ) ");
            sql.append("GROUP BY ");
            sql.append("    " + TBTHB2KMEI.CODE1 + ", ");
            sql.append("    " + TBTHB2KMEI.DATE1 + ", ");
            sql.append("    " + TBTHB2KMEI.CODE5 + ", ");
            sql.append("    " + TBTHB2KMEI.NAME4 + ", ");
            sql.append("    " + TBTHB2KMEI.NAME10 + ", ");
            sql.append("    " + TBTHB2KMEI.CODE2 + ", ");
            sql.append("    " + TBTHB2KMEI.KNGK1 + ", ");
            sql.append("    " + TBTHB2KMEI.NAME2 + ", ");
            sql.append("    " + TBTHB2KMEI.CODE3 + ", ");
            sql.append("    " + TBTHB2KMEI.KBN2 + ", ");
            sql.append("    " + TBTHB2KMEI.RITU1 + ", ");
            sql.append("    " + TBTHB2KMEI.SEIGAK + ", ");
            sql.append("    " + TBTHB2KMEI.CODE4 + ", ");
            sql.append("    " + TBTHB2KMEI.NAME8 + ", ");
            sql.append("    MST01." + TBTHBAMST.INTVALUE1 + ", ");
            sql.append("    MST02." + TBTHBAMST.INTVALUE1 + ", ");
            sql.append("    MST03." + TBTHBAMST.INTVALUE1 + " ");
            sql.append("ORDER BY ");
            sql.append("    CYBNO, ");
            sql.append("    SQLNO, ");
            sql.append("    RENNO, ");
            sql.append("    HINNO, ");
            sql.append("    BAINO ");
        }

        return sql.toString();
    }

    /**
     * ���[�f�[�^�iTOH)�̌������s���܂��B
     *
     * @return �ėp�e�[�u���}�X�^VO���X�g
     * @throws UserException
     *             �f�[�^�A�N�Z�X���ɃG���[�����������ꍇ�B
     */
    @SuppressWarnings("unchecked")
    public List<ReportTkdBillingByMiddleClassificationVO> findReportTkdBillingByCondition(ReportTkdBillingByMiddleClassificationCondition cond) throws KKHException {

        super.setModel(new ReportTkdBillingByMiddleClassificationVO());

        try {
            _cond = cond;
            return super.find();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0002");
        }
    }

    /**
     * Model�̐������s��<br>
     * �������ʂ�VO��KEY���啶���̂��ߕϊ��������s��<br>
     * AbstractRdbDao��createFindedModelInstances���I�[�o�[���C�h<br>
     *
     * @param hashList
     *            List ��������
     * @return List<CommonCodeMasterVO> �ϊ���̌�������
     */
    @Override
    protected List<ReportTkdBillingByMiddleClassificationVO> createFindedModelInstances(List hashList) {
        List<ReportTkdBillingByMiddleClassificationVO> list = new ArrayList<ReportTkdBillingByMiddleClassificationVO>();
        if (getModel() instanceof ReportTkdBillingByMiddleClassificationVO) {
            for (int i = 0; i < hashList.size(); i++) {
                Map result = (Map) hashList.get(i);
                ReportTkdBillingByMiddleClassificationVO vo = new ReportTkdBillingByMiddleClassificationVO();

                vo.setSQLNO((BigDecimal) result.get(ReportTkdBillingByMiddleClassificationVO.SQLNO.toUpperCase()));
                vo.setStrDairitenCD((String) result.get(TBTHB2KMEI.CODE1.toUpperCase()));
                vo.setStrYM((String) result.get(TBTHB2KMEI.DATE1.toUpperCase()));
                vo.setStrCYBNCD((String) result.get(TBTHB2KMEI.CODE5.toUpperCase()));
                vo.setStrCYBNNM((String) result.get(TBTHB2KMEI.NAME4.toUpperCase()));
                vo.setCYBNO((BigDecimal) result.get(ReportTkdBillingByMiddleClassificationVO.CYBNO.toUpperCase()));
                vo.setStrKBTNM((String) result.get(TBTHB2KMEI.NAME10.toUpperCase()));
                vo.setStrKBTCD((String) result.get(TBTHB2KMEI.CODE2.toUpperCase()));
                vo.setBAINO((BigDecimal) result.get(ReportTkdBillingByMiddleClassificationVO.BAINO.toUpperCase()));
                vo.setRENNO((String) result.get(ReportTkdBillingByMiddleClassificationVO.RENNO.toUpperCase()));
                vo.setStrHinmokuNM((String) result.get(TBTHB2KMEI.NAME2.toUpperCase()));
                vo.setStrHinmokuCD((String) result.get(TBTHB2KMEI.CODE3.toUpperCase()));
                vo.setHINNO((BigDecimal) result.get(ReportTkdBillingByMiddleClassificationVO.HINNO.toUpperCase()));
                vo.setStrKanriKBN((String) result.get(TBTHB2KMEI.KBN2.toUpperCase()));
                vo.setIntHaibunHiritsu((BigDecimal) result.get(TBTHB2KMEI.RITU1.toUpperCase()));
                vo.setCurHaifugaku((BigDecimal) result.get(TBTHB2KMEI.SEIGAK.toUpperCase()));
                vo.setStrSite((String) result.get(TBTHB2KMEI.CODE4.toUpperCase()));
                vo.setStrBiko((String) result.get(TBTHB2KMEI.NAME8.toUpperCase()));

                // �������ʒ���̏�Ԃɂ���
                ModelUtils.copyMemberSearchAfterInstace(vo);
                list.add(vo);
            }
        }

        return list;
    }

}

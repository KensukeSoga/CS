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
 * ���C�I�����[(���쎺���X�g)����DAO
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2014/07/31 HLC S.Fujimoto)<BR>
 * </P>
 *
 * @author HLC S.Fujimoto
 */

public class AddChangeReportLionSeisakuDAO extends AbstractRdbDao {

    /** ���C�I�����[(���쎺���X�g)�������� */
    AddChangeReportLionSeisakuCondition _cond = null;
    /** ���C�I�����[(���쎺���X�g)VO */
    AddChangeReportLionSeisakuVO _vo = null;

    /**
     *  getSelectSQL�Ŕ��s����SQL���[�h
     */
    /** �����^�C���X�^���v */
    private static final String RRKTIMSTMP = "RRKTIMSTMP";
    /** ���쎺���X�g(AD1) */
    private static final String SEISAKUAD1 = "SEISAKUAD1";
    /** ���쎺���X�g(AD2) */
    private static final String SEISAKUAD2 = "SEISAKUAD2";
    /** ���쎺���X�g(AD1/AD2����) */
    private static final String SEISAKUDIFF = "SEISAKUDIFF";

    //�f�t�H���gSQL���[�h
    String _sqlMode = RRKTIMSTMP;

    /** �C�����C���r���[(AD1) */
    private static final String VWNAME_AD1 = "AD1";
    /** �C�����C���r���[(AD2) */
    private static final String VWNAME_AD2 = "AD2";

    /**
     * �}�̋敪
     */
    /** ���� */
    private static final String SEISAKU = "012";

    /**
     * �ύX�_
     */
    /** �敪�ύX */
    private static final String CHGPNT_BAITAIKBN = "01";
    /** �R�[�h�ύX */
    private static final String CHGPNT_BRDCD = "02";
    /** �����ύX */
    private static final String CHGPNT_KENNM = "03";
    /** ���z�ύX */
    private static final String CHGPNT_SEIGAK = "04";
    /** �敪�ύX�A�R�[�h�ύX */
    private static final String CHGPNT_BAITAIKBN_BRDCD = "05";
    /** �敪�ύX�A�����ύX */
    private static final String CHGPNT_BAITAIKBN_KENNM = "06";
    /** �敪�ύX�A���z�ύX */
    private static final String CHGPNT_BAITAIKBN_SEIGAK = "07";
    /** �R�[�h�ύX�A�����ύX */
    private static final String CHGPNT_BRDCD_KENNM = "08";
    /** �R�[�h�ύX�A���z�ύX */
    private static final String CHGPNT_BRDCD_SEIGAK = "09";
    /** �����ύX�A���z�ύX */
    private static final String CHGPNT_KENNM_SEIGAK = "10";
    /** �敪�ύX�A�����ύX�A���z�ύX */
    private static final String CHGPNT_BAITAIKBN_KENNM_SEIGAK = "11";
    /** �敪�ύX�A�R�[�h�ύX�A���z�ύX */
    private static final String CHGPNT_BAITAIKBN_BRDCD_SEIGAK = "12";
    /** �敪�ύX�A�R�[�h�ύX�A�����ύX */
    private static final String CHGPNT_BAITAIKBN_BRDCD_KENNM = "13";
    /** �R�[�h�ύX�A�����ύX�A���z�ύX */
    private static final String CHGPNT_BRDCD_KENNM_SEIGAK = "14";
    /** �敪�ύX�A�R�[�h�ύX�A�����ύX�A���z�ύX */
    private static final String CHGPNT_ALL = "15";

    /**
     * �f�t�H���g�R���X�g���N�^�B
     */
    public AddChangeReportLionSeisakuDAO() {
        super.setPoolConnectClass(KKHPoolConnect.class);
        super.setDBModelInterface(KKHOracleModel.getInstance());
        super.setBigDecimalMode(true);
    }

    /**
     * �v���C�}���L�[��Ԃ��܂��B
     * @return String[] �v���C�}���L�[
     */
    @Override
    public String[] getPrimryKeyNames() {
        return null;
    }

    /**
     * �X�V���t�t�B�[���h��Ԃ��܂��B
     * @return String �X�V���t�t�B�[���h
     */
    public String getTimeStampKeyName() {
        return null;
    }

    /**
     * �e�[�u������Ԃ��܂��B
     * @return String �e�[�u����
     */
    @Override
    public String getTableName() {
        return TBTHB91RRKDOWN.TBNAME;
    }

    /**
     * �e�[�u���񖼂�Ԃ��܂��B
     * @return String[] �e�[�u����
     */
    @Override
    public String[] getTableColumnNames() {
        return null;
    }

    /**
     * SQL������
     */
    public String getSelectSQL() {

        String sql = "";

        //�����^�C���X�^���v�̏ꍇ
        if (_sqlMode.equals(RRKTIMSTMP)) {
            sql = getSelectSQLRrkTimStmp();
        }
        //���쎺���X�g(AD1)�̏ꍇ
        else if (_sqlMode.equals(SEISAKUAD1)) {
            sql = getSelectSQLAD2Seisaku();
        }
        //���쎺���X�g(AD2)�̏ꍇ
        else if (_sqlMode.equals(SEISAKUAD2)) {
            if (_cond.getRrkTimStmp() == null) {
                sql = getSelectSQLAD2Seisaku();
            } else {
                sql = getSelectSQLAD1Seisaku();
            }
        }
        //���쎺���X�g(AD1/AD2����)�̏ꍇ
        else if (_sqlMode.equals(SEISAKUDIFF)) {
            sql = getSelectSQLSeisakuDiff();
        }
        else {
            sql = "";
        }

        return sql;
    }

    /**
     * ��������擾SQL������
     * @return SQL��
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
     * ���쎺���X�g(AD1)�擾SQL������
     * @return SQL��
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
     * ���쎺���X�g(AD2)�擾SQL������
     * @return SQL��
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
     * ���쎺���X�g(AD1/AD2����)�擾SQL������
     * @return SQL��
     */
    private String getSelectSQLSeisakuDiff() {

        //SQL��
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

        //�ǉ�
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

        //�폜
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

        //�ύX
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
     * ���C�I�����쎺���X�g�f�[�^�̌������s���܂��B
     * @param cond ���C�I�����[(���쎺���X�g�E�ǉ��ύX���X�g)��������
     * @return ���C�I�����쎺���X�g�f�[�^�擾VO���X�g
     * @throws KKHException �f�[�^�A�N�Z�X���ɃG���[�����������ꍇ
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
     * ���C�I�����쎺���X�g�����f�[�^�̌������s���܂��B
     * @param cond ���C�I�����[(���쎺���X�g�E�ǉ��ύX���X�g)��������
     * @return ���C�I�����쎺���X�g�f�[�^�擾VO���X�g
     * @throws KKHException �f�[�^�A�N�Z�X���ɃG���[�����������ꍇ
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
     * Model�̐������s��<br>
     * �������ʂ�VO��KEY���啶���̂��ߕϊ��������s��<br>
     * AbstractRdbDao��createFindedModelInstances���I�[�o�[���C�h<br>
     *
     * @param hashList List ��������
     * @return List<AddChangeReportLionSeisakuVO> �ϊ���̌�������
     */
    @Override
    protected List<AddChangeReportLionSeisakuVO> createFindedModelInstances(List hashList) {
        List<AddChangeReportLionSeisakuVO> list = new ArrayList<AddChangeReportLionSeisakuVO>();
        for (int i = 0; i < hashList.size(); i++) {
            Map result = (Map) hashList.get(i);
            AddChangeReportLionSeisakuVO vo = new AddChangeReportLionSeisakuVO();

            //�����^�C���X�^���v�̏ꍇ
            if (_sqlMode.equals(RRKTIMSTMP)) {
                //�����^�C���X�^���v
                vo.setRrkTimStmp((String) result.get(AddChangeReportLionSeisakuVO.RRKTIMSTMP.toUpperCase()));
            }
            //���쎺���X�g(AD1)�̏ꍇ
            else if (_sqlMode.equals(SEISAKUAD1)) {
                //��No
                vo.setJyutno((String) result.get(AddChangeReportLionSeisakuVO.JYUTNO.toUpperCase()));
                //�󒍖���No
                vo.setJymeino((String) result.get(AddChangeReportLionSeisakuVO.JYMEINO.toUpperCase()));
                //���㖾��No
                vo.setUrmeino((String) result.get(AddChangeReportLionSeisakuVO.URMEINO.toUpperCase()));
                //�}�̋敪�R�[�h
                vo.setBaitaiKbn((String) result.get(AddChangeReportLionSeisakuVO.BAITAIKBN.toUpperCase()));
                //�}�̋敪��
                vo.setBaitaiNm((String) result.get(AddChangeReportLionSeisakuVO.BAITAINM.toUpperCase()));
                //�u�����h�R�[�h
                vo.setBrdCd((String) result.get(AddChangeReportLionSeisakuVO.BRDCD.toUpperCase()));
                //�u�����h��
                vo.setBrdNm((String) result.get(AddChangeReportLionSeisakuVO.BRDNM.toUpperCase()));
                //����
                vo.setKenNm((String) result.get(AddChangeReportLionSeisakuVO.KENNM.toUpperCase()));
                //�������z
                vo.setSeigak((BigDecimal) result.get(AddChangeReportLionSeisakuVO.SEIGAK.toUpperCase()));
                //����Ŋz
                vo.setTaxAmt((BigDecimal) result.get(AddChangeReportLionSeisakuVO.TAXAMT.toUpperCase()));
            }
            //���쎺���X�g(AD2)�̏ꍇ
            else if (_sqlMode.equals(SEISAKUAD2)) {
                //��No
                vo.setJyutno((String) result.get(AddChangeReportLionSeisakuVO.JYUTNO.toUpperCase()));
                //�󒍖���No
                vo.setJymeino((String) result.get(AddChangeReportLionSeisakuVO.JYMEINO.toUpperCase()));
                //���㖾��No
                vo.setUrmeino((String) result.get(AddChangeReportLionSeisakuVO.URMEINO.toUpperCase()));
                //�}�̋敪�R�[�h
                vo.setBaitaiKbn((String) result.get(AddChangeReportLionSeisakuVO.BAITAIKBN.toUpperCase()));
                //�}�̋敪��
                vo.setBaitaiNm((String) result.get(AddChangeReportLionSeisakuVO.BAITAINM.toUpperCase()));
                //�u�����h�R�[�h
                vo.setBrdCd((String) result.get(AddChangeReportLionSeisakuVO.BRDCD.toUpperCase()));
                //�u�����h��
                vo.setBrdNm((String) result.get(AddChangeReportLionSeisakuVO.BRDNM.toUpperCase()));
                //����
                vo.setKenNm((String) result.get(AddChangeReportLionSeisakuVO.KENNM.toUpperCase()));
                //�������z
                vo.setSeigak((BigDecimal) result.get(AddChangeReportLionSeisakuVO.SEIGAK.toUpperCase()));
                //����Ŋz
                vo.setTaxAmt((BigDecimal) result.get(AddChangeReportLionSeisakuVO.TAXAMT.toUpperCase()));
            }
            //���쎺���X�g�����̏ꍇ
            else if (_sqlMode.equals(SEISAKUDIFF)) {
                //��No
                vo.setJyutno((String) result.get(AddChangeReportLionSeisakuVO.JYUTNO.toUpperCase()));
                //�󒍖���No
                vo.setJymeino((String) result.get(AddChangeReportLionSeisakuVO.JYMEINO.toUpperCase()));
                //���㖾��No
                vo.setUrmeino((String) result.get(AddChangeReportLionSeisakuVO.URMEINO.toUpperCase()));
                //�}�̋敪�R�[�h
                vo.setBaitaiKbn((String) result.get(AddChangeReportLionSeisakuVO.BAITAIKBN.toUpperCase()));
                //�}�̋敪��
                vo.setBaitaiNm((String) result.get(AddChangeReportLionSeisakuVO.BAITAINM.toUpperCase()));
                //�u�����h�R�[�h
                vo.setBrdCd((String) result.get(AddChangeReportLionSeisakuVO.BRDCD.toUpperCase()));
                //�u�����h��
                vo.setBrdNm((String) result.get(AddChangeReportLionSeisakuVO.BRDNM.toUpperCase()));
                //����
                vo.setKenNm((String) result.get(AddChangeReportLionSeisakuVO.KENNM.toUpperCase()));
                //�������z
                vo.setSeigak((BigDecimal) result.get(AddChangeReportLionSeisakuVO.SEIGAK.toUpperCase()));
                //����Ŋz
                vo.setTaxAmt((BigDecimal) result.get(AddChangeReportLionSeisakuVO.TAXAMT.toUpperCase()));
                //�ύX�_
                vo.setChgPnt((String) result.get(AddChangeReportLionSeisakuVO.CHGPNT.toUpperCase()));
                //SEQ
                vo.setSEQ((String) result.get(AddChangeReportLionSeisakuVO.SEQ.toUpperCase()));
            }

            //�������ʒ���̏�Ԃɂ���
            ModelUtils.copyMemberSearchAfterInstace(vo);
            list.add(vo);
        }

        return list;
    }

}

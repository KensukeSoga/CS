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
import jp.co.isid.kkh.integ.tbl.VHB_V11KYKSH_LION;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractRdbDao;
import jp.co.isid.nj.model.ModelUtils;

/**
 *
 * <P>
 * ���C�I�����[(�ǉ��ύX���X�g)����DAO
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2014/07/31 HLC S.Fujimoto)<BR>
 * </P>
 *
 * @author HLC S.Fujimoto
 */

public class AddChangeReportLionBaitaiDAO extends AbstractRdbDao {

    /** ���C�I���ǉ��ύX���X�g�f�[�^�������� */
    AddChangeReportLionBaitaiCondition _cond = null;
    /** �}�̋敪���X�g */
    List<String> _baitaiList = null;

    /**
     *  getSelectSQL�Ŕ��s����SQL���[�h
     */
    /** �����^�C���X�^���v */
    private static final String RRKTIMSTMP = "RRKTIMSTMP";
    /** �ǉ��ύX���X�g */
    private static final String BAITAI = "BAITAI";
    /** �ǉ��ύX���X�g(AD1) */
    private static final String BAITAIAD1 = "BAITAIAD1";
    /** �ǉ��ύX���X�g(AD2) */
    private static final String BAITAIAD2 = "BAITAIAD2";
    /** �ǉ��ύX���X�g(AD1/AD2�����A��������) */
    private static final String BAITAIDIFFINTERNAL = "BAITAIDIFFINTERNAL";
    /** �ǉ��ύX���X�g(AD1/AD2���� */
    private static final String BAITAIDIFF = "BAITAIDIFF";

    //�f�t�H���gSQL���[�h
    String _sqlMode = RRKTIMSTMP;

    /** �C�����C���r���[(AD1) */
    private static final String VWNAME_AD1 = "AD1";
    /** �C�����C���r���[(AD2) */
    private static final String VWNAME_AD2 = "AD2";
    /** �C�����C���r���[(RRK) */
    private static final String VWNAME_RRK = "RRK";
    /** �C�����C���r���[(INFO) */
    private static final String VWNAME_INF = "INF";

    /**
     * �}�̋敪
     */
    /** �e���r�^�C�� */
    private static final String TVTIME = "01";
    /** ���W�I�^�C�� */
    private static final String RDTIME = "04";
    /** �V�� */
    private static final String NEWSPAPER = "07";
    /** BS/CS */
    private static final String BSCS = "16";

    /** ���� */
    private static final String SEISAKU = "012";

    /**
     * �}�X�^
     */
    /** �}�̋敪�}�X�^�[ */
    private static final String BAITAI_M = "104";
    /** AD�u�����h�}�X�^ */
    private static final String BRAND_M = "201";

    /**
     * �f�t�H���g�R���X�g���N�^�B
     */
    public AddChangeReportLionBaitaiDAO() {
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
        //�ǉ��ύX���X�g(AD2)�̏ꍇ
        else if (_sqlMode.equals(BAITAI)) {
            if (_cond.getRrkTimStmp() == null) {
                _sqlMode = BAITAIAD2;
                sql = getSelectSQLAD2Baitai();
            } else {
                _sqlMode = BAITAIAD1;
                sql = getSelectSQLAD1Baitai();
            }
        }
        //�ǉ��ύX���X�g(AD1/AD2�����A��������)�̏ꍇ
        else if (_sqlMode.equals(BAITAIDIFFINTERNAL)) {
            sql = getSelectSQLBaitaiDiffInternal();
        }
        //�ǉ��ύX���X�g(AD1/AD2����)�̏ꍇ
        else if (_sqlMode.equals(BAITAIDIFF)) {
            sql = getSelectSQLBaiatiDiffExternal();
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

        //sql
        StringBuffer sql = new StringBuffer();

        sql.append("SELECT");
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
     * �ǉ��ύX���X�g(AD1)�擾SQL������
     * @return SQL��
     */
    private String getSelectSQLAD1Baitai() {

        //SQL��
        StringBuffer sql = new StringBuffer();

        sql.append("WITH");
        sql.append(" " + VWNAME_RRK);
        sql.append(" AS (");
        sql.append(" SELECT");
        sql.append(" /*+ ORDERED */");
        sql.append(" " + TBTHB92RRKKMEI.EGCD + ",");
        sql.append(" " + TBTHB92RRKKMEI.TKSKGYCD + ",");
        sql.append(" " + TBTHB92RRKKMEI.TKSBMNSEQNO + ",");
        sql.append(" " + TBTHB92RRKKMEI.TKSTNTSEQNO + ",");
        sql.append(" TRIM(" + TBTHB92RRKKMEI.CODE1 + ") " + TBTHB92RRKKMEI.CODE1 + ",");
        sql.append(" " + TBTHB92RRKKMEI.JYUTNO + " " + AddChangeReportLionBaitaiVO.AD1JYUTNO + ",");
        sql.append(" " + TBTHB92RRKKMEI.JYMEINO + " " + AddChangeReportLionBaitaiVO.AD1JYMEINO + ",");
        sql.append(" " + TBTHB92RRKKMEI.URMEINO + " " + AddChangeReportLionBaitaiVO.AD1URMEINO + ",");
        sql.append(" " + TBTHB92RRKKMEI.RENBN + " " + AddChangeReportLionBaitaiVO.AD1RENBN + ",");
        sql.append(" " + TBTHBAMST.FIELD1 + " " + AddChangeReportLionBaitaiVO.AD1BAITAIKBN + ",");
        sql.append(" " + TBTHBAMST.FIELD4 + " " + AddChangeReportLionBaitaiVO.AD1BAITAINM + ",");
        sql.append(" " + TBTHBAMST.FIELD5 + " " + AddChangeReportLionBaitaiVO.AD1BAITAISORTNO + ",");
        sql.append(" TRIM(" + TBTHB92RRKKMEI.NAME10 + ") " + AddChangeReportLionBaitaiVO.AD1KENNM + ",");
        sql.append(" " + TBTHB92RRKKMEI.SEIGAK + " " + AddChangeReportLionBaitaiVO.AD1SEIGAK + ",");
        sql.append(" TRIM(" + TBTHB92RRKKMEI.CODE2 + ") " + AddChangeReportLionBaitaiVO.AD1KYKSHCD + ",");
        sql.append(" '' " + AddChangeReportLionBaitaiVO.AD1KYKCD + ",");
        sql.append(" CASE WHEN TRIM(" + TBTHB92RRKKMEI.SONOTA7 + ") IS NOT NULL THEN TO_NUMBER(TRIM(" + TBTHB92RRKKMEI.SONOTA7 + ")) END " + AddChangeReportLionBaitaiVO.AD1BYOSU + ",");
        sql.append(" CASE WHEN TRIM(" + TBTHB92RRKKMEI.SONOTA5 + ") IS NOT NULL THEN TO_NUMBER(TRIM(" + TBTHB92RRKKMEI.SONOTA5 + ")) END " + AddChangeReportLionBaitaiVO.AD1HONSU + ",");
        sql.append(" TRIM(" + TBTHB92RRKKMEI.NAME12 + ") " + AddChangeReportLionBaitaiVO.AD1SPACE + ",");
        sql.append(" CASE " + TBTHB92RRKKMEI.CODE1 + " WHEN '11' THEN " + TBTHB92RRKKMEI.NAME7 + " ELSE '' END " + AddChangeReportLionBaitaiVO.AD1TERM + ",");
        sql.append(" TRIM(" + TBTHB92RRKKMEI.NAME5 + ") " + AddChangeReportLionBaitaiVO.AD1KEISAIBI);
        sql.append(" FROM");
        sql.append(" " + TBTHB91RRKDOWN.TBNAME + ",");
        sql.append(" " + TBTHB92RRKKMEI.TBNAME + ",");
        sql.append(" " + TBTHBAMST.TBNAME);
        sql.append(" WHERE");
        sql.append(" " + TBTHB92RRKKMEI.RRKTIMSTMP + " = TO_DATE('" + _cond.getRrkTimStmp() + "', 'yyyy/MM/dd HH24:MI:SS') AND");
        sql.append(" " + TBTHB92RRKKMEI.EGCD + " = '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB92RRKKMEI.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB92RRKKMEI.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB92RRKKMEI.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB92RRKKMEI.YYMM + " = '" + _cond.getYymm() + "' AND");
        sql.append(" " + TBTHB91RRKDOWN.RRKTIMSTMP + " = " + TBTHB92RRKKMEI.RRKTIMSTMP + " AND");
        sql.append(" " + TBTHB91RRKDOWN.EGCD + " = " + TBTHB92RRKKMEI.EGCD + " AND");
        sql.append(" " + TBTHB91RRKDOWN.TKSKGYCD + " = " + TBTHB92RRKKMEI.TKSKGYCD + " AND");
        sql.append(" " + TBTHB91RRKDOWN.TKSBMNSEQNO + " = " + TBTHB92RRKKMEI.TKSBMNSEQNO + " AND");
        sql.append(" " + TBTHB91RRKDOWN.TKSTNTSEQNO + " = " + TBTHB92RRKKMEI.TKSTNTSEQNO + " AND");
        sql.append(" " + TBTHB91RRKDOWN.YYMM + " = " + TBTHB92RRKKMEI.YYMM + " AND");
        sql.append(" " + TBTHB91RRKDOWN.JYUTNO + " = " + TBTHB92RRKKMEI.JYUTNO + " AND");
        sql.append(" " + TBTHB91RRKDOWN.JYMEINO + " = " + TBTHB92RRKKMEI.JYMEINO + " AND");
        sql.append(" " + TBTHB91RRKDOWN.URMEINO + " = " + TBTHB92RRKKMEI.URMEINO + " AND");
        sql.append(" " + TBTHB91RRKDOWN.TJYUTNO + " = ' ' AND");
        sql.append(" " + TBTHB92RRKKMEI.CODE6 + " <> '" + SEISAKU + "' AND");
        sql.append(" " + TBTHBAMST.SYBT + " = '" + BAITAI_M + "' AND");
        sql.append(" " + TBTHB92RRKKMEI.EGCD + " = " + TBTHBAMST.EGCD + "(+) AND");
        sql.append(" " + TBTHB92RRKKMEI.TKSKGYCD + " = " + TBTHBAMST.TKSKGYCD + "(+) AND");
        sql.append(" " + TBTHB92RRKKMEI.TKSBMNSEQNO + " = " + TBTHBAMST.TKSBMNSEQNO + "(+) AND");
        sql.append(" " + TBTHB92RRKKMEI.TKSTNTSEQNO + " = " + TBTHBAMST.TKSTNTSEQNO + "(+) AND");
        sql.append(" TRIM(" + TBTHB92RRKKMEI.CODE1 + ") = " + TBTHBAMST.FIELD1 + "(+)");
        sql.append(" )");

        sql.append(" SELECT");
        sql.append(" /*+ ORDERED */");
        sql.append(" " + VWNAME_RRK + "." + AddChangeReportLionBaitaiVO.AD1JYUTNO + " " + AddChangeReportLionBaitaiVO.JYUTNO + ",");
        sql.append(" " + VWNAME_RRK + "." + AddChangeReportLionBaitaiVO.AD1JYMEINO + " " + AddChangeReportLionBaitaiVO.JYMEINO + ",");
        sql.append(" " + VWNAME_RRK + "." + AddChangeReportLionBaitaiVO.AD1URMEINO + " " + AddChangeReportLionBaitaiVO.URMEINO + ",");
        sql.append(" " + VWNAME_RRK + "." + AddChangeReportLionBaitaiVO.AD1RENBN + " " + AddChangeReportLionBaitaiVO.RENBN + ",");
        sql.append(" " + VWNAME_RRK + "." + AddChangeReportLionBaitaiVO.AD1BAITAIKBN + " " + AddChangeReportLionBaitaiVO.BAITAIKBN + ",");
        sql.append(" " + VWNAME_RRK + "." + AddChangeReportLionBaitaiVO.AD1BAITAINM + " " + AddChangeReportLionBaitaiVO.BAITAINM + ",");
        sql.append(" " + VWNAME_RRK + "." + AddChangeReportLionBaitaiVO.AD1KENNM + " " + AddChangeReportLionBaitaiVO.KENNM + ",");
        sql.append(" " + VWNAME_RRK + "." + AddChangeReportLionBaitaiVO.AD1SEIGAK + " " + AddChangeReportLionBaitaiVO.SEIGAK + ",");
        sql.append(" " + VWNAME_RRK + "." + AddChangeReportLionBaitaiVO.AD1KYKSHCD + " " + AddChangeReportLionBaitaiVO.KYKSHCD + ",");
        sql.append(" " + VHB_V11KYKSH_LION.KYKCD + " " + AddChangeReportLionBaitaiVO.KYKCD + ",");
        sql.append(" " + VHB_V11KYKSH_LION.KYKSHNM + " " + AddChangeReportLionBaitaiVO.KYKNM + ",");
        sql.append(" " + VWNAME_RRK + "." + AddChangeReportLionBaitaiVO.AD1BYOSU + " " + AddChangeReportLionBaitaiVO.BYOSU + ",");
        sql.append(" " + VWNAME_RRK + "." + AddChangeReportLionBaitaiVO.AD1HONSU + " " + AddChangeReportLionBaitaiVO.HONSU + ",");
        sql.append(" " + VWNAME_RRK + "." + AddChangeReportLionBaitaiVO.AD1SPACE + " " + AddChangeReportLionBaitaiVO.SPACE + ",");
        sql.append(" " + VWNAME_RRK + "." + AddChangeReportLionBaitaiVO.AD1TERM + " " + AddChangeReportLionBaitaiVO.TERM + ",");
        sql.append(" " + VWNAME_RRK + "." + AddChangeReportLionBaitaiVO.AD1KEISAIBI + " " + AddChangeReportLionBaitaiVO.KEISAIBI);
        sql.append(" FROM");
        sql.append(" " + VWNAME_RRK + ",");
        sql.append(" " + VHB_V11KYKSH_LION.TBNAME);
        sql.append(" WHERE");
        sql.append(" " + TBTHB92RRKKMEI.EGCD + " = " + VHB_V11KYKSH_LION.EGCD + "(+) AND");
        sql.append(" " + TBTHB92RRKKMEI.TKSKGYCD + " = " + VHB_V11KYKSH_LION.TKSKGYCD + "(+) AND");
        sql.append(" " + TBTHB92RRKKMEI.TKSBMNSEQNO + " = " + VHB_V11KYKSH_LION.TKSBMNSEQNO + "(+) AND");
        sql.append(" " + TBTHB92RRKKMEI.TKSTNTSEQNO + " = " + VHB_V11KYKSH_LION.TKSTNTSEQNO + "(+) AND");
        sql.append(" " + AddChangeReportLionBaitaiVO.AD1BAITAIKBN + " = " + VHB_V11KYKSH_LION.SYBT + "(+) AND");
        sql.append(" " + AddChangeReportLionBaitaiVO.AD1KYKSHCD + " = " + VHB_V11KYKSH_LION.KYKSHCD + "(+)");
        sql.append(" ORDER BY");
        sql.append(" " + AddChangeReportLionBaitaiVO.AD1BAITAISORTNO + ",");
        sql.append(" " + AddChangeReportLionBaitaiVO.AD1JYUTNO + ",");
        sql.append(" " + AddChangeReportLionBaitaiVO.AD1JYMEINO + ",");
        sql.append(" " + AddChangeReportLionBaitaiVO.AD1URMEINO + ",");
        sql.append(" " + AddChangeReportLionBaitaiVO.AD1RENBN);

        return sql.toString();
    }

    /**
     * �ǉ��ύX���X�g(AD2)�擾SQL������
     * @return SQL��
     */
    private String getSelectSQLAD2Baitai() {

        //SQL��
        StringBuffer sql = new StringBuffer();

        sql.append("WITH");
        sql.append(" " + VWNAME_INF + " AS");
        sql.append(" (");
        sql.append(" SELECT");
        sql.append(" /*+ ORDERED */");
        sql.append(" " + TBTHB2KMEI.EGCD + ",");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + ",");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + ",");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + ",");
        sql.append(" TRIM(" + TBTHB2KMEI.CODE1 + ") " + TBTHB2KMEI.CODE1 + ",");
        sql.append(" " + TBTHB2KMEI.JYUTNO + " " + AddChangeReportLionBaitaiVO.AD2JYUTNO + ",");
        sql.append(" " + TBTHB2KMEI.JYMEINO + " " + AddChangeReportLionBaitaiVO.AD2JYMEINO + ",");
        sql.append(" " + TBTHB2KMEI.URMEINO + " " + AddChangeReportLionBaitaiVO.AD2URMEINO + ",");
        sql.append(" " + TBTHB2KMEI.RENBN + " " + AddChangeReportLionBaitaiVO.AD2RENBN + ",");
        sql.append(" " + TBTHBAMST.FIELD1 + " " + AddChangeReportLionBaitaiVO.AD2BAITAIKBN + ",");
        sql.append(" " + TBTHBAMST.FIELD4  + " " + AddChangeReportLionBaitaiVO.AD2BAITAINM + ",");
        sql.append(" " + TBTHBAMST.FIELD5 + " " + AddChangeReportLionBaitaiVO.AD2BAITAISORTNO + ",");
        sql.append(" TRIM(" + TBTHB2KMEI.NAME10 + ") " + AddChangeReportLionBaitaiVO.AD2KENNM + ",");
        sql.append(" " + TBTHB2KMEI.SEIGAK + " " + AddChangeReportLionBaitaiVO.AD2SEIGAK + ",");
        sql.append(" TRIM(" + TBTHB2KMEI.CODE2 + ") " + AddChangeReportLionBaitaiVO.AD2KYKSHCD + ",");
        sql.append(" '' " + AddChangeReportLionBaitaiVO.AD2KYKCD + ",");
        sql.append(" CASE WHEN TRIM(" + TBTHB2KMEI.SONOTA7 + ") IS NOT NULL THEN TO_NUMBER(TRIM(" + TBTHB2KMEI.SONOTA7 + ")) END " + AddChangeReportLionBaitaiVO.AD2BYOSU + ",");
        sql.append(" CASE WHEN TRIM(" + TBTHB2KMEI.SONOTA5 + ") IS NOT NULL THEN TO_NUMBER(TRIM(" + TBTHB2KMEI.SONOTA5 + ")) END " + AddChangeReportLionBaitaiVO.AD2HONSU + ",");
        sql.append(" TRIM(" + TBTHB2KMEI.NAME2 + ") " + AddChangeReportLionBaitaiVO.AD2SPACE + ",");
        sql.append(" CASE " + TBTHB2KMEI.CODE1 + " WHEN '11' THEN " + TBTHB2KMEI.NAME7 + " ELSE '' END " + AddChangeReportLionBaitaiVO.AD2TERM + ",");
        sql.append(" TRIM(" + TBTHB2KMEI.NAME5 + ") " + AddChangeReportLionBaitaiVO.AD2KEISAIBI);
        sql.append(" FROM");
        sql.append(" " + TBTHB1DOWN.TBNAME + ",");
        sql.append(" " + TBTHB2KMEI.TBNAME + ",");
        sql.append(" " + TBTHBAMST.TBNAME);
        sql.append(" WHERE");
        sql.append(" " + TBTHB2KMEI.EGCD + " = '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.YYMM + " = '" + _cond.getYymm() + "' AND");
        sql.append(" " + TBTHB1DOWN.EGCD + " = " + TBTHB2KMEI.EGCD + " AND");
        sql.append(" " + TBTHB1DOWN.TKSKGYCD + " = " + TBTHB2KMEI.TKSKGYCD + " AND");
        sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + " = " + TBTHB2KMEI.TKSBMNSEQNO + " AND");
        sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + " = " + TBTHB2KMEI.TKSTNTSEQNO + " AND");
        sql.append(" " + TBTHB1DOWN.YYMM + " = " + TBTHB2KMEI.YYMM + " AND");
        sql.append(" " + TBTHB1DOWN.JYUTNO + " = " + TBTHB2KMEI.JYUTNO + " AND");
        sql.append(" " + TBTHB1DOWN.JYMEINO + " = " + TBTHB2KMEI.JYMEINO + " AND");
        sql.append(" " + TBTHB1DOWN.URMEINO + " = " + TBTHB2KMEI.URMEINO + " AND");
        sql.append(" " + TBTHB1DOWN.TJYUTNO + " = ' ' AND");
        sql.append(" " + TBTHB2KMEI.CODE6 + " <> '" + SEISAKU + "' AND");
        sql.append(" " + TBTHBAMST.SYBT + " = '" + BAITAI_M + "' AND");
        sql.append(" " + TBTHB2KMEI.EGCD + " = " + TBTHBAMST.EGCD + "(+) AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = " + TBTHBAMST.TKSKGYCD + "(+) AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = " + TBTHBAMST.TKSBMNSEQNO + "(+) AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = " + TBTHBAMST.TKSTNTSEQNO + "(+) AND");
        sql.append(" TRIM(" + TBTHB2KMEI.CODE1 + ") = " + TBTHBAMST.FIELD1 + "(+)");
        sql.append(" )");

        sql.append(" SELECT");
        sql.append(" /*+ ORDERED */");
        sql.append(" " + VWNAME_INF + "." + AddChangeReportLionBaitaiVO.AD2JYUTNO + " " + AddChangeReportLionBaitaiVO.JYUTNO + ",");
        sql.append(" " + VWNAME_INF + "." + AddChangeReportLionBaitaiVO.AD2JYMEINO + " " + AddChangeReportLionBaitaiVO.JYMEINO + ",");
        sql.append(" " + VWNAME_INF + "." + AddChangeReportLionBaitaiVO.AD2URMEINO + " " + AddChangeReportLionBaitaiVO.URMEINO + ",");
        sql.append(" " + VWNAME_INF + "." + AddChangeReportLionBaitaiVO.AD2RENBN + " " + AddChangeReportLionBaitaiVO.RENBN + ",");
        sql.append(" " + VWNAME_INF + "." + AddChangeReportLionBaitaiVO.AD2BAITAIKBN + " " + AddChangeReportLionBaitaiVO.BAITAIKBN + ",");
        sql.append(" " + VWNAME_INF + "." + AddChangeReportLionBaitaiVO.AD2BAITAINM + " " + AddChangeReportLionBaitaiVO.BAITAINM + ",");
        sql.append(" " + VWNAME_INF + "." + AddChangeReportLionBaitaiVO.AD2KENNM + " " + AddChangeReportLionBaitaiVO.KENNM + ",");
        sql.append(" " + VWNAME_INF + "." + AddChangeReportLionBaitaiVO.AD2SEIGAK + " " + AddChangeReportLionBaitaiVO.SEIGAK + ",");
        sql.append(" " + VWNAME_INF + "." + AddChangeReportLionBaitaiVO.AD2KYKSHCD + " " + AddChangeReportLionBaitaiVO.KYKSHCD + ",");
        sql.append(" " + VHB_V11KYKSH_LION.KYKCD + " " + AddChangeReportLionBaitaiVO.KYKCD + ",");
        sql.append(" " + VHB_V11KYKSH_LION.KYKSHNM + " " + AddChangeReportLionBaitaiVO.KYKNM + ",");
        sql.append(" " + VWNAME_INF + "." + AddChangeReportLionBaitaiVO.AD2BYOSU + " " + AddChangeReportLionBaitaiVO.BYOSU + ",");
        sql.append(" " + VWNAME_INF + "." + AddChangeReportLionBaitaiVO.AD2HONSU + " " + AddChangeReportLionBaitaiVO.HONSU + ",");
        sql.append(" " + VWNAME_INF + "." + AddChangeReportLionBaitaiVO.AD2SPACE + " " + AddChangeReportLionBaitaiVO.SPACE + ",");
        sql.append(" " + VWNAME_INF + "." + AddChangeReportLionBaitaiVO.AD2TERM + " " + AddChangeReportLionBaitaiVO.TERM + ",");
        sql.append(" " + VWNAME_INF + "." + AddChangeReportLionBaitaiVO.AD2KEISAIBI + " " + AddChangeReportLionBaitaiVO.KEISAIBI);
        sql.append(" FROM");
        sql.append(" " + VWNAME_INF + ",");
        sql.append(" " + VHB_V11KYKSH_LION.TBNAME);
        sql.append(" WHERE");
        sql.append(" " + TBTHB2KMEI.EGCD + " = " + VHB_V11KYKSH_LION.EGCD + "(+) AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = " + VHB_V11KYKSH_LION.TKSKGYCD + "(+) AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = " + VHB_V11KYKSH_LION.TKSBMNSEQNO + "(+) AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = " + VHB_V11KYKSH_LION.TKSTNTSEQNO + "(+) AND");
        sql.append(" " + AddChangeReportLionBaitaiVO.AD2BAITAIKBN + " = " + VHB_V11KYKSH_LION.SYBT + "(+) AND");
        sql.append(" " + AddChangeReportLionBaitaiVO.AD2KYKSHCD + " = " + VHB_V11KYKSH_LION.KYKSHCD + "(+)");
        sql.append(" ORDER BY");
        sql.append(" " + AddChangeReportLionBaitaiVO.AD2BAITAISORTNO + ",");
        sql.append(" " + AddChangeReportLionBaitaiVO.AD2JYUTNO + ",");
        sql.append(" " + AddChangeReportLionBaitaiVO.AD2JYMEINO + ",");
        sql.append(" " + AddChangeReportLionBaitaiVO.AD2URMEINO + ",");
        sql.append(" " + AddChangeReportLionBaitaiVO.AD2RENBN);

        return sql.toString();
    }

    /**
     * �ǉ��ύX���X�g(AD1/AD2�����A��������)�擾SQL������
     * @return SQL��
     */
    private String getSelectSQLBaitaiDiffInternal() {

        //SQL��
        StringBuffer sql = new StringBuffer();

        sql.append("WITH");

        //AD1
        sql.append(" AD1");
        sql.append(" AS (");
        sql.append(" SELECT");
        sql.append(" /*+ ORDERED */");
        sql.append(" " + TBTHB92RRKKMEI.JYUTNO + " " + AddChangeReportLionBaitaiVO.AD1JYUTNO + ",");
        sql.append(" " + TBTHB92RRKKMEI.JYMEINO + " " + AddChangeReportLionBaitaiVO.AD1JYMEINO + ",");
        sql.append(" " + TBTHB92RRKKMEI.URMEINO + " " + AddChangeReportLionBaitaiVO.AD1URMEINO + ",");
        sql.append(" " + TBTHB92RRKKMEI.RENBN + " " + AddChangeReportLionBaitaiVO.AD1RENBN + ",");
        sql.append(" " + TBTHBAMST.FIELD1 + " " + AddChangeReportLionBaitaiVO.AD1BAITAIKBN + ",");
        sql.append(" " + TBTHBAMST.FIELD4 + " " + AddChangeReportLionBaitaiVO.AD1BAITAINM + ",");
        sql.append(" " + TBTHBAMST.FIELD5 + " " + AddChangeReportLionBaitaiVO.AD1BAITAISORTNO + ",");
        sql.append(" TRIM(" + TBTHB92RRKKMEI.NAME10 + ") " + AddChangeReportLionBaitaiVO.AD1KENNM + " ,");
        sql.append(" " + TBTHB92RRKKMEI.SEIGAK + " " + AddChangeReportLionBaitaiVO.AD1SEIGAK + ",");
        sql.append(" TRIM(" + TBTHB92RRKKMEI.CODE2 + ") " + AddChangeReportLionBaitaiVO.AD1KYKSHCD + ",");
        sql.append(" CASE WHEN " + VHB_V11KYKSH_LION.KYKCD + " IS NOT NULL THEN " + VHB_V11KYKSH_LION.KYKCD + " ELSE '' END " + AddChangeReportLionBaitaiVO.AD1KYKCD + ",");
        sql.append(" CASE WHEN " + VHB_V11KYKSH_LION.KYKSHNM + " IS NOT NULL THEN " + VHB_V11KYKSH_LION.KYKSHNM + " ELSE '' END " + AddChangeReportLionBaitaiVO.AD1KYKNM + ",");
        sql.append(" CASE WHEN TRIM(" + TBTHB92RRKKMEI.SONOTA7 + ") IS NOT NULL THEN TO_NUMBER(TRIM(" + TBTHB92RRKKMEI.SONOTA7 + ")) END " + AddChangeReportLionBaitaiVO.AD1BYOSU + ",");
        sql.append(" CASE WHEN TRIM(" + TBTHB92RRKKMEI.SONOTA5 + ") IS NOT NULL THEN TO_NUMBER(TRIM(" + TBTHB92RRKKMEI.SONOTA5 + ")) END " + AddChangeReportLionBaitaiVO.AD1HONSU + ",");
        sql.append(" TRIM(" + TBTHB92RRKKMEI.NAME2 + ") " + AddChangeReportLionBaitaiVO.AD1SPACE + ",");
        sql.append(" TRIM(" + TBTHB92RRKKMEI.NAME5 + ") " + AddChangeReportLionBaitaiVO.AD1KEISAIBI + ",");
        sql.append(" CASE " + TBTHB92RRKKMEI.CODE1 + " WHEN '11' THEN " + TBTHB92RRKKMEI.NAME7 + " ELSE '' END " + AddChangeReportLionBaitaiVO.AD1TERM);
        sql.append(" FROM");
        sql.append(" " + TBTHB91RRKDOWN.TBNAME + ",");
        sql.append(" " + TBTHB92RRKKMEI.TBNAME + ",");
        sql.append(" " + TBTHBAMST.TBNAME + ",");
        sql.append(" " + VHB_V11KYKSH_LION.TBNAME);
        sql.append(" WHERE");
        sql.append(" " + TBTHB92RRKKMEI.RRKTIMSTMP + " = TO_DATE('" + _cond.getRrkTimStmp() + "', 'yyyy/MM/dd HH24:MI:SS') AND");
        sql.append(" " + TBTHB92RRKKMEI.EGCD + " = '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB92RRKKMEI.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB92RRKKMEI.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB92RRKKMEI.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB92RRKKMEI.YYMM + " = '" + _cond.getYymm() + "' AND");
        sql.append(" " + TBTHB91RRKDOWN.RRKTIMSTMP + " = " + TBTHB92RRKKMEI.RRKTIMSTMP + " AND");
        sql.append(" " + TBTHB91RRKDOWN.EGCD + " = " + TBTHB92RRKKMEI.EGCD + " AND");
        sql.append(" " + TBTHB91RRKDOWN.TKSKGYCD + " = " + TBTHB92RRKKMEI.TKSKGYCD + " AND");
        sql.append(" " + TBTHB91RRKDOWN.TKSBMNSEQNO + " = " + TBTHB92RRKKMEI.TKSBMNSEQNO + " AND");
        sql.append(" " + TBTHB91RRKDOWN.TKSTNTSEQNO + " = " + TBTHB92RRKKMEI.TKSTNTSEQNO + " AND");
        sql.append(" " + TBTHB91RRKDOWN.YYMM + " = " + TBTHB92RRKKMEI.YYMM + " AND");
        sql.append(" " + TBTHB91RRKDOWN.JYUTNO + " = " + TBTHB92RRKKMEI.JYUTNO + " AND");
        sql.append(" " + TBTHB91RRKDOWN.JYMEINO + " = " + TBTHB92RRKKMEI.JYMEINO + " AND");
        sql.append(" " + TBTHB91RRKDOWN.URMEINO + " = " + TBTHB92RRKKMEI.URMEINO + " AND");
        sql.append(" " + TBTHB91RRKDOWN.TJYUTNO + " = ' ' AND");
        sql.append(" " + TBTHB92RRKKMEI.CODE6 + " <> '" + SEISAKU + "' AND");
        sql.append(" " + TBTHBAMST.SYBT + " = '" + BAITAI_M + "' AND");
        sql.append(" " + TBTHB92RRKKMEI.EGCD + " = " + TBTHBAMST.EGCD + "(+) AND");
        sql.append(" " + TBTHB92RRKKMEI.TKSKGYCD + " = " + TBTHBAMST.TKSKGYCD + "(+) AND");
        sql.append(" " + TBTHB92RRKKMEI.TKSBMNSEQNO + " = " + TBTHBAMST.TKSBMNSEQNO + "(+) AND");
        sql.append(" " + TBTHB92RRKKMEI.TKSTNTSEQNO + " = " + TBTHBAMST.TKSTNTSEQNO + "(+) AND");
        sql.append(" TRIM(" + TBTHB92RRKKMEI.CODE1 + ") = " + TBTHBAMST.FIELD1 + "(+) AND");
        sql.append(" " + TBTHB92RRKKMEI.EGCD + " = " + VHB_V11KYKSH_LION.EGCD + "(+) AND");
        sql.append(" " + TBTHB92RRKKMEI.TKSKGYCD + " = " + VHB_V11KYKSH_LION.TKSKGYCD + "(+) AND");
        sql.append(" " + TBTHB92RRKKMEI.TKSBMNSEQNO + "= " + VHB_V11KYKSH_LION.TKSBMNSEQNO + "(+) AND");
        sql.append(" " + TBTHB92RRKKMEI.TKSTNTSEQNO + " = " + VHB_V11KYKSH_LION.TKSTNTSEQNO + "(+) AND");
        sql.append(" " + TBTHB92RRKKMEI.CODE1 + " = " + VHB_V11KYKSH_LION.SYBT + "(+) AND");
        sql.append(" TRIM(" + TBTHB92RRKKMEI.CODE2 + ") = " + VHB_V11KYKSH_LION.KYKSHCD + "(+)");
        sql.append(" ),");

        //AD2
        sql.append(" AD2");
        sql.append(" AS (");
        sql.append(" SELECT");
        sql.append(" /*+ ORDERED */");
        sql.append(" " + TBTHB2KMEI.JYUTNO + " " + AddChangeReportLionBaitaiVO.AD2JYUTNO + ",");
        sql.append(" " + TBTHB2KMEI.JYMEINO + " " + AddChangeReportLionBaitaiVO.AD2JYMEINO + ",");
        sql.append(" " + TBTHB2KMEI.URMEINO + " " + AddChangeReportLionBaitaiVO.AD2URMEINO + ",");
        sql.append(" " + TBTHB2KMEI.RENBN + " " + AddChangeReportLionBaitaiVO.AD2RENBN + ",");
        sql.append(" " + TBTHBAMST.FIELD1 + " " + AddChangeReportLionBaitaiVO.AD2BAITAIKBN + ",");
        sql.append(" " + TBTHBAMST.FIELD4 + " " + AddChangeReportLionBaitaiVO.AD2BAITAINM + ",");
        sql.append(" " + TBTHBAMST.FIELD5 + " " + AddChangeReportLionBaitaiVO.AD2BAITAISORTNO + ",");
        sql.append(" TRIM(" + TBTHB2KMEI.NAME10 + ") " + AddChangeReportLionBaitaiVO.AD2KENNM + ",");
        sql.append(" " + TBTHB2KMEI.SEIGAK + " " + AddChangeReportLionBaitaiVO.AD2SEIGAK + ",");
        sql.append(" TRIM(" + TBTHB2KMEI.CODE2 + ") " + AddChangeReportLionBaitaiVO.AD2KYKSHCD + ",");
        sql.append(" CASE WHEN " + VHB_V11KYKSH_LION.KYKCD + " IS NOT NULL THEN " + VHB_V11KYKSH_LION.KYKCD + " ELSE '' END " + AddChangeReportLionBaitaiVO.AD2KYKCD + ",");
        sql.append(" CASE WHEN " + VHB_V11KYKSH_LION.KYKSHNM + " IS NOT NULL THEN " + VHB_V11KYKSH_LION.KYKSHNM + " ELSE '' END " + AddChangeReportLionBaitaiVO.AD2KYKNM + ",");
        sql.append(" CASE WHEN TRIM(" + TBTHB2KMEI.SONOTA7 + ") IS NOT NULL THEN TO_NUMBER(TRIM(" + TBTHB2KMEI.SONOTA7 + ")) END " + AddChangeReportLionBaitaiVO.AD2BYOSU + ",");
        sql.append(" CASE WHEN TRIM(" + TBTHB2KMEI.SONOTA5 + ") IS NOT NULL THEN TO_NUMBER(TRIM(" + TBTHB2KMEI.SONOTA5 + ")) END " + AddChangeReportLionBaitaiVO.AD2HONSU + ",");
        sql.append(" TRIM(" + TBTHB2KMEI.NAME2 + ") " + AddChangeReportLionBaitaiVO.AD2SPACE + ",");
        sql.append(" TRIM(" + TBTHB2KMEI.NAME5 + ") " + AddChangeReportLionBaitaiVO.AD2KEISAIBI + ",");
        sql.append(" CASE " + TBTHB2KMEI.CODE1 + " WHEN '11' THEN " + TBTHB2KMEI.NAME7 + " ELSE '' END " + AddChangeReportLionBaitaiVO.AD2TERM);
        sql.append(" FROM");
        sql.append(" " + TBTHB1DOWN.TBNAME + ",");
        sql.append(" " + TBTHB2KMEI.TBNAME + ",");
        sql.append(" " + TBTHBAMST.TBNAME + ",");
        sql.append(" " + VHB_V11KYKSH_LION.TBNAME);
        sql.append(" WHERE");
        sql.append(" " + TBTHB2KMEI.EGCD + " = '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.YYMM + " = '" + _cond.getYymm() + "' AND");
        sql.append(" " + TBTHB1DOWN.EGCD + " = " + TBTHB2KMEI.EGCD + " AND");
        sql.append(" " + TBTHB1DOWN.TKSKGYCD + " = " + TBTHB2KMEI.TKSKGYCD + " AND");
        sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + " = " + TBTHB2KMEI.TKSBMNSEQNO + " AND");
        sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + " = " + TBTHB2KMEI.TKSTNTSEQNO + " AND");
        sql.append(" " + TBTHB1DOWN.YYMM + " = " + TBTHB2KMEI.YYMM + " AND");
        sql.append(" " + TBTHB1DOWN.JYUTNO + " = " + TBTHB2KMEI.JYUTNO + " AND");
        sql.append(" " + TBTHB1DOWN.JYMEINO + " = " + TBTHB2KMEI.JYMEINO + " AND");
        sql.append(" " + TBTHB1DOWN.URMEINO + " = " + TBTHB2KMEI.URMEINO + " AND");
        sql.append(" " + TBTHB1DOWN.TJYUTNO + " = ' ' AND");
        sql.append(" " + TBTHB2KMEI.CODE6 + " <> '" + SEISAKU + "' AND");
        sql.append(" " + TBTHBAMST.SYBT + " = '" + BAITAI_M + "' AND");
        sql.append(" " + TBTHB2KMEI.EGCD + " = " + TBTHBAMST.EGCD + "(+) AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = " + TBTHBAMST.TKSKGYCD + "(+) AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = " + TBTHBAMST.TKSBMNSEQNO + "(+) AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = " + TBTHBAMST.TKSTNTSEQNO + "(+) AND");
        sql.append(" TRIM(" + TBTHB2KMEI.CODE1 + ") = " + TBTHBAMST.FIELD1 + "(+) AND");
        sql.append(" " + TBTHB2KMEI.EGCD + " = " + VHB_V11KYKSH_LION.EGCD + "(+) AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = " + VHB_V11KYKSH_LION.TKSKGYCD + "(+) AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = " + VHB_V11KYKSH_LION.TKSBMNSEQNO + "(+) AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = " + VHB_V11KYKSH_LION.TKSTNTSEQNO + "(+) AND");
        sql.append(" " + TBTHB2KMEI.CODE1 + " = " + VHB_V11KYKSH_LION.SYBT + "(+) AND");
        sql.append(" TRIM(" + TBTHB2KMEI.CODE2 + ") = " + VHB_V11KYKSH_LION.KYKSHCD + "(+)");
        sql.append(" )");

        sql.append(" SELECT");
        sql.append(" " + AddChangeReportLionBaitaiVO.JYUTNO + ",");
        sql.append(" " + AddChangeReportLionBaitaiVO.JYMEINO + ",");
        sql.append(" " + AddChangeReportLionBaitaiVO.URMEINO + ",");
        sql.append(" " + AddChangeReportLionBaitaiVO.RENBN + ",");
        sql.append(" " + AddChangeReportLionBaitaiVO.BAITAIKBN + ",");
        sql.append(" " + AddChangeReportLionBaitaiVO.BAITAINM + ",");
        sql.append(" " + AddChangeReportLionBaitaiVO.KENNM + ",");
        sql.append(" " + AddChangeReportLionBaitaiVO.SEIGAK + ",");
        sql.append(" " + AddChangeReportLionBaitaiVO.KYKSHCD + ",");
        sql.append(" " + AddChangeReportLionBaitaiVO.KYKCD + ",");
        sql.append(" " + AddChangeReportLionBaitaiVO.KYKNM + ",");
        sql.append(" " + AddChangeReportLionBaitaiVO.BYOSU + ",");
        sql.append(" " + AddChangeReportLionBaitaiVO.HONSU + ",");
        sql.append(" " + AddChangeReportLionBaitaiVO.SPACE + ",");
        sql.append(" " + AddChangeReportLionBaitaiVO.KEISAIBI + ",");
        sql.append(" " + AddChangeReportLionBaitaiVO.TERM + ",");
        sql.append(" " + AddChangeReportLionBaitaiVO.SEQ + ",");
        sql.append(" " + AddChangeReportLionBaitaiVO.ORDERSEQ);
        sql.append(" FROM");
        sql.append(" (");

        //�ǉ�
        sql.append(" SELECT");
        sql.append(" " + AddChangeReportLionBaitaiVO.AD2JYUTNO + " " + AddChangeReportLionBaitaiVO.JYUTNO + ",");
        sql.append(" " + AddChangeReportLionBaitaiVO.AD2JYMEINO + " " + AddChangeReportLionBaitaiVO.JYMEINO + ",");
        sql.append(" " + AddChangeReportLionBaitaiVO.AD2URMEINO + " " + AddChangeReportLionBaitaiVO.URMEINO + ",");
        sql.append(" " + AddChangeReportLionBaitaiVO.AD2RENBN + " " + AddChangeReportLionBaitaiVO.RENBN + ",");
        sql.append(" " + AddChangeReportLionBaitaiVO.AD2BAITAIKBN + " " + AddChangeReportLionBaitaiVO.BAITAIKBN + ",");
        sql.append(" " + AddChangeReportLionBaitaiVO.AD2BAITAINM + " " + AddChangeReportLionBaitaiVO.BAITAINM + ",");
        sql.append(" " + AddChangeReportLionBaitaiVO.AD2BAITAISORTNO + " " + AddChangeReportLionBaitaiVO.BAITAISORTNO + ",");
        sql.append(" " + AddChangeReportLionBaitaiVO.AD2KENNM + " " + AddChangeReportLionBaitaiVO.KENNM + ",");
        sql.append(" " + AddChangeReportLionBaitaiVO.AD2SEIGAK + " " + AddChangeReportLionBaitaiVO.SEIGAK + ",");
        sql.append(" " + AddChangeReportLionBaitaiVO.AD2KYKSHCD + " " + AddChangeReportLionBaitaiVO.KYKSHCD + ",");
        sql.append(" " + AddChangeReportLionBaitaiVO.AD2KYKCD + " " + AddChangeReportLionBaitaiVO.KYKCD + ",");
        sql.append(" " + AddChangeReportLionBaitaiVO.AD2KYKNM + " " + AddChangeReportLionBaitaiVO.KYKNM + ",");
        sql.append(" " + AddChangeReportLionBaitaiVO.AD2BYOSU + " " + AddChangeReportLionBaitaiVO.BYOSU + ",");
        sql.append(" " + AddChangeReportLionBaitaiVO.AD2HONSU + " " + AddChangeReportLionBaitaiVO.HONSU + ",");
        sql.append(" " + AddChangeReportLionBaitaiVO.AD2SPACE + " " + AddChangeReportLionBaitaiVO.SPACE + ",");
        sql.append(" " + AddChangeReportLionBaitaiVO.AD2KEISAIBI + " " + AddChangeReportLionBaitaiVO.KEISAIBI + ",");
        sql.append(" " + AddChangeReportLionBaitaiVO.AD2TERM + " " + AddChangeReportLionBaitaiVO.TERM + ",");
        sql.append(" '1' " + AddChangeReportLionBaitaiVO.SEQ + ",");
        sql.append(" '2' " + AddChangeReportLionBaitaiVO.ORDERSEQ);
        sql.append(" FROM");
        sql.append(" " + VWNAME_AD2 + " A");
        sql.append(" WHERE");
        sql.append(" NOT EXISTS (");
        sql.append(" SELECT");
        sql.append(" 1");
        sql.append(" FROM");
        sql.append(" " + VWNAME_AD1 + " B");
        sql.append(" WHERE");
        sql.append(" A." + AddChangeReportLionBaitaiVO.AD2JYUTNO + " = B." + AddChangeReportLionBaitaiVO.AD1JYUTNO + " AND");
        sql.append(" A." + AddChangeReportLionBaitaiVO.AD2JYMEINO + " = B." + AddChangeReportLionBaitaiVO.AD1JYMEINO + " AND");
        sql.append(" A." + AddChangeReportLionBaitaiVO.AD2URMEINO + " = B." + AddChangeReportLionBaitaiVO.AD1URMEINO + " AND");
        sql.append(" A." + AddChangeReportLionBaitaiVO.AD2RENBN + " = B." + AddChangeReportLionBaitaiVO.AD1RENBN);
        sql.append(" )");

        sql.append(" UNION ALL");

        //�폜
        sql.append(" SELECT");
        sql.append(" " + AddChangeReportLionBaitaiVO.AD1JYUTNO + ",");
        sql.append(" " + AddChangeReportLionBaitaiVO.AD1JYMEINO + ",");
        sql.append(" " + AddChangeReportLionBaitaiVO.AD1URMEINO + ",");
        sql.append(" " + AddChangeReportLionBaitaiVO.AD1RENBN + ",");
        sql.append(" " + AddChangeReportLionBaitaiVO.AD1BAITAIKBN + ",");
        sql.append(" " + AddChangeReportLionBaitaiVO.AD1BAITAINM + ",");
        sql.append(" " + AddChangeReportLionBaitaiVO.AD1BAITAISORTNO + ",");
        sql.append(" " + AddChangeReportLionBaitaiVO.AD1KENNM + ",");
        sql.append(" " + AddChangeReportLionBaitaiVO.AD1SEIGAK + ",");
        sql.append(" " + AddChangeReportLionBaitaiVO.AD1KYKSHCD + ",");
        sql.append(" " + AddChangeReportLionBaitaiVO.AD1KYKCD + ",");
        sql.append(" " + AddChangeReportLionBaitaiVO.AD1KYKNM + ",");
        sql.append(" " + AddChangeReportLionBaitaiVO.AD1BYOSU + ",");
        sql.append(" " + AddChangeReportLionBaitaiVO.AD1HONSU + ",");
        sql.append(" " + AddChangeReportLionBaitaiVO.AD1SPACE + ",");
        sql.append(" " + AddChangeReportLionBaitaiVO.AD1KEISAIBI + ",");
        sql.append(" " + AddChangeReportLionBaitaiVO.AD1TERM + ",");
        sql.append(" '2',");
        sql.append(" '1'");
        sql.append(" FROM");
        sql.append(" " + VWNAME_AD1 + " C");
        sql.append(" WHERE");
        sql.append(" NOT EXISTS (");
        sql.append(" SELECT");
        sql.append(" 1");
        sql.append(" FROM");
        sql.append(" " + VWNAME_AD2 + " D");
        sql.append(" WHERE");
        sql.append(" C." + AddChangeReportLionBaitaiVO.AD1JYUTNO + " = D." + AddChangeReportLionBaitaiVO.AD2JYUTNO + " AND");
        sql.append(" C." + AddChangeReportLionBaitaiVO.AD1JYMEINO + " = D." + AddChangeReportLionBaitaiVO.AD2JYMEINO + " AND");
        sql.append(" C." + AddChangeReportLionBaitaiVO.AD1URMEINO + " = D." + AddChangeReportLionBaitaiVO.AD2URMEINO + " AND");
        sql.append(" C." + AddChangeReportLionBaitaiVO.AD1RENBN + " = D." + AddChangeReportLionBaitaiVO.AD2RENBN);
        sql.append(" )");

        sql.append(" UNION ALL");

        //�ύX(AD1)
        sql.append(" SELECT");
        sql.append(" /*+ ORDERED */");
        sql.append(" E." + AddChangeReportLionBaitaiVO.AD1JYUTNO + ",");
        sql.append(" E." + AddChangeReportLionBaitaiVO.AD1JYMEINO + ",");
        sql.append(" E." + AddChangeReportLionBaitaiVO.AD1URMEINO + ",");
        sql.append(" E." + AddChangeReportLionBaitaiVO.AD1RENBN + ",");
        sql.append(" E." + AddChangeReportLionBaitaiVO.AD1BAITAIKBN + ",");
        sql.append(" E." + AddChangeReportLionBaitaiVO.AD1BAITAINM + ",");
        sql.append(" E." + AddChangeReportLionBaitaiVO.AD1BAITAISORTNO + ",");
        sql.append(" E." + AddChangeReportLionBaitaiVO.AD1KENNM + ",");
        sql.append(" E." + AddChangeReportLionBaitaiVO.AD1SEIGAK + ",");
        sql.append(" E." + AddChangeReportLionBaitaiVO.AD1KYKSHCD + ",");
        sql.append(" E." + AddChangeReportLionBaitaiVO.AD1KYKCD + ",");
        sql.append(" E." + AddChangeReportLionBaitaiVO.AD1KYKNM + ",");
        sql.append(" E." + AddChangeReportLionBaitaiVO.AD1BYOSU + ",");
        sql.append(" E." + AddChangeReportLionBaitaiVO.AD1HONSU+ ",");
        sql.append(" E." + AddChangeReportLionBaitaiVO.AD1SPACE + ",");
        sql.append(" E." + AddChangeReportLionBaitaiVO.AD1KEISAIBI + ",");
        sql.append(" E." + AddChangeReportLionBaitaiVO.AD1TERM + ",");
        sql.append(" '3',");
        sql.append(" '1'");
        sql.append(" FROM");
        sql.append(" " + VWNAME_AD1 + " E,");
        sql.append(" " + VWNAME_AD2 + " F");
        sql.append(" WHERE");
        sql.append(" E." + AddChangeReportLionBaitaiVO.AD1JYUTNO + " = F." + AddChangeReportLionBaitaiVO.AD2JYUTNO + " AND");
        sql.append(" E." + AddChangeReportLionBaitaiVO.AD1JYMEINO + " = F." + AddChangeReportLionBaitaiVO.AD2JYMEINO + " AND");
        sql.append(" E." + AddChangeReportLionBaitaiVO.AD1URMEINO + " = F." + AddChangeReportLionBaitaiVO.AD2URMEINO + " AND");
        sql.append(" E." + AddChangeReportLionBaitaiVO.AD1RENBN + " = F." + AddChangeReportLionBaitaiVO.AD2RENBN + " AND");
        sql.append(" (");
        sql.append(" TRIM(E." + AddChangeReportLionBaitaiVO.AD1BAITAIKBN + ") <> TRIM(F." + AddChangeReportLionBaitaiVO.AD2BAITAIKBN + ") OR");
        sql.append(" TRIM(E." + AddChangeReportLionBaitaiVO.AD1KENNM + ") <> TRIM(F." + AddChangeReportLionBaitaiVO.AD2KENNM + ") OR");
        sql.append(" E." + AddChangeReportLionBaitaiVO.AD1SEIGAK + " <> F." + AddChangeReportLionBaitaiVO.AD2SEIGAK + " OR");
        sql.append(" TRIM(E." + AddChangeReportLionBaitaiVO.AD1KYKSHCD + ") <> TRIM(F." + AddChangeReportLionBaitaiVO.AD2KYKSHCD + ") OR");
        sql.append(" TRIM(E." + AddChangeReportLionBaitaiVO.AD1KYKCD + ") <> TRIM(F." + AddChangeReportLionBaitaiVO.AD2KYKCD + ") OR");
        sql.append(" TRIM(E." + AddChangeReportLionBaitaiVO.AD1KYKNM + ") <> TRIM(F." + AddChangeReportLionBaitaiVO.AD2KYKNM + ") OR");
        sql.append(" TRIM(E." + AddChangeReportLionBaitaiVO.AD1HONSU + ") <> TRIM(F." + AddChangeReportLionBaitaiVO.AD2HONSU + ") OR");
        sql.append(" TRIM(E." + AddChangeReportLionBaitaiVO.AD1BYOSU + ") <> TRIM(F." + AddChangeReportLionBaitaiVO.AD2BYOSU + ") OR");
        sql.append(" TRIM(E." + AddChangeReportLionBaitaiVO.AD1SPACE + ") <> TRIM(F." + AddChangeReportLionBaitaiVO.AD2SPACE + ") OR");
        sql.append(" TRIM(E." + AddChangeReportLionBaitaiVO.AD1KEISAIBI + ") <> TRIM(F." + AddChangeReportLionBaitaiVO.AD2KEISAIBI + ") OR");
        sql.append(" E." + AddChangeReportLionBaitaiVO.AD1TERM + " <> F." + AddChangeReportLionBaitaiVO.AD2TERM);
        sql.append(" )");

        sql.append(" UNION ALL");

        //�ύX(AD2)
        sql.append(" SELECT");
        sql.append(" /*+ ORDERED */");
        sql.append(" F." + AddChangeReportLionBaitaiVO.AD2JYUTNO + ",");
        sql.append(" F." + AddChangeReportLionBaitaiVO.AD2JYMEINO + ",");
        sql.append(" F." + AddChangeReportLionBaitaiVO.AD2URMEINO + ",");
        sql.append(" F." + AddChangeReportLionBaitaiVO.AD2RENBN + ",");
        sql.append(" F." + AddChangeReportLionBaitaiVO.AD2BAITAIKBN + ",");
        sql.append(" F." + AddChangeReportLionBaitaiVO.AD2BAITAINM + ",");
        sql.append(" F." + AddChangeReportLionBaitaiVO.AD2BAITAISORTNO+ ",");
        sql.append(" F." + AddChangeReportLionBaitaiVO.AD2KENNM + ",");
        sql.append(" F." + AddChangeReportLionBaitaiVO.AD2SEIGAK + ",");
        sql.append(" F." + AddChangeReportLionBaitaiVO.AD2KYKSHCD + ",");
        sql.append(" F." + AddChangeReportLionBaitaiVO.AD2KYKCD + ",");
        sql.append(" F." + AddChangeReportLionBaitaiVO.AD2KYKNM + ",");
        sql.append(" F." + AddChangeReportLionBaitaiVO.AD2BYOSU + ",");
        sql.append(" F." + AddChangeReportLionBaitaiVO.AD2HONSU + ",");
        sql.append(" F." + AddChangeReportLionBaitaiVO.AD2SPACE + ",");
        sql.append(" F." + AddChangeReportLionBaitaiVO.AD2KEISAIBI + ",");
        sql.append(" F." + AddChangeReportLionBaitaiVO.AD2TERM + ",");
        sql.append(" '3',");
        sql.append(" '2'");
        sql.append(" FROM");
        sql.append(" " + VWNAME_AD1 + " E,");
        sql.append(" " + VWNAME_AD2 + " F");
        sql.append(" WHERE");
        sql.append(" E." + AddChangeReportLionBaitaiVO.AD1JYUTNO + " = F." + AddChangeReportLionBaitaiVO.AD2JYUTNO + " AND");
        sql.append(" E." + AddChangeReportLionBaitaiVO.AD1JYMEINO + " = F." + AddChangeReportLionBaitaiVO.AD2JYMEINO + " AND");
        sql.append(" E." + AddChangeReportLionBaitaiVO.AD1URMEINO + " = F." + AddChangeReportLionBaitaiVO.AD2URMEINO + " AND");
        sql.append(" E." + AddChangeReportLionBaitaiVO.AD1RENBN + " = F." + AddChangeReportLionBaitaiVO.AD2RENBN + " AND");
        sql.append(" (");
        sql.append(" TRIM(E." + AddChangeReportLionBaitaiVO.AD1BAITAIKBN + ") <> TRIM(F." + AddChangeReportLionBaitaiVO.AD2BAITAIKBN + ") OR");
        sql.append(" TRIM(E." + AddChangeReportLionBaitaiVO.AD1KENNM + ") <> TRIM(F." + AddChangeReportLionBaitaiVO.AD2KENNM + ") OR");
        sql.append(" E." + AddChangeReportLionBaitaiVO.AD1SEIGAK + " <> F." + AddChangeReportLionBaitaiVO.AD2SEIGAK + " OR");
        sql.append(" TRIM(E." + AddChangeReportLionBaitaiVO.AD1KYKSHCD + ") <> TRIM(F." + AddChangeReportLionBaitaiVO.AD2KYKSHCD + ") OR");
        sql.append(" TRIM(E." + AddChangeReportLionBaitaiVO.AD1KYKCD + ") <> TRIM(F." + AddChangeReportLionBaitaiVO.AD2KYKCD + ") OR");
        sql.append(" TRIM(E." + AddChangeReportLionBaitaiVO.AD1KYKNM + ") <> TRIM(F." + AddChangeReportLionBaitaiVO.AD2KYKNM + ") OR");
        sql.append(" TRIM(E." + AddChangeReportLionBaitaiVO.AD1HONSU + ") <> TRIM(F." + AddChangeReportLionBaitaiVO.AD2HONSU + ") OR");
        sql.append(" TRIM(E." + AddChangeReportLionBaitaiVO.AD1BYOSU + ") <> TRIM(F." + AddChangeReportLionBaitaiVO.AD2BYOSU + ") OR");
        sql.append(" TRIM(E." + AddChangeReportLionBaitaiVO.AD1SPACE + ") <> TRIM(F." + AddChangeReportLionBaitaiVO.AD2SPACE + ") OR");
        sql.append(" TRIM(E." + AddChangeReportLionBaitaiVO.AD1KEISAIBI + ") <> TRIM(F." + AddChangeReportLionBaitaiVO.AD2KEISAIBI + ") OR");
        sql.append(" E." + AddChangeReportLionBaitaiVO.AD1TERM + " <> F." + AddChangeReportLionBaitaiVO.AD2TERM);
        sql.append(" )");
        sql.append(" )");

        sql.append(" ORDER BY");
        sql.append(" " + AddChangeReportLionBaitaiVO.JYUTNO + ",");
        sql.append(" " + AddChangeReportLionBaitaiVO.JYMEINO + ",");
        sql.append(" " + AddChangeReportLionBaitaiVO.URMEINO + ",");
        sql.append(" " + AddChangeReportLionBaitaiVO.RENBN + ",");
        sql.append(" " + AddChangeReportLionBaitaiVO.ORDERSEQ);

        return sql.toString();
    }

    /**
     * �ǉ��ύX���X�g(AD1/AD2����)�擾SQL������
     * @return SQL��
     */
    private String getSelectSQLBaiatiDiffExternal() {

        //SQL��
        StringBuilder sql = new StringBuilder();

        //AD1
        sql.append("WITH");
        sql.append(" " + VWNAME_AD1);
        sql.append(" AS (");
        sql.append(" SELECT");
        sql.append(" /*+ ORDERED */");
        sql.append(" " + TBTHB92RRKKMEI.JYUTNO + " " + AddChangeReportLionBaitaiVO.AD1JYUTNO + ",");
        sql.append(" " + TBTHB92RRKKMEI.JYMEINO + " " + AddChangeReportLionBaitaiVO.AD1JYMEINO + ",");
        sql.append(" " + TBTHB92RRKKMEI.URMEINO + " " + AddChangeReportLionBaitaiVO.AD1URMEINO + ",");
        sql.append(" " + TBTHBAMST.FIELD1 + " " + AddChangeReportLionBaitaiVO.AD1BAITAIKBN + ",");
        sql.append(" " + TBTHBAMST.FIELD4 + " " + AddChangeReportLionBaitaiVO.AD1BAITAINM + ",");
        sql.append(" " + TBTHBAMST.FIELD5 + " " + AddChangeReportLionBaitaiVO.AD1BAITAISORTNO + ",");
        sql.append(" TRIM(" + TBTHB92RRKKMEI.NAME10 + ") " + AddChangeReportLionBaitaiVO.AD1KENNM + ",");
        sql.append(" SUM(" + TBTHB92RRKKMEI.SEIGAK + ") " + AddChangeReportLionBaitaiVO.AD1SEIGAK + ",");
        sql.append(" TRIM(" + TBTHB92RRKKMEI.CODE3 + ") " + AddChangeReportLionBaitaiVO.AD1BRDCD);
        sql.append(" FROM");
        sql.append(" " + TBTHB91RRKDOWN.TBNAME + ",");
        sql.append(" " + TBTHB92RRKKMEI.TBNAME + ",");
        sql.append(" " + TBTHBAMST.TBNAME + "");
        sql.append(" WHERE");
        sql.append(" " + TBTHB92RRKKMEI.RRKTIMSTMP + " = TO_DATE('" + _cond.getRrkTimStmp() + "', 'yyyy/MM/dd HH24:MI:SS') AND");
        sql.append(" " + TBTHB92RRKKMEI.EGCD + " = '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB92RRKKMEI.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB92RRKKMEI.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB92RRKKMEI.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB92RRKKMEI.YYMM + " = '" + _cond.getYymm() + "' AND");
        sql.append(" " + TBTHB91RRKDOWN.RRKTIMSTMP + " = " + TBTHB92RRKKMEI.RRKTIMSTMP + " AND");
        sql.append(" " + TBTHB91RRKDOWN.EGCD + " = " + TBTHB92RRKKMEI.EGCD + " AND");
        sql.append(" " + TBTHB91RRKDOWN.TKSKGYCD + " = " + TBTHB92RRKKMEI.TKSKGYCD + " AND");
        sql.append(" " + TBTHB91RRKDOWN.TKSBMNSEQNO + " = " + TBTHB92RRKKMEI.TKSBMNSEQNO + " AND");
        sql.append(" " + TBTHB91RRKDOWN.TKSTNTSEQNO + " = " + TBTHB92RRKKMEI.TKSTNTSEQNO + " AND");
        sql.append(" " + TBTHB91RRKDOWN.YYMM + " = " + TBTHB92RRKKMEI.YYMM + " AND");
        sql.append(" " + TBTHB91RRKDOWN.JYUTNO + " = " + TBTHB92RRKKMEI.JYUTNO + " AND");
        sql.append(" " + TBTHB91RRKDOWN.JYMEINO + " = " + TBTHB92RRKKMEI.JYMEINO + " AND");
        sql.append(" " + TBTHB91RRKDOWN.URMEINO + " = " + TBTHB92RRKKMEI.URMEINO + " AND");
        sql.append(" " + TBTHB91RRKDOWN.TJYUTNO + " = ' ' AND");
        sql.append(" " + TBTHB92RRKKMEI.CODE6 + " <> '" + SEISAKU + "' AND");
        sql.append(" " + TBTHBAMST.SYBT + "= '" + BAITAI_M + "' AND");
        sql.append(" " + TBTHB92RRKKMEI.EGCD + " = " + TBTHBAMST.EGCD + "(+) AND");
        sql.append(" " + TBTHB92RRKKMEI.TKSKGYCD + " = " + TBTHBAMST.TKSKGYCD + "(+) AND");
        sql.append(" " + TBTHB92RRKKMEI.TKSBMNSEQNO + " = " + TBTHBAMST.TKSBMNSEQNO + "(+) AND");
        sql.append(" " + TBTHB92RRKKMEI.TKSTNTSEQNO + " = " + TBTHBAMST.TKSTNTSEQNO + "(+) AND");
        sql.append(" TRIM(" + TBTHB92RRKKMEI.CODE1+ ") = " + TBTHBAMST.FIELD1 + "(+)");
        sql.append(" GROUP BY");
        sql.append(" " + TBTHB92RRKKMEI.JYUTNO + ",");
        sql.append(" " + TBTHB92RRKKMEI.JYMEINO + ",");
        sql.append(" " + TBTHB92RRKKMEI.URMEINO + ",");
        sql.append(" " + TBTHBAMST.FIELD1 + ",");
        sql.append(" " + TBTHBAMST.FIELD4 + ",");
        sql.append(" " + TBTHBAMST.FIELD5 + ",");
        sql.append(" " + TBTHB92RRKKMEI.NAME10 + ",");
        sql.append(" " + TBTHB92RRKKMEI.CODE3);
        sql.append(" ),");

        //AD2
        sql.append(" " + VWNAME_AD2 + " AS (");
        sql.append(" SELECT");
        sql.append(" /*+ ORDERED */");
        sql.append(" " + TBTHB2KMEI.JYUTNO + " " + AddChangeReportLionBaitaiVO.AD2JYUTNO + ",");
        sql.append(" " + TBTHB2KMEI.JYMEINO + " " + AddChangeReportLionBaitaiVO.AD2JYMEINO + ",");
        sql.append(" " + TBTHB2KMEI.URMEINO + " " + AddChangeReportLionBaitaiVO.AD2URMEINO + ",");
        sql.append(" " + TBTHBAMST.FIELD1 + " " + AddChangeReportLionBaitaiVO.AD2BAITAIKBN + ",");
        sql.append(" " + TBTHBAMST.FIELD4 + " " + AddChangeReportLionBaitaiVO.AD2BAITAINM + ",");
        sql.append(" " + TBTHBAMST.FIELD5 + " " + AddChangeReportLionBaitaiVO.AD2BAITAISORTNO + ",");
        sql.append(" TRIM(" + TBTHB2KMEI.NAME10 + ") " + AddChangeReportLionBaitaiVO.AD2KENNM + ",");
        sql.append(" SUM(" + TBTHB2KMEI.SEIGAK + ") " + AddChangeReportLionBaitaiVO.AD2SEIGAK + ",");
        sql.append(" TRIM(" + TBTHB2KMEI.CODE3 + ") " + AddChangeReportLionBaitaiVO.AD2BRDCD);
        sql.append(" FROM");
        sql.append(" " + TBTHB1DOWN.TBNAME + ",");
        sql.append(" " + TBTHB2KMEI.TBNAME + ",");
        sql.append(" " + TBTHBAMST.TBNAME);
        sql.append(" WHERE");
        sql.append(" " + TBTHB2KMEI.EGCD + " = '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.YYMM + " = '" + _cond.getYymm() + "' AND");
        sql.append(" " + TBTHB1DOWN.EGCD + " = " + TBTHB2KMEI.EGCD + " AND");
        sql.append(" " + TBTHB1DOWN.TKSKGYCD + " = " + TBTHB2KMEI.TKSKGYCD + " AND");
        sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + " = " + TBTHB2KMEI.TKSBMNSEQNO + " AND");
        sql.append(" " + TBTHB1DOWN.YYMM + " = " + TBTHB2KMEI.YYMM + " AND");
        sql.append(" " + TBTHB1DOWN.JYUTNO + " = " + TBTHB2KMEI.JYUTNO + " AND");
        sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + " = " + TBTHB2KMEI.TKSTNTSEQNO + " AND");
        sql.append(" " + TBTHB1DOWN.JYMEINO + " = " + TBTHB2KMEI.JYMEINO + " AND");
        sql.append(" " + TBTHB1DOWN.URMEINO + " = " + TBTHB2KMEI.URMEINO + " AND");
        sql.append(" " + TBTHB1DOWN.TJYUTNO + " = ' ' AND");
        sql.append(" " + TBTHB2KMEI.CODE6 + " <> '" + SEISAKU + "' AND");
        sql.append(" " + TBTHBAMST.SYBT + " = '" + BAITAI_M + "' AND");
        sql.append(" " + TBTHB2KMEI.EGCD + " = " + TBTHBAMST.EGCD + "(+) AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = " + TBTHBAMST.TKSKGYCD + "(+) AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = " + TBTHBAMST.TKSBMNSEQNO + "(+) AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = " + TBTHBAMST.TKSTNTSEQNO + "(+) AND");
        sql.append(" TRIM(" + TBTHB2KMEI.CODE1 + ") = " + TBTHBAMST.FIELD1 + "(+)");
        sql.append(" GROUP BY");
        sql.append(" " + TBTHB2KMEI.JYUTNO + ",");
        sql.append(" " + TBTHB2KMEI.JYMEINO + ",");
        sql.append(" " + TBTHB2KMEI.URMEINO + ",");
        sql.append(" " + TBTHBAMST.FIELD1 + ",");
        sql.append(" " + TBTHBAMST.FIELD4 + ",");
        sql.append(" " + TBTHBAMST.FIELD5 + ",");
        sql.append(" " + TBTHB2KMEI.NAME10 + ",");
        sql.append(" " + TBTHB2KMEI.CODE3);
        sql.append(" )");

        sql.append(" SELECT");
        sql.append(" " + AddChangeReportLionBaitaiVO.JYUTNO + ",");
        sql.append(" " + AddChangeReportLionBaitaiVO.JYMEINO + ",");
        sql.append(" " + AddChangeReportLionBaitaiVO.URMEINO + ",");
        sql.append(" " + AddChangeReportLionBaitaiVO.BAITAIKBN + ",");
        sql.append(" " + AddChangeReportLionBaitaiVO.BAITAINM + ",");
        sql.append(" " + AddChangeReportLionBaitaiVO.KENNM + ",");
        sql.append(" " + AddChangeReportLionBaitaiVO.AD1SEIGAK + ",");
        sql.append(" " + AddChangeReportLionBaitaiVO.AD2SEIGAK + ",");
        sql.append(" " + AddChangeReportLionBaitaiVO.SEQ + ",");
        sql.append(" " + AddChangeReportLionBaitaiVO.ORDERSEQ);
        sql.append(" FROM");
        sql.append(" (");

        //�ǉ�
        sql.append(" SELECT");
        sql.append(" /*+ ORDERED */");
        sql.append(" " + AddChangeReportLionBaitaiVO.AD2JYUTNO + " " + AddChangeReportLionBaitaiVO.JYUTNO + ",");
        sql.append(" " + AddChangeReportLionBaitaiVO.AD2JYMEINO + " " + AddChangeReportLionBaitaiVO.JYMEINO + ",");
        sql.append(" " + AddChangeReportLionBaitaiVO.AD2URMEINO + " " + AddChangeReportLionBaitaiVO.URMEINO + ",");
        sql.append(" " + AddChangeReportLionBaitaiVO.AD2BAITAIKBN + " " + AddChangeReportLionBaitaiVO.BAITAIKBN + ",");
        sql.append(" " + AddChangeReportLionBaitaiVO.AD2BAITAINM + " " + AddChangeReportLionBaitaiVO.BAITAINM + ",");
        sql.append(" " + AddChangeReportLionBaitaiVO.AD2BAITAISORTNO + " " + AddChangeReportLionBaitaiVO.BAITAISORTNO + ",");
        sql.append(" " + AddChangeReportLionBaitaiVO.AD2KENNM + " " + AddChangeReportLionBaitaiVO.KENNM + ",");
        sql.append(" -1 " + AddChangeReportLionBaitaiVO.AD1SEIGAK + ",");
        sql.append(" " + AddChangeReportLionBaitaiVO.AD2SEIGAK + ",");
        sql.append(" '1' " + AddChangeReportLionBaitaiVO.SEQ + ",");
        sql.append(" '2' " + AddChangeReportLionBaitaiVO.ORDERSEQ);
        sql.append(" FROM");
        sql.append(" " + VWNAME_AD2 + " A");
        sql.append(" WHERE NOT EXISTS");
        sql.append(" (");
        sql.append(" SELECT");
        sql.append(" 1");
        sql.append(" FROM");
        sql.append(" " + VWNAME_AD1 + " B");
        sql.append(" WHERE");
        sql.append(" A." + AddChangeReportLionBaitaiVO.AD2JYUTNO + " = B." + AddChangeReportLionBaitaiVO.AD1JYUTNO + " AND");
        sql.append(" A." + AddChangeReportLionBaitaiVO.AD2JYMEINO + " = B." + AddChangeReportLionBaitaiVO.AD1JYMEINO + " AND");
        sql.append(" A." + AddChangeReportLionBaitaiVO.AD2URMEINO + " = B." + AddChangeReportLionBaitaiVO.AD1URMEINO);
        sql.append(" )");

        sql.append(" UNION ALL");

        //�폜
        sql.append(" SELECT");
        sql.append(" /*+ ORDERED */");
        sql.append(" " + AddChangeReportLionBaitaiVO.AD1JYUTNO + ",");
        sql.append(" " + AddChangeReportLionBaitaiVO.AD1JYMEINO + ",");
        sql.append(" " + AddChangeReportLionBaitaiVO.AD1URMEINO + ",");
        sql.append(" " + AddChangeReportLionBaitaiVO.AD1BAITAIKBN + ",");
        sql.append(" " + AddChangeReportLionBaitaiVO.AD1BAITAINM + ",");
        sql.append(" " + AddChangeReportLionBaitaiVO.AD1BAITAISORTNO + ",");
        sql.append(" " + AddChangeReportLionBaitaiVO.AD1KENNM + ",");
        sql.append(" " + AddChangeReportLionBaitaiVO.AD1SEIGAK + ",");
        sql.append(" -1 " + AddChangeReportLionBaitaiVO.AD2SEIGAK + ",");
        sql.append(" '2' " + AddChangeReportLionBaitaiVO.SEQ + ",");
        sql.append(" '2' " + AddChangeReportLionBaitaiVO.ORDERSEQ);
        sql.append(" FROM");
        sql.append(" " + VWNAME_AD1 + " C");
        sql.append(" WHERE NOT EXISTS");
        sql.append(" (");
        sql.append(" SELECT");
        sql.append(" 1");
        sql.append(" FROM");
        sql.append(" " + VWNAME_AD2 + " D");
        sql.append(" WHERE");
        sql.append(" C." + AddChangeReportLionBaitaiVO.AD1JYUTNO + " = D." + AddChangeReportLionBaitaiVO.AD2JYUTNO + " AND");
        sql.append(" C." + AddChangeReportLionBaitaiVO.AD1JYMEINO + " = D." + AddChangeReportLionBaitaiVO.AD2JYMEINO + " AND");
        sql.append(" C." + AddChangeReportLionBaitaiVO.AD1URMEINO + " = D." + AddChangeReportLionBaitaiVO.AD2URMEINO);
        sql.append(" )");

        sql.append(" UNION ALL");

        //�}�̕ύX��(AD2)
        sql.append(" SELECT");
        sql.append(" /*+ ORDERED */");
        sql.append(" F." + AddChangeReportLionBaitaiVO.AD2JYUTNO + ",");
        sql.append(" F." + AddChangeReportLionBaitaiVO.AD2JYMEINO + ",");
        sql.append(" F." + AddChangeReportLionBaitaiVO.AD2URMEINO + ",");
        sql.append(" F." + AddChangeReportLionBaitaiVO.AD2BAITAIKBN + ",");
        sql.append(" F." + AddChangeReportLionBaitaiVO.AD2BAITAINM + ",");
        sql.append(" F." + AddChangeReportLionBaitaiVO.AD2BAITAISORTNO + ",");
        sql.append(" F." + AddChangeReportLionBaitaiVO.AD2KENNM + ",");
        sql.append(" -1 " + AddChangeReportLionBaitaiVO.AD1SEIGAK + ",");
        sql.append(" F." + AddChangeReportLionBaitaiVO.AD2SEIGAK + ",");
        sql.append(" '3' " + AddChangeReportLionBaitaiVO.SEQ + ",");
        sql.append(" '2' " + AddChangeReportLionBaitaiVO.ORDERSEQ);
        sql.append(" FROM");
        sql.append(" " + VWNAME_AD1 + " E,");
        sql.append(" " + VWNAME_AD2 + " F");
        sql.append(" WHERE");
        sql.append(" E." + AddChangeReportLionBaitaiVO.AD1JYUTNO + " = F." + AddChangeReportLionBaitaiVO.AD2JYUTNO + " AND");
        sql.append(" E." + AddChangeReportLionBaitaiVO.AD1JYMEINO + " = F." + AddChangeReportLionBaitaiVO.AD2JYMEINO + " AND");
        sql.append(" E." + AddChangeReportLionBaitaiVO.AD1URMEINO + " = F." + AddChangeReportLionBaitaiVO.AD2URMEINO + " AND");
        sql.append(" E." + AddChangeReportLionBaitaiVO.AD1BAITAIKBN + " <> F." + AddChangeReportLionBaitaiVO.AD2BAITAIKBN);

        sql.append(" UNION ALL");

        //�}�̕ύX��(AD1)
        sql.append(" SELECT");
        sql.append(" /*+ ORDERED */");
        sql.append(" E." + AddChangeReportLionBaitaiVO.AD1JYUTNO + ",");
        sql.append(" E." + AddChangeReportLionBaitaiVO.AD1JYMEINO + ",");
        sql.append(" E." + AddChangeReportLionBaitaiVO.AD1URMEINO + ",");
        sql.append(" E." + AddChangeReportLionBaitaiVO.AD1BAITAIKBN + ",");
        sql.append(" E." + AddChangeReportLionBaitaiVO.AD1BAITAINM + ",");
        sql.append(" E." + AddChangeReportLionBaitaiVO.AD1BAITAISORTNO + ",");
        sql.append(" E." + AddChangeReportLionBaitaiVO.AD1KENNM + ",");
        sql.append(" E." + AddChangeReportLionBaitaiVO.AD1SEIGAK + ",");
        sql.append(" -1 " + AddChangeReportLionBaitaiVO.AD2SEIGAK + ",");
        sql.append(" '4' " + AddChangeReportLionBaitaiVO.SEQ + ",");
        sql.append(" '2' " + AddChangeReportLionBaitaiVO.ORDERSEQ);
        sql.append(" FROM");
        sql.append(" " + VWNAME_AD1 + " E,");
        sql.append(" " + VWNAME_AD2 + " F");
        sql.append(" WHERE");
        sql.append(" E." + AddChangeReportLionBaitaiVO.AD1JYUTNO + " = F." + AddChangeReportLionBaitaiVO.AD2JYUTNO + " AND");
        sql.append(" E." + AddChangeReportLionBaitaiVO.AD1JYMEINO + " = F." + AddChangeReportLionBaitaiVO.AD2JYMEINO + " AND");
        sql.append(" E." + AddChangeReportLionBaitaiVO.AD1URMEINO + " = F." + AddChangeReportLionBaitaiVO.AD2URMEINO + " AND");
        sql.append(" E." + AddChangeReportLionBaitaiVO.AD1BAITAIKBN + " <> F." + AddChangeReportLionBaitaiVO.AD2BAITAIKBN);

        sql.append(" UNION ALL");

        //�����ύX(�^�C���ABS/CS�ȊO)
        sql.append(" SELECT");
        sql.append(" /*+ ORDERED */");
        sql.append(" F." + AddChangeReportLionBaitaiVO.AD2JYUTNO + ",");
        sql.append(" F." + AddChangeReportLionBaitaiVO.AD2JYMEINO + ",");
        sql.append(" F." + AddChangeReportLionBaitaiVO.AD2URMEINO + ",");
        sql.append(" F." + AddChangeReportLionBaitaiVO.AD2BAITAIKBN + ",");
        sql.append(" F." + AddChangeReportLionBaitaiVO.AD2BAITAINM + ",");
        sql.append(" F." + AddChangeReportLionBaitaiVO.AD2BAITAISORTNO + ",");
        sql.append(" F." + AddChangeReportLionBaitaiVO.AD2KENNM + ",");
        sql.append(" E." + AddChangeReportLionBaitaiVO.AD1SEIGAK + ",");
        sql.append(" F." + AddChangeReportLionBaitaiVO.AD2SEIGAK + ",");
        sql.append(" '5' " + AddChangeReportLionBaitaiVO.SEQ + ",");
        sql.append(" '2' " + AddChangeReportLionBaitaiVO.ORDERSEQ);
        sql.append(" FROM");
        sql.append(" " + VWNAME_AD1 + " E,");
        sql.append(" " + VWNAME_AD2 + " F,");
        sql.append(" " + TBTHBAMST.TBNAME);
        sql.append(" WHERE");
        sql.append(" E." + AddChangeReportLionBaitaiVO.AD1JYUTNO + " = F." + AddChangeReportLionBaitaiVO.AD2JYUTNO + " AND");
        sql.append(" E." + AddChangeReportLionBaitaiVO.AD1JYMEINO + " = F." + AddChangeReportLionBaitaiVO.AD2JYMEINO + " AND");
        sql.append(" E." + AddChangeReportLionBaitaiVO.AD1URMEINO + " = F." + AddChangeReportLionBaitaiVO.AD2URMEINO + " AND");
        sql.append(" E." + AddChangeReportLionBaitaiVO.AD1BAITAIKBN + " = F." + AddChangeReportLionBaitaiVO.AD2BAITAIKBN + " AND");
        sql.append(" E." + AddChangeReportLionBaitaiVO.AD1KENNM + " <> F." + AddChangeReportLionBaitaiVO.AD2KENNM + " AND");
        sql.append(" E." + AddChangeReportLionBaitaiVO.AD1SEIGAK + " = F." + AddChangeReportLionBaitaiVO.AD2SEIGAK + " AND");
        sql.append(" F." + AddChangeReportLionBaitaiVO.AD2BRDCD + " = " + TBTHBAMST.FIELD1 + " AND");
        sql.append(" " + TBTHBAMST.EGCD + " = '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHBAMST.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHBAMST.SYBT + " = '" + BRAND_M + "' AND");
        sql.append(" F." + AddChangeReportLionBaitaiVO.AD2BAITAIKBN + " NOT IN ( '" + TVTIME + "', '" + RDTIME + "', '" + BSCS + "' )");

        sql.append(" UNION ALL");

        //�����ύX(�^�C���ABS/CS)
        sql.append(" SELECT");
        sql.append(" /*+ ORDERED */");
        sql.append(" F." + AddChangeReportLionBaitaiVO.AD2JYUTNO + ",");
        sql.append(" F." + AddChangeReportLionBaitaiVO.AD2JYMEINO + ",");
        sql.append(" F." + AddChangeReportLionBaitaiVO.AD2URMEINO + ",");
        sql.append(" F." + AddChangeReportLionBaitaiVO.AD2BAITAIKBN + ",");
        sql.append(" F." + AddChangeReportLionBaitaiVO.AD2BAITAINM + ",");
        sql.append(" F." + AddChangeReportLionBaitaiVO.AD2BAITAISORTNO + ",");
        sql.append(" F." + AddChangeReportLionBaitaiVO.AD2KENNM + ",");
        sql.append(" E." + AddChangeReportLionBaitaiVO.AD1SEIGAK + ",");
        sql.append(" F." + AddChangeReportLionBaitaiVO.AD2SEIGAK + ",");
        sql.append(" '5' " + AddChangeReportLionBaitaiVO.SEQ + ",");
        sql.append(" '2' " + AddChangeReportLionBaitaiVO.ORDERSEQ);
        sql.append(" FROM");
        sql.append(" " + VWNAME_AD1 + " E,");
        sql.append(" " + VWNAME_AD2 + " F");
        sql.append(" WHERE");
        sql.append(" E." + AddChangeReportLionBaitaiVO.AD1JYUTNO + " = F." + AddChangeReportLionBaitaiVO.AD2JYUTNO + " AND");
        sql.append(" E." + AddChangeReportLionBaitaiVO.AD1JYMEINO + " = F." + AddChangeReportLionBaitaiVO.AD2JYMEINO + " AND");
        sql.append(" E." + AddChangeReportLionBaitaiVO.AD1URMEINO + " = F." + AddChangeReportLionBaitaiVO.AD2URMEINO + " AND");
        sql.append(" E." + AddChangeReportLionBaitaiVO.AD1BAITAIKBN + " = F." + AddChangeReportLionBaitaiVO.AD2BAITAIKBN + " AND");
        sql.append(" E." + AddChangeReportLionBaitaiVO.AD1KENNM + " <> F." + AddChangeReportLionBaitaiVO.AD2KENNM + " AND");
        sql.append(" E." + AddChangeReportLionBaitaiVO.AD1SEIGAK + " = F." + AddChangeReportLionBaitaiVO.AD2SEIGAK + " AND");
        sql.append(" F." + AddChangeReportLionBaitaiVO.AD2BAITAIKBN + " IN ( '" + TVTIME + "', '" + RDTIME + "', '" + BSCS + "' )");

        sql.append(" UNION ALL");

        //���z�ύX(�^�C���ABS/CS�ȊO)
        sql.append(" SELECT");
        sql.append(" /*+ ORDERED */");
        sql.append(" F." + AddChangeReportLionBaitaiVO.AD2JYUTNO + ",");
        sql.append(" F." + AddChangeReportLionBaitaiVO.AD2JYMEINO + ",");
        sql.append(" F." + AddChangeReportLionBaitaiVO.AD2URMEINO + ",");
        sql.append(" F." + AddChangeReportLionBaitaiVO.AD2BAITAIKBN + ",");
        sql.append(" F." + AddChangeReportLionBaitaiVO.AD2BAITAINM + ",");
        sql.append(" F." + AddChangeReportLionBaitaiVO.AD2BAITAISORTNO + ",");
        sql.append(" F." + AddChangeReportLionBaitaiVO.AD2KENNM + ",");
        sql.append(" E." + AddChangeReportLionBaitaiVO.AD1SEIGAK + ",");
        sql.append(" F." + AddChangeReportLionBaitaiVO.AD2SEIGAK + ",");
        sql.append(" '6' " + AddChangeReportLionBaitaiVO.SEQ + ",");
        sql.append(" '2' " + AddChangeReportLionBaitaiVO.ORDERSEQ);
        sql.append(" FROM");
        sql.append(" " + VWNAME_AD1 + " E,");
        sql.append(" " + VWNAME_AD2 + " F,");
        sql.append(" " + TBTHBAMST.TBNAME);
        sql.append(" WHERE");
        sql.append(" E." + AddChangeReportLionBaitaiVO.AD1JYUTNO + " = F." + AddChangeReportLionBaitaiVO.AD2JYUTNO + " AND");
        sql.append(" E." + AddChangeReportLionBaitaiVO.AD1JYMEINO + " = F." + AddChangeReportLionBaitaiVO.AD2JYMEINO + " AND");
        sql.append(" E." + AddChangeReportLionBaitaiVO.AD1URMEINO + " = F." + AddChangeReportLionBaitaiVO.AD2URMEINO + " AND");
        sql.append(" E." + AddChangeReportLionBaitaiVO.AD1BAITAIKBN + " = F." + AddChangeReportLionBaitaiVO.AD2BAITAIKBN + " AND");
        sql.append(" E." + AddChangeReportLionBaitaiVO.AD1KENNM + " = F." + AddChangeReportLionBaitaiVO.AD2KENNM + " AND");
        sql.append(" E." + AddChangeReportLionBaitaiVO.AD1SEIGAK + " <> F." + AddChangeReportLionBaitaiVO.AD2SEIGAK + " AND");
        sql.append(" F." + AddChangeReportLionBaitaiVO.AD2BRDCD + " = " + TBTHBAMST.FIELD1 + " AND");
        sql.append(" " + TBTHBAMST.EGCD + " = '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHBAMST.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHBAMST.SYBT + " = '" + BRAND_M + "' AND");
        sql.append(" F." + AddChangeReportLionBaitaiVO.AD2BAITAIKBN + " NOT IN ( '" + TVTIME + "', '" + RDTIME + "', '" + BSCS + "' )");

        sql.append(" UNION ALL");

        //���z�ύX(�^�C���ABS/CS)
        sql.append(" SELECT");
        sql.append(" /*+ ORDERED */");
        sql.append(" F." + AddChangeReportLionBaitaiVO.AD2JYUTNO + ",");
        sql.append(" F." + AddChangeReportLionBaitaiVO.AD2JYMEINO + ",");
        sql.append(" F." + AddChangeReportLionBaitaiVO.AD2URMEINO + ",");
        sql.append(" F." + AddChangeReportLionBaitaiVO.AD2BAITAIKBN + ",");
        sql.append(" F." + AddChangeReportLionBaitaiVO.AD2BAITAINM + ",");
        sql.append(" F." + AddChangeReportLionBaitaiVO.AD2BAITAISORTNO + ",");
        sql.append(" F." + AddChangeReportLionBaitaiVO.AD2KENNM + ",");
        sql.append(" E." + AddChangeReportLionBaitaiVO.AD1SEIGAK + ",");
        sql.append(" F." + AddChangeReportLionBaitaiVO.AD2SEIGAK + ",");
        sql.append(" '6' " + AddChangeReportLionBaitaiVO.SEQ + ",");
        sql.append(" '2' " + AddChangeReportLionBaitaiVO.ORDERSEQ);
        sql.append(" FROM");
        sql.append(" " + VWNAME_AD1 + " E,");
        sql.append(" " + VWNAME_AD2 + " F");
        sql.append(" WHERE");
        sql.append(" E." + AddChangeReportLionBaitaiVO.AD1JYUTNO + " = F." + AddChangeReportLionBaitaiVO.AD2JYUTNO + " AND");
        sql.append(" E." + AddChangeReportLionBaitaiVO.AD1JYMEINO + " = F." + AddChangeReportLionBaitaiVO.AD2JYMEINO + " AND");
        sql.append(" E." + AddChangeReportLionBaitaiVO.AD1URMEINO + " = F." + AddChangeReportLionBaitaiVO.AD2URMEINO + " AND");
        sql.append(" E." + AddChangeReportLionBaitaiVO.AD1BAITAIKBN + " = F." + AddChangeReportLionBaitaiVO.AD2BAITAIKBN + " AND");
        sql.append(" E." + AddChangeReportLionBaitaiVO.AD1KENNM + " = F." + AddChangeReportLionBaitaiVO.AD2KENNM + " AND");
        sql.append(" E." + AddChangeReportLionBaitaiVO.AD1SEIGAK + " <> F." + AddChangeReportLionBaitaiVO.AD2SEIGAK + " AND");
        sql.append(" F." + AddChangeReportLionBaitaiVO.AD2BAITAIKBN + " IN ( '" + TVTIME + "', '" + RDTIME + "', '" + BSCS + "' )");

        sql.append(" UNION ALL");

        //�����ύX�E���z�ύX(�^�C���ABS/CS�ȊO)
        sql.append(" SELECT");
        sql.append(" /*+ ORDERED */");
        sql.append(" F." + AddChangeReportLionBaitaiVO.AD2JYUTNO + ",");
        sql.append(" F." + AddChangeReportLionBaitaiVO.AD2JYMEINO + ",");
        sql.append(" F." + AddChangeReportLionBaitaiVO.AD2URMEINO + ",");
        sql.append(" F." + AddChangeReportLionBaitaiVO.AD2BAITAIKBN + ",");
        sql.append(" F." + AddChangeReportLionBaitaiVO.AD2BAITAINM + ",");
        sql.append(" F." + AddChangeReportLionBaitaiVO.AD2BAITAISORTNO + ",");
        sql.append(" F." + AddChangeReportLionBaitaiVO.AD2KENNM + ",");
        sql.append(" E." + AddChangeReportLionBaitaiVO.AD1SEIGAK + ",");
        sql.append(" F." + AddChangeReportLionBaitaiVO.AD2SEIGAK + ",");
        sql.append(" '7' " + AddChangeReportLionBaitaiVO.SEQ + ",");
        sql.append(" '2' " + AddChangeReportLionBaitaiVO.ORDERSEQ);
        sql.append(" FROM");
        sql.append(" " + VWNAME_AD1 + " E,");
        sql.append(" " + VWNAME_AD2 + " F,");
        sql.append(" " + TBTHBAMST.TBNAME);
        sql.append(" WHERE");
        sql.append(" E." + AddChangeReportLionBaitaiVO.AD1JYUTNO + " = F." + AddChangeReportLionBaitaiVO.AD2JYUTNO + " AND");
        sql.append(" E." + AddChangeReportLionBaitaiVO.AD1JYMEINO + " = F." + AddChangeReportLionBaitaiVO.AD2JYMEINO + " AND");
        sql.append(" E." + AddChangeReportLionBaitaiVO.AD1URMEINO + " = F." + AddChangeReportLionBaitaiVO.AD2URMEINO + " AND");
        sql.append(" E." + AddChangeReportLionBaitaiVO.AD1BAITAIKBN + " = F." + AddChangeReportLionBaitaiVO.AD2BAITAIKBN + " AND");
        sql.append(" E." + AddChangeReportLionBaitaiVO.AD1KENNM + " <> F." + AddChangeReportLionBaitaiVO.AD2KENNM + " AND");
        sql.append(" E." + AddChangeReportLionBaitaiVO.AD1SEIGAK + " <> F." + AddChangeReportLionBaitaiVO.AD2SEIGAK + " AND");
        sql.append(" F." + AddChangeReportLionBaitaiVO.AD2BRDCD + " = " + TBTHBAMST.FIELD1 + " AND");
        sql.append(" " + TBTHBAMST.EGCD + " = '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHBAMST.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHBAMST.SYBT + " = '" + BRAND_M + "' AND");
        sql.append(" F." + AddChangeReportLionBaitaiVO.AD2BAITAIKBN + " NOT IN ( '" + TVTIME + "', '" + RDTIME + "', '" + BSCS + "' )");

        sql.append(" UNION ALL");

        //�����ύX�E���z�ύX(�^�C���ABS/CS)
        sql.append(" SELECT");
        sql.append(" /*+ ORDERED */");
        sql.append(" F." + AddChangeReportLionBaitaiVO.AD2JYUTNO + ",");
        sql.append(" F." + AddChangeReportLionBaitaiVO.AD2JYMEINO + ",");
        sql.append(" F." + AddChangeReportLionBaitaiVO.AD2URMEINO + ",");
        sql.append(" F." + AddChangeReportLionBaitaiVO.AD2BAITAIKBN + ",");
        sql.append(" F." + AddChangeReportLionBaitaiVO.AD2BAITAINM + ",");
        sql.append(" F." + AddChangeReportLionBaitaiVO.AD2BAITAISORTNO + ",");
        sql.append(" F." + AddChangeReportLionBaitaiVO.AD2KENNM + ",");
        sql.append(" E." + AddChangeReportLionBaitaiVO.AD1SEIGAK + ",");
        sql.append(" F." + AddChangeReportLionBaitaiVO.AD2SEIGAK + ",");
        sql.append(" '7' " + AddChangeReportLionBaitaiVO.SEQ + ",");
        sql.append(" '2' " + AddChangeReportLionBaitaiVO.ORDERSEQ);
        sql.append(" FROM");
        sql.append(" " + VWNAME_AD1 + " E,");
        sql.append(" " + VWNAME_AD2 + " F");
        sql.append(" WHERE");
        sql.append(" E." + AddChangeReportLionBaitaiVO.AD1JYUTNO + " = F." + AddChangeReportLionBaitaiVO.AD2JYUTNO + " AND");
        sql.append(" E." + AddChangeReportLionBaitaiVO.AD1JYMEINO + " = F." + AddChangeReportLionBaitaiVO.AD2JYMEINO + " AND");
        sql.append(" E." + AddChangeReportLionBaitaiVO.AD1URMEINO + " = F." + AddChangeReportLionBaitaiVO.AD2URMEINO + " AND");
        sql.append(" E." + AddChangeReportLionBaitaiVO.AD1BAITAIKBN + " = F." + AddChangeReportLionBaitaiVO.AD2BAITAIKBN + " AND");
        sql.append(" E." + AddChangeReportLionBaitaiVO.AD1KENNM + " <> F." + AddChangeReportLionBaitaiVO.AD2KENNM + " AND");
        sql.append(" E." + AddChangeReportLionBaitaiVO.AD1SEIGAK + " <> F." + AddChangeReportLionBaitaiVO.AD2SEIGAK + " AND");
        sql.append(" F." + AddChangeReportLionBaitaiVO.AD2BAITAIKBN + " IN ( '" + TVTIME + "', '" + RDTIME + "', '" + BSCS + "' )");

        sql.append(" UNION ALL");

        //�f�ړ��m��(�V���Œʔ�)
        sql.append(" SELECT");
        sql.append(" /*+ ORDERED */");
        sql.append(" F." + AddChangeReportLionBaitaiVO.AD2JYUTNO + ",");
        sql.append(" F." + AddChangeReportLionBaitaiVO.AD2JYMEINO + ",");
        sql.append(" F." + AddChangeReportLionBaitaiVO.AD2URMEINO + ",");
        sql.append(" F." + AddChangeReportLionBaitaiVO.AD2BAITAIKBN + ",");
        sql.append(" F." + AddChangeReportLionBaitaiVO.AD2BAITAINM + ",");
        sql.append(" F." + AddChangeReportLionBaitaiVO.AD2BAITAISORTNO + ",");
        sql.append(" F." + AddChangeReportLionBaitaiVO.AD2KENNM + ",");
        sql.append(" E." + AddChangeReportLionBaitaiVO.AD1SEIGAK + ",");
        sql.append(" F." + AddChangeReportLionBaitaiVO.AD2SEIGAK + ",");
        sql.append(" '8' " + AddChangeReportLionBaitaiVO.SEQ + ",");
        sql.append(" '1' " + AddChangeReportLionBaitaiVO.ORDERSEQ);
        sql.append(" FROM");
        sql.append(" " + VWNAME_AD1 + " E,");
        sql.append(" " + VWNAME_AD2 + " F,");
        sql.append(" " + TBTHBAMST.TBNAME);
        sql.append(" WHERE");
        sql.append(" E." + AddChangeReportLionBaitaiVO.AD1JYUTNO + " = F." + AddChangeReportLionBaitaiVO.AD2JYUTNO + " AND");
        sql.append(" E." + AddChangeReportLionBaitaiVO.AD1JYMEINO + " = F." + AddChangeReportLionBaitaiVO.AD2JYMEINO + " AND");
        sql.append(" E." + AddChangeReportLionBaitaiVO.AD1URMEINO + " = F." + AddChangeReportLionBaitaiVO.AD2URMEINO + " AND");
        sql.append(" E." + AddChangeReportLionBaitaiVO.AD1BAITAIKBN + " = F." + AddChangeReportLionBaitaiVO.AD2BAITAIKBN + " AND");
        sql.append(" E." + AddChangeReportLionBaitaiVO.AD1KENNM + " = F." + AddChangeReportLionBaitaiVO.AD2KENNM + " AND");
        sql.append(" E." + AddChangeReportLionBaitaiVO.AD1SEIGAK + " = F." + AddChangeReportLionBaitaiVO.AD2SEIGAK + " AND");
        sql.append(" E." + AddChangeReportLionBaitaiVO.AD1BRDCD + " = F." + AddChangeReportLionBaitaiVO.AD2BRDCD + " AND");
        sql.append(" E." + AddChangeReportLionBaitaiVO.AD1BAITAIKBN + " = '" + NEWSPAPER + "' AND");
        sql.append(" F." + AddChangeReportLionBaitaiVO.AD2BRDCD + " = " + TBTHBAMST.FIELD1 + " AND");
        sql.append(" " + TBTHBAMST.EGCD + " = '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHBAMST.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHBAMST.SYBT + " = '" + BRAND_M + "' AND");
        sql.append(" UPPER(" + TBTHBAMST.FIELD5 + ") = 'TRUE'");
        sql.append(" )");

        sql.append(" ORDER BY");
        sql.append(" " + AddChangeReportLionBaitaiVO.BAITAISORTNO + ",");
        sql.append(" " + AddChangeReportLionBaitaiVO.JYUTNO + ",");
        sql.append(" " + AddChangeReportLionBaitaiVO.JYMEINO + ",");
        sql.append(" " + AddChangeReportLionBaitaiVO.URMEINO);

        return sql.toString();
    }

    /**
     * ���C�I���ǉ��ύX���X�g�f�[�^�̌������s���܂��B
     * @param cond ���C�I�����[(�ǉ��ύX���X�g)��������
     * @return ���C�I���ǉ��ύX���X�g�f�[�^�擾VO���X�g
     * @throws KKHException �f�[�^�A�N�Z�X���ɃG���[�����������ꍇ
     */
    @SuppressWarnings("unchecked")
    public List<AddChangeReportLionBaitaiVO> findAddChangeReportBaitai(AddChangeReportLionBaitaiCondition cond) throws KKHException {
        super.setModel(new AddChangeReportLionBaitaiVO());

        try {
            _cond = cond;
            _sqlMode = cond.getFindType();
            return (List<AddChangeReportLionBaitaiVO>)super.find();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0002");
        }
    }

    /**
     * ���C�I���ǉ��ύX���X�g�����f�[�^(��������)�̌������s���܂��B
     * @param cond ���C�I�����[(�ǉ��ύX���X�g)��������
     * @return ���C�I���ǉ��ύX���X�g�f�[�^�擾VO���X�g
     * @throws KKHException �f�[�^�A�N�Z�X���ɃG���[�����������ꍇ
     */
    @SuppressWarnings("unchecked")
    public List<AddChangeReportLionBaitaiVO> findAddChangeReportBaitaiDiffInternal(AddChangeReportLionBaitaiCondition cond) throws KKHException {
        super.setModel(new AddChangeReportLionBaitaiVO());

        try {
            _cond = cond;
            _sqlMode = BAITAIDIFFINTERNAL;
            return (List<AddChangeReportLionBaitaiVO>)super.find();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0002");
        }
    }

    /**
     * ���C�I���ǉ��ύX���X�g�����f�[�^�̌������s���܂��B
     * @param cond ���C�I�����[(�ǉ��ύX���X�g)��������
     * @param baitaiList �}�̋敪���X�g
     * @return ���C�I���ǉ��ύX���X�g�f�[�^�擾VO���X�g
     * @throws KKHException �f�[�^�A�N�Z�X���ɃG���[�����������ꍇ
     */
    @SuppressWarnings("unchecked")
    public List<AddChangeReportLionBaitaiVO> findAddChangeReportBaitaiDiffExternal(AddChangeReportLionBaitaiCondition cond) throws KKHException {
        super.setModel(new AddChangeReportLionBaitaiVO());

        try {
            _cond = cond;
            _sqlMode = BAITAIDIFF;
            return (List<AddChangeReportLionBaitaiVO>)super.find();
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
     * @return List<AddChangeReportLionBaitaiVO> �ϊ���̌�������
     */
    @Override
    protected List<AddChangeReportLionBaitaiVO> createFindedModelInstances(List hashList) {
        List<AddChangeReportLionBaitaiVO> list = new ArrayList<AddChangeReportLionBaitaiVO>();
        for (int i = 0; i < hashList.size(); i++) {
            Map result = (Map) hashList.get(i);
            AddChangeReportLionBaitaiVO vo = new AddChangeReportLionBaitaiVO();

            //�����^�C���X�^���v�̏ꍇ
            if (_sqlMode.equals(RRKTIMSTMP)) {
                //�����^�C���X�^���v
                vo.setRrkTimStmp((String) result.get(AddChangeReportLionSeisakuVO.RRKTIMSTMP.toUpperCase()));
            }
            //�ǉ��ύX���X�g(AD1)�̏ꍇ
            if (_sqlMode.equals(BAITAIAD1)) {
                //��No
                vo.setJyutNo((String) result.get(AddChangeReportLionBaitaiVO.JYUTNO.toUpperCase()));
                //�󒍖���No
                vo.setJymeiNo((String) result.get(AddChangeReportLionBaitaiVO.JYMEINO.toUpperCase()));
                //���㖾��No
                vo.setUrmeiNo((String) result.get(AddChangeReportLionBaitaiVO.URMEINO.toUpperCase()));
                //�A��
                vo.setRenbn((String) result.get(AddChangeReportLionBaitaiVO.RENBN.toUpperCase()));
                //�}�̋敪�R�[�h
                vo.setBaitaiKbn((String) result.get(AddChangeReportLionBaitaiVO.BAITAIKBN.toUpperCase()));
                //�}�̋敪��
                vo.setBaitaiNm((String) result.get(AddChangeReportLionBaitaiVO.BAITAINM.toUpperCase()));
                //����
                vo.setKenNm((String) result.get(AddChangeReportLionBaitaiVO.KENNM.toUpperCase()));
                //�������z
                vo.setSeigak((BigDecimal) result.get(AddChangeReportLionBaitaiVO.SEIGAK.toUpperCase()));
                //�ǎ��R�[�h
                vo.setKykshCd((String) result.get(AddChangeReportLionBaitaiVO.KYKSHCD.toUpperCase()));
                //�ǃR�[�h
                vo.setKykCd((String) result.get(AddChangeReportLionBaitaiVO.KYKCD.toUpperCase()));
                //�ǖ�
                vo.setKykNm((String) result.get(AddChangeReportLionBaitaiVO.KYKNM.toUpperCase()));
                //CM�b��
                vo.setByosu((BigDecimal) result.get(AddChangeReportLionBaitaiVO.BYOSU.toUpperCase()));
                //CM�{��
                vo.setHonsu((BigDecimal) result.get(AddChangeReportLionBaitaiVO.HONSU.toUpperCase()));
                //�X�y�[�X
                vo.setSpace((String) result.get(AddChangeReportLionBaitaiVO.SPACE.toUpperCase()));
                //�f�ړ�
                vo.setKeisaibi((String) result.get(AddChangeReportLionBaitaiVO.KEISAIBI.toUpperCase()));
                //����
                vo.setTerm((String) result.get(AddChangeReportLionBaitaiVO.TERM.toUpperCase()));
            }
            //AD2�ǉ��ύX���X�g(AD2)�̏ꍇ
            else if (_sqlMode.equals(BAITAIAD2)) {
                //��No
                vo.setJyutNo((String) result.get(AddChangeReportLionBaitaiVO.JYUTNO.toUpperCase()));
                //�󒍖���No
                vo.setJymeiNo((String) result.get(AddChangeReportLionBaitaiVO.JYMEINO.toUpperCase()));
                //���㖾��No
                vo.setUrmeiNo((String) result.get(AddChangeReportLionBaitaiVO.URMEINO.toUpperCase()));
                //�A��
                vo.setRenbn((String) result.get(AddChangeReportLionBaitaiVO.RENBN.toUpperCase()));
                //�}�̋敪�R�[�h
                vo.setBaitaiKbn((String) result.get(AddChangeReportLionBaitaiVO.BAITAIKBN.toUpperCase()));
                //�}�̋敪��
                vo.setBaitaiNm((String) result.get(AddChangeReportLionBaitaiVO.BAITAINM.toUpperCase()));
                //����
                vo.setKenNm((String) result.get(AddChangeReportLionBaitaiVO.KENNM.toUpperCase()));
                //�������z
                vo.setSeigak((BigDecimal) result.get(AddChangeReportLionBaitaiVO.SEIGAK.toUpperCase()));
                //�ǎ��R�[�h
                vo.setKykshCd((String) result.get(AddChangeReportLionBaitaiVO.KYKSHCD.toUpperCase()));
                //�ǃR�[�h
                vo.setKykCd((String) result.get(AddChangeReportLionBaitaiVO.KYKCD.toUpperCase()));
                //�ǖ�
                vo.setKykNm((String) result.get(AddChangeReportLionBaitaiVO.KYKNM.toUpperCase()));
                //CM�b��
                vo.setByosu((BigDecimal) result.get(AddChangeReportLionBaitaiVO.BYOSU.toUpperCase()));
                //CM�{��
                vo.setHonsu((BigDecimal) result.get(AddChangeReportLionBaitaiVO.HONSU.toUpperCase()));
                //�X�y�[�X
                vo.setSpace((String) result.get(AddChangeReportLionBaitaiVO.SPACE.toUpperCase()));
                //�f�ړ�
                vo.setKeisaibi((String) result.get(AddChangeReportLionBaitaiVO.KEISAIBI.toUpperCase()));
                //����
                vo.setTerm((String) result.get(AddChangeReportLionBaitaiVO.TERM.toUpperCase()));
            }
            //�ǉ��ύX���X�g����(��������)�̏ꍇ
            else if (_sqlMode.equals(BAITAIDIFFINTERNAL)) {
                //��No
                vo.setJyutNo((String) result.get(AddChangeReportLionBaitaiVO.JYUTNO.toUpperCase()));
                //�󒍖���No
                vo.setJymeiNo((String) result.get(AddChangeReportLionBaitaiVO.JYMEINO.toUpperCase()));
                //���㖾��No
                vo.setUrmeiNo((String) result.get(AddChangeReportLionBaitaiVO.URMEINO.toUpperCase()));
                //�A��
                vo.setRenbn((String) result.get(AddChangeReportLionBaitaiVO.RENBN.toUpperCase()));
                //�}�̋敪�R�[�h
                vo.setBaitaiKbn((String) result.get(AddChangeReportLionBaitaiVO.BAITAIKBN.toUpperCase()));
                //�}�̋敪��
                vo.setBaitaiNm((String) result.get(AddChangeReportLionBaitaiVO.BAITAINM.toUpperCase()));
                //����
                vo.setKenNm((String) result.get(AddChangeReportLionBaitaiVO.KENNM.toUpperCase()));
                //�������z
                vo.setSeigak((BigDecimal) result.get(AddChangeReportLionBaitaiVO.SEIGAK.toUpperCase()));
                //�ǎ��R�[�h
                vo.setKykshCd((String) result.get(AddChangeReportLionBaitaiVO.KYKSHCD.toUpperCase()));
                //�ǃR�[�h
                vo.setKykCd((String) result.get(AddChangeReportLionBaitaiVO.KYKCD.toUpperCase()));
                //�ǖ�
                vo.setKykNm((String) result.get(AddChangeReportLionBaitaiVO.KYKNM.toUpperCase()));
                //CM�b��
                vo.setByosu((BigDecimal) result.get(AddChangeReportLionBaitaiVO.BYOSU.toUpperCase()));
                //CM�{��
                vo.setHonsu((BigDecimal) result.get(AddChangeReportLionBaitaiVO.HONSU.toUpperCase()));
                //�X�y�[�X
                vo.setSpace((String) result.get(AddChangeReportLionBaitaiVO.SPACE.toUpperCase()));
                //�f�ړ�
                vo.setKeisaibi((String) result.get(AddChangeReportLionBaitaiVO.KEISAIBI.toUpperCase()));
                //����
                vo.setTerm((String) result.get(AddChangeReportLionBaitaiVO.TERM.toUpperCase()));
                //SEQ
                vo.setSEQ((String) result.get(AddChangeReportLionBaitaiVO.SEQ.toUpperCase()));
                //�\�[�g��
                vo.setORDERSEQ((String) result.get(AddChangeReportLionBaitaiVO.ORDERSEQ.toUpperCase()));
            }
            //�ǉ��ύX���X�g�����̏ꍇ
            else if (_sqlMode.equals(BAITAIDIFF)) {
                //�}�̋敪
                vo.setBaitaiNm((String) result.get(AddChangeReportLionBaitaiVO.BAITAINM.toUpperCase()));
                //��No
                vo.setJyutNo((String) result.get(AddChangeReportLionBaitaiVO.JYUTNO.toUpperCase()));
                //�󒍖���No
                vo.setJymeiNo((String) result.get(AddChangeReportLionBaitaiVO.JYMEINO.toUpperCase()));
                //���㖾��No
                vo.setUrmeiNo((String) result.get(AddChangeReportLionBaitaiVO.URMEINO.toUpperCase()));
                //�A��
                vo.setRenbn((String) result.get(AddChangeReportLionBaitaiVO.RENBN.toUpperCase()));
                //�}�̋敪
                vo.setBaitaiKbn((String) result.get(AddChangeReportLionBaitaiVO.BAITAIKBN.toUpperCase()));
                //�}�̋敪��
                vo.setBaitaiNm((String) result.get(AddChangeReportLionBaitaiVO.BAITAINM.toUpperCase()));
                //����
                vo.setKenNm((String) result.get(AddChangeReportLionBaitaiVO.KENNM.toUpperCase()));
                //AD1�������z
                vo.setAD1Seigak((BigDecimal) result.get(AddChangeReportLionBaitaiVO.AD1SEIGAK.toUpperCase()));
                //AD2�������z
                vo.setAD2Seigak((BigDecimal) result.get(AddChangeReportLionBaitaiVO.AD2SEIGAK.toUpperCase()));
                //SEQ
                vo.setSEQ((String) result.get(AddChangeReportLionBaitaiVO.SEQ.toUpperCase()));
                //�\�[�g��
                vo.setORDERSEQ((String) result.get(AddChangeReportLionBaitaiVO.ORDERSEQ.toUpperCase()));
            }

            //�������ʒ���̏�Ԃɂ���
            ModelUtils.copyMemberSearchAfterInstace(vo);
            list.add(vo);
        }

        return list;
    }

}

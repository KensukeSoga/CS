package jp.co.isid.kkh.customer.acom.model.claim;

import java.util.List;

import jp.co.isid.kkh.integ.tbl.TBTHB1DOWN;
import jp.co.isid.kkh.integ.tbl.TBTHB2KMEI;
import jp.co.isid.kkh.integ.tbl.TBTHB5HIK;
import jp.co.isid.kkh.integ.tbl.TBTHBAMST;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractRdbDao;

/**
 *
 * <P>
 * �����f�[�^ �ꗗ���擾DAO
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/2/7 JSE Y.Sato)<BR>
 * </P>
 *
 * @author JSE Y.Sato
 */
public class FindClaimByCondDAO extends AbstractRdbDao {

    /** �� (��ʃR�[�h) */
    static final String SYBT_CD = "SYBTCD";
    /** �� (���f�B�A��) */
    static final String MEDIA_NM = "MEDIANM";
    /** �� (�V��_�f�ڏꏊ����) */
    static final String SNBN_KEIBAS_NM = "SNBN_KEIBASNM";
    /** �� (�V��_���1����) */
    static final String SNBN_SYBT1_NM = "SNBN_SYBT1NM";
    /** �� (�V��_���2����) */
    static final String SNBN_SYBT2_NM = "SNBN_SYBT2NM";
    /** �� (�V��_�F������) */
    static final String SNBN_SISAT_NM = "SNBN_SISATNM";
    /** �� (�V��_�T�C�Y����) */
    static final String SNBN_SIZE_NM = "SNBN_SIZENM";
    /** �� (�G��_�F������) */
    static final String ZASI_SISAT_NM = "ZASI_SISATNM";
    /** �� (�G��_�T�C�Y����) */
    static final String ZASI_SIZE_NM = "ZASI_SIZENM";
    /** �� (�d�g_��ʌf�ږ���) */
    static final String DEMP_KOTKEI_NM = "DEMP_KOTKEINM";

    /** �e�[�u���ʖ�1 */
    private static final String TBL_A = "A";
    /** �e�[�u���ʖ�2 */
    private static final String TBL_B = "B";
    /** �e�[�u���ʖ�3 */
    private static final String TBL_C = "C";
    /** �e�[�u���ʖ�4 */
    private static final String TBL_D = "D";
    /** �e�[�u���ʖ�5 */
    private static final String TBL_E = "E";
    /** �e�[�u���ʖ�6 */
    private static final String TBL_F = "F";
    /** �e�[�u���ʖ�7 */
    private static final String TBL_G = "G";
    /** �e�[�u���ʖ�8 */
    private static final String TBL_H = "H";
    /** �e�[�u���ʖ�9 */
    private static final String TBL_I = "I";
    /** �e�[�u���ʖ�10 */
    private static final String TBL_J = "J";
    /** �e�[�u���ʖ�11 */
    private static final String TBL_K = "K";
    /** �e�[�u���ʖ�12 */
    private static final String TBL_AA = "AA";
    /** �e�[�u���ʖ�_�T�u�N�G��1 */
    private static final String TBL_SUB_A = "SUB_A";
    /** �e�[�u���ʖ�_�T�u�N�G��2 */
    private static final String TBL_SUB_B = "SUB_B";

    /** getSelectSQL�Ŕ��s����SQL�̃��[�h */
    private enum SqlMode{
        /** ����/�����ԍ� �ꗗ */
        CLAIMNO,
        /** ����/���� ���وꗗ */
        CLAIMDIFF,
        /** �����f�[�^ �ꗗ */
        CLAIM,
        /** �l���}�X�^ */
        NEBIKI
        };
    private SqlMode _sqlMode = SqlMode.CLAIMNO;

    /** �f�[�^�������� */
    private FindClaimCondition _cond;

    /**
     * �f�t�H���g�R���X�g���N�^�B
     */
    public FindClaimByCondDAO() {
        super.setPoolConnectClass(KKHPoolConnect.class);
        super.setDBModelInterface(KKHOracleModel.getInstance());
        super.setBigDecimalMode(true);
    }

    /**
     * �v���C�}���L�[��Ԃ��܂��B
     *
     * @return String[] �v���C�}���L�[
     */
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
    public String getTableName() {
        return null;
    }

    /**
     * �e�[�u���񖼂�Ԃ��܂��B
     *
     * @return String[] �e�[�u����
     */
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

        String ret = "";

        // ����/�����ԍ� �ꗗ���擾
        if (_sqlMode == SqlMode.CLAIMNO) {
            ret = this.getSelectSQLForClaimNo();

        // ����/���� ���وꗗ�擾
        } else if (_sqlMode == SqlMode.CLAIMDIFF) {
            ret = this.getSelectSQLForClaimDiff();

        // �����f�[�^ �ꗗ���擾
        } else if (_sqlMode == SqlMode.CLAIM) {
            ret = this.getSelectSQLForClaimData();

        // �l���}�X�^
        } else if (_sqlMode == SqlMode.NEBIKI) {
            ret = this.getSelectSQLForNebiki();
        }

        return ret;
    }

    /**
     * ����/�����ԍ� �ꗗ���擾��SQL����Ԃ��܂��B
     *
     * @return String SQL��
     */
    private String getSelectSQLForClaimNo() {

        StringBuffer sql = new StringBuffer();

        // ====================================================================================================
        // SELECT��
        // ====================================================================================================
        sql.append(" SELECT ");
        sql.append(" " + TBL_A + "." + TBTHB2KMEI.CODE1);        // �}�̃R�[�h
        sql.append("," + TBL_A + "." + TBTHB2KMEI.CODE3);        // �����ԍ�
        sql.append("," + TBL_B + "." + TBTHB1DOWN.KKNAMEKJ);     // ����
        sql.append("," + TBL_A + "." + TBTHB2KMEI.SONOTA1);      // �������ԍ�
        sql.append("," + TBL_A + "." + TBTHB2KMEI.DATE1);        // ���������s��
        sql.append("," + TBL_A + "." + TBTHB2KMEI.SONOTA6);      // �󒍓��e�敪
        sql.append("," + TBL_A + "." + TBTHB2KMEI.KBN1);         // �o�̓t���O
        sql.append("," + TBL_A + "." + TBTHB2KMEI.NAME7);        // ���s����
        sql.append("," + TBL_A + "." + TBTHB2KMEI.JYUTNO);       // ��No
        sql.append("," + TBL_A + "." + TBTHB2KMEI.JYMEINO);      // �󒍖���No
        sql.append("," + TBL_A + "." + TBTHB2KMEI.URMEINO);      // ���㖾��No
        sql.append("," + TBL_A + "." + TBTHB2KMEI.RENBN);        // �A��

        // ====================================================================================================
        // FROM��
        // ====================================================================================================
        sql.append(" FROM");
        sql.append(" " + TBTHB2KMEI.TBNAME + " " + TBL_A);
        sql.append("," + TBTHB1DOWN.TBNAME + " " + TBL_B);

        // ====================================================================================================
        // WHERE��
        // ====================================================================================================
        sql.append(" WHERE");
        // �������� ---------------------------------------------------------------------------------------------
        sql.append("     " + TBL_A + "." + TBTHB2KMEI.EGCD + "        = " + TBL_B + "." + TBTHB1DOWN.EGCD);
        sql.append(" AND " + TBL_A + "." + TBTHB2KMEI.TKSKGYCD + "    = " + TBL_B + "." + TBTHB1DOWN.TKSKGYCD);
        sql.append(" AND " + TBL_A + "." + TBTHB2KMEI.TKSBMNSEQNO + " = " + TBL_B + "." + TBTHB1DOWN.TKSBMNSEQNO);
        sql.append(" AND " + TBL_A + "." + TBTHB2KMEI.TKSTNTSEQNO + " = " + TBL_B + "." + TBTHB1DOWN.TKSTNTSEQNO);
        sql.append(" AND " + TBL_A + "." + TBTHB2KMEI.YYMM + "        = " + TBL_B + "." + TBTHB1DOWN.YYMM);
        sql.append(" AND " + TBL_A + "." + TBTHB2KMEI.JYUTNO + "      = " + TBL_B + "." + TBTHB1DOWN.JYUTNO);
        sql.append(" AND " + TBL_A + "." + TBTHB2KMEI.JYMEINO + "     = " + TBL_B + "." + TBTHB1DOWN.JYMEINO);
        sql.append(" AND " + TBL_A + "." + TBTHB2KMEI.URMEINO + "     = " + TBL_B + "." + TBTHB1DOWN.URMEINO);
        // �������� ---------------------------------------------------------------------------------------------
        sql.append(" AND " + TBL_A + "." + TBTHB2KMEI.EGCD + "        = '" + _cond.getEgCd() + "'");
        sql.append(" AND " + TBL_A + "." + TBTHB2KMEI.TKSKGYCD + "    = '" + _cond.getTksKgyCd() + "'");
        sql.append(" AND " + TBL_A + "." + TBTHB2KMEI.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "'");
        sql.append(" AND " + TBL_A + "." + TBTHB2KMEI.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "'");
        sql.append(" AND " + TBL_A + "." + TBTHB2KMEI.YYMM  + "       = '" + _cond.getYymm() + "'");
        sql.append(" AND " + TBL_A + "." + TBTHB2KMEI.CODE1 + "      IN (" + _cond.getSybt() + ")");
        sql.append(" AND " + TBL_B + "." + TBTHB1DOWN.TJYUTNO +     " = ' '");

        // ====================================================================================================
        // GROUP BY��
        // ====================================================================================================
        sql.append(" GROUP BY");
        sql.append(" " + TBL_A + "." + TBTHB2KMEI.CODE3);        // �R�[�h3(�����ԍ�)
        sql.append("," + TBL_B + "." + TBTHB1DOWN.KKNAMEKJ);     // ����(����)
        sql.append("," + TBL_A + "." + TBTHB2KMEI.CODE1);        // �R�[�h1(�}�̃R�[�h)
        sql.append("," + TBL_A + "." + TBTHB2KMEI.SONOTA1);      // ���̑�1(�������ԍ�)
        sql.append("," + TBL_A + "." + TBTHB2KMEI.DATE1);        // ���t1(���������s��)
        sql.append("," + TBL_A + "." + TBTHB2KMEI.KBN1);         // �敪1(�o�̓t���O)
        sql.append("," + TBL_A + "." + TBTHB2KMEI.NAME7);        // ����7(����)(���s����)
        sql.append("," + TBL_A + "." + TBTHB2KMEI.JYUTNO);       // ��No
        sql.append("," + TBL_A + "." + TBTHB2KMEI.JYMEINO);      // �󒍖���No
        sql.append("," + TBL_A + "." + TBTHB2KMEI.URMEINO);      // ���㖾��No
        sql.append("," + TBL_A + "." + TBTHB2KMEI.RENBN);        // �A��
        sql.append("," + TBL_A + "." + TBTHB2KMEI.SONOTA6);      // ���̑�6(�󒍓��e�敪)

        // ====================================================================================================
        // ORDER BY��
        // ====================================================================================================
        sql.append(" ORDER BY");
        sql.append(" " + TBL_A + "." + TBTHB2KMEI.CODE3);        // �R�[�h3(�����ԍ�)
        sql.append("," + TBL_A + "." + TBTHB2KMEI.SONOTA1);      // ���̑�1(�������ԍ�)

        return sql.toString();
    }

    /**
     * ����/���� ���وꗗ���擾��SQL����Ԃ��܂��B
     *
     * @return String SQL��
     */
    private String getSelectSQLForClaimDiff() {

        StringBuffer sql1 = new StringBuffer();
        sql1.append(" SELECT ");
        sql1.append(" " + TBL_A + "." + TBTHB5HIK.RECCD);                 // ���R�[�h���
        sql1.append("," + TBL_A + "." + TBTHB5HIK.IRBAN);                 // �˗��ԍ�
        sql1.append("," + TBL_A + "." + TBTHB5HIK.IRROWBAN);              // �˗��s�ԍ�
        sql1.append("," + TBL_A + "." + TBTHB5HIK.TOKUICD);               // ���Ӑ�R�[�h
        sql1.append("," + TBL_A + "." + TBTHB5HIK.SYOHIKBN);              // ���i�敪
        sql1.append("," + TBL_A + "." + TBTHB5HIK.SYOHINAME);             // ���i�敪����
        sql1.append("," + TBL_A + "." + TBTHB5HIK.TEKICD);                // �E�v�R�[�h
        sql1.append("," + TBL_A + "." + TBTHB5HIK.SYBT);                  // ��ʁi�}�̃R�[�h�j
        sql1.append("," + TBL_A + "." + TBTHB5HIK.MEDIACD);               // ���f�B�A�R�[�h
        sql1.append("," + TBL_A + "." + TBTHB5HIK.TENCD);                 // �X��
        sql1.append("," + TBL_A + "." + TBTHB5HIK.HOSORYO1);              // ������1
        sql1.append("," + TBL_A + "." + TBTHB5HIK.HOSORYO2);              // ������2
        sql1.append("," + TBL_A + "." + TBTHB5HIK.HOSORYO3);              // ������3
        sql1.append("," + TBL_A + "." + TBTHB5HIK.HOSORYO4);              // ������4
        sql1.append("," + TBL_A + "." + TBTHB5HIK.HOSORYO5);              // ������5
        sql1.append("," + TBL_A + "." + TBTHB5HIK.HOSORYO6);              // ������6
        sql1.append("," + TBL_A + "." + TBTHB5HIK.KEISAITANKA);           // �f�ڒP��
        sql1.append("," + TBL_A + "." + TBTHB5HIK.KEISAIRYO);             // �f�ڗ�
        sql1.append("," + TBL_A + "." + TBTHB5HIK.ANSYUBE);               // �����
        sql1.append("," + TBL_A + "." + TBTHB5HIK.IRMONTH1);              // �˗���1
        sql1.append("," + TBL_A + "." + TBTHB5HIK.IRMONTH2);              // �˗���2
        sql1.append("," + TBL_A + "." + TBTHB5HIK.IRMONTH3);              // �˗���3
        sql1.append("," + TBL_A + "." + TBTHB5HIK.IRMONTH4);              // �˗���4
        sql1.append("," + TBL_A + "." + TBTHB5HIK.IRMONTH5);              // �˗���5
        sql1.append("," + TBL_A + "." + TBTHB5HIK.IRMONTH6);              // �˗���6
        sql1.append("," + TBL_A + "." + TBTHB5HIK.KEITAICD);              // �`�ԋ敪�R�[�h
        sql1.append("," + TBL_A + "." + TBTHB5HIK.KEITAINAME);            // �`�ԋ敪��
        sql1.append("," + TBL_A + "." + TBTHB5HIK.SAIKBN);                // �זڋ敪
        sql1.append("," + TBL_A + "." + TBTHB5HIK.RIRENO);                // �����Ǘ��ԍ�
        sql1.append("," + TBL_A + "." + TBTHB5HIK.BIKOU1);                // ���l1
        sql1.append("," + TBL_A + "." + TBTHB5HIK.BIKOU2);                // ���l2
        sql1.append("," + TBL_A + "." + TBTHB5HIK.PLACECD);               // �f�ڏꏊ�R�[�h
        sql1.append("," + TBL_A + "." + TBTHB5HIK.SYBT1CD);               // ��ʂP�R�[�h
        sql1.append("," + TBL_A + "." + TBTHB5HIK.SYBT2CD);               // ��ʂQ�R�[�h
        sql1.append("," + TBL_A + "." + TBTHB5HIK.COLORCD);               // �F���R�[�h
        sql1.append("," + TBL_A + "." + TBTHB5HIK.SIZECD);                // �T�C�Y�R�[�h
        sql1.append("," + TBL_A + "." + TBTHB5HIK.SPACECD);               // �X�y�[�X�R�[�h
        sql1.append("," + TBL_A + "." + TBTHB5HIK.KOTUKEICD);             // ��ʌf�ڃR�[�h
        sql1.append("," + TBL_A + "." + SYBT_CD);                         // ��ʃR�[�h
        sql1.append(" FROM ");
        // �����捞 -----------------------------------------------------------------------------------------
        sql1.append("(SELECT ");
        sql1.append("     " + TBL_SUB_A + "." + TBTHB5HIK.RECCD);         // ���R�[�h���
        sql1.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.IRBAN);         // �˗��ԍ�
        sql1.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.IRROWBAN);      // �˗��s�ԍ�
        sql1.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.TOKUICD);       // ���Ӑ�R�[�h
        sql1.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.SYOHIKBN);      // ���i�敪
        sql1.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.SYOHINAME);     // ���i�敪����
        sql1.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.TEKICD);        // �E�v�R�[�h
        sql1.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.SYBT);          // ��ʁi�}�̃R�[�h�j
        sql1.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.MEDIACD);       // ���f�B�A�R�[�h
        sql1.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.TENCD);         // �X��
        sql1.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.HOSORYO1);      // ������1
        sql1.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.HOSORYO2);      // ������2
        sql1.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.HOSORYO3);      // ������3
        sql1.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.HOSORYO4);      // ������4
        sql1.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.HOSORYO5);      // ������5
        sql1.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.HOSORYO6);      // ������6
        sql1.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.KEISAITANKA);   // �f�ڒP��
        sql1.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.KEISAIRYO);     // �f�ڗ�
        sql1.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.ANSYUBE);       // �����
        sql1.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.IRMONTH1);      // �˗���1
        sql1.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.IRMONTH2);      // �˗���2
        sql1.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.IRMONTH3);      // �˗���3
        sql1.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.IRMONTH4);      // �˗���4
        sql1.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.IRMONTH5);      // �˗���5
        sql1.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.IRMONTH6);      // �˗���6
        sql1.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.KEITAICD);      // �`�ԋ敪�R�[�h
        sql1.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.KEITAINAME);    // �`�ԋ敪��
        sql1.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.SAIKBN);        // �זڋ敪
        sql1.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.RIRENO);        // �����Ǘ��ԍ�
        sql1.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.BIKOU1);        // ���l1
        sql1.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.BIKOU2);        // ���l2
        sql1.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.PLACECD);       // �f�ڏꏊ�R�[�h
        sql1.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.SYBT1CD);       // ��ʂP�R�[�h
        sql1.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.SYBT2CD);       // ��ʂQ�R�[�h
        sql1.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.COLORCD);       // �F���R�[�h
        sql1.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.SIZECD);        // �T�C�Y�R�[�h
        sql1.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.SPACECD);       // �X�y�[�X�R�[�h
        sql1.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.KOTUKEICD);     // ��ʌf�ڃR�[�h
        sql1.append("    ,CASE TRIM(" + TBL_SUB_A + "." + TBTHB5HIK.SYBT + ")");
        sql1.append("         WHEN '21' THEN '02'");
        sql1.append("         WHEN '22' THEN '03'");
        sql1.append("         WHEN '31' THEN '06'");
        sql1.append("         WHEN '11' THEN");
        sql1.append("             CASE TRIM(" + TBL_SUB_A + "." + TBTHB5HIK.SAIKBN + ")");
        sql1.append("                 WHEN '1' THEN '04'");
        sql1.append("                 WHEN '2' THEN '04'");
        sql1.append("                 WHEN '4' THEN '05'");
        sql1.append("                 WHEN '5' THEN '05'");
        sql1.append("             END");
        sql1.append("         END AS " + SYBT_CD);                        // ��ʃR�[�h
        sql1.append(" FROM ");
        sql1.append(" " + TBTHB5HIK.TBNAME + " " + TBL_SUB_A);
        sql1.append(",(SELECT");
        sql1.append("     " + TBTHB5HIK.RECCD);                                                  // ���R�[�h���
        sql1.append("    ," + TBTHB5HIK.IRBAN);                                                  // �˗��ԍ�
        sql1.append("    ," + TBTHB5HIK.IRROWBAN);                                               // �˗��s�ԍ�
        sql1.append("    ,MAX(" + TBTHB5HIK.RIRENO + ") AS " + TBTHB5HIK.RIRENO);                // �����Ǘ��ԍ�
        sql1.append(" FROM ");
        sql1.append("     " + TBTHB5HIK.TBNAME);
        sql1.append(" WHERE ");
        sql1.append("     " + TBTHB5HIK.TKSKGYCD + "    = '" + _cond.getTksKgyCd() + "'");       // �˗��ԍ�
        sql1.append(" AND " + TBTHB5HIK.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "'");    // �˗��s�ԍ�
        sql1.append(" AND " + TBTHB5HIK.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "'");    // �����Ǘ��ԍ�
        sql1.append(" GROUP BY ");
        sql1.append(" " + TBTHB5HIK.RECCD);                                                      // ���R�[�h���
        sql1.append("," + TBTHB5HIK.IRBAN);                                                      // �˗��ԍ�
        sql1.append("," + TBTHB5HIK.IRROWBAN);                                                   // �˗��s�ԍ�
        sql1.append(") " + TBL_SUB_B);
        sql1.append(" WHERE ");
        // ��������
        sql1.append("     " + TBL_SUB_B + "." + TBTHB5HIK.RECCD + "       = " + TBL_SUB_A + "." + TBTHB5HIK.RECCD);
        sql1.append(" AND " + TBL_SUB_B + "." + TBTHB5HIK.IRBAN + "       = " + TBL_SUB_A + "." + TBTHB5HIK.IRBAN);
        sql1.append(" AND " + TBL_SUB_B + "." + TBTHB5HIK.IRROWBAN + "    = " + TBL_SUB_A + "." + TBTHB5HIK.IRROWBAN);
        sql1.append(" AND " + TBL_SUB_B + "." + TBTHB5HIK.RIRENO + "      = " + TBL_SUB_A + "." + TBTHB5HIK.RIRENO);
        // ��������
        sql1.append(" AND " + TBL_SUB_A + "." + TBTHB5HIK.EGCD + "        = '" + _cond.getEgCd() + "'");
        sql1.append(" AND " + TBL_SUB_A + "." + TBTHB5HIK.TKSKGYCD + "    = '" + _cond.getTksKgyCd() + "'");
        sql1.append(" AND " + TBL_SUB_A + "." + TBTHB5HIK.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "'");
        sql1.append(" AND " + TBL_SUB_A + "." + TBTHB5HIK.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "'");
        // �Ϗ���
        sql1.append(this.GetCondition(TBL_SUB_A));
        sql1.append(" ) " + TBL_A);


        StringBuffer sql2 = new StringBuffer();
        sql2.append(" SELECT ");
        sql2.append(" " + TBL_B + "." + TBTHB5HIK.RECCD);                 // ���R�[�h���
        sql2.append("," + TBL_B + "." + TBTHB5HIK.IRBAN);                 // �˗��ԍ�
        sql2.append("," + TBL_B + "." + TBTHB5HIK.IRROWBAN);              // �˗��s�ԍ�
        sql2.append("," + TBL_B + "." + TBTHB5HIK.TOKUICD);               // ���Ӑ�R�[�h
        sql2.append("," + TBL_B + "." + TBTHB5HIK.SYOHIKBN);              // ���i�敪
        sql2.append("," + TBL_B + "." + TBTHB5HIK.SYOHINAME);             // ���i�敪����
        sql2.append("," + TBL_B + "." + TBTHB5HIK.TEKICD);                // �E�v�R�[�h
        sql2.append("," + TBL_B + "." + TBTHB5HIK.SYBT);                  // ��ʁi�}�̃R�[�h�j
        sql2.append("," + TBL_B + "." + TBTHB5HIK.MEDIACD);               // ���f�B�A�R�[�h
        sql2.append("," + TBL_B + "." + TBTHB5HIK.TENCD);                 // �X��
        sql2.append("," + TBL_B + "." + TBTHB5HIK.HOSORYO1);              // ������1
        sql2.append("," + TBL_B + "." + TBTHB5HIK.HOSORYO2);              // ������2
        sql2.append("," + TBL_B + "." + TBTHB5HIK.HOSORYO3);              // ������3
        sql2.append("," + TBL_B + "." + TBTHB5HIK.HOSORYO4);              // ������4
        sql2.append("," + TBL_B + "." + TBTHB5HIK.HOSORYO5);              // ������5
        sql2.append("," + TBL_B + "." + TBTHB5HIK.HOSORYO6);              // ������6
        sql2.append("," + TBL_B + "." + TBTHB5HIK.KEISAITANKA);           // �f�ڒP��
        sql2.append("," + TBL_B + "." + TBTHB5HIK.KEISAIRYO);             // �f�ڗ�
        sql2.append("," + TBL_B + "." + TBTHB5HIK.ANSYUBE);               // �����
        sql2.append("," + TBL_B + "." + TBTHB5HIK.IRMONTH1);              // �˗���1
        sql2.append("," + TBL_B + "." + TBTHB5HIK.IRMONTH2);              // �˗���2
        sql2.append("," + TBL_B + "." + TBTHB5HIK.IRMONTH3);              // �˗���3
        sql2.append("," + TBL_B + "." + TBTHB5HIK.IRMONTH4);              // �˗���4
        sql2.append("," + TBL_B + "." + TBTHB5HIK.IRMONTH5);              // �˗���5
        sql2.append("," + TBL_B + "." + TBTHB5HIK.IRMONTH6);              // �˗���6
        sql2.append("," + TBL_B + "." + TBTHB5HIK.KEITAICD);              // �`�ԋ敪�R�[�h
        sql2.append("," + TBL_B + "." + TBTHB5HIK.KEITAINAME);            // �`�ԋ敪��
        sql2.append("," + TBL_B + "." + TBTHB5HIK.SAIKBN);                // �זڋ敪
        sql2.append("," + TBL_B + "." + TBTHB5HIK.RIRENO);                // �����Ǘ��ԍ�
        sql2.append("," + TBL_B + "." + TBTHB5HIK.BIKOU1);                // ���l1
        sql2.append("," + TBL_B + "." + TBTHB5HIK.BIKOU2);                // ���l2
        sql2.append("," + TBL_B + "." + TBTHB5HIK.PLACECD);               // �f�ڏꏊ�R�[�h
        sql2.append("," + TBL_B + "." + TBTHB5HIK.SYBT1CD);               // ��ʂP�R�[�h
        sql2.append("," + TBL_B + "." + TBTHB5HIK.SYBT2CD);               // ��ʂQ�R�[�h
        sql2.append("," + TBL_B + "." + TBTHB5HIK.COLORCD);               // �F���R�[�h
        sql2.append("," + TBL_B + "." + TBTHB5HIK.SIZECD);                // �T�C�Y�R�[�h
        sql2.append("," + TBL_B + "." + TBTHB5HIK.SPACECD);               // �X�y�[�X�R�[�h
        sql2.append("," + TBL_B + "." + TBTHB5HIK.KOTUKEICD);             // ��ʌf�ڃR�[�h
        sql2.append("," + TBL_B + "." + SYBT_CD);                         // ��ʃR�[�h
        sql2.append(" FROM ");
        // �����捞 -----------------------------------------------------------------------------------------
        sql2.append(" (SELECT ");
        sql2.append("     " + TBL_SUB_A + "." + TBTHB5HIK.RECCD);         // ���R�[�h���
        sql2.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.IRBAN);         // �˗��ԍ�
        sql2.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.IRROWBAN);      // �˗��s�ԍ�
        sql2.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.TOKUICD);       // ���Ӑ�R�[�h
        sql2.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.SYOHIKBN);      // ���i�敪
        sql2.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.SYOHINAME);     // ���i�敪����
        sql2.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.TEKICD);        // �E�v�R�[�h
        sql2.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.SYBT);          // ��ʁi�}�̃R�[�h�j
        sql2.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.MEDIACD);       // ���f�B�A�R�[�h
        sql2.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.TENCD);         // �X��
        sql2.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.HOSORYO1);      // ������1
        sql2.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.HOSORYO2);      // ������2
        sql2.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.HOSORYO3);      // ������3
        sql2.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.HOSORYO4);      // ������4
        sql2.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.HOSORYO5);      // ������5
        sql2.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.HOSORYO6);      // ������6
        sql2.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.KEISAITANKA);   // �f�ڒP��
        sql2.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.KEISAIRYO);   // �f�ڗ�
        sql2.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.ANSYUBE);       // �����
        sql2.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.IRMONTH1);      // �˗���1
        sql2.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.IRMONTH2);      // �˗���2
        sql2.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.IRMONTH3);      // �˗���3
        sql2.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.IRMONTH4);      // �˗���4
        sql2.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.IRMONTH5);      // �˗���5
        sql2.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.IRMONTH6);      // �˗���6
        sql2.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.KEITAICD);      // �`�ԋ敪�R�[�h
        sql2.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.KEITAINAME);    // �`�ԋ敪��
        sql2.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.SAIKBN);        // �זڋ敪
        sql2.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.RIRENO);        // �����Ǘ��ԍ�
        sql2.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.BIKOU1);        // ���l1
        sql2.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.BIKOU2);        // ���l2
        sql2.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.PLACECD);       // �f�ڏꏊ�R�[�h
        sql2.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.SYBT1CD);       // ��ʂP�R�[�h
        sql2.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.SYBT2CD);       // ��ʂQ�R�[�h
        sql2.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.COLORCD);       // �F���R�[�h
        sql2.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.SIZECD);        // �T�C�Y�R�[�h
        sql2.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.SPACECD);       // �X�y�[�X�R�[�h
        sql2.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.KOTUKEICD);     // ��ʌf�ڃR�[�h
        sql2.append("    ,CASE TRIM(" + TBL_SUB_A + "." + TBTHB5HIK.SYBT + ")");
        sql2.append("         WHEN '21' THEN '02'");
        sql2.append("         WHEN '22' THEN '03'");
        sql2.append("         WHEN '31' THEN '06'");
        sql2.append("         WHEN '11' THEN");
        sql2.append("             CASE TRIM(" + TBL_SUB_A + "." + TBTHB5HIK.SAIKBN + ")");
        sql2.append("                 WHEN '1' THEN '04'");
        sql2.append("                 WHEN '2' THEN '04'");
        sql2.append("                 WHEN '4' THEN '05'");
        sql2.append("                 WHEN '5' THEN '05'");
        sql2.append("             END");
        sql2.append("         END AS " + SYBT_CD);                        // ��ʃR�[�h
        sql2.append("    FROM ");
        sql2.append(" " + TBTHB5HIK.TBNAME + " " + TBL_SUB_A);
        sql2.append(",(SELECT");
        sql2.append("     " + TBTHB5HIK.RECCD);                                                  // ���R�[�h���
        sql2.append("    ," + TBTHB5HIK.IRBAN);                                                  // �˗��ԍ�
        sql2.append("    ," + TBTHB5HIK.IRROWBAN);                                               // �˗��s�ԍ�
        sql2.append("    ,MAX(" + TBTHB5HIK.RIRENO + ") AS " + TBTHB5HIK.RIRENO);                // �����Ǘ��ԍ�
        sql2.append(" FROM ");
        sql2.append("     " + TBTHB5HIK.TBNAME);
        sql2.append(" WHERE ");
        sql2.append("     " + TBTHB5HIK.TKSKGYCD + "    = '" + _cond.getTksKgyCd() + "'");       // �˗��ԍ�
        sql2.append(" AND " + TBTHB5HIK.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "'");    // �˗��s�ԍ�
        sql2.append(" AND " + TBTHB5HIK.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "'");    // �����Ǘ��ԍ�
        sql2.append(" GROUP BY ");
        sql2.append(" " + TBTHB5HIK.RECCD);                                                      // ���R�[�h���
        sql2.append("," + TBTHB5HIK.IRBAN);                                                      // �˗��ԍ�
        sql2.append("," + TBTHB5HIK.IRROWBAN);                                                   // �˗��s�ԍ�
        sql2.append(") " + TBL_SUB_B);
        sql2.append(" WHERE ");
        // ��������
        sql2.append("     " + TBL_SUB_B + "." + TBTHB5HIK.RECCD + "       = " + TBL_SUB_A + "." + TBTHB5HIK.RECCD);
        sql2.append(" AND " + TBL_SUB_B + "." + TBTHB5HIK.IRBAN + "       = " + TBL_SUB_A + "." + TBTHB5HIK.IRBAN);
        sql2.append(" AND " + TBL_SUB_B + "." + TBTHB5HIK.IRROWBAN + "    = " + TBL_SUB_A + "." + TBTHB5HIK.IRROWBAN);
        sql2.append(" AND " + TBL_SUB_B + "." + TBTHB5HIK.RIRENO + "      = " + TBL_SUB_A + "." + TBTHB5HIK.RIRENO);
        // ��������
        sql2.append(" AND " + TBL_SUB_A + "." + TBTHB5HIK.EGCD + "        = '" + _cond.getEgCd() + "'");
        sql2.append(" AND " + TBL_SUB_A + "." + TBTHB5HIK.TKSKGYCD + "    = '" + _cond.getTksKgyCd() + "'");
        sql2.append(" AND " + TBL_SUB_A + "." + TBTHB5HIK.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "'");
        sql2.append(" AND " + TBL_SUB_A + "." + TBTHB5HIK.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "'");
        // �Ϗ���
        sql2.append(this.GetConditionDiff(TBL_SUB_A));
        // �L����׃e�[�u���ɑ��݂��郌�R�[�h���Ώ�
        sql2.append(" AND EXISTS(");
        sql2.append("         SELECT");
        sql2.append("            'X'");
        sql2.append("        FROM");
        sql2.append("            " + TBTHB2KMEI.TBNAME);
        sql2.append("        WHERE");
        sql2.append("            " + TBTHB2KMEI.EGCD + "        = '" + _cond.getEgCd() + "'");
        sql2.append("        AND " + TBTHB2KMEI.TKSKGYCD + "    = '" + _cond.getTksKgyCd() + "'");
        sql2.append("        AND " + TBTHB2KMEI.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "'");
        sql2.append("        AND " + TBTHB2KMEI.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "'");
        sql2.append("        AND " + TBTHB2KMEI.YYMM  + "       = '" + _cond.getYymm() + "'");
        sql2.append("        AND TRIM(" + TBTHB2KMEI.CODE1 + ") IN (" + _cond.getSybt() + ")");
        sql2.append("        AND TRIM(" + TBTHB2KMEI.CODE3 + ") = " + TBL_SUB_A + "." + TBTHB5HIK.IRBAN);
        sql2.append("        GROUP BY");
        sql2.append("            " + TBTHB2KMEI.CODE3);
        sql2.append("    )");
        sql2.append(" ) " + TBL_B);


        // SQL������̌���
        StringBuffer sql = new StringBuffer();
        // ==============================================================================================================
        // SELECT��
        // ==============================================================================================================
        sql.append(" SELECT ");
        sql.append(" " + TBL_AA + "." + TBTHB5HIK.RECCD);                                 // ���R�[�h���
        sql.append("," + TBL_AA + "." + TBTHB5HIK.IRBAN);                                 // �˗��ԍ�
        sql.append("," + TBL_AA + "." + TBTHB5HIK.IRROWBAN);                              // �˗��s�ԍ�
        sql.append("," + TBL_AA + "." + TBTHB5HIK.TOKUICD);                               // ���Ӑ�R�[�h
        sql.append("," + TBL_AA + "." + TBTHB5HIK.SYOHIKBN);                              // ���i�敪
        sql.append("," + TBL_AA + "." + TBTHB5HIK.SYOHINAME);                             // ���i�敪����
        sql.append("," + TBL_AA + "." + TBTHB5HIK.TEKICD);                                // �E�v�R�[�h
        sql.append("," + TBL_AA + "." + TBTHB5HIK.SYBT);                                  // ��ʁi�}�̃R�[�h�j
        sql.append("," + TBL_AA + "." + TBTHB5HIK.MEDIACD);                               // ���f�B�A�R�[�h
        sql.append("," + TBL_AA + "." + TBTHB5HIK.TENCD);                                 // �X��
        sql.append("," + TBL_AA + "." + TBTHB5HIK.HOSORYO1);                              // ������1
        sql.append("," + TBL_AA + "." + TBTHB5HIK.HOSORYO2);                              // ������2
        sql.append("," + TBL_AA + "." + TBTHB5HIK.HOSORYO3);                              // ������3
        sql.append("," + TBL_AA + "." + TBTHB5HIK.HOSORYO4);                              // ������4
        sql.append("," + TBL_AA + "." + TBTHB5HIK.HOSORYO5);                              // ������5
        sql.append("," + TBL_AA + "." + TBTHB5HIK.HOSORYO6);                              // ������6
        sql.append("," + TBL_AA + "." + TBTHB5HIK.KEISAITANKA);                           // �f�ڒP��
        sql.append("," + TBL_AA + "." + TBTHB5HIK.KEISAIRYO);                             // �f�ڗ�
        sql.append("," + TBL_AA + "." + TBTHB5HIK.ANSYUBE);                               // �����
        sql.append("," + TBL_AA + "." + TBTHB5HIK.IRMONTH1);                              // �˗���1
        sql.append("," + TBL_AA + "." + TBTHB5HIK.IRMONTH2);                              // �˗���2
        sql.append("," + TBL_AA + "." + TBTHB5HIK.IRMONTH3);                              // �˗���3
        sql.append("," + TBL_AA + "." + TBTHB5HIK.IRMONTH4);                              // �˗���4
        sql.append("," + TBL_AA + "." + TBTHB5HIK.IRMONTH5);                              // �˗���5
        sql.append("," + TBL_AA + "." + TBTHB5HIK.IRMONTH6);                              // �˗���6
        sql.append("," + TBL_AA + "." + TBTHB5HIK.KEITAICD);                              // �`�ԋ敪�R�[�h
        sql.append("," + TBL_AA + "." + TBTHB5HIK.KEITAINAME);                            // �`�ԋ敪��
        sql.append("," + TBL_AA + "." + TBTHB5HIK.SAIKBN);                                // �זڋ敪
        sql.append("," + TBL_AA + "." + TBTHB5HIK.RIRENO);                                // �����Ǘ��ԍ�
        sql.append("," + TBL_AA + "." + TBTHB5HIK.BIKOU1);                                // ���l1
        sql.append("," + TBL_AA + "." + TBTHB5HIK.BIKOU2);                                // ���l2
        sql.append("," + TBL_AA + "." + TBTHB5HIK.PLACECD);                               // �f�ڏꏊ�R�[�h
        sql.append("," + TBL_AA + "." + TBTHB5HIK.SYBT1CD);                               // ��ʂP�R�[�h
        sql.append("," + TBL_AA + "." + TBTHB5HIK.SYBT2CD);                               // ��ʂQ�R�[�h
        sql.append("," + TBL_AA + "." + TBTHB5HIK.COLORCD);                               // �F���R�[�h
        sql.append("," + TBL_AA + "." + TBTHB5HIK.SIZECD);                                // �T�C�Y�R�[�h
        sql.append("," + TBL_AA + "." + TBTHB5HIK.SPACECD);                               // �X�y�[�X�R�[�h
        sql.append("," + TBL_AA + "." + TBTHB5HIK.KOTUKEICD);                             // ��ʌf�ڃR�[�h
        sql.append("," + TBL_AA + "." + SYBT_CD);                                         // ��ʃR�[�h
        sql.append("," + TBL_C + "." + TBTHBAMST.FIELD3 + " AS " + MEDIA_NM);             // ���f�B�A��
        sql.append("," + TBL_D + "." + TBTHBAMST.FIELD3 + " AS " + SNBN_KEIBAS_NM);       // �f�ڏꏊ����
        sql.append("," + TBL_E + "." + TBTHBAMST.FIELD3 + " AS " + SNBN_SYBT1_NM);        // ���1����
        sql.append("," + TBL_F + "." + TBTHBAMST.FIELD3 + " AS " + SNBN_SYBT2_NM);        // ���2����
        sql.append("," + TBL_G + "." + TBTHBAMST.FIELD3 + " AS " + SNBN_SISAT_NM);        // �F������
        sql.append("," + TBL_H + "." + TBTHBAMST.FIELD3 + " AS " + ZASI_SIZE_NM);         // �G���T�C�Y����
        sql.append("," + TBL_J + "." + TBTHBAMST.FIELD3 + " AS " + SNBN_SIZE_NM);         // �V���X�y�[�X����
        sql.append("," + TBL_I + "." + TBTHBAMST.FIELD3 + " AS " + DEMP_KOTKEI_NM);       // ��ʌf�ږ���

        // ==============================================================================================================
        // FROM��
        // ==============================================================================================================
        sql.append(" FROM ");
        sql.append(" ( ");
        sql.append(sql1.toString());    // SQL1
        sql.append(" UNION ");
        sql.append(sql2.toString());    // SQL2
        sql.append(" ) " + TBL_AA);

        // ���f�B�A�R�[�h�ϊ��}�X�^ -------------------------------------------------------------------------
        sql.append(",(SELECT");
        sql.append("     TRIM(" + TBTHBAMST.FIELD1 + ") AS " + TBTHBAMST.FIELD1);    // �t�B�[���h1
        sql.append("    ,TRIM(" + TBTHBAMST.FIELD2 + ") AS " + TBTHBAMST.FIELD2);    // �t�B�[���h2
        sql.append("    ,TRIM(" + TBTHBAMST.FIELD3 + ") AS " + TBTHBAMST.FIELD3);    // �t�B�[���h3
        sql.append(" FROM ");
        sql.append("     " + TBTHBAMST.TBNAME);
        sql.append(" WHERE ");
        sql.append("     " + TBTHBAMST.EGCD + "        = '" + _cond.getEgCd() + "'");
        sql.append(" AND " + TBTHBAMST.TKSKGYCD + "    = '" + _cond.getTksKgyCd() + "'");
        sql.append(" AND " + TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "'");
        sql.append(" AND " + TBTHBAMST.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "'");
        sql.append(" AND " + TBTHBAMST.SYBT  + "       = '910'");
        sql.append(" ) " + TBL_C);

        // �f�ڏꏊ�ϊ��}�X�^ ----------------------------------------------------------------------------
        sql.append(",(SELECT");
        sql.append("     TRIM(" + TBTHBAMST.FIELD1 + ") AS " + TBTHBAMST.FIELD1);    // �t�B�[���h1
        sql.append("    ,TRIM(" + TBTHBAMST.FIELD2 + ") AS " + TBTHBAMST.FIELD2);    // �t�B�[���h2
        sql.append("    ,TRIM(" + TBTHBAMST.FIELD3 + ") AS " + TBTHBAMST.FIELD3);    // �t�B�[���h3
        sql.append(" FROM ");
        sql.append("     " + TBTHBAMST.TBNAME);
        sql.append(" WHERE ");
        sql.append("     " + TBTHBAMST.EGCD + "        = '" + _cond.getEgCd() + "'");
        sql.append(" AND " + TBTHBAMST.TKSKGYCD + "    = '" + _cond.getTksKgyCd() + "'");
        sql.append(" AND " + TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "'");
        sql.append(" AND " + TBTHBAMST.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "'");
        sql.append(" AND " + TBTHBAMST.SYBT  + "       = '906'");
        sql.append(" ) " + TBL_D);

        // �L�G�R�[�h�ϊ��}�X�^ ---------------------------------------------------------------------------
        sql.append(",(SELECT");
        sql.append("     TRIM(" + TBTHBAMST.FIELD1 + ") AS " + TBTHBAMST.FIELD1);    // �t�B�[���h1
        sql.append("    ,TRIM(" + TBTHBAMST.FIELD2 + ") AS " + TBTHBAMST.FIELD2);    // �t�B�[���h2
        sql.append("    ,TRIM(" + TBTHBAMST.FIELD3 + ") AS " + TBTHBAMST.FIELD3);    // �t�B�[���h3
        sql.append(" FROM ");
        sql.append("     " + TBTHBAMST.TBNAME);
        sql.append(" WHERE ");
        sql.append("     " + TBTHBAMST.EGCD + "        = '" + _cond.getEgCd() + "'");
        sql.append(" AND " + TBTHBAMST.TKSKGYCD + "    = '" + _cond.getTksKgyCd() + "'");
        sql.append(" AND " + TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "'");
        sql.append(" AND " + TBTHBAMST.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "'");
        sql.append(" AND " + TBTHBAMST.SYBT  + "       = '908'");
        sql.append(" ) " + TBL_E);

        // ���[�R�[�h�ϊ��}�X�^ ---------------------------------------------------------------------------
        sql.append(",(SELECT");
        sql.append("     TRIM(" + TBTHBAMST.FIELD1 + ") AS " + TBTHBAMST.FIELD1);    // �t�B�[���h1
        sql.append("    ,TRIM(" + TBTHBAMST.FIELD2 + ") AS " + TBTHBAMST.FIELD2);    // �t�B�[���h2
        sql.append("    ,TRIM(" + TBTHBAMST.FIELD3 + ") AS " + TBTHBAMST.FIELD3);    // �t�B�[���h3
        sql.append(" FROM ");
        sql.append("     " + TBTHBAMST.TBNAME);
        sql.append(" WHERE ");
        sql.append("     " + TBTHBAMST.EGCD + "        = '" + _cond.getEgCd() + "'");
        sql.append(" AND " + TBTHBAMST.TKSKGYCD + "    = '" + _cond.getTksKgyCd() + "'");
        sql.append(" AND " + TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "'");
        sql.append(" AND " + TBTHBAMST.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "'");
        sql.append(" AND " + TBTHBAMST.SYBT  + "       = '909'");
        sql.append(" ) " + TBL_F);

        // �F���ϊ��}�X�^ ---------------------------------------------------------------------------------
        sql.append(",(SELECT");
        sql.append("     TRIM(" + TBTHBAMST.FIELD1 + ") AS " + TBTHBAMST.FIELD1);    // �t�B�[���h1
        sql.append("    ,TRIM(" + TBTHBAMST.FIELD2 + ") AS " + TBTHBAMST.FIELD2);    // �t�B�[���h2
        sql.append("    ,TRIM(" + TBTHBAMST.FIELD3 + ") AS " + TBTHBAMST.FIELD3);    // �t�B�[���h3
        sql.append(" FROM ");
        sql.append("     " + TBTHBAMST.TBNAME);
        sql.append(" WHERE ");
        sql.append("     " + TBTHBAMST.EGCD + "        = '" + _cond.getEgCd() + "'");
        sql.append(" AND " + TBTHBAMST.TKSKGYCD + "    = '" + _cond.getTksKgyCd() + "'");
        sql.append(" AND " + TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "'");
        sql.append(" AND " + TBTHBAMST.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "'");
        sql.append(" AND " + TBTHBAMST.SYBT  + "       = '911'");
        sql.append(" ) " + TBL_G);

        // �T�C�Y�R�[�h�ϊ��}�X�^(�G��) ------------------------------------------------------------------------
        sql.append(",(SELECT");
        sql.append("     TRIM(" + TBTHBAMST.FIELD1 + ") AS " + TBTHBAMST.FIELD1);    // �t�B�[���h1
        sql.append("    ,TRIM(" + TBTHBAMST.FIELD2 + ") AS " + TBTHBAMST.FIELD2);    // �t�B�[���h2
        sql.append("    ,TRIM(" + TBTHBAMST.FIELD3 + ") AS " + TBTHBAMST.FIELD3);    // �t�B�[���h3
        sql.append(" FROM ");
        sql.append("     " + TBTHBAMST.TBNAME);
        sql.append(" WHERE ");
        sql.append("     " + TBTHBAMST.EGCD + "        = '" + _cond.getEgCd() + "'");
        sql.append(" AND " + TBTHBAMST.TKSKGYCD + "    = '" + _cond.getTksKgyCd() + "'");
        sql.append(" AND " + TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "'");
        sql.append(" AND " + TBTHBAMST.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "'");
        sql.append(" AND " + TBTHBAMST.SYBT  + "       = '907'");
        sql.append(" ) " + TBL_H);

        // �T�C�Y�R�[�h�ϊ��}�X�^(�V��) ------------------------------------------------------------------------
        sql.append(",(SELECT");
        sql.append("     TRIM(" + TBTHBAMST.FIELD1 + ") AS " + TBTHBAMST.FIELD1);    // �t�B�[���h1
        sql.append("    ,TRIM(" + TBTHBAMST.FIELD2 + ") AS " + TBTHBAMST.FIELD2);    // �t�B�[���h2
        sql.append("    ,TRIM(" + TBTHBAMST.FIELD3 + ") AS " + TBTHBAMST.FIELD3);    // �t�B�[���h3
        sql.append(" FROM ");
        sql.append("     " + TBTHBAMST.TBNAME);
        sql.append(" WHERE ");
        sql.append("     " + TBTHBAMST.EGCD + "        = '" + _cond.getEgCd() + "'");
        sql.append(" AND " + TBTHBAMST.TKSKGYCD + "    = '" + _cond.getTksKgyCd() + "'");
        sql.append(" AND " + TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "'");
        sql.append(" AND " + TBTHBAMST.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "'");
        sql.append(" AND " + TBTHBAMST.SYBT  + "       = '907'");
        sql.append(" ) " + TBL_J);

        // �f�ڏꏊ�ϊ��}�X�^ ----------------------------------------------------------------------------
        sql.append(",(SELECT");
        sql.append("     TRIM(" + TBTHBAMST.FIELD1 + ") AS " + TBTHBAMST.FIELD1);    // �t�B�[���h1
        sql.append("    ,TRIM(" + TBTHBAMST.FIELD2 + ") AS " + TBTHBAMST.FIELD2);    // �t�B�[���h2
        sql.append("    ,TRIM(" + TBTHBAMST.FIELD3 + ") AS " + TBTHBAMST.FIELD3);    // �t�B�[���h3
        sql.append(" FROM ");
        sql.append("     " + TBTHBAMST.TBNAME);
        sql.append(" WHERE ");
        sql.append("     " + TBTHBAMST.EGCD + "        = '" + _cond.getEgCd() + "'");
        sql.append(" AND " + TBTHBAMST.TKSKGYCD + "    = '" + _cond.getTksKgyCd() + "'");
        sql.append(" AND " + TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "'");
        sql.append(" AND " + TBTHBAMST.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "'");
        sql.append(" AND " + TBTHBAMST.SYBT  + "       = '906'");
        sql.append(" ) " + TBL_I);

        // ==============================================================================================================
        // WHERE��
        // ==============================================================================================================
        sql.append(" WHERE ");
        // ��������
        sql.append("     " + TBL_C + "." + TBTHBAMST.FIELD1 + " (+)= TRIM(" + TBL_AA + "." + SYBT_CD + ")");
        sql.append(" AND " + TBL_C + "." + TBTHBAMST.FIELD2 + " (+)= TRIM(" + TBL_AA + "." + TBTHB5HIK.MEDIACD + ")");
        sql.append(" AND " + TBL_D + "." + TBTHBAMST.FIELD1 + " (+)= TRIM(" + TBL_AA + "." + SYBT_CD + ")");
        sql.append(" AND " + TBL_D + "." + TBTHBAMST.FIELD2 + " (+)= TRIM(" + TBL_AA + "." + TBTHB5HIK.PLACECD + ")");
        sql.append(" AND " + TBL_E + "." + TBTHBAMST.FIELD1 + " (+)= TRIM(" + TBL_AA + "." + SYBT_CD + ")");
        sql.append(" AND " + TBL_E + "." + TBTHBAMST.FIELD2 + " (+)= TRIM(" + TBL_AA + "." + TBTHB5HIK.SYBT1CD + ")");
        sql.append(" AND " + TBL_F + "." + TBTHBAMST.FIELD1 + " (+)= TRIM(" + TBL_AA + "." + SYBT_CD + ")");
        sql.append(" AND " + TBL_F + "." + TBTHBAMST.FIELD2 + " (+)= TRIM(" + TBL_AA + "." + TBTHB5HIK.SYBT2CD + ")");
        sql.append(" AND " + TBL_G + "." + TBTHBAMST.FIELD1 + " (+)= TRIM(" + TBL_AA + "." + SYBT_CD + ")");
        sql.append(" AND " + TBL_G + "." + TBTHBAMST.FIELD2 + " (+)= TRIM(" + TBL_AA + "." + TBTHB5HIK.COLORCD + ")");
        sql.append(" AND " + TBL_H + "." + TBTHBAMST.FIELD1 + " (+)= TRIM(" + TBL_AA + "." + SYBT_CD + ")");
        sql.append(" AND " + TBL_H + "." + TBTHBAMST.FIELD2 + " (+)= TRIM(" + TBL_AA + "." + TBTHB5HIK.SIZECD + ")");
        sql.append(" AND " + TBL_J + "." + TBTHBAMST.FIELD1 + " (+)= TRIM(" + TBL_AA + "." + SYBT_CD + ")");
        sql.append(" AND " + TBL_J + "." + TBTHBAMST.FIELD2 + " (+)= TRIM(" + TBL_AA + "." + TBTHB5HIK.SPACECD + ")");
        sql.append(" AND " + TBL_I + "." + TBTHBAMST.FIELD1 + " (+)= TRIM(" + TBL_AA + "." + SYBT_CD + ")");
        sql.append(" AND " + TBL_I + "." + TBTHBAMST.FIELD2 + " (+)= TRIM(" + TBL_AA + "." + TBTHB5HIK.KOTUKEICD + ")");

        return sql.toString();
    }

    /**
     * �����f�[�^ �ꗗ���擾��SQL����Ԃ��܂��B
     *
     * @return String SQL��
     */
    private String getSelectSQLForClaimData() {

        StringBuffer sql = new StringBuffer();

        // ============================================================================================================================================
        // SELECT��
        // ============================================================================================================================================
        sql.append(" SELECT ");
        // �L����׃e�[�u���f�[�^
        sql.append(" " + TBL_A + "." + TBTHB2KMEI.TIMSTMP);
        sql.append("," + TBL_A + "." + TBTHB2KMEI.CODE3);                           // �˗��ԍ��i�����ԍ��j
        sql.append("," + TBL_A + "." + TBTHB2KMEI.CODE4);                           // �˗��s�ԍ��i�����s�ԍ��j
        sql.append("," + TBL_A + "." + TBTHB2KMEI.SONOTA5);                         // �����R�[�h
        sql.append("," + TBL_A + "." + TBTHB2KMEI.NAME2);                           // ��Ж�
        sql.append("," + TBL_A + "." + TBTHB2KMEI.CODE5);                           // ���������R�[�h
        sql.append("," + TBL_A + "." + TBTHB2KMEI.DATE1);                           // �����N����
        sql.append("," + TBL_A + "." + TBTHB2KMEI.SONOTA1);                         // �������ԍ�
        sql.append("," + TBL_A + "." + TBTHB2KMEI.SONOTA2);                         // �������s�ԍ�
        sql.append("," + TBL_A + "." + TBTHB2KMEI.DATE2);                           // �x����
        sql.append("," + TBL_A + "." + TBTHB2KMEI.SONOTA3);                         // ���i�敪
        sql.append("," + TBL_A + "." + TBTHB2KMEI.NAME1);                           // ���i�敪����
        sql.append("," + TBL_A + "." + TBTHB2KMEI.CODE6);                           // �E�v�R�[�h
        sql.append("," + TBL_A + "." + TBTHB2KMEI.CODE1);                           // �}�̃R�[�h
        sql.append("," + TBL_A + "." + TBTHB2KMEI.CODE2);                           // ���f�B�A�R�[�h
        sql.append("," + TBL_A + "." + TBTHB2KMEI.SONOTA4);                         // �X��
        sql.append("," + TBL_A + "." + TBTHB2KMEI.SEIGAK);                          // ���z
        sql.append("," + TBL_A + "." + TBTHB2KMEI.KNGK1);                           // �����
        sql.append("," + TBL_A + "." + TBTHB2KMEI.MEIHNFLG);                        // �����
        sql.append("," + TBL_A + "." + TBTHB2KMEI.SONOTA6);                         // �敪
        sql.append("," + TBL_A + "." + TBTHB2KMEI.SONOTA9);                         // �f�ړ��i�V���E�G���j
        sql.append("," + TBL_A + "." + TBTHB2KMEI.HNNERT);                          // �l����
        sql.append("," + TBL_A + "." + TBTHB2KMEI.NEBIGAK);                         // �l���z
        sql.append("," + TBL_A + "." + TBTHB2KMEI.RITU1);                           // ����ŗ�
        sql.append("," + TBL_A + "." + TBTHB2KMEI.JYUTNO);                          // ��No
        sql.append("," + TBL_A + "." + TBTHB2KMEI.JYMEINO);                         // �󒍖���No
        sql.append("," + TBL_A + "." + TBTHB2KMEI.URMEINO);                         // ���㖾��No
        sql.append("," + TBL_A + "." + TBTHB2KMEI.DATE3);                           // �o�^�N����
        sql.append("," + TBL_A + "." + TBTHB2KMEI.DATE4);                           // �ύX�N����
        sql.append("," + TBL_A + "." + TBTHB2KMEI.DATE5);                           // ����N����
        sql.append("," + TBL_A + "." + TBTHB2KMEI.KBN1);                            // �����敪
        sql.append("," + TBL_A + "." + TBTHB2KMEI.NAME7);                           // �o�͓���
        sql.append("," + TBL_A + "." + TBTHB2KMEI.RENBN);                           // �A��
        sql.append("," + TBL_A + "." + TBTHB2KMEI.SONOTA7);                         // �f�ڒP��
        sql.append("," + TBL_A + "." + TBTHB2KMEI.NAME11);                          // ����11(����)
        sql.append("," + TBL_A + "." + TBTHB2KMEI.NAME12);                          // ����12(����)
        sql.append("," + TBL_A + "." + TBTHB2KMEI.NAME13);                          // ����13(����)
        sql.append("," + TBL_A + "." + TBTHB2KMEI.NAME14);                          // ����14(����)
        sql.append("," + TBL_A + "." + TBTHB2KMEI.NAME15);                          // ����15(����)
        sql.append("," + TBL_A + "." + TBTHB2KMEI.NAME16);                          // ����16(����)
        sql.append("," + TBL_A + "." + TBTHB2KMEI.NAME17);                          // ����17(����)
        sql.append("," + TBL_A + "." + TBTHB2KMEI.KBN2);                            // �l���s�敪
        sql.append("," + TBL_K + "." + TBTHB5HIK.SAIKBN);                           // �זڋ敪
        // �󒍃_�E�����[�h�e�[�u���f�[�^
        sql.append("," + TBL_B + "." + TBTHB1DOWN.FIELD4);                          // �������ԁi�X�|�b�g�j
        sql.append("," + TBL_B + "." + TBTHB1DOWN.FIELD8);                          // �������ԁi�^�C���j
        sql.append("," + TBL_B + "." + TBTHB1DOWN.FIELD9);                          // �X�y�[�X�i�G���j
        sql.append("," + TBL_B + "." + TBTHB1DOWN.FIELD11);                         // �X�y�[�X�i�V���j
        sql.append("," + TBL_B + "." + TBTHB1DOWN.KKNAMEKJ);                        // ����
        sql.append("," + TBL_B + "." + TBTHB1DOWN.TMSPKBN);                         // �^�C���X�|�b�g�敪
        sql.append("," + TBL_B + "." + TBTHB1DOWN.KOKKBN);                          // ���ۋ敪
        // �ȉ��A�}�X�^�擾�f�[�^
        sql.append("," + TBL_C + "." + TBTHBAMST.FIELD3 + " AS " + MEDIA_NM);       // ���f�B�A��
        sql.append("," + TBL_D + "." + TBTHBAMST.FIELD3 + " AS " + SNBN_KEIBAS_NM); // �V��_�f�ڏꏊ����(�d�g_��ʌf�ږ���)
        sql.append("," + TBL_E + "." + TBTHBAMST.FIELD3 + " AS " + SNBN_SYBT1_NM);  // �V��_���1����
        sql.append("," + TBL_F + "." + TBTHBAMST.FIELD3 + " AS " + SNBN_SYBT2_NM);  // �V��_���2����
        sql.append("," + TBL_H + "." + TBTHBAMST.FIELD3 + " AS " + SNBN_SISAT_NM);  // �V��_�F������
        sql.append("," + TBL_J + "." + TBTHBAMST.FIELD3 + " AS " + SNBN_SIZE_NM);   // �V��_�T�C�Y����
        sql.append("," + TBL_G + "." + TBTHBAMST.FIELD3 + " AS " + ZASI_SISAT_NM);  // �G��_�F������
        sql.append("," + TBL_I + "." + TBTHBAMST.FIELD3 + " AS " + ZASI_SIZE_NM);   // �G��_�T�C�Y����

        // ============================================================================================================================================
        // FROM��
        // ============================================================================================================================================
        sql.append(" FROM");

        // �L����׃e�[�u�� ----------------------------------------------------------------------------
        sql.append("    (SELECT");
        sql.append("     " + TBTHB2KMEI.EGCD);                                                                       // �c�Ə��i��j�R�[�h
        sql.append("    ," + TBTHB2KMEI.TKSKGYCD);                                                                   // ���Ӑ��ƃR�[�h
        sql.append("    ," + TBTHB2KMEI.TKSBMNSEQNO);                                                                // ���Ӑ敔��SEQNO
        sql.append("    ," + TBTHB2KMEI.TKSTNTSEQNO);                                                                // ���Ӑ�S��SEQNO
        sql.append("    ," + TBTHB2KMEI.YYMM);                                                                       // �N��
        sql.append("    ,TO_CHAR(" + TBTHB2KMEI.TIMSTMP + ", 'YYYY/MM/DD HH24:MI:SS') AS " + TBTHB2KMEI.TIMSTMP);    // �^�C���X�^���v
        sql.append("    ," + TBTHB2KMEI.CODE3);                                                                      // �˗��ԍ��i�����ԍ��j
        sql.append("    ," + TBTHB2KMEI.CODE4);                                                                      // �˗��s�ԍ��i�����s�ԍ��j
        sql.append("    ," + TBTHB2KMEI.SONOTA5);                                                                    // �����R�[�h
        sql.append("    ," + TBTHB2KMEI.NAME2);                                                                      // ��Ж�
        sql.append("    ," + TBTHB2KMEI.CODE5);                                                                      // ���������R�[�h
        sql.append("    ," + TBTHB2KMEI.DATE1);                                                                      // �����N����
        sql.append("    ," + TBTHB2KMEI.SONOTA1);                                                                    // �������ԍ�
        sql.append("    ," + TBTHB2KMEI.SONOTA2);                                                                    // �������s�ԍ�
        sql.append("    ," + TBTHB2KMEI.DATE2);                                                                      // �x����
        sql.append("    ," + TBTHB2KMEI.SONOTA3);                                                                    // ���i�敪
        sql.append("    ," + TBTHB2KMEI.NAME1);                                                                      // ���i�敪����
        sql.append("    ," + TBTHB2KMEI.CODE6);                                                                      // �E�v�R�[�h
        sql.append("    ," + TBTHB2KMEI.CODE1);                                                                      // �}�̃R�[�h
        sql.append("    ," + TBTHB2KMEI.CODE2);                                                                      // ���f�B�A�R�[�h
        sql.append("    ,CASE WHEN TRIM(" + TBTHB2KMEI.MEIHNFLG + ") <> '1' THEN");                                  // ����ʂ��u1�F�藦���v�ȊO�̏ꍇ�̂݁A�X�Ԃ�ݒ肷��
        sql.append("         " + TBTHB2KMEI.SONOTA4);
        sql.append("          ELSE ''");
        sql.append("     END AS " + TBTHB2KMEI.SONOTA4);                                                             // �X��
        sql.append("    ,NVL(" + TBTHB2KMEI.SEIGAK + ", 0) AS " + TBTHB2KMEI.SEIGAK);                                // ���z
        sql.append("    ,NVL(" + TBTHB2KMEI.KNGK1 + ",  0) AS " + TBTHB2KMEI.KNGK1);                                 // �����
        sql.append("    ," + TBTHB2KMEI.MEIHNFLG);                                                                   // �����
        sql.append("    ," + TBTHB2KMEI.SONOTA6);                                                                    // �敪
        sql.append("    ," + TBTHB2KMEI.SONOTA9);                                                                    // �f�ړ��i�V���E�G���j
        sql.append("    ," + TBTHB2KMEI.HNNERT);                                                                     // �l����
        sql.append("    ," + TBTHB2KMEI.NEBIGAK);                                                                    // �l���z
        sql.append("    ," + TBTHB2KMEI.RITU1);                                                                      // ����ŗ�
        sql.append("    ," + TBTHB2KMEI.JYUTNO);                                                                     // ��No
        sql.append("    ," + TBTHB2KMEI.JYMEINO);                                                                    // �󒍖���No
        sql.append("    ," + TBTHB2KMEI.URMEINO);                                                                    // ���㖾��No
        sql.append("    ," + TBTHB2KMEI.DATE3);                                                                      // �o�^�N����
        sql.append("    ," + TBTHB2KMEI.DATE4);                                                                      // �ύX�N����
        sql.append("    ," + TBTHB2KMEI.DATE5);                                                                      // ����N����
        sql.append("    ," + TBTHB2KMEI.KBN1);                                                                       // �����敪
        sql.append("    ," + TBTHB2KMEI.NAME7);                                                                      // �o�͓���
        sql.append("    ," + TBTHB2KMEI.RENBN);                                                                      // �A��
        sql.append("    ," + TBTHB2KMEI.SONOTA7);                                                                    // �f�ڒP��
        sql.append("    ,NVL(" + TBTHB2KMEI.NAME11 + ", '') AS " + TBTHB2KMEI.NAME11);                               // ����11(����)
        sql.append("    ,NVL(" + TBTHB2KMEI.NAME12 + ", '') AS " + TBTHB2KMEI.NAME12);                               // ����12(����)
        sql.append("    ,NVL(" + TBTHB2KMEI.NAME13 + ", '') AS " + TBTHB2KMEI.NAME13);                               // ����13(����)
        sql.append("    ,NVL(" + TBTHB2KMEI.NAME14 + ", '') AS " + TBTHB2KMEI.NAME14);                               // ����14(����)
        sql.append("    ,NVL(" + TBTHB2KMEI.NAME15 + ", '') AS " + TBTHB2KMEI.NAME15);                               // ����15(����)
        sql.append("    ,NVL(" + TBTHB2KMEI.NAME16 + ", '') AS " + TBTHB2KMEI.NAME16);                               // ����16(����)
        sql.append("    ,NVL(" + TBTHB2KMEI.NAME17 + ", '') AS " + TBTHB2KMEI.NAME17);                               // ����17(����)
        sql.append("    ,NVL(TRIM(" + TBTHB2KMEI.KBN2 + ")  , '') AS " + TBTHB2KMEI.KBN2);                           // �l���s�敪
        sql.append("    ,CASE TRIM(" + TBTHB2KMEI.CODE1 + ")");
        sql.append("         WHEN '21' THEN '02'");
        sql.append("         WHEN '22' THEN '03'");
        sql.append("         WHEN '31' THEN '06'");
        sql.append("         WHEN '11' THEN");
        sql.append("             CASE TRIM(" + TBTHB2KMEI.SONOTA6 + ")");
        sql.append("                 WHEN '05' THEN '04'");
        sql.append("                 WHEN '07' THEN '04'");
        sql.append("                 WHEN '03' THEN '05'");
        sql.append("                 WHEN '04' THEN '05'");
        sql.append("             END");
        sql.append("     END AS " + SYBT_CD);                                                                        // ��ʃR�[�h
        sql.append("     FROM");
        sql.append("         " + TBTHB2KMEI.TBNAME);
        sql.append("     WHERE");
        sql.append("         " + TBTHB2KMEI.EGCD + "        = '" + _cond.getEgCd() + "'");
        sql.append("     AND " + TBTHB2KMEI.TKSKGYCD + "    = '" + _cond.getTksKgyCd() + "'");
        sql.append("     AND " + TBTHB2KMEI.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "'");
        sql.append("     AND " + TBTHB2KMEI.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "'");
        sql.append("     AND " + TBTHB2KMEI.YYMM  + "       = '" + _cond.getYymm() + "'");
        sql.append("     AND " + TBTHB2KMEI.CODE1 + "       IN(" + _cond.getSybt() + ")");
        sql.append("    ) " + TBL_A);

        // �󒍃_�E�����[�h�e�[�u�� -------------------------------------------------------------------------
        sql.append("   ," + TBTHB1DOWN.TBNAME + " " + TBL_B);

        // ���f�B�A�R�[�h�ϊ��}�X�^ -------------------------------------------------------------------------
        sql.append("   ,(SELECT");
        sql.append("         TRIM(" + TBTHBAMST.FIELD1 + ") AS " + TBTHBAMST.FIELD1);    // �t�B�[���h1
        sql.append("        ,TRIM(" + TBTHBAMST.FIELD2 + ") AS " + TBTHBAMST.FIELD2);    // �t�B�[���h2
        sql.append("        ,TRIM(" + TBTHBAMST.FIELD3 + ") AS " + TBTHBAMST.FIELD3);    // �t�B�[���h3
        sql.append("        ,TRIM(" + TBTHBAMST.FIELD4 + ") AS " + TBTHBAMST.FIELD4);    // �t�B�[���h4
        sql.append("     FROM");
        sql.append("         " + TBTHBAMST.TBNAME);
        sql.append("     WHERE");
        sql.append("         " + TBTHBAMST.EGCD + "        = '" + _cond.getEgCd() + "'");
        sql.append("     AND " + TBTHBAMST.TKSKGYCD + "    = '" + _cond.getTksKgyCd() + "'");
        sql.append("     AND " + TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "'");
        sql.append("     AND " + TBTHBAMST.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "'");
        sql.append("     AND " + TBTHBAMST.SYBT  + "       = '910'");
        sql.append("    ) " + TBL_C);

        // �f�ڏꏊ�ϊ��}�X�^ ----------------------------------------------------------------------------
        sql.append("   ,(SELECT");
        sql.append("         TRIM(" + TBTHBAMST.FIELD1 + ") AS " + TBTHBAMST.FIELD1);    // �t�B�[���h1
        sql.append("        ,TRIM(" + TBTHBAMST.FIELD2 + ") AS " + TBTHBAMST.FIELD2);    // �t�B�[���h2
        sql.append("        ,TRIM(" + TBTHBAMST.FIELD3 + ") AS " + TBTHBAMST.FIELD3);    // �t�B�[���h3
        sql.append("        ,TRIM(" + TBTHBAMST.FIELD4 + ") AS " + TBTHBAMST.FIELD4);    // �t�B�[���h4
        sql.append("     FROM");
        sql.append("         " + TBTHBAMST.TBNAME);
        sql.append("     WHERE");
        sql.append("         " + TBTHBAMST.EGCD + "        = '" + _cond.getEgCd() + "'");
        sql.append("     AND " + TBTHBAMST.TKSKGYCD + "    = '" + _cond.getTksKgyCd() + "'");
        sql.append("     AND " + TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "'");
        sql.append("     AND " + TBTHBAMST.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "'");
        sql.append("     AND " + TBTHBAMST.SYBT  + "       = '906'");
        sql.append("    ) " + TBL_D);

        // �L�G�R�[�h�ϊ��}�X�^ ---------------------------------------------------------------------------
        sql.append("   ,(SELECT");
        sql.append("         TRIM(" + TBTHBAMST.FIELD1 + ") AS " + TBTHBAMST.FIELD1);    // �t�B�[���h1
        sql.append("        ,TRIM(" + TBTHBAMST.FIELD2 + ") AS " + TBTHBAMST.FIELD2);    // �t�B�[���h2
        sql.append("        ,TRIM(" + TBTHBAMST.FIELD3 + ") AS " + TBTHBAMST.FIELD3);    // �t�B�[���h3
        sql.append("        ,TRIM(" + TBTHBAMST.FIELD4 + ") AS " + TBTHBAMST.FIELD4);    // �t�B�[���h4
        sql.append("     FROM");
        sql.append("         " + TBTHBAMST.TBNAME);
        sql.append("     WHERE");
        sql.append("         " + TBTHBAMST.EGCD + "        = '" + _cond.getEgCd() + "'");
        sql.append("     AND " + TBTHBAMST.TKSKGYCD + "    = '" + _cond.getTksKgyCd() + "'");
        sql.append("     AND " + TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "'");
        sql.append("     AND " + TBTHBAMST.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "'");
        sql.append("     AND " + TBTHBAMST.SYBT  + "       = '908'");
        sql.append("    ) " + TBL_E);

        // ���[�R�[�h�ϊ��}�X�^ ---------------------------------------------------------------------------
        sql.append("   ,(SELECT");
        sql.append("         TRIM(" + TBTHBAMST.FIELD1 + ") AS " + TBTHBAMST.FIELD1);    // �t�B�[���h1
        sql.append("        ,TRIM(" + TBTHBAMST.FIELD2 + ") AS " + TBTHBAMST.FIELD2);    // �t�B�[���h2
        sql.append("        ,TRIM(" + TBTHBAMST.FIELD3 + ") AS " + TBTHBAMST.FIELD3);    // �t�B�[���h3
        sql.append("        ,TRIM(" + TBTHBAMST.FIELD4 + ") AS " + TBTHBAMST.FIELD4);    // �t�B�[���h4
        sql.append("     FROM");
        sql.append("         " + TBTHBAMST.TBNAME);
        sql.append("     WHERE");
        sql.append("         " + TBTHBAMST.EGCD + "        = '" + _cond.getEgCd() + "'");
        sql.append("     AND " + TBTHBAMST.TKSKGYCD + "    = '" + _cond.getTksKgyCd() + "'");
        sql.append("     AND " + TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "'");
        sql.append("     AND " + TBTHBAMST.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "'");
        sql.append("     AND " + TBTHBAMST.SYBT  + "       = '909'");
        sql.append("    ) " + TBL_F);

        // �F���ϊ��}�X�^(�G��) --------------------------------------------------------------------------
        sql.append("   ,(SELECT");
        sql.append("         TRIM(" + TBTHBAMST.FIELD1 + ") AS " + TBTHBAMST.FIELD1);    // �t�B�[���h1
        sql.append("        ,TRIM(" + TBTHBAMST.FIELD2 + ") AS " + TBTHBAMST.FIELD2);    // �t�B�[���h2
        sql.append("        ,TRIM(" + TBTHBAMST.FIELD3 + ") AS " + TBTHBAMST.FIELD3);    // �t�B�[���h3
        sql.append("        ,TRIM(" + TBTHBAMST.FIELD4 + ") AS " + TBTHBAMST.FIELD4);    // �t�B�[���h4
        sql.append("     FROM");
        sql.append("         " + TBTHBAMST.TBNAME);
        sql.append("     WHERE");
        sql.append("         " + TBTHBAMST.EGCD + "        = '" + _cond.getEgCd() + "'");
        sql.append("     AND " + TBTHBAMST.TKSKGYCD + "    = '" + _cond.getTksKgyCd() + "'");
        sql.append("     AND " + TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "'");
        sql.append("     AND " + TBTHBAMST.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "'");
        sql.append("     AND " + TBTHBAMST.SYBT  + "       = '911'");
        sql.append("    ) " + TBL_G);

        // �F���ϊ��}�X�^(�V��) --------------------------------------------------------------------------
        sql.append("   ,(SELECT");
        sql.append("         TRIM(" + TBTHBAMST.FIELD1 + ") AS " + TBTHBAMST.FIELD1);    // �t�B�[���h1
        sql.append("        ,TRIM(" + TBTHBAMST.FIELD2 + ") AS " + TBTHBAMST.FIELD2);    // �t�B�[���h2
        sql.append("        ,TRIM(" + TBTHBAMST.FIELD3 + ") AS " + TBTHBAMST.FIELD3);    // �t�B�[���h3
        sql.append("        ,TRIM(" + TBTHBAMST.FIELD4 + ") AS " + TBTHBAMST.FIELD4);    // �t�B�[���h4
        sql.append("     FROM");
        sql.append("         " + TBTHBAMST.TBNAME);
        sql.append("     WHERE");
        sql.append("         " + TBTHBAMST.EGCD + "        = '" + _cond.getEgCd() + "'");
        sql.append("     AND " + TBTHBAMST.TKSKGYCD + "    = '" + _cond.getTksKgyCd() + "'");
        sql.append("     AND " + TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "'");
        sql.append("     AND " + TBTHBAMST.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "'");
        sql.append("     AND " + TBTHBAMST.SYBT  + "       = '911'");
        sql.append("    ) " + TBL_H);

        // �T�C�Y�R�[�h�ϊ��}�X�^(�G��) ----------------------------------------------------------------------
        sql.append("   ,(SELECT");
        sql.append("         TRIM(" + TBTHBAMST.FIELD1 + ") AS " + TBTHBAMST.FIELD1);    // �t�B�[���h1
        sql.append("        ,TRIM(" + TBTHBAMST.FIELD2 + ") AS " + TBTHBAMST.FIELD2);    // �t�B�[���h2
        sql.append("        ,TRIM(" + TBTHBAMST.FIELD3 + ") AS " + TBTHBAMST.FIELD3);    // �t�B�[���h3
        sql.append("        ,TRIM(" + TBTHBAMST.FIELD4 + ") AS " + TBTHBAMST.FIELD4);    // �t�B�[���h4
        sql.append("     FROM");
        sql.append("         " + TBTHBAMST.TBNAME);
        sql.append("     WHERE");
        sql.append("         " + TBTHBAMST.EGCD + "        = '" + _cond.getEgCd() + "'");
        sql.append("     AND " + TBTHBAMST.TKSKGYCD + "    = '" + _cond.getTksKgyCd() + "'");
        sql.append("     AND " + TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "'");
        sql.append("     AND " + TBTHBAMST.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "'");
        sql.append("     AND " + TBTHBAMST.SYBT  + "       = '907'");
        sql.append("    ) " + TBL_I);

        // �T�C�Y�R�[�h�ϊ��}�X�^(�V��) ----------------------------------------------------------------------
        sql.append("   ,(SELECT");
        sql.append("         TRIM(" + TBTHBAMST.FIELD1 + ") AS " + TBTHBAMST.FIELD1);    // �t�B�[���h1
        sql.append("        ,TRIM(" + TBTHBAMST.FIELD2 + ") AS " + TBTHBAMST.FIELD2);    // �t�B�[���h2
        sql.append("        ,TRIM(" + TBTHBAMST.FIELD3 + ") AS " + TBTHBAMST.FIELD3);    // �t�B�[���h3
        sql.append("        ,TRIM(" + TBTHBAMST.FIELD4 + ") AS " + TBTHBAMST.FIELD4);    // �t�B�[���h4
        sql.append("     FROM");
        sql.append("         " + TBTHBAMST.TBNAME);
        sql.append("     WHERE");
        sql.append("         " + TBTHBAMST.EGCD + "        = '" + _cond.getEgCd() + "'");
        sql.append("     AND " + TBTHBAMST.TKSKGYCD + "    = '" + _cond.getTksKgyCd() + "'");
        sql.append("     AND " + TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "'");
        sql.append("     AND " + TBTHBAMST.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "'");
        sql.append("     AND " + TBTHBAMST.SYBT  + "       = '907'");
        sql.append("    ) " + TBL_J);

        // �����捞 -----------------------------------------------------------------------------------------
        sql.append("    ,(SELECT");
        sql.append("         " + TBTHB5HIK.IRBAN  );                                        // �˗��ԍ��i�����ԍ��j
        sql.append("        ," + TBTHB5HIK.IRROWBAN  );                                     // �˗��s�ԍ��i�����s�ԍ��j
        sql.append("        ,NVL(" + TBTHB5HIK.SAIKBN + ", '') AS " + TBTHB5HIK.SAIKBN);    // �זڋ敪
        sql.append("     FROM ");
        sql.append("         " + TBTHB5HIK.TBNAME);
        sql.append("     WHERE ");
        sql.append("         " + TBTHB5HIK.TKSKGYCD + "    = '" + _cond.getTksKgyCd() + "'");
        sql.append("     AND " + TBTHB5HIK.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "'");
        sql.append("     AND " + TBTHB5HIK.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "'");
        // �Ϗ���
        sql.append(this.GetCondition(""));
        sql.append("     GROUP BY");
        sql.append("         " + TBTHB5HIK.IRBAN  );
        sql.append("        ," + TBTHB5HIK.IRROWBAN  );
        sql.append("        ," + TBTHB5HIK.SAIKBN );
        sql.append("     UNION ");
        sql.append("     SELECT");
        sql.append("         " + TBTHB5HIK.IRBAN  );                                        // �˗��ԍ��i�����ԍ��j
        sql.append("        ," + TBTHB5HIK.IRROWBAN  );                                     // �˗��s�ԍ��i�����s�ԍ��j
        sql.append("        ,NVL(" + TBTHB5HIK.SAIKBN + ", '') AS " + TBTHB5HIK.SAIKBN);    // �זڋ敪
        sql.append("     FROM ");
        sql.append("         " + TBTHB5HIK.TBNAME);
        sql.append("     WHERE ");
        sql.append("         " + TBTHB5HIK.TKSKGYCD + "    = '" + _cond.getTksKgyCd() + "'");
        sql.append("     AND " + TBTHB5HIK.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "'");
        sql.append("     AND " + TBTHB5HIK.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "'");
        // �Ϗ���
        sql.append(this.GetConditionDiff(""));
        sql.append("     GROUP BY");
        sql.append("         " + TBTHB5HIK.IRBAN  );
        sql.append("        ," + TBTHB5HIK.IRROWBAN  );
        sql.append("        ," + TBTHB5HIK.SAIKBN );
        sql.append("    ) " + TBL_K);

        // ============================================================================================================================================
        // WHERE��
        // ============================================================================================================================================
        sql.append(" WHERE");
        // �������� -------------------------------------------------------------------------------------------------------
        sql.append("     " + TBL_B + "." + TBTHB1DOWN.EGCD + "        = " + TBL_A + "." + TBTHB2KMEI.EGCD);
        sql.append(" AND " + TBL_B + "." + TBTHB1DOWN.TKSKGYCD + "    = " + TBL_A + "." + TBTHB2KMEI.TKSKGYCD);
        sql.append(" AND " + TBL_B + "." + TBTHB1DOWN.TKSBMNSEQNO + " = " + TBL_A + "." + TBTHB2KMEI.TKSBMNSEQNO);
        sql.append(" AND " + TBL_B + "." + TBTHB1DOWN.TKSTNTSEQNO + " = " + TBL_A + "." + TBTHB2KMEI.TKSTNTSEQNO);
        sql.append(" AND " + TBL_B + "." + TBTHB1DOWN.YYMM + "        = " + TBL_A + "." + TBTHB2KMEI.YYMM);
        sql.append(" AND " + TBL_B + "." + TBTHB1DOWN.JYUTNO + "      = " + TBL_A + "." + TBTHB2KMEI.JYUTNO);
        sql.append(" AND " + TBL_B + "." + TBTHB1DOWN.JYMEINO + "     = " + TBL_A + "." + TBTHB2KMEI.JYMEINO);
        sql.append(" AND " + TBL_B + "." + TBTHB1DOWN.URMEINO + "     = " + TBL_A + "." + TBTHB2KMEI.URMEINO);
        sql.append(" AND " + TBL_C + "." + TBTHBAMST.FIELD1 + "    (+)= TRIM(" + TBL_A + "." + SYBT_CD + ")");
        sql.append(" AND " + TBL_C + "." + TBTHBAMST.FIELD2 + "    (+)= TRIM(" + TBL_A + "." + TBTHB2KMEI.CODE2 + ")");
        sql.append(" AND " + TBL_D + "." + TBTHBAMST.FIELD1 + "    (+)= TRIM(" + TBL_A + "." + SYBT_CD + ")");
        sql.append(" AND " + TBL_D + "." + TBTHBAMST.FIELD2 + "    (+)= TRIM(" + TBL_A + "." + TBTHB2KMEI.NAME11 + ")");
        sql.append(" AND " + TBL_E + "." + TBTHBAMST.FIELD1 + "    (+)= TRIM(" + TBL_A + "." + SYBT_CD + ")");
        sql.append(" AND " + TBL_E + "." + TBTHBAMST.FIELD2 + "    (+)= TRIM(" + TBL_A + "." + TBTHB2KMEI.NAME12 + ")");
        sql.append(" AND " + TBL_F + "." + TBTHBAMST.FIELD1 + "    (+)= TRIM(" + TBL_A + "." + SYBT_CD + ")");
        sql.append(" AND " + TBL_F + "." + TBTHBAMST.FIELD2 + "    (+)= TRIM(" + TBL_A + "." + TBTHB2KMEI.NAME13 + ")");
        sql.append(" AND " + TBL_G + "." + TBTHBAMST.FIELD1 + "    (+)= TRIM(" + TBL_A + "." + SYBT_CD + ")");
        sql.append(" AND " + TBL_G + "." + TBTHBAMST.FIELD2 + "    (+)= TRIM(" + TBL_A + "." + TBTHB2KMEI.NAME11 + ")");
        sql.append(" AND " + TBL_H + "." + TBTHBAMST.FIELD1 + "    (+)= TRIM(" + TBL_A + "." + SYBT_CD + ")");
        sql.append(" AND " + TBL_H + "." + TBTHBAMST.FIELD2 + "    (+)= TRIM(" + TBL_A + "." + TBTHB2KMEI.NAME14 + ")");
        sql.append(" AND " + TBL_I + "." + TBTHBAMST.FIELD1 + "    (+)= TRIM(" + TBL_A + "." + SYBT_CD + ")");
        sql.append(" AND " + TBL_I + "." + TBTHBAMST.FIELD2 + "    (+)= TRIM(" + TBL_A + "." + TBTHB2KMEI.NAME12 + ")");
        sql.append(" AND " + TBL_J + "." + TBTHBAMST.FIELD1 + "    (+)= TRIM(" + TBL_A + "." + SYBT_CD + ")");
        sql.append(" AND " + TBL_J + "." + TBTHBAMST.FIELD2 + "    (+)= TRIM(" + TBL_A + "." + TBTHB2KMEI.NAME15 + ")");
        sql.append(" AND " + TBL_K + "." + TBTHB5HIK.IRBAN + "     (+)= TRIM(" + TBL_A + "." + TBTHB2KMEI.CODE3 + ")");
        sql.append(" AND " + TBL_K + "." + TBTHB5HIK.IRROWBAN + "  (+)= TRIM(" + TBL_A + "." + TBTHB2KMEI.CODE4 + ")");
        // �������� -------------------------------------------------------------------------------------------------------
        sql.append(" AND " + TBL_B + "." + TBTHB1DOWN.TJYUTNO + " = ' '");

        // ============================================================================================================================================
        // ORDER BY��
        // ============================================================================================================================================
        sql.append(" ORDER BY");
        sql.append(" " + TBL_A + "." + TBTHB2KMEI.CODE3);        // �R�[�h3(�����ԍ�)
        sql.append("," + TBL_A + "." + TBTHB2KMEI.SONOTA1);      // ���̑�1(�������ԍ�)
        sql.append("," + TBL_A + "." + TBTHB2KMEI.DATE1);        // ���t1(���������s��)
        sql.append("," + TBL_A + "." + TBTHB2KMEI.KBN2);         // �敪2(�l���s�敪)
        sql.append("," + TBL_A + "." + TBTHB2KMEI.CODE4);        // �����s�ԍ�
        sql.append("," + TBL_A + "." + TBTHB2KMEI.JYUTNO);       // ��No
        sql.append("," + TBL_A + "." + TBTHB2KMEI.JYMEINO);      // �󒍖���No
        sql.append("," + TBL_A + "." + TBTHB2KMEI.URMEINO);      // ���㖾��No
        sql.append("," + TBL_A + "." + TBTHB2KMEI.RENBN);        // �A��

        return sql.toString();
    }

    /**
     * �l���}�X�^ ���擾��SQL����Ԃ��܂��B
     *
     * @return String SQL��
     */
    private String getSelectSQLForNebiki() {

        StringBuffer sql = new StringBuffer();

        // ====================================================================================================
        // SELECT��
        // ====================================================================================================
        sql.append(" SELECT ");
        sql.append("  " + TBL_A + ".MEU19_NBIKSINSEINO");    //
        sql.append(" ," + TBL_B + ".MEU1A_GYOMKBN");         // �Ɩ��敪
        sql.append(" ," + TBL_B + ".MEU1A_BTAICD");          // �}�̃R�[�h�i���f�B�A�R�[�h�j
        sql.append(" ," + TBL_B + ".MEU1A_HMOKCD");          // ��ڃR�[�h
        sql.append(" ," + TBL_B + ".MEU1A_NBIKRITU");        // �l����

        // ====================================================================================================
        // FROM��
        // ====================================================================================================
        sql.append(" FROM");
        sql.append("  rcmn_MEU19NBJK    " + TBL_A);
        sql.append(" ,rcmn_MEU1ANBNAIYO " + TBL_B);

        // ====================================================================================================
        // WHERE��
        // ====================================================================================================
        sql.append(" WHERE");
        sql.append("     " + TBL_A + ".MEU19_THSKGYCD      = '" + _cond.getTksKgyCd() + "'");
        sql.append(" AND " + TBL_A + ".MEU19_SEQNO         = '" + _cond.getTksBmnSeqNo() + "'");
        sql.append(" AND " + TBL_A + ".MEU19_TRTNTSEQNO    = '" + _cond.getTksTntSeqNo() + "'");
        sql.append(" AND " + TBL_A + ".MEU19_TYSYMD       <= '" + _cond.getKeisaiDay() + "'");
        sql.append(" AND " + TBL_A + ".MEU19_TYEYMD       >= '" + _cond.getKeisaiDay() + "'");
        sql.append(" AND " + TBL_A + ".MEU19_ENDYMD        = '99999999'");

        // �������� ---------------------------------------------------------------------------------------------
        sql.append(" AND " + TBL_A + ".MEU19_THSKGYCD      = " + TBL_B + ".MEU1A_THSKGYCD");
        sql.append(" AND " + TBL_A + ".MEU19_SEQNO         = " + TBL_B + ".MEU1A_SEQNO");
        sql.append(" AND " + TBL_A + ".MEU19_TRTNTSEQNO    = " + TBL_B + ".MEU1A_TRTNTSEQNO");
        sql.append(" AND " + TBL_A + ".MEU19_NBIKSINSEINO  = " + TBL_B + ".MEU1A_NBIKSINSEINO");

        // ====================================================================================================
        // ORDER BY��
        // ====================================================================================================
        sql.append(" ORDER BY");
        sql.append(" " + TBL_A + ".MEU19_NBIKSINSEINO");
        sql.append("," + TBL_A + ".MEU19_KESYM");

        return sql.toString();
    }

    /**
     * �ς̌����������擾����
     * @param  tblName �e�[�u����
     * @return �ς̌�������
     */
    private String GetCondition(String tblName) {

        StringBuffer buff = new StringBuffer();

        // ���������D��ʂ̗v�f�擾�i�J���}��؂�ׁ̈A�������Ď擾����j
        String[] baitai = _cond.getSybt().replace("\'","").split(",");

        // �e�[�u�����̐ݒ�
        String tblStr = "";
        if (tblName.equals("")) {
            tblStr = "";
        }
        else {
            tblStr = tblName + ".";
        }

        for (int i = 0; i < baitai.length; i++) {

            // ��ʂ��u21:�V���v�̏ꍇ
            if (FindClaimByCondManager.C_BAITAI_SHINBUN.equals(baitai[i].trim())) {

                if (0 < buff.toString().length()) {
                    buff.append(" OR ");
                }

                // ���������̐ݒ�
                StringBuffer temp = new StringBuffer();
                temp.append("(");
                temp.append(tblStr + TBTHB5HIK.SYBT + " = '" + FindClaimByCondManager.C_BAITAI_SHINBUN + "'");
                temp.append(" AND ");
                temp.append(tblStr + TBTHB5HIK.URIYYMM + " = '" + _cond.getYymm() + "'");
                temp.append(")");

                buff.append(temp.toString());

            // ��ʂ��u22:�G���v�̏ꍇ
            } else if (FindClaimByCondManager.C_BAITAI_ZASHI.equals(baitai[i].trim())) {

                if (0 < buff.toString().length()) {
                    buff.append(" OR ");
                }

                // ���������̐ݒ�
                StringBuffer temp = new StringBuffer();
                temp.append("(");
                temp.append(tblStr + TBTHB5HIK.SYBT + " = '" + FindClaimByCondManager.C_BAITAI_ZASHI + "'");
                temp.append(" AND ");
                temp.append(tblStr + TBTHB5HIK.URIYYMM + " = '" + _cond.getYymm() + "'");
                temp.append(")");

                buff.append(temp.toString());

            // ��ʂ��u11:�d�g�v�̏ꍇ
            } else if (FindClaimByCondManager.C_BAITAI_DENPA.equals(baitai[i].trim())) {

                if (0 < buff.toString().length()) {
                    buff.append(" OR ");
                }

                // ���������̐ݒ�
                StringBuffer temp = new StringBuffer();
                temp.append(" ( ");
                temp.append(tblStr + TBTHB5HIK.SYBT + " = '" + FindClaimByCondManager.C_BAITAI_DENPA + "'");
                temp.append(" AND ");
                temp.append(" ( ");
                temp.append(" ( ");
                temp.append(" TRIM(" + tblStr + TBTHB5HIK.IRMONTH1 + ") = '" + _cond.getYymm() + "'");
                temp.append(" AND ");
                temp.append(" " + tblStr + TBTHB5HIK.HOSORYO1 + " <> 0");
                temp.append(" ) ");
                temp.append(" OR ");
                temp.append(" ( ");
                temp.append(" TRIM(" + tblStr + TBTHB5HIK.IRMONTH2 + ") = '" + _cond.getYymm() + "'");
                temp.append(" AND ");
                temp.append(" " + tblStr + TBTHB5HIK.HOSORYO2 + " <> 0");
                temp.append(" ) ");
                temp.append(" OR ");
                temp.append(" ( ");
                temp.append(" TRIM(" + tblStr + TBTHB5HIK.IRMONTH3 + ") = '" + _cond.getYymm() + "'");
                temp.append("  AND ");
                temp.append(" " + tblStr + TBTHB5HIK.HOSORYO3 + " <> 0");
                temp.append(" ) ");
                temp.append(" OR ");
                temp.append(" ( ");
                temp.append(" TRIM(" + tblStr + TBTHB5HIK.IRMONTH4 + ") = '" + _cond.getYymm() + "'");
                temp.append(" AND ");
                temp.append(" " + tblStr + TBTHB5HIK.HOSORYO4 + " <> 0");
                temp.append(" ) ");
                temp.append(" OR ");
                temp.append(" ( ");
                temp.append(" TRIM(" + tblStr + TBTHB5HIK.IRMONTH5 + ") = '" + _cond.getYymm() + "'");
                temp.append(" AND ");
                temp.append(" " + tblStr + TBTHB5HIK.HOSORYO5 + " <> 0");
                temp.append(" ) ");
                temp.append(" OR ");
                temp.append(" (");
                temp.append(" TRIM(" + tblStr + TBTHB5HIK.IRMONTH6 + ") = '" + _cond.getYymm() + "'");
                temp.append(" AND ");
                temp.append(" " + tblStr + TBTHB5HIK.HOSORYO6 + " <> 0");
                temp.append(" ) ");
                temp.append(" ) ");
                temp.append(" ) ");

                buff.append(temp.toString());

            // ��ʂ��u31:��ʁv�̏ꍇ
            } else if (FindClaimByCondManager.C_BAITAI_KOTSU.equals(baitai[i].trim())) {

                if (0 < buff.toString().length()) {
                    buff.append(" OR ");
                }

                // ���������̐ݒ�
                StringBuffer temp = new StringBuffer();
                temp.append("(");
                temp.append(tblStr + TBTHB5HIK.SYBT + " = '" + FindClaimByCondManager.C_BAITAI_KOTSU + "'");
                temp.append(" AND ");
                temp.append(tblStr + TBTHB5HIK.URIYYMM + " = '" + _cond.getYymm() + "'");
                temp.append(")");

                buff.append(temp.toString());
            }
        }

        // �����������w�肳��Ă���ꍇ�́A�쐬�����������Ԃ�
        if (0 < buff.toString().length()) {
            return " AND (" +  buff.toString() + ") ";
        } else {
            return "";
        }
    }

    /**
     * �ς̌����������擾����
     * @param  tblName �e�[�u����
     * @return �ς̌�������
     */
    private String GetConditionDiff(String tblName) {

        StringBuffer buff = new StringBuffer();

        // ���������D��ʂ̗v�f�擾�i�J���}��؂�ׁ̈A�������Ď擾����j
        String[] baitai = _cond.getSybt().replace("\'","").split(",");

        // �e�[�u�����̐ݒ�
        String tblStr = "";
        if (tblName.equals("")) {
            tblStr = "";
        }
        else {
            tblStr = tblName + ".";
        }

        for (int i = 0; i < baitai.length; i++) {

            // ��ʂ��u21:�V���v�̏ꍇ
            if (FindClaimByCondManager.C_BAITAI_SHINBUN.equals(baitai[i].trim())) {

                if (0 < buff.toString().length()) {
                    buff.append(" OR ");
                }

                // ���������̐ݒ�
                StringBuffer temp = new StringBuffer();
                temp.append("(");
                temp.append(tblStr + TBTHB5HIK.SYBT + " <> '" + FindClaimByCondManager.C_BAITAI_SHINBUN + "'");
                temp.append(" AND ");
                temp.append(tblStr + TBTHB5HIK.URIYYMM + " <> '" + _cond.getYymm() + "'");
                temp.append(")");

                buff.append(temp.toString());

            // ��ʂ��u22:�G���v�̏ꍇ
            } else if (FindClaimByCondManager.C_BAITAI_ZASHI.equals(baitai[i].trim())) {

                if (0 < buff.toString().length()) {
                    buff.append(" OR ");
                }

                // ���������̐ݒ�
                StringBuffer temp = new StringBuffer();
                temp.append("(");
                temp.append(tblStr + TBTHB5HIK.SYBT + " <> '" + FindClaimByCondManager.C_BAITAI_ZASHI + "'");
                temp.append(" AND ");
                temp.append(tblStr + TBTHB5HIK.URIYYMM + " <> '" + _cond.getYymm() + "'");
                temp.append(")");

                buff.append(temp.toString());

            // ��ʂ��u11:�d�g�v�̏ꍇ
            } else if (FindClaimByCondManager.C_BAITAI_DENPA.equals(baitai[i].trim())) {

                if (0 < buff.toString().length()) {
                    buff.append(" OR ");
                }

                // ���������̐ݒ�
                StringBuffer temp = new StringBuffer();
                temp.append(" ( ");
                temp.append(tblStr + TBTHB5HIK.SYBT + " = '" + FindClaimByCondManager.C_BAITAI_DENPA + "'");
                temp.append(" AND ");
                temp.append(" NOT ( ");
                temp.append(" ( ");
                temp.append(" TRIM(" + tblStr + TBTHB5HIK.IRMONTH1 + ") = '" + _cond.getYymm() + "'");
                temp.append(" AND ");
                temp.append(" " + tblStr + TBTHB5HIK.HOSORYO1 + " <> 0");
                temp.append(" ) ");
                temp.append(" OR ");
                temp.append(" ( ");
                temp.append(" TRIM(" + tblStr + TBTHB5HIK.IRMONTH2 + ") = '" + _cond.getYymm() + "'");
                temp.append(" AND ");
                temp.append(" " + tblStr + TBTHB5HIK.HOSORYO2 + " <> 0");
                temp.append(" ) ");
                temp.append(" OR ");
                temp.append(" ( ");
                temp.append(" TRIM(" + tblStr + TBTHB5HIK.IRMONTH3 + ") = '" + _cond.getYymm() + "'");
                temp.append(" AND ");
                temp.append(" " + tblStr + TBTHB5HIK.HOSORYO3 + " <> 0");
                temp.append(" ) ");
                temp.append(" OR ");
                temp.append(" ( ");
                temp.append(" TRIM(" + tblStr + TBTHB5HIK.IRMONTH4 + ") = '" + _cond.getYymm() + "'");
                temp.append(" AND ");
                temp.append(" " + tblStr + TBTHB5HIK.HOSORYO4 + " <> 0");
                temp.append(" ) ");
                temp.append(" OR ");
                temp.append(" ( ");
                temp.append(" TRIM(" + tblStr + TBTHB5HIK.IRMONTH5 + ") = '" + _cond.getYymm() + "'");
                temp.append(" AND ");
                temp.append(" " + tblStr + TBTHB5HIK.HOSORYO5 + " <> 0");
                temp.append(" ) ");
                temp.append(" OR ");
                temp.append(" ( ");
                temp.append(" TRIM(" + tblStr + TBTHB5HIK.IRMONTH6 + ") = '" + _cond.getYymm() + "'");
                temp.append(" AND ");
                temp.append(" " + tblStr + TBTHB5HIK.HOSORYO6 + " <> 0");
                temp.append(" ) ");
                temp.append(" ) ");
                temp.append(" ) ");

                buff.append(temp.toString());

            // ��ʂ��u31:��ʁv�̏ꍇ
            } else if (FindClaimByCondManager.C_BAITAI_KOTSU.equals(baitai[i].trim())) {

                if (0 < buff.toString().length()) {
                    buff.append(" OR ");
                }

                // ���������̐ݒ�
                StringBuffer temp = new StringBuffer();
                temp.append("(");
                temp.append(tblStr + TBTHB5HIK.SYBT + " = '" + FindClaimByCondManager.C_BAITAI_KOTSU + "'");
                temp.append(" AND ");
                temp.append(tblStr + TBTHB5HIK.URIYYMM + " = '" + _cond.getYymm() + "'");
                temp.append(")");

                buff.append(temp.toString());
            }
        }

        // �����������w�肳��Ă���ꍇ�́A�쐬�����������Ԃ�
        if (0 < buff.toString().length()) {
            return " AND (" +  buff.toString() + ") ";
        } else {
            return "";
        }
    }

    /**
     * ����/�����ԍ� �ꗗ���̌������s���܂��B
     *
     * @return ����/�����ԍ� �ꗗ�����܂�VO���X�g
     * @throws UserException
     *             �f�[�^�A�N�Z�X���ɃG���[�����������ꍇ�B
     */
    @SuppressWarnings("unchecked")
    public List<FindClaimNoCondVO> findClaimNoDataByCondition(
            FindClaimCondition cond) throws KKHException {

        super.setModel(new FindClaimNoCondVO());

        try {
            _cond = cond;
            _sqlMode = SqlMode.CLAIMNO;
            return super.find();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0002");
        }
    }

    /**
     * ����/���� ���وꗗ���̌������s���܂��B
     *
     * @return ����/���� ���وꗗ�����܂�VO���X�g
     * @throws UserException
     *             �f�[�^�A�N�Z�X���ɃG���[�����������ꍇ�B
     */
    @SuppressWarnings("unchecked")
    public List<FindClaimDiffCondVO> findClaimDiffDataByCondition(
            FindClaimCondition cond) throws KKHException {

        super.setModel(new FindClaimDiffCondVO());

        try {
            _cond = cond;
            _sqlMode = SqlMode.CLAIMDIFF;
            return super.find();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0002");
        }
    }

    /**
     * �����f�[�^ �ꗗ���̌������s���܂��B
     *
     * @return �����f�[�^ �ꗗ�����܂�VO���X�g
     * @throws UserException
     *             �f�[�^�A�N�Z�X���ɃG���[�����������ꍇ�B
     */
    @SuppressWarnings("unchecked")
    public List<FindClaimCondVO> findClaimDataByCondition(
            FindClaimCondition cond) throws KKHException {

        super.setModel(new FindClaimCondVO());

        try {
            _cond = cond;
            _sqlMode = SqlMode.CLAIM;
            return super.find();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0002");
        }
    }

    /**
     * �l���}�X�^ ���̌������s���܂��B
     *
     * @return �l���}�X�^ �����܂�VO���X�g
     * @throws UserException
     *             �f�[�^�A�N�Z�X���ɃG���[�����������ꍇ�B
     */
    @SuppressWarnings("unchecked")
    public List<FindNebikiCondVO> findNebikiDataByCondition(
            FindClaimCondition cond) throws KKHException {

        super.setModel(new FindNebikiCondVO());

        try {
            _cond = cond;
            _sqlMode = SqlMode.NEBIKI;
            return super.find();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0002");
        }
    }
}
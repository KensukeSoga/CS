package jp.co.isid.kkh.customer.lion.model.master;


import jp.co.isid.kkh.integ.tbl.TBTHB10WLRDB;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractSimpleRdbDao;

/**
 *
 * <P>
 * ���W�I�ԑg�}�X�^�f�[�^�o�^DAO
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/02/15 JSE A.Naito)<BR>
 * </P>
 * @author JSE A.Naito
 */
public class LionRdMastRegisterDAO extends AbstractSimpleRdbDao {

    /**�ėp�}�X�^(�f�[�^)��������*/
    private LionCondition _cond;

    /**
     * �f�t�H���g�R���X�g���N�^�B
     */
    public LionRdMastRegisterDAO() {
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
        return TBTHB10WLRDB.TRKTIMSTMP;
    }

    /**
     * �V�X�e�����t�ōX�V�����̒�`�ł�
     */
    @Override
    protected String[] getSystemDateColumnNames() {
        return new String[] { TBTHB10WLRDB.TRKTIMSTMP,TBTHB10WLRDB.UPDTIMSTMP };
    }

    /**
     * �e�[�u������Ԃ��܂��B
     *
     * @return String �e�[�u����
     */
    public String getTableName() {
        return TBTHB10WLRDB.TBNAME;
    }

    /**
     * �e�[�u���񖼂�Ԃ��܂��B
     *
     * @return String[] �e�[�u����
     */
    public String[] getTableColumnNames() {
        return new String[]{
                TBTHB10WLRDB.TRKTIMSTMP
                ,TBTHB10WLRDB.TRKPL
                ,TBTHB10WLRDB.TRKTNT
                ,TBTHB10WLRDB.UPDTIMSTMP
                ,TBTHB10WLRDB.UPDAPL
                ,TBTHB10WLRDB.UPDTNT
                ,TBTHB10WLRDB.EGCD
                ,TBTHB10WLRDB.TKSKGYCD
                ,TBTHB10WLRDB.TKSBMNSEQNO
                ,TBTHB10WLRDB.TKSTNTSEQNO
                ,TBTHB10WLRDB.BANCD
                ,TBTHB10WLRDB.BANNAME
                ,TBTHB10WLRDB.HKYOKUCD
                ,TBTHB10WLRDB.SEISAKUHI
                ,TBTHB10WLRDB.HYOJIJYUN
                ,TBTHB10WLRDB.TANKA
                ,TBTHB10WLRDB.TYPE2
        };
    }

    /**
     * �ėp�}�X�^(�f�[�^)�̓o�^
     *
     * @param vo �}�X�^�f�[�^VO�iINSERT�p�j
     * @throws KKHException �f�[�^�A�N�Z�X���ɃG���[�����������ꍇ
     */
    public void registLionRdMastDataVO(LionRdMastDataInsertVO vo) throws KKHException {
        //�p�����[�^�`�F�b�N
        if (vo == null) {
            throw new KKHException("�o�^�G���[", "BD-E0004");
        }
        super.setModel(vo);
        try {
            if (!super.insert()) {
                throw new KKHException("�o�^�G���[", "BD-E0004");
            }
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0004");
        }
    }

    /**
     * �폜�r�p�k����
     */
    @Override
    public String getExecString() {

        StringBuffer sql = new StringBuffer();

        sql.append(" DELETE ");
        sql.append(" FROM ");
        sql.append(" " + TBTHB10WLRDB.TBNAME + " ");
        // Where��
        sql.append(" WHERE ");
        sql.append(" " + TBTHB10WLRDB.EGCD + " = '" + _cond.getEgCd() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHB10WLRDB.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHB10WLRDB.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHB10WLRDB.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' ");

        return sql.toString();
    }

    /**
     * �ėp�}�X�^(�f�[�^)�̍폜
     *
     * @param cond �폜����
     * @throws KKHException �f�[�^�A�N�Z�X���ɃG���[�����������ꍇ
     */
    public boolean deleteLionDataByCondition(LionCondition cond) throws KKHException {
        //�p�����[�^�`�F�b�N
        if (cond == null) {
            throw new KKHException("�폜�G���[", "BD-E0003");
        }

        try {
            _cond = cond;
            super.exec();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0003");
        }

        return true;
    }

}
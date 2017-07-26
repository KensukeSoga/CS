package jp.co.isid.kkh.customer.lion.model.master;


import jp.co.isid.kkh.integ.tbl.TBTHB9WLTVB;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractSimpleRdbDao;

/**
 *
 * <P>
 * TV�ԑg�}�X�^�f�[�^�o�^DAO
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2011/11/11 JSE H.Abe)<BR>
 * </P>
 * @author JSE H.Abe
 */
public class LionTvMastRegisterDAO extends AbstractSimpleRdbDao {

    /**�ėp�}�X�^(�f�[�^)��������*/
    private LionCondition _cond;

    /**
     * �f�t�H���g�R���X�g���N�^�B
     */
    public LionTvMastRegisterDAO() {
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
        return TBTHB9WLTVB.TRKTIMSTMP;
    }

    /**
     * �V�X�e�����t�ōX�V�����̒�`�ł�
     */
    @Override
    protected String[] getSystemDateColumnNames() {
        return new String[] { TBTHB9WLTVB.TRKTIMSTMP,TBTHB9WLTVB.UPDTIMSTMP };
    }

    /**
     * �e�[�u������Ԃ��܂��B
     *
     * @return String �e�[�u����
     */
    public String getTableName() {
        return TBTHB9WLTVB.TBNAME;
    }

    /**
     * �e�[�u���񖼂�Ԃ��܂��B
     *
     * @return String[] �e�[�u����
     */
    public String[] getTableColumnNames() {
        return new String[]{
                TBTHB9WLTVB.TRKTIMSTMP
                ,TBTHB9WLTVB.TRKPL
                ,TBTHB9WLTVB.TRKTNT
                ,TBTHB9WLTVB.UPDTIMSTMP
                ,TBTHB9WLTVB.UPDAPL
                ,TBTHB9WLTVB.UPDTNT
                ,TBTHB9WLTVB.EGCD
                ,TBTHB9WLTVB.TKSKGYCD
                ,TBTHB9WLTVB.TKSBMNSEQNO
                ,TBTHB9WLTVB.TKSTNTSEQNO
                ,TBTHB9WLTVB.BANCD
                ,TBTHB9WLTVB.BANNAME
                ,TBTHB9WLTVB.HKYOKUCD
                ,TBTHB9WLTVB.SEISAKUHI
                ,TBTHB9WLTVB.HYOJIJYUN
                ,TBTHB9WLTVB.TANKA
                ,TBTHB9WLTVB.TYPE2
        };
    }

    /**
     * �ėp�}�X�^(�f�[�^)�̓o�^
     *
     * @param vo �}�X�^�f�[�^VO�iINSERT�p�j
     * @throws KKHException �f�[�^�A�N�Z�X���ɃG���[�����������ꍇ
     */
    public void registLionTvMastDataVO(LionTvMastDataInsertVO vo) throws KKHException {
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
        sql.append(" " + TBTHB9WLTVB.TBNAME + " ");
        // Where��
        sql.append(" WHERE ");
        sql.append(" " + TBTHB9WLTVB.EGCD + " = '" + _cond.getEgCd() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHB9WLTVB.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHB9WLTVB.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHB9WLTVB.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' ");

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
package jp.co.isid.kkh.customer.mac.model.master;

import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.model.master.MasterCondition;

/**
 * <P>
 * �}�N�h�i���h�X�܃}�X�^�����e�[�u������Manager�B
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2013/02/01 JSE H.Okazaki)<BR>
 * </P>
 * @author
 */
public class MasterMacTnpRManager {

    /** �V���O���g���C���X�^���X */
    private static MasterMacTnpRManager _manager = new MasterMacTnpRManager();

    /**
     * �V���O���g���ׁ̈A�C���X�^���X�����֎~���܂��B
     */
    private MasterMacTnpRManager() {
    }

    /**
     * �C���X�^���X��Ԃ��܂��B
     *
     * @return �C���X�^���X
     */
    public static MasterMacTnpRManager getInstance() {
        return _manager;
    }

    /**
     * �}�N�h�i���h�X�܃}�X�^�����e�[�u���ɑS�f�[�^�o�^
     *
     * @param cond �o�^����
     *        aplid �A�v��ID
     * @throws KKHException �������ɃG���[�����������ꍇ
     */
    public void insertAllData(MasterCondition cond, String aplid) throws KKHException {
            MasterMacTnpRRegisterDAO dao = MasterMacTnpRRegisterDAOFactory.createMasterRegisterDAO();
            dao.insertAllDataVO(cond,aplid);
    }

    /**
     * �}�N�h�i���h�X�܃}�X�^�����e�[�u���ɐV�K�f�[�^�o�^
     *
     * @param cond �o�^����
     *        aplid �A�v��ID
     * @throws KKHException �������ɃG���[�����������ꍇ
     */
    public void insertNewData(MasterCondition cond, String aplid) throws KKHException {
            MasterMacTnpRRegisterDAO dao = MasterMacTnpRRegisterDAOFactory.createMasterRegisterDAO();
            dao.insertNewDataVO(cond,aplid);
    }

    /**
     * �}�N�h�i���h�X�܃}�X�^�����e�[�u������f�[�^�폜
     *
     * @param cond �o�^����
     * @throws KKHException �������ɃG���[�����������ꍇ
     */
    public void deleteData(MasterCondition cond) throws KKHException {
            MasterMacTnpRRegisterDAO dao = MasterMacTnpRRegisterDAOFactory.createMasterRegisterDAO();
            dao.deleteDataVO(cond);
    }

    /**
     * �}�N�h�i���h�X�܃}�X�^�����e�[�u���̃f�[�^���폜���[�h�ɍX�V
     *
     * @param cond �o�^����
     * @throws KKHException �������ɃG���[�����������ꍇ
     */
    public void updateDelMode(MasterCondition cond) throws KKHException {
            MasterMacTnpRRegisterDAO dao = MasterMacTnpRRegisterDAOFactory.createMasterRegisterDAO();
            dao.updateDelModeVO(cond);
    }

    /**
    * �}�N�h�i���h�X�܃}�X�^�����e�[�u���̍X�V���{�L�[���ꊇ�X�V
     *
     * @param cond �o�^����
     * @throws KKHException �������ɃG���[�����������ꍇ
     */
    public void updateDate(MasterCondition cond) throws KKHException {
            MasterMacTnpRRegisterDAO dao = MasterMacTnpRRegisterDAOFactory.createMasterRegisterDAO();
            dao.updateDateVO(cond);
    }

}

package jp.co.isid.kkh.customer.mac.model.master;

import jp.co.isid.nj.integ.DaoFactory;


/**
 * <P>
 * �}�X�^�f�[�^�o�^DAO�̃t�@�N�g���N���X
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2011/12/27 IP Shimizu)<BR>
 * </P>
 * @author IP Shimizu
 */
final class MasterMacRegisterDAOFactory extends DaoFactory {

    /**
    * �C���X�^���X�����֎~���܂��B
    */
    private MasterMacRegisterDAOFactory() {
    }

    /**
     * �X�V�E�폜DAO�C���X�^���X�𐶐����܂��B
     * @return �X�V�E�폜DAO�C���X�^���X
     */
    public static MasterMacRegisterDAO createMasterRegisterDAO() {
        return (MasterMacRegisterDAO) DaoFactory.createDao(MasterMacRegisterDAO.class);
    }
}

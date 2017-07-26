package jp.co.isid.kkh.customer.mac.model.master;

import jp.co.isid.nj.integ.DaoFactory;


/**
 * <P>
 * �}�N�h�i���h�X�܃}�X�^�����e�[�u���o�^DAO�̃t�@�N�g���N���X
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2013/02/01 JSE H.Okazaki)<BR>
 * </P>
 * @author IP Shimizu
 */
final class MasterMacTnpRRegisterDAOFactory extends DaoFactory {

    /**
    * �C���X�^���X�����֎~���܂��B
    */
    private MasterMacTnpRRegisterDAOFactory() {
    }

    /**
     * DAO�C���X�^���X�𐶐����܂��B
     * @return DAO�C���X�^���X
     */
    public static MasterMacTnpRRegisterDAO createMasterRegisterDAO() {
        return (MasterMacTnpRRegisterDAO) DaoFactory.createDao(MasterMacTnpRRegisterDAO.class);
    }
}

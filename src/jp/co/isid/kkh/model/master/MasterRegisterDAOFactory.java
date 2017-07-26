package jp.co.isid.kkh.model.master;

import jp.co.isid.nj.integ.DaoFactory;


/**
 * <P>
 * �}�X�^�f�[�^�o�^DAO�̃t�@�N�g���N���X
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2011/02/17 HLC K.Honma)<BR>
 * </P>
 * @author HLC K.Honma
 */
final class MasterRegisterDAOFactory extends DaoFactory {

    /**
    * �C���X�^���X�����֎~���܂��B
    */
    private MasterRegisterDAOFactory() {
    }

    /**
     * �X�V�E�폜DAO�C���X�^���X�𐶐����܂��B
     * @return �X�V�E�폜DAO�C���X�^���X
     */
    public static MasterRegisterDAO createMasterRegisterDAO() {
        return (MasterRegisterDAO) DaoFactory.createDao(MasterRegisterDAO.class);
    }
}

package jp.co.isid.kkh.customer.lion.model.master;

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
final class LionTvMastRegisterDAOFactory extends DaoFactory {

    /**
    * �C���X�^���X�����֎~���܂��B
    */
    private LionTvMastRegisterDAOFactory() {
    }

    /**
     * �X�V�E�폜DAO�C���X�^���X�𐶐����܂��B
     * @return �X�V�E�폜DAO�C���X�^���X
     */
    public static LionTvMastRegisterDAO createTvMastLionRegisterDAO() {
        return (LionTvMastRegisterDAO) DaoFactory.createDao(LionTvMastRegisterDAO.class);
    }
}

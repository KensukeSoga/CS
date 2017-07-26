package jp.co.isid.kkh.customer.lion.model.master;

import jp.co.isid.nj.integ.DaoFactory;


/**
 * <P>
 * �}�X�^�f�[�^�o�^DAO�̃t�@�N�g���N���X
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/02/16 JSE A.Naito)<BR>
 * </P>
 * @author JSE A.Naito
 */
final class LionTvKMastRegisterDAOFactory extends DaoFactory {

    /**
    * �C���X�^���X�����֎~���܂��B
    */
    private LionTvKMastRegisterDAOFactory() {
    }

    /**
     * �X�V�E�폜DAO�C���X�^���X�𐶐����܂��B
     * @return �X�V�E�폜DAO�C���X�^���X
     */
    public static LionTvKMastRegisterDAO createTvKMastLionRegisterDAO() {
        return (LionTvKMastRegisterDAO) DaoFactory.createDao(LionTvKMastRegisterDAO.class);
    }
}

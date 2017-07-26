package jp.co.isid.kkh.customer.lion.model.detail;

import jp.co.isid.nj.integ.DaoFactory;

/**
 * <P>
 * �f�[�^�o�^DAO�̃t�@�N�g���N���X
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/2/9 Fourm A.naito)<BR>
 * </P>
 * @author Fourm A.naito
 */
final class UpdateSubjectDAOFactory extends DaoFactory {

	 /**
	 * �C���X�^���X�����֎~���܂��B
	 */
    private UpdateSubjectDAOFactory() {
    }

    /**
     * �X�VDAO�C���X�^���X�𐶐����܂��B
     * @return �X�V�E�폜DAO�C���X�^���X
     */
    public static UpdateSubjectDAO createUpjissiDAO() {
        return (UpdateSubjectDAO) DaoFactory.createDao(UpdateSubjectDAO.class);
    }
}
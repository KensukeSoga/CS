package jp.co.isid.kkh.customer.acom.model.detail;

import jp.co.isid.nj.integ.DaoFactory;

/**
 * <P>
 * �����f�[�^�o�^DAO�̃t�@�N�g���N���X
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2011/12/22 Fourm H.izawa)<BR>
 * </P>
 * @author Fourm H.izawa
 */
final class FindHatyuConfirmDAOFactory extends DaoFactory {

    /**
    * �C���X�^���X�����֎~���܂��B
    */
    private FindHatyuConfirmDAOFactory() {
    }

    /**
     * �X�VDAO�C���X�^���X�𐶐����܂��B
     * @return �X�V�E�폜DAO�C���X�^���X
     */
    public static FindHatyuConfirmDAO createfinetgr84hikDAO() {
        return (FindHatyuConfirmDAO) DaoFactory.createDao(FindHatyuConfirmDAO.class);
    }

}

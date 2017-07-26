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
final class FindSyouhinNameDAOFactory extends DaoFactory {

    /**
    * �C���X�^���X�����֎~���܂��B
    */
    private FindSyouhinNameDAOFactory() {
    }

    /**
     * �X�VDAO�C���X�^���X�𐶐����܂��B
     * @return �X�V�E�폜DAO�C���X�^���X
     */
    public static FindSyouhinNameGetDAO createfinetgr84hikDAO() {
        return (FindSyouhinNameGetDAO) DaoFactory.createDao(FindSyouhinNameGetDAO.class);
    }

}

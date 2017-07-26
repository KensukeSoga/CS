package jp.co.isid.kkh.customer.tkd.model.detail;

import jp.co.isid.nj.integ.DaoFactory;

/**
 * <P>
 * ���{No�擾DAO�̃t�@�N�g���N���X
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2011/12/7 Fourm H.izawa)<BR>
 * </P>
 * @author Fourm H.izawa
 */
final class FindThb2KmeiBycondDAOFactory extends DaoFactory {

    /**
    * �C���X�^���X�����֎~���܂��B
    */
    private FindThb2KmeiBycondDAOFactory() {
    }

    /**
     * ���{No�擾DAO�C���X�^���X�𐶐����܂��B
     * @return ���{No�擾DAO�C���X�^���X
     */
    public static FindThb2KmeiBycondDAO createFindThb2KmeiBycondDAO() {
        return (FindThb2KmeiBycondDAO) DaoFactory.createDao(FindThb2KmeiBycondDAO.class);
    }
}


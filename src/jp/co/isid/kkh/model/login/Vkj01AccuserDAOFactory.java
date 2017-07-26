package jp.co.isid.kkh.model.login;

import jp.co.isid.nj.integ.DaoFactory;

/**
 * <P>
 * �l���VIEWDAO�̃t�@�N�g���N���X
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/02/13 JSE H.Abe)<BR>
 * </P>
 *
 * @author JSE H.Abe
 */
public class Vkj01AccuserDAOFactory extends DaoFactory {

    /**
     * �C���X�^���X�����֎~���܂��B
     */
    private Vkj01AccuserDAOFactory() {
    }

    /**
     * DAO�C���X�^���X�𐶐����܂��B
     *
     * @return DAO�C���X�^���X
     */
    public static Vkj01AccuserDAO createVkj01AccuserDAO() {
        return (Vkj01AccuserDAO) DaoFactory.createDao(Vkj01AccuserDAO.class);
    }
}

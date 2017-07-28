package jp.co.isid.kkh.model.login;

import jp.co.isid.nj.integ.DaoFactory;

/**
 * <P>
 * �E�ʓ����O���[�v���DAO�̃t�@�N�g���N���X
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/02/13 JSE H.Abe)<BR>
 * </P>
 *
 * @author JSE H.Abe
 */
public class Vkj02TitleClassGroupInfoDAOFactory extends DaoFactory {

    /**
     * �C���X�^���X�����֎~���܂��B
     */
    private Vkj02TitleClassGroupInfoDAOFactory() {
    }

    /**
     * DAO�C���X�^���X�𐶐����܂��B
     *
     * @return DAO�C���X�^���X
     */
    public static Vkj02TitleClassGroupInfoDAO createVkj02TitleClassGroupInfoDAO() {
        return (Vkj02TitleClassGroupInfoDAO) DaoFactory.createDao(Vkj02TitleClassGroupInfoDAO.class);
    }
}

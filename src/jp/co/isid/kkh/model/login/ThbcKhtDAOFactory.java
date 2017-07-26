package jp.co.isid.kkh.model.login;

import jp.co.isid.nj.integ.DaoFactory;

/**
 * <P>
 * �J�����Ӑ�Ǘ����DAO�̃t�@�N�g���N���X
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/02/13 JSE H.Abe)<BR>
 * </P>
 *
 * @author JSE H.Abe
 */
public class ThbcKhtDAOFactory extends DaoFactory {

    /**
     * �C���X�^���X�����֎~���܂��B
     */
    private ThbcKhtDAOFactory() {
    }

    /**
     * DAO�C���X�^���X�𐶐����܂��B
     *
     * @return DAO�C���X�^���X
     */
    public static ThbcKhtDAO createThbcKhtDAO() {
        return (ThbcKhtDAO) DaoFactory.createDao(ThbcKhtDAO.class);
    }
}

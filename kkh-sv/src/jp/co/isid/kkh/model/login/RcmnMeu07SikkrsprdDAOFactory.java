package jp.co.isid.kkh.model.login;

import jp.co.isid.nj.integ.DaoFactory;

/**
 * <P>
 * �o���g�D�W�J���DAO�̃t�@�N�g���N���X
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/02/13 JSE H.Abe)<BR>
 * </P>
 *
 * @author JSE H.Abe
 */
public class RcmnMeu07SikkrsprdDAOFactory extends DaoFactory {

    /**
     * �C���X�^���X�����֎~���܂��B
     */
    private RcmnMeu07SikkrsprdDAOFactory() {
    }

    /**
     * DAO�C���X�^���X�𐶐����܂��B
     *
     * @return DAO�C���X�^���X
     */
    public static RcmnMeu07SikkrsprdDAO createRcmnMeu07SikkrsprdDAO() {
        return (RcmnMeu07SikkrsprdDAO) DaoFactory.createDao(RcmnMeu07SikkrsprdDAO.class);
    }
}

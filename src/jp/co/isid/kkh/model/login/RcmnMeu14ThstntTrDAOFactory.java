package jp.co.isid.kkh.model.login;

import jp.co.isid.nj.integ.DaoFactory;

/**
 * <P>
 * �����S�����DAO�̃t�@�N�g���N���X
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/02/13 JSE H.Abe)<BR>
 * </P>
 *
 * @author JSE H.Abe
 */
public class RcmnMeu14ThstntTrDAOFactory extends DaoFactory {

    /**
     * �C���X�^���X�����֎~���܂��B
     */
    private RcmnMeu14ThstntTrDAOFactory() {
    }

    /**
     * DAO�C���X�^���X�𐶐����܂��B
     *
     * @return DAO�C���X�^���X
     */
    public static RcmnMeu14ThstntTrDAO createRcmnMeu14ThstntTrDAO() {
        return (RcmnMeu14ThstntTrDAO) DaoFactory.createDao(RcmnMeu14ThstntTrDAO.class);
    }
}

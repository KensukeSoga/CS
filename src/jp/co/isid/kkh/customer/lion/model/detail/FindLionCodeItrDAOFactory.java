package jp.co.isid.kkh.customer.lion.model.detail;

import jp.co.isid.nj.integ.DaoFactory;


/**
 * <P>
 * �ėp�}�X�^����DAO�̃t�@�N�g���N���X
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/02/27 JSE A.Naito)<BR>
 * </P>
 * @author JSE A.Naito
 */
public class FindLionCodeItrDAOFactory extends DaoFactory {

    /**
    * �C���X�^���X�����֎~���܂��B
    */
    private FindLionCodeItrDAOFactory() {
    }

    /**
    * DAO�C���X�^���X�𐶐����܂��B
    * @return DAO�C���X�^���X
    */
    public static FindLionCodeItrDAO createFindLionCodeItrDAO() {
        return (FindLionCodeItrDAO) DaoFactory.createDao(FindLionCodeItrDAO.class);
    }
}

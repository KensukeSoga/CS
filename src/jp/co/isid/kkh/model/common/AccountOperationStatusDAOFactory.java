package jp.co.isid.kkh.model.common;

import jp.co.isid.nj.integ.DaoFactory;


/**
 * <P>
 * �Ɩ���v�ғ���DAO�̃t�@�N�g���N���X
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/02/09 JSE H.Abe)<BR>
 * </P>
 * @author
 */
public class AccountOperationStatusDAOFactory extends DaoFactory {

    /**
    * �C���X�^���X�����֎~���܂��B
    */
    private AccountOperationStatusDAOFactory() {
    }

    /**
    * DAO�C���X�^���X�𐶐����܂��B
    * @return DAO�C���X�^���X
    */
    public static AccountOperationStatusDAO createAccountOperationStatusDAO() {
        return (AccountOperationStatusDAO) DaoFactory.createDao(AccountOperationStatusDAO.class);
    }
}

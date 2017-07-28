package jp.co.isid.kkh.customer.lion.model.master;

import jp.co.isid.nj.integ.DaoFactory;


/**
 * <P>
 * �ėp�}�X�^����DAO�̃t�@�N�g���N���X
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/02/20 JSE A.Naito)<BR>
 * </P>
 * @author JSE A.Naito
 */
public class FindRdKMastDAOFactory extends DaoFactory {

    /**
    * �C���X�^���X�����֎~���܂��B
    */
    private FindRdKMastDAOFactory() {
    }

    /**
    * DAO�C���X�^���X�𐶐����܂��B
    * @return DAO�C���X�^���X
    */
    public static FindRdKMastDAO createFindRdKMastDAO() {
        return (FindRdKMastDAO) DaoFactory.createDao(FindRdKMastDAO.class);
    }
}

package jp.co.isid.kkh.customer.lion.model.detail;

import jp.co.isid.nj.integ.DaoFactory;


/**
 * <P>
 * �ėp�}�X�^����DAO�̃t�@�N�g���N���X
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/02/17 JSE A.Naito)<BR>
 * </P>
 * @author
 */
public class FindLionCardNoGetDAOFactory extends DaoFactory {

    /**
    * �C���X�^���X�����֎~���܂��B
    */
    private FindLionCardNoGetDAOFactory() {
    }

    /**
    * DAO�C���X�^���X�𐶐����܂��B
    * @return DAO�C���X�^���X
    */
    public static FindLionCardNoGetDAO createFindLionCardNoGetDAO() {
        return (FindLionCardNoGetDAO) DaoFactory.createDao(FindLionCardNoGetDAO.class);
    }
}

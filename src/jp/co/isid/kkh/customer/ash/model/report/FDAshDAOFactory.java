package jp.co.isid.kkh.customer.ash.model.report;

import jp.co.isid.nj.integ.DaoFactory;

/**
 * <P>
 *�����f�[�^�ꗗ����DAO�̃t�@�N�g���N���X
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * </P>
 * @author
 */
public class FDAshDAOFactory extends DaoFactory {

    /**
    * �C���X�^���X�����֎~���܂��B
    */
    private FDAshDAOFactory() {
    }

    /**
    * DAO�C���X�^���X�𐶐����܂��B
    * @return DAO�C���X�^���X
    */
    public static FDAshDAO createFDAshDAO() {
        return (FDAshDAO) DaoFactory.createDao(FDAshDAO.class);
    }

}

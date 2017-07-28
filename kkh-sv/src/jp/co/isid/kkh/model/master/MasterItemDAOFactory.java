package jp.co.isid.kkh.model.master;

import jp.co.isid.nj.integ.DaoFactory;


/**
 * <P>
 * �ėp�}�X�^����DAO�̃t�@�N�g���N���X
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/2/3 Fourm H.izawa)<BR>
 * </P>
 * @author
 */
public class MasterItemDAOFactory extends DaoFactory {

    /**
    * �C���X�^���X�����֎~���܂��B
    */
    private MasterItemDAOFactory() {
    }

    /**
    * DAO�C���X�^���X�𐶐����܂��B
    * @return DAO�C���X�^���X
    */
    public static MasterItemDAO createMasterItemDAO() {
        return (MasterItemDAO) DaoFactory.createDao(MasterItemDAO.class);
    }
}

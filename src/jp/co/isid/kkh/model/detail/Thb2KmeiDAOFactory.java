package jp.co.isid.kkh.model.detail;

import jp.co.isid.nj.integ.DaoFactory;


/**
 * <P>
 * �ėp�}�X�^����DAO�̃t�@�N�g���N���X
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2011/11/07 JSE K.Fukuda)<BR>
 * </P>
 * @author
 */
public class Thb2KmeiDAOFactory extends DaoFactory {

    /**
    * �C���X�^���X�����֎~���܂��B
    */
    private Thb2KmeiDAOFactory() {
    }

    /**
    * DAO�C���X�^���X�𐶐����܂��B
    * @return DAO�C���X�^���X
    */
    public static Thb2KmeiDAO createThb2KmeiDAO() {
        return (Thb2KmeiDAO) DaoFactory.createDao(Thb2KmeiDAO.class);
    }

}

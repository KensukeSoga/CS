package jp.co.isid.kkh.customer.epson.model.detail;

import jp.co.isid.nj.integ.DaoFactory;


/**
 * <P>
 * �ėp�}�X�^����DAO�̃t�@�N�g���N���X
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/3/5 IP.Shimizu)<BR>
 * </P>
 * @author
 */
public class DetailDataEpsonDAOFactory extends DaoFactory {

    /**
    * �C���X�^���X�����֎~���܂��B
    */
    private DetailDataEpsonDAOFactory() {
    }

    /**
    * DAO�C���X�^���X�𐶐����܂��B
    * @return DAO�C���X�^���X
    */
    public static DetailDataEpsonDAO createDetailDataDAO() {
        return (DetailDataEpsonDAO) DaoFactory.createDao(DetailDataEpsonDAO.class);
    }
}

package jp.co.isid.kkh.customer.epson.model.detail;

import jp.co.isid.nj.integ.DaoFactory;


/**
 * <P>
 * ��������f�[�^����DAO�̃t�@�N�g���N���X
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/04/25 JSE.Yuguchi)<BR>
 * </P>
 * @author
 */
public class SeikyuDataEpsonDAOFactory extends DaoFactory {

    /**
    * �C���X�^���X�����֎~���܂��B
    */
    private SeikyuDataEpsonDAOFactory() {
    }

    /**
    * DAO�C���X�^���X�𐶐����܂��B
    * @return DAO�C���X�^���X
    */
    public static SeikyuDataEpsonDAO createSeikyuDataDAO() {
        return (SeikyuDataEpsonDAO) DaoFactory.createDao(SeikyuDataEpsonDAO.class);
    }
}

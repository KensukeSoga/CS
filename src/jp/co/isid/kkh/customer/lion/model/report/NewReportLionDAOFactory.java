package jp.co.isid.kkh.customer.lion.model.report;

import jp.co.isid.nj.integ.DaoFactory;


/**
 * <P>
 *�L����ꗗ����DAO�̃t�@�N�g���N���X
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/3/06 fourm h.izawa)<BR>
 * </P>
 * @author
 */
public class NewReportLionDAOFactory extends DaoFactory {

    /**
    * �C���X�^���X�����֎~���܂��B
    */
    private NewReportLionDAOFactory() {
    }

    /**
    * DAO�C���X�^���X�𐶐����܂��B
    * @return DAO�C���X�^���X
    */
    public static NewReportLionDAO createReportAshKoukokuHiDAO() {
        return (NewReportLionDAO) DaoFactory.createDao(NewReportLionDAO.class);
    }
}

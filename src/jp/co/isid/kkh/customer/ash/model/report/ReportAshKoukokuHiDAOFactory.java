package jp.co.isid.kkh.customer.ash.model.report;

import jp.co.isid.nj.integ.DaoFactory;


/**
 * <P>
 *�L����ꗗ����DAO�̃t�@�N�g���N���X
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/2/13 fourm h.izawa)<BR>
 * </P>
 * @author
 */
public class ReportAshKoukokuHiDAOFactory extends DaoFactory {

    /**
    * �C���X�^���X�����֎~���܂��B
    */
    private ReportAshKoukokuHiDAOFactory() {
    }

    /**
    * DAO�C���X�^���X�𐶐����܂��B
    * @return DAO�C���X�^���X
    */
    public static ReportAshKoukokuHiDAO createReportAshKoukokuHiDAO() {
        return (ReportAshKoukokuHiDAO) DaoFactory.createDao(ReportAshKoukokuHiDAO.class);
    }
}

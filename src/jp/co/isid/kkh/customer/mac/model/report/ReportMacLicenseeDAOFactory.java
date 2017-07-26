package jp.co.isid.kkh.customer.mac.model.report;

import jp.co.isid.nj.integ.DaoFactory;


/**
 * <P>
 * �ėp�}�X�^����DAO�̃t�@�N�g���N���X
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2011/1/12 fourm h.izawa)<BR>
 * </P>
 * @author
 */
public class ReportMacLicenseeDAOFactory extends DaoFactory {

    /**
    * �C���X�^���X�����֎~���܂��B
    */
    private ReportMacLicenseeDAOFactory() {
    }

    /**
    * DAO�C���X�^���X�𐶐����܂��B
    * @return DAO�C���X�^���X
    */
    public static ReportMacLicenseeDAO createReportMacLicenseeDAO() {
        return (ReportMacLicenseeDAO) DaoFactory.createDao(ReportMacLicenseeDAO.class);
    }
}

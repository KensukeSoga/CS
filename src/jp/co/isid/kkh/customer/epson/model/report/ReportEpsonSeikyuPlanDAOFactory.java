package jp.co.isid.kkh.customer.epson.model.report;

import jp.co.isid.nj.integ.DaoFactory;

/**
 * <P>
 * �����\��ꗗ�i�G�v�\��)����DAO�̃t�@�N�g���N���X
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/3/9 IP JK)<BR>
 * </P>
 * @author
 */
public class ReportEpsonSeikyuPlanDAOFactory extends DaoFactory {

    /**
    * �C���X�^���X�����֎~���܂��B
    */
    private ReportEpsonSeikyuPlanDAOFactory() {
    }

    /**
    * DAO�C���X�^���X�𐶐����܂��B
    * @return DAO�C���X�^���X
    */
    public static ReportEpsonSeikyuPlanDAO createReportEpsonSeikyuPlanDAO() {
        return (ReportEpsonSeikyuPlanDAO) DaoFactory.createDao(ReportEpsonSeikyuPlanDAO.class);
    }
}

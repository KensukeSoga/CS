package jp.co.isid.kkh.customer.ash.model.report;

import jp.co.isid.nj.integ.DaoFactory;


/**
 * <P>
 *�}�̕ʈꗗ����DAO�̃t�@�N�g���N���X
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2011/1/23 fourm h.izawa)<BR>
 * </P>
 * @author
 */
public class ReportAshMediaCodeDAOFactory extends DaoFactory {

    /**
    * �C���X�^���X�����֎~���܂��B
    */
    private ReportAshMediaCodeDAOFactory() {
    }

    /**
    * DAO�C���X�^���X�𐶐����܂��B
    * @return DAO�C���X�^���X
    */
    public static ReportAshMediaCodeDAO createReportAshMediaCodeDAO() {
        return (ReportAshMediaCodeDAO) DaoFactory.createDao(ReportAshMediaCodeDAO.class);
    }
}

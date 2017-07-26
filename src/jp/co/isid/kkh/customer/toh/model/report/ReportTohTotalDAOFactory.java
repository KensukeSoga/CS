package jp.co.isid.kkh.customer.toh.model.report;

import jp.co.isid.nj.integ.DaoFactory;


/**
 * <P>
 * �ėp�}�X�^����DAO�̃t�@�N�g���N���X
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/02/22 JSE T.Kobayashi)<BR>
 * </P>
 * @author
 */
public class ReportTohTotalDAOFactory extends DaoFactory {

    /**
    * �C���X�^���X�����֎~���܂��B
    */
    private ReportTohTotalDAOFactory() {
    }

    /**
    * DAO�C���X�^���X�𐶐����܂��B
    * @return DAO�C���X�^���X
    */
    public static ReportTohTotalDAO createReportTohTotalDAO() {
        return (ReportTohTotalDAO) DaoFactory.createDao(ReportTohTotalDAO.class);
    }
}

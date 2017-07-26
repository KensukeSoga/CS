package jp.co.isid.kkh.customer.acom.model.report;

import jp.co.isid.kkh.customer.acom.model.report.ReportAcomDAO;
import jp.co.isid.nj.integ.DaoFactory;

/**
 * <P>
 * �ėp�}�X�^����DAO�̃t�@�N�g���N���X
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/01/11)<BR>
 * </P>
 * @author
 */

public class ReportAcomDAOFactory extends DaoFactory{
    /**
	    * �C���X�^���X�����֎~���܂��B
	    */
	    private ReportAcomDAOFactory() {
	    }

	    /**
	    * DAO�C���X�^���X�𐶐����܂��B
	    * @return DAO�C���X�^���X
	    */
	    public static ReportAcomDAO createReportAcomDAO() {
	        return (ReportAcomDAO) DaoFactory.createDao(ReportAcomDAO.class);
	    }

}

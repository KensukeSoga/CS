package jp.co.isid.kkh.customer.acom.model.report;

import jp.co.isid.kkh.customer.acom.model.report.ReportAcomDAO;
import jp.co.isid.nj.integ.DaoFactory;

/**
 * <P>
 * 汎用マスタ検索DAOのファクトリクラス
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/01/11)<BR>
 * </P>
 * @author
 */

public class ReportAcomDAOFactory extends DaoFactory{
    /**
	    * インスタンス化を禁止します。
	    */
	    private ReportAcomDAOFactory() {
	    }

	    /**
	    * DAOインスタンスを生成します。
	    * @return DAOインスタンス
	    */
	    public static ReportAcomDAO createReportAcomDAO() {
	        return (ReportAcomDAO) DaoFactory.createDao(ReportAcomDAO.class);
	    }

}

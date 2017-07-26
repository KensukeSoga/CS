package jp.co.isid.kkh.customer.tkd.model.report;

import jp.co.isid.nj.integ.DaoFactory;

/**
 * <P>
 * 武田請求明細（品目別）取得DAOファクトリー
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/01/23 JSE Hitoshi Sasaki)<BR>
 * </P>
 * 
 * @author JSE Hitoshi Sasaki
 */
public class ReportTkdBillingByItemDAOFactory extends DaoFactory {

	/**
	 * インスタンス化を禁止します。
	 */
	private ReportTkdBillingByItemDAOFactory() {
	}

	/**
	 * DAOインスタンスを生成します。
	 * 
	 * @return DAOインスタンス
	 */
	public static ReportTkdBillingByItemDAO createDAO() {
		return (ReportTkdBillingByItemDAO) DaoFactory.createDao(ReportTkdBillingByItemDAO.class);
	}
}

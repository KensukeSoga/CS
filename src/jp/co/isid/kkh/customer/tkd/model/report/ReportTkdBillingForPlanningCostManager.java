package jp.co.isid.kkh.customer.tkd.model.report;

import java.util.List;
import jp.co.isid.kkh.model.base.KKHException;

/**
 * <P>
 * 武田請求明細（企画費）取得マネージャー
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/01/23 JSE Hitoshi Sasaki)<BR>
 * </P>
 *
 * @author JSE Hitoshi Sasaki
 */
public class ReportTkdBillingForPlanningCostManager {

	/** シングルトンインスタンス */
	private static ReportTkdBillingForPlanningCostManager _manager = new ReportTkdBillingForPlanningCostManager();

	/**
	 * シングルトンの為、インスタンス化を禁止します。
	 */
	private ReportTkdBillingForPlanningCostManager() {
	}

	/**
	 * インスタンスを返します。
	 *
	 * @return インスタンス
	 */
	public static ReportTkdBillingForPlanningCostManager getInstance() {
		return _manager;
	}

	/**
	 * 帳票データ(TOH)を検索します。
	 *
	 * @return ReportTohResult 汎用マスタ検索データ
	 * @throws KKHException
	 *             処理中にエラーが発生した場合
	 */
	public ReportTkdBillingForPlanningCostResult findByCondition(ReportTkdBillingForPlanningCostCondition cond) throws KKHException {
		// 検索結果
		ReportTkdBillingForPlanningCostResult result = new ReportTkdBillingForPlanningCostResult();

		// ******************************************************
		// 広告費明細データを取得
		// ******************************************************
		ReportTkdBillingForPlanningCostDAO dao = ReportTkdBillingForPlanningCostDAOFactory.createDAO();

		List<ReportTkdBillingForPlanningCostVO> list = dao.findReportTkdBillingByCondition(cond);

		result.setReportTkdBilling(list);

		return result;
	}
}

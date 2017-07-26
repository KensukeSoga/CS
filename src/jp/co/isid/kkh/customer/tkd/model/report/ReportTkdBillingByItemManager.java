package jp.co.isid.kkh.customer.tkd.model.report;

import java.util.List;
import jp.co.isid.kkh.model.base.KKHException;

/**
 * <P>
 * 武田請求明細（品目別）取得マネージャー
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/01/23 JSE Hitoshi Sasaki)<BR>
 * </P>
 *
 * @author JSE Hitoshi Sasaki
 */
public class ReportTkdBillingByItemManager {

	/** シングルトンインスタンス */
	private static ReportTkdBillingByItemManager _manager = new ReportTkdBillingByItemManager();

	/**
	 * シングルトンの為、インスタンス化を禁止します。
	 */
	private ReportTkdBillingByItemManager() {
	}

	/**
	 * インスタンスを返します。
	 *
	 * @return インスタンス
	 */
	public static ReportTkdBillingByItemManager getInstance() {
		return _manager;
	}

	/**
	 * 帳票データ(TKD)を検索します。
	 *
	 * @return ReportTkdBillingByItemResult 汎用マスタ検索データ
	 * @throws KKHException
	 *             処理中にエラーが発生した場合
	 */
	public ReportTkdBillingByItemResult findByCondition(ReportTkdBillingByItemCondition cond) throws KKHException {
		// 検索結果
		ReportTkdBillingByItemResult result = new ReportTkdBillingByItemResult();

		// ******************************************************
		// 広告費明細データを取得
		// ******************************************************
		ReportTkdBillingByItemDAO dao = ReportTkdBillingByItemDAOFactory.createDAO();

		List<ReportTkdBillingByItemVO> list = dao.findReportTkdBillingByCondition(cond);

		result.setReportTkdBilling(list);

		return result;

	}
}

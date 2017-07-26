package jp.co.isid.kkh.customer.tkd.model.report;

import java.util.List;

import jp.co.isid.kkh.model.base.KKHException;

/**
 * <P>
 * 武田請求明細（中分類別）取得マネージャー
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/01/23 JSE Hitoshi Sasaki)<BR>
 * </P>
 *
 * @author JSE Hitoshi Sasaki
 */
public class ReportTkdBillingByMiddleClassificationManager {

	/** シングルトンインスタンス */
	private static ReportTkdBillingByMiddleClassificationManager _manager = new ReportTkdBillingByMiddleClassificationManager();

	/**
	 * シングルトンの為、インスタンス化を禁止します。
	 */
	private ReportTkdBillingByMiddleClassificationManager() {
	}

	/**
	 * インスタンスを返します。
	 *
	 * @return インスタンス
	 */
	public static ReportTkdBillingByMiddleClassificationManager getInstance() {
		return _manager;
	}

	/**
	 * 帳票データ(TKD)を検索します。
	 *
	 * @return ReportTkdBillingByMiddleClassificationResult 汎用マスタ検索データ
	 * @throws KKHException
	 *             処理中にエラーが発生した場合
	 */
	public ReportTkdBillingByMiddleClassificationResult findByCondition(ReportTkdBillingByMiddleClassificationCondition cond) throws KKHException {
		// 検索結果
		ReportTkdBillingByMiddleClassificationResult result = new ReportTkdBillingByMiddleClassificationResult();

		// ******************************************************
		// 広告費明細データを取得
		// ******************************************************
		ReportTkdBillingByMiddleClassificationDAO dao = ReportTkdBillingByMiddleClassificationDAOFactory.createDAO();

		List<ReportTkdBillingByMiddleClassificationVO> list = dao.findReportTkdBillingByCondition(cond);

		result.setReportTkdBilling(list);

		return result;
	}
}

package jp.co.isid.kkh.customer.lion.model.report;

import java.util.List;

import jp.co.isid.kkh.model.base.KKHException;

/**
 * <P>
 * ライオンFD出力データ取得マネージャー
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/01/23 JSE Hitoshi Sasaki)<BR>
 * </P>
 *
 * @author JSE Hitoshi Sasaki
 */
public class FDLionManager {

	/** シングルトンインスタンス */
	private static FDLionManager _manager = new FDLionManager();

	/**
	 * シングルトンの為、インスタンス化を禁止します。
	 */
	private FDLionManager() {
	}

	/**
	 * インスタンスを返します。
	 *
	 * @return インスタンス
	 */
	public static FDLionManager getInstance() {
		return _manager;
	}

	/**
	 * ライオンFD出力データを検索します。
	 *
	 * @return FDLionResult ライオンFD出力データ取得結果
	 * @throws KKHException
	 *             処理中にエラーが発生した場合
	 */
	public FDLionResult findByCondition(FDLionCondition cond) throws KKHException {

		FDLionResult result = new FDLionResult();

		FDLionDAO dao = FDLionDAOFactory.createDAO();

		List<FDLionVO> list = dao.findFDLionByCondition(cond);

		result.setFDLion(list);

		return result;
	}
}

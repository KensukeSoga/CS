package jp.co.isid.kkh.customer.tkd.model.detail;

import java.util.List;

import jp.co.isid.kkh.model.base.KKHException;

public class FindJissiNoCntByCondManager {

	/** シングルトンインスタンス */
	private static FindJissiNoCntByCondManager _manager = new FindJissiNoCntByCondManager();

	/**
	 * シングルトンの為、インスタンス化を禁止します。
	 */
	private FindJissiNoCntByCondManager() {
	}

	/**
	 * インスタンスを返します。
	 *
	 * @return インスタンス
	 */
	public static FindJissiNoCntByCondManager getInstance() {
		return _manager;
	}

	/**
	 * 使用済実施Noの件数を検索します。
	 *
	 * @return FindJissiNoCntByCondResult 使用済実施Noの件数
	 * @throws KKHException
	 *             処理中にエラーが発生した場合
	 */
	public FindJissiNoCntByCondResult findJissiNoCntByCondition(
			FindJissiNoCntCondition cond) throws KKHException {

		// パラメータの必須チェック
		if (cond.getEsqId() == null || cond.getEsqId().equals("")) {
			throw new KKHException("パラメータ指定エラー", "BD-E0001");
		}
		if (cond.getEgCd() == null || cond.getEgCd().equals("")) {
			throw new KKHException("パラメータ指定エラー", "BD-E0001");
		}
		if (cond.getTksKgyCd() == null || cond.getTksKgyCd().equals("")) {
			throw new KKHException("パラメータ指定エラー", "BD-E0001");
		}
		if (cond.getTksBmnSeqNo() == null || cond.getTksBmnSeqNo().equals("")) {
			throw new KKHException("パラメータ指定エラー", "BD-E0001");
		}
		if (cond.getTksTntSeqNo() == null || cond.getTksTntSeqNo().equals("")) {
			throw new KKHException("パラメータ指定エラー", "BD-E0001");
		}
		if (cond.getYm() == null || cond.getYm().equals("")) {
			throw new KKHException("パラメータ指定エラー", "BD-E0001");
		}
		if (cond.getJyutNo() == null || cond.getJyutNo().equals("")) {
			throw new KKHException("パラメータ指定エラー", "BD-E0001");
		}
		if (cond.getJyMeiNo() == null || cond.getJyMeiNo().equals("")) {
			throw new KKHException("パラメータ指定エラー", "BD-E0001");
		}
		if (cond.getUrMeiNo() == null || cond.getUrMeiNo().equals("")) {
			throw new KKHException("パラメータ指定エラー", "BD-E0001");
		}

		// 検索結果
		FindJissiNoCntByCondResult result = new FindJissiNoCntByCondResult();

		// 検索条件
		FindJissiNoCntCondition lCond = new FindJissiNoCntCondition();

		// ******************************************************
		// 使用済実施Noの件数を取得
		// ******************************************************
		FindJissiNoCntByCondDAO dao = FindJissiNoCntByCondDAOFactory.createFindJissiNoCntByCondDAO();

		// ******************************************************
		// マスタ種類設定を取得
		// ******************************************************
		lCond = cond;
		List<FindJissiNoCntCondVO> list = dao.findJissiNoCntByCondition(lCond);
		FindJissiNoCntCondVO vo = list.get(0);

		result.setJissiNoCnt(vo.getKngk1());

		return result;
	}

}

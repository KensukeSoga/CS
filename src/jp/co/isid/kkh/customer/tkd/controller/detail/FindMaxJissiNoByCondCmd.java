package jp.co.isid.kkh.customer.tkd.controller.detail;

import jp.co.isid.kkh.model.base.KKHException;

import jp.co.isid.kkh.customer.tkd.model.detail.FindMaxJissiNoByCondManager;
import jp.co.isid.kkh.customer.tkd.model.detail.FindMaxJissiNoByCondResult;
import jp.co.isid.kkh.customer.tkd.model.detail.FindMaxJissiNoCondition;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * 実施Noの最大値検索コマンド
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2011/12/09 JSE Y.Sato)<BR>
 * </P>
 *
 * @author JSE Y.Sato
 */
public class FindMaxJissiNoByCondCmd extends Command {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/** 検索結果キー */
	private static final String RESULT_KEY = "RESULT_KEY";

	/** 検索条件 */
	private FindMaxJissiNoCondition _condition;

	/**
	 * 検索条件を使用し、 実施Noの最大値検索処理を実行します。
	 *
	 * @throws KKHException
	 *             検索に失敗した場合
	 */
	public void execute() throws KKHException {
		FindMaxJissiNoByCondManager manager = FindMaxJissiNoByCondManager.getInstance();
		FindMaxJissiNoByCondResult result = manager.findMaxjissiNoByCondition(_condition);
		getResult().set(RESULT_KEY, result);
	}

	/**
	 *  検索条件を設定します。
	 *
	 * @param condition
	 *            FindMaxJissiNoCondition 検索条件
	 */
	public void setFindMaxJissiNoCondition(FindMaxJissiNoCondition condition) {
		_condition = condition;
	}

	/**
	 * 実施Noの最大値検索結果を返します。
	 *
	 * @return FindMaxJissiNoByCondResult 条件検索結果
	 */
	public FindMaxJissiNoByCondResult getFindByCondResult() {
		return (FindMaxJissiNoByCondResult) super.getResult().get(RESULT_KEY);
	}
}

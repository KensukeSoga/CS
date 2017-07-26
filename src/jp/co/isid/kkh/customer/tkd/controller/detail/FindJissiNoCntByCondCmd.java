package jp.co.isid.kkh.customer.tkd.controller.detail;

import jp.co.isid.kkh.model.base.KKHException;

import jp.co.isid.kkh.customer.tkd.model.detail.FindJissiNoCntByCondManager;
import jp.co.isid.kkh.customer.tkd.model.detail.FindJissiNoCntByCondResult;
import jp.co.isid.kkh.customer.tkd.model.detail.FindJissiNoCntCondition;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * 使用済実施Noの件数検索コマンド
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2011/12/13 JSE Y.Sato)<BR>
 * </P>
 *
 * @author JSE Y.Sato
 */
public class FindJissiNoCntByCondCmd extends Command {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/** 検索結果キー */
	private static final String RESULT_KEY = "RESULT_KEY";

	/** 検索条件 */
	private FindJissiNoCntCondition _condition;

	/**
	 * 検索条件を使用し、 使用済実施Noの件数検索処理を実行します。
	 *
	 * @throws KKHException
	 *             検索に失敗した場合
	 */
	public void execute() throws KKHException {
		FindJissiNoCntByCondManager manager = FindJissiNoCntByCondManager.getInstance();
		FindJissiNoCntByCondResult result = manager.findJissiNoCntByCondition(_condition);
		getResult().set(RESULT_KEY, result);
	}

	/**
	 *  検索条件を設定します。
	 *
	 * @param condition
	 *            FindJissiNoCntCondition 検索条件
	 */
	public void setFindJissiNoCntCondition(FindJissiNoCntCondition condition) {
		_condition = condition;
	}

	/**
	 * 使用済実施Noの件数検索結果を返します。
	 *
	 * @return FindJissiNoCntByCondResult 条件検索結果
	 */
	public FindJissiNoCntByCondResult getFindByCondResult() {
		return (FindJissiNoCntByCondResult) super.getResult().get(RESULT_KEY);
	}
}

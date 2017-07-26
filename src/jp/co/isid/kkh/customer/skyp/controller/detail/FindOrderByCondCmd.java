package jp.co.isid.kkh.customer.skyp.controller.detail;

import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.customer.skyp.model.detail.FindOrderByCondManager;
import jp.co.isid.kkh.customer.skyp.model.detail.FindOrderByCondResult;
import jp.co.isid.kkh.customer.skyp.model.detail.FindOrderCondition;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * 並び順情報検索コマンド
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2011/12/21 JSE Y.Sato)<BR>
 * </P>
 *
 * @author JSE Y.Sato
 */
public class FindOrderByCondCmd extends Command {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /** 検索結果キー */
    private static final String RESULT_KEY = "RESULT_KEY";

    /** 検索条件 */
    private FindOrderCondition _condition;

    /**
     * 検索条件を使用し、 並び順情報検索処理を実行します。
     *
     * @throws KKHException
     *             検索に失敗した場合
     */
    public void execute() throws KKHException {
        FindOrderByCondManager manager = FindOrderByCondManager.getInstance();
        FindOrderByCondResult result = manager.findOrderByCondition(_condition);
        getResult().set(RESULT_KEY, result);
    }

    /**
     * 検索条件を設定します。
     *
     * @param condition
     *            FindOrderCondition 検索条件
     */
    public void setFindOrderCondition(FindOrderCondition condition) {
        _condition = condition;
    }

    /**
     * 並び順情報検索結果を返します。
     *
     * @return FindOrderByCondResult 条件検索結果
     */
    public FindOrderByCondResult getFindByCondResult() {
        return (FindOrderByCondResult) super.getResult().get(RESULT_KEY);
    }
}

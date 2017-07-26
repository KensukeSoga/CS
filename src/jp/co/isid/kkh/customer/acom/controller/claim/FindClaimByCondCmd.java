package jp.co.isid.kkh.customer.acom.controller.claim;

import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.customer.acom.model.claim.FindClaimByCondManager;
import jp.co.isid.kkh.customer.acom.model.claim.FindClaimByCondResult;
import jp.co.isid.kkh.customer.acom.model.claim.FindClaimCondition;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * 請求データ一覧情報検索コマンド
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/2/7 JSE Y.Sato)<BR>
 * </P>
 *
 * @author JSE Y.Sato
 */
public class FindClaimByCondCmd extends Command {

    /** */
    private static final long serialVersionUID = 1L;

    /** 検索結果キー */
    private static final String RESULT_KEY = "RESULT_KEY";

    /** 検索条件 */
    private FindClaimCondition _condition;

    /**
     * 検索条件を使用し、 発注/請求番号 一覧情報検索処理を実行します。
     *
     * @throws KKHException
     *             検索に失敗した場合
     */
    public void execute() throws KKHException {
        FindClaimByCondManager manager = FindClaimByCondManager.getInstance();
        FindClaimByCondResult result = manager.findClaimByCondition(_condition);
        getResult().set(RESULT_KEY, result);
    }

    /**
     * 検索条件を設定します。
     *
     * @param condition
     *            FindClaimCondition 検索条件
     */
    public void setFindClaimCondition(FindClaimCondition condition) {
        _condition = condition;
    }

    /**
     * 請求データ一覧情報検索結果を返します。
     *
     * @return FindClaimByCondResult 条件検索結果
     */
    public FindClaimByCondResult getFindClaimByCondResult() {
        return (FindClaimByCondResult) super.getResult().get(RESULT_KEY);
    }
}

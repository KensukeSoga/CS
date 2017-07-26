package jp.co.isid.kkh.customer.lion.controller.detail;

import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.customer.lion.model.detail.FindLionCardNoItrCondition;
import jp.co.isid.kkh.customer.lion.model.detail.FindLionCardNoItrManager;
import jp.co.isid.kkh.customer.lion.model.detail.FindLionCardNoItrResult;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * FindRdKMast検索コマンド
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/02/21 JSE A.Naito)<BR>
 * </P>
 * @author  JSE A.Naito
 */
public class FindLionCardNoItrCmd extends Command {

    private static final long serialVersionUID = 1L;

    /** 検索結果キー */
    private static final String RESULT_KEY = "RESULT_KEY";

    /** 検索条件 */
    private FindLionCardNoItrCondition _condition;

    /**
     * 検索条件を使用し、検索処理を実行します。
     * @throws KKHException 検索に失敗した場合
     */
    public void execute() throws KKHException {
        FindLionCardNoItrManager manager = FindLionCardNoItrManager.getInstance();
        FindLionCardNoItrResult result = manager.findLionCardNoItrByCondition(_condition);
        getResult().set(RESULT_KEY, result);
    }

    /**
     * 検索条件を設定します。
     *
     * @param condition CommonCodeMasterSearchCondition 検索条件
     */
    public void setFindLionCardNoItrCondition(FindLionCardNoItrCondition condition) {
        _condition = condition;
    }

    /**
     * 条件検索結果を返します。
     *
     * @return FindRdKMastResult 条件検索結果
     */
    public FindLionCardNoItrResult getFindLionCardNoItrResult() {
        return (FindLionCardNoItrResult) super.getResult().get(RESULT_KEY);
    }

}

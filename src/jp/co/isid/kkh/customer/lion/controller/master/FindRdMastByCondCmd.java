package jp.co.isid.kkh.customer.lion.controller.master;

import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.customer.lion.model.master.FindRdMastCondition;
import jp.co.isid.kkh.customer.lion.model.master.FindRdMastResult;
import jp.co.isid.kkh.customer.lion.model.master.LionManager;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * FindRdMast検索コマンド
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/02/17 JSE A.Naito)<BR>
 * </P>
 * @author JSE A.Naito
 */
public class FindRdMastByCondCmd extends Command {

    private static final long serialVersionUID = 1L;

    /** 検索結果キー */
    private static final String RESULT_KEY = "RESULT_KEY";

    /** 検索条件 */
    private FindRdMastCondition _condition;

    /**
     * 検索条件を使用し、検索処理を実行します。
     * @throws KKHException 検索に失敗した場合
     */
    public void execute() throws KKHException {
        LionManager manager = LionManager.getInstance();
        FindRdMastResult result = manager.findRdMastByCondition(_condition);
        getResult().set(RESULT_KEY, result);
    }

    /**
     * 検索条件を設定します。
     *
     * @param condition CommonCodeMasterSearchCondition 検索条件
     */
    public void setFindRdMastCondition(FindRdMastCondition condition) {
        _condition = condition;
    }

    /**
     * 条件検索結果を返します。
     *
     * @return FindTvMastResult 条件検索結果
     */
    public FindRdMastResult getFindRdMastResult() {
        return (FindRdMastResult) super.getResult().get(RESULT_KEY);
    }

}

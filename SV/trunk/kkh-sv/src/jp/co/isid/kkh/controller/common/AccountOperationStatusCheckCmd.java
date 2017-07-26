package jp.co.isid.kkh.controller.common;

import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.model.common.AccountOperationStatusCondition;
import jp.co.isid.kkh.model.common.AccountOperationStatusManager;
import jp.co.isid.kkh.model.common.AccountOperationStatusResult;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * 業務会計稼働状況チェックコマンド
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/02/09 JSE H.Abe)<BR>
 * </P>
 *
 * @author
 */
public class AccountOperationStatusCheckCmd extends Command {

    private static final long serialVersionUID = 1L;

    /** 検索結果キー */
    private static final String RESULT_KEY = "RESULT_KEY";

    /** 検索条件 */
    private AccountOperationStatusCondition _condition;

    /**
     * 業務会計稼働状況チェックを実行します。
     *
     * @throws KKHException 処理中にエラーが発生した場合
     */
    public void execute() throws KKHException {
        AccountOperationStatusResult result = new AccountOperationStatusResult();
        AccountOperationStatusManager manager = AccountOperationStatusManager.getInstance();
        boolean managerResult = manager.checkAccountOperationStatus(_condition);
        result.setAccountOperationStatus(managerResult);
        getResult().set(RESULT_KEY, result);
    }

    /**
     * 検索条件を設定します。
     *
     * @param condition 検索条件
     */
    public void setAccountOperationStatusCondition(AccountOperationStatusCondition condition) {
        _condition = condition;
    }

    /**
     * 実行結果を返します。
     *
     * @return 実行結果
     */
    public AccountOperationStatusResult getAccountOperationStatusResult() {
        return (AccountOperationStatusResult) super.getResult().get(RESULT_KEY);
    }

}

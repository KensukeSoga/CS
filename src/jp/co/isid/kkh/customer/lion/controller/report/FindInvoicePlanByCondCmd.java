package jp.co.isid.kkh.customer.lion.controller.report;

import jp.co.isid.kkh.customer.lion.model.report.InvoicePlanLionCondition;
import jp.co.isid.kkh.customer.lion.model.report.InvoicePlanLionManager;
import jp.co.isid.kkh.customer.lion.model.report.InvoicePlanLionResult;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * ライオン制作費請求予定表検索コマンド
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2014/07/31 HLC S.Fujimoto)<BR>
 * </P>
 *
 * @author HLC S.Fujimoto
 */
public class FindInvoicePlanByCondCmd extends Command{

    private static final long serialVersionUID = 1L;

    /** 検索結果キー */
    private static final String RESULT_KEY = "RESULT_KEY";

    /** 検索条件 */
    private InvoicePlanLionCondition _condition;

    /**
     * 検索条件を使用し、検索処理を実行します。
     * @throws KKHException 検索に失敗した場合
     */
    public void execute() throws KKHException {
        InvoicePlanLionManager manager = InvoicePlanLionManager.getInstance();
        InvoicePlanLionResult result = manager.findByCondition(_condition);
        getResult().set(RESULT_KEY, result);
    }

    /**
     * 検索結果を取得します
     * @return 検索結果
     */
    public InvoicePlanLionResult getInvoicePlanLionResult() {
        return (InvoicePlanLionResult) super.getResult().get(RESULT_KEY);
    }

    /**
     * 検索条件を設定します。
     * @param condition InvoicePlanLionCondition 検索条件
     */
    public void setFindInvoicePlanLionCondition(InvoicePlanLionCondition condition) {
        _condition = condition;
    }

}

package jp.co.isid.kkh.customer.lion.controller.report;

import jp.co.isid.kkh.customer.lion.model.report.OrderDiffListLionCondition;
import jp.co.isid.kkh.customer.lion.model.report.OrderDiffListLionManager;
import jp.co.isid.kkh.customer.lion.model.report.OrderDiffListLionResult;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * ライオン受注差異一覧検索コマンド
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2014/11/10 HLC S.Fujimoto)<BR>
 * </P>
 *
 * @author HLC S.Fujimoto
 */
public class FindOrderDiffListByCondCmd extends Command{

    private static final long serialVersionUID = 1L;

    /** 検索結果キー */
    private static final String RESULT_KEY = "RESULT_KEY";

    /** 検索条件 */
    private OrderDiffListLionCondition _condition;

    /**
     * 検索条件を使用し、検索処理を実行します。
     * @throws KKHException 検索に失敗した場合
     */
    public void execute() throws KKHException {
        OrderDiffListLionManager manager = OrderDiffListLionManager.getInstance();
        OrderDiffListLionResult result = manager.findByCondition(_condition);
        getResult().set(RESULT_KEY, result);
    }

    /**
     * 検索結果を取得します
     * @return OrderDiffListLionResult 検索結果
     */
    public OrderDiffListLionResult getOrderDiffListLionResult() {
        return (OrderDiffListLionResult) super.getResult().get(RESULT_KEY);
    }

    /**
     * 検索条件を設定します。
     * @param condition OrderDiffListLionCondition 検索条件
     */
    public void setFindOrderDiffListLionCondition(OrderDiffListLionCondition condition) {
        _condition = condition;
    }

}

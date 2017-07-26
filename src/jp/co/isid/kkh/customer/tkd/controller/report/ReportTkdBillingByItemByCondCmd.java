package jp.co.isid.kkh.customer.tkd.controller.report;

import jp.co.isid.kkh.customer.tkd.model.report.ReportTkdBillingByItemCondition;
import jp.co.isid.kkh.customer.tkd.model.report.ReportTkdBillingByItemManager;
import jp.co.isid.kkh.customer.tkd.model.report.ReportTkdBillingByItemResult;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * 武田請求明細取得コマンド
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/01/23 JSE H.Sasaki)<BR>
 * </P>
 *
 * @author
 */
public class ReportTkdBillingByItemByCondCmd extends Command {

    private static final long serialVersionUID = 1L;

    /** 検索結果キー */
    private static final String RESULT_KEY = "RESULT_KEY";

    /** 検索条件 */
    private ReportTkdBillingByItemCondition _condition;

    /**
     * 検索条件を使用し、検索処理を実行します。
     *
     * @throws KKHException
     *             検索に失敗した場合
     */
    public void execute() throws KKHException {
        ReportTkdBillingByItemManager manager = ReportTkdBillingByItemManager.getInstance();
        ReportTkdBillingByItemResult result = manager.findByCondition(_condition);
        getResult().set(RESULT_KEY, result);
    }

    /**
     * 検索条件を設定します。
     *
     * @param condition
     *            CommonCodeMasterSearchCondition 検索条件
     */
    public void setFindReportTkdBillingCondition(ReportTkdBillingByItemCondition condition) {
        _condition = condition;
    }

    /**
     * 条件検索結果を返します。
     *
     * @return ReportTohResult 条件検索結果
     */
    public ReportTkdBillingByItemResult getReportTkdBillingResult() {
        return (ReportTkdBillingByItemResult) super.getResult().get(RESULT_KEY);
    }

}

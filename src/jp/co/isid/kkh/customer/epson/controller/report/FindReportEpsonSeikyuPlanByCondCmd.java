package jp.co.isid.kkh.customer.epson.controller.report;

import jp.co.isid.kkh.customer.epson.model.report.ReportEpsonSeikyuPlanCondition;
import jp.co.isid.kkh.customer.epson.model.report.ReportEpsonSeikyuPlanManager;
import jp.co.isid.kkh.customer.epson.model.report.ReportEpsonSeikyuPlanResult;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * 請求予定一覧（エプソン)情報検索コマンド
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/3/9 IP JK)<BR>
 * </P>
 *
 * @author
 */
public class FindReportEpsonSeikyuPlanByCondCmd extends Command {

    /** */
    private static final long serialVersionUID = 1L;

    /** 検索結果キー */
    private static final String RESULT_KEY = "RESULT_KEY";

    /** 検索条件 */
    private ReportEpsonSeikyuPlanCondition _condition;

    /**
     * 検索条件を使用し、検索処理を実行します。
     * @throws KKHException 検索に失敗した場合
     */
    public void execute() throws KKHException {
        ReportEpsonSeikyuPlanManager manager = ReportEpsonSeikyuPlanManager.getInstance();
        ReportEpsonSeikyuPlanResult result = manager.findByCondition(_condition);
        getResult().set(RESULT_KEY, result);
    }

    /**
     * 検索条件を設定します。
     *
     * @param condition ReportEpsonSeikyuPlanCondition 検索条件
     */
    public void setFindReportEpsonSeikyuPlanCondition(ReportEpsonSeikyuPlanCondition condition) {
        _condition = condition;
    }

    /**
     * 条件検索結果を返します。
     *
     * @return ReportEpsonSeikyuPlanResult 条件検索結果
     */
    public ReportEpsonSeikyuPlanResult getReportEpsonSeikyuPlanResult() {
        return (ReportEpsonSeikyuPlanResult) super.getResult().get(RESULT_KEY);
    }
}

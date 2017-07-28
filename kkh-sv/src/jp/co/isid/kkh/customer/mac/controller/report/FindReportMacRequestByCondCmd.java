package jp.co.isid.kkh.customer.mac.controller.report;

import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.customer.mac.model.report.ReportMacRequestCondition;
import jp.co.isid.kkh.customer.mac.model.report.ReportMacRequestManager;
import jp.co.isid.kkh.customer.mac.model.report.ReportMacRequestResult;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * MAC検索コマンド
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/1/11)<BR>
 * </P>
 * @author
 */
public class FindReportMacRequestByCondCmd extends Command {

    private static final long serialVersionUID = 1L;

    /** 検索結果キー */
    private static final String RESULT_KEY = "RESULT_KEY";

    /** 検索条件 */
    private ReportMacRequestCondition _condition;

    /**
     * 検索条件を使用し、検索処理を実行します。
     * @throws KKHException 検索に失敗した場合
     */
    public void execute() throws KKHException {
        ReportMacRequestManager manager = ReportMacRequestManager.getInstance();
        ReportMacRequestResult result = manager.findByCondition(_condition);
        getResult().set(RESULT_KEY, result);
    }

    /**
     * 検索条件を設定します。
     *
     * @param condition CommonCodeMasterSearchCondition 検索条件
     */
    public void setFindReportMacRequestCondition(ReportMacRequestCondition condition) {
        _condition = condition;
    }

    /**
     * 条件検索結果を返します。
     *
     * @return ReportMacResult 条件検索結果
     */
    public ReportMacRequestResult getReportMacRequestResult() {
        return (ReportMacRequestResult) super.getResult().get(RESULT_KEY);
    }

}

package jp.co.isid.kkh.customer.mac.controller.report;

import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.customer.mac.model.report.ReportMacCondition;
import jp.co.isid.kkh.customer.mac.model.report.ReportMacManager;
import jp.co.isid.kkh.customer.mac.model.report.ReportMacResult;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * MAC検索コマンド
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2011/12/27 JSE K.T)<BR>
 * </P>
 * @author
 */
public class FindReportMacByCondCmd extends Command {

    private static final long serialVersionUID = 1L;

    /** 検索結果キー */
    private static final String RESULT_KEY = "RESULT_KEY";

    /** 検索条件 */
    private ReportMacCondition _condition;

    /**
     * 検索条件を使用し、検索処理を実行します。
     * @throws KKHException 検索に失敗した場合
     */
    public void execute() throws KKHException {
        ReportMacManager manager = ReportMacManager.getInstance();
        ReportMacResult result = manager.findByCondition(_condition);
        getResult().set(RESULT_KEY, result);
    }

    /**
     * 検索条件を設定します。
     *
     * @param condition CommonCodeMasterSearchCondition 検索条件
     */
    public void setFindReportMacCondition(ReportMacCondition condition) {
        _condition = condition;
    }

    /**
     * 条件検索結果を返します。
     *
     * @return ReportMacResult 条件検索結果
     */
    public ReportMacResult getReportMacResult() {
        return (ReportMacResult) super.getResult().get(RESULT_KEY);
    }

}

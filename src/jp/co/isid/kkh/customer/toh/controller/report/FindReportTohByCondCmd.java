package jp.co.isid.kkh.customer.toh.controller.report;

import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.customer.toh.model.report.ReportTohCondition;
import jp.co.isid.kkh.customer.toh.model.report.ReportTohManager;
import jp.co.isid.kkh.customer.toh.model.report.ReportTohResult;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * 汎用マスタ検索コマンド
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2011/11/07 JSE K.Fukuda)<BR>
 * </P>
 * @author
 */
public class FindReportTohByCondCmd extends Command {

    private static final long serialVersionUID = 1L;

    /** 検索結果キー */
    private static final String RESULT_KEY = "RESULT_KEY";

    /** 検索条件 */
    private ReportTohCondition _condition;

    /**
     * 検索条件を使用し、検索処理を実行します。
     * @throws KKHException 検索に失敗した場合
     */
    public void execute() throws KKHException {
        ReportTohManager manager = ReportTohManager.getInstance();
        ReportTohResult result = manager.findByCondition(_condition);
        getResult().set(RESULT_KEY, result);
    }

    /**
     * 検索条件を設定します。
     *
     * @param condition CommonCodeMasterSearchCondition 検索条件
     */
    public void setFindReportTohCondition(ReportTohCondition condition) {
        _condition = condition;
    }

    /**
     * 条件検索結果を返します。
     *
     * @return ReportTohResult 条件検索結果
     */
    public ReportTohResult getReportTohResult() {
        return (ReportTohResult) super.getResult().get(RESULT_KEY);
    }

}

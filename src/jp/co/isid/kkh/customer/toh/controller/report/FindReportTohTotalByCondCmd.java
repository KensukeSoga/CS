package jp.co.isid.kkh.customer.toh.controller.report;

import jp.co.isid.kkh.customer.toh.model.report.ReportTohTotalCondition;
import jp.co.isid.kkh.customer.toh.model.report.ReportTohTotalManager;
import jp.co.isid.kkh.customer.toh.model.report.ReportTohTotalResult;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * 汎用マスタ検索コマンド
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/02/22 JSE T.Kobayashi)<BR>
 * </P>
 * @author
 */
public class FindReportTohTotalByCondCmd extends Command {

    private static final long serialVersionUID = 1L;

    /** 検索結果キー */
    private static final String RESULT_KEY = "RESULT_KEY";

    /** 検索条件 */
    private ReportTohTotalCondition _condition;

    /**
     * 検索条件を使用し、検索処理を実行します。
     * @throws KKHException 検索に失敗した場合
     */
    public void execute() throws KKHException {
        ReportTohTotalManager manager = ReportTohTotalManager.getInstance();
        ReportTohTotalResult result = manager.findByCondition(_condition);
        getResult().set(RESULT_KEY, result);
    }

    /**
     * 検索条件を設定します。
     *
     * @param condition CommonCodeMasterSearchCondition 検索条件
     */
    public void setFindReportTohTotalCondition(ReportTohTotalCondition condition) {
        _condition = condition;
    }

    /**
     * 条件検索結果を返します。
     *
     * @return ReportTohResult 条件検索結果
     */
    public ReportTohTotalResult getReportTohTotalResult() {
        return (ReportTohTotalResult) super.getResult().get(RESULT_KEY);
    }

}

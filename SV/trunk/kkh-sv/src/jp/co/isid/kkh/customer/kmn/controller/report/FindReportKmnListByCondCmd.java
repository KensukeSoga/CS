package jp.co.isid.kkh.customer.kmn.controller.report;

import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.customer.kmn.model.report.ReportKmnListCondition;
import jp.co.isid.kkh.customer.kmn.model.report.ReportKmnListManager;
import jp.co.isid.kkh.customer.kmn.model.report.ReportKmnListResult;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * 帳票（公文_請求一覧）データ検索コマンド
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2013/1/31 JSE A.Naito)<BR>
 * </P>
 *
 * @author JSE A.Naito
 */
public class FindReportKmnListByCondCmd extends Command {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /** 検索結果キー */
    private static final String RESULT_KEY = "RESULT_KEY";

    /** 検索条件 */
    private ReportKmnListCondition _condition;

    /**
     * 検索条件を使用し、帳票（公文_請求一覧）データ検索処理を実行します。
     *
     * @throws KKHException
     *             検索に失敗した場合
     */
    public void execute() throws KKHException {
        ReportKmnListManager manager = ReportKmnListManager.getInstance();
        ReportKmnListResult result = manager.findByCondition(_condition);
        getResult().set(RESULT_KEY, result);
    }

    /**
     * 検索条件を設定します。
     *
     * @param condition
     *            setReportKmnListCondition 検索条件
     */
    public void setReportKmnListCondition(ReportKmnListCondition condition) {
        _condition = condition;
    }

    /**
     * 帳票（公文_請求一覧）データ検索結果を返します。
     *
     * @return ReportUniResult 条件検索結果
     */
    public ReportKmnListResult getReportKmnListResult() {
        return (ReportKmnListResult) super.getResult().get(RESULT_KEY);
    }
}

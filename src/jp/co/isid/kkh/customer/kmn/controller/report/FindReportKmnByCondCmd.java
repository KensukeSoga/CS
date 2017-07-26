package jp.co.isid.kkh.customer.kmn.controller.report;

import jp.co.isid.kkh.customer.kmn.model.report.ReportKmnCondition;
import jp.co.isid.kkh.customer.kmn.model.report.ReportKmnManager;
import jp.co.isid.kkh.customer.kmn.model.report.ReportKmnResult;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * 帳票（公文_伝票）データ検索コマンド
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2013/01/30 JSE M.Naito)<BR>
 * </P>
 *
 * @author JSE M.Naito
 */
public class FindReportKmnByCondCmd extends Command {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /** 検索結果キー */
    private static final String RESULT_KEY = "RESULT_KEY";

    /** 検索条件 */
    private ReportKmnCondition _condition;

    /**
     * 検索条件を使用し、 帳票（公文_伝票）データ検索処理を実行します。
     *
     * @throws KKHException
     *         検索に失敗した場合
     */
    public void execute() throws KKHException {
    	ReportKmnManager manager = ReportKmnManager.getInstance();
    	ReportKmnResult result = manager.findReportKmnByCondition(_condition);
        getResult().set(RESULT_KEY, result);
    }

    /**
     * 検索条件を設定します。
     *
     * @param condition
     *        ReportUniCondition 検索条件
     */
    public void setReportKmnCondition(ReportKmnCondition condition) {
        _condition = condition;
    }

    /**
     * 帳票（公文_伝票）データ検索結果を返します。
     *
     * @return ReportUniResult 条件検索結果
     */
    public ReportKmnResult getReportKmnResult() {
        return (ReportKmnResult) super.getResult().get(RESULT_KEY);
    }
}

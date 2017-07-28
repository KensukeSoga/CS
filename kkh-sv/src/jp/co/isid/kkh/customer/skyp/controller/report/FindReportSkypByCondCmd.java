package jp.co.isid.kkh.customer.skyp.controller.report;

import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.customer.skyp.model.report.ReportSkypCondition;
import jp.co.isid.kkh.customer.skyp.model.report.ReportSkypManager;
import jp.co.isid.kkh.customer.skyp.model.report.ReportSkypResult;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * 帳票（スカパー_納品／請求書）データ検索コマンド
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/1/16 JSE Y.Sato)<BR>
 * </P>
 *
 * @author JSE Y.Sato
 */
public class FindReportSkypByCondCmd extends Command {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /** 検索結果キー */
    private static final String RESULT_KEY = "RESULT_KEY";

    /** 検索条件 */
    private ReportSkypCondition _condition;

    /**
     * 検索条件を使用し、 帳票（スカパー_納品／請求書）データ検索処理を実行します。
     *
     * @throws KKHException
     *             検索に失敗した場合
     */
    public void execute() throws KKHException {
    	ReportSkypManager manager = ReportSkypManager.getInstance();
    	ReportSkypResult result = manager.findReportSkypByCondition(_condition);
        getResult().set(RESULT_KEY, result);
    }

    /**
     * 検索条件を設定します。
     *
     * @param condition
     *            ReportSkypCondition 検索条件
     */
    public void setReportSkypCondition(ReportSkypCondition condition) {
        _condition = condition;
    }

    /**
     * 帳票（スカパー_納品／請求書）データ検索結果を返します。
     *
     * @return ReportSkypResult 条件検索結果
     */
    public ReportSkypResult getReportSkypResult() {
        return (ReportSkypResult) super.getResult().get(RESULT_KEY);
    }
}

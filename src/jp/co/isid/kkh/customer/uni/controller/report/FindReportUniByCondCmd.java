package jp.co.isid.kkh.customer.uni.controller.report;

import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.customer.uni.model.report.ReportUniCondition;
import jp.co.isid.kkh.customer.uni.model.report.ReportUniManager;
import jp.co.isid.kkh.customer.uni.model.report.ReportUniResult;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * 帳票（ユニチャーム_広告費明細表）データ検索コマンド
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/1/23 JSE Y.Sato)<BR>
 * </P>
 *
 * @author JSE Y.Sato
 */
public class FindReportUniByCondCmd extends Command {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /** 検索結果キー */
    private static final String RESULT_KEY = "RESULT_KEY";

    /** 検索条件 */
    private ReportUniCondition _condition;

    /**
     * 検索条件を使用し、 帳票（ユニチャーム_広告費明細表）データ検索処理を実行します。
     *
     * @throws KKHException
     *             検索に失敗した場合
     */
    public void execute() throws KKHException {
    	ReportUniManager manager = ReportUniManager.getInstance();
    	ReportUniResult result = manager.findReportUniByCondition(_condition);
        getResult().set(RESULT_KEY, result);
    }

    /**
     * 検索条件を設定します。
     *
     * @param condition
     *            ReportUniCondition 検索条件
     */
    public void setReportUniCondition(ReportUniCondition condition) {
        _condition = condition;
    }

    /**
     * 帳票（ユニチャーム_広告費明細表）データ検索結果を返します。
     *
     * @return ReportUniResult 条件検索結果
     */
    public ReportUniResult getReportUniResult() {
        return (ReportUniResult) super.getResult().get(RESULT_KEY);
    }
}

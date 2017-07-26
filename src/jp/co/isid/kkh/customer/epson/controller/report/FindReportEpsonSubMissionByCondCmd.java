package jp.co.isid.kkh.customer.epson.controller.report;

import jp.co.isid.kkh.customer.epson.model.report.ReportEpsonSubMissionCondition;
import jp.co.isid.kkh.customer.epson.model.report.ReportEpsonSubMissionManager;
import jp.co.isid.kkh.customer.epson.model.report.ReportEpsonSubMissionResult;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * 提出帳票情報検索コマンド
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/3/5 JSE YS)<BR>
 * </P>
 *
 * @author
 */
public class FindReportEpsonSubMissionByCondCmd extends Command {

    /** */
    private static final long serialVersionUID = 1L;

    /** 検索結果キー */
    private static final String RESULT_KEY = "RESULT_KEY";

    /** 検索条件 */
    private ReportEpsonSubMissionCondition _condition;

    /**
     * 検索条件を使用し、検索処理を実行します。
     * @throws KKHException 検索に失敗した場合
     */
    public void execute() throws KKHException {
        ReportEpsonSubMissionManager manager = ReportEpsonSubMissionManager.getInstance();
        ReportEpsonSubMissionResult result = manager.findByCondition(_condition);
        getResult().set(RESULT_KEY, result);
    }

    /**
     * 検索条件を設定します。
     *
     * @param condition ReportEpsonSubMissionCondition 検索条件
     */
    public void setFindReportEpsonSubMissionCondition(ReportEpsonSubMissionCondition condition) {
        _condition = condition;
    }

    /**
     * 条件検索結果を返します。
     *
     * @return ReportEpsonSubMissionResult 条件検索結果
     */
    public ReportEpsonSubMissionResult getReportEpsonSubMissionResult() {
        return (ReportEpsonSubMissionResult) super.getResult().get(RESULT_KEY);
    }
}

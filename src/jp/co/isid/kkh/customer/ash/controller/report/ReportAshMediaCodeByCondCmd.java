package jp.co.isid.kkh.customer.ash.controller.report;

import jp.co.isid.kkh.customer.ash.model.report.ReportAshMediaCodeManager;
import jp.co.isid.kkh.customer.ash.model.report.ReportAshMediaCodeResult;
import jp.co.isid.kkh.customer.ash.model.report.ReportAshMediaCondition;

import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * MAC検索コマンド
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2011/1/23 fourm h.izawa)<BR>
 * </P>
 * @author
 */
public class ReportAshMediaCodeByCondCmd extends Command {

    private static final long serialVersionUID = 1L;

    /** 検索結果キー */
    private static final String RESULT_KEY = "RESULT_KEY";

    /** 検索条件 */
    private ReportAshMediaCondition _condition;

    /**
     * 検索条件を使用し、検索処理を実行します。
     * @throws KKHException 検索に失敗した場合
     */
    public void execute() throws KKHException {
        ReportAshMediaCodeManager manager = ReportAshMediaCodeManager.getInstance();
        ReportAshMediaCodeResult result = manager.findByCondition(_condition);
        getResult().set(RESULT_KEY, result);
    }

    /**
     * 検索条件を設定します。
     *
     * @param condition CommonCodeMasterSearchCondition 検索条件
     */
    public void setFindReportAshMediaCondition(ReportAshMediaCondition condition) {
        _condition = condition;
    }

    /**
     * 条件検索結果を返します。
     *
     * @return ReportMacResult 条件検索結果
     */
    public ReportAshMediaCodeResult getReportAshMediaCodeResult() {
        return (ReportAshMediaCodeResult) super.getResult().get(RESULT_KEY);
    }

}

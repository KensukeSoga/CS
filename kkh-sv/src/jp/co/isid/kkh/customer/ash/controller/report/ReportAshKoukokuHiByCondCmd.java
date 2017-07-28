package jp.co.isid.kkh.customer.ash.controller.report;

import jp.co.isid.kkh.customer.ash.model.report.ReportAshKoukokuHiManager;
import jp.co.isid.kkh.customer.ash.model.report.ReportAshKoukokuHiResult;
import jp.co.isid.kkh.customer.ash.model.report.ReportAshMediaCondition;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * 広告費明細書（Ash）データ検索コマンド
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2011/1/12 fourm h.izawa)<BR>
 * </P>
 * @author
 */
public class ReportAshKoukokuHiByCondCmd extends Command {

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
        ReportAshKoukokuHiManager manager = ReportAshKoukokuHiManager.getInstance();
        ReportAshKoukokuHiResult result = manager.findByCondition(_condition);
        getResult().set(RESULT_KEY, result);
    }

    /**
     * 検索条件を設定します。
     * @param condition CommonCodeMasterSearchCondition 検索条件
     */
    public void setFindReportAshKoukokuHiCondition(ReportAshMediaCondition condition) {
        _condition = condition;
    }

    /**
     * 条件検索結果を返します。
     * @return ReportMacResult 条件検索結果
     */
    public ReportAshKoukokuHiResult getReportAshKoukokuHiResult() {
        return (ReportAshKoukokuHiResult) super.getResult().get(RESULT_KEY);
    }

}

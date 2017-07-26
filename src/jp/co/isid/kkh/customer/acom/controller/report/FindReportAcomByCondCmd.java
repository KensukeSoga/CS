package jp.co.isid.kkh.customer.acom.controller.report;
import jp.co.isid.kkh.customer.acom.model.report.ReportAcomCondition;
import jp.co.isid.kkh.customer.acom.model.report.ReportAcomManager;
import jp.co.isid.kkh.customer.acom.model.report.ReportAcomResult;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * アコム検索コマンド
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/01/11)<BR>
 * </P>
 * @author
 */
public class FindReportAcomByCondCmd extends Command{
    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/** 検索結果キー */
    private static final String RESULT_KEY = "RESULT_KEY";

    /** 検索条件 */
    private ReportAcomCondition _condition;

    /**
     * 検索条件を使用し、検索処理を実行します。
     * @throws KKHException 検索に失敗した場合
     */
    public void execute() throws KKHException {
    	ReportAcomManager manager = ReportAcomManager.getInstance();
    	ReportAcomResult result = manager.findByCondition(_condition);
        getResult().set(RESULT_KEY, result);
    }

    /**
     * 検索条件を設定します。
     *
     * @param condition CommonCodeMasterSearchCondition 検索条件
     */
    public void setFindReportAcomCondition(ReportAcomCondition condition) {
        _condition = condition;
    }

    /**
     * 条件検索結果を返します。
     *
     * @return ReportAcomResult 条件検索結果
     */
    public ReportAcomResult getReportAcomResult() {
        return (ReportAcomResult) super.getResult().get(RESULT_KEY);
    }

}

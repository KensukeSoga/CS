package jp.co.isid.kkh.customer.lion.controller.report;
import jp.co.isid.kkh.customer.lion.model.report.DetailListLionCondition;
import jp.co.isid.kkh.customer.lion.model.report.DetailListLionManager;
import jp.co.isid.kkh.customer.lion.model.report.DetailListLionResult;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * ライオン明細一覧検索コマンド
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2013/02/01)<BR>
 * </P>
 * @author
 */
public class FindDetailListLionByCondCmd extends Command{
    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/** 検索結果キー */
    private static final String RESULT_KEY = "RESULT_KEY";

    /** 検索条件 */
    private DetailListLionCondition _condition;

    /**
     * 検索条件を使用し、検索処理を実行します。
     * @throws KKHException 検索に失敗した場合
     */
    public void execute() throws KKHException {
        DetailListLionManager manager = DetailListLionManager.getInstance();
        DetailListLionResult result = manager.findByCondition(_condition);
        getResult().set(RESULT_KEY, result);
    }

    /**
     * 検索条件を設定します。
     *
     * @param condition CommonCodeMasterSearchCondition 検索条件
     */
    public void setFindDetailListLionCondition(DetailListLionCondition condition) {
        _condition = condition;
    }

    /**
     * 条件検索結果を返します。
     *
     * @return ReportLionResult 条件検索結果
     */
    public DetailListLionResult getDetailListLionResult() {
        return (DetailListLionResult) super.getResult().get(RESULT_KEY);
    }

}

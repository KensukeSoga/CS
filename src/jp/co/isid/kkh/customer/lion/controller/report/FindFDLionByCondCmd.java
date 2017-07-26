package jp.co.isid.kkh.customer.lion.controller.report;

import jp.co.isid.kkh.customer.lion.model.report.FDLionCondition;
import jp.co.isid.kkh.customer.lion.model.report.FDLionManager;
import jp.co.isid.kkh.customer.lion.model.report.FDLionResult;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * ライオンFD出力データ取得コマンド
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/01/23 JSE H.Sasaki)<BR>
 * </P>
 *
 * @author
 */
public class FindFDLionByCondCmd extends Command {

    private static final long serialVersionUID = 1L;

    /** 検索結果キー */
    private static final String RESULT_KEY = "RESULT_KEY";

    /** 検索条件 */
    private FDLionCondition _condition;

    /**
     * 検索条件を使用し、検索処理を実行します。
     *
     * @throws KKHException
     *             検索に失敗した場合
     */
    public void execute() throws KKHException {
        FDLionManager manager = FDLionManager.getInstance();
        FDLionResult result = manager.findByCondition(_condition);
        getResult().set(RESULT_KEY, result);
    }

    /**
     * 検索条件を設定します。
     *
     * @param condition
     *            CommonCodeMasterSearchCondition 検索条件
     */
    public void setFindFDLionCondition(FDLionCondition condition) {
        _condition = condition;
    }

    /**
     * 条件検索結果を返します。
     *
     * @return ReportTohResult 条件検索結果
     */
    public FDLionResult getFindFDLionResult() {
        return (FDLionResult) super.getResult().get(RESULT_KEY);
    }

}

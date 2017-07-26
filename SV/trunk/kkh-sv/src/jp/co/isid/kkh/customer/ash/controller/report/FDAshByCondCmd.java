package jp.co.isid.kkh.customer.ash.controller.report;

import jp.co.isid.kkh.customer.ash.model.report.FDAshManager;
import jp.co.isid.kkh.customer.ash.model.report.FDAshResult;
import jp.co.isid.kkh.customer.ash.model.report.ReportAshMediaCondition;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * 請求データ（Ash）検索コマンド
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * </P>
 * @author
 */
public class FDAshByCondCmd extends Command {

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
        FDAshManager manager = FDAshManager.getInstance();
        FDAshResult result = manager.findByCondition(_condition);
        getResult().set(RESULT_KEY, result);
    }

    /**
     * 検索条件を設定します。
     * @param ReportAshMediaCondition 検索条件
     */
    public void setFindFDAshCondition(ReportAshMediaCondition condition) {
        _condition = condition;
    }

    /**
     * 条件検索結果を返します。
     * @return FDAshResult 検索結果
     */
    public FDAshResult getFDAshResult() {
        return (FDAshResult) super.getResult().get(RESULT_KEY);
    }

}

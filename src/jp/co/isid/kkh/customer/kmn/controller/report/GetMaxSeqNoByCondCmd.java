package jp.co.isid.kkh.customer.kmn.controller.report;

import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.customer.kmn.model.report.MaxSeqNoCondition;
import jp.co.isid.kkh.customer.kmn.model.report.MaxSeqNoManager;
import jp.co.isid.kkh.customer.kmn.model.report.MaxSeqNoResult;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * シークエンスNo最大値取得コマンド
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2013/2/25 JSE A.Naito)<BR>
 * </P>
 *
 * @author JSE A.Naito
 */
public class GetMaxSeqNoByCondCmd extends Command {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /** 検索結果キー */
    private static final String RESULT_KEY = "RESULT_KEY";

    /** 検索条件 */
    private MaxSeqNoCondition _condition;

    /**
     * 検索条件を使用し、シークエンスNo最大値を取得します。
     *
     * @throws KKHException
     *             検索に失敗した場合
     */
    public void execute() throws KKHException {
        MaxSeqNoManager manager = MaxSeqNoManager.getInstance();
        MaxSeqNoResult result = manager.findByCondition(_condition);
        getResult().set(RESULT_KEY, result);
    }

    /**
     * 検索条件を設定します。
     *
     * @param condition
     *            setReportKmnListCondition 検索条件
     */
    public void setMaxSeqNoCondition(MaxSeqNoCondition condition) {
        _condition = condition;
    }

    /**
     * シークエンスNo最大値を返します。
     *
     * @return ReportUniResult 条件検索結果
     */
    public MaxSeqNoResult getMaxSeqNoResult() {
        return (MaxSeqNoResult) super.getResult().get(RESULT_KEY);
    }
}

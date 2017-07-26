package jp.co.isid.kkh.customer.kmn.controller.report;

import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.customer.kmn.model.report.UpdateSeqNoCondition;
import jp.co.isid.kkh.customer.kmn.model.report.UpdateSeqNoManager;
import jp.co.isid.kkh.customer.kmn.model.report.UpdateSeqNoResult;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * シークエンスNo登録・更新コマンド
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2013/2/26 JSE A.Naito)<BR>
 * </P>
 *
 * @author JSE A.Naito
 */
public class UpdateSeqNoByCondCmd extends Command {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /** 検索結果キー */
    private static final String RESULT_KEY = "RESULT_KEY";

    /** 検索条件 */
    private UpdateSeqNoCondition _condition;

    /**
     * 検索条件を使用し、シークエンスNo最大値を取得します。
     *
     * @throws KKHException
     *             検索に失敗した場合
     */
    public void execute() throws KKHException {
        UpdateSeqNoManager manager = UpdateSeqNoManager.getInstance();
        manager.updateDisplayData(_condition);
        getResult().set(RESULT_KEY, new UpdateSeqNoResult());
    }

    /**
     * 検索条件を設定します。
     *
     * @param condition
     *            setReportKmnListCondition 検索条件
     */
    public void setUpdateSeqNoCondition(UpdateSeqNoCondition condition) {
        _condition = condition;
    }

    /**
     * シークエンスNo最大値を返します。
     *
     * @return ReportUniResult 条件検索結果
     */
    public UpdateSeqNoResult getUpdateSeqNoResult() {
        return (UpdateSeqNoResult) super.getResult().get(RESULT_KEY);
    }

}

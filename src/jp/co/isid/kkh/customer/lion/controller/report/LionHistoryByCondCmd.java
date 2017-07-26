package jp.co.isid.kkh.customer.lion.controller.report;

import jp.co.isid.kkh.customer.lion.model.report.LionHistoryCondition;
import jp.co.isid.kkh.customer.lion.model.report.LionHistoryManager;
import jp.co.isid.kkh.customer.lion.model.report.LionHistoryResult;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * ライオン受注履歴作成コマンド
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2014/07/31 S.Fujimoto)<BR>
 * </P>
 * @author HLC S.Fujimoto
 */
public class LionHistoryByCondCmd extends Command {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** 検索結果キー */
    private static final String RESULT_KEY = "RESULT_KEY";

    LionHistoryCondition _cond;

    /**
     * 検索条件を使用し、検索処理を実行します。
     * @throws KKHException 検索に失敗した場合
     */
    @Override
    public void execute() throws KKHException {
        LionHistoryManager manager = LionHistoryManager.getInstance();
        LionHistoryResult result = manager.insertLionRrkInfo(_cond);
        getResult().set(RESULT_KEY, result);
    }

    /**
     * 検索条件を設定します。
     * @param cond 検索条件
     */
    public void setLionHistoryCondition(LionHistoryCondition cond) {
        _cond = cond;
    }

    /**
     * 実行結果を返します。
     * @return 実行結果
     */
    public LionHistoryResult getInsertHistoryResult() {
        return (LionHistoryResult)super.getResult().get(RESULT_KEY);
    }

}

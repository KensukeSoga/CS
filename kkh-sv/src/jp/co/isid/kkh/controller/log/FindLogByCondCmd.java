package jp.co.isid.kkh.controller.log;

import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.model.log.LogCondition;
import jp.co.isid.kkh.model.log.LogManager;
import jp.co.isid.kkh.model.log.LogResult;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * 汎用ログ検索コマンド
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2011/11/11 IP H.Shimizu)<BR>
 * </P>
 * @author
 */
public class FindLogByCondCmd extends Command {

    private static final long serialVersionUID = 1L;

    /** 検索結果キー */
    private static final String RESULT_KEY = "RESULT_KEY";

    /** 検索条件 */
    private LogCondition _condition;

    /**
     * 検索条件を使用し、検索処理を実行します。
     * @throws KKHException 検索に失敗した場合
     */
    public void execute() throws KKHException {
        LogManager manager = LogManager.getInstance();
        LogResult result = manager.findLogByCondition(_condition);
        getResult().set(RESULT_KEY, result);
    }

    /**
     * 検索条件を設定します。
     *
     * @param condition CommonCodeMasterSearchCondition 検索条件
     */
    public void setFindLogCondition(LogCondition condition) {
        _condition = condition;
    }

    /**
     * 条件検索結果を返します。
     *
     * @return LogResult 条件検索結果
     */
    public LogResult getLogResult() {
        return (LogResult) super.getResult().get(RESULT_KEY);
    }

}

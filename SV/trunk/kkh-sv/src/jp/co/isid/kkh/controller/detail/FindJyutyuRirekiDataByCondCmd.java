package jp.co.isid.kkh.controller.detail;

import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.model.detail.DetailManager;
import jp.co.isid.kkh.model.detail.Thb8DownRCondition;
import jp.co.isid.kkh.model.detail.Thb8DownRResult;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * 受注ダウンロード履歴検索コマンド
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2011/11/07 JSE K.Fukuda)<BR>
 * </P>
 * @author
 */
public class FindJyutyuRirekiDataByCondCmd extends Command {

    private static final long serialVersionUID = 1L;

    /** 検索結果キー */
    private static final String RESULT_KEY = "RESULT_KEY";

    /** 検索条件 */
    private Thb8DownRCondition _condition;

    /**
     * 検索条件を使用し、検索処理を実行します。
     * @throws KKHException 検索に失敗した場合
     */
    public void execute() throws KKHException {
        DetailManager manager = DetailManager.getInstance();
        Thb8DownRResult result = manager.findJyutyuRirekiDataByCond(_condition);
        getResult().set(RESULT_KEY, result);
    }

    /**
     * 検索条件を設定します。
     *
     * @param condition Thb8DownRCondition 検索条件
     */
    public void setThb8DownRCondition(Thb8DownRCondition condition) {
        _condition = condition;
    }

    /**
     * 条件検索結果を返します。
     *
     * @return Thb8DownRResult 条件検索結果
     */
    public Thb8DownRResult getThb8DownRResult() {
        return (Thb8DownRResult) super.getResult().get(RESULT_KEY);
    }

}

package jp.co.isid.kkh.customer.ash.controller.detail;

import jp.co.isid.kkh.customer.ash.model.detail.DetailAshManager;
import jp.co.isid.kkh.customer.ash.model.detail.DetailDataAshCondition;
import jp.co.isid.kkh.customer.ash.model.detail.DetailDataAshResult;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * 汎用マスタ検索コマンド
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2011/11/07 JSE K.Fukuda)<BR>
 * </P>
 * @author
 */
public class FindDetailDataAshByCondCmd extends Command {

    private static final long serialVersionUID = 1L;

    /** 検索結果キー */
    private static final String RESULT_KEY = "RESULT_KEY";

    /** 検索条件 */
    private DetailDataAshCondition _condition;

    /**
     * 検索条件を使用し、検索処理を実行します。
     * @throws KKHException 検索に失敗した場合
     */
    public void execute() throws KKHException {
        DetailAshManager manager = DetailAshManager.getInstance();
        DetailDataAshResult result = manager.findDetailDataAshByCond(_condition);
        getResult().set(RESULT_KEY, result);
    }

    /**
     * 検索条件を設定します。
     *
     * @param condition FindDetailDataByCond 検索条件
     */
    public void setDetailDataAshCondition(DetailDataAshCondition condition) {
        _condition = condition;
    }

    /**
     * 条件検索結果を返します。
     *
     * @return DetailDataResult 条件検索結果
     */
    public DetailDataAshResult getDetailDataAshResult() {
        return (DetailDataAshResult) super.getResult().get(RESULT_KEY);
    }

}

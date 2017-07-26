package jp.co.isid.kkh.customer.acom.controller.input;

import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.customer.acom.model.input.HikManager;
import jp.co.isid.kkh.customer.acom.model.input.HikCommonCondition;
import jp.co.isid.kkh.customer.acom.model.input.HikSearchResult;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * 発注データ検索コマンド
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2011/11/08 HLC J.Mrobayashi)<BR>
 * </P>
 * @author HLC J.Mrobayashi
 */
public class FindHikByCondCmd extends Command {

    private static final long serialVersionUID = 1L;

    /** 検索結果キー */
    private static final String RESULT_KEY = "RESULT_KEY";

    /** 検索条件 */
    private HikCommonCondition _condition;

    /**
     * 検索条件を使用し、検索処理を実行します。
     * @throws KKHException 検索に失敗した場合
     */
    public void execute() throws KKHException {
        HikManager manager = HikManager.getInstance();
        HikSearchResult result = manager.findByCondition(_condition);
        getResult().set(RESULT_KEY, result);
    }

    /**
     * 検索条件を設定します。
     * @param condition HikCommonCondition 検索条件
     */
    public void setHikSearchCondition(HikCommonCondition condition) {
        _condition = condition;
    }

    /**
     * 条件検索結果を返します。
     * @return HikSearchResult 条件検索結果
     */
    public HikSearchResult getHikSearchResult() {
        return (HikSearchResult) super.getResult().get(RESULT_KEY);
    }

}

package jp.co.isid.kkh.customer.epson.controller.detail;

import jp.co.isid.kkh.customer.epson.model.detail.DetailEpsonManager;
import jp.co.isid.kkh.customer.epson.model.detail.DetailDataEpsonCondition;
import jp.co.isid.kkh.customer.epson.model.detail.DetailDataEpsonResult;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * 汎用マスタ検索コマンド
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/3/5 IP.Shimizu)<BR>
 * </P>
 * @author
 */
public class FindDetailDataEpsonByCondCmd extends Command {

    private static final long serialVersionUID = 1L;

    /** 検索結果キー */
    private static final String RESULT_KEY = "RESULT_KEY";

    /** 検索条件 */
    private DetailDataEpsonCondition _condition;

    /**
     * 検索条件を使用し、検索処理を実行します。
     * @throws KKHException 検索に失敗した場合
     */
    public void execute() throws KKHException {
        DetailEpsonManager manager = DetailEpsonManager.getInstance();
        DetailDataEpsonResult result = manager.findDetailDataEpsonByCond(_condition);
        getResult().set(RESULT_KEY, result);
    }

    /**
     * 検索条件を設定します。
     *
     * @param condition FindDetailDataByCond 検索条件
     */
    public void setDetailDataEpsonCondition(DetailDataEpsonCondition condition) {
        _condition = condition;
    }

    /**
     * 条件検索結果を返します。
     *
     * @return DetailDataResult 条件検索結果
     */
    public DetailDataEpsonResult getDetailDataEpsonResult() {
        return (DetailDataEpsonResult) super.getResult().get(RESULT_KEY);
    }

}

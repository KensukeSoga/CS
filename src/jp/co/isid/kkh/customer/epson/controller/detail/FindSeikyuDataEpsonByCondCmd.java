package jp.co.isid.kkh.customer.epson.controller.detail;

import jp.co.isid.kkh.customer.epson.model.detail.SeikyuDataEpsonManager;
import jp.co.isid.kkh.customer.epson.model.detail.SeikyuDataCondition;
import jp.co.isid.kkh.customer.epson.model.detail.SeikyuDataEpsonResult;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * 請求回収データ検索コマンド
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/04/25 JSE.Yuguchi)<BR>
 * </P>
 * @author
 */
public class FindSeikyuDataEpsonByCondCmd extends Command {

    private static final long serialVersionUID = 1L;

    /** 検索結果キー */
    private static final String RESULT_KEY = "RESULT_KEY";

    /** 検索条件 */
    private SeikyuDataCondition _condition;

    /**
     * 検索条件を使用し、検索処理を実行します。
     * @throws KKHException 検索に失敗した場合
     */
    public void execute() throws KKHException {
        SeikyuDataEpsonManager manager = SeikyuDataEpsonManager.getInstance();
        SeikyuDataEpsonResult result = manager.findSeikyuDataEpsonByCond(_condition);
        getResult().set(RESULT_KEY, result);
    }

    /**
     * 検索条件を設定します。
     *
     * @param condition FindSeikyuDataByCond 検索条件
     */
    public void setSeikyuDataCondition(SeikyuDataCondition condition) {
        _condition = condition;
    }

    /**
     * 条件検索結果を返します。
     *
     * @return SeikyuDataEpsonResult 条件検索結果
     */
    public SeikyuDataEpsonResult getSeikyuDataEpsonResult() {
        return (SeikyuDataEpsonResult) super.getResult().get(RESULT_KEY);
    }

}

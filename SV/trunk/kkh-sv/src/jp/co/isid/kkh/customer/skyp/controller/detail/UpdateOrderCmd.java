package jp.co.isid.kkh.customer.skyp.controller.detail;

import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.customer.skyp.model.detail.UpdateOrderManager;
import jp.co.isid.kkh.customer.skyp.model.detail.UpdateOrderResult;
import jp.co.isid.kkh.customer.skyp.model.detail.UpdateOrderVO;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * 並び順更新コマンド
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2011/12/22 JSE Y.Sato)<BR>
 * </P>
 *
 * @author JSE Y.Sato
 */
public class UpdateOrderCmd extends Command {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /** 検索結果キー */
    private static final String RESULT_KEY = "RESULT_KEY";

    /** 検索条件 */
    private UpdateOrderVO _vo;

    /**
     * 並び順更新処理を実行します。
     *
     * @throws KKHException
     *             検索に失敗した場合
     */
    public void execute() throws KKHException {
        UpdateOrderManager manager = UpdateOrderManager.getInstance();
        UpdateOrderResult result = manager.updateThb2KmeiForOrder(_vo);
        getResult().set(RESULT_KEY, result);
    }

    /**
     * 並び順更新情報VOを設定します。
     *
     * @param vo
     *            UpdateOrderVO 検索条件
     */
    public void setUpdateOrderVO(UpdateOrderVO vo) {
        _vo = vo;
    }

    /**
     * 並び順更新結果を返します。
     *
     * @return UpdateOrderResult 並び順更新結果
     */
    public UpdateOrderResult getUpdateOrderResult() {
        return (UpdateOrderResult) super.getResult().get(RESULT_KEY);
    }
}

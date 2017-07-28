package jp.co.isid.kkh.customer.acom.controller.claim;

import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.customer.acom.model.claim.UpdateOutFlgManager;
import jp.co.isid.kkh.customer.acom.model.claim.UpdateOutFlgResult;
import jp.co.isid.kkh.customer.acom.model.claim.UpdateOutFlgVO;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * 送信フラグ更新コマンド
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/2/20 JSE Y.Sato)<BR>
 * </P>
 *
 * @author JSE Y.Sato
 */
public class UpdateOutFlgCmd extends Command {

    /** */
    private static final long serialVersionUID = 1L;

    /** 検索結果キー */
    private static final String RESULT_KEY = "RESULT_KEY";

    /** 検索条件 */
    private UpdateOutFlgVO _vo;

    /**
     * 送信フラグ更新処理を実行します。
     *
     * @throws KKHException
     *             検索に失敗した場合
     */
    public void execute() throws KKHException {
        UpdateOutFlgManager manager = UpdateOutFlgManager.getInstance();
        UpdateOutFlgResult result = manager.updateThb2KmeiForOutFlg(_vo);
        getResult().set(RESULT_KEY, result);
    }

    /**
     * 送信フラグ更新情報VOを設定します。
     *
     * @param vo
     *            UpdateOutFlgVO 検索条件
     */
    public void setUpdateOutFlgVO(UpdateOutFlgVO vo) {
        _vo = vo;
    }

    /**
     * 送信フラグ更新結果を返します。
     *
     * @return UpdateOutFlgResult 送信フラグ更新結果
     */
    public UpdateOutFlgResult getUpdateOutFlgResult() {
        return (UpdateOutFlgResult) super.getResult().get(RESULT_KEY);
    }
}

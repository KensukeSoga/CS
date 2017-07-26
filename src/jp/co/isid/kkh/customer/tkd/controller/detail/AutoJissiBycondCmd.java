package jp.co.isid.kkh.customer.tkd.controller.detail;

import jp.co.isid.kkh.model.base.KKHException;

import jp.co.isid.kkh.customer.tkd.model.detail.AutoJissiBycondManager;
import jp.co.isid.kkh.customer.tkd.model.detail.AutoJissiBycondResult;
import jp.co.isid.kkh.customer.tkd.model.detail.AutoJissiBycondVO;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * 広告費明細－実施NO自動UP/DOWN（実施No自動付与）コマンド
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2011/12/6 Fourm H.izawa)<BR>
 * </P>
 *
 * @author Fourm H.izawa
 */
public class AutoJissiBycondCmd extends Command {

    private static final long serialVersionUID = 1L;

    /** 実施NO自動UP/DOWN（実施No自動付与）VO */
    private AutoJissiBycondVO _vo;

    /** 実行結果キー */
    private static final String RESULT_KEY = "RESULT_KEY";

    /**
     * 実施NO自動UP/DOWN（実施No自動付与）処理を実行します。
     *
     * @throws KKHException 登録に失敗した場合
     */
    public void execute() throws KKHException {
        AutoJissiBycondManager manager = AutoJissiBycondManager.getInstance();

        // 実施NOのUP/DOWN（実施No自動付与）の登録
        manager.audateJissiData(_vo);
        // 正常終了
        getResult().set(RESULT_KEY, new AutoJissiBycondResult());
    }

    /**
     * 実施NO自動UP/DOWN（実施No自動付与）VOを設定します。
     *
     * @param vo AutoJissiBycondVO 実施NO自動UP/DOWN（実施No自動付与）
     */
    public void setAutoJissiBycondVO(AutoJissiBycondVO vo) {
        _vo = vo;
    }

    /**
     * 実施NO自動UP/DOWN（実施No自動付与）の結果を返します。
     *
     * @return AutoJissiBycondResult 実施NO自動UP/DOWN（実施No自動付与）の結果
     */
    public AutoJissiBycondResult getAutoJissiBycondResult() {
        return (AutoJissiBycondResult) super.getResult().get(RESULT_KEY);
    }

}

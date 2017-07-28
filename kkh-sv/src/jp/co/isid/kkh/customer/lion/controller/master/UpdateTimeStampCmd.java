package jp.co.isid.kkh.customer.lion.controller.master;

import jp.co.isid.kkh.customer.lion.model.master.UpdateTimeStampManager;
import jp.co.isid.kkh.customer.lion.model.master.UpdateTimeStampResult;
import jp.co.isid.kkh.customer.lion.model.master.UpdateTimeStampVO;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * 広告費明細－表示データ更新コマンド
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/2/9 Fourm A.naito)<BR>
 * </P>
 *
 * @author Fourm A.naito
 */
public class UpdateTimeStampCmd extends Command {

    private static final long serialVersionUID = 1L;

    /** 広告費明細表示データ更新処理用VO */
    private UpdateTimeStampVO _vo;

    /** 実行結果キー */
    private static final String RESULT_KEY = "RESULT_KEY";

    /**
     * 広告費明細表示データ更新処理を実行します。
     *
     * @throws KKHException 登録に失敗した場合
     */
    public void execute() throws KKHException {

        UpdateTimeStampManager manager = UpdateTimeStampManager.getInstance();

        // 実施NOのUP/DOWNの登録
        manager.updateJissiData(_vo);
        // 正常終了
        getResult().set(RESULT_KEY, new UpdateTimeStampResult());

//        throw new KKHException("");
    }

    /**
     * プランデータ登録VOを設定します。
     *
     * @param vo DetailUpdateDataVO プランデータ登録VO
     */
    public void setUpdateTimeStampVO(UpdateTimeStampVO vo) {
        _vo = vo;
    }

    /**
     * 登録後のプランデータを返します。
     *
     * @return UpdateDisplayDataResult 登録後のプランデータ
     */
    public UpdateTimeStampResult getUpdateTimeStampResult() {
        return (UpdateTimeStampResult) super.getResult().get(RESULT_KEY);
    }

}

package jp.co.isid.kkh.customer.lion.controller.detail;

import jp.co.isid.kkh.customer.lion.model.detail.UpdateSubjectManager;
import jp.co.isid.kkh.customer.lion.model.detail.UpdateSubjectResult;
import jp.co.isid.kkh.customer.lion.model.detail.UpdateSubjectVO;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * 広告費明細－件名変更コマンド
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/2/9 Fourm A.naito)<BR>
 * </P>
 *
 * @author Fourm A.naito
 */
public class UpdateSubjectCmd extends Command {

    private static final long serialVersionUID = 1L;

    /** 広告費明細表示データ更新処理用VO */
    private UpdateSubjectVO _vo;

    /** 実行結果キー */
    private static final String RESULT_KEY = "RESULT_KEY";

    /**
     * 広告費明細表示データ更新処理を実行します。
     *
     * @throws KKHException 登録に失敗した場合
     */
    public void execute() throws KKHException {

        UpdateSubjectManager manager = UpdateSubjectManager.getInstance();

        // 件名変更データの登録
        manager.updateJissiData(_vo);
        // 正常終了
        getResult().set(RESULT_KEY, new UpdateSubjectResult());
    }

    /**
     * プランデータ登録VOを設定します。
     *
     * @param vo DetailUpdateDataVO プランデータ登録VO
     */
    public void setUpdateSubjectVO(UpdateSubjectVO vo) {
        _vo = vo;
    }

    /**
     * 登録後のプランデータを返します。
     *
     * @return UpdateDisplayDataResult 登録後のプランデータ
     */
    public UpdateSubjectResult getUpdateSubjectResult() {
        return (UpdateSubjectResult) super.getResult().get(RESULT_KEY);
    }

}

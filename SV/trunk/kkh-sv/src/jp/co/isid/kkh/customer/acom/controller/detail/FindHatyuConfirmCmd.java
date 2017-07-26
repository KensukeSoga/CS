package jp.co.isid.kkh.customer.acom.controller.detail;

import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.customer.acom.model.detail.FindHatyuConfirmManager;
import jp.co.isid.kkh.customer.acom.model.detail.FindHatyuConfirmResult;
import jp.co.isid.kkh.customer.acom.model.detail.FindHatyuNumByCondVO;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * 広告費明細－表示データ更新コマンド
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2011/12/22 Fourm H.izawa)<BR>
 * </P>
 *
 * @author Fourm H.izawa
 */
public class FindHatyuConfirmCmd extends Command {

    private static final long serialVersionUID = 1L;

    /** 広告費明細表示データ更新処理用VO */
    private FindHatyuNumByCondVO _vo;

    /** 実行結果キー */
    private static final String RESULT_KEY = "RESULT_KEY";

    /**
     * 広告費明細表示データ更新処理を実行します。
     *
     * @throws KKHException 登録に失敗した場合
     */
    public void execute() throws KKHException {

        FindHatyuConfirmManager manager = FindHatyuConfirmManager.getInstance();

        //検索開始
        FindHatyuConfirmResult result = manager.findThb2Kmeidata(_vo);
        // 正常終了
        getResult().set(RESULT_KEY, result);

//        throw new KKHException("");
    }

    /**
     * プランデータ登録VOを設定します。
     *
     * @param vo DetailUpdateDataVO プランデータ登録VO
     */
    public void setFindHatyuNumBycondVO(FindHatyuNumByCondVO vo) {
        _vo = vo;
    }

    /**
     * 登録後のプランデータを返します。
     *
     * @return UpdateDisplayDataResult 登録後のプランデータ
     */
    public FindHatyuConfirmResult getFindHatyuNumBycondResult() {
        return (FindHatyuConfirmResult) super.getResult().get(RESULT_KEY);
    }

}

package jp.co.isid.kkh.customer.acom.controller.detail;

import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.customer.acom.model.detail.FindSyohinNameGetCond;
import jp.co.isid.kkh.customer.acom.model.detail.FindSyouhinNameManager;
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
public class FindSyouhinNameCmd extends Command {

    private static final long serialVersionUID = 1L;

    /** 広告費明細表示データ更新処理用VO */
    private FindSyohinNameGetCond _vo;

    /** 実行結果キー */
    private static final String RESULT_KEY = "RESULT_KEY";

    /**
     * 広告費明細表示データ更新処理を実行します。
     *
     * @throws KKHException 登録に失敗した場合
     */
    public void execute() throws KKHException {

        FindSyouhinNameManager manager = FindSyouhinNameManager.getInstance();

        //検索開始
        String syouhinName = manager.findThb2Kmeidata(_vo);
        // 正常終了
        getResult().set(RESULT_KEY, syouhinName);

//        throw new KKHException("");
    }

    /**
     * プランデータ登録VOを設定します。
     *
     * @param vo DetailUpdateDataVO プランデータ登録VO
     */
    public void setFindSyouhinName(FindSyohinNameGetCond vo) {
        _vo = vo;
    }

    /**
     * 登録後のプランデータを返します。
     *
     * @return UpdateDisplayDataResult 登録後のプランデータ
     */
    public String getFindSyouhinNameResult() {
        return (String) super.getResult().get(RESULT_KEY);
    }

}

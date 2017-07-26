package jp.co.isid.kkh.customer.tkd.controller.detail;

import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.customer.tkd.model.detail.FindThb2KmeiBycondManager;
import jp.co.isid.kkh.customer.tkd.model.detail.FindThb2KmeiBycondResult;
import jp.co.isid.kkh.customer.tkd.model.detail.FindThb2KmeiBycondVO;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * 広告費明細－表示データ更新コマンド
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2011/12/6 Fourm H.izawa)<BR>
 * </P>
 *
 * @author Fourm H.izawa
 */
public class FindThb2KmeiBycondCmd extends Command {

    private static final long serialVersionUID = 1L;

    /** 広告費明細表示データ更新処理用VO */
    private FindThb2KmeiBycondVO _vo;

    /** 実行結果キー */
    private static final String RESULT_KEY = "RESULT_KEY";

    /**
     * 広告費明細表示データ更新処理を実行します。
     *
     * @throws KKHException 登録に失敗した場合
     */
    public void execute() throws KKHException {

        FindThb2KmeiBycondManager manager = FindThb2KmeiBycondManager.getInstance();
        FindThb2KmeiBycondResult result = new FindThb2KmeiBycondResult();

        //業務区分がクリエーティブ以外を処理する
        if(_vo.getCreativeFlg().equals("0")){
            result = manager.findThb2Kmeidata(_vo);
        }
        else{
            result = manager.findThb2KmeidataCreative(_vo);
        }

        //FindThb2KmeiBycondResult result = manager.findThb2Kmeidata(_vo);
        // 正常終了
        getResult().set(RESULT_KEY, result);

//        throw new KKHException("");
    }

    /**
     * プランデータ登録VOを設定します。
     *
     * @param vo DetailUpdateDataVO プランデータ登録VO
     */
    public void setFindThb2KmeiBycondVO(FindThb2KmeiBycondVO vo) {
        _vo = vo;
    }

    /**
     * 登録後のプランデータを返します。
     *
     * @return UpdateDisplayDataResult 登録後のプランデータ
     */
    public FindThb2KmeiBycondResult getFindThb2KmeiBycondResult() {
        return (FindThb2KmeiBycondResult) super.getResult().get(RESULT_KEY);
    }

}

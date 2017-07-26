package jp.co.isid.kkh.customer.acom.controller.detail;

import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.customer.acom.model.detail.FindThb5HikBycondManager;
import jp.co.isid.kkh.customer.acom.model.detail.FindThb5HikResult;
import jp.co.isid.kkh.customer.acom.model.detail.Thb5HikVO;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * 広告費明細－表示データ更新コマンド
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2011/1/10 Fourm H.izawa)<BR>
 * </P>
 *
 * @author Fourm H.izawa
 */
public class FindThb5HikBycondCmd extends Command {

    private static final long serialVersionUID = 1L;

    /** 広告費明細表示データ更新処理用VO */
    private Thb5HikVO _vo;

    /** 実行結果キー */
    private static final String RESULT_KEY = "RESULT_KEY";

    /**
     * 広告費明細表示データ更新処理を実行します。
     *
     * @throws KKHException 登録に失敗した場合
     */
    public void execute() throws KKHException {

        FindThb5HikBycondManager manager = FindThb5HikBycondManager.getInstance();

        //検索開始
        FindThb5HikResult result = manager.findthb5Hikdata(_vo);
        // 正常終了
        getResult().set(RESULT_KEY, result);

//        throw new KKHException("");
    }

    /**
     * プランデータ登録VOを設定します。
     * @param vo DetailUpdateDataVO プランデータ登録VO
     */
    public void setFind8HikBycondVO(Thb5HikVO vo) {
        _vo = vo;
    }

    /**
     * 登録後のプランデータを返します。
     * @return UpdateDisplayDataResult 登録後のプランデータ
     */
    public FindThb5HikResult getFindThb5HikResult() {
        return (FindThb5HikResult) super.getResult().get(RESULT_KEY);
    }

}

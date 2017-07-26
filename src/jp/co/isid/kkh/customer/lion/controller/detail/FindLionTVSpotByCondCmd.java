package jp.co.isid.kkh.customer.lion.controller.detail;

import jp.co.isid.kkh.customer.lion.model.detail.FindLionTVSpotCondition;
import jp.co.isid.kkh.customer.lion.model.detail.FindLionTVSpotManager;
import jp.co.isid.kkh.customer.lion.model.detail.FindLionTVSpotResult;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * ライオンTVSpotデータ取得コマンド
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/03/05 JSE H.Sasaki)<BR>
 * </P>
 *
 * @author
 */
public class FindLionTVSpotByCondCmd extends Command {

    private static final long serialVersionUID = 1L;

    /** 検索結果キー */
    private static final String RESULT_KEY = "RESULT_KEY";

    /** 検索条件 */
    private FindLionTVSpotCondition _condition;

    /**
     * 検索条件を使用し、検索処理を実行します。
     *
     * @throws KKHException
     *             検索に失敗した場合
     */
    public void execute() throws KKHException {
        FindLionTVSpotManager manager = FindLionTVSpotManager.getInstance();
        FindLionTVSpotResult result = manager.findByCondition(_condition);
        getResult().set(RESULT_KEY, result);
    }

    /**
     * 検索条件を設定します。
     *
     * @param condition
     *            CommonCodeMasterSearchCondition 検索条件
     */
    public void setFindLionTVSpotCondition(FindLionTVSpotCondition condition) {
        _condition = condition;
    }

    /**
     * 条件検索結果を返します。
     *
     * @return ReportTohResult 条件検索結果
     */
    public FindLionTVSpotResult getFindLionTVSpotResult() {
        return (FindLionTVSpotResult) super.getResult().get(RESULT_KEY);
    }
}

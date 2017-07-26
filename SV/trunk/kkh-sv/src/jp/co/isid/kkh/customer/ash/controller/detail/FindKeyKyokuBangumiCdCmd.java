package jp.co.isid.kkh.customer.ash.controller.detail;

import jp.co.isid.kkh.customer.ash.model.detail.FindKeyKyokuBangumiCdCondition;
import jp.co.isid.kkh.customer.ash.model.detail.FindKeyKyokuBangumiCdManager;
import jp.co.isid.kkh.customer.ash.model.detail.FindKeyKyokuBangumiCdResult;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * キー局の番組コードのCommand
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2014/08/20 HLC S.Jang)<BR>
 * </P>
 *
 * @author HLC 張(Jang)
 */
public class FindKeyKyokuBangumiCdCmd extends Command {
    private static final long serialVersionUID = 1L;

    /** 検索条件 */
    private FindKeyKyokuBangumiCdCondition _condition;

    /** 検索結果キー */
    private static final String RESULT_KEY = "RESULT_KEY";

    /**
     * 検索条件を使用し、検索処理を実行します。
     * @throws KKHException 検索に失敗した場合
     */
    public void execute() throws KKHException {
        FindKeyKyokuBangumiCdManager manager = FindKeyKyokuBangumiCdManager.getInstance();
        FindKeyKyokuBangumiCdResult result = manager.findKeyKyokuBangumiCd(this._condition);
        getResult().set(RESULT_KEY, result);
    }

    /**
     * 検索条件を設定します。
     * @param condition FindDetailDataByCond 検索条件
     */
    public void setFindKeyKyokuBangumiCdCondition(FindKeyKyokuBangumiCdCondition condition) {
        _condition = condition;
    }

    /**
     * 条件検索結果を返します。
     * @return DetailDataResult 条件検索結果
     */
    public FindKeyKyokuBangumiCdResult getFindKeyKyokuBangumiCdResultResult() {
        return (FindKeyKyokuBangumiCdResult) super.getResult().get(RESULT_KEY);
    }

}

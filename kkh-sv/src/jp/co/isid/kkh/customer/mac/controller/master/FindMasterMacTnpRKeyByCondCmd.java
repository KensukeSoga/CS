package jp.co.isid.kkh.customer.mac.controller.master;


import jp.co.isid.kkh.customer.mac.model.master.FindMasterMacTnpRByCondCondition;
import jp.co.isid.kkh.customer.mac.model.master.FindMasterMacTnpRKeyByCondManager;
import jp.co.isid.kkh.customer.mac.model.master.FindMasterMacTnpRKeyByCondResult;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * マクドナルド店舗マスタ履歴テーブルキー項目検索コマンド
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2013/02/01 JSE H.Okazaki)<BR>
 * </P>
 * @author
 */
public class FindMasterMacTnpRKeyByCondCmd extends Command {

    private static final long serialVersionUID = 1L;

    /** 検索結果キー */
    private static final String RESULT_KEY = "RESULT_KEY";

    /** 検索条件 */
    private FindMasterMacTnpRByCondCondition _condition;

    /**
     * 検索条件を使用し、検索処理を実行します。
     * @throws KKHException 検索に失敗した場合
     */
    public void execute() throws KKHException {
        FindMasterMacTnpRKeyByCondManager manager = FindMasterMacTnpRKeyByCondManager.getInstance();
        FindMasterMacTnpRKeyByCondResult result = manager.findthb17rmtnp(_condition);
        getResult().set(RESULT_KEY, result);
    }

    /**
     * 検索条件を設定します。
     *
     * @param condition CommonCodeMasterSearchCondition 検索条件
     */
    public void setFindMasterCondition(FindMasterMacTnpRByCondCondition condition) {
        _condition = condition;
    }

    /**
     * 条件検索結果を返します。
     *
     * @return MasterResult 条件検索結果
     */
    public FindMasterMacTnpRKeyByCondResult getMasterResult() {
        return (FindMasterMacTnpRKeyByCondResult) super.getResult().get(RESULT_KEY);
    }

}

package jp.co.isid.kkh.controller.common;

import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.model.common.CommonCodeMasterManager;
import jp.co.isid.kkh.model.common.CommonCodeMasterCondition;
import jp.co.isid.kkh.model.common.CommonCodeMasterResult;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * 汎用マスタ検索コマンド
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2011/11/07 JSE K.Fukuda)<BR>
 * </P>
 * @author
 */
public class FindCommonCodeMasterByCondCmd extends Command {

    private static final long serialVersionUID = 1L;

    /** 検索結果キー */
    private static final String RESULT_KEY = "RESULT_KEY";

    /** 検索条件 */
    private CommonCodeMasterCondition _condition;

    /**
     * 検索条件を使用し、検索処理を実行します。
     * @throws KKHException 検索に失敗した場合
     */
    public void execute() throws KKHException {
        CommonCodeMasterManager manager = CommonCodeMasterManager.getInstance();
        CommonCodeMasterResult result = manager.findByCondition(_condition);
        getResult().set(RESULT_KEY, result);
    }

    /**
     * 検索条件を設定します。
     *
     * @param condition CommonCodeMasterSearchCondition 検索条件
     */
    public void setFindCommonCodeMasterCondition(CommonCodeMasterCondition condition) {
        _condition = condition;
    }

    /**
     * 条件検索結果を返します。
     *
     * @return MasterResult 条件検索結果
     */
    public CommonCodeMasterResult getCommonCodeMasterResult() {
        return (CommonCodeMasterResult) super.getResult().get(RESULT_KEY);
    }

}

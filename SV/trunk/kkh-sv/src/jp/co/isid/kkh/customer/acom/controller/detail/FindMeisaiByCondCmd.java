package jp.co.isid.kkh.customer.acom.controller.detail;

import jp.co.isid.kkh.customer.acom.model.detail.FindMeisaiDataCondition;
import jp.co.isid.kkh.customer.acom.model.detail.FindMeisaiDataResult;
import jp.co.isid.kkh.customer.acom.model.detail.FindMeisaiDataManager;
import jp.co.isid.nj.controller.command.Command;
import jp.co.isid.nj.exp.UserException;

@SuppressWarnings("serial")
public class FindMeisaiByCondCmd extends Command {
    /** 検索結果キー */
    private static final String RESULT_KEY = "RESULT_KEY";

    /** 検索条件 */
    private FindMeisaiDataCondition _condition;

    @Override
    public void execute() throws UserException {
        FindMeisaiDataManager manager = FindMeisaiDataManager.getInstance();
        FindMeisaiDataResult result = manager.findMeisaiDataByCond(_condition);
        getResult().set(RESULT_KEY, result);
    }

    /**
     * 検索条件を設定します。
     *
     * @param condition DetailDataCondition 検索条件
     */
    public void setDetailDataCondition(FindMeisaiDataCondition condition) {
        _condition = condition;
    }

    /**
     * 条件検索結果を返します。
     *
     * @return DetailDataResult 条件検索結果
     */
    public FindMeisaiDataResult getDetailDataResult() {
        return (FindMeisaiDataResult) super.getResult().get(RESULT_KEY);
    }
}

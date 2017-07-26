package jp.co.isid.kkh.controller.detail;

import jp.co.isid.kkh.model.detail.DetailDataCondition;
import jp.co.isid.kkh.model.detail.DetailDataResult;
import jp.co.isid.kkh.model.detail.DetailManager;
import jp.co.isid.nj.controller.command.Command;
import jp.co.isid.nj.exp.UserException;

@SuppressWarnings("serial")
public class FindDetailDataByCondCmd extends Command {
    /** 検索結果キー */
    private static final String RESULT_KEY = "RESULT_KEY";

    /** 検索条件 */
    private DetailDataCondition _condition;

	@Override
	public void execute() throws UserException {
		DetailManager manager = DetailManager.getInstance();
		DetailDataResult result = manager.findDetailDataByCond(_condition);
        getResult().set(RESULT_KEY, result);
	}

    /**
     * 検索条件を設定します。
     *
     * @param condition DetailDataCondition 検索条件
     */
    public void setDetailDataCondition(DetailDataCondition condition) {
        _condition = condition;
    }

    /**
     * 条件検索結果を返します。
     *
     * @return DetailDataResult 条件検索結果
     */
    public DetailDataResult getDetailDataResult() {
        return (DetailDataResult) super.getResult().get(RESULT_KEY);
    }
}

package jp.co.isid.kkh.controller.detail;

import jp.co.isid.kkh.model.detail.DetailDataCondition;
import jp.co.isid.kkh.model.detail.DetailDataResult;
import jp.co.isid.kkh.model.detail.DetailManager;
import jp.co.isid.nj.controller.command.Command;
import jp.co.isid.nj.exp.UserException;

@SuppressWarnings("serial")
public class FindDetailDataByCondCmd extends Command {
    /** �������ʃL�[ */
    private static final String RESULT_KEY = "RESULT_KEY";

    /** �������� */
    private DetailDataCondition _condition;

	@Override
	public void execute() throws UserException {
		DetailManager manager = DetailManager.getInstance();
		DetailDataResult result = manager.findDetailDataByCond(_condition);
        getResult().set(RESULT_KEY, result);
	}

    /**
     * ����������ݒ肵�܂��B
     *
     * @param condition DetailDataCondition ��������
     */
    public void setDetailDataCondition(DetailDataCondition condition) {
        _condition = condition;
    }

    /**
     * �����������ʂ�Ԃ��܂��B
     *
     * @return DetailDataResult ������������
     */
    public DetailDataResult getDetailDataResult() {
        return (DetailDataResult) super.getResult().get(RESULT_KEY);
    }
}

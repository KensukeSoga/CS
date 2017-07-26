package jp.co.isid.kkh.customer.acom.controller.detail;

import jp.co.isid.kkh.customer.acom.model.detail.FindMeisaiDataCondition;
import jp.co.isid.kkh.customer.acom.model.detail.FindMeisaiDataResult;
import jp.co.isid.kkh.customer.acom.model.detail.FindMeisaiDataManager;
import jp.co.isid.nj.controller.command.Command;
import jp.co.isid.nj.exp.UserException;

@SuppressWarnings("serial")
public class FindMeisaiByCondCmd extends Command {
    /** �������ʃL�[ */
    private static final String RESULT_KEY = "RESULT_KEY";

    /** �������� */
    private FindMeisaiDataCondition _condition;

    @Override
    public void execute() throws UserException {
        FindMeisaiDataManager manager = FindMeisaiDataManager.getInstance();
        FindMeisaiDataResult result = manager.findMeisaiDataByCond(_condition);
        getResult().set(RESULT_KEY, result);
    }

    /**
     * ����������ݒ肵�܂��B
     *
     * @param condition DetailDataCondition ��������
     */
    public void setDetailDataCondition(FindMeisaiDataCondition condition) {
        _condition = condition;
    }

    /**
     * �����������ʂ�Ԃ��܂��B
     *
     * @return DetailDataResult ������������
     */
    public FindMeisaiDataResult getDetailDataResult() {
        return (FindMeisaiDataResult) super.getResult().get(RESULT_KEY);
    }
}

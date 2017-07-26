package jp.co.isid.kkh.customer.lion.controller.report;

import jp.co.isid.kkh.customer.lion.model.report.LionHistoryCondition;
import jp.co.isid.kkh.customer.lion.model.report.LionHistoryManager;
import jp.co.isid.kkh.customer.lion.model.report.LionHistoryResult;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * ���C�I���󒍗����쐬�R�}���h
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2014/07/31 S.Fujimoto)<BR>
 * </P>
 * @author HLC S.Fujimoto
 */
public class LionHistoryByCondCmd extends Command {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** �������ʃL�[ */
    private static final String RESULT_KEY = "RESULT_KEY";

    LionHistoryCondition _cond;

    /**
     * �����������g�p���A�������������s���܂��B
     * @throws KKHException �����Ɏ��s�����ꍇ
     */
    @Override
    public void execute() throws KKHException {
        LionHistoryManager manager = LionHistoryManager.getInstance();
        LionHistoryResult result = manager.insertLionRrkInfo(_cond);
        getResult().set(RESULT_KEY, result);
    }

    /**
     * ����������ݒ肵�܂��B
     * @param cond ��������
     */
    public void setLionHistoryCondition(LionHistoryCondition cond) {
        _cond = cond;
    }

    /**
     * ���s���ʂ�Ԃ��܂��B
     * @return ���s����
     */
    public LionHistoryResult getInsertHistoryResult() {
        return (LionHistoryResult)super.getResult().get(RESULT_KEY);
    }

}

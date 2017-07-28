package jp.co.isid.kkh.customer.ash.controller.report;

import jp.co.isid.kkh.customer.ash.model.report.FDAshManager;
import jp.co.isid.kkh.customer.ash.model.report.FDAshResult;
import jp.co.isid.kkh.customer.ash.model.report.ReportAshMediaCondition;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * �����f�[�^�iAsh�j�����R�}���h
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * </P>
 * @author
 */
public class FDAshByCondCmd extends Command {

    private static final long serialVersionUID = 1L;

    /** �������ʃL�[ */
    private static final String RESULT_KEY = "RESULT_KEY";

    /** �������� */
    private ReportAshMediaCondition _condition;

    /**
     * �����������g�p���A�������������s���܂��B
     * @throws KKHException �����Ɏ��s�����ꍇ
     */
    public void execute() throws KKHException {
        FDAshManager manager = FDAshManager.getInstance();
        FDAshResult result = manager.findByCondition(_condition);
        getResult().set(RESULT_KEY, result);
    }

    /**
     * ����������ݒ肵�܂��B
     * @param ReportAshMediaCondition ��������
     */
    public void setFindFDAshCondition(ReportAshMediaCondition condition) {
        _condition = condition;
    }

    /**
     * �����������ʂ�Ԃ��܂��B
     * @return FDAshResult ��������
     */
    public FDAshResult getFDAshResult() {
        return (FDAshResult) super.getResult().get(RESULT_KEY);
    }

}

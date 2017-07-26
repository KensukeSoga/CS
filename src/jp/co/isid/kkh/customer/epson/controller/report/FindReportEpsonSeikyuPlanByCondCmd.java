package jp.co.isid.kkh.customer.epson.controller.report;

import jp.co.isid.kkh.customer.epson.model.report.ReportEpsonSeikyuPlanCondition;
import jp.co.isid.kkh.customer.epson.model.report.ReportEpsonSeikyuPlanManager;
import jp.co.isid.kkh.customer.epson.model.report.ReportEpsonSeikyuPlanResult;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * �����\��ꗗ�i�G�v�\��)��񌟍��R�}���h
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/3/9 IP JK)<BR>
 * </P>
 *
 * @author
 */
public class FindReportEpsonSeikyuPlanByCondCmd extends Command {

    /** */
    private static final long serialVersionUID = 1L;

    /** �������ʃL�[ */
    private static final String RESULT_KEY = "RESULT_KEY";

    /** �������� */
    private ReportEpsonSeikyuPlanCondition _condition;

    /**
     * �����������g�p���A�������������s���܂��B
     * @throws KKHException �����Ɏ��s�����ꍇ
     */
    public void execute() throws KKHException {
        ReportEpsonSeikyuPlanManager manager = ReportEpsonSeikyuPlanManager.getInstance();
        ReportEpsonSeikyuPlanResult result = manager.findByCondition(_condition);
        getResult().set(RESULT_KEY, result);
    }

    /**
     * ����������ݒ肵�܂��B
     *
     * @param condition ReportEpsonSeikyuPlanCondition ��������
     */
    public void setFindReportEpsonSeikyuPlanCondition(ReportEpsonSeikyuPlanCondition condition) {
        _condition = condition;
    }

    /**
     * �����������ʂ�Ԃ��܂��B
     *
     * @return ReportEpsonSeikyuPlanResult ������������
     */
    public ReportEpsonSeikyuPlanResult getReportEpsonSeikyuPlanResult() {
        return (ReportEpsonSeikyuPlanResult) super.getResult().get(RESULT_KEY);
    }
}

package jp.co.isid.kkh.customer.tkd.controller.report;

import jp.co.isid.kkh.customer.tkd.model.report.ReportTkdBillingForPlanningCostCondition;
import jp.co.isid.kkh.customer.tkd.model.report.ReportTkdBillingForPlanningCostManager;
import jp.co.isid.kkh.customer.tkd.model.report.ReportTkdBillingForPlanningCostResult;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * ���c�������׎擾�R�}���h
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/01/23 JSE H.Sasaki)<BR>
 * </P>
 *
 * @author
 */
public class ReportTkdBillingForPlanningCostByCondCmd extends Command {

    private static final long serialVersionUID = 1L;

    /** �������ʃL�[ */
    private static final String RESULT_KEY = "RESULT_KEY";

    /** �������� */
    private ReportTkdBillingForPlanningCostCondition _condition;

    /**
     * �����������g�p���A�������������s���܂��B
     *
     * @throws KKHException
     *             �����Ɏ��s�����ꍇ
     */
    public void execute() throws KKHException {
        ReportTkdBillingForPlanningCostManager manager = ReportTkdBillingForPlanningCostManager.getInstance();
        ReportTkdBillingForPlanningCostResult result = manager.findByCondition(_condition);
        getResult().set(RESULT_KEY, result);
    }

    /**
     * ����������ݒ肵�܂��B
     *
     * @param condition
     *            CommonCodeMasterSearchCondition ��������
     */
    public void setFindReportTkdBillingCondition(ReportTkdBillingForPlanningCostCondition condition) {
        _condition = condition;
    }

    /**
     * �����������ʂ�Ԃ��܂��B
     *
     * @return ReportTohResult ������������
     */
    public ReportTkdBillingForPlanningCostResult getReportTkdBillingResult() {
        return (ReportTkdBillingForPlanningCostResult) super.getResult().get(RESULT_KEY);
    }

}

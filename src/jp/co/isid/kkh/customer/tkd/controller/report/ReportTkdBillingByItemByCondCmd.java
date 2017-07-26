package jp.co.isid.kkh.customer.tkd.controller.report;

import jp.co.isid.kkh.customer.tkd.model.report.ReportTkdBillingByItemCondition;
import jp.co.isid.kkh.customer.tkd.model.report.ReportTkdBillingByItemManager;
import jp.co.isid.kkh.customer.tkd.model.report.ReportTkdBillingByItemResult;
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
public class ReportTkdBillingByItemByCondCmd extends Command {

    private static final long serialVersionUID = 1L;

    /** �������ʃL�[ */
    private static final String RESULT_KEY = "RESULT_KEY";

    /** �������� */
    private ReportTkdBillingByItemCondition _condition;

    /**
     * �����������g�p���A�������������s���܂��B
     *
     * @throws KKHException
     *             �����Ɏ��s�����ꍇ
     */
    public void execute() throws KKHException {
        ReportTkdBillingByItemManager manager = ReportTkdBillingByItemManager.getInstance();
        ReportTkdBillingByItemResult result = manager.findByCondition(_condition);
        getResult().set(RESULT_KEY, result);
    }

    /**
     * ����������ݒ肵�܂��B
     *
     * @param condition
     *            CommonCodeMasterSearchCondition ��������
     */
    public void setFindReportTkdBillingCondition(ReportTkdBillingByItemCondition condition) {
        _condition = condition;
    }

    /**
     * �����������ʂ�Ԃ��܂��B
     *
     * @return ReportTohResult ������������
     */
    public ReportTkdBillingByItemResult getReportTkdBillingResult() {
        return (ReportTkdBillingByItemResult) super.getResult().get(RESULT_KEY);
    }

}

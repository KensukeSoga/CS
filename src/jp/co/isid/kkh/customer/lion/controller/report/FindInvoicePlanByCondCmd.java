package jp.co.isid.kkh.customer.lion.controller.report;

import jp.co.isid.kkh.customer.lion.model.report.InvoicePlanLionCondition;
import jp.co.isid.kkh.customer.lion.model.report.InvoicePlanLionManager;
import jp.co.isid.kkh.customer.lion.model.report.InvoicePlanLionResult;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * ���C�I���������\��\�����R�}���h
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2014/07/31 HLC S.Fujimoto)<BR>
 * </P>
 *
 * @author HLC S.Fujimoto
 */
public class FindInvoicePlanByCondCmd extends Command{

    private static final long serialVersionUID = 1L;

    /** �������ʃL�[ */
    private static final String RESULT_KEY = "RESULT_KEY";

    /** �������� */
    private InvoicePlanLionCondition _condition;

    /**
     * �����������g�p���A�������������s���܂��B
     * @throws KKHException �����Ɏ��s�����ꍇ
     */
    public void execute() throws KKHException {
        InvoicePlanLionManager manager = InvoicePlanLionManager.getInstance();
        InvoicePlanLionResult result = manager.findByCondition(_condition);
        getResult().set(RESULT_KEY, result);
    }

    /**
     * �������ʂ��擾���܂�
     * @return ��������
     */
    public InvoicePlanLionResult getInvoicePlanLionResult() {
        return (InvoicePlanLionResult) super.getResult().get(RESULT_KEY);
    }

    /**
     * ����������ݒ肵�܂��B
     * @param condition InvoicePlanLionCondition ��������
     */
    public void setFindInvoicePlanLionCondition(InvoicePlanLionCondition condition) {
        _condition = condition;
    }

}

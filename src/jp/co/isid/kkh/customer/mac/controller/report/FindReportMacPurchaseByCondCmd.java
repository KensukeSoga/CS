package jp.co.isid.kkh.customer.mac.controller.report;

import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.customer.mac.model.report.ReportMacPurchaseCondition;
import jp.co.isid.kkh.customer.mac.model.report.ReportMacPurchaseManager;
import jp.co.isid.kkh.customer.mac.model.report.ReportMacPurchaseResult;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * MAC�����R�}���h
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/1/11)<BR>
 * </P>
 * @author
 */
public class FindReportMacPurchaseByCondCmd extends Command {

    private static final long serialVersionUID = 1L;

    /** �������ʃL�[ */
    private static final String RESULT_KEY = "RESULT_KEY";

    /** �������� */
    private ReportMacPurchaseCondition _condition;

    /**
     * �����������g�p���A�������������s���܂��B
     * @throws KKHException �����Ɏ��s�����ꍇ
     */
    public void execute() throws KKHException {
        ReportMacPurchaseManager manager = ReportMacPurchaseManager.getInstance();
        ReportMacPurchaseResult result = manager.findByCondition(_condition);
        getResult().set(RESULT_KEY, result);
    }

    /**
     * ����������ݒ肵�܂��B
     *
     * @param condition CommonCodeMasterSearchCondition ��������
     */
    public void setFindReportMacPurchaseCondition(ReportMacPurchaseCondition condition) {
        _condition = condition;
    }

    /**
     * �����������ʂ�Ԃ��܂��B
     *
     * @return ReportMacResult ������������
     */
    public ReportMacPurchaseResult getReportMacPurchaseResult() {
        return (ReportMacPurchaseResult) super.getResult().get(RESULT_KEY);
    }

}

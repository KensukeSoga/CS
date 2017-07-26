package jp.co.isid.kkh.customer.mac.controller.report;

import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.customer.mac.model.report.ReportMacSchklstCondition;
import jp.co.isid.kkh.customer.mac.model.report.ReportMacSchklstManager;
import jp.co.isid.kkh.customer.mac.model.report.ReportMacSchklstResult;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * MAC�����R�}���h
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2011/12/27 JSE K.T)<BR>
 * </P>
 * @author
 */
public class FindReportMacSchklstByCondCmd extends Command {

    private static final long serialVersionUID = 1L;

    /** �������ʃL�[ */
    private static final String RESULT_KEY = "RESULT_KEY";

    /** �������� */
    private ReportMacSchklstCondition _condition;

    /**
     * �����������g�p���A�������������s���܂��B
     * @throws KKHException �����Ɏ��s�����ꍇ
     */
    public void execute() throws KKHException {
        ReportMacSchklstManager manager = ReportMacSchklstManager.getInstance();
        ReportMacSchklstResult result = manager.findByCondition(_condition);
        getResult().set(RESULT_KEY, result);
    }

    /**
     * ����������ݒ肵�܂��B
     *
     * @param condition CommonCodeMasterSearchCondition ��������
     */
    public void setFindReportMacSchklstCondition(ReportMacSchklstCondition condition) {
        _condition = condition;
    }

    /**
     * �����������ʂ�Ԃ��܂��B
     *
     * @return ReportMacResult ������������
     */
    public ReportMacSchklstResult getReportMacSchklstResult() {
        return (ReportMacSchklstResult) super.getResult().get(RESULT_KEY);
    }

}

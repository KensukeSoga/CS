package jp.co.isid.kkh.customer.mac.controller.report;

import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.customer.mac.model.report.ReportMacCondition;
import jp.co.isid.kkh.customer.mac.model.report.ReportMacLicenseeManager;
import jp.co.isid.kkh.customer.mac.model.report.ReportMacLicenseeResult;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * MAC�����R�}���h
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2011/1/12 fourm h.izawa)<BR>
 * </P>
 * @author
 */
public class ReportMacLicenseeByCondCmd extends Command {

    private static final long serialVersionUID = 1L;

    /** �������ʃL�[ */
    private static final String RESULT_KEY = "RESULT_KEY";

    /** �������� */
    private ReportMacCondition _condition;

    /**
     * �����������g�p���A�������������s���܂��B
     * @throws KKHException �����Ɏ��s�����ꍇ
     */
    public void execute() throws KKHException {
        ReportMacLicenseeManager manager = ReportMacLicenseeManager.getInstance();
        ReportMacLicenseeResult result = manager.findByCondition(_condition);
        getResult().set(RESULT_KEY, result);
    }

    /**
     * ����������ݒ肵�܂��B
     *
     * @param condition CommonCodeMasterSearchCondition ��������
     */
    public void setFindReportMacLicenseeCondition(ReportMacCondition condition) {
        _condition = condition;
    }

    /**
     * �����������ʂ�Ԃ��܂��B
     *
     * @return ReportMacResult ������������
     */
    public ReportMacLicenseeResult getReportMacLicenseeResult() {
        return (ReportMacLicenseeResult) super.getResult().get(RESULT_KEY);
    }

}

package jp.co.isid.kkh.customer.mac.controller.report;

import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.customer.mac.model.report.ReportMacCondition;
import jp.co.isid.kkh.customer.mac.model.report.ReportMacManager;
import jp.co.isid.kkh.customer.mac.model.report.ReportMacResult;
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
public class FindReportMacByCondCmd extends Command {

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
        ReportMacManager manager = ReportMacManager.getInstance();
        ReportMacResult result = manager.findByCondition(_condition);
        getResult().set(RESULT_KEY, result);
    }

    /**
     * ����������ݒ肵�܂��B
     *
     * @param condition CommonCodeMasterSearchCondition ��������
     */
    public void setFindReportMacCondition(ReportMacCondition condition) {
        _condition = condition;
    }

    /**
     * �����������ʂ�Ԃ��܂��B
     *
     * @return ReportMacResult ������������
     */
    public ReportMacResult getReportMacResult() {
        return (ReportMacResult) super.getResult().get(RESULT_KEY);
    }

}

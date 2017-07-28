package jp.co.isid.kkh.customer.ash.controller.report;

import jp.co.isid.kkh.customer.ash.model.report.ReportAshMediaCondition;
import jp.co.isid.kkh.customer.ash.model.report.ReportAshMediaChklstManager;
import jp.co.isid.kkh.customer.ash.model.report.ReportAshMediaChklstResult;
import jp.co.isid.kkh.model.base.KKHException;

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
public class ReportAshMediaChklstByCondCmd extends Command {

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
        ReportAshMediaChklstManager manager = ReportAshMediaChklstManager.getInstance();
        ReportAshMediaChklstResult result = manager.findByCondition(_condition);
        getResult().set(RESULT_KEY, result);
    }

    /**
     * ����������ݒ肵�܂��B
     *
     * @param condition CommonCodeMasterSearchCondition ��������
     */
    public void setFindReportAshMediaChklstCondition(ReportAshMediaCondition condition) {
        _condition = condition;
    }

    /**
     * �����������ʂ�Ԃ��܂��B
     *
     * @return ReportMacResult ������������
     */
    public ReportAshMediaChklstResult getReportAshMediaChklstResult() {
        return (ReportAshMediaChklstResult) super.getResult().get(RESULT_KEY);
    }

}

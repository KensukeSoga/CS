package jp.co.isid.kkh.customer.ash.controller.report;

import jp.co.isid.kkh.customer.ash.model.report.ReportAshMediaCodeManager;
import jp.co.isid.kkh.customer.ash.model.report.ReportAshMediaCodeResult;
import jp.co.isid.kkh.customer.ash.model.report.ReportAshMediaCondition;

import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * MAC�����R�}���h
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2011/1/23 fourm h.izawa)<BR>
 * </P>
 * @author
 */
public class ReportAshMediaCodeByCondCmd extends Command {

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
        ReportAshMediaCodeManager manager = ReportAshMediaCodeManager.getInstance();
        ReportAshMediaCodeResult result = manager.findByCondition(_condition);
        getResult().set(RESULT_KEY, result);
    }

    /**
     * ����������ݒ肵�܂��B
     *
     * @param condition CommonCodeMasterSearchCondition ��������
     */
    public void setFindReportAshMediaCondition(ReportAshMediaCondition condition) {
        _condition = condition;
    }

    /**
     * �����������ʂ�Ԃ��܂��B
     *
     * @return ReportMacResult ������������
     */
    public ReportAshMediaCodeResult getReportAshMediaCodeResult() {
        return (ReportAshMediaCodeResult) super.getResult().get(RESULT_KEY);
    }

}

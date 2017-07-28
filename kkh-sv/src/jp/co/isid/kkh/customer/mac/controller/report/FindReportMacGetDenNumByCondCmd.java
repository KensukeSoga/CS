package jp.co.isid.kkh.customer.mac.controller.report;

import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.customer.mac.model.report.ReportMacGetDenNumCondition;
import jp.co.isid.kkh.customer.mac.model.report.ReportMacGetDenNumManager;
import jp.co.isid.kkh.customer.mac.model.report.ReportMacGetDenNumResult;
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
public class FindReportMacGetDenNumByCondCmd extends Command {

    private static final long serialVersionUID = 1L;

    /** �������ʃL�[ */
    private static final String RESULT_KEY = "RESULT_KEY";

    /** �������� */
    private ReportMacGetDenNumCondition _condition;

    /**
     * �����������g�p���A�������������s���܂��B
     * @throws KKHException �����Ɏ��s�����ꍇ
     */
    public void execute() throws KKHException {
        ReportMacGetDenNumManager manager = ReportMacGetDenNumManager.getInstance();
        ReportMacGetDenNumResult result = manager.findByCondition(_condition);
        getResult().set(RESULT_KEY, result);
    }

    /**
     * ����������ݒ肵�܂��B
     *
     * @param condition CommonCodeMasterSearchCondition ��������
     */
    public void setFindReportMacGetDenNumCondition(ReportMacGetDenNumCondition condition) {
        _condition = condition;
    }

    /**
     * �����������ʂ�Ԃ��܂��B
     *
     * @return ReportMacResult ������������
     */
    public ReportMacGetDenNumResult getReportMacGetDenNumResult() {
        return (ReportMacGetDenNumResult) super.getResult().get(RESULT_KEY);
    }

}

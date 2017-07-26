package jp.co.isid.kkh.customer.toh.controller.report;

import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.customer.toh.model.report.ReportTohCondition;
import jp.co.isid.kkh.customer.toh.model.report.ReportTohManager;
import jp.co.isid.kkh.customer.toh.model.report.ReportTohResult;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * �ėp�}�X�^�����R�}���h
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2011/11/07 JSE K.Fukuda)<BR>
 * </P>
 * @author
 */
public class FindReportTohByCondCmd extends Command {

    private static final long serialVersionUID = 1L;

    /** �������ʃL�[ */
    private static final String RESULT_KEY = "RESULT_KEY";

    /** �������� */
    private ReportTohCondition _condition;

    /**
     * �����������g�p���A�������������s���܂��B
     * @throws KKHException �����Ɏ��s�����ꍇ
     */
    public void execute() throws KKHException {
        ReportTohManager manager = ReportTohManager.getInstance();
        ReportTohResult result = manager.findByCondition(_condition);
        getResult().set(RESULT_KEY, result);
    }

    /**
     * ����������ݒ肵�܂��B
     *
     * @param condition CommonCodeMasterSearchCondition ��������
     */
    public void setFindReportTohCondition(ReportTohCondition condition) {
        _condition = condition;
    }

    /**
     * �����������ʂ�Ԃ��܂��B
     *
     * @return ReportTohResult ������������
     */
    public ReportTohResult getReportTohResult() {
        return (ReportTohResult) super.getResult().get(RESULT_KEY);
    }

}

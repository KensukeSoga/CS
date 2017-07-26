package jp.co.isid.kkh.customer.toh.controller.report;

import jp.co.isid.kkh.customer.toh.model.report.ReportTohTotalCondition;
import jp.co.isid.kkh.customer.toh.model.report.ReportTohTotalManager;
import jp.co.isid.kkh.customer.toh.model.report.ReportTohTotalResult;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * �ėp�}�X�^�����R�}���h
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/02/22 JSE T.Kobayashi)<BR>
 * </P>
 * @author
 */
public class FindReportTohTotalByCondCmd extends Command {

    private static final long serialVersionUID = 1L;

    /** �������ʃL�[ */
    private static final String RESULT_KEY = "RESULT_KEY";

    /** �������� */
    private ReportTohTotalCondition _condition;

    /**
     * �����������g�p���A�������������s���܂��B
     * @throws KKHException �����Ɏ��s�����ꍇ
     */
    public void execute() throws KKHException {
        ReportTohTotalManager manager = ReportTohTotalManager.getInstance();
        ReportTohTotalResult result = manager.findByCondition(_condition);
        getResult().set(RESULT_KEY, result);
    }

    /**
     * ����������ݒ肵�܂��B
     *
     * @param condition CommonCodeMasterSearchCondition ��������
     */
    public void setFindReportTohTotalCondition(ReportTohTotalCondition condition) {
        _condition = condition;
    }

    /**
     * �����������ʂ�Ԃ��܂��B
     *
     * @return ReportTohResult ������������
     */
    public ReportTohTotalResult getReportTohTotalResult() {
        return (ReportTohTotalResult) super.getResult().get(RESULT_KEY);
    }

}

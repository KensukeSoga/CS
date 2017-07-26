package jp.co.isid.kkh.customer.epson.controller.report;

import jp.co.isid.kkh.customer.epson.model.report.ReportEpsonSubMissionCondition;
import jp.co.isid.kkh.customer.epson.model.report.ReportEpsonSubMissionManager;
import jp.co.isid.kkh.customer.epson.model.report.ReportEpsonSubMissionResult;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * ��o���[��񌟍��R�}���h
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/3/5 JSE YS)<BR>
 * </P>
 *
 * @author
 */
public class FindReportEpsonSubMissionByCondCmd extends Command {

    /** */
    private static final long serialVersionUID = 1L;

    /** �������ʃL�[ */
    private static final String RESULT_KEY = "RESULT_KEY";

    /** �������� */
    private ReportEpsonSubMissionCondition _condition;

    /**
     * �����������g�p���A�������������s���܂��B
     * @throws KKHException �����Ɏ��s�����ꍇ
     */
    public void execute() throws KKHException {
        ReportEpsonSubMissionManager manager = ReportEpsonSubMissionManager.getInstance();
        ReportEpsonSubMissionResult result = manager.findByCondition(_condition);
        getResult().set(RESULT_KEY, result);
    }

    /**
     * ����������ݒ肵�܂��B
     *
     * @param condition ReportEpsonSubMissionCondition ��������
     */
    public void setFindReportEpsonSubMissionCondition(ReportEpsonSubMissionCondition condition) {
        _condition = condition;
    }

    /**
     * �����������ʂ�Ԃ��܂��B
     *
     * @return ReportEpsonSubMissionResult ������������
     */
    public ReportEpsonSubMissionResult getReportEpsonSubMissionResult() {
        return (ReportEpsonSubMissionResult) super.getResult().get(RESULT_KEY);
    }
}

package jp.co.isid.kkh.customer.kmn.controller.report;

import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.customer.kmn.model.report.ReportKmnListCondition;
import jp.co.isid.kkh.customer.kmn.model.report.ReportKmnListManager;
import jp.co.isid.kkh.customer.kmn.model.report.ReportKmnListResult;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * ���[�i����_�����ꗗ�j�f�[�^�����R�}���h
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2013/1/31 JSE A.Naito)<BR>
 * </P>
 *
 * @author JSE A.Naito
 */
public class FindReportKmnListByCondCmd extends Command {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /** �������ʃL�[ */
    private static final String RESULT_KEY = "RESULT_KEY";

    /** �������� */
    private ReportKmnListCondition _condition;

    /**
     * �����������g�p���A���[�i����_�����ꗗ�j�f�[�^�������������s���܂��B
     *
     * @throws KKHException
     *             �����Ɏ��s�����ꍇ
     */
    public void execute() throws KKHException {
        ReportKmnListManager manager = ReportKmnListManager.getInstance();
        ReportKmnListResult result = manager.findByCondition(_condition);
        getResult().set(RESULT_KEY, result);
    }

    /**
     * ����������ݒ肵�܂��B
     *
     * @param condition
     *            setReportKmnListCondition ��������
     */
    public void setReportKmnListCondition(ReportKmnListCondition condition) {
        _condition = condition;
    }

    /**
     * ���[�i����_�����ꗗ�j�f�[�^�������ʂ�Ԃ��܂��B
     *
     * @return ReportUniResult ������������
     */
    public ReportKmnListResult getReportKmnListResult() {
        return (ReportKmnListResult) super.getResult().get(RESULT_KEY);
    }
}

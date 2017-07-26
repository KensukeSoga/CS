package jp.co.isid.kkh.customer.kmn.controller.report;

import jp.co.isid.kkh.customer.kmn.model.report.ReportKmnCondition;
import jp.co.isid.kkh.customer.kmn.model.report.ReportKmnManager;
import jp.co.isid.kkh.customer.kmn.model.report.ReportKmnResult;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * ���[�i����_�`�[�j�f�[�^�����R�}���h
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2013/01/30 JSE M.Naito)<BR>
 * </P>
 *
 * @author JSE M.Naito
 */
public class FindReportKmnByCondCmd extends Command {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /** �������ʃL�[ */
    private static final String RESULT_KEY = "RESULT_KEY";

    /** �������� */
    private ReportKmnCondition _condition;

    /**
     * �����������g�p���A ���[�i����_�`�[�j�f�[�^�������������s���܂��B
     *
     * @throws KKHException
     *         �����Ɏ��s�����ꍇ
     */
    public void execute() throws KKHException {
    	ReportKmnManager manager = ReportKmnManager.getInstance();
    	ReportKmnResult result = manager.findReportKmnByCondition(_condition);
        getResult().set(RESULT_KEY, result);
    }

    /**
     * ����������ݒ肵�܂��B
     *
     * @param condition
     *        ReportUniCondition ��������
     */
    public void setReportKmnCondition(ReportKmnCondition condition) {
        _condition = condition;
    }

    /**
     * ���[�i����_�`�[�j�f�[�^�������ʂ�Ԃ��܂��B
     *
     * @return ReportUniResult ������������
     */
    public ReportKmnResult getReportKmnResult() {
        return (ReportKmnResult) super.getResult().get(RESULT_KEY);
    }
}

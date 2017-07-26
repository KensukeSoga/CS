package jp.co.isid.kkh.customer.uni.controller.report;

import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.customer.uni.model.report.ReportUniCondition;
import jp.co.isid.kkh.customer.uni.model.report.ReportUniManager;
import jp.co.isid.kkh.customer.uni.model.report.ReportUniResult;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * ���[�i���j�`���[��_�L����ו\�j�f�[�^�����R�}���h
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/1/23 JSE Y.Sato)<BR>
 * </P>
 *
 * @author JSE Y.Sato
 */
public class FindReportUniByCondCmd extends Command {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /** �������ʃL�[ */
    private static final String RESULT_KEY = "RESULT_KEY";

    /** �������� */
    private ReportUniCondition _condition;

    /**
     * �����������g�p���A ���[�i���j�`���[��_�L����ו\�j�f�[�^�������������s���܂��B
     *
     * @throws KKHException
     *             �����Ɏ��s�����ꍇ
     */
    public void execute() throws KKHException {
    	ReportUniManager manager = ReportUniManager.getInstance();
    	ReportUniResult result = manager.findReportUniByCondition(_condition);
        getResult().set(RESULT_KEY, result);
    }

    /**
     * ����������ݒ肵�܂��B
     *
     * @param condition
     *            ReportUniCondition ��������
     */
    public void setReportUniCondition(ReportUniCondition condition) {
        _condition = condition;
    }

    /**
     * ���[�i���j�`���[��_�L����ו\�j�f�[�^�������ʂ�Ԃ��܂��B
     *
     * @return ReportUniResult ������������
     */
    public ReportUniResult getReportUniResult() {
        return (ReportUniResult) super.getResult().get(RESULT_KEY);
    }
}

package jp.co.isid.kkh.customer.skyp.controller.report;

import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.customer.skyp.model.report.ReportSkypCondition;
import jp.co.isid.kkh.customer.skyp.model.report.ReportSkypManager;
import jp.co.isid.kkh.customer.skyp.model.report.ReportSkypResult;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * ���[�i�X�J�p�[_�[�i�^�������j�f�[�^�����R�}���h
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/1/16 JSE Y.Sato)<BR>
 * </P>
 *
 * @author JSE Y.Sato
 */
public class FindReportSkypByCondCmd extends Command {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /** �������ʃL�[ */
    private static final String RESULT_KEY = "RESULT_KEY";

    /** �������� */
    private ReportSkypCondition _condition;

    /**
     * �����������g�p���A ���[�i�X�J�p�[_�[�i�^�������j�f�[�^�������������s���܂��B
     *
     * @throws KKHException
     *             �����Ɏ��s�����ꍇ
     */
    public void execute() throws KKHException {
    	ReportSkypManager manager = ReportSkypManager.getInstance();
    	ReportSkypResult result = manager.findReportSkypByCondition(_condition);
        getResult().set(RESULT_KEY, result);
    }

    /**
     * ����������ݒ肵�܂��B
     *
     * @param condition
     *            ReportSkypCondition ��������
     */
    public void setReportSkypCondition(ReportSkypCondition condition) {
        _condition = condition;
    }

    /**
     * ���[�i�X�J�p�[_�[�i�^�������j�f�[�^�������ʂ�Ԃ��܂��B
     *
     * @return ReportSkypResult ������������
     */
    public ReportSkypResult getReportSkypResult() {
        return (ReportSkypResult) super.getResult().get(RESULT_KEY);
    }
}

package jp.co.isid.kkh.customer.lion.controller.report;

import jp.co.isid.kkh.customer.lion.model.report.NewReportLionCondition;
import jp.co.isid.kkh.customer.lion.model.report.NewReportLionManager;
import jp.co.isid.kkh.customer.lion.model.report.NewReportLionResult;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * ���C�I�����Ϗ��f�[�^�����R�}���h
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/03/06)<BR>
 * </P>
 *
 * @author
 */
public class FindNewReportLionByCondCmd extends Command {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /** �������ʃL�[ */
    private static final String RESULT_KEY = "RESULT_KEY";

    /** �������� */
    private NewReportLionCondition _condition;

    /**
     * �����������g�p���A�������������s���܂��B
     * @throws KKHException �����Ɏ��s�����ꍇ
     */
    public void execute() throws KKHException {
        NewReportLionManager manager = NewReportLionManager.getInstance();
        NewReportLionResult result = manager.findByCondition(_condition);
        getResult().set(RESULT_KEY, result);
    }

    /**
     * ����������ݒ肵�܂��B
     *
     * @param condition CommonCodeMasterSearchCondition ��������
     */
    public void setFindReportLionCondition(NewReportLionCondition condition) {
        _condition = condition;
    }

    /**
     * �����������ʂ�Ԃ��܂��B
     *
     * @return ReportLionResult ������������
     */
    public NewReportLionResult getReportLionResult() {
        return (NewReportLionResult) super.getResult().get(RESULT_KEY);
    }

}

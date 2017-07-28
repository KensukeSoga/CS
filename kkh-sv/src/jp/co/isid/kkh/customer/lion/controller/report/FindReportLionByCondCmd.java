package jp.co.isid.kkh.customer.lion.controller.report;
import jp.co.isid.kkh.customer.lion.model.report.ReportLionCondition;
import jp.co.isid.kkh.customer.lion.model.report.ReportLionManager;
import jp.co.isid.kkh.customer.lion.model.report.ReportLionResult;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * ���C�I���v���[�t���X�g�����R�}���h
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/01/11)<BR>
 * </P>
 *
 * @author
 */
public class FindReportLionByCondCmd extends Command{

    private static final long serialVersionUID = 1L;

    /** �������ʃL�[ */
    private static final String RESULT_KEY = "RESULT_KEY";

    /** �������� */
    private ReportLionCondition _condition;

    /**
     * �����������g�p���A�������������s���܂��B
     * @throws KKHException �����Ɏ��s�����ꍇ
     */
    public void execute() throws KKHException {
        ReportLionManager manager = ReportLionManager.getInstance();
        ReportLionResult result = manager.findByCondition(_condition);
        getResult().set(RESULT_KEY, result);
    }

    /**
     * ����������ݒ肵�܂��B
     *
     * @param condition CommonCodeMasterSearchCondition ��������
     */
    public void setFindReportLionCondition(ReportLionCondition condition) {
        _condition = condition;
    }

    /**
     * �����������ʂ�Ԃ��܂��B
     *
     * @return ReportLionResult ������������
     */
    public ReportLionResult getReportLionResult() {
        return (ReportLionResult) super.getResult().get(RESULT_KEY);
    }

}

package jp.co.isid.kkh.customer.acom.controller.report;
import jp.co.isid.kkh.customer.acom.model.report.ReportAcomCondition;
import jp.co.isid.kkh.customer.acom.model.report.ReportAcomManager;
import jp.co.isid.kkh.customer.acom.model.report.ReportAcomResult;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * �A�R�������R�}���h
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/01/11)<BR>
 * </P>
 * @author
 */
public class FindReportAcomByCondCmd extends Command{
    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/** �������ʃL�[ */
    private static final String RESULT_KEY = "RESULT_KEY";

    /** �������� */
    private ReportAcomCondition _condition;

    /**
     * �����������g�p���A�������������s���܂��B
     * @throws KKHException �����Ɏ��s�����ꍇ
     */
    public void execute() throws KKHException {
    	ReportAcomManager manager = ReportAcomManager.getInstance();
    	ReportAcomResult result = manager.findByCondition(_condition);
        getResult().set(RESULT_KEY, result);
    }

    /**
     * ����������ݒ肵�܂��B
     *
     * @param condition CommonCodeMasterSearchCondition ��������
     */
    public void setFindReportAcomCondition(ReportAcomCondition condition) {
        _condition = condition;
    }

    /**
     * �����������ʂ�Ԃ��܂��B
     *
     * @return ReportAcomResult ������������
     */
    public ReportAcomResult getReportAcomResult() {
        return (ReportAcomResult) super.getResult().get(RESULT_KEY);
    }

}

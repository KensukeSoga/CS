package jp.co.isid.kkh.customer.lion.controller.report;
import jp.co.isid.kkh.customer.lion.model.report.DetailListLionCondition;
import jp.co.isid.kkh.customer.lion.model.report.DetailListLionManager;
import jp.co.isid.kkh.customer.lion.model.report.DetailListLionResult;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * ���C�I�����׈ꗗ�����R�}���h
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2013/02/01)<BR>
 * </P>
 * @author
 */
public class FindDetailListLionByCondCmd extends Command{
    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/** �������ʃL�[ */
    private static final String RESULT_KEY = "RESULT_KEY";

    /** �������� */
    private DetailListLionCondition _condition;

    /**
     * �����������g�p���A�������������s���܂��B
     * @throws KKHException �����Ɏ��s�����ꍇ
     */
    public void execute() throws KKHException {
        DetailListLionManager manager = DetailListLionManager.getInstance();
        DetailListLionResult result = manager.findByCondition(_condition);
        getResult().set(RESULT_KEY, result);
    }

    /**
     * ����������ݒ肵�܂��B
     *
     * @param condition CommonCodeMasterSearchCondition ��������
     */
    public void setFindDetailListLionCondition(DetailListLionCondition condition) {
        _condition = condition;
    }

    /**
     * �����������ʂ�Ԃ��܂��B
     *
     * @return ReportLionResult ������������
     */
    public DetailListLionResult getDetailListLionResult() {
        return (DetailListLionResult) super.getResult().get(RESULT_KEY);
    }

}

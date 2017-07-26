package jp.co.isid.kkh.customer.lion.controller.report;

import jp.co.isid.kkh.customer.lion.model.report.FDLionCondition;
import jp.co.isid.kkh.customer.lion.model.report.FDLionManager;
import jp.co.isid.kkh.customer.lion.model.report.FDLionResult;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * ���C�I��FD�o�̓f�[�^�擾�R�}���h
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/01/23 JSE H.Sasaki)<BR>
 * </P>
 *
 * @author
 */
public class FindFDLionByCondCmd extends Command {

    private static final long serialVersionUID = 1L;

    /** �������ʃL�[ */
    private static final String RESULT_KEY = "RESULT_KEY";

    /** �������� */
    private FDLionCondition _condition;

    /**
     * �����������g�p���A�������������s���܂��B
     *
     * @throws KKHException
     *             �����Ɏ��s�����ꍇ
     */
    public void execute() throws KKHException {
        FDLionManager manager = FDLionManager.getInstance();
        FDLionResult result = manager.findByCondition(_condition);
        getResult().set(RESULT_KEY, result);
    }

    /**
     * ����������ݒ肵�܂��B
     *
     * @param condition
     *            CommonCodeMasterSearchCondition ��������
     */
    public void setFindFDLionCondition(FDLionCondition condition) {
        _condition = condition;
    }

    /**
     * �����������ʂ�Ԃ��܂��B
     *
     * @return ReportTohResult ������������
     */
    public FDLionResult getFindFDLionResult() {
        return (FDLionResult) super.getResult().get(RESULT_KEY);
    }

}

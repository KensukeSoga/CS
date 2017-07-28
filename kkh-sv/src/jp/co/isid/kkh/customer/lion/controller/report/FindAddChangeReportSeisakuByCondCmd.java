package jp.co.isid.kkh.customer.lion.controller.report;

import jp.co.isid.kkh.customer.lion.model.report.AddChangeReportLionSeisakuCondition;
import jp.co.isid.kkh.customer.lion.model.report.AddChangeReportLionSeisakuManager;
import jp.co.isid.kkh.customer.lion.model.report.AddChangeReportLionSeisakuResult;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * ���C�I�����[(���쎺���X�g)�����R�}���h
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2014/07/31 HLC S.Fujimoto)<BR>
 * </P>
 *
 * @author HLC S.Fujimoto
 */
public class FindAddChangeReportSeisakuByCondCmd extends Command{

    private static final long serialVersionUID = 1L;

    /** �������ʃL�[ */
    private static final String RESULT_KEY = "RESULT_KEY";

    /** �������� */
    private AddChangeReportLionSeisakuCondition _condition;

    /**
     * �����������g�p���A�������������s���܂��B
     * @throws KKHException �����Ɏ��s�����ꍇ
     */
    public void execute() throws KKHException {
        AddChangeReportLionSeisakuManager manager = AddChangeReportLionSeisakuManager.getInstance();
        AddChangeReportLionSeisakuResult result = manager.findByCondition(_condition);
        getResult().set(RESULT_KEY, result);
    }

    /**
     * ����������ݒ肵�܂��B
     *
     * @param condition CommonCodeMasterSearchCondition ��������
     */
    public void setFindAddChangeReportCondition(AddChangeReportLionSeisakuCondition condition) {
        _condition = condition;
    }

    /**
     * �����������ʂ�Ԃ��܂��B
     *
     * @return ReportLionResult ������������
     */
    public AddChangeReportLionSeisakuResult getAddChangeReportResult() {
        return (AddChangeReportLionSeisakuResult) super.getResult().get(RESULT_KEY);
    }

}

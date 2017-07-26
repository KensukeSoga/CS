package jp.co.isid.kkh.customer.lion.controller.report;

import jp.co.isid.kkh.customer.lion.model.report.AddChangeReportLionBaitaiCondition;
import jp.co.isid.kkh.customer.lion.model.report.AddChangeReportLionBaitaiManager;
import jp.co.isid.kkh.customer.lion.model.report.AddChangeReportLionBaitaiResult;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * ���C�I�����[(�ǉ��ύX���X�g)�����R�}���h
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2014/07/31 HLC S.Fujimoto)<BR>
 * </P>
 *
 * @author HLC S.Fujimoto
 */
public class FindAddChangeReportBaitaiByCondCmd extends Command{

    private static final long serialVersionUID = 1L;

    /** �������ʃL�[ */
    private static final String RESULT_KEY = "RESULT_KEY";

    /** �������� */
    private AddChangeReportLionBaitaiCondition _condition;

    /**
     * �����������g�p���A�������������s���܂��B
     * @throws KKHException �����Ɏ��s�����ꍇ
     */
    public void execute() throws KKHException {
        AddChangeReportLionBaitaiManager manager = AddChangeReportLionBaitaiManager.getInstance();
        AddChangeReportLionBaitaiResult result = manager.findByCondition(_condition);
        getResult().set(RESULT_KEY, result);
    }

    /**
     * ����������ݒ肵�܂��B
     *
     * @param condition CommonCodeMasterSearchCondition ��������
     */
    public void setFindAddChangeReportCondition(AddChangeReportLionBaitaiCondition condition) {
        _condition = condition;
    }

    /**
     * �����������ʂ�Ԃ��܂��B
     *
     * @return ReportLionResult ������������
     */
    public AddChangeReportLionBaitaiResult getAddChangeReportResult() {
        return (AddChangeReportLionBaitaiResult) super.getResult().get(RESULT_KEY);
    }

}

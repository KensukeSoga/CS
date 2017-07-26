package jp.co.isid.kkh.customer.lion.controller.detail;

import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.customer.lion.model.detail.FindLionCodeItrCondition;
import jp.co.isid.kkh.customer.lion.model.detail.FindLionCodeItrManager;
import jp.co.isid.kkh.customer.lion.model.detail.FindLionCodeItrResult;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * �R�[�h�ꗗ�����R�}���h
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/02/27 JSE A.Naito)<BR>
 * </P>
 * @author  JSE A.Naito
 */
public class FindLionCodeItrCmd extends Command {

    private static final long serialVersionUID = 1L;

    /** �������ʃL�[ */
    private static final String RESULT_KEY = "RESULT_KEY";

    /** �������� */
    private FindLionCodeItrCondition _condition;

    /**
     * �����������g�p���A�������������s���܂��B
     * @throws KKHException �����Ɏ��s�����ꍇ
     */
    public void execute() throws KKHException {
        FindLionCodeItrManager manager = FindLionCodeItrManager.getInstance();
        FindLionCodeItrResult result = manager.findLionCodeItrByCondition(_condition);
        getResult().set(RESULT_KEY, result);
    }

    /**
     * ����������ݒ肵�܂��B
     *
     * @param condition CommonCodeMasterSearchCondition ��������
     */
    public void setFindLionCodeItrCondition(FindLionCodeItrCondition condition) {
        _condition = condition;
    }

    /**
     * �����������ʂ�Ԃ��܂��B
     *
     * @return FindRdKMastResult ������������
     */
    public FindLionCodeItrResult getFindLionCodeItrResult() {
        return (FindLionCodeItrResult) super.getResult().get(RESULT_KEY);
    }

}

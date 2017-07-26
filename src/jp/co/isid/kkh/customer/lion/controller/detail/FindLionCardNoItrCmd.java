package jp.co.isid.kkh.customer.lion.controller.detail;

import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.customer.lion.model.detail.FindLionCardNoItrCondition;
import jp.co.isid.kkh.customer.lion.model.detail.FindLionCardNoItrManager;
import jp.co.isid.kkh.customer.lion.model.detail.FindLionCardNoItrResult;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * FindRdKMast�����R�}���h
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/02/21 JSE A.Naito)<BR>
 * </P>
 * @author  JSE A.Naito
 */
public class FindLionCardNoItrCmd extends Command {

    private static final long serialVersionUID = 1L;

    /** �������ʃL�[ */
    private static final String RESULT_KEY = "RESULT_KEY";

    /** �������� */
    private FindLionCardNoItrCondition _condition;

    /**
     * �����������g�p���A�������������s���܂��B
     * @throws KKHException �����Ɏ��s�����ꍇ
     */
    public void execute() throws KKHException {
        FindLionCardNoItrManager manager = FindLionCardNoItrManager.getInstance();
        FindLionCardNoItrResult result = manager.findLionCardNoItrByCondition(_condition);
        getResult().set(RESULT_KEY, result);
    }

    /**
     * ����������ݒ肵�܂��B
     *
     * @param condition CommonCodeMasterSearchCondition ��������
     */
    public void setFindLionCardNoItrCondition(FindLionCardNoItrCondition condition) {
        _condition = condition;
    }

    /**
     * �����������ʂ�Ԃ��܂��B
     *
     * @return FindRdKMastResult ������������
     */
    public FindLionCardNoItrResult getFindLionCardNoItrResult() {
        return (FindLionCardNoItrResult) super.getResult().get(RESULT_KEY);
    }

}

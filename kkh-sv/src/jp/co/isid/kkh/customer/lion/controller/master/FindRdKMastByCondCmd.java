package jp.co.isid.kkh.customer.lion.controller.master;

import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.customer.lion.model.master.FindRdKMastCondition;
import jp.co.isid.kkh.customer.lion.model.master.FindRdKMastResult;
import jp.co.isid.kkh.customer.lion.model.master.LionManager;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * FindRdKMast�����R�}���h
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/02/20 JSE A.Naito)<BR>
 * </P>
 * @author  JSE A.Naito
 */
public class FindRdKMastByCondCmd extends Command {

    private static final long serialVersionUID = 1L;

    /** �������ʃL�[ */
    private static final String RESULT_KEY = "RESULT_KEY";

    /** �������� */
    private FindRdKMastCondition _condition;

    /**
     * �����������g�p���A�������������s���܂��B
     * @throws KKHException �����Ɏ��s�����ꍇ
     */
    public void execute() throws KKHException {
        LionManager manager = LionManager.getInstance();
        FindRdKMastResult result = manager.findRdKMastByCondition(_condition);
        getResult().set(RESULT_KEY, result);
    }

    /**
     * ����������ݒ肵�܂��B
     *
     * @param condition CommonCodeMasterSearchCondition ��������
     */
    public void setFindRdKMastCondition(FindRdKMastCondition condition) {
        _condition = condition;
    }

    /**
     * �����������ʂ�Ԃ��܂��B
     *
     * @return FindRdKMastResult ������������
     */
    public FindRdKMastResult getFindRdKMastResult() {
        return (FindRdKMastResult) super.getResult().get(RESULT_KEY);
    }

}

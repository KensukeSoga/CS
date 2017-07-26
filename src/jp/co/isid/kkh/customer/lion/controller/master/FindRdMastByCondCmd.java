package jp.co.isid.kkh.customer.lion.controller.master;

import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.customer.lion.model.master.FindRdMastCondition;
import jp.co.isid.kkh.customer.lion.model.master.FindRdMastResult;
import jp.co.isid.kkh.customer.lion.model.master.LionManager;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * FindRdMast�����R�}���h
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/02/17 JSE A.Naito)<BR>
 * </P>
 * @author JSE A.Naito
 */
public class FindRdMastByCondCmd extends Command {

    private static final long serialVersionUID = 1L;

    /** �������ʃL�[ */
    private static final String RESULT_KEY = "RESULT_KEY";

    /** �������� */
    private FindRdMastCondition _condition;

    /**
     * �����������g�p���A�������������s���܂��B
     * @throws KKHException �����Ɏ��s�����ꍇ
     */
    public void execute() throws KKHException {
        LionManager manager = LionManager.getInstance();
        FindRdMastResult result = manager.findRdMastByCondition(_condition);
        getResult().set(RESULT_KEY, result);
    }

    /**
     * ����������ݒ肵�܂��B
     *
     * @param condition CommonCodeMasterSearchCondition ��������
     */
    public void setFindRdMastCondition(FindRdMastCondition condition) {
        _condition = condition;
    }

    /**
     * �����������ʂ�Ԃ��܂��B
     *
     * @return FindTvMastResult ������������
     */
    public FindRdMastResult getFindRdMastResult() {
        return (FindRdMastResult) super.getResult().get(RESULT_KEY);
    }

}

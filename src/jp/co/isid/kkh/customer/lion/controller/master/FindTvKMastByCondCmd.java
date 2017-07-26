package jp.co.isid.kkh.customer.lion.controller.master;

import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.customer.lion.model.master.FindTvKMastCondition;
import jp.co.isid.kkh.customer.lion.model.master.FindTvKMastResult;
import jp.co.isid.kkh.customer.lion.model.master.LionManager;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * FindTvKMast�����R�}���h
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/02/17 JSE A.Naito)<BR>
 * </P>
 * @author  JSE A.Naito
 */
public class FindTvKMastByCondCmd extends Command {

    private static final long serialVersionUID = 1L;

    /** �������ʃL�[ */
    private static final String RESULT_KEY = "RESULT_KEY";

    /** �������� */
    private FindTvKMastCondition _condition;

    /**
     * �����������g�p���A�������������s���܂��B
     * @throws KKHException �����Ɏ��s�����ꍇ
     */
    public void execute() throws KKHException {
        LionManager manager = LionManager.getInstance();
        FindTvKMastResult result = manager.findTvKMastByCondition(_condition);
        getResult().set(RESULT_KEY, result);
    }

    /**
     * ����������ݒ肵�܂��B
     *
     * @param condition CommonCodeMasterSearchCondition ��������
     */
    public void setFindTvKMastCondition(FindTvKMastCondition condition) {
        _condition = condition;
    }

    /**
     * �����������ʂ�Ԃ��܂��B
     *
     * @return FindTvKMastResult ������������
     */
    public FindTvKMastResult getFindTvKMastResult() {
        return (FindTvKMastResult) super.getResult().get(RESULT_KEY);
    }

}

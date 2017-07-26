package jp.co.isid.kkh.customer.lion.controller.master;

import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.customer.lion.model.master.LionManager;
import jp.co.isid.kkh.customer.lion.model.master.LionZashiRyoSpcMastCondition;
import jp.co.isid.kkh.customer.lion.model.master.LionZashiRyoSpcMastResult;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * FindRdKMast�����R�}���h
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/03/02 JSE A.Naito)<BR>
 * </P>
 * @author  JSE A.Naito
 */
public class LionZashiRyoSpcMastCmd extends Command {

    private static final long serialVersionUID = 1L;

    /** �������ʃL�[ */
    private static final String RESULT_KEY = "RESULT_KEY";

    /** �������� */
    private LionZashiRyoSpcMastCondition _condition;

    /**
     * �����������g�p���A�������������s���܂��B
     * @throws KKHException �����Ɏ��s�����ꍇ
     */
    public void execute() throws KKHException {
        LionManager manager = LionManager.getInstance();
        LionZashiRyoSpcMastResult result = manager.lionZashiRyoSpcMastByCondition(_condition);
        getResult().set(RESULT_KEY, result);
    }

    /**
     * ����������ݒ肵�܂��B
     *
     * @param condition CommonCodeMasterSearchCondition ��������
     */
    public void setLionZashiRyoSpcMastCondition(LionZashiRyoSpcMastCondition condition) {
        _condition = condition;
    }

    /**
     * �����������ʂ�Ԃ��܂��B
     *
     * @return FindRdKMastResult ������������
     */
    public LionZashiRyoSpcMastResult getLionZashiRyoSpcMastResult() {
        return (LionZashiRyoSpcMastResult) super.getResult().get(RESULT_KEY);
    }

}

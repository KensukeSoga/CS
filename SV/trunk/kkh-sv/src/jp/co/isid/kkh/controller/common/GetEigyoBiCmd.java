package jp.co.isid.kkh.controller.common;

import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.model.common.EigyoBiCondition;
import jp.co.isid.kkh.model.common.EigyoBiManager;
import jp.co.isid.kkh.model.common.EigyoBiResult;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * �ėp�}�X�^�����R�}���h
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2011/11/07 JSE K.Fukuda)<BR>
 * </P>
 * @author
 */
public class GetEigyoBiCmd extends Command {

    private static final long serialVersionUID = 1L;

    /** �������ʃL�[ */
    private static final String RESULT_KEY = "RESULT_KEY";

    /** �������� */
    private EigyoBiCondition _condition;

    /**
     * �����������g�p���A�������������s���܂��B
     * @throws KKHException �����Ɏ��s�����ꍇ
     */
    public void execute() throws KKHException {
        EigyoBiManager manager = EigyoBiManager.getInstance();
        EigyoBiResult result = manager.getEigyoBi(_condition);
        getResult().set(RESULT_KEY, result);
    }

    /**
     * ����������ݒ肵�܂��B
     *
     * @param condition EigyoBiSearchCondition ��������
     */
    public void setEigyoBiCondition(EigyoBiCondition condition) {
        _condition = condition;
    }

    /**
     * �����������ʂ�Ԃ��܂��B
     *
     * @return MasterResult ������������
     */
    public EigyoBiResult getEigyoBiResult() {
        return (EigyoBiResult) super.getResult().get(RESULT_KEY);
    }

}

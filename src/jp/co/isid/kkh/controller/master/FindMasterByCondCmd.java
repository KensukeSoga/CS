package jp.co.isid.kkh.controller.master;

import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.model.master.MasterCondition;
import jp.co.isid.kkh.model.master.MasterManager;
import jp.co.isid.kkh.model.master.MasterResult;
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
public class FindMasterByCondCmd extends Command {

    private static final long serialVersionUID = 1L;

    /** �������ʃL�[ */
    private static final String RESULT_KEY = "RESULT_KEY";

    /** �������� */
    private MasterCondition _condition;

    /**
     * �����������g�p���A�������������s���܂��B
     * @throws KKHException �����Ɏ��s�����ꍇ
     */
    public void execute() throws KKHException {
        MasterManager manager = MasterManager.getInstance();
        MasterResult result = manager.findByCondition(_condition);
        getResult().set(RESULT_KEY, result);
    }

    /**
     * ����������ݒ肵�܂��B
     *
     * @param condition CommonCodeMasterSearchCondition ��������
     */
    public void setFindMasterCondition(MasterCondition condition) {
        _condition = condition;
    }

    /**
     * �����������ʂ�Ԃ��܂��B
     *
     * @return MasterResult ������������
     */
    public MasterResult getMasterResult() {
        return (MasterResult) super.getResult().get(RESULT_KEY);
    }

}

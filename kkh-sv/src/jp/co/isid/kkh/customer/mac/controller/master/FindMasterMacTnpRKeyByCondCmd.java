package jp.co.isid.kkh.customer.mac.controller.master;


import jp.co.isid.kkh.customer.mac.model.master.FindMasterMacTnpRByCondCondition;
import jp.co.isid.kkh.customer.mac.model.master.FindMasterMacTnpRKeyByCondManager;
import jp.co.isid.kkh.customer.mac.model.master.FindMasterMacTnpRKeyByCondResult;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * �}�N�h�i���h�X�܃}�X�^�����e�[�u���L�[���ڌ����R�}���h
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2013/02/01 JSE H.Okazaki)<BR>
 * </P>
 * @author
 */
public class FindMasterMacTnpRKeyByCondCmd extends Command {

    private static final long serialVersionUID = 1L;

    /** �������ʃL�[ */
    private static final String RESULT_KEY = "RESULT_KEY";

    /** �������� */
    private FindMasterMacTnpRByCondCondition _condition;

    /**
     * �����������g�p���A�������������s���܂��B
     * @throws KKHException �����Ɏ��s�����ꍇ
     */
    public void execute() throws KKHException {
        FindMasterMacTnpRKeyByCondManager manager = FindMasterMacTnpRKeyByCondManager.getInstance();
        FindMasterMacTnpRKeyByCondResult result = manager.findthb17rmtnp(_condition);
        getResult().set(RESULT_KEY, result);
    }

    /**
     * ����������ݒ肵�܂��B
     *
     * @param condition CommonCodeMasterSearchCondition ��������
     */
    public void setFindMasterCondition(FindMasterMacTnpRByCondCondition condition) {
        _condition = condition;
    }

    /**
     * �����������ʂ�Ԃ��܂��B
     *
     * @return MasterResult ������������
     */
    public FindMasterMacTnpRKeyByCondResult getMasterResult() {
        return (FindMasterMacTnpRKeyByCondResult) super.getResult().get(RESULT_KEY);
    }

}

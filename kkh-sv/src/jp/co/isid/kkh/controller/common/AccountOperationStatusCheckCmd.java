package jp.co.isid.kkh.controller.common;

import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.model.common.AccountOperationStatusCondition;
import jp.co.isid.kkh.model.common.AccountOperationStatusManager;
import jp.co.isid.kkh.model.common.AccountOperationStatusResult;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * �Ɩ���v�ғ��󋵃`�F�b�N�R�}���h
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/02/09 JSE H.Abe)<BR>
 * </P>
 *
 * @author
 */
public class AccountOperationStatusCheckCmd extends Command {

    private static final long serialVersionUID = 1L;

    /** �������ʃL�[ */
    private static final String RESULT_KEY = "RESULT_KEY";

    /** �������� */
    private AccountOperationStatusCondition _condition;

    /**
     * �Ɩ���v�ғ��󋵃`�F�b�N�����s���܂��B
     *
     * @throws KKHException �������ɃG���[�����������ꍇ
     */
    public void execute() throws KKHException {
        AccountOperationStatusResult result = new AccountOperationStatusResult();
        AccountOperationStatusManager manager = AccountOperationStatusManager.getInstance();
        boolean managerResult = manager.checkAccountOperationStatus(_condition);
        result.setAccountOperationStatus(managerResult);
        getResult().set(RESULT_KEY, result);
    }

    /**
     * ����������ݒ肵�܂��B
     *
     * @param condition ��������
     */
    public void setAccountOperationStatusCondition(AccountOperationStatusCondition condition) {
        _condition = condition;
    }

    /**
     * ���s���ʂ�Ԃ��܂��B
     *
     * @return ���s����
     */
    public AccountOperationStatusResult getAccountOperationStatusResult() {
        return (AccountOperationStatusResult) super.getResult().get(RESULT_KEY);
    }

}

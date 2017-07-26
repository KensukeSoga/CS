package jp.co.isid.kkh.model.common;

import java.util.List;

import jp.co.isid.kkh.model.base.KKHException;

/**
 * <P>
 * �Ɩ���v�ғ���Manager
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/02/09 JSE H.Abe)<BR>
 * </P>
 *
 * @author
 */
public class AccountOperationStatusManager {

    /** �ғ���ԁF�ғ��� */
    private static String OPERATION_STATUS_ACTIVE = "0";

    /** �V���O���g���C���X�^���X */
    private static AccountOperationStatusManager _manager = new AccountOperationStatusManager();

    /**
     * �V���O���g���ׁ̈A�C���X�^���X�����֎~���܂��B
     */
    private AccountOperationStatusManager() {
    }

    /**
     * �C���X�^���X��Ԃ��܂��B
     *
     * @return �C���X�^���X
     */
    public static AccountOperationStatusManager getInstance() {
        return _manager;
    }

    /**
     * �Ɩ���v�ғ��󋵂��`�F�b�N���܂��B
     *
     * @param cond �Ɩ���v�ғ��󋵌�������
     * @return true�F�ғ����Afalse�F��~��
     * @throws KKHException �������ɃG���[�����������ꍇ
     */
    public boolean checkAccountOperationStatus(AccountOperationStatusCondition cond) throws KKHException {

        AccountOperationStatusDAO dao = AccountOperationStatusDAOFactory.createAccountOperationStatusDAO();

        // �Ɩ���v�ғ��󋵎擾
        List<AccountOperationStatusVO> voList = dao.getAccountOperationStatus(cond);

        if (voList.size() > 0) {
            // �ғ����̏ꍇ
            if (OPERATION_STATUS_ACTIVE.equals(voList.get(0).getKanriFlg())) {
                return true;
            }
        }
        return false;
    }

}

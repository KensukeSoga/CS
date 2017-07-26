package jp.co.isid.kkh.controller.login;

import java.util.ArrayList;
import java.util.List;

import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.model.common.AccountOperationStatusCondition;
import jp.co.isid.kkh.model.common.AccountOperationStatusManager;
import jp.co.isid.kkh.model.common.EigyoBiCondition;
import jp.co.isid.kkh.model.common.EigyoBiManager;
import jp.co.isid.kkh.model.common.EigyoBiResult;
import jp.co.isid.kkh.model.login.LoginInitInfoCondition;
import jp.co.isid.kkh.model.login.LoginInitInfoManager;
import jp.co.isid.kkh.model.login.LoginInitInfoResult;
import jp.co.isid.kkh.model.login.Vkj01AccuserCondition;
import jp.co.isid.kkh.model.login.Vkj01AccuserVO;
import jp.co.isid.kkh.service.base.ErrorInfo;
import jp.co.isid.kkh.util.StringUtil;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * ���O�C���������擾�R�}���h
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/02/13 JSE H.Abe)<BR>
 * </P>
 *
 * @author JSE H.Abe
 */
public class LoginInitInfoGetCmd extends Command {

    private static final long serialVersionUID = 1L;

    /** �������ʃL�[ */
    private static final String RESULT_KEY = "RESULT_KEY";

    /** �������� */
    private LoginInitInfoCondition _condition;

    /**
     * �����������g�p���A�������������s���܂��B
     *
     * @throws KKHException �����Ɏ��s�����ꍇ
     */
    public void execute() throws KKHException {

        // ���̓`�F�b�N
        checkInput();
        // �z�X�g�c�Ɠ��擾
        String eigyoBi = getEigyoBi();
        if (eigyoBi == null) {
            LoginInitInfoResult result = setResultErr("�c�Ɠ��擾�G���[", "HB-W0101");
            getResult().set(RESULT_KEY, result);
            return;
        }

        // �l���擾
        Vkj01AccuserVO vkj01AccuserVO = getPersonalInfo();
        if (vkj01AccuserVO == null) {
            LoginInitInfoResult result = setResultErr("�l���擾�G���[", "HB-W0102");
            getResult().set(RESULT_KEY, result);
            return;
        }

        // �Ɩ���v�ғ��󋵃`�F�b�N
        boolean accountOperationStatus = checkAccountOperationStatus();
        // �ԋp�l�ݒ�
        LoginInitInfoResult result = setResult(eigyoBi, vkj01AccuserVO, accountOperationStatus);
        getResult().set(RESULT_KEY, result);
    }

    /**
     * ����������ݒ肵�܂��B
     *
     * @param condition ��������
     */
    public void setPersonalInfoCondition(LoginInitInfoCondition condition) {
        _condition = condition;
    }

    /**
     * �������ʂ�Ԃ��܂��B
     *
     * @return ��������
     */
    public LoginInitInfoResult getPersonalInfoResult() {
        return (LoginInitInfoResult) super.getResult().get(RESULT_KEY);
    }

    /**
     * �p�����[�^���̓`�F�b�N
     *
     * @throws KKHException �p�����[�^�w��G���[�̏ꍇ
     */
    private void checkInput() throws KKHException {

        if (StringUtil.isBlank(_condition.getEsqId())) {
            throw new KKHException("�p�����[�^�w��G���[", "HB-E0017");
        }
        if (StringUtil.isBlank(_condition.getOperationNo())) {
            throw new KKHException("�p�����[�^�w��G���[", "HB-E0017");
        }
    }

    /**
     * �z�X�g�c�Ɠ��擾
     *
     * @return �z�X�g�c�Ɠ�
     * @throws KKHException �������ɃG���[�����������ꍇ
     */
    private String getEigyoBi() throws KKHException {

        EigyoBiCondition cond = new EigyoBiCondition();
        cond.setEsqId(_condition.getEsqId());
        EigyoBiManager manager = EigyoBiManager.getInstance();
        EigyoBiResult result = manager.getEigyoBi(cond);
        return result.getEigyoBi();
    }

    /**
     * �l���擾
     *
     * @return �l���VO
     * @throws KKHException �������ɃG���[�����������ꍇ
     */
    private Vkj01AccuserVO getPersonalInfo() throws KKHException {

        Vkj01AccuserCondition cond = new Vkj01AccuserCondition();
        cond.setEsqId(_condition.getEsqId());
        cond.setOperationNo(_condition.getOperationNo());
        LoginInitInfoManager manager = LoginInitInfoManager.getInstance();
        return manager.getPersonalInfo(cond);
    }

    /**
     * �Ɩ���v�ғ��󋵃`�F�b�N
     *
     * @return true�F�ғ����Afalse�F��~��
     * @throws KKHException �������ɃG���[�����������ꍇ
     */
    private boolean checkAccountOperationStatus() throws KKHException {

        AccountOperationStatusCondition cond = new AccountOperationStatusCondition();
        cond.setEsqId(_condition.getEsqId());
        AccountOperationStatusManager manager = AccountOperationStatusManager.getInstance();
        return manager.checkAccountOperationStatus(cond);
    }

    /**
     * �ԋp�l�ݒ�
     *
     * @param eigyoBi �z�X�g�c�Ɠ�
     * @param vkj01AccuserVO �l���VO
     * @param accountOperationStatus �Ɩ���v�ғ���
     * @return �l���擾����
     */
    private LoginInitInfoResult setResult(String eigyoBi, Vkj01AccuserVO vkj01AccuserVO, boolean accountOperationStatus) {

        LoginInitInfoResult result = new LoginInitInfoResult();
        result.setEigyoBi(eigyoBi);
        result.setAccountOperationStatus(accountOperationStatus);
        result.setOrganizationCode(vkj01AccuserVO.getOgnzuntCd());

        return result;
    }

    /**
     * �ԋp�l�ݒ�i�G���[�j
     *
     * @param message ���b�Z�[�W
     * @param errorID �G���[�R�[�h
     * @return �l���擾���ʁi�G���[�j
     */
    private LoginInitInfoResult setResultErr(String message, String errorID) {

        LoginInitInfoResult result = new LoginInitInfoResult();
        ErrorInfo errorInfo = new ErrorInfo();
        errorInfo.setError(true);
        errorInfo.setErrorCode(errorID);
        List<String> list = new ArrayList<String>();
        list.add(message);
        errorInfo.setNote(list);
        result.setErrorInfo(errorInfo);
        return result;
    }

}

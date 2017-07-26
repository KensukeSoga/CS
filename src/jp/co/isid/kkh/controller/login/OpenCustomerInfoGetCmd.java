package jp.co.isid.kkh.controller.login;

import java.util.ArrayList;
import java.util.List;

import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.model.login.OpenCustomerInfoCondition;
import jp.co.isid.kkh.model.login.OpenCustomerInfoManager;
import jp.co.isid.kkh.model.login.OpenCustomerInfoResult;
import jp.co.isid.kkh.model.login.ThbcKhtCondition;
import jp.co.isid.kkh.model.login.ThbcKhtVO;
import jp.co.isid.kkh.service.base.ErrorInfo;
import jp.co.isid.kkh.util.StringUtil;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * �J�����Ӑ���擾�R�}���h
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/02/13 JSE H.Abe)<BR>
 * </P>
 *
 * @author JSE H.Abe
 */
public class OpenCustomerInfoGetCmd extends Command {

    private static final long serialVersionUID = 1L;

    /** �������ʃL�[ */
    private static final String RESULT_KEY = "RESULT_KEY";

    /** �������� */
    private OpenCustomerInfoCondition _condition;

    /**
     * �����������g�p���A�������������s���܂��B
     *
     * @throws KKHException �����Ɏ��s�����ꍇ
     */
    public void execute() throws KKHException {

        // ���̓`�F�b�N
        checkInput();
        // �J�����Ӑ���擾
        ThbcKhtVO thbcKhtVO = getOpenCustomerInfo();
        if (thbcKhtVO == null) {
            OpenCustomerInfoResult result = setResultErr("�J�����Ӑ���擾�G���[", "HB-W0108");
            getResult().set(RESULT_KEY, result);
            return;
        }
        // �ԋp�l�ݒ�
        OpenCustomerInfoResult result = setResult(thbcKhtVO);
        getResult().set(RESULT_KEY, result);
    }

    /**
     * ����������ݒ肵�܂��B
     *
     * @param condition ��������
     */
    public void setOpenCustomerInfoCondition(OpenCustomerInfoCondition condition) {
        _condition = condition;
    }

    /**
     * �������ʂ�Ԃ��܂��B
     *
     * @return ��������
     */
    public OpenCustomerInfoResult getOpenCustomerInfoResult() {
        return (OpenCustomerInfoResult) super.getResult().get(RESULT_KEY);
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
        if (StringUtil.isBlank(_condition.getEgCd())) {
            throw new KKHException("�p�����[�^�w��G���[", "HB-E0017");
        }
        if (StringUtil.isBlank(_condition.getTksKgyCd())) {
            throw new KKHException("�p�����[�^�w��G���[", "HB-E0017");
        }
        if (StringUtil.isBlank(_condition.getTksBmnSeqNo())) {
            throw new KKHException("�p�����[�^�w��G���[", "HB-E0017");
        }
        if (StringUtil.isBlank(_condition.getTksTntSeqNo())) {
            throw new KKHException("�p�����[�^�w��G���[", "HB-E0017");
        }
    }

    /**
     * �J�����Ӑ���擾
     *
     * @return �J�����Ӑ���VO
     * @throws KKHException �������ɃG���[�����������ꍇ
     */
    private ThbcKhtVO getOpenCustomerInfo() throws KKHException {

        ThbcKhtCondition cond = new ThbcKhtCondition();
        cond.setEgCd(_condition.getEgCd());
        cond.setKgyCd(_condition.getTksKgyCd());
        cond.setBmnSeqNo(_condition.getTksBmnSeqNo());
        cond.setTntSeqNo(_condition.getTksTntSeqNo());
        OpenCustomerInfoManager manager = OpenCustomerInfoManager.getInstance();
        return manager.getOpenCustomerInfo(cond);
    }

    /**
     * �ԋp�l�ݒ�
     *
     * @param thbcKhtVO �J�����Ӑ���VO
     * @return �J�����Ӑ���擾����
     */
    private OpenCustomerInfoResult setResult(ThbcKhtVO thbcKhtVO) {

        OpenCustomerInfoResult result = new OpenCustomerInfoResult();
        result.setDisFlg(thbcKhtVO.getDisFlg());
        return result;
    }

    /**
     * �ԋp�l�ݒ�i�G���[�j
     *
     * @param message ���b�Z�[�W
     * @param errorID �G���[�R�[�h
     * @return �J�����Ӑ���擾���ʁi�G���[�j
     */
    private OpenCustomerInfoResult setResultErr(String message, String errorID) {

        OpenCustomerInfoResult result = new OpenCustomerInfoResult();
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

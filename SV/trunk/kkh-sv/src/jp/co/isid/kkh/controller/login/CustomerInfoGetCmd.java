package jp.co.isid.kkh.controller.login;

import java.util.ArrayList;
import java.util.List;

import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.model.login.CustomerInfoCondition;
import jp.co.isid.kkh.model.login.CustomerInfoManager;
import jp.co.isid.kkh.model.login.CustomerInfoResult;
import jp.co.isid.kkh.model.login.RcmnMeu12ThskgyCondition;
import jp.co.isid.kkh.model.login.RcmnMeu12ThskgyVO;
import jp.co.isid.kkh.model.login.ThbdSpUsCondition;
import jp.co.isid.kkh.model.login.ThbdSpUsVO;
import jp.co.isid.kkh.service.base.ErrorInfo;
import jp.co.isid.kkh.util.StringUtil;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * ���Ӑ���擾�R�}���h
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/02/13 JSE H.Abe)<BR>
 * </P>
 *
 * @author JSE H.Abe
 */
public class CustomerInfoGetCmd extends Command {

    private static final long serialVersionUID = 1L;

    /** �������ʃL�[ */
    private static final String RESULT_KEY = "RESULT_KEY";

    /** �������� */
    private CustomerInfoCondition _condition;

    /**
     * �����������g�p���A�������������s���܂��B
     *
     * @throws KKHException �����Ɏ��s�����ꍇ
     */
    public void execute() throws KKHException {

        // ���̓`�F�b�N
        checkInput();
        // ���Ӑ���擾
        RcmnMeu12ThskgyVO rcmnMeu12ThskgyVO = getCustomerInfo();

        // ���Ӑ��񂪂O���̏ꍇ
        if (rcmnMeu12ThskgyVO == null) {
            // ���ʃ��[�U�[���擾
            ThbdSpUsVO thbdSpUsVO = getSpecialUserInfo();
            // ���ʃ��[�U�[��񂪂O���̏ꍇ
            if (thbdSpUsVO == null) {
                CustomerInfoResult result = setResultErr("���Ӑ���擾�G���[", "HB-W0103");
                getResult().set(RESULT_KEY, result);
            // ���ʃ��[�U�[��񂪎擾�ł����ꍇ
            } else {
                CustomerInfoResult result = setResult(thbdSpUsVO.getTksKgyNm(), thbdSpUsVO.getTksBmnNm());
                getResult().set(RESULT_KEY, result);
            }
        // ���Ӑ��񂪎擾�ł����ꍇ
        } else {
            CustomerInfoResult result = setResult(rcmnMeu12ThskgyVO.getThskgyDispKj(), rcmnMeu12ThskgyVO.getSubMei());
            getResult().set(RESULT_KEY, result);
        }
    }

    /**
     * ����������ݒ肵�܂��B
     *
     * @param condition ��������
     */
    public void setCustomerInfoCondition(CustomerInfoCondition condition) {
        _condition = condition;
    }

    /**
     * �������ʂ�Ԃ��܂��B
     *
     * @return ��������
     */
    public CustomerInfoResult getCustomerInfoResult() {
        return (CustomerInfoResult) super.getResult().get(RESULT_KEY);
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
        if (StringUtil.isBlank(_condition.getCustomerCode())) {
            throw new KKHException("���Ӑ���擾�G���[", "HB-W0103");
            //throw new KKHException("�p�����[�^�w��G���[", "HB-E0017");
        }
    }

    /**
     * ���Ӑ���擾
     *
     * @return ���Ӑ���VO
     * @throws KKHException �������ɃG���[�����������ꍇ
     */
    private RcmnMeu12ThskgyVO getCustomerInfo() throws KKHException {

        RcmnMeu12ThskgyCondition cond = new RcmnMeu12ThskgyCondition();
        cond.setTksKgyCd(_condition.getCustomerCode().substring(0, 6));
        cond.setTksBmnSeqNo(_condition.getCustomerCode().substring(6, 8));
        CustomerInfoManager manager = CustomerInfoManager.getInstance();
        return manager.getCustomerInfo(cond);
    }

    /**
     * ���ʃ��[�U�[���擾
     *
     * @return ���ʃ��[�U�[���VO
     * @throws KKHException �������ɃG���[�����������ꍇ
     */
    private ThbdSpUsVO getSpecialUserInfo() throws KKHException {

        ThbdSpUsCondition cond = new ThbdSpUsCondition();
        cond.setTksKgyCd(_condition.getCustomerCode().substring(0, 6));
        cond.setTksBmnSeqNo(_condition.getCustomerCode().substring(6, 8));
        CustomerInfoManager manager = CustomerInfoManager.getInstance();
        return manager.getSpecialUserInfo(cond);
    }

    /**
     * �ԋp�l�ݒ�
     *
     * @param tksKgyNm ���Ӑ��Ɩ�
     * @param tksBmnNm ���Ӑ敔�喼
     * @return ���Ӑ���擾����
     */
    private CustomerInfoResult setResult(String tksKgyNm, String tksBmnNm) {

        CustomerInfoResult result = new CustomerInfoResult();
        result.setCustomerName(tksKgyNm + System.getProperty("line.separator") + tksBmnNm);
        return result;
    }

    /**
     * �ԋp�l�ݒ�i�G���[�j
     *
     * @param message ���b�Z�[�W
     * @param errorID �G���[�R�[�h
     * @return ���Ӑ���擾���ʁi�G���[�j
     */
    private CustomerInfoResult setResultErr(String message, String errorID) {

        CustomerInfoResult result = new CustomerInfoResult();
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

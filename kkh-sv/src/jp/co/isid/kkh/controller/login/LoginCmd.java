package jp.co.isid.kkh.controller.login;

import java.util.ArrayList;
import java.util.List;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.model.common.CommonCondition;
import jp.co.isid.kkh.model.common.CommonDAO;
import jp.co.isid.kkh.model.common.CommonDAOFactory;
import jp.co.isid.kkh.model.common.CommonVO;
import jp.co.isid.kkh.model.login.LoginCondition;
import jp.co.isid.kkh.model.login.LoginCustomerInfoVO;
import jp.co.isid.kkh.model.login.LoginManager;
import jp.co.isid.kkh.model.login.LoginResult;
import jp.co.isid.kkh.model.login.RcmnMeu00SikCondition;
import jp.co.isid.kkh.model.login.RcmnMeu00SikVO;
import jp.co.isid.kkh.model.login.RcmnMeu07SikkrsprdCondition;
import jp.co.isid.kkh.model.login.RcmnMeu07SikkrsprdVO;
import jp.co.isid.kkh.model.login.RcmnMeu14ThstntTrCondition;
import jp.co.isid.kkh.model.login.RcmnMeu14ThstntTrVO;
import jp.co.isid.kkh.model.login.Tcm01KkhCondition;
import jp.co.isid.kkh.model.login.Tcm01KkhVO;
import jp.co.isid.kkh.model.login.ThbcKhtCondition;
import jp.co.isid.kkh.model.login.ThbcKhtVO;
import jp.co.isid.kkh.model.login.ThbdSpUsCondition;
import jp.co.isid.kkh.model.login.ThbdSpUsVO;
import jp.co.isid.kkh.model.login.Vkj02TitleClassGroupInfoCondition;
import jp.co.isid.kkh.model.login.Vkj02TitleClassGroupInfoVO;
import jp.co.isid.kkh.service.base.ErrorInfo;
import jp.co.isid.kkh.util.DateUtil;
import jp.co.isid.kkh.util.StringUtil;
import jp.co.isid.kkh.util.constants.KKHConstants;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * ���O�C�������R�}���h
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/02/13 JSE H.Abe)<BR>
 * �E���Ӑ惍�O�C���������Ή�(2017/02/08 HLC K.Soga)<BR>
 * </P>
 *
 * @author JSE H.Abe
 */
public class LoginCmd extends Command {

    private static final long serialVersionUID = 1L;

    /** �K�w�R�[�h�F�Ǐ��� */
    private static final String KAISO_CD_KYOKU = "40";

    /** �M�p�R�[�h�F�ΏۊO */
    private static final String[] SINCD_NOT_SUBJECT = { "7", "8", "9", "A", "X" };

    /** ��S�����Ӑ�F�Ȃ� */
    private static final int MAIN_CUSTOMER_NOT_EXIST = -1;

    /** �������ʃL�[ */
    private static final String RESULT_KEY = "RESULT_KEY";

    /** �������� */
    private LoginCondition _condition;

    /** �G���[��� */
    ErrorInfo _errorInfo = null;

    /** �X�[�p�[���[�U�[��� */
    ThbdSpUsVO _superUserInfo = null;

    /** ���ʃ��O�C�����[�U�[��񃊃X�g */
    List<ThbdSpUsVO> _specialLoginUserInfoList = null;

    /** �c�Ə����i�ʏ탆�[�U�[�j */
    RcmnMeu00SikVO _meu00SikVO = null;

    /** �Ώێ����S�����i�[���X�g */
    List<RcmnMeu14ThstntTrVO> _subjectMeu14ThstntTrVOList = null;

    /** ���O�C�����Ӑ��񃊃X�g */
    List<LoginCustomerInfoVO> _customerInfoVOList = null;

    /**
     * �����������g�p���A�������������s���܂��B
     *
     * @throws KKHException �����Ɏ��s�����ꍇ
     */
    public void execute() throws KKHException {

        //�E�ʓ����O���[�v�R�[�h
        List<String> groupCdList = new ArrayList<String>();
        //�g�D�R�[�h
        String organizationCode = null;

        //���̓`�F�b�N
        checkInput();

        //���[�U�[��ʔ���
        String userType = judgeUserType();

        //�ʏ탆�[�U�[�̏ꍇ
        if (KKHConstants.USER_KIND_NORMAL.equals(userType)) {
            //�E�ʓ����O���[�v�R�[�h�擾
            groupCdList = getGroupCdList();

            //�c�Ə����擾
            _meu00SikVO = getBusinessOfficeInfo();

            //�ǌ����̏ꍇ
            if (KKHConstants.RELATIVE_AUTHORITY_KYOKU.equals(_condition.getRelativeAuthority())) {
                //�g�D�R�[�h�̎擾
                organizationCode = getOrganizationCode();
            }
        }

        //�ʏ탆�[�U�[�A�X�[�p�[���[�U�[�̏ꍇ
        if (KKHConstants.USER_KIND_NORMAL.equals(userType) || KKHConstants.USER_KIND_SUPER.equals(userType)) {
            //�Ώێ����S�����i�[���X�g
            _subjectMeu14ThstntTrVOList = new ArrayList<RcmnMeu14ThstntTrVO>();

            //�����S�����擾
            List<RcmnMeu14ThstntTrVO> meu14ThstntTrVOList = getCustomerChargeInfo(userType);

            //���Ӑ���擾���������[�v����
            for (RcmnMeu14ThstntTrVO rcmnMeu14ThstntTrVO : meu14ThstntTrVOList) {
                // �G���[����������
                _errorInfo = null;

                //�X�[�p�[���[�U�[�̏ꍇ
                if (KKHConstants.USER_KIND_SUPER.equals(userType)) {
                    _subjectMeu14ThstntTrVOList.add(rcmnMeu14ThstntTrVO);
                    continue;
                }

                //���ʓ��Ӑ�`�F�b�N
                if (checkSpecialCustomer(rcmnMeu14ThstntTrVO)) {
                    _subjectMeu14ThstntTrVOList.add(rcmnMeu14ThstntTrVO);
                    continue;
                }

                //�ǌ����̏ꍇ
                if (KKHConstants.RELATIVE_AUTHORITY_KYOKU.equals(_condition.getRelativeAuthority())) {

                    //�S���ґg�D�`�F�b�N(��)
                    if (organizationCode.equals(rcmnMeu14ThstntTrVO.getSikcdKyk())) {
                        //�M�p�R�[�h�`�F�b�N
                        if (!checkSinCd(rcmnMeu14ThstntTrVO.getSinCd())) {
                            _errorInfo = setErrorInfo("�M�p�R�[�h�`�F�b�N�G���[", "HB-W0107");
                        } else {
                            _subjectMeu14ThstntTrVOList.add(rcmnMeu14ThstntTrVO);
                        }
                        continue;
                    }

                //�������̏ꍇ
                } else if (KKHConstants.RELATIVE_AUTHORITY_BU.equals(_condition.getRelativeAuthority())) {
                    //�S���ґg�D�`�F�b�N(��)
                    if (_condition.getOperationNo().equals(rcmnMeu14ThstntTrVO.getSikCdBu())) {
                        //�M�p�R�[�h�`�F�b�N
                        if (!checkSinCd(rcmnMeu14ThstntTrVO.getSinCd())) {
                            throw new KKHException("�M�p�R�[�h�`�F�b�N�G���[", "HB-W0107");
                        } else {
                            _subjectMeu14ThstntTrVOList.add(rcmnMeu14ThstntTrVO);
                            continue;
                        }
                    }
                }

                //���J�͈͓��Ӑ�`�F�b�N
                _errorInfo = checkOpenRange(groupCdList, rcmnMeu14ThstntTrVO);
                if (_errorInfo != null){
                    continue;
                }

                //�Ώێ����S�����i�[���X�g�ɐݒ�
                _subjectMeu14ThstntTrVOList.add(rcmnMeu14ThstntTrVO);
            }

            // �S���f�[�^��0���̏ꍇ
            if (_subjectMeu14ThstntTrVOList.size() == 0) {
                throw new KKHException(_errorInfo.getNote().get(0), _errorInfo.getErrorCode());
            }

            // ���O�C�����Ӑ���̐ݒ�
            _customerInfoVOList = setLoginCustomerInfo();

        // ���ʃ��O�C�����[�U�[�̏ꍇ
        } else {
            // ���O�C�����Ӑ���̐ݒ�
            _customerInfoVOList = setLoginCustomerInfoSpecialLogin();
        }

        // ��S�����Ӑ�INDEX�擾
        int customerIndex = getMainCustomerIndex(userType);

        // ��S�����Ӑ悪����ꍇ
        if (customerIndex != MAIN_CUSTOMER_NOT_EXIST) {
            //�J�����Ӑ��񑶍݃`�F�b�N
            checkOpenCustomerInfo(userType, customerIndex);
        }

        /** 2017/02/08 ���Ӑ惍�O�C���������Ή� HLC K.Soga ADD Start */
        //���Ӑ�p�~�`�F�b�N
        checkRepeal(userType);
        /** 2017/02/08 ���Ӑ惍�O�C���������Ή� HLC K.Soga ADD End */

        //�ԋp�l�ݒ�
        LoginResult result = setResult(userType, customerIndex);
        getResult().set(RESULT_KEY, result);
    }

    /**
     * ����������ݒ肵�܂��B
     *
     * @param condition ��������
     */
    public void setLoginCondition(LoginCondition condition) {
        _condition = condition;
    }

    /**
     * �������ʂ�Ԃ��܂��B
     *
     * @return ��������
     */
    public LoginResult getLoginResult() {
        return (LoginResult) super.getResult().get(RESULT_KEY);
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
        if (StringUtil.isBlank(_condition.getUserId())) {
            throw new KKHException("�p�����[�^�w��G���[", "HB-E0017");
        }
        if (StringUtil.isBlank(_condition.getCustomerCode())) {
            throw new KKHException("�p�����[�^�w��G���[", "HB-E0017");
        }
        if (StringUtil.isBlank(_condition.getNormalUserFlag())) {
            throw new KKHException("�p�����[�^�w��G���[", "HB-E0017");
        }
        if (StringUtil.isBlank(_condition.getOrganizationCode())) {
            throw new KKHException("�p�����[�^�w��G���[", "HB-E0017");
        }
        if (StringUtil.isBlank(_condition.getEigyoBi())) {
            throw new KKHException("�p�����[�^�w��G���[", "HB-E0017");
        }
    }

    /**
     * ���[�U�[��ʔ���
     *
     * @throws KKHException �������ɃG���[�����������ꍇ
     */
    private String judgeUserType() throws KKHException {

        //�ʏ탆�[�U�[
        if (KKHConstants.FLAG_ON.equals(_condition.getNormalUserFlag())) {
            return KKHConstants.USER_KIND_NORMAL;
        }

        //�X�[�p�[���[�U�[
        _superUserInfo = getSuperUserInfo();
        if (_superUserInfo != null) {
            return KKHConstants.USER_KIND_SUPER;
        }

        //���ʃ��O�C�����[�U�[
        _specialLoginUserInfoList = getSpecialLoginUserInfo();
        return KKHConstants.USER_KIND_SPECIAL_LOGIN;
    }

    /**
     * �X�[�p�[���[�U�[���擾
     *
     * @return �X�[�p�[���[�U�[���VO
     * @throws KKHException �������ɃG���[�����������ꍇ
     */
    private ThbdSpUsVO getSuperUserInfo() throws KKHException {

        ThbdSpUsCondition cond = new ThbdSpUsCondition();
        cond.setUserId(_condition.getUserId());
        LoginManager manager = LoginManager.getInstance();
        ThbdSpUsVO vo = manager.getSuperUserInfo(cond);

        // �f�[�^������A���p�X���[�h����v�����ꍇ
        if (vo != null && vo.getPassword().equals(_condition.getPassword())) {
            return vo;
        } else {
            return null;
        }
    }

    /**
     * ���ʃ��O�C�����[�U�[���擾
     *
     * @return ���ʃ��O�C�����[�U�[���VO���X�g
     * @throws KKHException �Ώۃf�[�^�����݂��Ȃ��ꍇ
     */
    private List<ThbdSpUsVO> getSpecialLoginUserInfo() throws KKHException {

        ThbdSpUsCondition cond = new ThbdSpUsCondition();
        cond.setTksKgyCd(_condition.getCustomerCode().substring(0, 6));
        cond.setTksBmnSeqNo(_condition.getCustomerCode().substring(6, 8));
        LoginManager manager = LoginManager.getInstance();
        List<ThbdSpUsVO> list = manager.getSpecialLoginUserInfo(cond);

        List<ThbdSpUsVO> subjectList = new ArrayList<ThbdSpUsVO>();
        for (int i = 0; i < list.size(); i++) {
            ThbdSpUsVO vo = list.get(i);

            // ���[�U�[ID�A�p�X���[�h����v�����ꍇ
            if (vo.getUserId().equals(_condition.getUserId()) && vo.getPassword().equals(_condition.getPassword())) {
                subjectList.add(vo);
            }
        }

        //�Ώۃf�[�^���Ȃ��ꍇ
        if (subjectList.size() == 0) {
            throw new KKHException("���ʃ��O�C�����[�U�[���擾�G���[", "HB-W0104");
        }

        return subjectList;
    }

    /**
     * �E�ʓ����O���[�v�R�[�h�擾
     *
     * @return �E�ʓ����O���[�v�R�[�h
     * @throws KKHException �������ɃG���[�����������ꍇ
     */
    private List<String> getGroupCdList() throws KKHException {

        Vkj02TitleClassGroupInfoCondition cond = new Vkj02TitleClassGroupInfoCondition();
        cond.setEsqId(_condition.getEsqId());
        cond.setEigyoBi(_condition.getEigyoBi());
        LoginManager manager = LoginManager.getInstance();
        List<Vkj02TitleClassGroupInfoVO> voList = manager.getGroupInfo(cond);

        //�E�ʓ����O���[�v�R�[�h��ݒ�
        List<String> groupCdList = new ArrayList<String>();
        for (Vkj02TitleClassGroupInfoVO vo : voList) {
            groupCdList.add(vo.getGroupCd());
        }
        return groupCdList;
    }

    /**
     * �c�Ə����擾
     *
     * @return �c�Ə����VO
     * @throws KKHException �Ώۃf�[�^�����݂��Ȃ��ꍇ
     */
    private RcmnMeu00SikVO getBusinessOfficeInfo() throws KKHException {

        RcmnMeu00SikCondition cond = new RcmnMeu00SikCondition();
        cond.setOperationNo(_condition.getOperationNo());
        cond.setEigyoBi(_condition.getEigyoBi());
        LoginManager manager = LoginManager.getInstance();
        RcmnMeu00SikVO vo = manager.getBusinessOfficeInfo(cond);

        // �f�[�^���Ȃ��ꍇ
        if (vo == null) {
            throw new KKHException("�c�Ə����擾�G���[", "HB-E0015");
        }
        return vo;
    }

    /**
     * �����S�����擾
     *
     * @param userType ���[�U�[���
     * @return �����S�����VO
     * @throws KKHException �Ώۃf�[�^�����݂��Ȃ��ꍇ
     */
    private List<RcmnMeu14ThstntTrVO> getCustomerChargeInfo(String userType) throws KKHException {

        RcmnMeu14ThstntTrCondition cond = new RcmnMeu14ThstntTrCondition();
        //�ʏ탆�[�U�[�̏ꍇ
        if (KKHConstants.USER_KIND_NORMAL.equals(userType)) {
            cond.setEgCd(_meu00SikVO.getEgsyoCd());
        //�X�[�p�[���[�U�[�̏ꍇ
        } else if (KKHConstants.USER_KIND_SUPER.equals(userType)) {
            cond.setEgCd(_superUserInfo.getEgsCd());
        }
        cond.setTksKgyCd(_condition.getCustomerCode().substring(0, 6));
        cond.setTksBmnSeqNo(_condition.getCustomerCode().substring(6, 8));
        cond.setEigyoBi(_condition.getEigyoBi());
        LoginManager manager = LoginManager.getInstance();
        List<RcmnMeu14ThstntTrVO> list = manager.getCustomerChargeInfo(cond);

        // �f�[�^���Ȃ��ꍇ
        if (list.size() == 0) {
            throw new KKHException("�����S�����擾�G���[", "HB-W0105");
        }
        return list;
    }

    /**
     * ���ʓ��Ӑ�`�F�b�N
     *
     * @param rcmnMeu14ThstntTrVO �����S�����
     * @return true�F���ʓ��Ӑ�Afalse�F���̑�
     * @throws KKHException �������ɃG���[�����������ꍇ
     */
    private boolean checkSpecialCustomer(RcmnMeu14ThstntTrVO rcmnMeu14ThstntTrVO) throws KKHException {

        ThbdSpUsCondition cond = new ThbdSpUsCondition();
        cond.setTksKgyCd(rcmnMeu14ThstntTrVO.getThskgyCd());
        cond.setTksBmnSeqNo(rcmnMeu14ThstntTrVO.getSeqNo());
        cond.setTksTntSeqNo(rcmnMeu14ThstntTrVO.getTrtntSeqNo());
        cond.setSikCd(_condition.getOperationNo());
        cond.setUserId(_condition.getUserId());
        LoginManager manager = LoginManager.getInstance();
        ThbdSpUsVO vo = manager.getSpecialCustomerInfo(cond);

        // �f�[�^���Ȃ��ꍇ
        if (vo == null) {
            return false;
        }
        return true;
    }

    /**
     * �g�D�R�[�h�擾
     *
     * @return �g�D�R�[�h
     * @throws KKHException �������ɃG���[�����������ꍇ
     */
    private String getOrganizationCode() throws KKHException {

        // �Ǐ����̏ꍇ
        if (KAISO_CD_KYOKU.equals(_meu00SikVO.getKaisoCd())) {
            // �^�pNo(�g�D�R�[�h
            return _condition.getOperationNo();
            // �������̏ꍇ
        } else {
            // �o���g�D�W�J���擾
            RcmnMeu07SikkrsprdVO rcmnMeu07SikkrsprdVO = getAccountingOrganizationInfo(_meu00SikVO.getJSikCd(),
            _meu00SikVO.getEgsyoCd());

            // ��ʑg�D�R�[�h(��)
            return rcmnMeu07SikkrsprdVO.getSikCdKyk();
        }
    }

    /**
     * �o���g�D�W�J���擾
     *
     * @param higherOrganizationCode ��ʑg�D�R�[�h
     * @param egCd �c�Ə��R�[�h
     * @return �o���g�D�W�J���VO
     * @throws KKHException �Ώۃf�[�^�����݂��Ȃ��ꍇ
     */
    private RcmnMeu07SikkrsprdVO getAccountingOrganizationInfo(String higherOrganizationCode, String egCd)
            throws KKHException {

        RcmnMeu07SikkrsprdCondition cond = new RcmnMeu07SikkrsprdCondition();
        cond.setHigherOrganizationCode(higherOrganizationCode);
        cond.setEgCd(egCd);
        cond.setEigyoBi(_condition.getEigyoBi());
        LoginManager manager = LoginManager.getInstance();
        RcmnMeu07SikkrsprdVO vo = manager.getAccountingOrganizationInfo(cond);

        // �f�[�^���Ȃ��ꍇ
        if (vo == null) {
            throw new KKHException("��ʑg�D���擾�G���[", "HB-E0016");
        }

        return vo;
    }

    /**
     * ���J�͈͓��Ӑ�`�F�b�N
     *
     * @param groupCdList �E�ʃO���[�v�R�[�h
     * @param rcmnMeu14ThstntTrVO �����S�����
     * @return �G���[���
     * @throws KKHException �Ώۃf�[�^�����݂��Ȃ��ꍇ
     */
    private ErrorInfo checkOpenRange(List<String> groupCdList, RcmnMeu14ThstntTrVO rcmnMeu14ThstntTrVO) throws KKHException {

        Tcm01KkhCondition cond = new Tcm01KkhCondition();
        cond.setHigherOrganizationCode(_meu00SikVO.getJSikCd());
        cond.setOperationNo(_condition.getOperationNo());
        StringBuffer buffer = new StringBuffer();
        if (groupCdList.size() == 0) {
            buffer.append("'*'");
        } else {
            for (String groupCd : groupCdList) {
                buffer.append("'" + groupCd + "',");
            }
            buffer.append("'*'");
        }
        cond.setGroupCd(buffer.toString());
        cond.setTntCd("'" + _condition.getUserId() + "', '*'");
        cond.setCustomerCode(rcmnMeu14ThstntTrVO.getThskgyCd() + rcmnMeu14ThstntTrVO.getSeqNo()
                + rcmnMeu14ThstntTrVO.getTrtntSeqNo());
        cond.setEigyoBi(_condition.getEigyoBi());
        cond.setTermBegin(DateUtil.getTermBegin(_condition.getEigyoBi()));
        cond.setTermEnd(DateUtil.getTermEnd(_condition.getEigyoBi()));

        LoginManager manager = LoginManager.getInstance();
        Tcm01KkhVO vo = manager.getOpenRange(cond);

        // �f�[�^��0���̏ꍇ
        if (vo == null) {
            return setErrorInfo("���J�͈͏��擾�G���[", "HB-W0106");
        }

        // �M�p�R�[�h�`�F�b�N
        if (checkSinCd(rcmnMeu14ThstntTrVO.getSinCd()) == false) {
            return setErrorInfo("�M�p�R�[�h�`�F�b�N�G���[", "HB-W0107");
        }

        return null;
    }

    /**
     * �J�����Ӑ��񑶍݃`�F�b�N
     *
     * @param userType ���[�U�[���
     * @parama customerIndex ��S�����Ӑ�INDEX
     * @return �J�����Ӑ���VO
     * @throws KKHException �Ώۃf�[�^�����݂��Ȃ��ꍇ
     */
    private void checkOpenCustomerInfo(String userType, int customerIndex) throws KKHException {

        ThbcKhtCondition cond = new ThbcKhtCondition();

        //�ʏ탆�[�U�[�̏ꍇ
        if (KKHConstants.USER_KIND_NORMAL.equals(userType)) {
            cond.setEgCd(_meu00SikVO.getEgsyoCd());
        //�X�[�p�[���[�U�[�̏ꍇ
        } else if (KKHConstants.USER_KIND_SUPER.equals(userType)) {
            cond.setEgCd(_superUserInfo.getEgsCd());
        //���ʃ��O�C�����[�U�[�̏ꍇ
        } else {
            cond.setEgCd(_specialLoginUserInfoList.get(0).getEgsCd());
        }
        cond.setKgyCd(_customerInfoVOList.get(customerIndex).getTksKgyCd());
        cond.setBmnSeqNo(_customerInfoVOList.get(customerIndex).getTksBmnSeqNo());
        cond.setTntSeqNo(_customerInfoVOList.get(customerIndex).getTksTntSeqNo());
        LoginManager manager = LoginManager.getInstance();
        ThbcKhtVO vo = manager.getOpenCustomerInfo(cond);

        //�f�[�^���Ȃ��ꍇ
        if (vo == null) {
            throw new KKHException("�J�����Ӑ���擾�G���[", "HB-W0108");
        }
    }

    /**
     * �M�p�R�[�h�`�F�b�N
     *
     * @param sinCd �M�p�R�[�h
     * @return true�FOK�Afalse�FNG
     */
    private boolean checkSinCd(String sinCd) {

        String subjectCode = sinCd.substring(0, 1);
        for (int i = 0; i < SINCD_NOT_SUBJECT.length; i++) {
            if (SINCD_NOT_SUBJECT[i].equals(subjectCode) == true) {
                return false;
            }
        }
        return true;
    }

    /**
     * ��S�����Ӑ�INDEX�擾
     *
     * @param userType ���[�U�[���
     * @return ��S�����Ӑ�INDEX
     */
    private int getMainCustomerIndex(String userType) {

        //1���݂̂̏ꍇ
        if (_customerInfoVOList.size() == 1) {
            return 0;
        }

        //���ʃ��O�C�����[�U�[�̏ꍇ
        if (KKHConstants.USER_KIND_SPECIAL_LOGIN.equals(userType)) {
            for (int i = 0; i < _specialLoginUserInfoList.size(); i++) {
                ThbdSpUsVO vo = _specialLoginUserInfoList.get(i);
                if (vo.getSikCd().equals(_condition.getOrganizationCode())) {
                    return i;
                }
            }
        //���̑��̃��[�U�[�̏ꍇ
        } else {
            for (int i = 0; i < _subjectMeu14ThstntTrVOList.size(); i++) {
                RcmnMeu14ThstntTrVO vo = _subjectMeu14ThstntTrVOList.get(i);
                if (vo.getSikCd().equals(_condition.getOrganizationCode())) {
                    return i;
                }
            }
        }

        //��S�����Ӑ�Ȃ�
        return MAIN_CUSTOMER_NOT_EXIST;
    }

    /**
     * ���O�C�����Ӑ���ݒ�
     *
     * @return ���O�C�����Ӑ���
     */
    private List<LoginCustomerInfoVO> setLoginCustomerInfo() {

        List<LoginCustomerInfoVO> customerInfoVOList = new ArrayList<LoginCustomerInfoVO>();

        for (RcmnMeu14ThstntTrVO meu14ThstntTrVO : _subjectMeu14ThstntTrVOList) {
            LoginCustomerInfoVO customerInfoVO = new LoginCustomerInfoVO();
            customerInfoVO.setTksKgyCd(meu14ThstntTrVO.getThskgyCd());
            customerInfoVO.setTksBmnSeqNo(meu14ThstntTrVO.getSeqNo());
            customerInfoVO.setTksTntSeqNo(meu14ThstntTrVO.getTrtntSeqNo());
            customerInfoVO.setDispTksCd(meu14ThstntTrVO.getThskgyCd() + meu14ThstntTrVO.getSeqNo() + "-" + meu14ThstntTrVO.getTrtntSeqNo());
            customerInfoVO.setDispTksName(meu14ThstntTrVO.getThskgyDispKj() + meu14ThstntTrVO.getSubMei());
            customerInfoVO.setDispTntSikName(meu14ThstntTrVO.getBuHyojiKj());
            customerInfoVOList.add(customerInfoVO);
        }
        return customerInfoVOList;
    }

    /**
     * ���O�C�����Ӑ���ݒ�(���ʃ��O�C�����[�U�[)
     *
     * @return ���O�C�����Ӑ���
     */
    private List<LoginCustomerInfoVO> setLoginCustomerInfoSpecialLogin() {

        List<LoginCustomerInfoVO> customerInfoVOList = new ArrayList<LoginCustomerInfoVO>();

        for (ThbdSpUsVO thbdSpUsVO : _specialLoginUserInfoList) {
            LoginCustomerInfoVO customerInfoVO = new LoginCustomerInfoVO();
            customerInfoVO.setTksKgyCd(thbdSpUsVO.getTksKgyCd());
            customerInfoVO.setTksBmnSeqNo(thbdSpUsVO.getTksBmnSeqNo());
            customerInfoVO.setTksTntSeqNo(thbdSpUsVO.getTksTntSeqNo());
            customerInfoVO.setDispTksCd(thbdSpUsVO.getTksKgyCd() + thbdSpUsVO.getTksBmnSeqNo() + "-" + thbdSpUsVO.getTksTntSeqNo());
            customerInfoVO.setDispTksName(thbdSpUsVO.getTksKgyNm() + thbdSpUsVO.getTksBmnNm());
            customerInfoVO.setDispTntSikName(thbdSpUsVO.getTksTntNm());
            customerInfoVOList.add(customerInfoVO);
        }
        return customerInfoVOList;
    }

    /**
     * �G���[���ݒ�(�G���[)
     *
     * @param message ���b�Z�[�W
     * @param errorID �G���[�R�[�h
     * @return �G���[���
     */
    private ErrorInfo setErrorInfo(String message, String errorID) {

        ErrorInfo errorInfo = new ErrorInfo();
        errorInfo.setError(true);
        errorInfo.setErrorCode(errorID);
        List<String> list = new ArrayList<String>();
        list.add(message);
        errorInfo.setNote(list);
        return errorInfo;
    }

    /**
     * �ԋp�l�ݒ�
     *
     * @param userType ���[�U�[���
     * @param customerIndex ��S�����Ӑ�INDEX
     * @return ���O�C�����
     */
    private LoginResult setResult(String userType, int customerIndex) {

        LoginResult result = new LoginResult();

        //�ʏ탆�[�U�[�̏ꍇ
        if (KKHConstants.USER_KIND_NORMAL.equals(userType) == true) {
            result.setEgCd(_meu00SikVO.getEgsyoCd());
            result.setUserName(null);
        //�X�[�p�[���[�U�[�̏ꍇ
        } else if (KKHConstants.USER_KIND_SUPER.equals(userType) == true) {
            result.setEgCd(_superUserInfo.getEgsCd());
            result.setUserName(_superUserInfo.getUserNmKj());
        //���ʃ��O�C�����[�U�[�̏ꍇ
        } else {
            result.setEgCd(_specialLoginUserInfoList.get(0).getEgsCd());
            result.setUserName(_specialLoginUserInfoList.get(0).getUserNmKj());
        }

        //1���̏ꍇ�A�܂��������Ŏ�S�����Ӑ悪�Ȃ��ꍇ
        if (_customerInfoVOList.size() == 1 || customerIndex == MAIN_CUSTOMER_NOT_EXIST) {
            result.setLoginCustomerInfoVOList(_customerInfoVOList);
        //�������Ŏ�S�����Ӑ悪����ꍇ
        } else {
            List<LoginCustomerInfoVO> subjectCustomerInfoVOList = new ArrayList<LoginCustomerInfoVO>();
            subjectCustomerInfoVOList.add(_customerInfoVOList.get(customerIndex));
            result.setLoginCustomerInfoVOList(subjectCustomerInfoVOList);
        }

        //���[�U�[�^�C�v�̃Z�b�g
        result.set_SystemAdministerFlg(userType);

        return result;
    }

    /** 2017/02/08 ���Ӑ惍�O�C���������Ή� HLC K.Soga ADD Start */
    /**
     * ���Ӑ�p�~�`�F�b�N
     * @param userType ���[�U�[���
     * @return ���O�C�����
     */
    private void checkRepeal(String userType) throws KKHException{
        //�����ݒ�
        CommonDAO commonDao = CommonDAOFactory.createCommonDAO();
        CommonCondition commonCond = new CommonCondition();

        //�ʏ탆�[�U�[�̏ꍇ
        if (KKHConstants.USER_KIND_NORMAL.equals(userType)) {
            commonCond.setEgCd(_meu00SikVO.getEgsyoCd());
        //�X�[�p�[���[�U�[�̏ꍇ
        } else if (KKHConstants.USER_KIND_SUPER.equals(userType)) {
            commonCond.setEgCd(_superUserInfo.getEgsCd());
        //���ʃ��O�C�����[�U�[�̏ꍇ
        } else {
            commonCond.setEgCd(_specialLoginUserInfoList.get(0).getEgsCd());
        }

        //���Ӑ��񌏐������[�v����
        for(int i = 0; i < _customerInfoVOList.size(); i++){
            commonCond.setTksKgyCd(_customerInfoVOList.get(i).getTksKgyCd());
            commonCond.setTksBmnSeqNo(_customerInfoVOList.get(i).getTksBmnSeqNo());
            commonCond.setTksTntSeqNo(_customerInfoVOList.get(i).getTksTntSeqNo());
            commonCond.setSybt(KKHConstants.SYBT_REPEALFLG);
            commonCond.setfield1(KKHConstants.FIELD1_REPEALFLG);
            List<CommonVO> commonVoList = commonDao.findCommonByCondition(commonCond);

            //�擾�����ėp�e�[�u���}�X�^������0���̏ꍇ�X�L�b�v����
            if(commonVoList.size() == 0){
                //���[�U�[��ʂ��ʏ탆�[�U�[�̏ꍇ
                if(KKHConstants.USER_KIND_NORMAL.equals(userType)){
                    throw new KKHException("���Ӑ�p�~�ݒ�G���[", "HB-W0168");
                }

                continue;
            }
            
            //�擾�����p�~�t���O��[0]�̏ꍇ
            if (commonVoList.get(0).getField2().equals(KKHConstants.FLAG_ON)) {
                throw new KKHException("���Ӑ�p�~�G���[", "HB-W0167");
            }
        }
    }
    /** 2017/02/08 ���Ӑ惍�O�C���������Ή� HLC K.Soga ADD End */
}
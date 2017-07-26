package jp.co.isid.kkh.model.login;

import java.util.List;

import jp.co.isid.kkh.model.base.KKHException;

/**
 * <P>
 * ���O�C��Manager�B
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/02/13 JSE H.Abe)<BR>
 * </P>
 *
 * @author JSE H.Abe
 */
public class LoginManager {

    /** �V���O���g���C���X�^���X */
    private static LoginManager _manager = new LoginManager();

    /**
     * �V���O���g���ׁ̈A�C���X�^���X�����֎~���܂��B
     */
    private LoginManager() {
    }

    /**
     * �C���X�^���X��Ԃ��܂��B
     *
     * @return �C���X�^���X
     */
    public static LoginManager getInstance() {
        return _manager;
    }

    /**
     * �l���̎擾
     *
     * @param cond ��������
     * @return �l���VO
     * @throws KKHException �������ɃG���[�����������ꍇ
     */
    public Vkj01AccuserVO getPersonalInfo(Vkj01AccuserCondition cond) throws KKHException {

        Vkj01AccuserDAO dao = Vkj01AccuserDAOFactory.createVkj01AccuserDAO();
        List<Vkj01AccuserVO> list = dao.getPersonalInfo(cond);
        // �f�[�^��0���̏ꍇ
        if (list.size() == 0) {
            return null;
        }
        return list.get(0);
    }

    /**
     * ���Ӑ���̎擾
     *
     * @param cond ��������
     * @return ���Ӑ���VO
     * @throws KKHException �������ɃG���[�����������ꍇ
     */
    public RcmnMeu12ThskgyVO getCustomerInfo(RcmnMeu12ThskgyCondition cond) throws KKHException {

        RcmnMeu12ThskgyDAO dao = RcmnMeu12ThskgyDAOFactory.createRcmnMeu12ThskgyDAO();
        List<RcmnMeu12ThskgyVO> list = dao.getCustomerInfo(cond);
        // �f�[�^��0���̏ꍇ
        if (list.size() == 0) {
            return null;
        }
        return list.get(0);
    }

    /**
     * �X�[�p�[���[�U�[���̎擾
     *
     * @param cond ��������
     * @return �X�[�p�[���[�U�[���VO
     * @throws KKHException �������ɃG���[�����������ꍇ
     */
    public ThbdSpUsVO getSuperUserInfo(ThbdSpUsCondition cond) throws KKHException {

        ThbdSpUsDAO dao = ThbdSpUsDAOFactory.createThbdSpUsDAO();
        List<ThbdSpUsVO> list = dao.getSuperUserInfo(cond);
        // �f�[�^��0���̏ꍇ
        if (list.size() == 0) {
            return null;
        }
        return list.get(0);
    }

    /**
     * ���ʃ��O�C�����[�U�[���̎擾
     *
     * @param cond ��������
     * @return ���ʃ��O�C�����[�U�[���VO���X�g
     * @throws KKHException �������ɃG���[�����������ꍇ
     */
    public List<ThbdSpUsVO> getSpecialLoginUserInfo(ThbdSpUsCondition cond) throws KKHException {

        ThbdSpUsDAO dao = ThbdSpUsDAOFactory.createThbdSpUsDAO();
        return dao.getSpecialLoginUserInfo(cond);
    }

    /**
     * �E�ʃO���[�v���̎擾
     *
     * @param cond ��������
     * @return �E�ʓ����O���[�v���VO���X�g
     * @throws KKHException �������ɃG���[�����������ꍇ
     */
    public List<Vkj02TitleClassGroupInfoVO> getGroupInfo(Vkj02TitleClassGroupInfoCondition cond) throws KKHException {

        Vkj02TitleClassGroupInfoDAO dao = Vkj02TitleClassGroupInfoDAOFactory.createVkj02TitleClassGroupInfoDAO();
        return dao.getGroupInfo(cond);
    }

    /**
     * �c�Ə����擾�̎擾
     *
     * @param cond ��������
     * @return �c�Ə����擾VO
     * @throws KKHException �������ɃG���[�����������ꍇ
     */
    public RcmnMeu00SikVO getBusinessOfficeInfo(RcmnMeu00SikCondition cond) throws KKHException {

        RcmnMeu00SikDAO dao = RcmnMeu00SikDAOFactory.createRcmnMeu00SikDAO();
        List<RcmnMeu00SikVO> list = dao.getBusinessOfficeInfo(cond);
        // �f�[�^��0���̏ꍇ
        if (list.size() == 0) {
            return null;
        }
        return list.get(0);
    }

    /**
     * �����S�����̎擾
     *
     * @param cond ��������
     * @return �����S�����VO
     * @throws KKHException �������ɃG���[�����������ꍇ
     */
    public List<RcmnMeu14ThstntTrVO> getCustomerChargeInfo(RcmnMeu14ThstntTrCondition cond) throws KKHException {

        RcmnMeu14ThstntTrDAO dao = RcmnMeu14ThstntTrDAOFactory.createRcmnMeu14ThstntTrDAO();
        return dao.getCustomerChargeInfo(cond);
    }

    /**
     * ���ʓ��Ӑ���̎擾
     *
     * @param cond ��������
     * @return ���ʓ��Ӑ���VO
     * @throws KKHException �������ɃG���[�����������ꍇ
     */
    public ThbdSpUsVO getSpecialCustomerInfo(ThbdSpUsCondition cond) throws KKHException {

        ThbdSpUsDAO dao = ThbdSpUsDAOFactory.createThbdSpUsDAO();
        List<ThbdSpUsVO> list = dao.getSpecialCustomerInfo(cond);
        // �f�[�^��0���̏ꍇ
        if (list.size() == 0) {
            return null;
        }
        return list.get(0);
    }

    /**
     * �o���g�D�W�J���̎擾
     *
     * @param cond ��������
     * @return �o���g�D�W�J���VO
     * @throws KKHException �������ɃG���[�����������ꍇ
     */
    public RcmnMeu07SikkrsprdVO getAccountingOrganizationInfo(RcmnMeu07SikkrsprdCondition cond) throws KKHException {

        RcmnMeu07SikkrsprdDAO dao = RcmnMeu07SikkrsprdDAOFactory.createRcmnMeu07SikkrsprdDAO();
        List<RcmnMeu07SikkrsprdVO> list = dao.getAccountingOrganizationInfo(cond);
        // �f�[�^��0���̏ꍇ
        if (list.size() == 0) {
            return null;
        }
        return list.get(0);
    }

    /**
     * ���J�͈͏��̎擾
     *
     * @param cond ��������
     * @return ���J�͈͏��VO
     * @throws KKHException �������ɃG���[�����������ꍇ
     */
    public Tcm01KkhVO getOpenRange(Tcm01KkhCondition cond) throws KKHException {

        Tcm01KkhDAO dao = Tcm01KkhDAOFactory.createTcm01KkhDAO();
        List<Tcm01KkhVO> list = dao.getOpenRange(cond);
        // �f�[�^��0���̏ꍇ
        if (list.size() == 0) {
            return null;
        }
        return list.get(0);
    }

    /**
     * �J�����Ӑ���̎擾
     *
     * @param cond ��������
     * @return �J�����Ӑ���VO
     * @throws KKHException �������ɃG���[�����������ꍇ
     */
    public ThbcKhtVO getOpenCustomerInfo(ThbcKhtCondition cond) throws KKHException {

        ThbcKhtDAO dao = ThbcKhtDAOFactory.createThbcKhtDAO();
        List<ThbcKhtVO> list = dao.getOpenCustomerInfo(cond);
        // �f�[�^��0���̏ꍇ
        if (list.size() == 0) {
            return null;
        }
        return list.get(0);
    }
}

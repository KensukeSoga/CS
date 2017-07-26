package jp.co.isid.kkh.model.login;

import java.util.List;

import jp.co.isid.kkh.model.base.KKHException;

/**
 * <P>
 * ���Ӑ��񌟍�Manager�B
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/02/13 JSE H.Abe)<BR>
 * </P>
 *
 * @author JSE H.Abe
 */
public class CustomerInfoManager {

    /** �V���O���g���C���X�^���X */
    private static CustomerInfoManager _manager = new CustomerInfoManager();

    /**
     * �V���O���g���ׁ̈A�C���X�^���X�����֎~���܂��B
     */
    private CustomerInfoManager() {
    }

    /**
     * �C���X�^���X��Ԃ��܂��B
     *
     * @return �C���X�^���X
     */
    public static CustomerInfoManager getInstance() {
        return _manager;
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
     * ���ʃ��[�U�[���̎擾
     *
     * @param cond ��������
     * @return ���ʃ��[�U�[���VO
     * @throws KKHException �������ɃG���[�����������ꍇ
     */
    public ThbdSpUsVO getSpecialUserInfo(ThbdSpUsCondition cond) throws KKHException {

        ThbdSpUsDAO dao = ThbdSpUsDAOFactory.createThbdSpUsDAO();
        List<ThbdSpUsVO> list = dao.getSpecialLoginUserInfo(cond);
        // �f�[�^��0���̏ꍇ
        if (list.size() == 0) {
            return null;
        }
        return list.get(0);
    }
}

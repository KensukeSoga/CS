package jp.co.isid.kkh.model.login;

import java.util.List;

import jp.co.isid.kkh.model.base.KKHException;

/**
 * <P>
 * �J�����Ӑ��񌟍�Manager�B
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/02/13 JSE H.Abe)<BR>
 * </P>
 *
 * @author JSE H.Abe
 */
public class OpenCustomerInfoManager {

    /** �V���O���g���C���X�^���X */
    private static OpenCustomerInfoManager _manager = new OpenCustomerInfoManager();

    /**
     * �V���O���g���ׁ̈A�C���X�^���X�����֎~���܂��B
     */
    private OpenCustomerInfoManager() {
    }

    /**
     * �C���X�^���X��Ԃ��܂��B
     *
     * @return �C���X�^���X
     */
    public static OpenCustomerInfoManager getInstance() {
        return _manager;
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

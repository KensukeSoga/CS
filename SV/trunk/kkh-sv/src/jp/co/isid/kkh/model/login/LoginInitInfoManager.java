package jp.co.isid.kkh.model.login;

import java.util.List;

import jp.co.isid.kkh.model.base.KKHException;

/**
 * <P>
 * ���O�C���������擾Manager�B
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/02/13 JSE H.Abe)<BR>
 * </P>
 *
 * @author JSE H.Abe
 */
public class LoginInitInfoManager {

    /** �V���O���g���C���X�^���X */
    private static LoginInitInfoManager _manager = new LoginInitInfoManager();

    /**
     * �V���O���g���ׁ̈A�C���X�^���X�����֎~���܂��B
     */
    private LoginInitInfoManager() {
    }

    /**
     * �C���X�^���X��Ԃ��܂��B
     *
     * @return �C���X�^���X
     */
    public static LoginInitInfoManager getInstance() {
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

}

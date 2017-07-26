package jp.co.isid.kkh.customer.tkd.model.detail;

import jp.co.isid.kkh.model.base.KKHException;

public class AutoJissiBycondManager {

    /** �V���O���g���C���X�^���X */
    private static AutoJissiBycondManager _manager = new AutoJissiBycondManager();

    /**
     * �V���O���g���ׁ̈A�C���X�^���X�����֎~���܂��B
     */
    private AutoJissiBycondManager() {
    }

    /**
     * �C���X�^���X��Ԃ��܂��B
     *
     * @return �C���X�^���X
     */
    public static AutoJissiBycondManager getInstance() {
        return _manager;
    }

    /**
     * ���{No�����t�^�̓o�^
     * @param vo
     * @throws KKHException
     */
    public void audateJissiData(AutoJissiBycondVO vo) throws KKHException{

        AutoJissiBycondDAO dao = AutoJissiBycondDAOFactory.createAutojissiDAO();
        dao.AutojissiUp(vo);
    }
}

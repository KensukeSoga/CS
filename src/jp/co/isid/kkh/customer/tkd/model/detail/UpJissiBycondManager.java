package jp.co.isid.kkh.customer.tkd.model.detail;

import jp.co.isid.kkh.model.base.KKHException;

public class UpJissiBycondManager {

    /** �V���O���g���C���X�^���X */
    private static UpJissiBycondManager _manager = new UpJissiBycondManager();

    /**
     * �V���O���g���ׁ̈A�C���X�^���X�����֎~���܂��B
     */
    private UpJissiBycondManager() {
    }

    /**
     * �C���X�^���X��Ԃ��܂��B
     *
     * @return �C���X�^���X
     */
    public static UpJissiBycondManager getInstance() {
        return _manager;
    }

    /**
     * ���{No����UP/DOWN�o�^
     * @param vo
     * @throws KKHException
     */
    public void updateJissiData(UpJissiBycondVO vo) throws KKHException{

    UpJissiBycondDAO dao = UpJissiBycondDAOFactory.createUpjissiDAO();
    dao.jissiUp(vo);
    }

}

package jp.co.isid.kkh.model.detail;

import jp.co.isid.kkh.model.base.KKHException;

public class JyutNoTouUpdateManager {

    /** �V���O���g���C���X�^���X */
    private static JyutNoTouUpdateManager _manager = new JyutNoTouUpdateManager();

    /**
     * �V���O���g���ׁ̈A�C���X�^���X�����֎~���܂��B
     */
    private JyutNoTouUpdateManager() {
    }

    /**
     * �C���X�^���X��Ԃ��܂��B
     *
     * @return �C���X�^���X
     */
    public static JyutNoTouUpdateManager getInstance() {
        return _manager;
    }

    /**
     * �����ԍ�����
     * @param vo
     * @throws KKHException
     */
    public void jyutNoTouUpDateData(JyutNoTouUpdateVO vo) throws KKHException{

        JyutNoTouUpdateDAO dao = JyutNoTouUpdateDAOFactory.createJyutNoTouUpdateDAO();
        dao.JyutNoTouUpdate(vo);
    }

}

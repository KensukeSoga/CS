package jp.co.isid.kkh.model.detail;

import jp.co.isid.kkh.model.base.KKHException;

public class JyutNoTouInsManager {

    /** �V���O���g���C���X�^���X */
    private static JyutNoTouInsManager _manager = new JyutNoTouInsManager();

    /**
     * �V���O���g���ׁ̈A�C���X�^���X�����֎~���܂��B
     */
    private JyutNoTouInsManager() {
    }

    /**
     * �C���X�^���X��Ԃ��܂��B
     *
     * @return �C���X�^���X
     */
    public static JyutNoTouInsManager getInstance() {
        return _manager;
    }

    /**
     * �����ԍ�����
     * @param vo
     * @throws KKHException
     */
    public void jyutNoTouInsDateData(JyutNoTouInsVO vo) throws KKHException{

        JyutNoTouInsDAO dao = JyutNoTouInsDAOFactory.createJyutNoTouUpdateDAO();
        dao.JyutNoTouIns(vo);
    }

}

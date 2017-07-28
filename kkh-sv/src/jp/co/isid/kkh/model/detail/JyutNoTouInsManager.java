package jp.co.isid.kkh.model.detail;

import jp.co.isid.kkh.model.base.KKHException;

public class JyutNoTouInsManager {

    /** シングルトンインスタンス */
    private static JyutNoTouInsManager _manager = new JyutNoTouInsManager();

    /**
     * シングルトンの為、インスタンス化を禁止します。
     */
    private JyutNoTouInsManager() {
    }

    /**
     * インスタンスを返します。
     *
     * @return インスタンス
     */
    public static JyutNoTouInsManager getInstance() {
        return _manager;
    }

    /**
     * 発注番号統合
     * @param vo
     * @throws KKHException
     */
    public void jyutNoTouInsDateData(JyutNoTouInsVO vo) throws KKHException{

        JyutNoTouInsDAO dao = JyutNoTouInsDAOFactory.createJyutNoTouUpdateDAO();
        dao.JyutNoTouIns(vo);
    }

}

package jp.co.isid.kkh.model.detail;

import jp.co.isid.kkh.model.base.KKHException;

public class JyutNoTouUpdateManager {

    /** シングルトンインスタンス */
    private static JyutNoTouUpdateManager _manager = new JyutNoTouUpdateManager();

    /**
     * シングルトンの為、インスタンス化を禁止します。
     */
    private JyutNoTouUpdateManager() {
    }

    /**
     * インスタンスを返します。
     *
     * @return インスタンス
     */
    public static JyutNoTouUpdateManager getInstance() {
        return _manager;
    }

    /**
     * 発注番号統合
     * @param vo
     * @throws KKHException
     */
    public void jyutNoTouUpDateData(JyutNoTouUpdateVO vo) throws KKHException{

        JyutNoTouUpdateDAO dao = JyutNoTouUpdateDAOFactory.createJyutNoTouUpdateDAO();
        dao.JyutNoTouUpdate(vo);
    }

}

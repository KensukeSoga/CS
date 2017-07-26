package jp.co.isid.kkh.customer.tkd.model.detail;

import jp.co.isid.kkh.model.base.KKHException;

public class UpJissiBycondManager {

    /** シングルトンインスタンス */
    private static UpJissiBycondManager _manager = new UpJissiBycondManager();

    /**
     * シングルトンの為、インスタンス化を禁止します。
     */
    private UpJissiBycondManager() {
    }

    /**
     * インスタンスを返します。
     *
     * @return インスタンス
     */
    public static UpJissiBycondManager getInstance() {
        return _manager;
    }

    /**
     * 実施No自動UP/DOWN登録
     * @param vo
     * @throws KKHException
     */
    public void updateJissiData(UpJissiBycondVO vo) throws KKHException{

    UpJissiBycondDAO dao = UpJissiBycondDAOFactory.createUpjissiDAO();
    dao.jissiUp(vo);
    }

}

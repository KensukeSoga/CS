package jp.co.isid.kkh.customer.tkd.model.detail;

import jp.co.isid.kkh.model.base.KKHException;

public class AutoJissiBycondManager {

    /** シングルトンインスタンス */
    private static AutoJissiBycondManager _manager = new AutoJissiBycondManager();

    /**
     * シングルトンの為、インスタンス化を禁止します。
     */
    private AutoJissiBycondManager() {
    }

    /**
     * インスタンスを返します。
     *
     * @return インスタンス
     */
    public static AutoJissiBycondManager getInstance() {
        return _manager;
    }

    /**
     * 実施No自動付与の登録
     * @param vo
     * @throws KKHException
     */
    public void audateJissiData(AutoJissiBycondVO vo) throws KKHException{

        AutoJissiBycondDAO dao = AutoJissiBycondDAOFactory.createAutojissiDAO();
        dao.AutojissiUp(vo);
    }
}

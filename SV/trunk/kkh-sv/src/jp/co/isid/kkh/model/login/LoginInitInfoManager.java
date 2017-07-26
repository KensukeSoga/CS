package jp.co.isid.kkh.model.login;

import java.util.List;

import jp.co.isid.kkh.model.base.KKHException;

/**
 * <P>
 * ログイン初期情報取得Manager。
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/02/13 JSE H.Abe)<BR>
 * </P>
 *
 * @author JSE H.Abe
 */
public class LoginInitInfoManager {

    /** シングルトンインスタンス */
    private static LoginInitInfoManager _manager = new LoginInitInfoManager();

    /**
     * シングルトンの為、インスタンス化を禁止します。
     */
    private LoginInitInfoManager() {
    }

    /**
     * インスタンスを返します。
     *
     * @return インスタンス
     */
    public static LoginInitInfoManager getInstance() {
        return _manager;
    }

    /**
     * 個人情報の取得
     *
     * @param cond 検索条件
     * @return 個人情報VO
     * @throws KKHException 処理中にエラーが発生した場合
     */
    public Vkj01AccuserVO getPersonalInfo(Vkj01AccuserCondition cond) throws KKHException {

        Vkj01AccuserDAO dao = Vkj01AccuserDAOFactory.createVkj01AccuserDAO();
        List<Vkj01AccuserVO> list = dao.getPersonalInfo(cond);
        // データが0件の場合
        if (list.size() == 0) {
            return null;
        }
        return list.get(0);
    }

}

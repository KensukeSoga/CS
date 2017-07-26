package jp.co.isid.kkh.model.login;

import java.util.List;

import jp.co.isid.kkh.model.base.KKHException;

/**
 * <P>
 * 開放得意先情報検索Manager。
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/02/13 JSE H.Abe)<BR>
 * </P>
 *
 * @author JSE H.Abe
 */
public class OpenCustomerInfoManager {

    /** シングルトンインスタンス */
    private static OpenCustomerInfoManager _manager = new OpenCustomerInfoManager();

    /**
     * シングルトンの為、インスタンス化を禁止します。
     */
    private OpenCustomerInfoManager() {
    }

    /**
     * インスタンスを返します。
     *
     * @return インスタンス
     */
    public static OpenCustomerInfoManager getInstance() {
        return _manager;
    }

    /**
     * 開放得意先情報の取得
     *
     * @param cond 検索条件
     * @return 開放得意先情報VO
     * @throws KKHException 処理中にエラーが発生した場合
     */
    public ThbcKhtVO getOpenCustomerInfo(ThbcKhtCondition cond) throws KKHException {

        ThbcKhtDAO dao = ThbcKhtDAOFactory.createThbcKhtDAO();
        List<ThbcKhtVO> list = dao.getOpenCustomerInfo(cond);
        // データが0件の場合
        if (list.size() == 0) {
            return null;
        }
        return list.get(0);
    }
}

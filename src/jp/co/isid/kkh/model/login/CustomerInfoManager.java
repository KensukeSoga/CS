package jp.co.isid.kkh.model.login;

import java.util.List;

import jp.co.isid.kkh.model.base.KKHException;

/**
 * <P>
 * 得意先情報検索Manager。
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/02/13 JSE H.Abe)<BR>
 * </P>
 *
 * @author JSE H.Abe
 */
public class CustomerInfoManager {

    /** シングルトンインスタンス */
    private static CustomerInfoManager _manager = new CustomerInfoManager();

    /**
     * シングルトンの為、インスタンス化を禁止します。
     */
    private CustomerInfoManager() {
    }

    /**
     * インスタンスを返します。
     *
     * @return インスタンス
     */
    public static CustomerInfoManager getInstance() {
        return _manager;
    }

    /**
     * 得意先情報の取得
     *
     * @param cond 検索条件
     * @return 得意先情報VO
     * @throws KKHException 処理中にエラーが発生した場合
     */
    public RcmnMeu12ThskgyVO getCustomerInfo(RcmnMeu12ThskgyCondition cond) throws KKHException {

        RcmnMeu12ThskgyDAO dao = RcmnMeu12ThskgyDAOFactory.createRcmnMeu12ThskgyDAO();
        List<RcmnMeu12ThskgyVO> list = dao.getCustomerInfo(cond);
        // データが0件の場合
        if (list.size() == 0) {
            return null;
        }
        return list.get(0);
    }

    /**
     * 特別ユーザー情報の取得
     *
     * @param cond 検索条件
     * @return 特別ユーザー情報VO
     * @throws KKHException 処理中にエラーが発生した場合
     */
    public ThbdSpUsVO getSpecialUserInfo(ThbdSpUsCondition cond) throws KKHException {

        ThbdSpUsDAO dao = ThbdSpUsDAOFactory.createThbdSpUsDAO();
        List<ThbdSpUsVO> list = dao.getSpecialLoginUserInfo(cond);
        // データが0件の場合
        if (list.size() == 0) {
            return null;
        }
        return list.get(0);
    }
}

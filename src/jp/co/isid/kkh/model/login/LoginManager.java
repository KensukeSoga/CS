package jp.co.isid.kkh.model.login;

import java.util.List;

import jp.co.isid.kkh.model.base.KKHException;

/**
 * <P>
 * ログインManager。
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/02/13 JSE H.Abe)<BR>
 * </P>
 *
 * @author JSE H.Abe
 */
public class LoginManager {

    /** シングルトンインスタンス */
    private static LoginManager _manager = new LoginManager();

    /**
     * シングルトンの為、インスタンス化を禁止します。
     */
    private LoginManager() {
    }

    /**
     * インスタンスを返します。
     *
     * @return インスタンス
     */
    public static LoginManager getInstance() {
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
     * スーパーユーザー情報の取得
     *
     * @param cond 検索条件
     * @return スーパーユーザー情報VO
     * @throws KKHException 処理中にエラーが発生した場合
     */
    public ThbdSpUsVO getSuperUserInfo(ThbdSpUsCondition cond) throws KKHException {

        ThbdSpUsDAO dao = ThbdSpUsDAOFactory.createThbdSpUsDAO();
        List<ThbdSpUsVO> list = dao.getSuperUserInfo(cond);
        // データが0件の場合
        if (list.size() == 0) {
            return null;
        }
        return list.get(0);
    }

    /**
     * 特別ログインユーザー情報の取得
     *
     * @param cond 検索条件
     * @return 特別ログインユーザー情報VOリスト
     * @throws KKHException 処理中にエラーが発生した場合
     */
    public List<ThbdSpUsVO> getSpecialLoginUserInfo(ThbdSpUsCondition cond) throws KKHException {

        ThbdSpUsDAO dao = ThbdSpUsDAOFactory.createThbdSpUsDAO();
        return dao.getSpecialLoginUserInfo(cond);
    }

    /**
     * 職位グループ情報の取得
     *
     * @param cond 検索条件
     * @return 職位等級グループ情報VOリスト
     * @throws KKHException 処理中にエラーが発生した場合
     */
    public List<Vkj02TitleClassGroupInfoVO> getGroupInfo(Vkj02TitleClassGroupInfoCondition cond) throws KKHException {

        Vkj02TitleClassGroupInfoDAO dao = Vkj02TitleClassGroupInfoDAOFactory.createVkj02TitleClassGroupInfoDAO();
        return dao.getGroupInfo(cond);
    }

    /**
     * 営業所情報取得の取得
     *
     * @param cond 検索条件
     * @return 営業所情報取得VO
     * @throws KKHException 処理中にエラーが発生した場合
     */
    public RcmnMeu00SikVO getBusinessOfficeInfo(RcmnMeu00SikCondition cond) throws KKHException {

        RcmnMeu00SikDAO dao = RcmnMeu00SikDAOFactory.createRcmnMeu00SikDAO();
        List<RcmnMeu00SikVO> list = dao.getBusinessOfficeInfo(cond);
        // データが0件の場合
        if (list.size() == 0) {
            return null;
        }
        return list.get(0);
    }

    /**
     * 取引先担当情報の取得
     *
     * @param cond 検索条件
     * @return 取引先担当情報VO
     * @throws KKHException 処理中にエラーが発生した場合
     */
    public List<RcmnMeu14ThstntTrVO> getCustomerChargeInfo(RcmnMeu14ThstntTrCondition cond) throws KKHException {

        RcmnMeu14ThstntTrDAO dao = RcmnMeu14ThstntTrDAOFactory.createRcmnMeu14ThstntTrDAO();
        return dao.getCustomerChargeInfo(cond);
    }

    /**
     * 特別得意先情報の取得
     *
     * @param cond 検索条件
     * @return 特別得意先情報VO
     * @throws KKHException 処理中にエラーが発生した場合
     */
    public ThbdSpUsVO getSpecialCustomerInfo(ThbdSpUsCondition cond) throws KKHException {

        ThbdSpUsDAO dao = ThbdSpUsDAOFactory.createThbdSpUsDAO();
        List<ThbdSpUsVO> list = dao.getSpecialCustomerInfo(cond);
        // データが0件の場合
        if (list.size() == 0) {
            return null;
        }
        return list.get(0);
    }

    /**
     * 経理組織展開情報の取得
     *
     * @param cond 検索条件
     * @return 経理組織展開情報VO
     * @throws KKHException 処理中にエラーが発生した場合
     */
    public RcmnMeu07SikkrsprdVO getAccountingOrganizationInfo(RcmnMeu07SikkrsprdCondition cond) throws KKHException {

        RcmnMeu07SikkrsprdDAO dao = RcmnMeu07SikkrsprdDAOFactory.createRcmnMeu07SikkrsprdDAO();
        List<RcmnMeu07SikkrsprdVO> list = dao.getAccountingOrganizationInfo(cond);
        // データが0件の場合
        if (list.size() == 0) {
            return null;
        }
        return list.get(0);
    }

    /**
     * 公開範囲情報の取得
     *
     * @param cond 検索条件
     * @return 公開範囲情報VO
     * @throws KKHException 処理中にエラーが発生した場合
     */
    public Tcm01KkhVO getOpenRange(Tcm01KkhCondition cond) throws KKHException {

        Tcm01KkhDAO dao = Tcm01KkhDAOFactory.createTcm01KkhDAO();
        List<Tcm01KkhVO> list = dao.getOpenRange(cond);
        // データが0件の場合
        if (list.size() == 0) {
            return null;
        }
        return list.get(0);
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

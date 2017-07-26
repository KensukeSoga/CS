package jp.co.isid.kkh.model.login;

import jp.co.isid.nj.integ.DaoFactory;

/**
 * <P>
 * 取引先情報DAOのファクトリクラス
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/02/13 JSE H.Abe)<BR>
 * </P>
 *
 * @author JSE H.Abe
 */
public class RcmnMeu12ThskgyDAOFactory extends DaoFactory {

    /**
     * インスタンス化を禁止します。
     */
    private RcmnMeu12ThskgyDAOFactory() {
    }

    /**
     * DAOインスタンスを生成します。
     *
     * @return DAOインスタンス
     */
    public static RcmnMeu12ThskgyDAO createRcmnMeu12ThskgyDAO() {
        return (RcmnMeu12ThskgyDAO) DaoFactory.createDao(RcmnMeu12ThskgyDAO.class);
    }
}

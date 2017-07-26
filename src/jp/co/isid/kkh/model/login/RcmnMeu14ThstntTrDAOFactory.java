package jp.co.isid.kkh.model.login;

import jp.co.isid.nj.integ.DaoFactory;

/**
 * <P>
 * 取引先担当情報DAOのファクトリクラス
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/02/13 JSE H.Abe)<BR>
 * </P>
 *
 * @author JSE H.Abe
 */
public class RcmnMeu14ThstntTrDAOFactory extends DaoFactory {

    /**
     * インスタンス化を禁止します。
     */
    private RcmnMeu14ThstntTrDAOFactory() {
    }

    /**
     * DAOインスタンスを生成します。
     *
     * @return DAOインスタンス
     */
    public static RcmnMeu14ThstntTrDAO createRcmnMeu14ThstntTrDAO() {
        return (RcmnMeu14ThstntTrDAO) DaoFactory.createDao(RcmnMeu14ThstntTrDAO.class);
    }
}

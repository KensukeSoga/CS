package jp.co.isid.kkh.model.login;

import jp.co.isid.nj.integ.DaoFactory;

/**
 * <P>
 * 組織マスタDAOのファクトリクラス
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/02/13 JSE H.Abe)<BR>
 * </P>
 *
 * @author JSE H.Abe
 */
public class RcmnMeu00SikDAOFactory extends DaoFactory {

    /**
     * インスタンス化を禁止します。
     */
    private RcmnMeu00SikDAOFactory() {
    }

    /**
     * DAOインスタンスを生成します。
     *
     * @return DAOインスタンス
     */
    public static RcmnMeu00SikDAO createRcmnMeu00SikDAO() {
        return (RcmnMeu00SikDAO) DaoFactory.createDao(RcmnMeu00SikDAO.class);
    }
}

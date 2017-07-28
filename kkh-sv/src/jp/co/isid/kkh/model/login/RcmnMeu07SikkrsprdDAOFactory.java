package jp.co.isid.kkh.model.login;

import jp.co.isid.nj.integ.DaoFactory;

/**
 * <P>
 * 経理組織展開情報DAOのファクトリクラス
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/02/13 JSE H.Abe)<BR>
 * </P>
 *
 * @author JSE H.Abe
 */
public class RcmnMeu07SikkrsprdDAOFactory extends DaoFactory {

    /**
     * インスタンス化を禁止します。
     */
    private RcmnMeu07SikkrsprdDAOFactory() {
    }

    /**
     * DAOインスタンスを生成します。
     *
     * @return DAOインスタンス
     */
    public static RcmnMeu07SikkrsprdDAO createRcmnMeu07SikkrsprdDAO() {
        return (RcmnMeu07SikkrsprdDAO) DaoFactory.createDao(RcmnMeu07SikkrsprdDAO.class);
    }
}

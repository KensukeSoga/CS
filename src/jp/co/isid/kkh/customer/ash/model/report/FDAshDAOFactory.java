package jp.co.isid.kkh.customer.ash.model.report;

import jp.co.isid.nj.integ.DaoFactory;

/**
 * <P>
 *請求データ一覧検索DAOのファクトリクラス
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * </P>
 * @author
 */
public class FDAshDAOFactory extends DaoFactory {

    /**
    * インスタンス化を禁止します。
    */
    private FDAshDAOFactory() {
    }

    /**
    * DAOインスタンスを生成します。
    * @return DAOインスタンス
    */
    public static FDAshDAO createFDAshDAO() {
        return (FDAshDAO) DaoFactory.createDao(FDAshDAO.class);
    }

}

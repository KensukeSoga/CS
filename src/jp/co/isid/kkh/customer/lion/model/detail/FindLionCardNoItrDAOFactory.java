package jp.co.isid.kkh.customer.lion.model.detail;

import jp.co.isid.nj.integ.DaoFactory;


/**
 * <P>
 * 汎用マスタ検索DAOのファクトリクラス
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/02/21 JSE A.Naito)<BR>
 * </P>
 * @author JSE A.Naito
 */
public class FindLionCardNoItrDAOFactory extends DaoFactory {

    /**
    * インスタンス化を禁止します。
    */
    private FindLionCardNoItrDAOFactory() {
    }

    /**
    * DAOインスタンスを生成します。
    * @return DAOインスタンス
    */
    public static FindLionCardNoItrDAO createFindLionCardNoItrDAO() {
        return (FindLionCardNoItrDAO) DaoFactory.createDao(FindLionCardNoItrDAO.class);
    }
}

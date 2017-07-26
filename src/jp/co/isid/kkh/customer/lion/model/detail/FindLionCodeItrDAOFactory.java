package jp.co.isid.kkh.customer.lion.model.detail;

import jp.co.isid.nj.integ.DaoFactory;


/**
 * <P>
 * 汎用マスタ検索DAOのファクトリクラス
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/02/27 JSE A.Naito)<BR>
 * </P>
 * @author JSE A.Naito
 */
public class FindLionCodeItrDAOFactory extends DaoFactory {

    /**
    * インスタンス化を禁止します。
    */
    private FindLionCodeItrDAOFactory() {
    }

    /**
    * DAOインスタンスを生成します。
    * @return DAOインスタンス
    */
    public static FindLionCodeItrDAO createFindLionCodeItrDAO() {
        return (FindLionCodeItrDAO) DaoFactory.createDao(FindLionCodeItrDAO.class);
    }
}

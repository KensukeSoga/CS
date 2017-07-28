package jp.co.isid.kkh.customer.lion.model.master;

import jp.co.isid.nj.integ.DaoFactory;


/**
 * <P>
 * 汎用マスタ検索DAOのファクトリクラス
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/02/20 JSE A.Naito)<BR>
 * </P>
 * @author JSE A.Naito
 */
public class FindRdKMastDAOFactory extends DaoFactory {

    /**
    * インスタンス化を禁止します。
    */
    private FindRdKMastDAOFactory() {
    }

    /**
    * DAOインスタンスを生成します。
    * @return DAOインスタンス
    */
    public static FindRdKMastDAO createFindRdKMastDAO() {
        return (FindRdKMastDAO) DaoFactory.createDao(FindRdKMastDAO.class);
    }
}

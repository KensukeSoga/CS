package jp.co.isid.kkh.model.master;

import jp.co.isid.nj.integ.DaoFactory;


/**
 * <P>
 * 汎用マスタ検索DAOのファクトリクラス
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/2/3 Fourm H.izawa)<BR>
 * </P>
 * @author
 */
public class MasterItemDAOFactory extends DaoFactory {

    /**
    * インスタンス化を禁止します。
    */
    private MasterItemDAOFactory() {
    }

    /**
    * DAOインスタンスを生成します。
    * @return DAOインスタンス
    */
    public static MasterItemDAO createMasterItemDAO() {
        return (MasterItemDAO) DaoFactory.createDao(MasterItemDAO.class);
    }
}

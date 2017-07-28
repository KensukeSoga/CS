package jp.co.isid.kkh.model.master;

import jp.co.isid.nj.integ.DaoFactory;


/**
 * <P>
 * 汎用マスタ検索DAOのファクトリクラス
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2011/11/07 JSE K.Fukuda)<BR>
 * </P>
 * @author
 */
public class MasterDAOFactory extends DaoFactory {

    /**
    * インスタンス化を禁止します。
    */
    private MasterDAOFactory() {
    }

    /**
    * DAOインスタンスを生成します。
    * @return DAOインスタンス
    */
    public static MasterDAO createMasterDAO() {
        return (MasterDAO) DaoFactory.createDao(MasterDAO.class);
    }
}

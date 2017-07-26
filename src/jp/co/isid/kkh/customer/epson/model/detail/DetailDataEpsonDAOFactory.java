package jp.co.isid.kkh.customer.epson.model.detail;

import jp.co.isid.nj.integ.DaoFactory;


/**
 * <P>
 * 汎用マスタ検索DAOのファクトリクラス
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/3/5 IP.Shimizu)<BR>
 * </P>
 * @author
 */
public class DetailDataEpsonDAOFactory extends DaoFactory {

    /**
    * インスタンス化を禁止します。
    */
    private DetailDataEpsonDAOFactory() {
    }

    /**
    * DAOインスタンスを生成します。
    * @return DAOインスタンス
    */
    public static DetailDataEpsonDAO createDetailDataDAO() {
        return (DetailDataEpsonDAO) DaoFactory.createDao(DetailDataEpsonDAO.class);
    }
}

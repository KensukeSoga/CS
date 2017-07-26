package jp.co.isid.kkh.customer.acom.model.detail;

import jp.co.isid.nj.integ.DaoFactory;


/**
 * <P>
 * 汎用マスタ検索DAOのファクトリクラス
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/1/10 form izawa)<BR>
 * </P>
 * @author
 */
public class Thb5HikDAOFactory extends DaoFactory {

    /**
    * インスタンス化を禁止します。
    */
    private Thb5HikDAOFactory() {
    }

    /**
    * DAOインスタンスを生成します。
    * @return DAOインスタンス
    */
    public static Thb5HikDAO createThb5HikDAO() {
        return (Thb5HikDAO) DaoFactory.createDao(Thb5HikDAO.class);
    }
}

package jp.co.isid.kkh.model.log;

import jp.co.isid.nj.integ.DaoFactory;


/**
 * <P>
 * 汎用ログ検索DAOのファクトリクラス
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2011/11/11 IP H.Shimizu)<BR>
 * </P>
 * @author
 */
public class LogDAOFactory extends DaoFactory {

    /**
    * インスタンス化を禁止します。
    */
    private LogDAOFactory() {
    }

    /**
    * DAOインスタンスを生成します。
    * @return DAOインスタンス
    */
    public static LogDAO createLogDAO() {
        return (LogDAO) DaoFactory.createDao(LogDAO.class);
    }
}

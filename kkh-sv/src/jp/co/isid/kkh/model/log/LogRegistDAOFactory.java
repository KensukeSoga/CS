package jp.co.isid.kkh.model.log;

import jp.co.isid.kkh.model.log.LogRegistDAO;
import jp.co.isid.nj.integ.DaoFactory;


/**
 * <P>
 * 汎用ログデータ登録DAOのファクトリクラス
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2011/11/17 IP H.Shimizu)<BR>
 * </P>
 * @author IP H.Shimizu
 */
final class LogRegistDAOFactory extends DaoFactory {

    /**
    * インスタンス化を禁止します。
    */
    private LogRegistDAOFactory() {
    }

    /**
     * 更新DAOインスタンスを生成します。
     * @return 更新・削除DAOインスタンス
     */
    public static LogRegistDAO createLogRegistDAO() {
        return (LogRegistDAO) DaoFactory.createDao(LogRegistDAO.class);
    }
}

package jp.co.isid.kkh.model.history;

import jp.co.isid.nj.integ.DaoFactory;


/**
 * <P>
 *媒体別一覧検索DAOのファクトリクラス
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2011/1/20 fourm h.izawa)<BR>
 * </P>
 * @author
 */
public class HistoryJyutDownDAOFactory extends DaoFactory {

    /**
    * インスタンス化を禁止します。
    */
    private HistoryJyutDownDAOFactory() {
    }

    /**
    * DAOインスタンスを生成します。
    * @return DAOインスタンス
    */
    public static HistoryJyutDownDAO createHistoryLionJyutDownDAO() {
        return (HistoryJyutDownDAO) DaoFactory.createDao(HistoryJyutDownDAO.class);
    }
}

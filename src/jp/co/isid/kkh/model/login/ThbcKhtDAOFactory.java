package jp.co.isid.kkh.model.login;

import jp.co.isid.nj.integ.DaoFactory;

/**
 * <P>
 * 開放得意先管理情報DAOのファクトリクラス
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/02/13 JSE H.Abe)<BR>
 * </P>
 *
 * @author JSE H.Abe
 */
public class ThbcKhtDAOFactory extends DaoFactory {

    /**
     * インスタンス化を禁止します。
     */
    private ThbcKhtDAOFactory() {
    }

    /**
     * DAOインスタンスを生成します。
     *
     * @return DAOインスタンス
     */
    public static ThbcKhtDAO createThbcKhtDAO() {
        return (ThbcKhtDAO) DaoFactory.createDao(ThbcKhtDAO.class);
    }
}

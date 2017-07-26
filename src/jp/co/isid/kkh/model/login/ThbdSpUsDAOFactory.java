package jp.co.isid.kkh.model.login;

import jp.co.isid.nj.integ.DaoFactory;

/**
 * <P>
 * 特別ユーザーマスタDAOのファクトリクラス
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/02/13 JSE H.Abe)<BR>
 * </P>
 *
 * @author JSE H.Abe
 */
public class ThbdSpUsDAOFactory extends DaoFactory {

    /**
     * インスタンス化を禁止します。
     */
    private ThbdSpUsDAOFactory() {
    }

    /**
     * DAOインスタンスを生成します。
     *
     * @return DAOインスタンス
     */
    public static ThbdSpUsDAO createThbdSpUsDAO() {
        return (ThbdSpUsDAO) DaoFactory.createDao(ThbdSpUsDAO.class);
    }
}

package jp.co.isid.kkh.model.login;

import jp.co.isid.nj.integ.DaoFactory;

/**
 * <P>
 * 公開範囲情報DAOのファクトリクラス
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/02/13 JSE H.Abe)<BR>
 * </P>
 *
 * @author JSE H.Abe
 */
public class Tcm01KkhDAOFactory extends DaoFactory {

    /**
     * インスタンス化を禁止します。
     */
    private Tcm01KkhDAOFactory() {
    }

    /**
     * DAOインスタンスを生成します。
     *
     * @return DAOインスタンス
     */
    public static Tcm01KkhDAO createTcm01KkhDAO() {
        return (Tcm01KkhDAO) DaoFactory.createDao(Tcm01KkhDAO.class);
    }
}

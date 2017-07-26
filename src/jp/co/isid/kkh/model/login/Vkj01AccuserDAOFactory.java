package jp.co.isid.kkh.model.login;

import jp.co.isid.nj.integ.DaoFactory;

/**
 * <P>
 * 個人情報VIEWDAOのファクトリクラス
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/02/13 JSE H.Abe)<BR>
 * </P>
 *
 * @author JSE H.Abe
 */
public class Vkj01AccuserDAOFactory extends DaoFactory {

    /**
     * インスタンス化を禁止します。
     */
    private Vkj01AccuserDAOFactory() {
    }

    /**
     * DAOインスタンスを生成します。
     *
     * @return DAOインスタンス
     */
    public static Vkj01AccuserDAO createVkj01AccuserDAO() {
        return (Vkj01AccuserDAO) DaoFactory.createDao(Vkj01AccuserDAO.class);
    }
}

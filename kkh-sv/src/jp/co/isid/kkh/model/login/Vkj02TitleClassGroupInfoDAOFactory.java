package jp.co.isid.kkh.model.login;

import jp.co.isid.nj.integ.DaoFactory;

/**
 * <P>
 * 職位等級グループ情報DAOのファクトリクラス
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/02/13 JSE H.Abe)<BR>
 * </P>
 *
 * @author JSE H.Abe
 */
public class Vkj02TitleClassGroupInfoDAOFactory extends DaoFactory {

    /**
     * インスタンス化を禁止します。
     */
    private Vkj02TitleClassGroupInfoDAOFactory() {
    }

    /**
     * DAOインスタンスを生成します。
     *
     * @return DAOインスタンス
     */
    public static Vkj02TitleClassGroupInfoDAO createVkj02TitleClassGroupInfoDAO() {
        return (Vkj02TitleClassGroupInfoDAO) DaoFactory.createDao(Vkj02TitleClassGroupInfoDAO.class);
    }
}

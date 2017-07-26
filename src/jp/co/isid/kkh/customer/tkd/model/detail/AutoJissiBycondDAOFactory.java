package jp.co.isid.kkh.customer.tkd.model.detail;


import jp.co.isid.nj.integ.DaoFactory;


/**
 * <P>
 * 実施NO自動UP/DOWN（実施No自動付与）用DAOのファクトリクラス
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2011/12/7 Fourm H.izawa)<BR>
 * </P>
 * @author Fourm H.izawa
 */
final class AutoJissiBycondDAOFactory extends DaoFactory {

    /**
    * インスタンス化を禁止します。
    */
    private AutoJissiBycondDAOFactory() {
    }

    /**
     * 更新DAOインスタンスを生成します。
     * @return 更新・削除DAOインスタンス
     */
    public static AutoJissiBycondDAO createAutojissiDAO() {
        return (AutoJissiBycondDAO) DaoFactory.createDao(AutoJissiBycondDAO.class);
    }
}

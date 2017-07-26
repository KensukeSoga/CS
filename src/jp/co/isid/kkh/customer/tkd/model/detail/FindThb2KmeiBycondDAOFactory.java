package jp.co.isid.kkh.customer.tkd.model.detail;

import jp.co.isid.nj.integ.DaoFactory;

/**
 * <P>
 * 実施No取得DAOのファクトリクラス
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2011/12/7 Fourm H.izawa)<BR>
 * </P>
 * @author Fourm H.izawa
 */
final class FindThb2KmeiBycondDAOFactory extends DaoFactory {

    /**
    * インスタンス化を禁止します。
    */
    private FindThb2KmeiBycondDAOFactory() {
    }

    /**
     * 実施No取得DAOインスタンスを生成します。
     * @return 実施No取得DAOインスタンス
     */
    public static FindThb2KmeiBycondDAO createFindThb2KmeiBycondDAO() {
        return (FindThb2KmeiBycondDAO) DaoFactory.createDao(FindThb2KmeiBycondDAO.class);
    }
}


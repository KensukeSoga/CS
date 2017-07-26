package jp.co.isid.kkh.customer.acom.model.claim;

import jp.co.isid.nj.integ.DaoFactory;

/**
 * <P>
 * 発注/請求番号 一覧情報取得DAOのファクトリクラス
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/2/2 JSE Y.Sato)<BR>
 * </P>
 *
 * @author JSE Y.Sato
 */
final class FindClaimByCondDAOFactory extends DaoFactory {

    /**
     * インスタンス化を禁止します。
     */
    private FindClaimByCondDAOFactory() {
    }

    /**
     * データ取得DAOインスタンスを生成します。
     *
     * @return DAOインスタンス
     */
    public static FindClaimByCondDAO createFindKenMeisaiByCondDAO() {
        return (FindClaimByCondDAO) DaoFactory.createDao(FindClaimByCondDAO.class);
    }
}

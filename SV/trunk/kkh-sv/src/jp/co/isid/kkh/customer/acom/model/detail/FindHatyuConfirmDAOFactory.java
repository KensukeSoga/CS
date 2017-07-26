package jp.co.isid.kkh.customer.acom.model.detail;

import jp.co.isid.nj.integ.DaoFactory;

/**
 * <P>
 * 発注データ登録DAOのファクトリクラス
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2011/12/22 Fourm H.izawa)<BR>
 * </P>
 * @author Fourm H.izawa
 */
final class FindHatyuConfirmDAOFactory extends DaoFactory {

    /**
    * インスタンス化を禁止します。
    */
    private FindHatyuConfirmDAOFactory() {
    }

    /**
     * 更新DAOインスタンスを生成します。
     * @return 更新・削除DAOインスタンス
     */
    public static FindHatyuConfirmDAO createfinetgr84hikDAO() {
        return (FindHatyuConfirmDAO) DaoFactory.createDao(FindHatyuConfirmDAO.class);
    }

}

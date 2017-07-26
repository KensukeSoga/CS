package jp.co.isid.kkh.customer.acom.model.input;

import jp.co.isid.kkh.customer.acom.model.input.HikRegistDAO;
import jp.co.isid.nj.integ.DaoFactory;


/**
 * <P>
 * 発注データ登録DAOのファクトリクラス
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2011/11/14 HLC J.Morobayashi)<BR>
 * </P>
 * @author HLC J.Morobayashi
 */
final class HikRegistDAOFactory extends DaoFactory {

    /**
    * インスタンス化を禁止します。
    */
    private HikRegistDAOFactory() {
    }

    /**
     * 更新DAOインスタンスを生成します。
     * @return 更新・削除DAOインスタンス
     */
    public static HikRegistDAO createHikRegistDAO() {
        return (HikRegistDAO) DaoFactory.createDao(HikRegistDAO.class);
    }
}

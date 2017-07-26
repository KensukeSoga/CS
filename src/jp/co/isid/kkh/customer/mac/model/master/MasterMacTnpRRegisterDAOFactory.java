package jp.co.isid.kkh.customer.mac.model.master;

import jp.co.isid.nj.integ.DaoFactory;


/**
 * <P>
 * マクドナルド店舗マスタ履歴テーブル登録DAOのファクトリクラス
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2013/02/01 JSE H.Okazaki)<BR>
 * </P>
 * @author IP Shimizu
 */
final class MasterMacTnpRRegisterDAOFactory extends DaoFactory {

    /**
    * インスタンス化を禁止します。
    */
    private MasterMacTnpRRegisterDAOFactory() {
    }

    /**
     * DAOインスタンスを生成します。
     * @return DAOインスタンス
     */
    public static MasterMacTnpRRegisterDAO createMasterRegisterDAO() {
        return (MasterMacTnpRRegisterDAO) DaoFactory.createDao(MasterMacTnpRRegisterDAO.class);
    }
}

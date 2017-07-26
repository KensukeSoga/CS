package jp.co.isid.kkh.customer.mac.model.master;

import jp.co.isid.nj.integ.DaoFactory;


/**
 * <P>
 * マスタデータ登録DAOのファクトリクラス
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2011/12/27 IP Shimizu)<BR>
 * </P>
 * @author IP Shimizu
 */
final class MasterMacRegisterDAOFactory extends DaoFactory {

    /**
    * インスタンス化を禁止します。
    */
    private MasterMacRegisterDAOFactory() {
    }

    /**
     * 更新・削除DAOインスタンスを生成します。
     * @return 更新・削除DAOインスタンス
     */
    public static MasterMacRegisterDAO createMasterRegisterDAO() {
        return (MasterMacRegisterDAO) DaoFactory.createDao(MasterMacRegisterDAO.class);
    }
}

package jp.co.isid.kkh.customer.mac.model.report;

import jp.co.isid.nj.integ.DaoFactory;


/**
 * <P>
 * データ更新(購入伝票)DAOのファクトリクラス
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/1/17 IP Shimizu)<BR>
 * </P>
 * @author IP Shimizu
 */
final class UpdateReportMacPurDAOFactory extends DaoFactory {

    /**
    * インスタンス化を禁止します。
    */
    private UpdateReportMacPurDAOFactory() {
    }

    /**
     * 更新・削除DAOインスタンスを生成します。
     * @return 更新・削除DAOインスタンス
     */
    public static UpdateReportMacPurDAO createMasterRegisterDAO() {
        return (UpdateReportMacPurDAO) DaoFactory.createDao(UpdateReportMacPurDAO.class);
    }
}

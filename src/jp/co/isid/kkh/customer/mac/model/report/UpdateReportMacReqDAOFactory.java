package jp.co.isid.kkh.customer.mac.model.report;

import jp.co.isid.nj.integ.DaoFactory;


/**
 * <P>
 * データ更新(請求書)DAOのファクトリクラス
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/1/18)<BR>
 * </P>
 * @author IP Shimizu
 */
final class UpdateReportMacReqDAOFactory extends DaoFactory {

    /**
    * インスタンス化を禁止します。
    */
    private UpdateReportMacReqDAOFactory() {
    }

    /**
     * 更新・削除DAOインスタンスを生成します。
     * @return 更新・削除DAOインスタンス
     */
    public static UpdateReportMacReqDAO createMasterRegisterDAO() {
        return (UpdateReportMacReqDAO) DaoFactory.createDao(UpdateReportMacReqDAO.class);
    }
}

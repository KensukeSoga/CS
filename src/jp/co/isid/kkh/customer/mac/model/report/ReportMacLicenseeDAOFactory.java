package jp.co.isid.kkh.customer.mac.model.report;

import jp.co.isid.nj.integ.DaoFactory;


/**
 * <P>
 * 汎用マスタ検索DAOのファクトリクラス
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2011/1/12 fourm h.izawa)<BR>
 * </P>
 * @author
 */
public class ReportMacLicenseeDAOFactory extends DaoFactory {

    /**
    * インスタンス化を禁止します。
    */
    private ReportMacLicenseeDAOFactory() {
    }

    /**
    * DAOインスタンスを生成します。
    * @return DAOインスタンス
    */
    public static ReportMacLicenseeDAO createReportMacLicenseeDAO() {
        return (ReportMacLicenseeDAO) DaoFactory.createDao(ReportMacLicenseeDAO.class);
    }
}

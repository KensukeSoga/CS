package jp.co.isid.kkh.customer.epson.model.report;

import jp.co.isid.nj.integ.DaoFactory;

/**
 * <P>
 * 請求予定一覧（エプソン)検索DAOのファクトリクラス
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/3/9 IP JK)<BR>
 * </P>
 * @author
 */
public class ReportEpsonSeikyuPlanDAOFactory extends DaoFactory {

    /**
    * インスタンス化を禁止します。
    */
    private ReportEpsonSeikyuPlanDAOFactory() {
    }

    /**
    * DAOインスタンスを生成します。
    * @return DAOインスタンス
    */
    public static ReportEpsonSeikyuPlanDAO createReportEpsonSeikyuPlanDAO() {
        return (ReportEpsonSeikyuPlanDAO) DaoFactory.createDao(ReportEpsonSeikyuPlanDAO.class);
    }
}

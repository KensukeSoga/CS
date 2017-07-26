package jp.co.isid.kkh.customer.toh.model.report;

import jp.co.isid.nj.integ.DaoFactory;


/**
 * <P>
 * 汎用マスタ検索DAOのファクトリクラス
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/02/22 JSE T.Kobayashi)<BR>
 * </P>
 * @author
 */
public class ReportTohTotalDAOFactory extends DaoFactory {

    /**
    * インスタンス化を禁止します。
    */
    private ReportTohTotalDAOFactory() {
    }

    /**
    * DAOインスタンスを生成します。
    * @return DAOインスタンス
    */
    public static ReportTohTotalDAO createReportTohTotalDAO() {
        return (ReportTohTotalDAO) DaoFactory.createDao(ReportTohTotalDAO.class);
    }
}

package jp.co.isid.kkh.customer.ash.model.report;

import jp.co.isid.nj.integ.DaoFactory;


/**
 * <P>
 *媒体別一覧検索DAOのファクトリクラス
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2011/1/23 fourm h.izawa)<BR>
 * </P>
 * @author
 */
public class ReportAshMediaCodeDAOFactory extends DaoFactory {

    /**
    * インスタンス化を禁止します。
    */
    private ReportAshMediaCodeDAOFactory() {
    }

    /**
    * DAOインスタンスを生成します。
    * @return DAOインスタンス
    */
    public static ReportAshMediaCodeDAO createReportAshMediaCodeDAO() {
        return (ReportAshMediaCodeDAO) DaoFactory.createDao(ReportAshMediaCodeDAO.class);
    }
}

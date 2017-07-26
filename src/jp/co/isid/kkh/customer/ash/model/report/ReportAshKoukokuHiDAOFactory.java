package jp.co.isid.kkh.customer.ash.model.report;

import jp.co.isid.nj.integ.DaoFactory;


/**
 * <P>
 *広告費一覧検索DAOのファクトリクラス
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/2/13 fourm h.izawa)<BR>
 * </P>
 * @author
 */
public class ReportAshKoukokuHiDAOFactory extends DaoFactory {

    /**
    * インスタンス化を禁止します。
    */
    private ReportAshKoukokuHiDAOFactory() {
    }

    /**
    * DAOインスタンスを生成します。
    * @return DAOインスタンス
    */
    public static ReportAshKoukokuHiDAO createReportAshKoukokuHiDAO() {
        return (ReportAshKoukokuHiDAO) DaoFactory.createDao(ReportAshKoukokuHiDAO.class);
    }
}

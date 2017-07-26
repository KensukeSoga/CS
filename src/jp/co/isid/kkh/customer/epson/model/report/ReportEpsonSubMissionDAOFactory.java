package jp.co.isid.kkh.customer.epson.model.report;

import jp.co.isid.nj.integ.DaoFactory;

/**
 * <P>
 * 提出帳票（エプソン)検索DAOのファクトリクラス
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/3/5 JSE YS)<BR>
 * </P>
 * @author
 */
public class ReportEpsonSubMissionDAOFactory extends DaoFactory {

    /**
    * インスタンス化を禁止します。
    */
    private ReportEpsonSubMissionDAOFactory() {
    }

    /**
    * DAOインスタンスを生成します。
    * @return DAOインスタンス
    */
    public static ReportEpsonSubMissionDAO createReportEpsonSubMissionDAO() {
        return (ReportEpsonSubMissionDAO) DaoFactory.createDao(ReportEpsonSubMissionDAO.class);
    }
}

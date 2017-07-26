package jp.co.isid.kkh.customer.kmn.model.report;

import jp.co.isid.nj.integ.DaoFactory;

/**
 * <P>
 * 帳票（ユニチャーム_広告費明細表）データ検索DAOのファクトリクラス
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2013/01/30 JSE M.Naito)<BR>
 * </P>
 *
 * @author JSE M.Naito
 */
final class ReportKmnDAOFactory extends DaoFactory {

    /**
     * インスタンス化を禁止します。
     */
    private ReportKmnDAOFactory() {
    }

    /**
     * データ取得DAOインスタンスを生成します。
     *
     * @return DAOインスタンス
     */
    public static ReportKmnDAO createFindReportKmnDAO() {
        return (ReportKmnDAO) DaoFactory.createDao(ReportKmnDAO.class);
    }
}

package jp.co.isid.kkh.customer.kmn.model.report;

import jp.co.isid.nj.integ.DaoFactory;

/**
 * <P>
 * 帳票（公文_請求一覧）データ検索DAOのファクトリクラス
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2013/1/31 JSE A.Naito)<BR>
 * </P>
 *
 * @author JSE A.Naito
 */
final class ReportKmnListDAOFactory extends DaoFactory {

    /**
     * インスタンス化を禁止します。
     */
    private ReportKmnListDAOFactory() {
    }

    /**
     * データ取得DAOインスタンスを生成します。
     *
     * @return DAOインスタンス
     */
    public static ReportKmnListDAO createFindReportKmnListDAO() {
        return (ReportKmnListDAO) DaoFactory.createDao(ReportKmnListDAO.class);
    }
}

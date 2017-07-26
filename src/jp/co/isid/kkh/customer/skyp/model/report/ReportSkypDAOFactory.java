package jp.co.isid.kkh.customer.skyp.model.report;

import jp.co.isid.nj.integ.DaoFactory;

/**
 * <P>
 * 帳票（スカパー_納品／請求書）データ検索DAOのファクトリクラス
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/1/16 JSE Y.Sato)<BR>
 * </P>
 *
 * @author JSE Y.Sato
 */
final class ReportSkypDAOFactory extends DaoFactory {

    /**
     * インスタンス化を禁止します。
     */
    private ReportSkypDAOFactory() {
    }

    /**
     * データ取得DAOインスタンスを生成します。
     *
     * @return DAOインスタンス
     */
    public static ReportSkypDAO createFindReportSkypDAO() {
        return (ReportSkypDAO) DaoFactory.createDao(ReportSkypDAO.class);
    }
}

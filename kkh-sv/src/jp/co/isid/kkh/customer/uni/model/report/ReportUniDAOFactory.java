package jp.co.isid.kkh.customer.uni.model.report;

import jp.co.isid.nj.integ.DaoFactory;

/**
 * <P>
 * 帳票（ユニチャーム_広告費明細表）データ検索DAOのファクトリクラス
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/1/23 JSE Y.Sato)<BR>
 * </P>
 *
 * @author JSE Y.Sato
 */
final class ReportUniDAOFactory extends DaoFactory {

    /**
     * インスタンス化を禁止します。
     */
    private ReportUniDAOFactory() {
    }

    /**
     * データ取得DAOインスタンスを生成します。
     *
     * @return DAOインスタンス
     */
    public static ReportUniDAO createFindReportUniDAO() {
        return (ReportUniDAO) DaoFactory.createDao(ReportUniDAO.class);
    }
}

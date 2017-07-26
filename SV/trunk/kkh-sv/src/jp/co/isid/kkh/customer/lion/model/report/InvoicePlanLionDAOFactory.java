package jp.co.isid.kkh.customer.lion.model.report;

import jp.co.isid.nj.integ.DaoFactory;

/**
 * <P>
 * ライオン制作費請求予定表検索DAOファクトリー
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2014/07/31 HLC S.Fujimoto)<BR>
 * </BR>
 *
 * @author HLC S.Fujimoto
 */
public class InvoicePlanLionDAOFactory extends DaoFactory {

    /**
     * インスタンス化を禁止します。
     */
    private InvoicePlanLionDAOFactory() {
    }

    /**
     * DAOインスタンスを生成します。
     *
     * @return DAOインスタンス
     */
    public static InvoicePlanLionDAO createDAO() {
        return (InvoicePlanLionDAO) DaoFactory.createDao(InvoicePlanLionDAO.class);
    }

}

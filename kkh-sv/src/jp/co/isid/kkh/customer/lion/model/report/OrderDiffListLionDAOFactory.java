package jp.co.isid.kkh.customer.lion.model.report;

import jp.co.isid.nj.integ.DaoFactory;

/**
 * <P>
 * ライオン受注差異一覧検索DAOファクトリー
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2014/11/10 HLC S.Fujimoto)<BR>
 * </BR>
 *
 * @author HLC S.Fujimoto
 */
public class OrderDiffListLionDAOFactory extends DaoFactory {

    /**
     * インスタンス化を禁止します。
     */
    private OrderDiffListLionDAOFactory() {
    }

    /**
     * DAOインスタンスを生成します。
     *
     * @return DAOインスタンス
     */
    public static OrderDiffListLionDAO createDAO() {
        return (OrderDiffListLionDAO) DaoFactory.createDao(OrderDiffListLionDAO.class);
    }

}

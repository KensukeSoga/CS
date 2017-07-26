package jp.co.isid.kkh.customer.lion.model.report;

import jp.co.isid.nj.integ.DaoFactory;

/**
 * <P>
 * ライオン履歴作成DAOファクトリー
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2014/07/31 HLC S.Fujimoto)<BR>
 * </BR>
 *
 * @author HLC S.Fujimoto
 */
public class LionHistoryHeaderDAOFactory extends DaoFactory {

    /**
     * インスタンス化を禁止します。
     */
    private LionHistoryHeaderDAOFactory() {
    }

    /**
     * DAOインスタンスを生成します。
     *
     * @return DAOインスタンス
     */
    public static LionHistoryHeaderDAO createDAO() {
        return (LionHistoryHeaderDAO) DaoFactory.createDao(LionHistoryHeaderDAO.class);
    }

}

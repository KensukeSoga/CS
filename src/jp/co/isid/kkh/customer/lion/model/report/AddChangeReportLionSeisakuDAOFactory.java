package jp.co.isid.kkh.customer.lion.model.report;

import jp.co.isid.nj.integ.DaoFactory;

/**
 * <P>
 * ライオン帳票(制作室リスト)DAOファクトリー
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2014/07/31 HLC S.Fujimoto)<BR>
 * </BR>
 *
 * @author HLC S.Fujimoto
 */
public class AddChangeReportLionSeisakuDAOFactory extends DaoFactory {

    /**
     * インスタンス化を禁止します。
     */
    private AddChangeReportLionSeisakuDAOFactory() {
    }

    /**
     * DAOインスタンスを生成します。
     *
     * @return DAOインスタンス
     */
    public static AddChangeReportLionSeisakuDAO createDAO() {
        return (AddChangeReportLionSeisakuDAO) DaoFactory.createDao(AddChangeReportLionSeisakuDAO.class);
    }

}

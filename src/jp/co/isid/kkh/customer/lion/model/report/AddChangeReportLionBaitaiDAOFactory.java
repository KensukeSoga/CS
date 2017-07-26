package jp.co.isid.kkh.customer.lion.model.report;

import jp.co.isid.nj.integ.DaoFactory;

/**
 * <P>
 * ライオン帳票(追加変更リスト)DAOファクトリー
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2014/07/31 HLC S.Fujimoto)<BR>
 * </BR>
 *
 * @author HLC S.Fujimoto
 */
public class AddChangeReportLionBaitaiDAOFactory extends DaoFactory {

    /**
     * インスタンス化を禁止します。
     */
    private AddChangeReportLionBaitaiDAOFactory() {
    }

    /**
     * DAOインスタンスを生成します。
     *
     * @return DAOインスタンス
     */
    public static AddChangeReportLionBaitaiDAO createDAO() {
        return (AddChangeReportLionBaitaiDAO) DaoFactory.createDao(AddChangeReportLionBaitaiDAO.class);
    }

}

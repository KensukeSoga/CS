package jp.co.isid.kkh.customer.lion.model.report;

import jp.co.isid.nj.integ.DaoFactory;


/**
 * <P>
 *広告費一覧検索DAOのファクトリクラス
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/3/06 fourm h.izawa)<BR>
 * </P>
 * @author
 */
public class NewReportLionDAOFactory extends DaoFactory {

    /**
    * インスタンス化を禁止します。
    */
    private NewReportLionDAOFactory() {
    }

    /**
    * DAOインスタンスを生成します。
    * @return DAOインスタンス
    */
    public static NewReportLionDAO createReportAshKoukokuHiDAO() {
        return (NewReportLionDAO) DaoFactory.createDao(NewReportLionDAO.class);
    }
}

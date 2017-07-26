package jp.co.isid.kkh.customer.epson.model.detail;

import jp.co.isid.nj.integ.DaoFactory;


/**
 * <P>
 * 請求回収データ検索DAOのファクトリクラス
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/04/25 JSE.Yuguchi)<BR>
 * </P>
 * @author
 */
public class SeikyuDataEpsonDAOFactory extends DaoFactory {

    /**
    * インスタンス化を禁止します。
    */
    private SeikyuDataEpsonDAOFactory() {
    }

    /**
    * DAOインスタンスを生成します。
    * @return DAOインスタンス
    */
    public static SeikyuDataEpsonDAO createSeikyuDataDAO() {
        return (SeikyuDataEpsonDAO) DaoFactory.createDao(SeikyuDataEpsonDAO.class);
    }
}

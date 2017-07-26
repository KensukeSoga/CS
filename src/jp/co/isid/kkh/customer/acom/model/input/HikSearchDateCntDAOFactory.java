package jp.co.isid.kkh.customer.acom.model.input;

import jp.co.isid.kkh.customer.acom.model.input.HikSearchDateCntDAO;
import jp.co.isid.nj.integ.DaoFactory;


/**
 * <P>
 * 日付データ件数取得DAOのファクトリクラス
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2011/12/05 HLC J.Morobayashi)<BR>
 * </P>
 * @author HLC J.Morobayashi
 */
final class HikSearchDateCntDAOFactory extends DaoFactory {

    /**
    * インスタンス化を禁止します。
    */
    private HikSearchDateCntDAOFactory() {
    }

    /**
     * 検索DAOインスタンスを生成します。
     * @return DAOインスタンス
     */
    public static HikSearchDateCntDAO createHikSearchDateCntDAO() {
        return (HikSearchDateCntDAO) DaoFactory.createDao(HikSearchDateCntDAO.class);
    }
}

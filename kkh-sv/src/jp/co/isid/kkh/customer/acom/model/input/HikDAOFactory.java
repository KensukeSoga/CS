package jp.co.isid.kkh.customer.acom.model.input;

import jp.co.isid.nj.integ.DaoFactory;


/**
 * <P>
 * 発注データマスタ検索DAOのファクトリクラス
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2011/11/08 HLC J.Morobayashi)<BR>
 * </P>
 * @author HLC J.Morobayashi
 */
public class HikDAOFactory extends DaoFactory {

    /**
    * インスタンス化を禁止します。
    */
    private HikDAOFactory() {
    }

    /**
    * DAOインスタンスを生成します。
    * @return DAOインスタンス
    */
    public static HikDAO createHikDAO() {
        return (HikDAO) DaoFactory.createDao(HikDAO.class);
    }


    /**
     * DAOインスタンスを生成します。
     * @return DAOインスタンス
     */
     public static HikCheckDataDAO createHikCheckDataDAO() {
         return (HikCheckDataDAO) DaoFactory.createDao(HikCheckDataDAO.class);
     }

     /**
      * DAOインスタンスを生成します。
      * @return DAOインスタンス
      */
      public static HikSearchDateCntDAO createHikFindDateDAO() {
          return (HikSearchDateCntDAO) DaoFactory.createDao(HikSearchDateCntDAO.class);
      }
}

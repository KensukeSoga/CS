package jp.co.isid.kkh.model.detail;

import jp.co.isid.nj.integ.DaoFactory;


/**
 * <P>
 * 汎用マスタ検索DAOのファクトリクラス
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2011/11/07 JSE K.Fukuda)<BR>
 * </P>
 * @author
 */
public class JyutyuDataDAOFactory extends DaoFactory {

    /**
    * インスタンス化を禁止します。
    */
    private JyutyuDataDAOFactory() {
    }

    /**
    * DAOインスタンスを生成します。
    * @return DAOインスタンス
    */
    public static JyutyuDataDAO createJyutyuDataDAO() {
        return (JyutyuDataDAO) DaoFactory.createDao(JyutyuDataDAO.class);
    }
}

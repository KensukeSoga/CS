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
public class Thb2KmeiDAOFactory extends DaoFactory {

    /**
    * インスタンス化を禁止します。
    */
    private Thb2KmeiDAOFactory() {
    }

    /**
    * DAOインスタンスを生成します。
    * @return DAOインスタンス
    */
    public static Thb2KmeiDAO createThb2KmeiDAO() {
        return (Thb2KmeiDAO) DaoFactory.createDao(Thb2KmeiDAO.class);
    }

}

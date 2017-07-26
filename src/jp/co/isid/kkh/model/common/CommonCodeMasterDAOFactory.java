package jp.co.isid.kkh.model.common;

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
public class CommonCodeMasterDAOFactory extends DaoFactory {

    /**
    * インスタンス化を禁止します。
    */
    private CommonCodeMasterDAOFactory() {
    }

    /**
    * DAOインスタンスを生成します。
    * @return DAOインスタンス
    */
    public static CommonCodeMasterDAO createMasterDAO() {
        return (CommonCodeMasterDAO) DaoFactory.createDao(CommonCodeMasterDAO.class);
    }
}

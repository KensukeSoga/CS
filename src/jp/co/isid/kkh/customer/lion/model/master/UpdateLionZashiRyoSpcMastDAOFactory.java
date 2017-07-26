package jp.co.isid.kkh.customer.lion.model.master;

import jp.co.isid.nj.integ.DaoFactory;


/**
 * <P>
 * 汎用マスタ登録DAOのファクトリクラス
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/03/05 JSE A.Naito)<BR>
 * </P>
 * @author JSE A.Naito
 */
public class UpdateLionZashiRyoSpcMastDAOFactory extends DaoFactory {

    /**
    * インスタンス化を禁止します。
    */
    private UpdateLionZashiRyoSpcMastDAOFactory() {
    }

    /**
    * DAOインスタンスを生成します。
    * @return DAOインスタンス
    */
    public static UpdateLionZashiRyoSpcMastDAO createUpdateLionZashiRyoSpcMastDAO() {
        return (UpdateLionZashiRyoSpcMastDAO) DaoFactory.createDao(UpdateLionZashiRyoSpcMastDAO.class);
    }
}

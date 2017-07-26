package jp.co.isid.kkh.customer.lion.model.master;

import jp.co.isid.nj.integ.DaoFactory;


/**
 * <P>
 * マスタデータ登録DAOのファクトリクラス
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2011/02/17 HLC K.Honma)<BR>
 * </P>
 * @author HLC K.Honma
 */
final class LionTvMastRegisterDAOFactory extends DaoFactory {

    /**
    * インスタンス化を禁止します。
    */
    private LionTvMastRegisterDAOFactory() {
    }

    /**
     * 更新・削除DAOインスタンスを生成します。
     * @return 更新・削除DAOインスタンス
     */
    public static LionTvMastRegisterDAO createTvMastLionRegisterDAO() {
        return (LionTvMastRegisterDAO) DaoFactory.createDao(LionTvMastRegisterDAO.class);
    }
}

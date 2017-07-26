package jp.co.isid.kkh.customer.lion.model.master;

import jp.co.isid.nj.integ.DaoFactory;


/**
 * <P>
 * マスタデータ登録DAOのファクトリクラス
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/02/17 JSE A.Naito)<BR>
 * </P>
 * @author JSE A.Naito
 */
final class LionRdKMastRegisterDAOFactory extends DaoFactory {

    /**
    * インスタンス化を禁止します。
    */
    private LionRdKMastRegisterDAOFactory() {
    }

    /**
     * 更新・削除DAOインスタンスを生成します。
     * @return 更新・削除DAOインスタンス
     */
    public static LionRdKMastRegisterDAO createRdKMastLionRegisterDAO() {
        return (LionRdKMastRegisterDAO) DaoFactory.createDao(LionRdKMastRegisterDAO.class);
    }
}

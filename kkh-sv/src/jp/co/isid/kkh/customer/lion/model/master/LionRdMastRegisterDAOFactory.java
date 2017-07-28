package jp.co.isid.kkh.customer.lion.model.master;

import jp.co.isid.nj.integ.DaoFactory;


/**
 * <P>
 * ラジオ番組マスタデータ登録DAOのファクトリクラス
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/02/15 JSE A.Naito)<BR>
 * </P>
 * @author JSE A.Naito
 */
final class LionRdMastRegisterDAOFactory extends DaoFactory {

    /**
    * インスタンス化を禁止します。
    */
    private LionRdMastRegisterDAOFactory() {
    }

    /**
     * 更新・削除DAOインスタンスを生成します。
     * @return 更新・削除DAOインスタンス
     */
    public static LionRdMastRegisterDAO createRdMastLionRegisterDAO() {
        return (LionRdMastRegisterDAO) DaoFactory.createDao(LionRdMastRegisterDAO.class);
    }
}

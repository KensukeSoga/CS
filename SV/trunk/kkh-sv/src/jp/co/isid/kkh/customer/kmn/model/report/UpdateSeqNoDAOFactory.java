package jp.co.isid.kkh.customer.kmn.model.report;

import jp.co.isid.nj.integ.DaoFactory;

/**
 * <P>
 * シークエンスNo登録・更新DAOのファクトリクラス
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2013/02/26 JSE M.Naito)<BR>
 * </P>
 *
 * @author JSE M.Naito
 */
final class UpdateSeqNoDAOFactory extends DaoFactory {

    /**
     * インスタンス化を禁止します。
     */
    private UpdateSeqNoDAOFactory() {
    }

    /**
     * データ取得DAOインスタンスを生成します。
     *
     * @return DAOインスタンス
     */
    public static UpdateSeqNoDAO createUpdateSeqNoDAO() {
        return (UpdateSeqNoDAO) DaoFactory.createDao(UpdateSeqNoDAO.class);
    }
}

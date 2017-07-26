package jp.co.isid.kkh.customer.kmn.model.report;

import jp.co.isid.nj.integ.DaoFactory;

/**
 * <P>
 * シークエンスNo最大値取得DAOのファクトリクラス
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2013/02/25 JSE M.Naito)<BR>
 * </P>
 *
 * @author JSE M.Naito
 */
final class MaxSeqNoDAOFactory extends DaoFactory {

    /**
     * インスタンス化を禁止します。
     */
    private MaxSeqNoDAOFactory() {
    }

    /**
     * データ取得DAOインスタンスを生成します。
     *
     * @return DAOインスタンス
     */
    public static MaxSeqNoDAO createMaxSeqNoDAO() {
        return (MaxSeqNoDAO) DaoFactory.createDao(MaxSeqNoDAO.class);
    }
}

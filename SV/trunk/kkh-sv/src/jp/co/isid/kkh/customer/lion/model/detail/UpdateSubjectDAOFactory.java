package jp.co.isid.kkh.customer.lion.model.detail;

import jp.co.isid.nj.integ.DaoFactory;

/**
 * <P>
 * データ登録DAOのファクトリクラス
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/2/9 Fourm A.naito)<BR>
 * </P>
 * @author Fourm A.naito
 */
final class UpdateSubjectDAOFactory extends DaoFactory {

	 /**
	 * インスタンス化を禁止します。
	 */
    private UpdateSubjectDAOFactory() {
    }

    /**
     * 更新DAOインスタンスを生成します。
     * @return 更新・削除DAOインスタンス
     */
    public static UpdateSubjectDAO createUpjissiDAO() {
        return (UpdateSubjectDAO) DaoFactory.createDao(UpdateSubjectDAO.class);
    }
}
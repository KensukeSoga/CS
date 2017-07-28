package jp.co.isid.kkh.customer.skyp.model.detail;

import jp.co.isid.nj.integ.DaoFactory;

/**
 * <P>
 * 並び順情報更新DAOのファクトリクラス
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2011/12/22 JSE Y.Sato)<BR>
 * </P>
 *
 * @author JSE Y.Sato
 */
final class UpdateOrderDAOFactory extends DaoFactory {

	/**
	 * インスタンス化を禁止します。
	 */
	private UpdateOrderDAOFactory() {
	}

	/**
	 * データ取得DAOインスタンスを生成します。
	 *
	 * @return DAOインスタンス
	 */
	public static UpdateOrderDAO createUpdateOrderDAO() {
		return (UpdateOrderDAO) DaoFactory.createDao(UpdateOrderDAO.class);
	}
}

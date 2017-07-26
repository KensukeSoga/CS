package jp.co.isid.kkh.customer.ash.model.detail;

import jp.co.isid.nj.integ.DaoFactory;

/**
 * <P>
 * 更新DAOのファクトリクラス
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/3/29 JSE Y.Sato)<BR>
 * </P>
 *
 * @author JSE Y.Sato
 */
final class UpdateDataAshDAOFactory extends DaoFactory {

	/**
	 * インスタンス化を禁止します。
	 */
	private UpdateDataAshDAOFactory() {
	}

	/**
	 * データ取得DAOインスタンスを生成します。
	 *
	 * @return DAOインスタンス
	 */
	public static UpdateDataAshDAO createUpdateOutFlgDAO() {
		return (UpdateDataAshDAO) DaoFactory.createDao(UpdateDataAshDAO.class);
	}
}

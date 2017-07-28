package jp.co.isid.kkh.customer.skyp.model.detail;

import jp.co.isid.nj.integ.DaoFactory;

/**
 * <P>
 * 並び順情報取得DAOのファクトリクラス
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2011/12/21 JSE Y.Sato)<BR>
 * </P>
 *
 * @author JSE Y.Sato
 */
final class FindOrderByCondDAOFactory extends DaoFactory {

	/**
	 * インスタンス化を禁止します。
	 */
	private FindOrderByCondDAOFactory() {
	}

	/**
	 * データ取得DAOインスタンスを生成します。
	 *
	 * @return DAOインスタンス
	 */
	public static FindOrderByCondDAO createFindOrderByCondDAO() {
		return (FindOrderByCondDAO) DaoFactory.createDao(FindOrderByCondDAO.class);
	}
}

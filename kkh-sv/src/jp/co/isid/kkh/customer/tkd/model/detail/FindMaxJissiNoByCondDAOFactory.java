package jp.co.isid.kkh.customer.tkd.model.detail;

import jp.co.isid.nj.integ.DaoFactory;

/**
 * <P>
 * 実施No最大値取得DAOのファクトリクラス
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2011/12/9 JSE Y.Sato)<BR>
 * </P>
 *
 * @author JSE Y.Sato
 */
final class FindMaxJissiNoByCondDAOFactory extends DaoFactory {

	/**
	 * インスタンス化を禁止します。
	 */
	private FindMaxJissiNoByCondDAOFactory() {
	}

	/**
	 * データ取得DAOインスタンスを生成します。
	 *
	 * @return DAOインスタンス
	 */
	public static FindMaxJissiNoByCondDAO createFindMaxJissiNoByCondDAO() {
		return (FindMaxJissiNoByCondDAO) DaoFactory.createDao(FindMaxJissiNoByCondDAO.class);
	}
}

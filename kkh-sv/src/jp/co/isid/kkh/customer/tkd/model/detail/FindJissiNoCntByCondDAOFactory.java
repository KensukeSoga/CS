package jp.co.isid.kkh.customer.tkd.model.detail;

import jp.co.isid.nj.integ.DaoFactory;

/**
 * <P>
 * 使用済実施Noの件数取得DAOのファクトリクラス
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2011/12/13 JSE Y.Sato)<BR>
 * </P>
 *
 * @author JSE Y.Sato
 */
final class FindJissiNoCntByCondDAOFactory extends DaoFactory {

	/**
	 * インスタンス化を禁止します。
	 */
	private FindJissiNoCntByCondDAOFactory() {
	}

	/**
	 * データ取得DAOインスタンスを生成します。
	 *
	 * @return DAOインスタンス
	 */
	public static FindJissiNoCntByCondDAO createFindJissiNoCntByCondDAO() {
		return (FindJissiNoCntByCondDAO) DaoFactory.createDao(FindJissiNoCntByCondDAO.class);
	}
}

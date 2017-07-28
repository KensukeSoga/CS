package jp.co.isid.kkh.customer.acom.model.claim;

import jp.co.isid.nj.integ.DaoFactory;

/**
 * <P>
 * 送信フラグ情報更新DAOのファクトリクラス
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/2/20 JSE Y.Sato)<BR>
 * </P>
 *
 * @author JSE Y.Sato
 */
final class UpdateOutFlgDAOFactory extends DaoFactory {

	/**
	 * インスタンス化を禁止します。
	 */
	private UpdateOutFlgDAOFactory() {
	}

	/**
	 * データ取得DAOインスタンスを生成します。
	 *
	 * @return DAOインスタンス
	 */
	public static UpdateOutFlgDAO createUpdateOutFlgDAO() {
		return (UpdateOutFlgDAO) DaoFactory.createDao(UpdateOutFlgDAO.class);
	}
}

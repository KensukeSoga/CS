package jp.co.isid.kkh.customer.mac.model.master;

import jp.co.isid.nj.integ.DaoFactory;

/**
 * <P>
 * マクドナルド店舗マスタ履歴テーブルキー項目取得DAOのファクトリクラス
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2013/02/01 JSE H.Okazaki)<BR>
 * </P>
 *
 * @author
 */
final class FindMasterMacTnpRKeyByCondDAOFactory extends DaoFactory {

	/**
	 * インスタンス化を禁止します。
	 */
	private FindMasterMacTnpRKeyByCondDAOFactory() {
	}

	/**
	 * データ取得DAOインスタンスを生成します。
	 *
	 * @return DAOインスタンス
	 */
	public static FindMasterMacTnpRKeyByCondDAO createFindMasterMacTnpRKeyByCondDAO() {
		return (FindMasterMacTnpRKeyByCondDAO) DaoFactory.createDao(FindMasterMacTnpRKeyByCondDAO.class);
	}
}

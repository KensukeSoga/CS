package jp.co.isid.kkh.customer.lion.model.report;

import jp.co.isid.nj.integ.DaoFactory;

/**
 * <P>
 * ライオンFD出力データ取得DAOファクトリー
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/01/23 JSE Hitoshi Sasaki)<BR>
 * </P>
 *
 * @author JSE Hitoshi Sasaki
 */
public class FDLionDAOFactory extends DaoFactory {

	/**
	 * インスタンス化を禁止します。
	 */
	private FDLionDAOFactory() {
	}

	/**
	 * DAOインスタンスを生成します。
	 *
	 * @return DAOインスタンス
	 */
	public static FDLionDAO createDAO() {
		return (FDLionDAO) DaoFactory.createDao(FDLionDAO.class);
	}
}

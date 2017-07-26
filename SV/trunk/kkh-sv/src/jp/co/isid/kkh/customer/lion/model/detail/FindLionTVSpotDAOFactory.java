package jp.co.isid.kkh.customer.lion.model.detail;

import jp.co.isid.kkh.customer.lion.model.detail.FindLionTVSpotDAO;
import jp.co.isid.nj.integ.DaoFactory;

/**
 * <P>
 * ライオンTVSpotデータ取得DAOファクトリー
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/03/05 JSE Hitoshi Sasaki)<BR>
 * </P>
 *
 * @author JSE Hitoshi Sasaki
 */
public class FindLionTVSpotDAOFactory extends DaoFactory {

	/**
	 * インスタンス化を禁止します。
	 */
	private FindLionTVSpotDAOFactory() {
	}

	/**
	 * DAOインスタンスを生成します。
	 *
	 * @return DAOインスタンス
	 */
	public static FindLionTVSpotDAO createDAO() {
		return (FindLionTVSpotDAO) DaoFactory.createDao(FindLionTVSpotDAO.class);
	}
}

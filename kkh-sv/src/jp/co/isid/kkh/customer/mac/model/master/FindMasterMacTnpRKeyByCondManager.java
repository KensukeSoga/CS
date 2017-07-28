package jp.co.isid.kkh.customer.mac.model.master;

import java.util.List;

import jp.co.isid.kkh.model.base.KKHException;

/**
 * <P>
 * マクドナルド店舗マスタ履歴テーブルキー項目取得Manager。
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2013/02/01 JSE H.Okazaki)<BR>
 * </P>
 * @author
 */
public class FindMasterMacTnpRKeyByCondManager {

	/** シングルトンインスタンス */
	private static FindMasterMacTnpRKeyByCondManager _manager = new FindMasterMacTnpRKeyByCondManager();

	/**
	 * シングルトンの為、インスタンス化を禁止します。
	 */
	private FindMasterMacTnpRKeyByCondManager() {
	}

	/**
	 * インスタンスを返します。
	 *
	 * @return インスタンス
	 */
	public static FindMasterMacTnpRKeyByCondManager getInstance() {
		return _manager;
	}

	/**
	 * 使用済実施Noの件数を検索します。
	 *
	 * @return FindJissiNoCntByCondResult 使用済実施Noの件数
	 * @throws KKHException
	 *             処理中にエラーが発生した場合
	 */
	public FindMasterMacTnpRKeyByCondResult findthb17rmtnp(
	        FindMasterMacTnpRByCondCondition cond) throws KKHException {

		// 検索結果
	    FindMasterMacTnpRKeyByCondResult result = new FindMasterMacTnpRKeyByCondResult();

	    FindMasterMacTnpRKeyByCondDAO dao = FindMasterMacTnpRKeyByCondDAOFactory.createFindMasterMacTnpRKeyByCondDAO();

		List<FindMasterMacTnpRKeyByCondVO> list = dao.findthb17rmtnp(cond);

        result.set_thb17RmtnpList(list);

        return result;
	}

}

package jp.co.isid.kkh.customer.mac.model.master;

import java.util.List;

import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.customer.mac.model.master.FindMasterMacTnpRByCondCondition;

/**
 * <P>
 * マクドナルド店舗マスタ履歴テーブル検索Manager。
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2013/02/01 JSE H.Okazaki)<BR>
 * </P>
 * @author
 */
public class FindMasterMacTnpRByCondManager {

    /** シングルトンインスタンス */
    private static FindMasterMacTnpRByCondManager _manager = new FindMasterMacTnpRByCondManager();

    /**
     * シングルトンの為、インスタンス化を禁止します。
     */
    private FindMasterMacTnpRByCondManager() {
    }

    /**
     * インスタンスを返します。
     *
     * @return インスタンス
     */
    public static FindMasterMacTnpRByCondManager getInstance() {
        return _manager;
    }

    /**
     * マクドナルド店舗マスタ履歴テーブル検索
     *
     * @return FindMasterMacTnpRByCondResult 検索結果
     * @throws KKHException 処理中にエラーが発生した場合
     */
    public FindMasterMacTnpRByCondResult findthb17rmtnp(
            FindMasterMacTnpRByCondCondition cond) throws KKHException {

        // 検索結果
        FindMasterMacTnpRByCondResult result = new FindMasterMacTnpRByCondResult();

        FindMasterMacTnpRByCondDAO dao = FindMasterMacTnpRByCondDAOFactory.createFindMasterMacTnpRByCondDAO();

        List<FindMasterMacTnpRByCondVO> list = dao.findthb17rmtnp(cond);
        result.set_thb17RmtnpList(list);

        return result;
    }

}

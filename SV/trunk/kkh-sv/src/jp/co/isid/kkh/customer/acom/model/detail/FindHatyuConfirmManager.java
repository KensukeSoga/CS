package jp.co.isid.kkh.customer.acom.model.detail;

import java.util.List;

import jp.co.isid.kkh.model.base.KKHException;

public class FindHatyuConfirmManager {

    /** シングルトンインスタンス */
    private static FindHatyuConfirmManager _manager = new FindHatyuConfirmManager();

    /**
     * シングルトンの為、インスタンス化を禁止します。
     */
    private FindHatyuConfirmManager() {
    }

    /**
     * インスタンスを返します。
     *
     * @return インスタンス
     */
    public static FindHatyuConfirmManager getInstance() {
        return _manager;
    }

    /**
     *THB5HIKの検索
     * @param vo
     * @throws KKHException
     */
    public FindHatyuConfirmResult findThb2Kmeidata(FindHatyuNumByCondVO vo) throws KKHException{

        FindHatyuConfirmResult result = new FindHatyuConfirmResult();

        FindHatyuConfirmDAO thb5HikDAO = FindHatyuConfirmDAOFactory.createfinetgr84hikDAO();
        List<HikVO> thb5HikList =  thb5HikDAO.findThb5HikByCondCmn(vo);

        result.set_thb5HikList(thb5HikList);

        return result;
    }

}

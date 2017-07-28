package jp.co.isid.kkh.customer.acom.model.detail;

import java.util.List;

import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.customer.acom.model.detail.FindHatyuNumByCondDAO;

public class FindHatyuNumBycondManager {

    /** シングルトンインスタンス */
    private static FindHatyuNumBycondManager _manager = new FindHatyuNumBycondManager();

    /**
     * シングルトンの為、インスタンス化を禁止します。
     */
    private FindHatyuNumBycondManager() {
    }

    /**
     * インスタンスを返します。
     *
     * @return インスタンス
     */
    public static FindHatyuNumBycondManager getInstance() {
        return _manager;
    }

    /**
     *THB5HIKの検索
     * @param vo
     * @throws KKHException
     */
    public FindHatyuNumBycondResult findThb2Kmeidata(FindHatyuNumByCondVO vo) throws KKHException{

        FindHatyuNumBycondResult result = new FindHatyuNumBycondResult();

        FindHatyuNumByCondDAO thb5HikDAO = FindTHatyuNumBycondDAOFactory.createfinetgr84hikDAO();
//    	Thb5HikVO thb5HikCond = new Thb5HikVO();
////    	thb5HikCond.setRg84EgCd(vo.get_egCd());
//    	thb5HikCond.set_tksKgyCd(vo.get_tksKgyCd());
//    	thb5HikCond.set_tksBmnSeqNo(vo.get_tksBmnSeqNo());
//    	thb5HikCond.set_tksTntSeqNo(vo.get_tksTntSeqNo());
//    	thb5HikCond.set_irban(vo.get_Irban());
//    	// TODO THB5HIKテーブルに同項目なし
////    	thb5HikCond.setRg84Irrowban(vo.get_Irrowban());

        List<HikVO> thb5HikList =  thb5HikDAO.findThb5HikByCondCmn(vo);

        result.set_thb5HikList(thb5HikList);

        return result;
    }

}

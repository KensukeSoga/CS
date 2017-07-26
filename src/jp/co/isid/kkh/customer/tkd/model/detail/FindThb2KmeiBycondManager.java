package jp.co.isid.kkh.customer.tkd.model.detail;

import java.util.List;

import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.model.detail.Thb2KmeiVO;
import jp.co.isid.kkh.customer.tkd.model.detail.FindThb2KmeiBycondDAO;

public class FindThb2KmeiBycondManager {

    /** シングルトンインスタンス */
    private static FindThb2KmeiBycondManager _manager = new FindThb2KmeiBycondManager();

    /**
     * シングルトンの為、インスタンス化を禁止します。
     */
    private FindThb2KmeiBycondManager() {
    }

    /**
     * インスタンスを返します。
     *
     * @return インスタンス
     */
    public static FindThb2KmeiBycondManager getInstance() {
        return _manager;
    }

    /**
     *THB2KMEIの検索
     * @param vo
     * @throws KKHException
     */
    public FindThb2KmeiBycondResult findThb2Kmeidata(FindThb2KmeiBycondVO vo) throws KKHException{

        FindThb2KmeiBycondResult result = new FindThb2KmeiBycondResult();

        FindThb2KmeiBycondDAO thb2KmeiDAO = FindThb2KmeiBycondDAOFactory.createFindThb2KmeiBycondDAO();
        Thb2KmeiVO thb2KmeiCond = new Thb2KmeiVO();
        thb2KmeiCond.setHb2EgCd(vo.get_egCd());
        thb2KmeiCond.setHb2TksKgyCd(vo.get_tksKgyCd());
        thb2KmeiCond.setHb2TksBmnSeqNo(vo.get_tksBmnSeqNo());
        thb2KmeiCond.setHb2TksTntSeqNo(vo.get_tksTntSeqNo());
        thb2KmeiCond.setHb2Yymm(vo.get_YYMM());

        List<Thb2KmeiVO> thb2KmeiList =  thb2KmeiDAO.findThb2KmeiByCondCmn(thb2KmeiCond);
        result.set_thb2KmeiList(thb2KmeiList);

        return result;
    }

    /**
     *THB2KMEIの検索
     * @param vo
     * @throws KKHException
     */
    public FindThb2KmeiBycondResult findThb2KmeidataCreative(FindThb2KmeiBycondVO vo) throws KKHException{

        FindThb2KmeiBycondResult result = new FindThb2KmeiBycondResult();

        FindThb2KmeiBycondDAO thb2KmeiDAO = FindThb2KmeiBycondDAOFactory.createFindThb2KmeiBycondDAO();
        Thb2KmeiVO thb2KmeiCond = new Thb2KmeiVO();
        thb2KmeiCond.setHb2EgCd(vo.get_egCd());
        thb2KmeiCond.setHb2TksKgyCd(vo.get_tksKgyCd());
        thb2KmeiCond.setHb2TksBmnSeqNo(vo.get_tksBmnSeqNo());
        thb2KmeiCond.setHb2TksTntSeqNo(vo.get_tksTntSeqNo());
        thb2KmeiCond.setHb2Yymm(vo.get_YYMM());

        List<Thb2KmeiVO> thb2KmeiList =  thb2KmeiDAO.findThb2KmeiByCondCmnCreative(thb2KmeiCond);
        result.set_thb2KmeiList(thb2KmeiList);

        return result;
    }
}

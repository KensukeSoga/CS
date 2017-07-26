package jp.co.isid.kkh.customer.acom.model.detail;

import java.util.List;

import jp.co.isid.kkh.model.base.KKHException;

public class FindThb5HikBycondManager {

    /** シングルトンインスタンス */
    private static FindThb5HikBycondManager _manager = new FindThb5HikBycondManager();

    /**
     * シングルトンの為、インスタンス化を禁止します。
     */
    private FindThb5HikBycondManager() {
    }

    /**
     * インスタンスを返します。
     *
     * @return インスタンス
     */
    public static FindThb5HikBycondManager getInstance() {
        return _manager;
    }

    /**
     *THB2KMEIの検索
     * @param vo
     * @throws KKHException
     */
    public FindThb5HikResult findthb5Hikdata(Thb5HikVO vo) throws KKHException{

        FindThb5HikResult result = new FindThb5HikResult();

        Thb5HikDAO Thb5HikDAO = Thb5HikDAOFactory.createThb5HikDAO();
        HikVO HikVO = new HikVO();
        HikVO.setTksKgyCd(vo.get_tksKgyCd());
        HikVO.setTksBmnSeqNo(vo.get_tksBmnSeqNo());
        HikVO.setTksTntSeqNo(vo.get_tksTntSeqNo());
        HikVO.setIrban(vo.get_irban());

        List<HikVO> thb5HikList = Thb5HikDAO.findThb5HikByCondCmn(HikVO);

       // List<Thb2KmeiVO> thb2KmeiList =  thb2KmeiDAO.findThb2KmeiByCondCmn(thb2KmeiCond);

        result.set_thb5HikList(thb5HikList);

        return result;
    }

}

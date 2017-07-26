package jp.co.isid.kkh.customer.acom.model.detail;

import java.util.List;

import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.model.detail.Thb2KmeiVO;


/**
 * <P>
 * 広告費明細入力Manager。
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2011/12/08 JSE K.Fukuda)<BR>
 * </P>
 * @author
 */
public class FindMeisaiDataManager {

    /** シングルトンインスタンス */
    private static FindMeisaiDataManager _manager = new FindMeisaiDataManager();

    /**
     * シングルトンの為、インスタンス化を禁止します。
     */
    private FindMeisaiDataManager() {
    }

    /**
     * インスタンスを返します。
     *
     * @return インスタンス
     */
    public static FindMeisaiDataManager getInstance() {
        return _manager;
    }

    //**********************************************************************************************************************************************************************************
    //明細検索
    /**
     * 広告費明細データを検索します。
     *
     * @return DetailDataResult 汎用マスタ検索データ
     * @throws KKHException 処理中にエラーが発生した場合
     */
    public FindMeisaiDataResult findMeisaiDataByCond(FindMeisaiDataCondition cond) throws KKHException {

    	//検索結果
    	FindMeisaiDataResult result = new FindMeisaiDataResult();

    	//******************************************************
    	//広告費明細データを取得
    	//******************************************************
    	FindMeisaiiBycondDAO thb2KmeiDAO = FindMeisaiiBycondDAOFactory.createMeisaiDAO();
    	Thb2KmeiVO thb2KmeiCond = new Thb2KmeiVO();
    	thb2KmeiCond.setHb2EgCd(cond.getEgCd());
    	thb2KmeiCond.setHb2TksKgyCd(cond.getTksKgyCd());
    	thb2KmeiCond.setHb2TksBmnSeqNo(cond.getTksBmnSeqNo());
    	thb2KmeiCond.setHb2TksTntSeqNo(cond.getTksTntSeqNo());
    	thb2KmeiCond.setHb2Yymm(cond.getYm());
    	thb2KmeiCond.setHb2JyutNo(cond.getJyutNo());
    	thb2KmeiCond.setHb2JyMeiNo(cond.getJyMeiNo());
    	thb2KmeiCond.setHb2UrMeiNo(cond.getUrMeiNo());

        List<Thb2KmeiVO> thb2KmeiList = thb2KmeiDAO.findThb2KmeiByCondCmn(thb2KmeiCond);
        result.setThb2KmeiList(thb2KmeiList);

        return result;
    }

}

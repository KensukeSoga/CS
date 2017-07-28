package jp.co.isid.kkh.customer.epson.model.detail;

import java.util.List;

import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.customer.epson.model.detail.SeikyuDataEpsonResult;
import jp.co.isid.kkh.customer.epson.model.detail.Thb14skdownVO;
import jp.co.isid.kkh.customer.epson.model.detail.SeikyuDataEpsonDAO;
import jp.co.isid.kkh.customer.epson.model.detail.SeikyuDataEpsonDAOFactory;
import jp.co.isid.kkh.customer.epson.model.detail.SeikyuDataCondition;


/**
 * <P>
 * 請求回収データ入出力Manager。
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/04/25 JSE.Yuguchi)<BR>
 * </P>
 * @author
 */
public class SeikyuDataEpsonManager {

    /** シングルトンインスタンス */
    private static SeikyuDataEpsonManager _manager = new SeikyuDataEpsonManager();

    /**
     * シングルトンの為、インスタンス化を禁止します。
     */
    private SeikyuDataEpsonManager() {
    }

    /**
     * インスタンスを返します。
     *
     * @return インスタンス
     */
    public static SeikyuDataEpsonManager getInstance() {
        return _manager;
    }



    //**********************************************************************************************************************************************************************************
    //請求回収データ検索
    /**
     * 請求回収データを検索します。
     *
     * @return SeikyuDataEpsonResult 請求回収ダウンロード検索データ
     * @throws KKHException 処理中にエラーが発生した場合
     */
    public SeikyuDataEpsonResult findSeikyuDataEpsonByCond(SeikyuDataCondition cond) throws KKHException {


    	SeikyuDataEpsonDAO dao = SeikyuDataEpsonDAOFactory.createSeikyuDataDAO();
    	//検索結果
    	SeikyuDataEpsonResult result = new SeikyuDataEpsonResult();


        List<Thb14skdownVO> SeikyuDataList = dao.findSeikyuDataByCondition(cond);

        result.setSeikyuData(SeikyuDataList);

        return result;
    }

}

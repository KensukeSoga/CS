package jp.co.isid.kkh.customer.lion.model.detail;

import java.util.List;

import jp.co.isid.kkh.customer.lion.model.detail.FindLionCardNoItrDAO;
import jp.co.isid.kkh.customer.lion.model.detail.FindLionCardNoItrDAOFactory;
import jp.co.isid.kkh.customer.lion.model.detail.FindLionCardNoItrResult;
import jp.co.isid.kkh.customer.lion.model.detail.FindLionCardNoItrVO;
import jp.co.isid.kkh.model.base.KKHException;

/**
 * <P>
 * 汎用マスタ検索Manager。
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/02/21 JSE A.Naito)<BR>
 * </P>
 * @author JSE A.Naito
 */
public class FindLionCardNoItrManager {

    /** シングルトンインスタンス */
    private static FindLionCardNoItrManager _manager = new FindLionCardNoItrManager();

    /**
     * シングルトンの為、インスタンス化を禁止します。
     */
    private FindLionCardNoItrManager() {
    }

    /**
     * インスタンスを返します。
     *
     * @return インスタンス
     */
    public static FindLionCardNoItrManager getInstance() {
        return _manager;
    }

    /**
    * カードNO一覧データを検索します。
    *
    * @return FindLionCardNoItrResult 汎用マスタ検索データ
    * @throws KKHException 処理中にエラーが発生した場合
    */
   public FindLionCardNoItrResult findLionCardNoItrByCondition(FindLionCardNoItrCondition cond) throws KKHException {
   	//検索結果
	   FindLionCardNoItrResult result = new FindLionCardNoItrResult();

   	//******************************************************
   	//カードNO一覧データを取得
   	//******************************************************
	   FindLionCardNoItrDAO findLionCardNoItrDAO = FindLionCardNoItrDAOFactory.createFindLionCardNoItrDAO();

   	List<FindLionCardNoItrVO> list = findLionCardNoItrDAO.findLionCardNoItrByCondition(cond);
   	result.setFindLionCardNoItr(list);

       return result;

   }


}

package jp.co.isid.kkh.customer.lion.model.detail;

import java.util.List;

import jp.co.isid.kkh.model.base.KKHException;

/**
 * <P>
 * 汎用マスタ検索Manager。
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/02/27 JSE A.Naito)<BR>
 * </P>
 * @author JSE A.Naito
 */
public class FindLionCodeItrManager {

    /** シングルトンインスタンス */
    private static FindLionCodeItrManager _manager = new FindLionCodeItrManager();

    /**
     * シングルトンの為、インスタンス化を禁止します。
     */
    private FindLionCodeItrManager() {
    }

    /**
     * インスタンスを返します。
     *
     * @return インスタンス
     */
    public static FindLionCodeItrManager getInstance() {
        return _manager;
    }

    /**
    * コード一覧データを検索します。
    *
    * @return FindLionCardNoItrResult 汎用マスタ検索データ
    * @throws KKHException 処理中にエラーが発生した場合
    */
   public FindLionCodeItrResult findLionCodeItrByCondition(FindLionCodeItrCondition cond) throws KKHException {
   	//検索結果
	   FindLionCodeItrResult result = new FindLionCodeItrResult();

   	//******************************************************
   	//コード一覧データを取得
   	//******************************************************
	   FindLionCodeItrDAO findLionCodeItrDAO = FindLionCodeItrDAOFactory.createFindLionCodeItrDAO();

   	List<FindLionCodeItrVO> list = findLionCodeItrDAO.findLionCodeItrByCondition(cond);
   	result.setFindLionCodeItr(list);

       return result;

   }


}

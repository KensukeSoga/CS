package jp.co.isid.kkh.customer.lion.model.detail;

import java.util.List;
import jp.co.isid.kkh.model.base.KKHException;

/**
 * <P>
 * 汎用マスタ検索Manager。
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2011/11/07 JSE K.Fukuda)<BR>
 * </P>
 * @author
 */
public class FindLionDetailManager {

    /** シングルトンインスタンス */
    private static FindLionDetailManager _manager = new FindLionDetailManager();

    /**
     * シングルトンの為、インスタンス化を禁止します。
     */
    private FindLionDetailManager() {
    }

    /**
     * インスタンスを返します。
     *
     * @return インスタンス
     */
    public static FindLionDetailManager getInstance() {
        return _manager;
    }


    /**
    * 詳細データ（マスタ付）を検索します。
    *
    * @return ReportMacResult 詳細データ（マスタ付）検索データ
    * @throws KKHException 処理中にエラーが発生した場合
    */
   public FindLionDetailResult findLionDetailByCondition(FindLionDetailCondition cond) throws KKHException {
       //検索結果
    FindLionDetailResult result = new FindLionDetailResult();

       //******************************************************
       //TV番組データを取得
       //******************************************************
    FindLionDetailDAO findDetailDAO = FindLionDetailDAOFactory.createFindLionDetailDAO();

       List<FindLionDetailVO> list = findDetailDAO.findLionDetailByCondition(cond);
       result.setFindLionDetail(list);

       return result;

   }

   /**
    * 詳細データの存在有無（カードNO)を検索します。
    *
    * @return ReportMacResult 詳細データ（マスタ付）検索データ
    * @throws KKHException 処理中にエラーが発生した場合
    */
   public FindLionCardNoGetResult findLionCardNoGetByCondition(FindLionCardNoGetCondition cond) throws KKHException {
       //検索結果
    FindLionCardNoGetResult result = new FindLionCardNoGetResult();

       //******************************************************
       //TV番組データを取得
       //******************************************************
    FindLionCardNoGetDAO findCardNoGetDAO = FindLionCardNoGetDAOFactory.createFindLionCardNoGetDAO();

       List<FindLionCardNoGetVO> list = findCardNoGetDAO.findLionCardNoGetByCondition(cond);
       result.setFindLionCardNoGet(list);

       return result;

   }


}

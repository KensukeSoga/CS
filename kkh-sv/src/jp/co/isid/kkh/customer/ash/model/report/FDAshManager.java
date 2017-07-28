package jp.co.isid.kkh.customer.ash.model.report;

import java.util.List;
import jp.co.isid.kkh.model.base.KKHException;

/**
 * <P>
 * 請求データ（Ash）検索Manager。
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * </P>
 * @author
 */
public class FDAshManager {

    /** シングルトンインスタンス */
    private static FDAshManager _manager = new FDAshManager();

    /**
     * シングルトンの為、インスタンス化を禁止します。
     */
    private FDAshManager() {
    }

    /**
     * インスタンスを返します。
     *
     * @return インスタンス
     */
    public static FDAshManager getInstance() {
        return _manager;
    }

    /**
     * 請求データ一覧を検索します。
     * @return FDAshResult 請求データ一覧検索データ
     * @throws KKHException 処理中にエラーが発生した場合
     */
    public FDAshResult findByCondition(ReportAshMediaCondition cond) throws KKHException {
        //検索結果
        FDAshResult result = new FDAshResult();

        //******************************************************
        //媒体種別データを取得
        //******************************************************
        FDAshDAO FDAshDAO = FDAshDAOFactory.createFDAshDAO();
        List<FDAshVO> list = FDAshDAO.findFDAshByCondition(cond);
        result.setFDAsh(list);

        return result;
    }

}

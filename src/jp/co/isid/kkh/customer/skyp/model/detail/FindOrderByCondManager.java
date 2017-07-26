package jp.co.isid.kkh.customer.skyp.model.detail;

import java.util.List;

import jp.co.isid.kkh.model.base.KKHException;

public class FindOrderByCondManager {

    /** シングルトンインスタンス */
    private static FindOrderByCondManager _manager = new FindOrderByCondManager();

    /**
     * シングルトンの為、インスタンス化を禁止します。
     */
    private FindOrderByCondManager() {
    }

    /**
     * インスタンスを返します。
     *
     * @return インスタンス
     */
    public static FindOrderByCondManager getInstance() {
        return _manager;
    }

    /**
     * 並び順情報を検索します。
     *
     * @return FindOrderByCondResult 並び順情報
     * @throws KKHException
     *             処理中にエラーが発生した場合
     */
    public FindOrderByCondResult findOrderByCondition(FindOrderCondition cond)
            throws KKHException {

        // パラメータの必須チェック
        if (cond.getEsqId() == null || cond.getEsqId().equals("")) {
            throw new KKHException("パラメータ指定エラー", "BD-E0001");
        }
        if (cond.getEgCd() == null || cond.getEgCd().equals("")) {
            throw new KKHException("パラメータ指定エラー", "BD-E0001");
        }
        if (cond.getTksKgyCd() == null || cond.getTksKgyCd().equals("")) {
            throw new KKHException("パラメータ指定エラー", "BD-E0001");
        }
        if (cond.getTksBmnSeqNo() == null || cond.getTksBmnSeqNo().equals("")) {
            throw new KKHException("パラメータ指定エラー", "BD-E0001");
        }
        if (cond.getTksTntSeqNo() == null || cond.getTksTntSeqNo().equals("")) {
            throw new KKHException("パラメータ指定エラー", "BD-E0001");
        }
        if (cond.getYm() == null || cond.getYm().equals("")) {
            throw new KKHException("パラメータ指定エラー", "BD-E0001");
        }

        // 検索結果
        FindOrderByCondResult result = new FindOrderByCondResult();

        // 検索条件
        FindOrderCondition lCond = new FindOrderCondition();

        // ******************************************************
        // 並び順情報を取得
        // ******************************************************
        FindOrderByCondDAO dao = FindOrderByCondDAOFactory.createFindOrderByCondDAO();
        lCond = cond;
        List<FindOrderCondVO> list = dao.findOrderByCondition(lCond);
        result.setOrderList(list);

        return result;
    }

}

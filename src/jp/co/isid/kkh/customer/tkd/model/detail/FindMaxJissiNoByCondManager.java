package jp.co.isid.kkh.customer.tkd.model.detail;

import java.util.List;

import jp.co.isid.kkh.model.base.KKHException;

public class FindMaxJissiNoByCondManager {

    /** シングルトンインスタンス */
    private static FindMaxJissiNoByCondManager _manager = new FindMaxJissiNoByCondManager();

    /**
     * シングルトンの為、インスタンス化を禁止します。
     */
    private FindMaxJissiNoByCondManager() {
    }

    /**
     * インスタンスを返します。
     *
     * @return インスタンス
     */
    public static FindMaxJissiNoByCondManager getInstance() {
        return _manager;
    }

    /**
     * (データ)を検索します。
     *
     * @return FindByCondResult マスタ検索データ
     * @throws KKHException
     *             処理中にエラーが発生した場合
     */
    public FindMaxJissiNoByCondResult findMaxjissiNoByCondition(FindMaxJissiNoCondition cond)
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
        FindMaxJissiNoByCondResult result = new FindMaxJissiNoByCondResult();

        // 検索条件
        FindMaxJissiNoCondition lCond = new FindMaxJissiNoCondition();

        // ******************************************************
        // 実施Noの最大値を取得
        // ******************************************************
        FindMaxJissiNoByCondDAO dao = FindMaxJissiNoByCondDAOFactory.createFindMaxJissiNoByCondDAO();

        // ******************************************************
        // マスタ種類設定を取得
        // ******************************************************
        lCond = cond;
        List<FindMaxJissiNoCondVO> list = dao.findMaxjissiNoByCondition(lCond);
        FindMaxJissiNoCondVO vo = list.get(0);

        result.setJissiNo(vo.getKngk1());

        return result;
    }

}

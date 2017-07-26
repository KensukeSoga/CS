package jp.co.isid.kkh.customer.kmn.model.report;

import java.util.List;
import jp.co.isid.kkh.model.base.KKHException;

/**
 *
 * <P>
 * シークエンスNo最大値取得Manager。
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2013/02/25 JSE A.Naito)<BR>
 * </P>
 *
 * @author JSE A.Naito
 */
public class MaxSeqNoManager {

    /** シングルトンインスタンス */
    private static MaxSeqNoManager _manager = new MaxSeqNoManager();

    /**
     * シングルトンの為、インスタンス化を禁止します。
     */
    private MaxSeqNoManager() {
    }

    /**
     * インスタンスを返します。
     *
     * @return インスタンス
     */
    public static MaxSeqNoManager getInstance() {
        return _manager;
    }

    /**
     * シークエンスNo最大値を取得します。
     *
     * @return MaxSeqNoResult 汎用マスタ検索データ
     * @throws KKHException 処理中にエラーが発生した場合
     */
    public MaxSeqNoResult findByCondition(MaxSeqNoCondition cond) throws KKHException {

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
        if (cond.getYyMm() == null || cond.getYyMm().equals("")) {
            throw new KKHException("パラメータ指定エラー", "BD-E0001");
        }
        //検索結果
        MaxSeqNoResult result = new MaxSeqNoResult();

        //******************************************************
        //広告費明細データを取得
        //******************************************************
        MaxSeqNoDAO maxSeqNoDAO = MaxSeqNoDAOFactory.createMaxSeqNoDAO();

        List<MaxSeqNoVO> list = maxSeqNoDAO.findMaxSeqNoByCondition(cond);
        result.setMaxSeqNo(list);

        return result;

    }
}
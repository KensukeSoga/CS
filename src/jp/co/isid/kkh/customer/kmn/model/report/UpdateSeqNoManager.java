package jp.co.isid.kkh.customer.kmn.model.report;

import jp.co.isid.kkh.model.base.KKHException;

/**
 *
 * <P>
 * シークエンスNo登録Manager。
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2013/02/25 JSE A.Naito)<BR>
 * </P>
 *
 * @author JSE A.Naito
 */
public class UpdateSeqNoManager {

    /** シングルトンインスタンス */
    private static UpdateSeqNoManager _manager = new UpdateSeqNoManager();

    /**
     * シングルトンの為、インスタンス化を禁止します。
     */
    private UpdateSeqNoManager() {
    }

    /**
     * インスタンスを返します。
     *
     * @return インスタンス
     */
    public static UpdateSeqNoManager getInstance() {
        return _manager;
    }

    /**
     * シークエンスNo最大値を取得します。
     *
     * @return MaxSeqNoResult 汎用マスタ検索データ
     * @throws KKHException 処理中にエラーが発生した場合
     */
    public void updateDisplayData(UpdateSeqNoCondition cond) throws KKHException {

        // パラメータの必須チェック
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

        //******************************************************
        //広告費明細データを取得
        //******************************************************
        UpdateSeqNoDAO updateSeqNoDAO = UpdateSeqNoDAOFactory.createUpdateSeqNoDAO();

        updateSeqNoDAO.setConditionByCondition(cond);

        for (ReportKmnListVO reportKmnListVO : cond.getRepKmnList()) {
            updateSeqNoDAO.updateSeqNoByCondition(reportKmnListVO);
        }
    }

}

package jp.co.isid.kkh.customer.skyp.model.report;

import java.util.List;

import jp.co.isid.kkh.model.base.KKHException;

public class ReportSkypManager {

    /** シングルトンインスタンス */
    private static ReportSkypManager _manager = new ReportSkypManager();

    /**
     * シングルトンの為、インスタンス化を禁止します。
     */
    private ReportSkypManager() {
    }

    /**
     * インスタンスを返します。
     *
     * @return インスタンス
     */
    public static ReportSkypManager getInstance() {
        return _manager;
    }

    /**
     * 帳票（スカパー_納品／請求書）データを検索します。
     *
     * @return ReportSkypResult 並び順情報
     * @throws KKHException
     *             処理中にエラーが発生した場合
     */
    public ReportSkypResult findReportSkypByCondition(ReportSkypCondition cond)
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
        ReportSkypResult result = new ReportSkypResult();

        // 検索条件
        ReportSkypCondition lCond = new ReportSkypCondition();

        // ******************************************************
        // 帳票（スカパー_納品／請求書）データを取得
        // ******************************************************
        ReportSkypDAO dao = ReportSkypDAOFactory.createFindReportSkypDAO();
        lCond = cond;
        List<ReportSkypVO> list = dao.findReportSkypByCondition(lCond);
        result.setReportSkyp(list);

        return result;
    }

}

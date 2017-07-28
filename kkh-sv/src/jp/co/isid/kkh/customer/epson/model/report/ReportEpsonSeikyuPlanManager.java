package jp.co.isid.kkh.customer.epson.model.report;

import java.util.List;
import jp.co.isid.kkh.model.base.KKHException;

/**
 * <P>
 * 請求予定一覧（エプソン)マスタ検索Manager。
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/3/9 IP JK)<BR>
 * </P>
 * @author
 */
public class ReportEpsonSeikyuPlanManager {

    /** シングルトンインスタンス */
    private static ReportEpsonSeikyuPlanManager _manager = new ReportEpsonSeikyuPlanManager();

    /**
     * シングルトンの為、インスタンス化を禁止します。
     */
    private ReportEpsonSeikyuPlanManager() {
    }

    /**
     * インスタンスを返します。
     *
     * @return インスタンス
     */
    public static ReportEpsonSeikyuPlanManager getInstance() {
        return _manager;
    }

    /**
     * 請求予定一覧データ(エプソン)を検索します。
     *
     * @return ReportEpsonSeikyuPlanResult 汎用マスタ検索データ
     * @throws KKHException 処理中にエラーが発生した場合
     */
    public ReportEpsonSeikyuPlanResult findByCondition(ReportEpsonSeikyuPlanCondition cond) throws KKHException {

        // 検索結果
        ReportEpsonSeikyuPlanResult result = new ReportEpsonSeikyuPlanResult();

        //******************************************************
        // 提出帳票データを取得
        //******************************************************
        ReportEpsonSeikyuPlanDAO reportDAO = ReportEpsonSeikyuPlanDAOFactory.createReportEpsonSeikyuPlanDAO();
        List<ReportEpsonSeikyuPlanVO> list = reportDAO.findReportEpsonSeikyuPlanByCondition(cond);
        result.setReportEpsonSeikyuPlan(list);

        return result;
    }
}

package jp.co.isid.kkh.customer.epson.model.report;

import java.util.List;
import jp.co.isid.kkh.model.base.KKHException;

/**
 * <P>
 * 提出帳票（エプソン)マスタ検索Manager。
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/3/5 JSE YS)<BR>
 * </P>
 * @author
 */
public class ReportEpsonSubMissionManager {

    /** シングルトンインスタンス */
    private static ReportEpsonSubMissionManager _manager = new ReportEpsonSubMissionManager();

    /**
     * シングルトンの為、インスタンス化を禁止します。
     */
    private ReportEpsonSubMissionManager() {
    }

    /**
     * インスタンスを返します。
     *
     * @return インスタンス
     */
    public static ReportEpsonSubMissionManager getInstance() {
        return _manager;
    }

    /**
     * 提出帳票データ(エプソン)を検索します。
     *
     * @return ReportEpsonSubMissionResult 汎用マスタ検索データ
     * @throws KKHException 処理中にエラーが発生した場合
     */
    public ReportEpsonSubMissionResult findByCondition(ReportEpsonSubMissionCondition cond) throws KKHException {

        // 検索結果
        ReportEpsonSubMissionResult result = new ReportEpsonSubMissionResult();

        //******************************************************
        // 提出帳票データを取得
        //******************************************************
        ReportEpsonSubMissionDAO reportDAO = ReportEpsonSubMissionDAOFactory.createReportEpsonSubMissionDAO();
        List<ReportEpsonSubMissionVO> list = reportDAO.findReportEpsonSubMissionByCondition(cond);
        result.setReportEpsonSubMission(list);

        return result;
    }
}

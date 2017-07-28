package jp.co.isid.kkh.customer.mac.model.report;

import java.util.List;

import jp.co.isid.kkh.model.base.KKHException;

/**
 * <P>
 * 帳票（MAC)マスタ検索Manager。
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2011/11/07 JSE KT)<BR>
 * </P>
 * @author
 */
public class ReportMacRequestManager {

    /** シングルトンインスタンス */
    private static ReportMacRequestManager _manager = new ReportMacRequestManager();

    /**
     * シングルトンの為、インスタンス化を禁止します。
     */
    private ReportMacRequestManager() {
    }

    /**
     * インスタンスを返します。
     *
     * @return インスタンス
     */
    public static ReportMacRequestManager getInstance() {
        return _manager;
    }

    /**
     * 帳票データ(TOH)を検索します。
     *
     * @return ReportMacResult 汎用マスタ検索データ
     * @throws KKHException 処理中にエラーが発生した場合
     */
    public ReportMacRequestResult findByCondition(ReportMacRequestCondition cond) throws KKHException {
        //検索結果
        ReportMacRequestResult result = new ReportMacRequestResult();

        //******************************************************
        //広告費明細データを取得
        //******************************************************
        ReportMacRequestDAO reportMacDAO = ReportMacRequestDAOFactory.createReportMacRequestDAO();

        List<ReportMacRequestVO> list = reportMacDAO.findReportMacRequestByCondition(cond);
        result.setReportMacRequest(list);

        return result;
    }

}

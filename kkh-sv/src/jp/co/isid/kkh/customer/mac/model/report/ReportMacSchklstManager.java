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
public class ReportMacSchklstManager {

    /** シングルトンインスタンス */
    private static ReportMacSchklstManager _manager = new ReportMacSchklstManager();

    /**
     * シングルトンの為、インスタンス化を禁止します。
     */
    private ReportMacSchklstManager() {
    }

    /**
     * インスタンスを返します。
     *
     * @return インスタンス
     */
    public static ReportMacSchklstManager getInstance() {
        return _manager;
    }

    /**
     * 帳票データ(TOH)を検索します。
     *
     * @return ReportMacResult 汎用マスタ検索データ
     * @throws KKHException 処理中にエラーが発生した場合
     */
    public ReportMacSchklstResult findByCondition(ReportMacSchklstCondition cond) throws KKHException {
        //検索結果
        ReportMacSchklstResult result = new ReportMacSchklstResult();

        //******************************************************
        //広告費明細データを取得
        //******************************************************
        ReportMacSchklstDAO reportMacDAO = ReportMacSchklstDAOFactory.createReportMacSchklstDAO();

        List<ReportMacSchklstVO> list = reportMacDAO.findReportMacSchklstByCondition(cond);
        result.setReportMacSchklst(list);

        return result;
    }

}

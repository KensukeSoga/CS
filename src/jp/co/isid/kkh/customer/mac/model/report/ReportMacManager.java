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
public class ReportMacManager {

    /** シングルトンインスタンス */
    private static ReportMacManager _manager = new ReportMacManager();

    /**
     * シングルトンの為、インスタンス化を禁止します。
     */
    private ReportMacManager() {
    }

    /**
     * インスタンスを返します。
     *
     * @return インスタンス
     */
    public static ReportMacManager getInstance() {
        return _manager;
    }

    /**
     * 帳票データ(TOH)を検索します。
     *
     * @return ReportMacResult 汎用マスタ検索データ
     * @throws KKHException 処理中にエラーが発生した場合
     */
    public ReportMacResult findByCondition(ReportMacCondition cond) throws KKHException {
        //検索結果
        ReportMacResult result = new ReportMacResult();

        //******************************************************
        //広告費明細データを取得
        //******************************************************
        ReportMacDAO reportMacDAO = ReportMacDAOFactory.createReportMacDAO();

        List<ReportMacVO> list = reportMacDAO.findReportMacByCondition(cond);
        result.setReportMac(list);

        return result;
    }

}

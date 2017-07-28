package jp.co.isid.kkh.customer.toh.model.report;

import java.util.List;
import jp.co.isid.kkh.model.base.KKHException;

/**
 * <P>
 * 帳票（TOH)マスタ検索Manager。
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2011/11/07 JSE KT)<BR>
 * </P>
 * @author
 */
public class ReportTohManager {

    /** シングルトンインスタンス */
    private static ReportTohManager _manager = new ReportTohManager();

    /**
     * シングルトンの為、インスタンス化を禁止します。
     */
    private ReportTohManager() {
    }

    /**
     * インスタンスを返します。
     *
     * @return インスタンス
     */
    public static ReportTohManager getInstance() {
        return _manager;
    }

    /**
     * 帳票データ(TOH)を検索します。
     *
     * @return ReportTohResult 汎用マスタ検索データ
     * @throws KKHException 処理中にエラーが発生した場合
     */
    public ReportTohResult findByCondition(ReportTohCondition cond) throws KKHException {
        //検索結果
        ReportTohResult result = new ReportTohResult();

        //******************************************************
        //広告費明細データを取得
        //******************************************************
        ReportTohDAO reportTohDAO = ReportTohDAOFactory.createReportTohDAO();

        List<ReportTohVO> list = reportTohDAO.findReportTohByCondition(cond);
        result.setReportToh(list);

        return result;
    }

}

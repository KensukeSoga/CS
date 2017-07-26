package jp.co.isid.kkh.customer.ash.model.report;

import java.util.List;
import jp.co.isid.kkh.model.base.KKHException;

/**
 * <P>
 * 帳票（Ash)マスタ検索Manager。
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2011/1/20 fourm h.izawa)<BR>
 * </P>
 * @author
 */
public class ReportAshMediaManager {

    /** シングルトンインスタンス */
    private static ReportAshMediaManager _manager = new ReportAshMediaManager();

    /**
     * シングルトンの為、インスタンス化を禁止します。
     */
    private ReportAshMediaManager() {
    }

    /**
     * インスタンスを返します。
     *
     * @return インスタンス
     */
    public static ReportAshMediaManager getInstance() {
        return _manager;
    }

    /**
     * 帳票データ(Ash)を検索します。
     *
     * @return ReportAshMediaResult 媒体種別一覧検索データ
     * @throws KKHException 処理中にエラーが発生した場合
     */
    public ReportAshMediaResult findByCondition(ReportAshMediaCondition cond) throws KKHException {

        //検索結果
        ReportAshMediaResult result = new ReportAshMediaResult();

        //******************************************************
        //媒体種別データを取得
        //******************************************************
        ReportAshMediaDAO reportAshMediaDAO = ReportAshMediaDAOFactory.createReportAshMediaDAO();
        List<ReportAshMediaVO> list = reportAshMediaDAO.findReportMacByCondition(cond);
        result.setReportAsh(list);

        List<ReportAshMediaVO> listALL = reportAshMediaDAO.findReportMacALLByCondition(cond);
        result.setReportAshALL(listALL);

        return result;
    }

}

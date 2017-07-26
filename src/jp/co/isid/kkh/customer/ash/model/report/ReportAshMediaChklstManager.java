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
public class ReportAshMediaChklstManager {

    /** シングルトンインスタンス */
    private static ReportAshMediaChklstManager _manager = new ReportAshMediaChklstManager();

    /**
     * シングルトンの為、インスタンス化を禁止します。
     */
    private ReportAshMediaChklstManager() {
    }

    /**
     * インスタンスを返します。
     *
     * @return インスタンス
     */
    public static ReportAshMediaChklstManager getInstance() {
        return _manager;
    }

    /**
     * 帳票データ(Ash)を検索します。
     *
     * @return ReportAshMediaResult 媒体種別一覧検索データ
     * @throws KKHException 処理中にエラーが発生した場合
     */
    public ReportAshMediaChklstResult findByCondition(ReportAshMediaCondition cond) throws KKHException {
        //検索結果
        ReportAshMediaChklstResult result = new ReportAshMediaChklstResult();

        //******************************************************
        //媒体種別データを取得
        //******************************************************
        ReportAshMediaChklstDAO reportAshMediaChklstDAO = ReportAshMediaChklstDAOFactory.createReportAshMediaDAO();
        List<ReportAshMediaChklstVO> list = reportAshMediaChklstDAO.findReportAshMediaChklstByCondition(cond);
        result.setReportAshChklst(list);

        return result;
    }

}

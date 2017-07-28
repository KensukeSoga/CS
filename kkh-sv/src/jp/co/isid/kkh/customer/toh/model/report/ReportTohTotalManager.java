package jp.co.isid.kkh.customer.toh.model.report;

import java.util.List;
import jp.co.isid.kkh.model.base.KKHException;


/**
 * <P>
 * 帳票（年月別媒体別集計)検索Manager。
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/02/22 JSE T.Kobayashi)<BR>
 * </P>
 * @author
 */
public class ReportTohTotalManager {

    /** シングルトンインスタンス */
    private static ReportTohTotalManager _manager = new ReportTohTotalManager();

    /**
     * シングルトンの為、インスタンス化を禁止します。
     */
    private ReportTohTotalManager() {
    }

    /**
     * インスタンスを返します。
     *
     * @return インスタンス
     */
    public static ReportTohTotalManager getInstance() {
        return _manager;
    }

    /**
     * 帳票（年月別媒体別集計)を検索します。
     *
     * @return ReportTohTotalResult 汎用マスタ検索データ
     * @throws KKHException 処理中にエラーが発生した場合
     */
    public ReportTohTotalResult findByCondition(ReportTohTotalCondition cond) throws KKHException {
    	//検索結果
    	ReportTohTotalResult result = new ReportTohTotalResult();

    	//******************************************************
    	//広告費明細データを取得
    	//******************************************************
    	ReportTohTotalDAO reportTohTotalDAO = ReportTohTotalDAOFactory.createReportTohTotalDAO();

    	List<ReportTohTotalVO> list = reportTohTotalDAO.findReportTohTotalByCondition(cond);
    	result.setReportTohTotal(list);

        return result;

    }




}

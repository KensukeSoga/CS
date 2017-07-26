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
public class ReportMacGetDenNumManager {

    /** シングルトンインスタンス */
    private static ReportMacGetDenNumManager _manager = new ReportMacGetDenNumManager();

    /**
     * シングルトンの為、インスタンス化を禁止します。
     */
    private ReportMacGetDenNumManager() {
    }

    /**
     * インスタンスを返します。
     *
     * @return インスタンス
     */
    public static ReportMacGetDenNumManager getInstance() {
        return _manager;
    }

    /**
     * 帳票データ(TOH)を検索します。
     *
     * @return ReportMacResult 汎用マスタ検索データ
     * @throws KKHException 処理中にエラーが発生した場合
     */
    public ReportMacGetDenNumResult findByCondition(ReportMacGetDenNumCondition cond) throws KKHException {
        //検索結果
        ReportMacGetDenNumResult result = new ReportMacGetDenNumResult();

        //******************************************************
        //広告費明細データを取得
        //******************************************************
        ReportMacGetDenNumDAO reportMacDAO = ReportMacGetDenNumDAOFactory.createReportMacGetDenNumDAO();

        List<ReportMacGetDenNumVO> list = reportMacDAO.findReportMacGetDenNumByCondition(cond);
        result.setReportMacGetDenNum(list);

        return result;
    }

}

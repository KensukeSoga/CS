package jp.co.isid.kkh.customer.mac.model.report;

import java.util.List;
import jp.co.isid.kkh.model.base.KKHException;
/**
 * <P>
 * 帳票（MAC)マスタ検索Manager。
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2011/1/12 fourm h.izawa)<BR>
 * </P>
 * @author
 */
public class ReportMacLicenseeManager {

    /** シングルトンインスタンス */
    private static ReportMacLicenseeManager _manager = new ReportMacLicenseeManager();

    /**
     * シングルトンの為、インスタンス化を禁止します。
     */
    private ReportMacLicenseeManager() {
    }

    /**
     * インスタンスを返します。
     *
     * @return インスタンス
     */
    public static ReportMacLicenseeManager getInstance() {
        return _manager;
    }

    /**
     * 帳票データ(MAC)を検索します。
     *
     * @return ReportMacResult 汎用マスタ検索データ
     * @throws KKHException 処理中にエラーが発生した場合
     */
    public ReportMacLicenseeResult findByCondition(ReportMacCondition cond) throws KKHException {
    	//検索結果
    	ReportMacLicenseeResult result = new ReportMacLicenseeResult();

    	//******************************************************
    	//広告費明細データを取得
    	//******************************************************
    	ReportMacLicenseeDAO reportMacLicenseeDAO = ReportMacLicenseeDAOFactory.createReportMacLicenseeDAO();
    	List<ReportMacLicenseeVO> list = reportMacLicenseeDAO.findReportMacByCondition(cond);
    	result.setReportMac(list);

        return result;

    }



}

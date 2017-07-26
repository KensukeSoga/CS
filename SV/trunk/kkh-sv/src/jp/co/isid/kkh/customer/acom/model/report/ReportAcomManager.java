package jp.co.isid.kkh.customer.acom.model.report;

import java.util.List;

import jp.co.isid.kkh.customer.acom.model.report.ReportAcomCondition;
import jp.co.isid.kkh.customer.acom.model.report.ReportAcomDAO;
import jp.co.isid.kkh.customer.acom.model.report.ReportAcomDAOFactory;
import jp.co.isid.kkh.customer.acom.model.report.ReportAcomManager;
import jp.co.isid.kkh.customer.acom.model.report.ReportAcomResult;
import jp.co.isid.kkh.customer.acom.model.report.ReportAcomVO;
import jp.co.isid.kkh.model.base.KKHException;

/**
 * <P>
 * 帳票（アコム)マスタ検索Manager。
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/01/11)<BR>
 * </P>
 * @author
 */

public class ReportAcomManager {


    /** シングルトンインスタンス */
    private static ReportAcomManager _manager = new ReportAcomManager();

    /**
     * シングルトンの為、インスタンス化を禁止します。
     */
    private ReportAcomManager() {
    }

    /**
     * インスタンスを返します。
     *
     * @return インスタンス
     */
    public static ReportAcomManager getInstance() {
        return _manager;
    }


    /**
     * 帳票データ(ACOM)を検索します。
     *
     * @return ReportAcomResult 汎用マスタ検索データ
     * @throws KKHException 処理中にエラーが発生した場合
     */
    public ReportAcomResult findByCondition(ReportAcomCondition cond) throws KKHException {
        // パラメータの必須チェック
        if (cond.getEsqId() == null || cond.getEsqId().equals("")) {
            throw new KKHException("パラメータ指定エラー", "BD-E0001");
        }
        if (cond.getEgCd() == null || cond.getEgCd().equals("")) {
            throw new KKHException("パラメータ指定エラー", "BD-E0001");
        }
        if (cond.getTksKgyCd() == null || cond.getTksKgyCd().equals("")) {
            throw new KKHException("パラメータ指定エラー", "BD-E0001");
        }
        if (cond.getTksBmnSeqNo() == null || cond.getTksBmnSeqNo().equals("")) {
            throw new KKHException("パラメータ指定エラー", "BD-E0001");
        }
        if (cond.getTksTntSeqNo() == null || cond.getTksTntSeqNo().equals("")) {
            throw new KKHException("パラメータ指定エラー", "BD-E0001");
        }
        if (cond.getYm() == null || cond.getYm().equals("")) {
            throw new KKHException("パラメータ指定エラー", "BD-E0001");
        }
    	//検索結果
    	ReportAcomResult result = new ReportAcomResult();

    	//******************************************************
    	//広告費明細データを取得
    	//******************************************************
    	ReportAcomDAO reportAcomDAO = ReportAcomDAOFactory.createReportAcomDAO();

    	List<ReportAcomVO> list = reportAcomDAO.findReportAcomByCondition(cond);
    	result.setReportAcom(list);

        return result;
    }

}

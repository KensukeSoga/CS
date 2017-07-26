package jp.co.isid.kkh.customer.lion.model.report;

import java.util.List;

import jp.co.isid.kkh.customer.lion.model.report.ReportLionCondition;
import jp.co.isid.kkh.customer.lion.model.report.ReportLionDAOFactory;
import jp.co.isid.kkh.customer.lion.model.report.ReportLionManager;
import jp.co.isid.kkh.customer.lion.model.report.ReportLionResult;
import jp.co.isid.kkh.customer.lion.model.report.ReportLionVO;
import jp.co.isid.kkh.customer.lion.model.report.proof.ReportLionSonotaDAO;
import jp.co.isid.kkh.customer.lion.util.LionConstants;
import jp.co.isid.kkh.model.base.KKHException;

/**
 * <P>
 * 帳票（Lion)マスタ検索Manager。
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/01/11)<BR>
 * ・比較帳票対応(2014/07/31 HLC S.Fujimoto)<BR>
 * </P>
 *
 * @author
 */

public class ReportLionManager {


    /** シングルトンインスタンス */
    private static ReportLionManager _manager = new ReportLionManager();

    /**
     * シングルトンの為、インスタンス化を禁止します。
     */
    private ReportLionManager() {
    }

    /**
     * インスタンスを返します。
     * @return インスタンス
     */
    public static ReportLionManager getInstance() {
        return _manager;
    }

    /**
     * ライオン帳票データ(プルーフリスト)を検索します。
     *
     * @return ReportLionResult 汎用マスタ検索データ
     * @throws KKHException 処理中にエラーが発生した場合
     */
    public ReportLionResult findByCondition(ReportLionCondition cond) throws KKHException {

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
        ReportLionResult result = new ReportLionResult();

        //******************************************************
        //広告費明細データを取得
        //******************************************************
        //ReportLionDAO reportLionDAO = ReportLionDAOFactory.createReportLionDAO();
        //List<ReportLionVO> list = reportLionDAO.findReportLionByCondition(cond);

        ReportLionProofDaoInterface dao = ReportLionDAOFactory.createReportLionDAO(cond.getbaitai());
        List<ReportLionVO> list = dao.findReportLionByCondition(cond);

        result.setReportLion(list);

        //*****************************************************
        //その他専用 消費税取得
        //*****************************************************
        if(cond.getbaitai().equals(LionConstants.BaitaiCode.SONOTA.getName()))
        {
            ReportLionSonotaDAO sonotaDAO = new ReportLionSonotaDAO();
            List<ReportLionVO> sonotalist = sonotaDAO.findReportLionSyohiZeiByCondition(cond);
            result.setReportLionSyohiZei(sonotalist);
        }
        //*****************************************************
        //制作専用 媒体コード名称取得
        //*****************************************************
//    	else if(cond.getbaitai().equals(LionConstants.BaitaiCode.SEISAKU.getName()))
//    	{
//    		ReportLionSeisakDAO seisakuDAO = new ReportLionSeisakDAO();
//    		List<ReportLionVO> seisakulist = seisakuDAO.findReportLionBaitaiCdName(cond);
//    		result.setBaitaiCdName(seisakulist);
//    	}

        return result;
    }

}

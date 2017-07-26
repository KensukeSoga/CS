package jp.co.isid.kkh.customer.lion.model.report;

import java.util.List;

import jp.co.isid.kkh.customer.lion.model.report.DetailListLionCondition;
import jp.co.isid.kkh.customer.lion.model.report.DetailListLionDAOFactory;
import jp.co.isid.kkh.customer.lion.model.report.DetailListLionManager;
import jp.co.isid.kkh.customer.lion.model.report.DetailListLionResult;
import jp.co.isid.kkh.customer.lion.model.report.DetailListLionVO;
import jp.co.isid.kkh.customer.lion.model.report.detaillist.DetailListLionSonotaDAO;
import jp.co.isid.kkh.customer.lion.util.LionConstants;
import jp.co.isid.kkh.model.base.KKHException;
/**
 * <P>
 * ライオン明細一覧帳票検索マネージャ
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2013/02/07)<BR>
 * </P>
 * @author
 */

public class DetailListLionManager {


    /** シングルトンインスタンス */
    private static DetailListLionManager _manager = new DetailListLionManager();

    /**
     * シングルトンの為、インスタンス化を禁止します。
     */
    private DetailListLionManager() {
    }

    /**
     * インスタンスを返します。
     *
     * @return インスタンス
     */
    public static DetailListLionManager getInstance() {
        return _manager;
    }


    /**
     * 明細一覧データ(Lion)を検索します。
     *
     * @return DetailListLionResult 汎用マスタ検索データ
     * @throws KKHException 処理中にエラーが発生した場合
     */
    public DetailListLionResult findByCondition(DetailListLionCondition cond) throws KKHException {
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
        DetailListLionResult result = new DetailListLionResult();

        //******************************************************
        //広告費明細データを取得
        //******************************************************
        DetailListLionDaoInterface dao = DetailListLionDAOFactory.createDetailListLionDAO(cond.getymfrom()
                                                                                          ,cond.getymto()
                                                                                          ,cond.getbaitaikbn()
                                                                                          );
        List<DetailListLionVO> list = dao.findDetailListLionByCondition(cond);

        result.setDetailListLion(list);

        //*****************************************************
        //その他専用 消費税取得
        //*****************************************************
        if(cond.getbaitaikbn().equals(LionConstants.BaitaiCode.SONOTA.getName()))
        {
            DetailListLionSonotaDAO sonotaDAO = new DetailListLionSonotaDAO();
            List<DetailListLionVO> sonotalist = sonotaDAO.findDetailListLionSyohiZeiByCondition(cond);
            result.setDetailListLionSyohiZei(sonotalist);
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

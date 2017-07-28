package jp.co.isid.kkh.customer.ash.model.report;

import java.util.List;
import jp.co.isid.kkh.model.base.KKHException;

/**
 * <P>
 * 広告費明細書（Ash）データ検索Manager
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2011/1/20 fourm h.izawa)<BR>
 * </P>
 * @author
 */
public class ReportAshKoukokuHiManager {

    /** シングルトンインスタンス */
    private static ReportAshKoukokuHiManager _manager = new ReportAshKoukokuHiManager();

    /**
     * シングルトンの為、インスタンス化を禁止します。
     */
    private ReportAshKoukokuHiManager() {
    }

    /**
     * インスタンスを返します。
     *
     * @return インスタンス
     */
    public static ReportAshKoukokuHiManager getInstance() {
        return _manager;
    }

    /**
     * 帳票データ(Ash)を検索します。
     *
     * @return ReportAshMediaResult 媒体種別一覧検索データ
     * @throws KKHException 処理中にエラーが発生した場合
     */
    public ReportAshKoukokuHiResult findByCondition(ReportAshMediaCondition cond) throws KKHException {

        //検索結果
        ReportAshKoukokuHiResult result = new ReportAshKoukokuHiResult();

        //******************************************************
        //媒体種別データを取得
        //******************************************************
        ReportAshKoukokuHiDAO reportAshKoukokuHiDAO = ReportAshKoukokuHiDAOFactory.createReportAshKoukokuHiDAO();
        List<ReportAshKoukokuHiVO> list = reportAshKoukokuHiDAO.findReportAshKoukokuHiByCondition(cond);
        result.setReportAsh(list);

        //******************************************************
        //テレビタイム、ラジオタイムの明細金額の取得
        //******************************************************
        List<ReportAshTvAndRadioKingakVO> TvAndRadiolist = reportAshKoukokuHiDAO.findTvAndRadioKingakByCondition(cond);
        result.setReportAshTvAndRadio(TvAndRadiolist);
        return result;
    }

}

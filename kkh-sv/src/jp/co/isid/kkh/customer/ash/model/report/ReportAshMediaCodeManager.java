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
public class ReportAshMediaCodeManager {

    /** シングルトンインスタンス */
    private static ReportAshMediaCodeManager _manager = new ReportAshMediaCodeManager();

    /**
     * シングルトンの為、インスタンス化を禁止します。
     */
    private ReportAshMediaCodeManager() {
    }

    /**
     * インスタンスを返します。
     *
     * @return インスタンス
     */
    public static ReportAshMediaCodeManager getInstance() {
        return _manager;
    }

    /**
     * 帳票データ(Ash)を検索します。
     *
     * @return ReportAshMediaResult 媒体種別一覧検索データ
     * @throws KKHException 処理中にエラーが発生した場合
     */
    public ReportAshMediaCodeResult findByCondition(ReportAshMediaCondition cond) throws KKHException {

        //検索結果
        ReportAshMediaCodeResult result = new ReportAshMediaCodeResult();

        //******************************************************
        //baitaiデータを取得
        //******************************************************
        ReportAshMediaCodeDAO reportAshMediaDAO = ReportAshMediaCodeDAOFactory.createReportAshMediaCodeDAO();
        List<ReportAshMediaCodeVO> list = reportAshMediaDAO.findReportAshMediaCodeByCondition(cond);
        result.setReportAshCode(list);

        //******************************************************
        //Syohinデータを取得
        //******************************************************
        List<ReportAshMediaCodeVO> syohinlist = reportAshMediaDAO.findSyohinByCondition(cond);
        result.setSyohinCode(syohinlist);

        //*******************************************************
        //マスタデータ取得
        //*******************************************************
        List<ReportAshOldKyokuVO> OldKyokulist = reportAshMediaDAO.findOldKyokuByCondition(cond);
        result.setReportAshOldKyoku(OldKyokulist);

        //*******************************************************
        //番組データ取得
        //*******************************************************
        List<ReportAshBangumiDataVO> Bangumilist = reportAshMediaDAO.findBangumiDataByCondition(cond);
        result.setReportAshBangumiData(Bangumilist);

        return result;
    }

}

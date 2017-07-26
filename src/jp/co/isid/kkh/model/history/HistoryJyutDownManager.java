package jp.co.isid.kkh.model.history;

import java.util.List;
import jp.co.isid.kkh.model.base.KKHException;

/**
 * <P>
 * 履歴（Lion)検索Manager。
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2011/2/1 fourm h.izawa)<BR>
 * </P>
 * @author
 */
public class HistoryJyutDownManager {

    /** シングルトンインスタンス */
    private static HistoryJyutDownManager _manager = new HistoryJyutDownManager();

    /**
     * シングルトンの為、インスタンス化を禁止します。
     */
    private HistoryJyutDownManager() {
    }

    /**
     * インスタンスを返します。
     *
     * @return インスタンス
     */
    public static HistoryJyutDownManager getInstance() {
        return _manager;
    }

    /**
     * 帳票データ(Ash)を検索します。
     *
     * @return ReportAshMediaResult 媒体種別一覧検索データ
     * @throws KKHException 処理中にエラーが発生した場合
     */
    public HistoryJyutDownResult findByCondition(HistoryJyutDownCondition cond) throws KKHException {
        //検索結果
        HistoryJyutDownResult result = new HistoryJyutDownResult();

        //******************************************************
        //媒体種別データを取得
        //******************************************************
        HistoryJyutDownDAO HisLionDAO = HistoryJyutDownDAOFactory.createHistoryLionJyutDownDAO();
        List<HistoryJyutDownVO> list = HisLionDAO.findReportMacByCondition(cond);
        result.setReportAsh(list);

        return result;
    }

}

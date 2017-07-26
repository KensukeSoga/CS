package jp.co.isid.kkh.customer.lion.model.report;

import jp.co.isid.kkh.model.base.KKHException;

/**
 * <P>
 * ライオン受注履歴作成検索Manager
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2014/07/31 HLC S.Fujimoto)<BR>
 * </P>
 *
 * @author HLC S.Fujimoto
 */
public class LionHistoryManager {

    /** シングルトンインスタンス */
    private static LionHistoryManager _manager = new LionHistoryManager();

    /** ライオン履歴作成条件 */
//    LionHistoryCondition cond = new LionHistoryCondition();

    /**
     * シングルトンの為、インスタンス化を禁止します。
     */
    private LionHistoryManager() {
    }

    /**
     * インスタンスを返します。
     *
     * @return インスタンス
     */
    public static LionHistoryManager getInstance() {
        return _manager;
    }

     /**
     * ライオン受注履歴データを登録します。
     * @throws KKHException 処理中にエラーが発生した場合
     */
    public LionHistoryResult insertLionRrkInfo(LionHistoryCondition cond) throws KKHException {

        // パラメータの必須チェック
        if (!CheckParameter(cond)) {
            throw new KKHException("パラメータ指定エラー", "BD-E0001");
        }

        LionHistoryResult result = new LionHistoryResult();

        // 受注ダウンロード
        LionHistoryHeaderDAO headerDao = LionHistoryHeaderDAOFactory.createDAO();
        headerDao.insertHistoryHeaderCreate(cond);

        //広告費明細
        LionHistoryDetailDAO detailDao = LionHistoryDetailDAOFactory.createDAO();
        detailDao.insertHistoryDetailCreate(cond);

        return result;
    }

    /**
     * パラメータチェック
     * @param cond ライオン履歴条件
     * @return ture: OK、false: NG
     * @throws KKHException 処理中にエラーが発生した場合
     */
    private boolean CheckParameter(LionHistoryCondition cond) throws KKHException {

        //ESQ-ID
        if (cond.getEsqId() == null || cond.getEsqId().equals("")) {
            return false;
        }
        //営業所コード
        if (cond.getEgCd() == null || cond.getEgCd().equals("")) {
            return false;
        }
        //得意先企業コード
        if (cond.getTksKgyCd() == null || cond.getTksKgyCd().equals("")) {
            return false;
        }
        //得意先部門SEQNO
        if (cond.getTksBmnSeqNo() == null || cond.getTksBmnSeqNo().equals("")) {
            return false;
        }
        //得意先担当SEQNO
        if (cond.getTksTntSeqNo() == null || cond.getTksTntSeqNo().equals("")) {
            return false;
        }
        //年月
        if (cond.getYymm() == null || cond.getYymm().equals("")) {
            return false;
        }
        //履歴タイムスタンプ
        if (cond.getRrkTimStmp() == null || cond.getRrkTimStmp().equals("")) {
            return false;
        }
        //履歴作成時選択媒体
        if (cond.getRrkGetBaitai() == null || cond.getRrkGetBaitai().equals("")) {
            return false;
        }

        return true;
    }

}

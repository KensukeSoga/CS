package jp.co.isid.kkh.customer.lion.model.report;

import java.util.List;
import jp.co.isid.kkh.model.base.KKHException;

/**
 * <P>
 * ライオン帳票(見積書)検索Manager。
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/3/06 fourm h.izawa)<BR>
 * </P>
 * @author
 */
public class NewReportLionManager {

    /** シングルトンインスタンス */
    private static NewReportLionManager _manager = new NewReportLionManager();

    /**
     * シングルトンの為、インスタンス化を禁止します。
     */
    private NewReportLionManager() {
    }

    /**
     * インスタンスを返します。
     *
     * @return インスタンス
     */
    public static NewReportLionManager getInstance() {
        return _manager;
    }

    /**
     * ライオン帳票データ(見積書)を検索します。
     *
     * @return NewReportLionResult 媒体種別一覧検索データ
     * @throws KKHException 処理中にエラーが発生した場合
     */
    public NewReportLionResult findByCondition(NewReportLionCondition cond) throws KKHException {

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
        if (cond.getYymm() == null || cond.getYymm().equals("")) {
            throw new KKHException("パラメータ指定エラー", "BD-E0001");
        }
        if(cond.getBaitaiCd() == null || cond.getBaitaiCd().equals("")){
            throw new KKHException("パラメータ指定エラー", "BD-E0001");
        }

        NewReportLionResult result = new NewReportLionResult();
        NewReportLionDAO reportLionDAO = NewReportLionDAOFactory.createReportAshKoukokuHiDAO();
        //検索開始
        List<NewReportLionVO> list = reportLionDAO.findReportLionByCondition(cond);
        //検索結果格納
        result.setReportLion(list);

        return result;
    }

}

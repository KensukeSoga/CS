package jp.co.isid.kkh.customer.lion.model.report;

import java.util.List;
import jp.co.isid.kkh.model.base.KKHException;

/**
 * <P>
 * ライオン帳票(制作室リスト)検索Manager。
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2014/07/31 HLC S.Fujimoto)<BR>
 * </P>
 *
 * @author HLC S.Fujimoto
 */
public class AddChangeReportLionSeisakuManager {

    /** シングルトンインスタンス */
    private static AddChangeReportLionSeisakuManager _manager = new AddChangeReportLionSeisakuManager();

    /**
     * 検索種別
     */
    /** 履歴タイムスタンプ */
    private static final String RRKTIMSTMP = "RRKTIMSTMP";
    /** 制作室リスト(AD1) */
    private static final String SEISAKUAD1 = "SEISAKUAD1";
    /** 制作室リスト(AD2) */
    private static final String SEISAKUAD2 = "SEISAKUAD2";

    /**
     * シングルトンの為、インスタンス化を禁止します。
     */
    private AddChangeReportLionSeisakuManager() {
    }

    /**
     * インスタンスを返します。
     * @return インスタンス
     */
    public static AddChangeReportLionSeisakuManager getInstance() {
        return _manager;
    }

    /**
     * ライオン帳票データ(制作室リスト)を検索します。
     *
     * @return ReportAshMediaResult 媒体種別一覧検索データ
     * @throws KKHException 処理中にエラーが発生した場合
     */
    public AddChangeReportLionSeisakuResult findByCondition(AddChangeReportLionSeisakuCondition cond) throws KKHException {

        // パラメータの必須チェック
        if (!CheckParameter(cond)) {
            throw new KKHException("パラメータ指定エラー", "BD-E0001");
        }

        AddChangeReportLionSeisakuResult result = new AddChangeReportLionSeisakuResult();
        AddChangeReportLionSeisakuDAO dao = AddChangeReportLionSeisakuDAOFactory.createDAO();

        //履歴タイムスタンプの場合
        if (cond.getFindType().equals(RRKTIMSTMP)) {
            //検索開始
            List<AddChangeReportLionSeisakuVO> list = dao.findAddChangeReportSeisaku(cond);
            //検索結果格納
            result.setRrkTimStmpInfo(list);
        }
        //制作室リスト(AD1)の場合
        else if (cond.getFindType().equals(SEISAKUAD1)) {
            //検索開始
            List<AddChangeReportLionSeisakuVO> list = dao.findAddChangeReportSeisaku(cond);
            //検索結果格納
            result.setSeisakuAD1Info(list);
        }
        //制作しリスト(AD2)の場合
        else if (cond.getFindType().equals(SEISAKUAD2)) {
            //AD1検索開始
            List<AddChangeReportLionSeisakuVO> list2 = dao.findAddChangeReportSeisaku(cond);
            //検索結果格納
            result.setSeisakuAD1Info(list2);

            //差分取得
            List<AddChangeReportLionSeisakuVO> list3 = dao.findAddChangeReportSeisakuDiff(cond);
            //検索結果格納
            result.setSeisakuDiffInfo(list3);

            //AD2検索開始
            cond.setRrkTimStmp(null);   //履歴タイムスタンプ初期化
            List<AddChangeReportLionSeisakuVO> list = dao.findAddChangeReportSeisaku(cond);
            //検索結果格納
            result.setSeisakuAD2Info(list);
        }

        return result;
    }

    /**
     * パラメータ必須チェック
     * @param cond ライオン履歴条件
     * @return True: OK、False: NG
     */
    private boolean CheckParameter(AddChangeReportLionSeisakuCondition cond) {

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
        //検索種別
        if (cond.getFindType() == null || cond.getFindType().equals("")) {
            return false;
        }

        //制作室リスト(AD2)の場合、履歴タイムスタンプ必須
        if (cond.getFindType().equals(SEISAKUAD2)) {
            if (cond.getRrkTimStmp() == null || cond.getRrkTimStmp().equals("")) {
                return false;
            }
        }

        return true;
    }

}

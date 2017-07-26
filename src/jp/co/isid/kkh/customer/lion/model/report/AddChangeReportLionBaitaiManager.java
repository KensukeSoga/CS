package jp.co.isid.kkh.customer.lion.model.report;

import java.util.List;

import jp.co.isid.kkh.model.base.KKHException;

/**
 * <P>
 * ライオン帳票(追加変更リスト)検索Manager。
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2014/07/31 HLC S.Fujimoto)<BR>
 * </P>
 *
 * @author HLC S.Fujimoto
 */
public class AddChangeReportLionBaitaiManager {

    /** シングルトンインスタンス */
    private static AddChangeReportLionBaitaiManager _manager = new AddChangeReportLionBaitaiManager();

    /**
     * 検索種別
     */
    /** 履歴タイムスタンプ */
    private static final String RRKTIMSTMP = "RRKTIMSTMP";
    /** 追加変更リスト */
    private static final String BAITAI = "BAITAI";

    /**
     * シングルトンの為、インスタンス化を禁止します。
     */
    private AddChangeReportLionBaitaiManager() {
    }

    /**
     * インスタンスを返します。
     * @return インスタンス
     */
    public static AddChangeReportLionBaitaiManager getInstance() {
        return _manager;
    }

    /**
     * ライオン帳票データ(追加変更リスト)を検索します。
     * @param ライオン帳票(制作室リスト・追加変更リスト)データ検索条件
     * @return ReportAshMediaResult 媒体種別一覧検索データ
     * @throws KKHException 処理中にエラーが発生した場合
     */
    public AddChangeReportLionBaitaiResult findByCondition(AddChangeReportLionBaitaiCondition cond) throws KKHException {

        // パラメータの必須チェック
        if (!CheckParameter(cond)) {
            throw new KKHException("パラメータ指定エラー", "BD-E0001");
        }

        AddChangeReportLionBaitaiResult result = new AddChangeReportLionBaitaiResult();
        AddChangeReportLionBaitaiDAO dao = AddChangeReportLionBaitaiDAOFactory.createDAO();

        //履歴タイムスタンプの場合
        if (cond.getFindType().equals(RRKTIMSTMP)) {
            //検索開始
            List<AddChangeReportLionBaitaiVO> list = dao.findAddChangeReportBaitai(cond);
            //検索結果格納
            result.setRrkTimStmpInfo(list);
        }
        //追加変更リストの場合
        else if (cond.getFindType().equals(BAITAI)) {
            //AD1検索開始
            List<AddChangeReportLionBaitaiVO> list2 = dao.findAddChangeReportBaitai(cond);
            //検索結果格納
            result.setBaitaiAD1Info(list2);

            //差分取得(内部資料)
            List<AddChangeReportLionBaitaiVO> list3 = dao.findAddChangeReportBaitaiDiffInternal(cond);
            //検索結果格納
            result.setBaitaiDiffInfoInternal(list3);

            //差分取得
            List<AddChangeReportLionBaitaiVO> list4 = dao.findAddChangeReportBaitaiDiffExternal(cond);
            //検索結果格納
            result.setBaitaiDiffInfoExternal(list4);

            //AD2検索開始
            cond.setRrkTimStmp(null);   //履歴タイムスタンプ初期化
            List<AddChangeReportLionBaitaiVO> list = dao.findAddChangeReportBaitai(cond);
            //検索結果格納
            result.setBaitaiAD2Info(list);
        }

        return result;
    }

    /**
     * パラメータ必須チェック
     * @param cond ライオン履歴条件
     * @return True: OK、False: NG
     */
    private boolean CheckParameter(AddChangeReportLionBaitaiCondition cond) {

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
        //履歴タイムスタンプ取得以外の場合、履歴タイムスタンプ必須
        if (!cond.getFindType().equals(RRKTIMSTMP)) {
            if (cond.getRrkTimStmp() == null || cond.getRrkTimStmp().equals("")) {
                return false;
            }
        }

        return true;
    }

}

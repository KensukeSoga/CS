package jp.co.isid.kkh.controller.detail;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.model.detail.DetailManager;
import jp.co.isid.kkh.model.detail.BulkDataRegisterResult;
import jp.co.isid.kkh.model.detail.BulkDataRegisterVO;
import jp.co.isid.kkh.model.detail.Thb1DownVO;
import jp.co.isid.kkh.model.detail.Thb2KmeiVO;
import jp.co.isid.kkh.service.base.ErrorInfo;
import jp.co.isid.kkh.util.StringUtil;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * 一括登録コマンド
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2011/11/24 JSE H.Abe)<BR>
 * </P>
 *
 * @author JSE H.Abe
 */
public class BulkDataRegisterCmd extends Command {

    private static final long serialVersionUID = 1L;

    /** 一括登録処理用VO */
    private BulkDataRegisterVO _vo;

    /** 実行結果キー */
    private static final String RESULT_KEY = "RESULT_KEY";

    /**
     * 一括登録処理を実行します。
     *
     * @throws KKHException 登録に失敗した場合
     */
    public void execute() throws KKHException {

        DetailManager manager = DetailManager.getInstance();

        // 入力チェック
        checkInput();

        /*
         * 排他チェック
         */
        // ダウンロードデータの件数分、繰り返す
        for (Thb1DownVO currentDownVO : _vo.getThb1DownList()) {
            // 最新のダウンロードデータ取得
            List<Thb1DownVO> newThb1DownVOList = manager.lockThb1Down(currentDownVO);
            // ダウンロードデータ排他チェック
            ErrorInfo errorInfoThb1Down = checkExclusionThb1Down(newThb1DownVOList, currentDownVO.getHb1TimStmp());
            if (errorInfoThb1Down != null) {
                BulkDataRegisterResult result = new BulkDataRegisterResult();
                result.setErrorInfo(errorInfoThb1Down);
                getResult().set(RESULT_KEY, result);
                return;
            }
            // 広告費明細データ取得条件設定
            Thb2KmeiVO cond = new Thb2KmeiVO();
            setThb2KmeiCondition(cond, currentDownVO);
            // 広告費明細データ取得
            List<Thb2KmeiVO> thb2KmeiVOList = manager.lockThb2Kmei(cond);
            // 広告費明細データ排他チェック
            ErrorInfo errorInfoThb2Kmei = checkExclusionThb2Kmei(thb2KmeiVOList);
            if (errorInfoThb2Kmei != null) {
                BulkDataRegisterResult result = new BulkDataRegisterResult();
                result.setErrorInfo(errorInfoThb2Kmei);
                getResult().set(RESULT_KEY, result);
                return;
            }
        }

        /*
         * 一括登録
         */
        // ダウンロードデータの件数分、繰り返す
        for (Thb1DownVO currentDownVO : _vo.getThb1DownList()) {
            // 広告費明細データ編集
            Thb2KmeiVO thb2KmeiVO = new Thb2KmeiVO();
            editThb2KmeiVO(_vo, currentDownVO, thb2KmeiVO);
            // 広告費明細データ登録
            manager.insertThb2Kmei(thb2KmeiVO);
            // ダウンロードデータ編集
            editThb1DownVO(_vo, currentDownVO);
            // ダウンロードデータ更新
            manager.updateThb1DownForDisplayData(currentDownVO);

            //履歴データ更新
            manager.updateThb8RirekiForDisplayData(currentDownVO);
        }

        /*
         * 一括登録統合子対応
         */
        if(_vo.getTouIkkatsuThb1Down() != null)
        {
            for(Thb1DownVO UpRow : _vo.getTouIkkatsuThb1Down())
            {
                //実行
                manager.updateTourokuIkkatsuKoTaiou(UpRow);
            }
        }

        // 正常終了
        getResult().set(RESULT_KEY, new BulkDataRegisterResult());
    }

    /**
     * 一括登録VOの設定
     *
     * @param vo 一括登録VO
     */
    public void setBulkDataRegisterVO(BulkDataRegisterVO vo) {
        _vo = vo;
    }

    /**
     * 実行結果を返します。
     *
     * @return 実行結果
     */
    public BulkDataRegisterResult getBulkDataRegisterResult() {
        return (BulkDataRegisterResult) super.getResult().get(RESULT_KEY);
    }

    /**
     * パラメータ入力チェック
     *
     * @throws KKHException パラメータ指定エラーの場合
     */
    private void checkInput() throws KKHException {

        if (StringUtil.isBlank(_vo.getEsqId())) {
            throw new KKHException("パラメータ指定エラー", "BD-E0001");
        }
        if (StringUtil.isBlank(_vo.getAplId())) {
            throw new KKHException("パラメータ指定エラー", "BD-E0001");
        }
        if (StringUtil.isBlank(_vo.getEgCd())) {
            throw new KKHException("パラメータ指定エラー", "BD-E0001");
        }
        if (StringUtil.isBlank(_vo.getTksKgyCd())) {
            throw new KKHException("パラメータ指定エラー", "BD-E0001");
        }
        if (StringUtil.isBlank(_vo.getTksBmnSeqNo())) {
            throw new KKHException("パラメータ指定エラー", "BD-E0001");
        }
        if (StringUtil.isBlank(_vo.getTksTntSeqNo())) {
            throw new KKHException("パラメータ指定エラー", "BD-E0001");
        }
        if (_vo.getThb1DownList() == null) {
            throw new KKHException("パラメータ指定エラー", "BD-E0001");
        }
    }

    /**
     * 広告費明細データ取得条件の設定
     *
     * @param cond 広告費明細データ取得条件
     * @param downVO ダウンロードデータVO
     */
    private void setThb2KmeiCondition(Thb2KmeiVO cond, Thb1DownVO downVO) {
        cond.setHb2EgCd(downVO.getHb1EgCd());
        cond.setHb2TksKgyCd(downVO.getHb1TksKgyCd()); // TODO つづりが明細とダウンロードで異なる
        cond.setHb2TksBmnSeqNo(downVO.getHb1TksBmnSeqNo());
        cond.setHb2TksTntSeqNo(downVO.getHb1TksTntSeqNo());
        cond.setHb2Yymm(downVO.getHb1Yymm());
        cond.setHb2JyutNo(downVO.getHb1JyutNo());
        cond.setHb2JyMeiNo(downVO.getHb1JyMeiNo());
        cond.setHb2UrMeiNo(downVO.getHb1UrMeiNo());
    }

    /**
     * 排他チェック（ダウンロードデータ）
     *
     * @param newThb1DownVOList ダウンロードデータリスト（最新）
     * @param currentTimStmp 更新タイムスタンプ（現在）
     * @return 正常：null、チェックエラー：エラー情報
     */
    private ErrorInfo checkExclusionThb1Down(List<Thb1DownVO> newThb1DownVOList, Date currentTimStmp) {

        // 最新のダウンロードデータが取得できなかった場合
        if (newThb1DownVOList.size() == 0) {
            return createErrorInfo("排他エラー", "BD-W0001");
        }

        // 更新タイムスタンプ（最新）を取得
        Thb1DownVO newThb1DownVO = newThb1DownVOList.get(0);
        Date newTimStmp = newThb1DownVO.getHb1TimStmp();

        // 更新タイムスタンプ（最新）が更新タイムスタンプ（現在）より大きい場合
        if (newTimStmp.compareTo(currentTimStmp) > 0) {
            return createErrorInfo("排他エラー", "BD-W0001");
        }
        return null;
    }

    /**
     * 排他チェック（広告費明細データ）
     *
     * @param thb2KmeiVOList 広告費明細データリスト
     * @return 正常：null、チェックエラー：エラー情報
     */
    private ErrorInfo checkExclusionThb2Kmei(List<Thb2KmeiVO> thb2KmeiVOList) {

        // 広告費明細データが存在する場合
        if (thb2KmeiVOList.size() > 0) {
            return createErrorInfo("排他エラー", "BD-W0001");
        }
        return null;
    }

    /**
     * エラー情報生成
     *
     * @param message メッセージ
     * @param errorID エラーコード
     * @return エラー情報
     */
    private ErrorInfo createErrorInfo(String message, String errorID) {
        ErrorInfo errorInfo = new ErrorInfo();
        errorInfo.setError(true);
        errorInfo.setErrorCode(errorID);
        List<String> list = new ArrayList<String>();
        list.add(message);
        errorInfo.setNote(list);
        return errorInfo;
    }

    /**
     * 広告費明細データの編集
     *
     * @param bulkDataRegisterVO 一括登録処理用VO
     * @param thb1DownVO ダウンロードデータVO
     * @param 広告費明細データVO
     */
    private void editThb2KmeiVO(BulkDataRegisterVO bulkDataRegisterVO, Thb1DownVO thb1DownVO, Thb2KmeiVO thb2KmeiVO) {
        thb2KmeiVO.setHb2UpdApl(bulkDataRegisterVO.getAplId());
        thb2KmeiVO.setHb2UpdTnt(bulkDataRegisterVO.getEsqId());
        thb2KmeiVO.setHb2EgCd(bulkDataRegisterVO.getEgCd());
        thb2KmeiVO.setHb2TksKgyCd(bulkDataRegisterVO.getTksKgyCd());
        thb2KmeiVO.setHb2TksBmnSeqNo(bulkDataRegisterVO.getTksBmnSeqNo());
        thb2KmeiVO.setHb2TksTntSeqNo(bulkDataRegisterVO.getTksTntSeqNo());
        thb2KmeiVO.setHb2Yymm(thb1DownVO.getHb1Yymm());
        thb2KmeiVO.setHb2JyutNo(thb1DownVO.getHb1JyutNo());
        thb2KmeiVO.setHb2JyMeiNo(thb1DownVO.getHb1JyMeiNo());
        thb2KmeiVO.setHb2UrMeiNo(thb1DownVO.getHb1UrMeiNo());
        thb2KmeiVO.setHb2HimkCd(thb1DownVO.getHb1HimkCd());
        thb2KmeiVO.setHb2Renbn("001");
        thb2KmeiVO.setHb2DateFrom(" ");
        thb2KmeiVO.setHb2DateTo(" ");
        thb2KmeiVO.setHb2SeiGak(thb1DownVO.getHb1SeiGak());
        thb2KmeiVO.setHb2Hnnert(toBigDecimal("0"));
        thb2KmeiVO.setHb2HnmaeGak(toBigDecimal("0"));
        thb2KmeiVO.setHb2NebiGak(toBigDecimal("0"));

        if (StringUtil.isBlank(thb1DownVO.getHb1Field3())) {
            thb2KmeiVO.setHb2Date1(" ");
        } else {
            thb2KmeiVO.setHb2Date1(thb1DownVO.getHb1Field3());
        }

        thb2KmeiVO.setHb2Date2(" ");
        thb2KmeiVO.setHb2Date3(" ");
        thb2KmeiVO.setHb2Date4(" ");
        thb2KmeiVO.setHb2Date5(" ");
        thb2KmeiVO.setHb2Date6(" ");

        /*
         * 区分1（朝夕区分）の設定
         */
        // 朝夕区分が朝刊の場合
        if ("1".equals(thb1DownVO.getHb1Field4())) {
            thb2KmeiVO.setHb2Kbn1("M");
        // 朝夕区分が夕刊の場合
        } else {
            thb2KmeiVO.setHb2Kbn1("E");
        }

        thb2KmeiVO.setHb2Kbn2("1");
        thb2KmeiVO.setHb2Kbn3(" ");

        /*
         * コード1（スペース）の設定
         */
        String space = thb1DownVO.getHb1Field11();
        // スペースに"D"が含まれている、かつ"X"が含まれていない場合
        if (space.indexOf("D") >= 0 && space.indexOf("X") < 0) {
            // スペースの最後が"D"の場合
            if (space.indexOf("D") == space.length() - 1) {
                // 最後の"D"を削除
                space = space.substring(0, space.length() - 1);
            // 上記以外の場合
            } else {
                // 最初の"D"を"*"に変換
                space = space.replaceFirst("D", "*");
            }
        }

        if (StringUtil.isBlank(space)) {
            thb2KmeiVO.setHb2Code1(" ");
        } else {
            thb2KmeiVO.setHb2Code1(space);
        }

        if (StringUtil.isBlank(thb1DownVO.getHb1Field1())) {
            thb2KmeiVO.setHb2Code2(" ");
        } else {
            thb2KmeiVO.setHb2Code2(thb1DownVO.getHb1Field1());
        }

        thb2KmeiVO.setHb2Code3(" ");
        thb2KmeiVO.setHb2Code4(" ");
        thb2KmeiVO.setHb2Code5(" ");
        thb2KmeiVO.setHb2Code6(" ");
        thb2KmeiVO.setHb2Name1(" ");

        if (StringUtil.isBlank(thb1DownVO.getHb1Field2())) {
            thb2KmeiVO.setHb2Name2(" ");
        } else {
            thb2KmeiVO.setHb2Name2(thb1DownVO.getHb1Field2());
        }

        thb2KmeiVO.setHb2Name3(" ");
        thb2KmeiVO.setHb2Name4(" ");
        thb2KmeiVO.setHb2Name5(" ");
        thb2KmeiVO.setHb2Name6(" ");
        thb2KmeiVO.setHb2Name7(" ");

        if (StringUtil.isBlank(thb1DownVO.getHb1KKNameKJ())) {
            thb2KmeiVO.setHb2Name8(" ");
        } else {
            thb2KmeiVO.setHb2Name8(thb1DownVO.getHb1KKNameKJ());
        }

        thb2KmeiVO.setHb2Name9(" ");
        thb2KmeiVO.setHb2Name10(" ");
        //スペース２
        thb2KmeiVO.setHb2Name11(thb1DownVO.getSpace2());
        thb2KmeiVO.setHb2Kngk1(thb1DownVO.getHb1SeiTnka());
        thb2KmeiVO.setHb2Kngk2(toBigDecimal("0"));
        thb2KmeiVO.setHb2Kngk3(toBigDecimal("0"));
        thb2KmeiVO.setHb2Ritu1(toBigDecimal("0"));
        thb2KmeiVO.setHb2Ritu2(toBigDecimal("0"));
        thb2KmeiVO.setHb2Sonota1(" ");
        thb2KmeiVO.setHb2Sonota2(" ");
        thb2KmeiVO.setHb2Sonota3(" ");
        thb2KmeiVO.setHb2Sonota4(" ");
        thb2KmeiVO.setHb2Sonota5(" ");
        thb2KmeiVO.setHb2Sonota6(" ");
        thb2KmeiVO.setHb2Sonota7(" ");
        thb2KmeiVO.setHb2Sonota8(" ");
        thb2KmeiVO.setHb2Sonota9(" ");
        thb2KmeiVO.setHb2Sonota10(" ");
        thb2KmeiVO.setHb2BunFlg(" ");
        thb2KmeiVO.setHb2MeihnFlg(" ");
        thb2KmeiVO.setHb2NebhnFlg(" ");
    }

    /**
     * ダウンロードデータの編集
     *
     * @param bulkDataRegisterVO 一括登録処理用VO
     * @param thb1DownVO ダウンロードデータVO
     */
    private void editThb1DownVO(BulkDataRegisterVO bulkDataRegisterVO, Thb1DownVO thb1DownVO) {
        thb1DownVO.setHb1UpdApl(bulkDataRegisterVO.getAplId());
        thb1DownVO.setHb1UpdTnt(bulkDataRegisterVO.getEsqId());
        thb1DownVO.setHb1MSeiFlg("0");
    }

    /**
     * StringからBigDecimalに変換
     *
     * @param str 変換前文字列
     * @return 変換後数値
     */
    private BigDecimal toBigDecimal(String str) {

        // 未設定の場合
        if (StringUtil.isBlank(str)) {
            return null;
        }

        return new BigDecimal(str);
    }

}

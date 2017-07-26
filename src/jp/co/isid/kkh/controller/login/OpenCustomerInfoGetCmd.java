package jp.co.isid.kkh.controller.login;

import java.util.ArrayList;
import java.util.List;

import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.model.login.OpenCustomerInfoCondition;
import jp.co.isid.kkh.model.login.OpenCustomerInfoManager;
import jp.co.isid.kkh.model.login.OpenCustomerInfoResult;
import jp.co.isid.kkh.model.login.ThbcKhtCondition;
import jp.co.isid.kkh.model.login.ThbcKhtVO;
import jp.co.isid.kkh.service.base.ErrorInfo;
import jp.co.isid.kkh.util.StringUtil;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * 開放得意先情報取得コマンド
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/02/13 JSE H.Abe)<BR>
 * </P>
 *
 * @author JSE H.Abe
 */
public class OpenCustomerInfoGetCmd extends Command {

    private static final long serialVersionUID = 1L;

    /** 検索結果キー */
    private static final String RESULT_KEY = "RESULT_KEY";

    /** 検索条件 */
    private OpenCustomerInfoCondition _condition;

    /**
     * 検索条件を使用し、検索処理を実行します。
     *
     * @throws KKHException 検索に失敗した場合
     */
    public void execute() throws KKHException {

        // 入力チェック
        checkInput();
        // 開放得意先情報取得
        ThbcKhtVO thbcKhtVO = getOpenCustomerInfo();
        if (thbcKhtVO == null) {
            OpenCustomerInfoResult result = setResultErr("開放得意先情報取得エラー", "HB-W0108");
            getResult().set(RESULT_KEY, result);
            return;
        }
        // 返却値設定
        OpenCustomerInfoResult result = setResult(thbcKhtVO);
        getResult().set(RESULT_KEY, result);
    }

    /**
     * 検索条件を設定します。
     *
     * @param condition 検索条件
     */
    public void setOpenCustomerInfoCondition(OpenCustomerInfoCondition condition) {
        _condition = condition;
    }

    /**
     * 検索結果を返します。
     *
     * @return 検索結果
     */
    public OpenCustomerInfoResult getOpenCustomerInfoResult() {
        return (OpenCustomerInfoResult) super.getResult().get(RESULT_KEY);
    }

    /**
     * パラメータ入力チェック
     *
     * @throws KKHException パラメータ指定エラーの場合
     */
    private void checkInput() throws KKHException {

        if (StringUtil.isBlank(_condition.getEsqId())) {
            throw new KKHException("パラメータ指定エラー", "HB-E0017");
        }
        if (StringUtil.isBlank(_condition.getEgCd())) {
            throw new KKHException("パラメータ指定エラー", "HB-E0017");
        }
        if (StringUtil.isBlank(_condition.getTksKgyCd())) {
            throw new KKHException("パラメータ指定エラー", "HB-E0017");
        }
        if (StringUtil.isBlank(_condition.getTksBmnSeqNo())) {
            throw new KKHException("パラメータ指定エラー", "HB-E0017");
        }
        if (StringUtil.isBlank(_condition.getTksTntSeqNo())) {
            throw new KKHException("パラメータ指定エラー", "HB-E0017");
        }
    }

    /**
     * 開放得意先情報取得
     *
     * @return 開放得意先情報VO
     * @throws KKHException 処理中にエラーが発生した場合
     */
    private ThbcKhtVO getOpenCustomerInfo() throws KKHException {

        ThbcKhtCondition cond = new ThbcKhtCondition();
        cond.setEgCd(_condition.getEgCd());
        cond.setKgyCd(_condition.getTksKgyCd());
        cond.setBmnSeqNo(_condition.getTksBmnSeqNo());
        cond.setTntSeqNo(_condition.getTksTntSeqNo());
        OpenCustomerInfoManager manager = OpenCustomerInfoManager.getInstance();
        return manager.getOpenCustomerInfo(cond);
    }

    /**
     * 返却値設定
     *
     * @param thbcKhtVO 開放得意先情報VO
     * @return 開放得意先情報取得結果
     */
    private OpenCustomerInfoResult setResult(ThbcKhtVO thbcKhtVO) {

        OpenCustomerInfoResult result = new OpenCustomerInfoResult();
        result.setDisFlg(thbcKhtVO.getDisFlg());
        return result;
    }

    /**
     * 返却値設定（エラー）
     *
     * @param message メッセージ
     * @param errorID エラーコード
     * @return 開放得意先情報取得結果（エラー）
     */
    private OpenCustomerInfoResult setResultErr(String message, String errorID) {

        OpenCustomerInfoResult result = new OpenCustomerInfoResult();
        ErrorInfo errorInfo = new ErrorInfo();
        errorInfo.setError(true);
        errorInfo.setErrorCode(errorID);
        List<String> list = new ArrayList<String>();
        list.add(message);
        errorInfo.setNote(list);
        result.setErrorInfo(errorInfo);
        return result;
    }

}

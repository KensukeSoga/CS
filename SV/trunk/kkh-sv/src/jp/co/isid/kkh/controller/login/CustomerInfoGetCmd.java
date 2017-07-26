package jp.co.isid.kkh.controller.login;

import java.util.ArrayList;
import java.util.List;

import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.model.login.CustomerInfoCondition;
import jp.co.isid.kkh.model.login.CustomerInfoManager;
import jp.co.isid.kkh.model.login.CustomerInfoResult;
import jp.co.isid.kkh.model.login.RcmnMeu12ThskgyCondition;
import jp.co.isid.kkh.model.login.RcmnMeu12ThskgyVO;
import jp.co.isid.kkh.model.login.ThbdSpUsCondition;
import jp.co.isid.kkh.model.login.ThbdSpUsVO;
import jp.co.isid.kkh.service.base.ErrorInfo;
import jp.co.isid.kkh.util.StringUtil;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * 得意先情報取得コマンド
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/02/13 JSE H.Abe)<BR>
 * </P>
 *
 * @author JSE H.Abe
 */
public class CustomerInfoGetCmd extends Command {

    private static final long serialVersionUID = 1L;

    /** 検索結果キー */
    private static final String RESULT_KEY = "RESULT_KEY";

    /** 検索条件 */
    private CustomerInfoCondition _condition;

    /**
     * 検索条件を使用し、検索処理を実行します。
     *
     * @throws KKHException 検索に失敗した場合
     */
    public void execute() throws KKHException {

        // 入力チェック
        checkInput();
        // 得意先情報取得
        RcmnMeu12ThskgyVO rcmnMeu12ThskgyVO = getCustomerInfo();

        // 得意先情報が０件の場合
        if (rcmnMeu12ThskgyVO == null) {
            // 特別ユーザー情報取得
            ThbdSpUsVO thbdSpUsVO = getSpecialUserInfo();
            // 特別ユーザー情報が０件の場合
            if (thbdSpUsVO == null) {
                CustomerInfoResult result = setResultErr("得意先情報取得エラー", "HB-W0103");
                getResult().set(RESULT_KEY, result);
            // 特別ユーザー情報が取得できた場合
            } else {
                CustomerInfoResult result = setResult(thbdSpUsVO.getTksKgyNm(), thbdSpUsVO.getTksBmnNm());
                getResult().set(RESULT_KEY, result);
            }
        // 得意先情報が取得できた場合
        } else {
            CustomerInfoResult result = setResult(rcmnMeu12ThskgyVO.getThskgyDispKj(), rcmnMeu12ThskgyVO.getSubMei());
            getResult().set(RESULT_KEY, result);
        }
    }

    /**
     * 検索条件を設定します。
     *
     * @param condition 検索条件
     */
    public void setCustomerInfoCondition(CustomerInfoCondition condition) {
        _condition = condition;
    }

    /**
     * 検索結果を返します。
     *
     * @return 検索結果
     */
    public CustomerInfoResult getCustomerInfoResult() {
        return (CustomerInfoResult) super.getResult().get(RESULT_KEY);
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
        if (StringUtil.isBlank(_condition.getCustomerCode())) {
            throw new KKHException("得意先情報取得エラー", "HB-W0103");
            //throw new KKHException("パラメータ指定エラー", "HB-E0017");
        }
    }

    /**
     * 得意先情報取得
     *
     * @return 得意先情報VO
     * @throws KKHException 処理中にエラーが発生した場合
     */
    private RcmnMeu12ThskgyVO getCustomerInfo() throws KKHException {

        RcmnMeu12ThskgyCondition cond = new RcmnMeu12ThskgyCondition();
        cond.setTksKgyCd(_condition.getCustomerCode().substring(0, 6));
        cond.setTksBmnSeqNo(_condition.getCustomerCode().substring(6, 8));
        CustomerInfoManager manager = CustomerInfoManager.getInstance();
        return manager.getCustomerInfo(cond);
    }

    /**
     * 特別ユーザー情報取得
     *
     * @return 特別ユーザー情報VO
     * @throws KKHException 処理中にエラーが発生した場合
     */
    private ThbdSpUsVO getSpecialUserInfo() throws KKHException {

        ThbdSpUsCondition cond = new ThbdSpUsCondition();
        cond.setTksKgyCd(_condition.getCustomerCode().substring(0, 6));
        cond.setTksBmnSeqNo(_condition.getCustomerCode().substring(6, 8));
        CustomerInfoManager manager = CustomerInfoManager.getInstance();
        return manager.getSpecialUserInfo(cond);
    }

    /**
     * 返却値設定
     *
     * @param tksKgyNm 得意先企業名
     * @param tksBmnNm 得意先部門名
     * @return 得意先情報取得結果
     */
    private CustomerInfoResult setResult(String tksKgyNm, String tksBmnNm) {

        CustomerInfoResult result = new CustomerInfoResult();
        result.setCustomerName(tksKgyNm + System.getProperty("line.separator") + tksBmnNm);
        return result;
    }

    /**
     * 返却値設定（エラー）
     *
     * @param message メッセージ
     * @param errorID エラーコード
     * @return 得意先情報取得結果（エラー）
     */
    private CustomerInfoResult setResultErr(String message, String errorID) {

        CustomerInfoResult result = new CustomerInfoResult();
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

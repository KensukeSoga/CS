package jp.co.isid.kkh.controller.login;

import java.util.ArrayList;
import java.util.List;

import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.model.common.AccountOperationStatusCondition;
import jp.co.isid.kkh.model.common.AccountOperationStatusManager;
import jp.co.isid.kkh.model.common.EigyoBiCondition;
import jp.co.isid.kkh.model.common.EigyoBiManager;
import jp.co.isid.kkh.model.common.EigyoBiResult;
import jp.co.isid.kkh.model.login.LoginInitInfoCondition;
import jp.co.isid.kkh.model.login.LoginInitInfoManager;
import jp.co.isid.kkh.model.login.LoginInitInfoResult;
import jp.co.isid.kkh.model.login.Vkj01AccuserCondition;
import jp.co.isid.kkh.model.login.Vkj01AccuserVO;
import jp.co.isid.kkh.service.base.ErrorInfo;
import jp.co.isid.kkh.util.StringUtil;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * ログイン初期情報取得コマンド
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/02/13 JSE H.Abe)<BR>
 * </P>
 *
 * @author JSE H.Abe
 */
public class LoginInitInfoGetCmd extends Command {

    private static final long serialVersionUID = 1L;

    /** 検索結果キー */
    private static final String RESULT_KEY = "RESULT_KEY";

    /** 検索条件 */
    private LoginInitInfoCondition _condition;

    /**
     * 検索条件を使用し、検索処理を実行します。
     *
     * @throws KKHException 検索に失敗した場合
     */
    public void execute() throws KKHException {

        // 入力チェック
        checkInput();
        // ホスト営業日取得
        String eigyoBi = getEigyoBi();
        if (eigyoBi == null) {
            LoginInitInfoResult result = setResultErr("営業日取得エラー", "HB-W0101");
            getResult().set(RESULT_KEY, result);
            return;
        }

        // 個人情報取得
        Vkj01AccuserVO vkj01AccuserVO = getPersonalInfo();
        if (vkj01AccuserVO == null) {
            LoginInitInfoResult result = setResultErr("個人情報取得エラー", "HB-W0102");
            getResult().set(RESULT_KEY, result);
            return;
        }

        // 業務会計稼働状況チェック
        boolean accountOperationStatus = checkAccountOperationStatus();
        // 返却値設定
        LoginInitInfoResult result = setResult(eigyoBi, vkj01AccuserVO, accountOperationStatus);
        getResult().set(RESULT_KEY, result);
    }

    /**
     * 検索条件を設定します。
     *
     * @param condition 検索条件
     */
    public void setPersonalInfoCondition(LoginInitInfoCondition condition) {
        _condition = condition;
    }

    /**
     * 検索結果を返します。
     *
     * @return 検索結果
     */
    public LoginInitInfoResult getPersonalInfoResult() {
        return (LoginInitInfoResult) super.getResult().get(RESULT_KEY);
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
        if (StringUtil.isBlank(_condition.getOperationNo())) {
            throw new KKHException("パラメータ指定エラー", "HB-E0017");
        }
    }

    /**
     * ホスト営業日取得
     *
     * @return ホスト営業日
     * @throws KKHException 処理中にエラーが発生した場合
     */
    private String getEigyoBi() throws KKHException {

        EigyoBiCondition cond = new EigyoBiCondition();
        cond.setEsqId(_condition.getEsqId());
        EigyoBiManager manager = EigyoBiManager.getInstance();
        EigyoBiResult result = manager.getEigyoBi(cond);
        return result.getEigyoBi();
    }

    /**
     * 個人情報取得
     *
     * @return 個人情報VO
     * @throws KKHException 処理中にエラーが発生した場合
     */
    private Vkj01AccuserVO getPersonalInfo() throws KKHException {

        Vkj01AccuserCondition cond = new Vkj01AccuserCondition();
        cond.setEsqId(_condition.getEsqId());
        cond.setOperationNo(_condition.getOperationNo());
        LoginInitInfoManager manager = LoginInitInfoManager.getInstance();
        return manager.getPersonalInfo(cond);
    }

    /**
     * 業務会計稼働状況チェック
     *
     * @return true：稼働中、false：停止中
     * @throws KKHException 処理中にエラーが発生した場合
     */
    private boolean checkAccountOperationStatus() throws KKHException {

        AccountOperationStatusCondition cond = new AccountOperationStatusCondition();
        cond.setEsqId(_condition.getEsqId());
        AccountOperationStatusManager manager = AccountOperationStatusManager.getInstance();
        return manager.checkAccountOperationStatus(cond);
    }

    /**
     * 返却値設定
     *
     * @param eigyoBi ホスト営業日
     * @param vkj01AccuserVO 個人情報VO
     * @param accountOperationStatus 業務会計稼働状況
     * @return 個人情報取得結果
     */
    private LoginInitInfoResult setResult(String eigyoBi, Vkj01AccuserVO vkj01AccuserVO, boolean accountOperationStatus) {

        LoginInitInfoResult result = new LoginInitInfoResult();
        result.setEigyoBi(eigyoBi);
        result.setAccountOperationStatus(accountOperationStatus);
        result.setOrganizationCode(vkj01AccuserVO.getOgnzuntCd());

        return result;
    }

    /**
     * 返却値設定（エラー）
     *
     * @param message メッセージ
     * @param errorID エラーコード
     * @return 個人情報取得結果（エラー）
     */
    private LoginInitInfoResult setResultErr(String message, String errorID) {

        LoginInitInfoResult result = new LoginInitInfoResult();
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

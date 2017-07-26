package jp.co.isid.kkh.controller.login;

import java.util.List;

import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.model.common.CommonCondition;
import jp.co.isid.kkh.model.common.CommonManager;
import jp.co.isid.kkh.model.common.CommonResult;
import jp.co.isid.kkh.model.common.CommonVO;
import jp.co.isid.kkh.model.login.AccountSecurityRoleCondition;
import jp.co.isid.kkh.model.login.AccountSecurityRoleManager;
import jp.co.isid.kkh.model.login.AccountSecurityRoleResult;
import jp.co.isid.kkh.util.StringUtil;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * 業務会計セキュリティロール取得コマンド
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/02/13 JSE H.Abe)<BR>
 * </P>
 *
 * @author JSE H.Abe
 */
public class AccountSecurityRoleGetCmd extends Command {

    private static final long serialVersionUID = 1L;

    /** 営業所（取）コード：業務会計セキュリティロール取得対象外ESQID */
    private static final String EGCD_NOT_SUBJECT_ESQID = "99";

    /** 得意先企業コード：業務会計セキュリティロール取得対象外ESQID */
    private static final String TKSKGYCD_NOT_SUBJECT_ESQID = "999999";

    /** 得意先部門SEQNO：業務会計セキュリティロール取得対象外ESQID */
    private static final String TKSBMNSEQNO_NOT_SUBJECT_ESQID = "99";

    /** 得意先担当SEQNO：業務会計セキュリティロール取得対象外ESQID */
    private static final String TKSTNTSEQNO_NOT_SUBJECT_ESQID = "99";

    /** 種別：業務会計セキュリティロール取得対象外ESQID */
    private static final String SYBT_NOT_SUBJECT_ESQID = "006";

    /** 検索結果キー */
    private static final String RESULT_KEY = "RESULT_KEY";

    /** 検索条件 */
    private AccountSecurityRoleCondition _condition;

    /**
     * 検索条件を使用し、検索処理を実行します。
     *
     * @throws KKHException 検索に失敗した場合
     */
    public void execute() throws KKHException {

        // 入力チェック
        checkInput();
        // 対象外ユーザーチェック
        if (checkNotSubjectUser() == true){
            getResult().set(RESULT_KEY, setResult(null, true));
            return;
        }
        // 業務会計セキュリティロール（相対権限）取得
        AccountSecurityRoleManager manager = AccountSecurityRoleManager.getInstance();
        String relativeAuthority = manager.getAccountSecurityRole(_condition);
        // 返却値設定
        getResult().set(RESULT_KEY, setResult(relativeAuthority, false));
    }

    /**
     * 検索条件を設定します。
     *
     * @param condition 検索条件
     */
    public void setAccountSecurityRoleCondition(AccountSecurityRoleCondition condition) {
        _condition = condition;
    }

    /**
     * 検索結果を返します。
     *
     * @return 検索結果
     */
    public AccountSecurityRoleResult getAccountSecurityRoleResult() {
        return (AccountSecurityRoleResult) super.getResult().get(RESULT_KEY);
    }

    /**
     * パラメータ入力チェック
     *
     * @throws KKHException パラメータ指定エラーの場合
     */
    private void checkInput() throws KKHException {

        if (StringUtil.isBlank(_condition.getAplId())) {
            throw new KKHException("パラメータ指定エラー", "HB-E0017");
        }
        if (StringUtil.isBlank(_condition.getEsqId())) {
            throw new KKHException("パラメータ指定エラー", "HB-E0017");
        }
        if (StringUtil.isBlank(_condition.getPassword())) {
            throw new KKHException("パラメータ指定エラー", "HB-E0017");
        }
        if (_condition.getSecurityInfo() == null) {
            throw new KKHException("パラメータ指定エラー", "HB-E0017");
        }
    }

    /**
     * 対象外ユーザーチェック
     *
     * @return 対象外ユーザー：true、その他：false
     * @throws KKHException 処理中にエラーが発生した場合
     */
    private boolean checkNotSubjectUser() throws KKHException {

        CommonCondition cond = new CommonCondition();
        cond.setEsqId(_condition.getEsqId());
        cond.setEgCd(EGCD_NOT_SUBJECT_ESQID);
        cond.setTksKgyCd(TKSKGYCD_NOT_SUBJECT_ESQID);
        cond.setTksBmnSeqNo(TKSBMNSEQNO_NOT_SUBJECT_ESQID);
        cond.setTksTntSeqNo(TKSTNTSEQNO_NOT_SUBJECT_ESQID);
        cond.setSybt(SYBT_NOT_SUBJECT_ESQID);
        cond.setfield1(_condition.getEsqId());
        CommonManager manager = CommonManager.getInstance();
        CommonResult result = manager.findCommonByCondition(cond);
        List<CommonVO> list = result.getCommon();
        // データがない場合
        if (list.size() == 0) {
            return false;
        }
        return true;
    }

    /**
     * 返却値設定
     *
     * @param relativeAuthority 相対権限
     * @param notSecurityRoleFlag セキュリティロール取得対象外フラグ
     * @return 業務会計セキュリティロール取得結果
     */
    private AccountSecurityRoleResult setResult(String relativeAuthority, boolean notSecurityRoleFlag) {

        AccountSecurityRoleResult result = new AccountSecurityRoleResult();
        result.setRelativeAuthority(relativeAuthority);
        result.setNotSecurityRoleFlag(notSecurityRoleFlag);
        return result;
    }

}

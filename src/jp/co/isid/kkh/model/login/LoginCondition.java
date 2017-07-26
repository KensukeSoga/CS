package jp.co.isid.kkh.model.login;

import java.io.Serializable;

public class LoginCondition implements Serializable {

    private static final long serialVersionUID = 1L;

    /** ログイン担当者ESQID */
    private String _esqId = null;

    /** 運用No. */
    private String _operationNo = null;

    /** ユーザーID */
    private String _userId = null;

    /** パスワード */
    private String _password = null;

    /** 得意先コード */
    private String _customerCode = null;

    /** 通常ユーザーフラグ */
    private String _normalUserFlag = null;

    /** 相対権限 */
    private String _relativeAuthority = null;

    /** 担当者所属組織コード */
    private String _organizationCode = null;

    /** ホスト営業日 */
    private String _eigyoBi = null;

    /**
     * ログイン担当者ESQIDを取得する
     * @return ログイン担当者ESQID
     */
    public String getEsqId() {
        return _esqId;
    }

    /**
     * ログイン担当者ESQIDを設定する
     * @param esqId ログイン担当者ESQID
     */
    public void setEsqId(String esqId) {
        this._esqId = esqId;
    }

    /**
     * 運用No.を取得する
     * @return 運用No.
     */
    public String getOperationNo() {
        return _operationNo;
    }

    /**
     * 運用No.を設定する
     * @param operationNo 運用No.
     */
    public void setOperationNo(String operationNo) {
        this._operationNo = operationNo;
    }

    /**
     * ユーザーIDを取得する
     * @return ユーザーID
     */
    public String getUserId() {
        return _userId;
    }

    /**
     * ユーザーIDを設定する
     * @param userId ユーザーID
     */
    public void setUserId(String userId) {
        this._userId = userId;
    }

    /**
     * パスワードを取得する
     * @return パスワード
     */
    public String getPassword() {
        return _password;
    }

    /**
     * パスワードを設定する
     * @param password パスワード
     */
    public void setPassword(String password) {
        this._password = password;
    }

    /**
     * 得意先コードを取得する
     * @return 得意先コード
     */
    public String getCustomerCode() {
        return _customerCode;
    }

    /**
     * 得意先コードを設定する
     * @param customerCode 得意先コード
     */
    public void setCustomerCode(String customerCode) {
        this._customerCode = customerCode;
    }

    /**
     * 通常ユーザーフラグを取得する
     * @return 通常ユーザーフラグ
     */
    public String getNormalUserFlag() {
        return _normalUserFlag;
    }

    /**
     * 通常ユーザーフラグを設定する
     * @param normalUserFlag 通常ユーザーフラグ
     */
    public void setNormalUserFlag(String normalUserFlag) {
        this._normalUserFlag = normalUserFlag;
    }

    /**
     * 相対権限を取得する
     * @return 相対権限
     */
    public String getRelativeAuthority() {
        return _relativeAuthority;
    }

    /**
     * 相対権限を設定する
     * @param relativeAuthority 相対権限
     */
    public void setRelativeAuthority(String relativeAuthority) {
        this._relativeAuthority = relativeAuthority;
    }

    /**
     * 担当者所属組織コードを取得する
     * @return 担当者所属組織コード
     */
    public String getOrganizationCode() {
        return _organizationCode;
    }

    /**
     * 担当者所属組織コードを設定する
     * @param organizationCode 担当者所属組織コード
     */
    public void setOrganizationCode(String organizationCode) {
        this._organizationCode = organizationCode;
    }

    /**
     * ホスト営業日を取得する
     * @return ホスト営業日
     */
    public String getEigyoBi() {
        return _eigyoBi;
    }

    /**
     * ホスト営業日を設定する
     * @param eigyoBi ホスト営業日
     */
    public void setEigyoBi(String eigyoBi) {
        this._eigyoBi = eigyoBi;
    }

}

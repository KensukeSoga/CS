package jp.co.isid.kkh.model.login;

import java.io.Serializable;

public class Tcm01KkhCondition implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 上位組織コード */
    private String _higherOrganizationCode = null;

    /** 運用No. */
    private String _operationNo = null;

    /** 職位グループコード（複数） */
    private String _groupCd = null;

    /** 担当者コード */
    private String _tntCd = null;

    /** 得意先コード */
    private String _customerCode = null;

    /** ホスト営業日 */
    private String _eigyoBi = null;

    /** 期首 */
    private String _termBegin = null;

    /** 期末 */
    private String _termEnd = null;

    /**
     * 上位組織コードを取得する
     * @return 上位組織コード
     */
    public String getHigherOrganizationCode() {
        return _higherOrganizationCode;
    }

    /**
     * 上位組織コードを設定する
     * @param higherOrganizationCode 上位組織コード
     */
    public void setHigherOrganizationCode(String higherOrganizationCode) {
        this._higherOrganizationCode = higherOrganizationCode;
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
     * 職位グループコード（複数）を取得する
     * @return 職位グループコード（複数）
     */
    public String getGroupCd() {
        return _groupCd;
    }

    /**
     * 職位グループコード（複数）を設定する
     * @param groupCd 職位グループコード（複数）
     */
    public void setGroupCd(String groupCd) {
        this._groupCd = groupCd;
    }

    /**
     * 担当者コードを取得する
     * @return 担当者コード
     */
    public String getTntCd() {
        return _tntCd;
    }

    /**
     * 担当者コードを設定する
     * @param tntCd 担当者コード
     */
    public void setTntCd(String tntCd) {
        this._tntCd = tntCd;
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

    /**
     * 期首を取得する
     * @return 期首
     */
    public String getTermBegin() {
        return _termBegin;
    }

    /**
     * 期首を設定する
     * @param termBegin 期首
     */
    public void setTermBegin(String termBegin) {
        this._termBegin = termBegin;
    }

    /**
     * 期末を取得する
     * @return 期末
     */
    public String getTermEnd() {
        return _termEnd;
    }

    /**
     * 期末を設定する
     * @param termEnd 期末
     */
    public void setTermEnd(String termEnd) {
        this._termEnd = termEnd;
    }

}

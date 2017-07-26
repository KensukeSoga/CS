package jp.co.isid.kkh.model.login;

import java.io.Serializable;

public class CustomerInfoCondition implements Serializable {

    private static final long serialVersionUID = 1L;

    /** ログイン担当者ESQID */
    private String _esqId = null;

    /** 得意先コード */
    private String _customerCode = null;

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

}

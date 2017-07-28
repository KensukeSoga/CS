package jp.co.isid.kkh.model.login;

import java.io.Serializable;

public class LoginInitInfoCondition implements Serializable {

    private static final long serialVersionUID = 1L;

    /** ログイン担当者ESQID */
    private String _esqId = null;

    /** 運用No. */
    private String _operationNo = null;

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

}

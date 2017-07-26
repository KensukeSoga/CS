package jp.co.isid.kkh.model.login;

import java.io.Serializable;

public class RcmnMeu00SikCondition implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 運用No. */
    private String _operationNo = null;

    /** ホスト営業日 */
    private String _eigyoBi = null;

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

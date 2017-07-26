package jp.co.isid.kkh.model.common;

import java.io.Serializable;

public class CommonCondition implements Serializable {

    private static final long serialVersionUID = 1L;

    /** ログイン担当者ESQID */
    private String _esqId;
    /** 営業所（取）コード(必須) */
    private String _egCd;
    /** 得意先企業コード(必須) */
    private String _tksKgyCd;
    /** 得意先部門SEQNO(必須) */
    private String _tksBmnSeqNo;
    /** 得意先担当SEQNO(必須) */
    private String _tksTntSeqNo;
    /** マスタ種別  */
    private String _sybt;
    /** マスタ種別 */
    private String _field1;

    /**
     * @return esqId
     */
    public String getEsqId() {
        return _esqId;
    }

    /**
     * @param esqId セットする esqId
     */
    public void setEsqId(String esqId) {
        this._esqId = esqId;
    }

    /**
     * @return egCd
     */
    public String getEgCd() {
        return _egCd;
    }

    /**
     * @param egCd セットする egCd
     */
    public void setEgCd(String egCd) {
        this._egCd = egCd;
    }

    /**
     * @return tksKgyCd
     */
    public String getTksKgyCd() {
        return _tksKgyCd;
    }

    /**
     * @param tksKgyCd セットする tksKgyCd
     */
    public void setTksKgyCd(String tksKgyCd) {
        this._tksKgyCd = tksKgyCd;
    }

    /**
     * @return tksBmnSeqNo
     */
    public String getTksBmnSeqNo() {
        return _tksBmnSeqNo;
    }

    /**
     * @param tksBmnSeqNo セットする tksBmnSeqNo
     */
    public void setTksBmnSeqNo(String tksBmnSeqNo) {
        this._tksBmnSeqNo = tksBmnSeqNo;
    }

    /**
     * @return tksTntSeqNo
     */
    public String getTksTntSeqNo() {
        return _tksTntSeqNo;
    }

    /**
     * @param tksTntSeqNo セットする tksTntSeqNo
     */
    public void setTksTntSeqNo(String tksTntSeqNo) {
        this._tksTntSeqNo = tksTntSeqNo;
    }

    /**
     * @return sybt
     */
    public String getSybt() {
        return _sybt;
    }

    /**
     * @param sybt セットする sybt
     */
    public void setSybt(String sybt) {
        this._sybt = sybt;
    }

    /**
     * @return field1
     */
    public String getfield1() {
        return _field1;
    }

    /**
     * @param field1 セットする field1
     */
    public void setfield1(String field1) {
        this._field1 = field1;
    }

}

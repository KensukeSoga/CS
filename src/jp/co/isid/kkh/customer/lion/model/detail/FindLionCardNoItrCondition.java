package jp.co.isid.kkh.customer.lion.model.detail;

import java.io.Serializable;

public class FindLionCardNoItrCondition implements Serializable {

    private static final long serialVersionUID = 1L;

    /** ログイン担当者ESQID */
    private String _esqId;
    /** 営業所（取）コード(必須) */
    private String _egCd;
    /** 得意先企業コード(必須) */
    private String _tksKgyCd;
    /** 得意先部門SEQNO(必須) */
    private String _tksbmnseqno;
    /** 得意先担当SEQNO(必須) */
    private String _tkstntseqno;
    /** 種別 */
    private String _sybt;
    /** コード */
    private String _field1;
    /** 名称 */
    private String _field2;
    /** カードNO */
    private String _code;

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
     * @return tksbmnseqno
     */
    public String getTksBmnSeqNo() {
        return _tksbmnseqno;
    }

    /**
     * @param tksbmnseqno セットする tksbmnseqno
     */
    public void setTksBmnSeqNo(String tksbmnseqno) {
        this._tksbmnseqno = tksbmnseqno;
    }

    /**
     * @return tkstntseqno
     */
    public String getTksTntSeqNo() {
        return _tkstntseqno;
    }

    /**
     * @param tkstntseqno セットする tkstntseqno
     */
    public void setTksTntSeqNo(String tkstntseqno) {
        this._tkstntseqno = tkstntseqno;
    }

    /**
     * @return sybt
     */
    public String getSybt() {
        return _sybt;
    }

    /**
     * @param kyokucd セットする sybt
     */
    public void setSybt(String sybt) {
        this._sybt = sybt;
    }

    /**
     * @return field1
     */
    public String getField1() {
        return _field1;
    }

    /**
     * @param field1 セットする field1
     */
    public void setField1(String field1) {
        this._field1 = field1;
    }

    /**
     * @return field2
     */
    public String getField2() {
        return _field2;
    }

    /**
     * @param field2 セットする field2
     */
    public void setField2(String field2) {
        this._field2 = field2;
    }

    /**
     * @return code
     */
    public String getCode() {
        return _code;
    }

    /**
     * @param code セットする code
     */
    public void setCode(String code) {
        this._code = code;
    }

}
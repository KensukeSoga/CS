package jp.co.isid.kkh.customer.lion.model.detail;

import java.io.Serializable;

public class FindLionCodeItrCondition implements Serializable {

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
    /** 種別*/
    private String _cdNo;
    /** 媒体コード*/
    private String _btCd;

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
     * @return cdNo
     */
    public String getCdNo() {
        return _cdNo;
    }

    /**
     * @param cdNo セットする cdNo
     */
    public void setCdNo(String cdNo) {
        this._cdNo = cdNo;
    }

    /**
     * @return btCd
     */
    public String getBtCd() {
        return _btCd;
    }

    /**
     * @param btCd セットする btCd
     */
    public void setBtCd(String btCd) {
        this._btCd = btCd;
    }

}
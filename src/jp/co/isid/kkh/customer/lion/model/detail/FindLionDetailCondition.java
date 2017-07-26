package jp.co.isid.kkh.customer.lion.model.detail;

import java.io.Serializable;

public class FindLionDetailCondition implements Serializable {

    private static final long serialVersionUID = 1L;

    /** ログイン担当者ESQID */
    private String _esqId;
    /** 営業所（取）コード(必須) */
    private String _egCd;
    /** 得意先企業コード(必須) */
    private String _tksKgyCd;
    /** 得意先部門コード(必須) */
    private String _bmncd;
    /** 得意先担当コード(必須) */
    private String _tntcd;
    /** 年月 */
    private String _yymm;
    /** 受注NO */
    private String _jyutno;
    /** 受注明細NO */
    private String _jymeino;
    /** 売上明細NO */
    private String _urmeino;
    /** 媒体区分 */
    private String _code1;
    /** カードNO */
    private String _code6;

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
     * @return bmncd
     */
    public String getBmncd() {
        return _bmncd;
    }

    /**
     * @param bmncd セットする bmncd
     */
    public void setBmncd(String bmncd) {
        this._bmncd = bmncd;
    }

    /**
     * @return tntcd
     */
    public String getTntcd() {
        return _tntcd;
    }

    /**
     * @param tntcd セットする tntcd
     */
    public void setTntcd(String tntcd) {
        this._tntcd = tntcd;
    }

    /**
     * @return Yymm
     */
    public String getYymm() {
        return _yymm;
    }

    /**
     * @param Yymm セットする Yymm
     */
    public void setYymm(String yymm) {
        this._yymm = yymm;
    }

    /**
     * @return Jyutno
     */
    public String getJyutno() {
        return _jyutno;
    }

    /**
     * @param Jyutno セットする Jyutno
     */
    public void setJyutno(String jyutno) {
        this._jyutno = jyutno;
    }

    /**
     * @return Jymeino
     */
    public String getJymeino() {
        return _jymeino;
    }

    /**
     * @param Jymeino セットする Jymeino
     */
    public void setJymeino(String jymeino) {
        this._jymeino = jymeino;
    }

    /**
     * @return urmeino
     */
    public String getUrmeino() {
        return _urmeino;
    }

    /**
     * @param urmeino セットする tiurmeinoku
     */
    public void setUrmeino(String urmeino) {
        this._urmeino = urmeino;
    }

    /**
     * @return code1
     */
    public String getCode1() {
        return _code1;
    }

    /**
     * @param code1 セットする code1
     */
    public void setCode1(String code1) {
        this._code1 = code1;
    }

    /**
     * @return code6
     */
    public String getCode6() {
        return _code6;
    }

    /**
     * @param code6 セットする code6
     */
    public void setCode6(String code6) {
        this._code6 = code6;
    }

}
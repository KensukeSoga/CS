package jp.co.isid.kkh.model.common;

import java.io.Serializable;

public class CommonCodeMasterCondition implements Serializable {

    private static final long serialVersionUID = 1L;

    /** ログイン担当者ESQID */
    private String _esqId;
    /** KYCDKND */
    private String _kyCdKnd;
    /** 基準日 */
    private String _kijyunYmd;

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
     * @return _kyCdKnd
     */
    public String getKyCdKnd() {
        return _kyCdKnd;
    }

    /**
     * @param kyCdKnd セットする _kyCdKnd
     */
    public void setKyCdKnd(String kyCdKnd) {
        _kyCdKnd = kyCdKnd;
    }

    /**
     * @return _kijyunYmd
     */
    public String getKijyunYmd() {
        return _kijyunYmd;
    }

    /**
     * @param kijyunYmd セットする _kijyunYmd
     */
    public void setKijyunYmd(String kijyunYmd) {
        _kijyunYmd = kijyunYmd;
    }

}

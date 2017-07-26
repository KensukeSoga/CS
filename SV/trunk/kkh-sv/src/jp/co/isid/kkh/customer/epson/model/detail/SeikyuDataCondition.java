package jp.co.isid.kkh.customer.epson.model.detail;

import java.io.Serializable;

/**
*
* <P>
* 請求回収データ検索(Epson)SeikyuCondition
* </P>
* <P>
* <B>修正履歴</B><BR>
* ・新規作成(2012/04/23 JSE.Yuguchi)<BR>
* </P>
* @author
*/

public class SeikyuDataCondition implements Serializable {

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
    /** 年月*/
    private String _yymm;

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

}

package jp.co.isid.kkh.customer.mac.model.report;

import jp.co.isid.kkh.model.AbstractServiceCondition;

public class ReportMacPurchaseCondition extends AbstractServiceCondition {

    private static final long serialVersionUID = 1L;

    /** 明細行フラグ */
    private String _splitflg;
    /** 再印刷フラグ */
    private String _reflg;
    /** テリトリー */
    private String _territory;
    /** 店舗コード */
    private String _tenpocd;
    /** 伝票番号FROM */
    private String _denfr;
    /** 伝票番号TO */
    private String _dento;

    /**
     * @return reflg
     */
    public String getreflg() {
        return _reflg;
    }

    /**
     * @param reflg セットする reflg
     */
    public void setreflg(String reflg) {
        this._reflg = reflg;
    }

    /**
     * @return splitflg
     */
    public String getsplitflg() {
        return _splitflg;
    }

    /**
     * @param splitflg セットする splitflg
     */
    public void setsplitflg(String splitflg) {
        this._splitflg = splitflg;
    }

    /**
     * @return Territory
     */
    public String getterritory() {
        return _territory;
    }

    /**
     * @param Territory セットする Territory
     */
    public void setterritory(String territory) {
        this._territory = territory;
    }

    /**
     * @return tenpocd
     */
    public String gettenpocd() {
        return _tenpocd;
    }

    /**
     * @param splitflg セットする splitflg
     */
    public void settenpocd(String tenpocd) {
        this._tenpocd = tenpocd;
    }

    /**
     * @return kbn
     */
    public String getdenfr() {
        return _denfr;
    }

    /**
     * @param denfr セットする denfr
     */
    public void setdenfr(String denfr) {
        this._denfr = denfr;
    }

    /**
     * @return getdento
     */
    public String getdento() {
        return _dento;
    }

    /**
     * @param _dento セットする _dento
     */
    public void setdento(String dento) {
        this._dento = dento;
    }

}

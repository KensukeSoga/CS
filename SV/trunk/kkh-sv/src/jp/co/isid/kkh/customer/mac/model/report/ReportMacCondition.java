package jp.co.isid.kkh.customer.mac.model.report;

import jp.co.isid.kkh.model.AbstractServiceCondition;

public class ReportMacCondition extends AbstractServiceCondition {

    private static final long serialVersionUID = 1L;

    /** ì`ï[î‘çÜFROM*/
    private String _denfr;
    /** ì`ï[î‘çÜTO*/
    private String _dento;

    /**
     * @return kbn
     */
    public String getdenfr() {
        return _denfr;
    }
    /**
     * @param denfr ÉZÉbÉgÇ∑ÇÈ denfr
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
     * @param _dento ÉZÉbÉgÇ∑ÇÈ _dento
     */
    public void setdento(String dento) {
        this._dento = dento;
    }

}

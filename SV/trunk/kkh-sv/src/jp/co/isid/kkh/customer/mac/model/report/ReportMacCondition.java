package jp.co.isid.kkh.customer.mac.model.report;

import jp.co.isid.kkh.model.AbstractServiceCondition;

public class ReportMacCondition extends AbstractServiceCondition {

    private static final long serialVersionUID = 1L;

    /** �`�[�ԍ�FROM*/
    private String _denfr;
    /** �`�[�ԍ�TO*/
    private String _dento;

    /**
     * @return kbn
     */
    public String getdenfr() {
        return _denfr;
    }
    /**
     * @param denfr �Z�b�g���� denfr
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
     * @param _dento �Z�b�g���� _dento
     */
    public void setdento(String dento) {
        this._dento = dento;
    }

}

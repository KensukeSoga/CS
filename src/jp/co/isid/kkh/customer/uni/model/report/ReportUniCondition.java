package jp.co.isid.kkh.customer.uni.model.report;

import jp.co.isid.kkh.model.AbstractServiceCondition;

public class ReportUniCondition extends AbstractServiceCondition {

    private static final long serialVersionUID = 1L;

    /** ’ •[‹æ•ª */
    private String _repKbn;
    private String _Busho = null;

    /**
     * ’ •[‹æ•ª‚ğ•Ô‚µ‚Ü‚·B
     *
     * @return repKbn
     */
    public String getRepKbn() {
        return _repKbn;
    }

    /**
     * ’ •[‹æ•ª‚ğİ’è‚µ‚Ü‚·B
     *
     * @param repKbn
     */
    public void setRepKbn(String repKbn) {
        this._repKbn = repKbn;
    }

    /**
     * •”‚ğ•Ô‚µ‚Ü‚·B
     *
     * @return Busho
     */
    public String getBusho() {
        return _Busho;
    }

    /**
     * •”‚ğİ’è‚µ‚Ü‚·B
     *
     * @param Busho
     */
    public void setBusho(String Busho) {
        this._Busho = Busho;
    }

}

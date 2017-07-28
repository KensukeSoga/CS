package jp.co.isid.kkh.customer.mac.model.report;

import jp.co.isid.kkh.model.AbstractServiceCondition;

public class ReportMacRequestCondition extends AbstractServiceCondition {

    private static final long serialVersionUID = 1L;

    /** Äˆóüƒtƒ‰ƒO */
    private String _reflg;
    /** “X•Ü‹æ•ª */
    private String _tenpoKbn;
    /** “X•ÜƒR[ƒh */
    private String _tenpocd;
    /** “`•[”Ô†FROM */
    private String _denfr;
    /** “`•[”Ô†TO */
    private String _dento;

    /**
     * Äˆóüƒtƒ‰ƒO‚ğæ“¾‚·‚é
     * @return String Äˆóüƒtƒ‰ƒO
     */
    public String getreflg() {
        return _reflg;
    }

    /**
     * Äˆóüƒtƒ‰ƒO‚ğİ’è‚·‚é
     * @param reflg String Äˆóüƒtƒ‰ƒO
     */
    public void setreflg(String reflg) {
        this._reflg = reflg;
    }

    /**
     * “X•Ü‹æ•ª‚ğæ“¾‚·‚é
     * @return String “X•Ü‹æ•ª
     */
    public String gettenpoKbn() {
        return _tenpoKbn;
    }

    /**
     * “X•Ü‹æ•ª‚ğİ’è‚·‚é
     * @param tenpoKbn String “X•Ü‹æ•ª
     */
    public void settenpoKbn(String tenpoKbn) {
        this._tenpoKbn = tenpoKbn;
    }

    /**
     * “X•ÜƒR[ƒh‚ğæ“¾‚·‚é
     * @return String “X•ÜƒR[ƒh
     */
    public String gettenpocd() {
        return _tenpocd;
    }

    /**
     * “X•ÜƒR[ƒh‚ğİ’è‚·‚é
     * @param splitflg String “X•ÜƒR[ƒh
     */
    public void settenpocd(String tenpocd) {
        this._tenpocd = tenpocd;
    }

    /**
     * “`•[”Ô†FROM‚ğæ“¾‚·‚é
     * @return String “`•[”Ô†FROM
     */
    public String getdenfr() {
        return _denfr;
    }

    /**
     * “`•[”Ô†FROM‚ğİ’è‚·‚é
     * @param denfr String “`•[”Ô†FROM
     */
    public void setdenfr(String denfr) {
        this._denfr = denfr;
    }

    /**
     * “`•[”Ô†TO‚ğæ“¾‚·‚é
     * @return String “`•[”Ô†TO
     */
    public String getdento() {
        return _dento;
    }

    /**
     * “`•[”Ô†TO‚ğİ’è‚·‚é
     * @param _dento String “`•[”Ô†TO
     */
    public void setdento(String dento) {
        this._dento = dento;
    }

}

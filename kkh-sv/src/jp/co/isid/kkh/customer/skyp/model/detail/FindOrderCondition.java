package jp.co.isid.kkh.customer.skyp.model.detail;

import jp.co.isid.kkh.model.AbstractServiceCondition;

public class FindOrderCondition extends AbstractServiceCondition {

    private static final long serialVersionUID = 1L;

    /** ”}‘Ì‹æ•ª */
     private String _baitaikbn;

     /**
     * ”}‘Ì‹æ•ª‚ğ•Ô‚µ‚Ü‚·B
     *
     * @return esqId
     */
    public String getbaitaikbn() {
        return _baitaikbn;
    }
    /**
     * ”}‘Ì‹æ•ª‚ğİ’è‚µ‚Ü‚·B
     *
     * @param esqId
     */
    public void setbaitaikbn(String baitaikbn) {
        this._baitaikbn = baitaikbn;
    }

}

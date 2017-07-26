package jp.co.isid.kkh.customer.lion.model.detail;

import jp.co.isid.kkh.model.AbstractServiceCondition;

public class FindLionCardNoGetCondition extends AbstractServiceCondition {

    private static final long serialVersionUID = 1L;

    /** ó’NO */
    private String _jyutno;
    /** ó’–¾×NO */
    private String _jymeino;
    /** ”„ã–¾×NO */
    private String _urmeino;

    /**
     * ó’NO‚ğæ“¾‚·‚é
     * @return String ó’NO
     */
    public String getJyutno() {
        return _jyutno;
    }

    /**
     * ó’NO‚ğİ’è‚·‚é
     * @param Jyutno String ó’NO
     */
    public void setJyutno(String jyutno) {
        this._jyutno = jyutno;
    }

    /**
     * ó’–¾×NO‚ğæ“¾‚·‚é
     * @return String ó’–¾×NO
     */
    public String getJymeino() {
        return _jymeino;
    }

    /**
     * ó’–¾×NO‚ğİ’è‚·‚é
     * @param Jymeino String ó’–¾×NO
     */
    public void setJymeino(String jymeino) {
        this._jymeino = jymeino;
    }

    /**
     * ”„ã–¾×NO‚ğæ“¾‚·‚é
     * @return String ”„ã–¾×NO
     */
    public String getUrmeino() {
        return _urmeino;
    }

    /**
     * ”„ã–¾×NO‚ğİ’è‚·‚é
     * @param urmeino String ”„ã–¾×NO
     */
    public void setUrmeino(String urmeino) {
        this._urmeino = urmeino;
    }

}
package jp.co.isid.kkh.customer.acom.model.detail;

import jp.co.isid.kkh.model.AbstractServiceCondition;

public class FindMeisaiDataCondition extends AbstractServiceCondition {

    private static final long serialVersionUID = 1L;

    /** ó’No */
    private String _jyutNo = null;

    /** ó’–¾×No */
    private String _jyMeiNo = null;

    /** ”„ã–¾×No */
    private String _urMeiNo = null;

    /**
     * ó’No‚ğæ“¾‚·‚é
     * @return ó’No
     */
    public String getJyutNo() {
        return _jyutNo;
    }

    /**
     * ó’No‚ğİ’è‚·‚é
     * @param jyutNo ó’No
     */
    public void setJyutNo(String jyutNo) {
        this._jyutNo = jyutNo;
    }

    /**
     * ó’–¾×No‚ğæ“¾‚·‚é
     * @return ó’–¾×No
     */
    public String getJyMeiNo() {
        return _jyMeiNo;
    }

    /**
     * ó’–¾×No‚ğİ’è‚·‚é
     * @param jyMeiNo ó’–¾×No
     */
    public void setJyMeiNo(String jyMeiNo) {
        this._jyMeiNo = jyMeiNo;
    }

    /**
     * ”„ã–¾×No‚ğæ“¾‚·‚é
     * @return ”„ã–¾×No
     */
    public String getUrMeiNo() {
        return _urMeiNo;
    }

    /**
     * ”„ã–¾×No‚ğİ’è‚·‚é
     * @param urMeiNo ”„ã–¾×No
     */
    public void setUrMeiNo(String urMeiNo) {
        this._urMeiNo = urMeiNo;
    }

}

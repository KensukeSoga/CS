package jp.co.isid.kkh.customer.tkd.model.detail;

import jp.co.isid.kkh.model.AbstractServiceCondition;

public class FindJissiNoCntCondition extends AbstractServiceCondition {

    private static final long serialVersionUID = 1L;

    /** ��No */
    private String _jyutNo;
    /** �󒍖���No */
    private String _jyMeiNo;
    /** ���㖾��No */
    private String _urMeiNo;
    /** ���{No */
    private String _jissiNo;

    /**
     * ��No��Ԃ��܂��B
     *
     * @return jyutNo
     */
    public String getJyutNo() {
        return _jyutNo;
    }

    /**
     * ��No��ݒ肵�܂��B
     *
     * @param jyutNo
     */
    public void setJyutNo(String jyutNo) {
        this._jyutNo = jyutNo;
    }

    /**
     * �󒍖���No��Ԃ��܂��B
     *
     * @return jyMeiNo
     */
    public String getJyMeiNo() {
        return _jyMeiNo;
    }

    /**
     * �󒍖���No��ݒ肵�܂��B
     *
     * @param jyMeiNo
     */
    public void setJyMeiNo(String jyMeiNo) {
        this._jyMeiNo = jyMeiNo;
    }

    /**
     * ���㖾��No��ݒ肵�܂��B
     *
     * @return urMeiNo
     */
    public String getUrMeiNo() {
        return _urMeiNo;
    }

    /**
     * ���㖾��No��Ԃ��܂��B
     *
     * @param urMeiNo
     */
    public void setUrMeiNo(String urMeiNo) {
        this._urMeiNo = urMeiNo;
    }

    /**
     * ���{No��ݒ肵�܂��B
     *
     * @return jissiNo
     */
    public String getJissiNo() {
        return _jissiNo;
    }

    /**
     * ���{No��Ԃ��܂��B
     *
     * @param jissiNo
     */
    public void setJissiNo(String jissiNo) {
        this._jissiNo = jissiNo;
    }

}

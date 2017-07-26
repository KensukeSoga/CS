package jp.co.isid.kkh.customer.tkd.model.detail;

import jp.co.isid.kkh.model.AbstractServiceCondition;

public class FindJissiNoCntCondition extends AbstractServiceCondition {

    private static final long serialVersionUID = 1L;

    /** 受注No */
    private String _jyutNo;
    /** 受注明細No */
    private String _jyMeiNo;
    /** 売上明細No */
    private String _urMeiNo;
    /** 実施No */
    private String _jissiNo;

    /**
     * 受注Noを返します。
     *
     * @return jyutNo
     */
    public String getJyutNo() {
        return _jyutNo;
    }

    /**
     * 受注Noを設定します。
     *
     * @param jyutNo
     */
    public void setJyutNo(String jyutNo) {
        this._jyutNo = jyutNo;
    }

    /**
     * 受注明細Noを返します。
     *
     * @return jyMeiNo
     */
    public String getJyMeiNo() {
        return _jyMeiNo;
    }

    /**
     * 受注明細Noを設定します。
     *
     * @param jyMeiNo
     */
    public void setJyMeiNo(String jyMeiNo) {
        this._jyMeiNo = jyMeiNo;
    }

    /**
     * 売上明細Noを設定します。
     *
     * @return urMeiNo
     */
    public String getUrMeiNo() {
        return _urMeiNo;
    }

    /**
     * 売上明細Noを返します。
     *
     * @param urMeiNo
     */
    public void setUrMeiNo(String urMeiNo) {
        this._urMeiNo = urMeiNo;
    }

    /**
     * 実施Noを設定します。
     *
     * @return jissiNo
     */
    public String getJissiNo() {
        return _jissiNo;
    }

    /**
     * 実施Noを返します。
     *
     * @param jissiNo
     */
    public void setJissiNo(String jissiNo) {
        this._jissiNo = jissiNo;
    }

}

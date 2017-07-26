package jp.co.isid.kkh.customer.kmn.model.report;

import jp.co.isid.kkh.model.AbstractServiceCondition;

public class ReportKmnCondition extends AbstractServiceCondition {

    private static final long serialVersionUID = 1L;

    /** 請求先部門 */
    private String _Bumon = null;
    /** 出力No */
    private String _OutputNo = null;

    /**
     * 請求先部門を返します。
     *
     * @return Bumon
     */
    public String getBumon() {
        return _Bumon;
    }

    /**
     * 請求先部門を設定します。
     *
     * @param Bumon
     */
    public void setBumon(String Bumon) {
        this._Bumon = Bumon;
    }

    /**
     * 出力Noを返します。
     *
     * @return OutputNo
     */
    public String getOutputNo() {
        return _OutputNo;
    }

    /**
     * 出力Noを設定します。
     *
     * @param OutputNo
     */
    public void setOutputNo(String OutputNo) {
        this._OutputNo = OutputNo;
    }

}

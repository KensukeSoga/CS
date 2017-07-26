package jp.co.isid.kkh.customer.mac.model.report;

import jp.co.isid.kkh.model.AbstractServiceCondition;

public class ReportMacSchklstCondition extends AbstractServiceCondition {

    private static final long serialVersionUID = 1L;

    /** 店舗コード */
    private String _code1;
    /** 店舗検索orデータ検索 */
    private String _tordflg;

    /**
     * @return kbn
     */
    public String getcode1() {
        return _code1;
    }

    /**
     * @param code1 セットする code1
     */
    public void setcode1(String code1) {
        this._code1 = code1;
    }

    /**
     * @return _tordflg
     */
    public String gettordflg() {
        return _tordflg;
    }

    /**
     * @param _tordflg セットする _tordflg
     */
    public void settordflg(String tordflg) {
        this._tordflg = tordflg;
    }

}

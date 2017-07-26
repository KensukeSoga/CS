package jp.co.isid.kkh.customer.toh.model.report;

import jp.co.isid.kkh.model.AbstractServiceCondition;

public class ReportTohCondition extends AbstractServiceCondition {

    private static final long serialVersionUID = 1L;

    /** 納品区分*/
    private String _kbn;
    /** 件名媒体区分*/
    private String _kenbaikbn;

    /**
     * @return kbn
     */
    public String getKbn() {
        return _kbn;
    }

    /**
     * @param ym セットする kbn
     */
    public void setKbn(String kbn) {
        this._kbn = kbn;
    }

    /**
     * @return kenbaikbn
     */
    public String getKenbaikbn() {
        return _kenbaikbn;
    }

    /**
     * @param ym セットする kenbaikbn
     */
    public void setKenbaikbn(String kenbaikbn) {
        this._kenbaikbn = kenbaikbn;
    }

}

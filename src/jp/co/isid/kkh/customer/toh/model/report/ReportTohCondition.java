package jp.co.isid.kkh.customer.toh.model.report;

import jp.co.isid.kkh.model.AbstractServiceCondition;

public class ReportTohCondition extends AbstractServiceCondition {

    private static final long serialVersionUID = 1L;

    /** �[�i�敪*/
    private String _kbn;
    /** �����}�̋敪*/
    private String _kenbaikbn;

    /**
     * @return kbn
     */
    public String getKbn() {
        return _kbn;
    }

    /**
     * @param ym �Z�b�g���� kbn
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
     * @param ym �Z�b�g���� kenbaikbn
     */
    public void setKenbaikbn(String kenbaikbn) {
        this._kenbaikbn = kenbaikbn;
    }

}

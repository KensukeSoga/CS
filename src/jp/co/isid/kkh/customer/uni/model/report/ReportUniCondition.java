package jp.co.isid.kkh.customer.uni.model.report;

import jp.co.isid.kkh.model.AbstractServiceCondition;

public class ReportUniCondition extends AbstractServiceCondition {

    private static final long serialVersionUID = 1L;

    /** ���[�敪 */
    private String _repKbn;
    private String _Busho = null;

    /**
     * ���[�敪��Ԃ��܂��B
     *
     * @return repKbn
     */
    public String getRepKbn() {
        return _repKbn;
    }

    /**
     * ���[�敪��ݒ肵�܂��B
     *
     * @param repKbn
     */
    public void setRepKbn(String repKbn) {
        this._repKbn = repKbn;
    }

    /**
     * ������Ԃ��܂��B
     *
     * @return Busho
     */
    public String getBusho() {
        return _Busho;
    }

    /**
     * ������ݒ肵�܂��B
     *
     * @param Busho
     */
    public void setBusho(String Busho) {
        this._Busho = Busho;
    }

}

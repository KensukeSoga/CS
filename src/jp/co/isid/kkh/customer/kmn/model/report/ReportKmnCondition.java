package jp.co.isid.kkh.customer.kmn.model.report;

import jp.co.isid.kkh.model.AbstractServiceCondition;

public class ReportKmnCondition extends AbstractServiceCondition {

    private static final long serialVersionUID = 1L;

    /** �����敔�� */
    private String _Bumon = null;
    /** �o��No */
    private String _OutputNo = null;

    /**
     * �����敔���Ԃ��܂��B
     *
     * @return Bumon
     */
    public String getBumon() {
        return _Bumon;
    }

    /**
     * �����敔���ݒ肵�܂��B
     *
     * @param Bumon
     */
    public void setBumon(String Bumon) {
        this._Bumon = Bumon;
    }

    /**
     * �o��No��Ԃ��܂��B
     *
     * @return OutputNo
     */
    public String getOutputNo() {
        return _OutputNo;
    }

    /**
     * �o��No��ݒ肵�܂��B
     *
     * @param OutputNo
     */
    public void setOutputNo(String OutputNo) {
        this._OutputNo = OutputNo;
    }

}

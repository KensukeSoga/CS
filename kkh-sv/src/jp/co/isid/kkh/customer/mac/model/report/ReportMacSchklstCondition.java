package jp.co.isid.kkh.customer.mac.model.report;

import jp.co.isid.kkh.model.AbstractServiceCondition;

public class ReportMacSchklstCondition extends AbstractServiceCondition {

    private static final long serialVersionUID = 1L;

    /** �X�܃R�[�h */
    private String _code1;
    /** �X�܌���or�f�[�^���� */
    private String _tordflg;

    /**
     * @return kbn
     */
    public String getcode1() {
        return _code1;
    }

    /**
     * @param code1 �Z�b�g���� code1
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
     * @param _tordflg �Z�b�g���� _tordflg
     */
    public void settordflg(String tordflg) {
        this._tordflg = tordflg;
    }

}

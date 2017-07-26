package jp.co.isid.kkh.customer.mac.model.report;

import jp.co.isid.kkh.model.AbstractServiceCondition;

public class ReportMacPurchaseCondition extends AbstractServiceCondition {

    private static final long serialVersionUID = 1L;

    /** ���׍s�t���O */
    private String _splitflg;
    /** �Ĉ���t���O */
    private String _reflg;
    /** �e���g���[ */
    private String _territory;
    /** �X�܃R�[�h */
    private String _tenpocd;
    /** �`�[�ԍ�FROM */
    private String _denfr;
    /** �`�[�ԍ�TO */
    private String _dento;

    /**
     * @return reflg
     */
    public String getreflg() {
        return _reflg;
    }

    /**
     * @param reflg �Z�b�g���� reflg
     */
    public void setreflg(String reflg) {
        this._reflg = reflg;
    }

    /**
     * @return splitflg
     */
    public String getsplitflg() {
        return _splitflg;
    }

    /**
     * @param splitflg �Z�b�g���� splitflg
     */
    public void setsplitflg(String splitflg) {
        this._splitflg = splitflg;
    }

    /**
     * @return Territory
     */
    public String getterritory() {
        return _territory;
    }

    /**
     * @param Territory �Z�b�g���� Territory
     */
    public void setterritory(String territory) {
        this._territory = territory;
    }

    /**
     * @return tenpocd
     */
    public String gettenpocd() {
        return _tenpocd;
    }

    /**
     * @param splitflg �Z�b�g���� splitflg
     */
    public void settenpocd(String tenpocd) {
        this._tenpocd = tenpocd;
    }

    /**
     * @return kbn
     */
    public String getdenfr() {
        return _denfr;
    }

    /**
     * @param denfr �Z�b�g���� denfr
     */
    public void setdenfr(String denfr) {
        this._denfr = denfr;
    }

    /**
     * @return getdento
     */
    public String getdento() {
        return _dento;
    }

    /**
     * @param _dento �Z�b�g���� _dento
     */
    public void setdento(String dento) {
        this._dento = dento;
    }

}

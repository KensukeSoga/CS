package jp.co.isid.kkh.customer.mac.model.report;

import jp.co.isid.kkh.model.AbstractServiceCondition;

public class ReportMacRequestCondition extends AbstractServiceCondition {

    private static final long serialVersionUID = 1L;

    /** �Ĉ���t���O */
    private String _reflg;
    /** �X�܋敪 */
    private String _tenpoKbn;
    /** �X�܃R�[�h */
    private String _tenpocd;
    /** �`�[�ԍ�FROM */
    private String _denfr;
    /** �`�[�ԍ�TO */
    private String _dento;

    /**
     * �Ĉ���t���O���擾����
     * @return String �Ĉ���t���O
     */
    public String getreflg() {
        return _reflg;
    }

    /**
     * �Ĉ���t���O��ݒ肷��
     * @param reflg String �Ĉ���t���O
     */
    public void setreflg(String reflg) {
        this._reflg = reflg;
    }

    /**
     * �X�܋敪���擾����
     * @return String �X�܋敪
     */
    public String gettenpoKbn() {
        return _tenpoKbn;
    }

    /**
     * �X�܋敪��ݒ肷��
     * @param tenpoKbn String �X�܋敪
     */
    public void settenpoKbn(String tenpoKbn) {
        this._tenpoKbn = tenpoKbn;
    }

    /**
     * �X�܃R�[�h���擾����
     * @return String �X�܃R�[�h
     */
    public String gettenpocd() {
        return _tenpocd;
    }

    /**
     * �X�܃R�[�h��ݒ肷��
     * @param splitflg String �X�܃R�[�h
     */
    public void settenpocd(String tenpocd) {
        this._tenpocd = tenpocd;
    }

    /**
     * �`�[�ԍ�FROM���擾����
     * @return String �`�[�ԍ�FROM
     */
    public String getdenfr() {
        return _denfr;
    }

    /**
     * �`�[�ԍ�FROM��ݒ肷��
     * @param denfr String �`�[�ԍ�FROM
     */
    public void setdenfr(String denfr) {
        this._denfr = denfr;
    }

    /**
     * �`�[�ԍ�TO���擾����
     * @return String �`�[�ԍ�TO
     */
    public String getdento() {
        return _dento;
    }

    /**
     * �`�[�ԍ�TO��ݒ肷��
     * @param _dento String �`�[�ԍ�TO
     */
    public void setdento(String dento) {
        this._dento = dento;
    }

}

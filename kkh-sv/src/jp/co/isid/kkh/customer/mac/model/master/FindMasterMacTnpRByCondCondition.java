package jp.co.isid.kkh.customer.mac.model.master;

import jp.co.isid.kkh.model.AbstractServiceCondition;

public class FindMasterMacTnpRByCondCondition extends AbstractServiceCondition {

    private static final long serialVersionUID = 1L;

    /** �X�܃R�[�h */
    private String _tenpoCd;
    /** �X�V���{�L�[ */
    private String _updRrkTimstmp;
    /** ��荞�ݍX�V�t���O */
    private String _torikomiFlg;
    /** ������� */
    private String _rrkSybt;

    /**
     * �X�܃R�[�h��Ԃ��܂��B
     *
     * @return tenpoCd
     */
    public String getTenpoCd() {
        return _tenpoCd;
    }

    /**
     * �X�܃R�[�h��ݒ肵�܂��B
     *
     * @param tenpoCd
     */
    public void setTenpoCd(String tenpoCd) {
        this._tenpoCd = tenpoCd;
    }

    /**
     * �X�V���{�L�[��Ԃ��܂��B
     *
     * @return updRrkTimstmp
     */
    public String getUpdRrkTimstmp() {
        return _updRrkTimstmp;
    }

    /**
     * �X�V���{�L�[��ݒ肵�܂��B
     *
     * @param updRrkTimstmp
     */
    public void setUpdRrkTimstmp(String updRrkTimstmp) {
        this._updRrkTimstmp = updRrkTimstmp;
    }

    /**
     * ��荞�ݍX�V�t���O��ݒ肵�܂��B
     *
     * @return torikomiFlg
     */
    public String getTorikomiFlg() {
        return _torikomiFlg;
    }

    /**
     * ��荞�ݍX�V�t���O��Ԃ��܂��B
     *
     * @param torikomiFlg
     */
    public void setTorikomiFlg(String torikomiFlg) {
        this._torikomiFlg = torikomiFlg;
    }

    /**
     * ������ʂ�ݒ肵�܂��B
     *
     * @return rrkSybt
     */
    public String getRrkSybt() {
        return _rrkSybt;
    }

    /**
     * ������ʂ�Ԃ��܂��B
     *
     * @param rrkSybt
     */
    public void setRrkSybt(String rrkSybt) {
        this._rrkSybt = rrkSybt;
    }

}

package jp.co.isid.kkh.customer.mac.model.master;

import jp.co.isid.kkh.model.AbstractServiceCondition;

public class FindMasterMacTnpRByCondCondition extends AbstractServiceCondition {

    private static final long serialVersionUID = 1L;

    /** 店舗コード */
    private String _tenpoCd;
    /** 更新実施キー */
    private String _updRrkTimstmp;
    /** 取り込み更新フラグ */
    private String _torikomiFlg;
    /** 履歴種別 */
    private String _rrkSybt;

    /**
     * 店舗コードを返します。
     *
     * @return tenpoCd
     */
    public String getTenpoCd() {
        return _tenpoCd;
    }

    /**
     * 店舗コードを設定します。
     *
     * @param tenpoCd
     */
    public void setTenpoCd(String tenpoCd) {
        this._tenpoCd = tenpoCd;
    }

    /**
     * 更新実施キーを返します。
     *
     * @return updRrkTimstmp
     */
    public String getUpdRrkTimstmp() {
        return _updRrkTimstmp;
    }

    /**
     * 更新実施キーを設定します。
     *
     * @param updRrkTimstmp
     */
    public void setUpdRrkTimstmp(String updRrkTimstmp) {
        this._updRrkTimstmp = updRrkTimstmp;
    }

    /**
     * 取り込み更新フラグを設定します。
     *
     * @return torikomiFlg
     */
    public String getTorikomiFlg() {
        return _torikomiFlg;
    }

    /**
     * 取り込み更新フラグを返します。
     *
     * @param torikomiFlg
     */
    public void setTorikomiFlg(String torikomiFlg) {
        this._torikomiFlg = torikomiFlg;
    }

    /**
     * 履歴種別を設定します。
     *
     * @return rrkSybt
     */
    public String getRrkSybt() {
        return _rrkSybt;
    }

    /**
     * 履歴種別を返します。
     *
     * @param rrkSybt
     */
    public void setRrkSybt(String rrkSybt) {
        this._rrkSybt = rrkSybt;
    }

}

package jp.co.isid.kkh.model.login;

import java.io.Serializable;

public class RcmnMeu07SikkrsprdCondition implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 上位組織コード */
    private String _higherOrganizationCode = null;

    /** 営業所コード */
    private String _egCd = null;

    /** ホスト営業日 */
    private String _eigyoBi = null;

    /**
     * 上位組織コードを取得する
     * @return 上位組織コード
     */
    public String getHigherOrganizationCode() {
        return _higherOrganizationCode;
    }

    /**
     * 上位組織コードを設定する
     * @param higherOrganizationCode 上位組織コード
     */
    public void setHigherOrganizationCode(String higherOrganizationCode) {
        this._higherOrganizationCode = higherOrganizationCode;
    }

    /**
     * 営業所コードを取得する
     * @return 営業所コード
     */
    public String getEgCd() {
        return _egCd;
    }

    /**
     * 営業所コードを設定する
     * @param egCd 営業所コード
     */
    public void setEgCd(String egCd) {
        this._egCd = egCd;
    }

    /**
     * ホスト営業日を取得する
     * @return ホスト営業日
     */
    public String getEigyoBi() {
        return _eigyoBi;
    }

    /**
     * ホスト営業日を設定する
     * @param eigyoBi ホスト営業日
     */
    public void setEigyoBi(String eigyoBi) {
        this._eigyoBi = eigyoBi;
    }

}

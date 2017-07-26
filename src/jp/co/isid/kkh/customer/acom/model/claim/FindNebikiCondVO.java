package jp.co.isid.kkh.customer.acom.model.claim;

import java.math.BigDecimal;

import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * 請求データ 一覧情報VO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/2/7 JSE Y.Sato)<BR>
 * </P>
 *
 * @author JSE Y.Sato
 */
public class FindNebikiCondVO extends AbstractModel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * 新規インスタンスを構築します。
     */
    public FindNebikiCondVO() {
    }

    /**
     * 新規インスタンスを構築します。
     *
     * @return 新規インスタンス
     */
    public Object newInstance() {
        return new FindNebikiCondVO();
    }

    /**
     * 値引申請NOを取得する
     * @return 値引申請NO
     */
    public String getSinseiNo() {
        return (String) get("MEU19_NBIKSINSEINO");
    }

    /**
     * 値引申請NOを設定する
     * @param val 値引申請NO
     */
    public void setSinseiNo(String val) {
        set("MEU19_NBIKSINSEINO", val);
    }

    /**
     * 業務区分を取得する
     * @return 業務区分
     */
    public String getGMkbnCd() {
        return (String) get("MEU1A_GYOMKBN");
    }

    /**
     * 業務区分を設定する
     * @param val 業務区分
     */
    public void setGMkbnCd(String val) {
        set("MEU1A_GYOMKBN", val);
    }

    /**
     * 媒体コードを取得する
     * @return 媒体コード
     */
    public String getBtCd() {
        return (String) get("MEU1A_BTAICD");
    }

    /**
     * 媒体コードを設定する
     * @param val 媒体コード
     */
    public void setBtCd(String val) {
        set("MEU1A_BTAICD", val);
    }

    /**
     * 費目区分を取得する
     * @return 費目区分
     */
    public String getHmCd() {
        return (String) get("MEU1A_HMOKCD");
    }

    /**
     * 費目区分を設定する
     * @param val 費目区分
     */
    public void setHmCd(String val) {
        set("MEU1A_HMOKCD", val);
    }

    /**
     * 値引率を取得する
     * @return 値引率
     */
    public BigDecimal getNebikiR() {
        return (BigDecimal) get("MEU1A_NBIKRITU");
    }

    /**
     * 値引率を設定する
     * @param val 値引率
     */
    public void setNebikiR(BigDecimal val) {
        set("MEU1A_NBIKRITU", val);
    }

}

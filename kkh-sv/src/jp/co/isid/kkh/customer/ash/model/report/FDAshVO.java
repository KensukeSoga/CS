package jp.co.isid.kkh.customer.ash.model.report;

import java.math.BigDecimal;





import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * 請求データ一覧VO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * </P>
 * @author
 */
public class FDAshVO extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /**
     * 新規インスタンスを構築します。
     */
    public FDAshVO() {
    }

    /**
     * 新規インスタンスを構築します。
     * @return 新規インスタンス
     */
    public Object newInstance() {
        return new FDAshVO();
    }

    /**
     * 請求書番号を取得する
     * @return 請求書番号
     */
    public String getSeikyuno() {
        return (String) get("SEIKYUNO");
    }

    /**
     * 請求書番号を設定する
     * @param val String 請求書番号
     */
    public void setSeikyuno(String val) {
        set("SEIKYUNO", val);
    }

    /**
     * 媒体コードを取得する
     * @return 媒体コード
     */
    public String getBaitaicd() {
        return (String) get("BAITAICD");
    }

    /**
     * 媒体コードを設定する
     * @param val String 媒体コード
     */
    public void setBaitaicd(String val) {
        set("BAITAICD", val);
    }

    /**
     * 請求金額（消費税あり）を取得する
     * @return 請求金額（消費税あり）
     */
    public BigDecimal getSeikyukinzeiari() {
        return (BigDecimal) get("SEIKYUKINZEIARI");
    }

    /**
     * 請求金額（消費税あり）を設定する
     * @param val BigDecimal 請求金額（消費税あり）
     */
    public void setSeikyukinzeiari(BigDecimal val) {
        set("SEIKYUKINZEIARI", val);
    }

    /**
     * 請求金額（消費税なし）を取得する
     * @return 請求金額（消費税なし）
     */
    public BigDecimal getSeikyukinzeinashi() {
        return (BigDecimal) get("SEIKYUKINZEINASHI");
    }

    /**
     * 請求金額（消費税なし）を設定する
     * @param val BigDecimal 請求金額（消費税なし）
     */
    public void setSeikyukinzeinashi(BigDecimal val) {
        set("SEIKYUKINZEINASHI", val);
    }

    /**
     * 局コードを取得する
     * @return 局コード
     */
    public String getKyokucd() {
        return (String) get("KYOKUCD");
    }

    /**
     * 局コードを設定する
     * @param val String 局コード
     */
    public void setKyokucd(String val) {
        set("KYOKUCD", val);
    }

    /**
     * 品種コードを取得する
     * @return 品種コード
     */
    public String getHinsyucd() {
        return (String) get("HINSYUCD");
    }

    /**
     * 品種コードを設定する
     * @param val String 品種コード
     */
    public void setHinsyucd(String val) {
        set("HINSYUCD", val);
    }

    /**
     * 代理店コードを取得する
     * @return 代理店コード
     */
    public String getDairitencd() {
        return (String) get("DAIRITENCD");
    }

    /**
     * 代理店コードを設定する
     * @param val String 代理店コード
     */
    public void setDairitencd(String val) {
        set("DAIRITENCD", val);
    }

    /**
     * 番組コードを取得する
     * @return 番組コード
     */
    public String getBangumicd() {
        return (String) get("BANGUMICD");
    }

    /**
     * 番組コードを設定する
     * @param val String 番組コード
     */
    public void setBangumicd(String val) {
        set("BANGUMICD", val);
    }

    /**
     * 件名を取得する
     * @return 件名
     */
    public String getKenmei() {
        return (String) get("KENMEI");
    }

    /**
     * 件名を設定する
     * @param val String 件名
     */
    public void setKenmei(String val) {
        set("KENMEI", val);
    }

    /**
     * 請求金額を取得する
     * @return 請求金額
     */
    public BigDecimal getSeikyukin() {
        return (BigDecimal) get("SEIKYUKIN");
    }

    /**
     * 請求金額を設定する
     * @param val BigDecimcal 請求金額
     */
    public void setSeikyukin(BigDecimal val) {
        set("SEIKYUKIN", val);
    }

    /**
     * 消費税率を取得する
     * @return 消費税率
     */
    public BigDecimal getShohizeiritu() {
        return (BigDecimal) get("SHOHIZEIRITU");
    }

    /**
     * 消費税率を設定する
     * @param val BigDecimal 消費税率
     */
    public void setShohizeiritu(BigDecimal val) {
        set("SHOHIZEIRITU", val);
    }

}
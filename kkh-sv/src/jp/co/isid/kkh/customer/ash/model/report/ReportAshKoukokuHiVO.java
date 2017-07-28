package jp.co.isid.kkh.customer.ash.model.report;

import java.math.BigDecimal;





import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * 広告費明細書（Ash）データVO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/2/13 fourm h.izawa)<BR>
 * </P>
 * @author
 */
public class ReportAshKoukokuHiVO extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /**
     * 新規インスタンスを構築します。
     */
    public ReportAshKoukokuHiVO() {
    }

    /**
     * 新規インスタンスを構築します。
     *
     * @return 新規インスタンス
     */
    public Object newInstance() {
        return new ReportAshKoukokuHiVO();
    }

    /**
     * 請求Noを設定します
     * @param val String 請求No
     */
    public void setSeikyuNo(String val) {
        set("SEIKYUNO", val);
    }

    /**
     * 請求Noを取得します
     * @return 請求No
     */
    public String getSeikyuNo() {
        return (String) get("SEIKYUNO");
    }

    /**
     * 媒体コードを設定します
     * @param val String 媒体コード
     */
    public void setBaitaiCD(String val) {
        set("BAITAICD", val);
    }

    /**
     * 媒体コードを取得します
     * @return 媒体コード
     */
    public String getBaitaiCD() {
        return (String) get("BAITAICD");
    }

    /**
     * 請求金額を設定します
     * @param val BigDecimal 請求金額
     */
    public void setSeikyukin(BigDecimal val) {
        set("SEIKYUKIN", val);
    }

    /**
     * 請求金額を取得します
     * @return 請求金額
     */
    public BigDecimal getSeikyukin() {
        return (BigDecimal) get("SEIKYUKIN");
    }

    /**
     * 局名を設定します
     * @param val String 局名
     */
    public void setKyokuNM(String val) {
        set("KYOKUNM", val);
    }

    /**
     * 局名を取得します
     * @return 局名
     */
    public String getKyokuNM() {
        return (String) get("KYOKUNM");
    }

    /**
     * 局コードを設定します
     * @param val String 局コード
     */
    public void setKyokuCD(String val) {
        set("KYOKUCD", val);
    }

    /**
     * 局コードを取得します
     * @return 局コード
     */
    public String getKyokuCD() {
        return (String) get("KYOKUCD");
    }

    /**
     * 品種名を設定します
     * @param val String 品種名
     */
    public void setHinsyuNM(String val) {
        set("HINSYUNM", val);
    }

    /**
     * 品種名を取得します
     * @return 品種名
     */
    public String getHinsyuNM() {
        return (String) get("HINSYUNM");
    }

    /**
     * 品種コードを設定します
     * @param val String 品種コード
     */
    public void setHinsyuCD(String val) {
        set("HINSYUCD", val);
    }

    /**
     * 品種コードを取得します
     * @return 品種コード
     */
    public String getHinsyuCD() {
        return (String) get("HINSYUCD");
    }

    /**
     * 代理店コードを設定します
     * @param val String 代理店コード
     */
    public void setDairitenCD(String val) {
        set("DAIRITENCD", val);
    }

    /**
     * 代理店コードを取得します
     * @return 代理店コード
     */
    public String getDairitenCD() {
        return (String) get("DAIRITENCD");
    }

    /**
     * 番組コードを設定します
     * @param val String 番組コード
     */
    public void setBangumiCD(String val) {
        set("BANGUMICD", val);
    }

    /**
     * 番組コードを取得します
     * @return 番組コード
     */
    public String getBangumiCD() {
        return (String) get("BANGUMICD");
    }

    /**
     * 件名を設定します
     * @param val String 件名
     */
    public void setKenmei(String val) {
        set("KENMEI", val);
    }

    /**
     * 件名を取得します
     * @return 件名
     */
    public String getKenmei() {
        return (String) get("KENMEI");
    }

    /**
     * 連番を設定します
     * @param val String 連番
     */
    public void setRENBN(String val) {
        set("RENBN", val);
    }

    /**
     * 連番を取得します
     * @return 連番
     */
    public String getRENBN() {
        return (String) get("RENBN");
    }

    /**
     * 受注NOを設定します
     * @param val String 受注NO
     */
    public void setJYUTNO(String val) {
        set("JYUTNO", val);
    }

    /**
     * 受注NOを取得します
     * @return 受注NO
     */
    public String getJYUTNO() {
        return (String) get("JYUTNO");
    }

    /**
     * 受注明細NOを設定します
     * @param val String 受注明細NO
     */
    public void setJYMEINO(String val) {
        set("JYMEINO", val);
    }

    /**
     * 受注明細NOを取得します
     * @return 受注明細NO
     */
    public String getJYMEINO() {
        return (String) get("JYMEINO");
    }

    /**
     * 売上明細NOを設定します
     * @param val String 売上明細NO
     */
    public void setURMEINO(String val) {
        set("URMEINO", val);
    }

    /**
     * 売上明細NOを取得します
     * @return 売上明細NO
     */
    public String getURMEINO() {
        return (String) get("URMEINO");
    }

    /**
     * キー局を設定します
     * @param val String キー局
     */
    public void setKeykyoku(String val) {
        set("KEYKYOKU", val);
    }

    /**
     * キー局を取得します
     * @return キー局
     */
    public String getKeykyoku() {
        return (String) get("KEYKYOKU");
    }

    /**
     * 雑誌コードを設定します
     * @param val String 雑誌コード
     */
    public void setCODE6(String val) {
        set("CODE6", val);
    }

    /**
     * 雑誌コードを取得します
     * @return 雑誌コード
     */
    public String getCODE6() {
        return (String) get("CODE6");
    }

    /**
     * 局略称を設定します
     * @param val String 局略称
     */
    public void setKyokuRyaku(String val) {
        set("KYOKURYAKU", val);
    }

    /**
     * 局略称を取得します
     * @return 局略称
     */
    public String getKyokuRyaku() {
        return (String) get("KYOKURYAKU");
    }

    /**
     * ソート番号を設定します
     * @param val String ソート番号
     */
    public void setSONOTA10(String val) {
        set("SONOTA10", val);
    }

    /**
     * ソート番号を取得します
     * @return ソート番号
     */
    public String getSONOTA10() {
        return (String) get("SONOTA10");
    }

}
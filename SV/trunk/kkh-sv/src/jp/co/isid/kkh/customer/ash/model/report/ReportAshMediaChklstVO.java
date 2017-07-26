package jp.co.isid.kkh.customer.ash.model.report;

import java.math.BigDecimal;





import jp.co.isid.kkh.integ.tbl.TBTHB2KMEI;
import jp.co.isid.kkh.integ.tbl.TBTHBAMST;
import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * 帳票（Ash)VO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/1/20 fourm h.izawa)<BR>
 * </P>
 * @author
 */
public class ReportAshMediaChklstVO extends AbstractModel {

    private static final long serialVersionUID = 7;

    /**
     * 新規インスタンスを構築します。
     */
    public ReportAshMediaChklstVO() {
    }

    /**
     * 新規インスタンスを構築します。
     *
     * @return 新規インスタンス
     */
    public Object newInstance() {
        return new ReportAshMediaChklstVO();
    }

    /**
     * 請求書番号を設定します。
     * @param val String SeikyuNo
     */
    public void setSeikyuNo(String val) {
        set("SEIKYUNO", val);
    }

    /**
     * 請求書番号を返します。
     * @return String SeikyuNo
     */
    public String getSeikyuNo() {
        return (String) get("SEIKYUNO");
    }

    /**
     * 媒体区分を設定します。
     * @param val String BaitaiKbn
     */
    public void setBaitaiKbn(String val) {
        set("BAITAIKBN", val);
    }

    /**
     * 媒体区分を返します。
     * @return String BaitaiKbn
     */
    public String getBaitaiKbn() {
        return (String) get("BAITAIKBN");
    }

    /**
     * 媒体コードを設定します。
     * @param val String BaitaiCD
     */
    public void setBaitaiCD(String val) {
        set("BAITAICD", val);
    }

    /**
     * 媒体コードを返します。
     * @return String BaitaiCD
     */
    public String getBaitaiCD() {
        return (String) get("BAITAICD");
    }

    /**
     * 請求金額を設定します。
     * @param val String SeikyukinKomi
     */
    public void setSeikyukinKomi(BigDecimal val) {
        set("SEIKYUKINKOMI", val);
    }

    /**
     * 請求金額を返します。
     * @return String SeikyukinKomi
     */
    public BigDecimal getSeikyukinKomi() {
        return (BigDecimal) get("SEIKYUKINKOMI");
    }

    /**
     * 請求金額を設定します。
     * @param val String Seikyukin
     */
    public void setSeikyukin(BigDecimal val) {
        set("SEIKYUKIN", val);
    }

    /**
     * 請求金額を返します。
     * @return String Seikyukin
     */
    public BigDecimal getSeikyukin() {
        return (BigDecimal) get("SEIKYUKIN");
    }

    /**
     * 局名を設定します。
     * @param val String KyokuNM
     */
    public void setKyokuNM(String val) {
        set("KYOKUNM", val);
    }

    /**
     * 局名を返します。
     * @return String KyokuNM
     */
    public String getKyokuNM() {
        return (String) get("KYOKUNM");
    }

    /**
     * 局コードを設定します。
     * @param val String KyokuCD
     */
    public void setKyokuCD(String val) {
        set("KYOKUCD", val);
    }

    /**
     * 局コードを返します。
     * @return String KyokuCD
     */
    public String getKyokuCD() {
        return (String) get("KYOKUCD");
    }

    /**
     * 局媒体コードを設定します。
     * @param val String KyokuBaitaiCd
     */
    public void setKyokuBaitaiCd(String val) {
        set("KYOKUBAITAICD", val);
    }

    /**
     * 局媒体コードを返します。
     * @return String KyokuBaitaiCd
     */
    public String getKyokuBaitaiCd() {
        return (String) get("KYOKUBAITAICD");
    }

    /**
     * 品種名を設定します。
     * @param val String HinsyuNM
     */
    public void setHinsyuNM(String val) {
        set("HINSYUNM", val);
    }

    /**
     * 品種名を返します。
     * @return String HinsyuNM
     */
    public String getHinsyuNM() {
        return (String) get("HINSYUNM");
    }

    /**
     * 品種コードを設定します。
     * @param val String HinsyuCD
     */
    public void setHinsyuCD(String val) {
        set("HINSYUCD", val);
    }

    /**
     * 品種コードを返します。
     * @return String HinsyuCD
     */
    public String getHinsyuCD() {
        return (String) get("HINSYUCD");
    }

    /**
     * 品種媒体コードを設定します。
     * @param val String HinsyuBaitaiCd
     */
    public void setHinsyuBaitaiCd(String val) {
        set("HINSYUBAITAICD", val);
    }

    /**
     * 品種媒体コードを返します。
     * @return String HinsyuBaitaiCd
     */
    public String getHinsyuBaitaiCd() {
        return (String) get("HINSYUBAITAICD");
    }

    /**
     * 代理店コードを設定します。
     * @param val String DairitenCD
     */
    public void setDairitenCD(String val) {
        set("DAIRITENCD", val);
    }

    /**
     * 代理店コードを返します。
     * @return String DairitenCD
     */
    public String getDairitenCD() {
        return (String) get("DAIRITENCD");
    }

    /**
     * 番組コードを設定します。
     * @param val String BangumiCD
     */
    public void setBangumiCD(String val) {
        set("BANGUMICD", val);
    }

    /**
     * 番組コードを返します。
     * @return String BangumiCD
     */
    public String getBangumiCD() {
        return (String) get("BANGUMICD");
    }
    /**
     * 件名を設定します。
     * @param val String Kenmei
     */
    public void setKenmei(String val) {
        set("KENMEI", val);
    }

    /**
     * 件名を返します。
     * @return String Kenmei
     */
    public String getKenmei() {
        return (String) get("KENMEI");
    }

    /**
     * 連番を設定します。
     * @param val String Renban
     */
    public void setRenbn(String val) {
        set(TBTHB2KMEI.RENBN, val);
    }

    /**
     * 連番を返します。
     * @return String Renban
     */
    public String getRenbn() {
        return (String) get(TBTHB2KMEI.RENBN);
    }

    /**
     * 受注Noを設定します。
     * @param val String JyutNo
     */
    public void setJyutNo(String val) {
        set(TBTHB2KMEI.JYUTNO, val);
    }

    /**
     * 受注Noを返します。
     * @return String JyutNo
     */
    public String getJyutNo() {
        return (String) get(TBTHB2KMEI.JYUTNO);
    }

    /**
     * 受注明細Noを設定します。
     * @param val String JyMeiNo
     */
    public void setJyMeiNo(String val) {
        set(TBTHB2KMEI.JYMEINO, val);
    }

    /**
     * 受注明細Noを返します。
     * @return String JyMeiNo
     */
    public String getJyMeiNo() {
        return (String) get(TBTHB2KMEI.JYMEINO);
    }

    /**
     * 売上明細Noを設定します。
     * @param val String UrMeiNo
     */
    public void setUrMeiNo(String val) {
        set(TBTHB2KMEI.URMEINO, val);
    }

    /**
     * 売上明細Noを返します。
     * @return String UrMeiNo
     */
    public String getUrMeiNo() {
        return (String) get(TBTHB2KMEI.URMEINO);
    }

    /**
     * 主局を設定します。
     * @param val String Keykyoku
     */
    public void setKeykyoku(String val) {
        set("KEYKYOKU", val);
    }

    /**
     * 主局を返します。
     * @return String Keykyoku
     */
    public String getKeykyoku() {
        return (String) get("KEYKYOKU");
    }

    /**
     * 雑誌ｺｰﾄﾞを設定します。
     * @param val String Code6
     */
    public void setCode6(String val) {
        set(TBTHB2KMEI.CODE6, val);
    }

    /**
     * 雑誌ｺｰﾄﾞを返します。
     * @return String Code6
     */
    public String getCode6() {
        return (String) get(TBTHB2KMEI.CODE6);
    }

    /**
     * 局略称を設定します。
     * @param val String KyokuRyaku
     */
    public void setKyokuRyaku(String val) {
        set("KYOKURYAKU", val);
    }

    /**
     * 局略称を返します。
     * @return String KyokuRyaku
     */
    public String getKyokuRyaku() {
        return (String) get("KYOKURYAKU");
    }
    /**
     * 順を設定します。
     * @param val String Sonota10
     */
    public void setSonota10(String val) {
        set(TBTHB2KMEI.SONOTA10 , val);
    }

    /**
     * 順を返します。
     * @return String Sonota10
     */
    public String getSonota10() {
        return (String) get(TBTHB2KMEI.SONOTA10);
    }

    /**
     * 税率を設定します。
     * @param val String Ritu1
     */
    public void setRitu1(BigDecimal val) {
        set(TBTHB2KMEI.RITU1 , val);
    }

    /**
     * 税率を返します。
     * @return String Ritu1
     */
    public BigDecimal getRitu1() {
        return (BigDecimal) get(TBTHB2KMEI.RITU1);
    }

    /**
     * アップロード愛媛対応。
     * @param val String Field6
     */
    public void setField6(String val) {
        set(TBTHBAMST.FIELD6 , val);
    }

    /**
     * アップロード愛媛対応
     * @return String Field6
     */
    public String getField6() {
        return (String) get(TBTHBAMST.FIELD6);
    }

}

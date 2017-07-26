package jp.co.isid.kkh.customer.uni.model.report;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlElement;

import jp.co.isid.nj.model.AbstractModel;


/**
 * <P>
 * 帳票（ユニチャーム_広告費明細表）データ返却用VO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/1/23 JSE Y.Sato)<BR>
 * </P>
 *
 * @author JSE Y.Sato
 */
public class ReportUniResultVO extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /**
     * 新規インスタンスを構築します。
     */
    public ReportUniResultVO() {
    }

    /**
     * 新規インスタンスを構築します。
     *
     * @return 新規インスタンス
     */
    public Object newInstance() {
        return new ReportUniResultVO();
    }

    /**
     * 請求原票Noを設定します。
     * @param val String 請求原票No
     */
    public void setGpyNo(String val) {
        set("GPYNO", val);
    }

    /**
     * 請求原票Noを返します。
     * @return String 請求原票No
     */
    public String getGpyNo() {
        return (String) get("GPYNO");
    }

    /**
     * 請求原票行Noを設定します。
     * @param val String 請求原票行No
     */
    public void setMGpyNo(String val) {
        set("MGPYNO", val);
    }

    /**
     * 請求原票行Noを返します。
     * @return String 請求原票行No
     */
    public String getMGpyNo() {
        return (String) get("MGPYNO");
    }

    /**
     * 受注No(受注No + "-" + 受注明細No + "-" + 売上明細No)を設定します。
     * @param val String 受注No(受注No + "-" + 受注明細No + "-" + 売上明細No)
     */
    public void setJutyuNo(String val) {
        set("JYUTYUNO", val);
    }

    /**
     * 受注No(受注No + "-" + 受注明細No + "-" + 売上明細No)を返します。
     * @return String 受注No(受注No + "-" + 受注明細No + "-" + 売上明細No)
     */
    public String getJutyuNo() {
        return (String) get("JYUTYUNO");
    }

    /**
     * 業務区分を設定します。
     * @param val String 業務区分
     */
    public void setGyomKbn(String val) {
        set("GYOMKBN", val);
    }

    /**
     * 業務区分を返します。
     * @return String 業務区分
     */
    public String getGyomKbn() {
        return (String) get("GYOMKBN");
    }

    /**
     * 業務区分名を設定します。
     * @param val String 業務区分名
     */
    public void setGyomKbnNm(String val) {
        set("GYOMKBNNM", val);
    }

    /**
     * 業務区分名を返します。
     * @return String 業務区分名
     */
    public String getGyomKbnNm() {
        return (String) get("GYOMKBNNM");
    }

    /**
     * 請求区分を設定します。
     * @param val String 請求区分
     */
    public void setSeiKbn(String val) {
        set("SEIKBN", val);
    }

    /**
     * 請求区分を返します。
     * @return String 請求区分
     */
    public String getSeiKbn() {
        return (String) get("SEIKBN");
    }

    /**
     * 種別コードを設定します。
     * @param val String 種別コード
     */
    public void setShubetsuCd(String val) {
        set("SHOWNUM", val);
    }

    /**
     * 種別コードを返します。
     * @return String 種別コード
     */
    public String getShubetsuCd() {
        return (String) get("SHOWNUM");
    }

    /**
     * 種別名称を設定します。
     * @param val String 種別名称
     */
    public void setShubetsuNm(String val) {
        set("SHUBETSUNM", val);
    }

    /**
     * 種別名称を返します。
     * @return String 種別名称
     */
    public String getShubetsuNm() {
        return (String) get("SHUBETSUNM");
    }

    /**
     * 件名を設定します。
     * @param val String 件名
     */
    public void setKenmei(String val) {
        set("KENMEI", val);
    }

    /**
     * 件名を返します。
     * @return String 件名
     */
    public String getKenmei() {
        return (String) get("KENMEI");
    }

    /**
     * 費目を設定します。
     * @param val String 費目
     */
    public void setHimoku(String val) {
        set("HIMOKU", val);
    }

    /**
     * 費目を返します。
     * @return String 費目
     */
    public String getHimoku() {
        return (String) get("HIMOKU");
    }

    /**
     * 内容を設定します。
     * @param val String 内容
     */
    public void setContents(String val) {
        set("CONTENTS", val);
    }

    /**
     * 内容を返します。
     * @return String 内容
     */
    public String getContents() {
        return (String) get("CONTENTS");
    }

    /**
     * 内容１を設定します。
     * @param val String 内容１
     */
    public void setContents1(String val) {
        set("CONTENTS1", val);
    }

    /**
     * 内容１を返します。
     * @return String 内容１
     */
    public String getContents1() {
        return (String) get("CONTENTS1");
    }

    /**
     * 内容２を設定します。
     * @param val String 内容２
     */
    public void setContents2(String val) {
        set("CONTENTS2", val);
    }

    /**
     * 内容２を返します。
     * @return String 内容２
     */
    public String getContents2() {
        return (String) get("CONTENTS2");
    }

    /**
     * 内容３を設定します。
     * @param val String 内容３
     */
    public void setContents3(String val) {
        set("CONTENTS3", val);
    }

    /**
     * 内容３を返します。
     * @return String 内容３
     */
    public String getContents3() {
        return (String) get("CONTENTS3");
    }

    /**
     * 内容４を設定します。
     * @param val String 内容４
     */
    public void setContents4(String val) {
        set("CONTENTS4", val);
    }

    /**
     * 内容４を返します。
     * @return String 内容４
     */
    public String getContents4() {
        return (String) get("CONTENTS4");
    }

    /**
     * 金額を設定します。
     * @param val BigDecimal 金額
     */
    public void setKngk(BigDecimal val) {
        set("KNGK", val);
    }

    /**
     * 金額を返します。
     * @return BigDecimal 金額
     */
    @XmlElement(required = true)
    public BigDecimal getKngk() {
        return (BigDecimal) get("KNGK");
    }

    /**
     * 消費税額を設定します。
     * @param val BigDecimal 消費税額
     */
    public void setTax(BigDecimal val) {
        set("TAX", val);
    }

    /**
     * 消費税額を返します。
     * @return BigDecimal 消費税額
     */
    @XmlElement(required = true)
    public BigDecimal getTax() {
        return (BigDecimal) get("TAX");
    }

    /**
     * 金額（受注ダウンロードデータ）を設定します。
     * @param val BigDecimal 金額
     */
    public void setKngkJ(BigDecimal val) {
        set("KNGK_J", val);
    }

    /**
     * 金額（受注ダウンロードデータ）を返します。
     * @return BigDecimal 金額
     */
    @XmlElement(required = true)
    public BigDecimal getKngkJ() {
        return (BigDecimal) get("KNGK_J");
    }

    /**
     * 消費税額（受注ダウンロードデータ）を設定します。
     * @param val BigDecimal 消費税額
     */
    public void setTaxJ(BigDecimal val) {
        set("TAX_J", val);
    }

    /**
     * 消費税額（受注ダウンロードデータ）を返します。
     * @return BigDecimal 消費税額
     */
    @XmlElement(required = true)
    public BigDecimal getTaxJ() {
        return (BigDecimal) get("TAX_J");
    }

    /**
     * 部署を設定します。
     * @param val String 部署
     */
    public void setBusho(String val) {
        set("BUSHO", val);
    }

    /**
     * 部署を返します。
     * @return String 部署
     */
    public String getBusho() {
        return (String) get("BUSHO");
    }

    // 2013/01/09 JSE M.Naito add start
    /**
     * 統合フラグを設定します。
     * @param val String 統合フラグ
     */
    public void setTouFlg(String val) {
        set("TOUFLG", val);
    }

    /**
     * 統合フラグを返します。
     * @return String 統合フラグ
     */
    public String getTouFlg() {
        return (String) get("TOUFLG");
    }

    /**
     * 統合先受注Noを設定します。
     * @param val String 統合先受注No
     */
    public void setTJyutNo(String val) {
        set("TJYUTNO", val);
    }

    /**
     * 統合先受注Noを返します。
     * @return String 統合先受注No
     */
    public String getTJyutNo() {
        return (String) get("TJYUTNO");
    }

    /**
     * 統合先受注明細Noを設定します。
     * @param val String 統合先受注明細No
     */
    public void setTJymeiNo(String val) {
        set("TJYMEINO", val);
    }

    /**
     * 統合先受注明細Noを返します。
     * @return String 統合先受注明細No
     */
    public String getTJymeiNo() {
        return (String) get("TJYMEINO");
    }

    /**
     * 統合先売上明細Noを設定します。
     * @param val String 統合先売上明細No
     */
    public void setTUrmeiNo(String val) {
        set("TURMEINO", val);
    }

    /**
     * 統合先売上明細Noを返します。
     * @return String 統合先売上明細No
     */
    public String getTUrmeiNo() {
        return (String) get("TURMEINO");
    }
    // 2013/01/09 JSE M.Naito add end

}

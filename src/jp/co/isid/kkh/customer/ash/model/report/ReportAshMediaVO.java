package jp.co.isid.kkh.customer.ash.model.report;

import java.math.BigDecimal;
import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * 帳票(Ash)VO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/1/20 fourm h.izawa)<BR>
 * ・アサヒ消費税対応(2016/11/22 HLC K.Soga)<BR>
 * </P>
 * @author
 */
public class ReportAshMediaVO extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /** 新規インスタンスを構築します。 */
    public ReportAshMediaVO() {
    }

    /**
     * 新規インスタンスを構築します。
     *
     * @return 新規インスタンス
     */
    public Object newInstance() {
        return new ReportAshMediaVO();
    }

    /**
     * 請求書番号を設定します。
     * @param val String NAME33
     */
    public void setName33(String val) {
        set("NAME33", val);
    }

    /**
     * 請求書番号を返します。
     * @return String NAME33
     */
    public String getName33() {
        return (String) get("NAME33");
    }

    /**
     * 費目名を設定します。
     * @param val String NAME2
     */
    public void setName2(String val) {
        set("NAME2", val);
    }

    /**
     * 費目名を返します。
     * @return String NAME2
     */
    public String getName2() {
        return (String) get("NAME2");
    }

    /**
     * 費目名(漢字)を設定します。
     * @param val String Himknmkj
     */
    public void setHimknmkj(String val) {
        set("HIMKNMKJ", val);
    }

    /**
     * 費目名(漢字)を返します。
     * @return String Himknmkj
     */
    public String getHimknmkj() {
        return (String) get("HIMKNMKJ");
    }

    /**
     * 請求金額を設定します。
     * @param val BigDecimal SeiGak
     */
    public void setSeiGak(BigDecimal val) {
        set("SEIGAK", val);
    }

    /**
     * 請求金額を返します。
     * @return BigDecimal SeiGak
     */
    public BigDecimal getSeiGak() {
        return (BigDecimal) get("SEIGAK");
    }

    /** 2016/11/22 アサヒ消費税対応 HLC K.Soga ADD Start */
    /**
     * 値引額を設定します。
     * @param val BigDecimal NebikiGaku
     */
    public void setNebikiGaku(BigDecimal val) {
        set("NEBIKIGAKU", val);
    }

    /**
     * 値引額を返します。
     * @return BigDecimal NebikiGaku
     */
    public BigDecimal getNebikiGaku() {
        return (BigDecimal) get("NEBIKIGAKU");
    }
    /** 2016/11/22 アサヒ消費税対応 HLC K.Soga ADD End */

    /**
     * 件名(漢字)を設定します。
     * @param val String KkNameKj
     */
    public void setKkNameKj(String val) {
        set("KKNAMEKJ", val);
    }

    /**
     * 件名(漢字)を返します。
     * @return String KkNameKj
     */
    public String getKkNameKj() {
        return (String) get("KKNAMEKJ");
    }

    /**
     * 受注Noを設定します。
     * @param val String JyutNo2
     */
    public void setJyutNo2(String val) {
        set("JYUTNO2", val);
    }

    /**
     * 受注Noを返します。
     * @return String JyutNo2
     */
    public String getJyutNo2() {
        return (String) get("JYUTNO2");
    }

    /**
     * 売上明細Noを設定します。
     * @param val String UrMeiNo02
     */
    public void setUrMeiNo2(String val) {
        set("URMEINO2", val);
    }

    /**
     * 売上明細Noを返します。
     * @return String UrMeiNo02
     */
    public String getUrMeiNo2() {
        return (String) get("URMEINO2");
    }

    /**
     * 受注明細Noを設定します。
     * @param val String JyMeiNo02
     */
    public void setJyMeiNo2(String val) {
        set("JYMEINO2", val);
    }

    /**
     * 受注明細Noを返します。
     * @return String JyMeiNo02
     */
    public String getJyMeiNo2() {
        return (String) get("JYMEINO2");
    }

    /**
     * 本数を設定します。
     * @param val String Sonota2
     */
    public void setSonota2(String val) {
        set("SONOTA2", val);
    }

    /**
     * 本数を返します。
     * @return String Sonota2
     */
    public String getSonota2() {
        return (String) get("SONOTA2");
    }

    /**
     * 連番を設定します。
     * @param val String Renban2
     */
    public void setRenban2(String val) {
        set("RENBAN2", val);
    }

    /**
     * 連番を返します。
     * @return String Renban2
     */
    public String getRenban2() {
        return (String) get("RENBAN2");
    }

    /**
     * 値引率を設定します。
     * @param val String Hnnert
     */
    public void setHnnert(BigDecimal val) {
        set("HNNERT", val);
    }

    /**
     * 値引率を返します。
     * @return String Hnnert
     */
    public BigDecimal getHnnert() {
        return (BigDecimal) get("HNNERT");
    }

    /**
     * 料金を設定します。
     * @param val String HnmeGak
     */
    public void setHnmeGak(BigDecimal val) {
        set("HNMAEGAK", val);
    }

    /**
     * 料金を返します。
     * @return String HnmeGak
     */
    public BigDecimal getHnmeGak() {
        return (BigDecimal) get("HNMAEGAK");
    }
    /**
     * 消費税率を設定します。
     * @param val String Ritu1
     */
    public void setRitu1(BigDecimal val) {
        set("RITU1", val);
    }

    /**
     * 消費税率を返します。
     * @return String Ritu1
     */
    public BigDecimal getRitu1() {
        return (BigDecimal) get("RITU1");
    }

    /**
     * 媒体コードを設定します。
     * @param val String Code1
     */
    public void setCode1(String val) {
        set("CODE1", val);
    }

    /**
     * 媒体コードを返します。
     * @return String Code1
     */
    public String getCode1() {
        return (String) get("CODE1");
    }

    /**
     * 品種コードを設定します。
     * @param val String Code3
     */
    public void setCode3(String val) {
        set("CODE3", val);
    }

    /**
     * 品種コードを返します。
     * @return String Code3
     */
    public String getCode3() {
        return (String) get("CODE3");
    }

    /**
     * ソート番号を設定します。
     * @param val String Sonota10
     */
    public void setSonota10(String val) {
        set("SONOTA10", val);
    }

    /**
     * ソート番号を返します。
     * @return String Sonota10
     */
    public String getSonota10() {
        return (String) get("SONOTA10");
    }

    /**
     * 掲載日､発売日を設定します。
     * @param val String Name5
     */
    public void setName5(String val) {
        set("NAME5", val);
    }

    /**
     * 掲載日､発売日を返します。
     * @return String Name5
     */
    public String getName5() {
        return (String) get("NAME5");
    }

    /**
     * 朝夕区分を設定します。
     * @param val String Sonota3
     */
    public void setSonota3(String val) {
        set("SONOTA3", val);
    }

    /**
     * 朝夕区分を返します。
     * @return String Sonota3
     */
    public String getSonota3() {
        return (String) get("SONOTA3");
    }

    /**
     * 掲載版&掲載号を設定します。
     * @param val String Sonota5
     */
    public void setSonota5(String val) {
        set("SONOTA5", val);
    }

    /**
     * 掲載版&掲載号を返します。
     * @return String Sonota5
     */
    public String getSonota5() {
        return (String) get("SONOTA5");
    }

    /**
     * 記雑区分を設定します。
     * @param val String Sonota6
     */
    public void setSonota6(String val) {
        set("SONOTA6", val);
    }

    /**
     * 記雑区分を返します。
     * @return String Sonota6
     */
    public String getSonota6() {
        return (String) get("SONOTA6");
    }

    /**
     * 局ｺｰﾄﾞを設定します。
     * @param val String Code2
     */
    public void setCode2(String val) {
        set("CODE2", val);
    }

    /**
     * 局ｺｰﾄﾞを返します。
     * @return String Code2
     */
    public String getCode2() {
        return (String) get("CODE2");
    }

    /**
     * 雑誌ｺｰﾄﾞを設定します。
     * @param val String Code6
     */
    public void setCode6(String val) {
        set("CODE6", val);
    }

    /**
     * 雑誌ｺｰﾄﾞを返します。
     * @return String Code6
     */
    public String getCode6() {
        return (String) get("CODE6");
    }
    /**
     * スペースを設定します。
     * @param val String Name1
     */
    public void setName1(String val) {
        set("NAME1", val);
    }

    /**
     * スペースを返します。
     * @return String Name1
     */
    public String getName1() {
        return (String) get("NAME1");
    }

    /**
     * 放送時間、駅路線名を設定します。
     * @param val String Name6
     */
    public void setName6(String val) {
        set("NAME6", val);
    }

    /**
     * 放送時間、駅路線名を返します。
     * @return String Name6
     */
    public String getName6() {
        return (String) get("NAME6");
    }

    /**
     * 曜日を設定します。
     * @param val String Name9
     */
    public void setName9(String val) {
        set("NAME9", val);
    }

    /**
     * 曜日を返します。
     * @return String Name9
     */
    public String getName9() {
        return (String) get("NAME9");
    }

    /** 2016/11/22 アサヒ消費税対応 HLC K.Soga ADD Start */
    /**
     * 消費税額を設定します。
     * @param val BigDecimal Kngk1
     */
    public void setKngk1(BigDecimal val) {
        set("KNGK1", val);
    }

    /**
     * 消費税額を返します。
     * @return BigDecimal Kngk1
     */
    public BigDecimal getKngk1() {
        return (BigDecimal) get("KNGK1");
    }
    /** 2016/11/22 アサヒ消費税対応 HLC K.Soga ADD End */

    /**
     * 局ネット数を設定します。
     * @param val String Sonota7
     */
    public void setSonota7(String val) {
        set("SONOTA7", val);
    }

    /**
     * 局ネット数を返します。
     * @return String Sonota7
     */
    public String getSonota7() {
        return (String) get("SONOTA7");
    }

    /**
     * キー局コードを設定します。
     * @param val String Sonota8
     */
    public void setSonota8(String val) {
        set("SONOTA8", val);
    }

    /**
     * キー局コードを返します。
     * @return String Sonota8
     */
    public String getSonota8() {
        return (String) get("SONOTA8");
    }
}
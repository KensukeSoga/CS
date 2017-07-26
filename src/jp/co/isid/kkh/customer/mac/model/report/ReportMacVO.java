package jp.co.isid.kkh.customer.mac.model.report;

import java.math.BigDecimal;

import jp.co.isid.kkh.integ.tbl.TBTHB2KMEI;
import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * 帳票（MAC)VO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2011/12/27 JSE KT)<BR>
 * </P>
 * @author
 */
public class ReportMacVO extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /**
     * 新規インスタンスを構築します。
     */
    public ReportMacVO() {
    }

    /**
     * 新規インスタンスを構築します。
     *
     * @return 新規インスタンス
     */
    public Object newInstance() {
        return new ReportMacVO();
    }

     /**
      * 受注NOを設定します。
      * @param val String 受注NO
      */
     public void setJyutNo(String val) {
         set(TBTHB2KMEI.JYUTNO, val);
     }

     /**
      * 受注NOを返します。
      * @return String 受注NO
      */
     public String getJyutNo() {
         return (String) get(TBTHB2KMEI.JYUTNO);
     }

    /**
     * 受注明細NOを設定します。
     * @param val String 受注明細NO
     */
    public void setJyMeiNo(String val) {
        set(TBTHB2KMEI.JYMEINO, val);
    }

    /**
     * 受注明細NOを返します。
     * @return String 受注明細NO
     */
    public String getJyMeiNo() {
        return (String) get(TBTHB2KMEI.JYMEINO);
    }

    /**
     * 売上明細NOを設定します。
     * @param val String 売上明細NO
     */
    public void setUrMeiNo(String val) {
        set(TBTHB2KMEI.URMEINO, val);
    }

    /**
     * 売上明細NOを返します。
     * @return String 売上明細NO
     */
    public String getUrMeiNo() {
        return (String) get(TBTHB2KMEI.URMEINO);
    }

    /**
     * 掲載日を設定します。
     * @param val String 掲載日
     */
    public void setDate1(String val) {
        set(TBTHB2KMEI.DATE1, val);
    }

    /**
     * 掲載日を返します。
     * @return String 掲載日
     */
    public String getDate1() {
        return (String) get(TBTHB2KMEI.DATE1);
    }

    /**
     * CODE1を設定します。
     * @param val String CODE1
     */
    public void setCode1(String val) {
        set(TBTHB2KMEI.CODE1, val);
    }

    /**
     * CODE1を返します。
     * @return String CODE1
     */
    public String getCode1() {
        return (String) get(TBTHB2KMEI.CODE1);
    }

    /**
     * CODE2を設定します。
     * @param val String CODE2
     */
    public void setCode2(String val) {
        set(TBTHB2KMEI.CODE2, val);
    }

    /**
     * CODE2を返します。
     * @return String CODE2
     */
    public String getCode2() {
        return (String) get(TBTHB2KMEI.CODE2);
    }

    /**
     * CODE4を設定します。
     * @param val String CODE4
     */
    public void setCode4(String val) {
        set(TBTHB2KMEI.CODE4, val);
    }

    /**
     * CODE4を返します。
     * @return String CODE4
     */
    public String getCode4() {
        return (String) get(TBTHB2KMEI.CODE4);
    }

    /**
     * NAME1を設定します。
     * @param val String NAME1
     */
    public void setName1(String val) {
        set(TBTHB2KMEI.NAME1, val);
    }

    /**
     * NAME1を返します。
     * @return String NAME1
     */
    public String getName1() {
        return (String) get(TBTHB2KMEI.NAME1);
    }

    /**
     * NAME2を設定します。
     * @param val String NAME2
     */
    public void setName2(String val) {
        set(TBTHB2KMEI.NAME2, val);
    }

    /**
     * NAME2を返します。
     * @return String NAME2
     */
    public String getName2() {
        return (String) get(TBTHB2KMEI.NAME2);
    }

    /**
     * NAME3を設定します。
     * @param val String NAME3
     */
    public void setName3(String val) {
        set(TBTHB2KMEI.NAME3, val);
    }

    /**
     * NAME3を返します。
     * @return String NAME3
     */
    public String getName3() {
        return (String) get(TBTHB2KMEI.NAME3);
    }

    /**
     * 料金を設定します。
     * @param val String 料金
     */
    public void setSeiGak(BigDecimal val) {
        set(TBTHB2KMEI.SEIGAK, val);
    }

    /**
     * 料金を返します。
     * @return String 料金
     */
    public BigDecimal getSeiGak() {
        return (BigDecimal) get(TBTHB2KMEI.SEIGAK);
    }

    /**
     * 区分1を設定します。
     * @param val String 区分1
     */
    public void setKbn1(String val) {
        set(TBTHB2KMEI.KBN1, val);
    }

    /**
     * 区分1を返します。
     * @return String 区分1
     */
    public String getKbn1() {
        return (String) get(TBTHB2KMEI.KBN1);
    }

    /**
     * 金額1を設定します。
     * @param val BigDecimal 金額1
     */
    public void setKngk1(BigDecimal val) {
        set(TBTHB2KMEI.KNGK1, val);
    }

    /**
     * 金額1を返します。
     * @return BigDecimal 金額1
     */
    public BigDecimal getKngk1() {
        return (BigDecimal) get(TBTHB2KMEI.KNGK1);
    }

    /**
     * 金額2を設定します。
     * @param val BigDecimal 金額2
     */
    public void setKngk2(BigDecimal val) {
        set(TBTHB2KMEI.KNGK2, val);
    }

    /**
     * 金額2を返します。
     * @return BigDecimal 金額2
     */
    public BigDecimal getKngk2() {
        return (BigDecimal) get(TBTHB2KMEI.KNGK2);
    }

    /**
     * SONOTA1を設定します。
     * @param val String SONOTA1
     */
    public void setSonota1(String val) {
        set(TBTHB2KMEI.SONOTA1, val);
    }

    /**
     * SONOTA1を返します。
     * @return String SONOTA1
     */
    public String getSonota1() {
        return (String) get(TBTHB2KMEI.SONOTA1);
    }

    /**
     * SONOTA2を設定します。
     * @param val String SONOTA2
     */
    public void setSonota2(String val) {
        set(TBTHB2KMEI.SONOTA2, val);
    }

    /**
     * SONOTA2を返します。
     * @return String SONOTA2
     */
    public String getSonota2() {
        return (String) get(TBTHB2KMEI.SONOTA2);
    }

    /**
     * RENBNを設定します。
     * @param val String RENBN
     */
    public void setRenbn(String val) {
        set(TBTHB2KMEI.RENBN, val);
    }

    /**
     * RENBNを返します。
     * @return String RENBN
     */
    public String getRenbn() {
        return (String) get(TBTHB2KMEI.RENBN);
    }

    //消費税対応 2013/10/21 add HLC H.Watabe start
    /**
     * Ritu1を設定します。
     * @param val BigDecimal Ritu1
     */
    public void setRitu1(BigDecimal val) {
        set(TBTHB2KMEI.RITU1, val);
    }

    /**
     * Ritu1を返します。
     * @return BigDecimal Ritu1
     */
    public BigDecimal getRitu1() {
        return (BigDecimal) get(TBTHB2KMEI.RITU1);
    }
    //消費税対応 2013/10/21 add HLC H.Watabe start

}

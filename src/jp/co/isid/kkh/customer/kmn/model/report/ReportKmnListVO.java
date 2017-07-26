package jp.co.isid.kkh.customer.kmn.model.report;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlElement;

import jp.co.isid.kkh.integ.tbl.TBTHB14SKDOWN;
import jp.co.isid.kkh.integ.tbl.TBTHB1DOWN;
import jp.co.isid.kkh.integ.tbl.TBTHB2KMEI;
import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * 帳票（公文_請求一覧）データVO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2013/1/31 JSE A.Naito)<BR>
 * </P>
 *
 * @author JSE A.Naito
 */
public class ReportKmnListVO extends AbstractModel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * 新規インスタンスを構築します。
     */
    public ReportKmnListVO() {
    }

    /**
     * 新規インスタンスを構築します。
     *
     * @return 新規インスタンス
     */
    public Object newInstance() {
        return new ReportKmnListVO();
    }

    //選択
    public String Sentaku;
    //内容
    public String Naiyo;
    //宛先
    public String Atesaki;

    /**
     * 選択を設定します。
     * @param val String 選択
     */
    public void setSentaku(String val) {
        set(Sentaku, val);
    }

    /**
     * 選択を返します。
     * @return String 選択
     */
    public String getSentaku() {
        return (String) get(Sentaku);
    }

    /**
     * 出力Noを設定します。
     * @param val String 出力No
     */
    public void setShutNo(String val) {
        set(TBTHB2KMEI.CODE2, val);
    }

    /**
     * 出力Noを返します。
     * @return String 出力No
     */
    public String getShutNo() {
        return (String) get(TBTHB2KMEI.CODE2);
    }

    /**
     * シークエンスNoを設定します。
     * @param val String シークエンスNo
     */
    public void setSeqNo(String val) {
        set(TBTHB2KMEI.CODE3, val);
    }

    /**
     * シークエンスNoを返します。
     * @return String シークエンスNo
     */
    public String getSeqNo() {
        return (String) get(TBTHB2KMEI.CODE3);
    }

    /**
     * 受注Noを設定します。
     * @param val String 受注No
     */
    public void setJyutNo(String val) {
        set(TBTHB2KMEI.JYUTNO, val);
    }

    /**
     * 受注Noを返します。
     * @return String 受注No
     */
    public String getJyutNo() {
        return (String) get(TBTHB2KMEI.JYUTNO);
    }

    /**
     * 受注明細Noを設定します。
     * @param val String 受注明細No
     */
    public void setJyMeiNo(String val) {
        set(TBTHB2KMEI.JYMEINO, val);
    }

    /**
     * 受注明細Noを返します。
     * @return String 受注明細No
     */
    public String getJyMeiNo() {
        return (String) get(TBTHB2KMEI.JYMEINO);
    }

    /**
     * 売上明細Noを設定します。
     * @param val String 売上明細No
     */
    public void setUrMeiNo(String val) {
        set(TBTHB2KMEI.URMEINO, val);
    }

    /**
     * 売上明細Noを返します。
     * @return String 売上明細No
     */
    public String getUrMeiNo() {
        return (String) get(TBTHB2KMEI.URMEINO);
    }

    /**
     * 連番を設定します。
     * @param val String 連番
     */
    public void setRenban(String val) {
        set(TBTHB2KMEI.RENBN, val);
    }

    /**
     * 連番を返します。
     * @return String 連番
     */
    public String getRenban() {
        return (String) get(TBTHB2KMEI.RENBN);
    }

    /**
     * 内容を設定します。
     * @param val String 内容
     */
    public void setNaiyo(String val) {
        set(Naiyo, val);
    }

    /**
     * 内容を返します。
     * @return String 内容
     */
    public String getNaiyo() {
        return (String) get(Naiyo);
    }

    /**
     * 費目を設定します。
     * @param String 費目
     */
    public void setHimoku(String val) {
        set(TBTHB2KMEI.NAME1, val);
    }

    /**
     * 費目を返します。
     * @return String 費目
     */
    public String getHimoku() {
        return (String) get(TBTHB2KMEI.NAME1);
    }

    /**
    * 部門コードを設定します。
    * @param val String 部門コードNo
    */
   public void setBumonCd(String val) {
       set(TBTHB2KMEI.CODE1, val);
   }

   /**
    * 部門コードを返します。
    * @return String 部門コードNo
    */
   public String getBumonCd() {
       return (String) get(TBTHB2KMEI.CODE1);
   }

   /**
    * 部門名を設定します。
    * @param val String 部門名
    */
   public void setBumonNm(String val) {
       set(TBTHB2KMEI.NAME6, val);
   }

   /**
    * 部門名を返します。
    * @return String 部門名
    */
   public String getBumonNm() {
       return (String) get(TBTHB2KMEI.NAME6);
   }

   /**
    * 宛先を設定します。
    * @param val String 宛先
    */
   public void setAtesaki(String val) {
       set(Atesaki, val);
   }

   /**
    * 宛先を返します。
    * @return String 宛先
    */
   public String getAtesaki() {
       return (String) get(Atesaki);
   }

    /**
     * 期間を設定します。
     * @param val String 期間
     */
    public void setKikan(String val) {
        set(TBTHB2KMEI.NAME2, val);
    }

    /**
     * 期間を返します。
     * @return String 期間
     */
    public String getKikan() {
        return (String) get(TBTHB2KMEI.NAME2);
    }

    /**
     * 金額を設定します。
     * @param val BigDecimal 金額
     */
    public void setKingaku(BigDecimal val) {
        set(TBTHB2KMEI.KNGK1, val);
    }

    /**
     * 金額を返します。
     * @return BigDecimal 金額
     */
    @XmlElement(required = true)
    public BigDecimal getKingaku() {
        return (BigDecimal) get(TBTHB2KMEI.KNGK1);
    }

    /**
     * 備考を設定します。
     * @param val String 備考
     */
    public void setBiko(String val) {
        set(TBTHB2KMEI.NAME15, val);
    }

    /**
     * 備考を返します。
     * @return String 備考
     */
    public String getBiko() {
        return (String) get(TBTHB2KMEI.NAME15);
    }

    /**
     * 請求回収のデータ数を設定します。
     * @param val String 請求回収のデータ数
     */
    public void setSeiZumi(String val) {
        set("SKDOWN_CNT", val);
    }

    /**
     * 請求回収のデータ数を返します。
     * @return String 請求回収のデータ数
     */
    public String getSeiZumi() {
        return (String) get("SKDOWN_CNT");
    }

    /**
     * 請求回収の受注Noを設定します。
     * @param val String 受注No
     */
    public void setSkJyutNo(String val) {
        set(TBTHB14SKDOWN.JYUTNO, val);
    }

    /**
     * 請求回収の受注Noを返します。
     * @return String 受注No
     */
    public String getSkJyutNo() {
        return (String) get(TBTHB14SKDOWN.JYUTNO);
    }

    /**
     * 受注の受注Noを設定します。
     * @param val String 受注No
     */
    public void setDJyutNo(String val) {
        set(TBTHB1DOWN.JYUTNO, val);
    }

    /**
     * 受注の受注Noを返します。
     * @return String 受注No
     */
    public String getDJyutNo() {
        return (String) get(TBTHB1DOWN.JYUTNO);
    }

    /**
     * 受注の統合先受注Noを設定します。
     * @param val String 統合先受注No
     */
    public void setDTJyutNo(String val) {
        set(TBTHB1DOWN.TJYUTNO, val);
    }

    /**
     * 受注の統合先受注Noを返します。
     * @return String 統合先受注No
     */
    public String getDTJyutNo() {
        return (String) get(TBTHB1DOWN.TJYUTNO);
    }
}
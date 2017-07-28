package jp.co.isid.kkh.customer.mac.model.report;

import java.math.BigDecimal;

import jp.co.isid.kkh.integ.tbl.TBTHBAMST;
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
public class ReportMacGetDenNumVO extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /**
     * 新規インスタンスを構築します。
     */
    public ReportMacGetDenNumVO() {
    }

    /**
     * 新規インスタンスを構築します。
     *
     * @return 新規インスタンス
     */
    public Object newInstance() {
        return new ReportMacGetDenNumVO();
    }

     /**
      * 伝票番号を設定します。
      * @param val String 伝票番号
      */
     public void setDenNum(String val) {
         set(TBTHBAMST.FIELD1, val);
     }

     /**
      * 伝票番号を返します。
      * @return String 伝票番号
      */
     public String getDenNum() {
         return (String) get(TBTHBAMST.FIELD1);
     }

     /**
      * 伝票番号上限を設定します。
      * @param val String 伝票番号上限
      */
     public void setDenNumMax(String val) {
         set(TBTHBAMST.FIELD2, val);
     }

     /**
      * 伝票番号上限を返します。
      * @return String 伝票番号上限
      */
     public String getDenNumMax() {
         return (String) get(TBTHBAMST.FIELD2);
     }

     /**
      * 取引先コードを設定します。
      * @param val String 取引先コード
      */
     public void setTrhskCd(String val) {
         set(TBTHBAMST.FIELD3, val);
     }

     /**
      * 取引先コードを返します。
      * @return String 取引先コード
      */
     public String getTrhskCd() {
         return (String) get(TBTHBAMST.FIELD3);
     }

     /**
      *
      * 電話番号を設定します。
      * @param val String 電話番号
      */
     public void setTelNo(String val) {
         set(TBTHBAMST.FIELD4, val);
     }

     /**
      * 電話番号を返します。
      * @return String 電話番号
      */
     public String getTelNo() {
         return (String) get(TBTHBAMST.FIELD4);
     }

     /**
      * 連絡先住所を設定します。
      * @param val String 連絡先住所
      */
     public void setAddress(String val) {
         set(TBTHBAMST.FIELD5, val);
     }

     /**
      * 連絡先住所を返します。
      * @return String 連絡先住所
      */
     public String getAddress() {
         return (String) get(TBTHBAMST.FIELD5);
     }

     /**
      * 伝票調整値を設定します。
      * @param val String 伝票調整値
      */
     public void setSetDenpyo(String val) {
         set(TBTHBAMST.FIELD6, val);
     }

     /**
      * 伝票調整値を返します。
      * @return String 伝票調整値
      */
     public String getSetDenpyo() {
         return (String) get(TBTHBAMST.FIELD6);
     }

     /**
      * ラベル調整値を設定します。
      * @param val String ラベル調整値
      */
     public void setSetLabel(String val) {
         set(TBTHBAMST.FIELD7, val);
     }

     /**
      * ラベル調整値を返します。
      * @return String ラベル調整値
      */
     public String getSetLabel() {
         return (String) get(TBTHBAMST.FIELD7);
     }

     /**
      * 消費税を設定します。
      * @param val String 消費税
      */
     public void setComTax(BigDecimal val) {
         set(TBTHBAMST.INTVALUE2, val);
     }

     /**
      * 消費税を返します。
      * @return String 消費税
      */
     public BigDecimal getComTax() {
         return (BigDecimal) get(TBTHBAMST.INTVALUE2);
     }

}

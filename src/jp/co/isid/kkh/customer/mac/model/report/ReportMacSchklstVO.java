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
public class ReportMacSchklstVO extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /**
     * 新規インスタンスを構築します。
     */
    public ReportMacSchklstVO() {
    }

    /**
     * 新規インスタンスを構築します。
     *
     * @return 新規インスタンス
     */
    public Object newInstance() {
        return new ReportMacSchklstVO();
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
     * NAME5を設定します。
     * @param val String NAME5
     */
    public void setName5(String val) {
        set(TBTHB2KMEI.NAME5, val);
    }

    /**
     * NAME5を返します。
     * @return String NAME5
     */
    public String getName5() {
        return (String) get(TBTHB2KMEI.NAME5);
    }

    /**
     * NAME4を設定します。
     * @param val String NAME5
     */
    public void setName4(String val) {
        set(TBTHB2KMEI.NAME4, val);
    }

    /**
     * NAME4を返します。
     * @return String NAME5
     */
    public String getName4() {
        return (String) get(TBTHB2KMEI.NAME4);
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

}

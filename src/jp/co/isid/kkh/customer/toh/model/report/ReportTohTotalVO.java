package jp.co.isid.kkh.customer.toh.model.report;

import java.math.BigDecimal;

import jp.co.isid.kkh.integ.tbl.TBTHB2KMEI;
import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * 帳票（TOH)VO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/02/22 JSE T.Kobayashi)<BR>
 * </P>
 * @author
 */
public class ReportTohTotalVO extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /**
     * 新規インスタンスを構築します。
     */
    public ReportTohTotalVO() {
    }

    /**
     * 新規インスタンスを構築します。
     *
     * @return 新規インスタンス
     */
    public Object newInstance() {
        return new ReportTohTotalVO();
    }

    /**
     * 年月を設定します。
     * @param val String 受注NO
     */
    public void setYYMM(String val) {
        set(TBTHB2KMEI.YYMM, val);
    }

    /**
     * 年月を返します。
     * @return String 受注NO
     */
    public String getYYMM() {
        return (String) get(TBTHB2KMEI.YYMM);
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
     * 媒体名を設定します。
     * @param val String 媒体名
     */
    public void setName2(String val) {
        set(TBTHB2KMEI.NAME2, val);
    }

    /**
     * 媒体名を返します。
     * @return String 媒体名
     */
    public String getName2() {
        return (String) get(TBTHB2KMEI.NAME2);
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
     * スペース2を設定します。
     * @param val String スペース2
     */
    public void setName11(String val) {
        set(TBTHB2KMEI.NAME11, val);
    }

    /**
     * スペース2を返します。
     * @return String スペース2
     */
    public String getName11() {
        return (String) get(TBTHB2KMEI.NAME11);
    }

    /**
     * スペース2（枠）を設定します。
     * @param val String スペース2（枠）
     */
    public void setName11wak(String val) {
        set("HB2_NAME11WAK", val);
    }

    /**
     * スペース2（枠）を返します。
     * @return String スペース2（枠）
     */
    public String getName11wak() {
        return (String) get("HB2_NAME11WAK");
    }

    /**
     * 枠フラグを設定します。
     * @param val String 枠フラグ
     */
     public void setName12(String val) {
         set(TBTHB2KMEI.NAME12, val);
     }

     /**
      * 枠フラグを返します。
      * @return String 枠フラグ
      */
     public String getName12() {
         return (String) get(TBTHB2KMEI.NAME12);
     }

}

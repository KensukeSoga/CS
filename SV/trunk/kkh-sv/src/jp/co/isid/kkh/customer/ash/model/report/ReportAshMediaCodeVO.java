package jp.co.isid.kkh.customer.ash.model.report;

import jp.co.isid.kkh.integ.tbl.TBTHBAMST;
import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * 帳票（Ash)VO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/1/23 fourm h.izawa)<BR>
 * </P>
 * @author
 */
public class ReportAshMediaCodeVO extends AbstractModel {

    private static final long serialVersionUID = 1L;
    /**
     * 新規インスタンスを構築します。
     */
    public ReportAshMediaCodeVO() {
    }

    /**
     * 新規インスタンスを構築します。
     *
     * @return 新規インスタンス
     */
    public Object newInstance() {
        return new ReportAshMediaCodeVO();
    }

    /**
     * 種別を設定します。
     * @param val String SYBT
     */
    public void setSybt(String val) {
        set(TBTHBAMST.SYBT, val);
     }

    /**
     * 種別を返します。
     * @return String SYBT
     */
    public String getSybt() {
        return (String) get(TBTHBAMST.SYBT);
    }

    /**
     * Field1を設定します。
     * @param val String FIELD1
     */
    public void setField1(String val) {
        set(TBTHBAMST.FIELD1, val);
    }

    /**
     * Field1を返します。
     * @return String FIELD1
     */
    public String getField1() {
        return (String) get(TBTHBAMST.FIELD1);
    }

    /**
     * FIELD2を設定します。
     * @param val String FIELD2
     */
    public void setField2(String val) {
        set(TBTHBAMST.FIELD2, val);
    }

    /**
     * FIELD2を返します。
     * @return String FIELD2
     */
    public String getField2() {
        return (String) get(TBTHBAMST.FIELD2);
    }

    /**
     * Field3を設定します。
     * @param val String Field3
     */
    public void setField3(String val) {
        set(TBTHBAMST.FIELD3, val);
    }

    /**
     * FIELD3を返します。
     * @return String FIELD3
     */
    public String getField3() {
        return (String) get(TBTHBAMST.FIELD3);
    }

    /**
     * FIELD4を設定します。
     * @param val String FIELD4
     */
    public void setField4(String val) {
        set(TBTHBAMST.FIELD4, val);
    }

    /**
     * FIELD4を返します。
     * @return String FIELD4
     */
    public String getField4() {
        return (String) get(TBTHBAMST.FIELD4);
    }

    //2015/07/08 k.soga アサヒ対応 Add  Start
    /**
     * FIELD9を設定します。
     * @param val String FIELD9
     */
    public void setField9(String val) {
        set(TBTHBAMST.FIELD9, val);
    }

    /**
     * FIELD9を返します。
     * @return String FIELD9
     */
    public String getField9() {
        return (String) get(TBTHBAMST.FIELD9);
    }
    //2015/07/08 k.soga アサヒ対応 Add  End
}

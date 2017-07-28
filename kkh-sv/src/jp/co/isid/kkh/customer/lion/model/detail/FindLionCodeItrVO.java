package jp.co.isid.kkh.customer.lion.model.detail;

import java.math.BigDecimal;

import jp.co.isid.kkh.integ.tbl.TBTHBAMST;
import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * コード一覧VO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/02/27 JSE A.Naito)<BR>
 * </P>
 * @author
 */
public class FindLionCodeItrVO extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /**
     * 新規インスタンスを構築します。
     */
    public FindLionCodeItrVO() {
    }

    /**
     * 新規インスタンスを構築します。
     *
     * @return 新規インスタンス
     */
    public Object newInstance() {
        return new FindLionCodeItrVO();
    }

    /** VAL1 */
    public static final String VAL1 = "VAL1";

    /** VAL2 */
    public static final String VAL2 = "VAL2";

    /** VAL3 */
    public static final String VAL3 = "VAL3";

    /** VAL4 */
    public static final String VAL4 = "VAL4";

    //動的マスタ////////////////////////////////
    /**
     * VAL1を設定する
     * @param val VAL1
     */
    public void setVal1(String val) {
        set(VAL1, val);
    }

    /**
     * VAL1を取得する
     * @return VAL1
     */
    public String getVal1() {
        return (String) get(VAL1);
    }

    /**
     * VAL2を設定する
     * @param val VAL2
     */
    public void setVal2(String val) {
        set(VAL2, val);
    }

    /**
     * VAL2を取得する
     * @return VAL2
     */
    public String getVal2() {
        return (String) get(VAL2);
    }

    /**
     * VAL3を設定する
     * @param val VAL3
     */
    public void setVal3(String val) {
        set(VAL3, val);
    }

    /**
     * VAL3を取得する
     * @return VAL3
     */
    public String getVal3() {
        return (String) get(VAL3);
    }

    /**
     * VAL4を設定する
     * @param val VAL4
     */
    public void setVal4(String val) {
        set(VAL4, val);
    }

    /**
     * VAL4を取得する
     * @return VAL4
     */
    public String getVal4() {
        return (String) get(VAL4);
    }

    //////////////////////////////////////////////

    /**
     * Intvalue1を設定します。
     * @param val String Intvalue1
     */
    public void setIntvalue1(BigDecimal val) {
        set(TBTHBAMST.INTVALUE1, val);
    }

    /**
     * Intvalue1を返します。
     * @return String Intvalue1
     */
    public BigDecimal getIntvalue1() {
        return (BigDecimal) get(TBTHBAMST.INTVALUE1);
    }

}
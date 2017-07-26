package jp.co.isid.kkh.customer.lion.model.master;

import java.math.BigDecimal;
import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * ラジオ局VO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/03/02 JSE A.Naito)<BR>
 * </P>
 * @author JSE A.Naito
 */
public class LionZashiRyoSpcMastVO extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /**
     * 新規インスタンスを構築します。
     */
    public LionZashiRyoSpcMastVO() {
    }

    /**
     * 新規インスタンスを構築します。
     *
     * @return 新規インスタンス
     */
    public Object newInstance() {
        return new LionZashiRyoSpcMastVO();
    }

    /** VAL1 */
    public static final String VAL1 = "VAL1";

    /** VAL2 */
    public static final String VAL2 = "VAL2";

    /** VAL3 */
    public static final String VAL3 = "VAL3";

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
        return  (String) get(VAL2);
    }

    /**
     * VAL3を設定する
     * @param val VAL3
     */
    public void setVal3(BigDecimal val) {
        set(VAL3, val);
    }

    /**
     * VAL3を取得する
     * @return VAL3
     */
    public BigDecimal getVal3() {
        return  (BigDecimal) get(VAL3);
    }

}
package jp.co.isid.kkh.customer.tkd.model.detail;

import java.math.BigDecimal;

import jp.co.isid.kkh.integ.tbl.TBTHB2KMEI;
import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * 実施No最大値VO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2011/12/09 JSE Y.Sato)<BR>
 * </P>
 *
 * @author JSE Y.Sato
 */
public class FindMaxJissiNoCondVO extends AbstractModel {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
     * 新規インスタンスを構築します。
     */
    public FindMaxJissiNoCondVO() {
    }

    /**
     * 新規インスタンスを構築します。
     *
     * @return 新規インスタンス
     */
    public Object newInstance() {
        return new FindMaxJissiNoCondVO();
    }

    /**
     * 実施Noの最大値を設定します。
     *
     * @param val
     *            BigDecimal 実施Noの最大値
     */
    public void setKngk1(BigDecimal val) {
        set(TBTHB2KMEI.KNGK1, val);
    }

    /**
     * 実施Noの最大値を返します。
     *
     * @return BigDecimal 実施Noの最大値
     */
    public BigDecimal getKngk1() {
        return (BigDecimal) get(TBTHB2KMEI.KNGK1);
    }

}
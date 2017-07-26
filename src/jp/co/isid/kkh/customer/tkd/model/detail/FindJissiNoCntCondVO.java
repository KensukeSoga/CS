package jp.co.isid.kkh.customer.tkd.model.detail;

import java.math.BigDecimal;

import jp.co.isid.kkh.integ.tbl.TBTHB2KMEI;
import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * 使用済実施No件数VO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2011/12/13 JSE Y.Sato)<BR>
 * </P>
 *
 * @author JSE Y.Sato
 */
public class FindJissiNoCntCondVO extends AbstractModel {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
     * 新規インスタンスを構築します。
     */
    public FindJissiNoCntCondVO() {
    }

    /**
     * 新規インスタンスを構築します。
     *
     * @return 新規インスタンス
     */
    public Object newInstance() {
        return new FindJissiNoCntCondVO();
    }

    /**
     * 使用済実施Noの件数を設定します。
     *
     * @param val
     *            BigDecimal 使用済実施Noの件数
     */
    public void setKngk1(BigDecimal val) {
        set(TBTHB2KMEI.KNGK1, val);
    }

    /**
     * 使用済実施Noの件数を返します。
     *
     * @return BigDecimal 使用済実施Noの件数
     */
    public BigDecimal getKngk1() {
        return (BigDecimal) get(TBTHB2KMEI.KNGK1);
    }

}
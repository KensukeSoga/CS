package jp.co.isid.kkh.customer.lion.model.detail;

import jp.co.isid.kkh.integ.tbl.TBTHB2KMEI;
import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * CardNoGetVO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/02/20 JSE KTPRES)<BR>
 * </P>
 * @author
 */
public class FindLionCardNoGetVO extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /**
     * 新規インスタンスを構築します。
     */
    public FindLionCardNoGetVO() {
    }

    /**
     * 新規インスタンスを構築します。
     *
     * @return 新規インスタンス
     */
    public Object newInstance() {
        return new FindLionCardNoGetVO();
    }

    /**
     * 媒体区分を設定します。
     * @param val val String 媒体区分
     */
    public void setCode1(String val) {
        set(TBTHB2KMEI.CODE1, val);
    }

    /**
     * 媒体区分を返します。
     * @return String 媒体区分
     */
    public String getCode1() {
        return (String) get(TBTHB2KMEI.CODE1);
    }

    /**
     * カードNoを設定します。
     * @param val String カードNo
     */
    public void setCode6(String val) {
      set(TBTHB2KMEI.CODE6, val);
    }

    /**
     * カードNoを返します。
     * @return String カードNo
     */
    public String getCode6() {
      return (String) get(TBTHB2KMEI.CODE6);
    }

}
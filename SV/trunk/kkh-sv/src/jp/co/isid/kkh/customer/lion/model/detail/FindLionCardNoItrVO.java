package jp.co.isid.kkh.customer.lion.model.detail;

import jp.co.isid.kkh.integ.tbl.TBTHBAMST;
import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * カードNO一覧VO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/02/21 JSE A.Naito)<BR>
 * </P>
 * @author
 */
public class FindLionCardNoItrVO extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /**
     * 新規インスタンスを構築します。
     */
    public FindLionCardNoItrVO() {
    }

    /**
     * 新規インスタンスを構築します。
     *
     * @return 新規インスタンス
     */
    public Object newInstance() {
        return new FindLionCardNoItrVO();
    }

    /**
     * コードを設定します。
     * @param val String KYOKUNAME
     */
    public void setField1(String val) {
        set(TBTHBAMST.FIELD1, val);
    }

    /**
     * コードを返します。
     * @return String KYOKUNAME
     */
    public String getField1() {
        return (String) get(TBTHBAMST.FIELD1);
    }

    /**
     * 名称を設定します。
     * @param val String KIGOU
     */
    public void setField2(String val) {
        set(TBTHBAMST.FIELD2, val);
    }

    /**
     * 名称を返します。
     * @return String KIGOU
     */
    public String getField2() {
        return (String) get(TBTHBAMST.FIELD2);
    }

}
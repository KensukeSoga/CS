package jp.co.isid.kkh.customer.kmn.model.report;

import jp.co.isid.kkh.integ.tbl.TBTHB2KMEI;
import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * シークエンスNo最大値VO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2013/02/25 JSE A.Naito)<BR>
 * </P>
 *
 * @author JSE A.Naito
 */
public class MaxSeqNoVO extends AbstractModel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * 新規インスタンスを構築します。
     */
    public MaxSeqNoVO() {
    }

    /**
     * 新規インスタンスを構築します。
     *
     * @return 新規インスタンス
     */
    public Object newInstance() {
        return new MaxSeqNoVO();
    }

    /**
     * シークエンスNoを設定します。
     * @param val String シークエンスNo
     */
    public void setSeqNo(String val) {
        set(TBTHB2KMEI.CODE3, val);
    }

    /**
     * シークエンスNoを返します。
     * @return String シークエンスNo
     */
    public String getSeqNo() {
        return (String) get(TBTHB2KMEI.CODE3);
    }
}
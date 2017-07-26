package jp.co.isid.kkh.customer.kmn.model.report;

import jp.co.isid.kkh.model.AbstractServiceCondition;

/**
 * <P>
 * シークエンスNo最大値取得Condition
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2013/2/25 JSE A.Naito)<BR>
 * </P>
 *
 * @author JSE A.Naito
 */
public class MaxSeqNoCondition extends AbstractServiceCondition {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /** 請求年月 */
    private String _yyMm = null;

    /**
     * 請求年月を返します。
     *
     * @return yyMm
     */
    public String getYyMm() {
        return _yyMm;
    }

    /**
     * 請求年月を設定します。
     *
     * @param yyMm
     */
    public void setYyMm(String yyMm) {
        this._yyMm = yyMm;
    }
}


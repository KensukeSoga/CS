package jp.co.isid.kkh.customer.kmn.model.report;

import jp.co.isid.kkh.model.AbstractServiceCondition;

/**
 * <P>
 * 帳票（公文_請求一覧）データCondition
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2013/1/31 JSE A.Naito)<BR>
 * </P>
 *
 * @author JSE A.Naito
 */
public class ReportKmnListCondition extends AbstractServiceCondition {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /** 部門 */
    private String _bumonCd = null;
    /** 出力単位 */
    private String _output = null;

    /**
     * 部門を返します。
     *
     * @return _bumonCd
     */
    public String getBumonCd() {
        return _bumonCd;
    }

    /**
     * 部門を設定します。
     *
     * @param bumonCd
     */
    public void setBumonCd(String bumonCd) {
        this._bumonCd = bumonCd;
    }

    /**
     * 出力単位を返します。
     *
     * @return _output
     */
    public String getOutput() {
        return _output;
    }

    /**
     * 出力単位を設定します。
     *
     * @param _output
     */
    public void setOutput(String output) {
        this._output = output;
    }
}

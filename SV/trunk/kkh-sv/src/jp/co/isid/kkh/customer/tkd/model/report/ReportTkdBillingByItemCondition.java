package jp.co.isid.kkh.customer.tkd.model.report;

import jp.co.isid.kkh.model.AbstractServiceCondition;

/**
 * <P>
 * 武田請求明細（品目別）取得条件
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/01/23 JSE Hitoshi Sasaki)<BR>
 * </P>
 *
 * @author JSE Hitoshi Sasaki
 */
public class ReportTkdBillingByItemCondition extends AbstractServiceCondition {

    private static final long serialVersionUID = 1L;

/*	*//** 年月 *//*
    private String _ym;
*/
    /** 区分 */
    private String _kbn;

/*	*//**
     * @return _ym
     *//*
    public String getYM() {
        return _ym;
    }

    *//**
     * @param ym
     *            セットする ym
     *//*
    public void setYM(String ym) {
        this._ym = ym;
    }*/

    /**
     * @return _kbn
     */
    public String getKbn() {
        return _kbn;
    }

    /**
     * @param kbn
     *            セットする kbn
     */
    public void setKbn(String kbn) {
        this._kbn = kbn;
    }

}

package jp.co.isid.kkh.model.login;

import jp.co.isid.kkh.integ.tbl.TBRCMN_MEU12THSKGY;
import jp.co.isid.kkh.integ.tbl.TBRCMN_MEU13THSKGYBMON;
import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * 取引先情報VO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/02/13 JSE H.Abe)<BR>
 * </P>
 * @author JSE H.Abe
 */
public class RcmnMeu12ThskgyVO extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /**
     * 新規インスタンスを構築します。
     */
    public RcmnMeu12ThskgyVO() {
    }

    /**
     * 新規インスタンスを構築します。
     *
     * @return 新規インスタンス
     */
    public Object newInstance() {
        return new RcmnMeu12ThskgyVO();
    }

    /**
     * THSKGYDISPKJを取得する
     * @return THSKGYDISPKJ
     */
    public String getThskgyDispKj() {
        return (String) get(TBRCMN_MEU12THSKGY.THSKGYDISPKJ);
    }

    /**
     * THSKGYDISPKJを設定する
     * @param val THSKGYDISPKJ
     */
    public void setThskgyDispKj(String val) {
        set(TBRCMN_MEU12THSKGY.THSKGYDISPKJ, val);
    }

    /**
     * SUBMEIを取得する
     * @return SUBMEI
     */
    public String getSubMei() {
        return (String) get(TBRCMN_MEU13THSKGYBMON.SUBMEI);
    }

    /**
     * SUBMEIを設定する
     * @param val SUBMEI
     */
    public void setSubMei(String val) {
        set(TBRCMN_MEU13THSKGYBMON.SUBMEI, val);
    }

}

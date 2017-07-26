package jp.co.isid.kkh.model.login;

import jp.co.isid.kkh.integ.tbl.TBRCMN_MEU00SIK;
import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * 組織マスタVO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/02/13 JSE H.Abe)<BR>
 * </P>
 * @author JSE H.Abe
 */
public class RcmnMeu00SikVO extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /**
     * 新規インスタンスを構築します。
     */
    public RcmnMeu00SikVO() {
    }

    /**
     * 新規インスタンスを構築します。
     *
     * @return 新規インスタンス
     */
    public Object newInstance() {
        return new RcmnMeu00SikVO();
    }

    /**
     * EGSYOCDを取得する
     * @return EGSYOCD
     */
    public String getEgsyoCd() {
        return (String) get(TBRCMN_MEU00SIK.EGSYOCD);
    }

    /**
     * EGSYOCDを設定する
     * @param val EGSYOCD
     */
    public void setEgsyoCd(String val) {
        set(TBRCMN_MEU00SIK.EGSYOCD, val);
    }

    /**
     * JSIKCDを取得する
     * @return JSIKCD
     */
    public String getJSikCd() {
        return (String) get(TBRCMN_MEU00SIK.JSIKCD);
    }

    /**
     * JSIKCDを設定する
     * @param val JSIKCD
     */
    public void setJSikCd(String val) {
        set(TBRCMN_MEU00SIK.JSIKCD, val);
    }

    /**
     * KAISOCDを取得する
     * @return KAISOCD
     */
    public String getKaisoCd() {
        return (String) get(TBRCMN_MEU00SIK.KAISOCD);
    }

    /**
     * KAISOCDを設定する
     * @param val KAISOCD
     */
    public void setKaisoCd(String val) {
        set(TBRCMN_MEU00SIK.KAISOCD, val);
    }

}

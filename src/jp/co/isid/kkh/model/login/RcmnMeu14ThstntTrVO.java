package jp.co.isid.kkh.model.login;

import jp.co.isid.kkh.integ.tbl.TBRCMN_MEU07SIKKRSPRD;
import jp.co.isid.kkh.integ.tbl.TBRCMN_MEU12THSKGY;
import jp.co.isid.kkh.integ.tbl.TBRCMN_MEU13THSKGYBMON;
import jp.co.isid.kkh.integ.tbl.TBRCMN_MEU14THSTNTTR;
import jp.co.isid.kkh.integ.tbl.TBRCMN_MEU16SKUKJK;
import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * 取引先担当情報VO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/02/13 JSE H.Abe)<BR>
 * </P>
 * @author JSE H.Abe
 */
public class RcmnMeu14ThstntTrVO extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /**
     * 新規インスタンスを構築します。
     */
    public RcmnMeu14ThstntTrVO() {
    }

    /**
     * 新規インスタンスを構築します。
     *
     * @return 新規インスタンス
     */
    public Object newInstance() {
        return new RcmnMeu14ThstntTrVO();
    }

    /**
     * THSKGYCDを取得する
     * @return THSKGYCD
     */
    public String getThskgyCd() {
        return (String) get(TBRCMN_MEU14THSTNTTR.THSKGYCD);
    }

    /**
     * THSKGYCDを設定する
     * @param val THSKGYCD
     */
    public void setThskgyCd(String val) {
        set(TBRCMN_MEU14THSTNTTR.THSKGYCD, val);
    }

    /**
     * SEQNOを取得する
     * @return SEQNO
     */
    public String getSeqNo() {
        return (String) get(TBRCMN_MEU14THSTNTTR.SEQNO);
    }

    /**
     * SEQNOを設定する
     * @param val SEQNO
     */
    public void setSeqNo(String val) {
        set(TBRCMN_MEU14THSTNTTR.SEQNO, val);
    }

    /**
     * TRTNTSEQNOを取得する
     * @return TRTNTSEQNO
     */
    public String getTrtntSeqNo() {
        return (String) get(TBRCMN_MEU14THSTNTTR.TRTNTSEQNO);
    }

    /**
     * TRTNTSEQNOを設定する
     * @param val TRTNTSEQNO
     */
    public void setTrtntSeqNo(String val) {
        set(TBRCMN_MEU14THSTNTTR.TRTNTSEQNO, val);
    }

    /**
     * SIKCDを取得する
     * @return SIKCD
     */
    public String getSikCd() {
        return (String) get(TBRCMN_MEU14THSTNTTR.SIKCD);
    }

    /**
     * SIKCDを設定する
     * @param val SIKCD
     */
    public void setSikCd(String val) {
        set(TBRCMN_MEU14THSTNTTR.SIKCD, val);
    }

    /**
     * SINCDを取得する
     * @return SINCD
     */
    public String getSinCd() {
        return (String) get(TBRCMN_MEU16SKUKJK.SINCD);
    }

    /**
     * SINCDを設定する
     * @param val SINCD
     */
    public void setSinCd(String val) {
        set(TBRCMN_MEU16SKUKJK.SINCD, val);
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

    /**
     * SIKCDKYKを取得する
     * @return SIKCDKYK
     */
    public String getSikcdKyk() {
        return (String) get(TBRCMN_MEU07SIKKRSPRD.SIKCDKYK);
    }

    /**
     * SIKCDKYKを設定する
     * @param val SIKCDKYK
     */
    public void setSikcdKyk(String val) {
        set(TBRCMN_MEU07SIKKRSPRD.SIKCDKYK, val);
    }

    /**
     * SIKCDBUを取得する
     * @return SIKCDBU
     */
    public String getSikCdBu() {
        return (String) get(TBRCMN_MEU07SIKKRSPRD.SIKCDBU);
    }

    /**
     * SIKCDBUを設定する
     * @param val SIKCDBU
     */
    public void setSikCdBu(String val) {
        set(TBRCMN_MEU07SIKKRSPRD.SIKCDBU, val);
    }

    /**
     * BUHYOJIKJを取得する
     * @return BUHYOJIKJ
     */
    public String getBuHyojiKj() {
        return (String) get(TBRCMN_MEU07SIKKRSPRD.BUHYOJIKJ);
    }

    /**
     * BUHYOJIKJを設定する
     * @param val BUHYOJIKJ
     */
    public void setBuHyojiKj(String val) {
        set(TBRCMN_MEU07SIKKRSPRD.BUHYOJIKJ, val);
    }

}

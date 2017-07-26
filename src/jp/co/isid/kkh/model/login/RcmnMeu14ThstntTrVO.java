package jp.co.isid.kkh.model.login;

import jp.co.isid.kkh.integ.tbl.TBRCMN_MEU07SIKKRSPRD;
import jp.co.isid.kkh.integ.tbl.TBRCMN_MEU12THSKGY;
import jp.co.isid.kkh.integ.tbl.TBRCMN_MEU13THSKGYBMON;
import jp.co.isid.kkh.integ.tbl.TBRCMN_MEU14THSTNTTR;
import jp.co.isid.kkh.integ.tbl.TBRCMN_MEU16SKUKJK;
import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * �����S�����VO
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/02/13 JSE H.Abe)<BR>
 * </P>
 * @author JSE H.Abe
 */
public class RcmnMeu14ThstntTrVO extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     */
    public RcmnMeu14ThstntTrVO() {
    }

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     *
     * @return �V�K�C���X�^���X
     */
    public Object newInstance() {
        return new RcmnMeu14ThstntTrVO();
    }

    /**
     * THSKGYCD���擾����
     * @return THSKGYCD
     */
    public String getThskgyCd() {
        return (String) get(TBRCMN_MEU14THSTNTTR.THSKGYCD);
    }

    /**
     * THSKGYCD��ݒ肷��
     * @param val THSKGYCD
     */
    public void setThskgyCd(String val) {
        set(TBRCMN_MEU14THSTNTTR.THSKGYCD, val);
    }

    /**
     * SEQNO���擾����
     * @return SEQNO
     */
    public String getSeqNo() {
        return (String) get(TBRCMN_MEU14THSTNTTR.SEQNO);
    }

    /**
     * SEQNO��ݒ肷��
     * @param val SEQNO
     */
    public void setSeqNo(String val) {
        set(TBRCMN_MEU14THSTNTTR.SEQNO, val);
    }

    /**
     * TRTNTSEQNO���擾����
     * @return TRTNTSEQNO
     */
    public String getTrtntSeqNo() {
        return (String) get(TBRCMN_MEU14THSTNTTR.TRTNTSEQNO);
    }

    /**
     * TRTNTSEQNO��ݒ肷��
     * @param val TRTNTSEQNO
     */
    public void setTrtntSeqNo(String val) {
        set(TBRCMN_MEU14THSTNTTR.TRTNTSEQNO, val);
    }

    /**
     * SIKCD���擾����
     * @return SIKCD
     */
    public String getSikCd() {
        return (String) get(TBRCMN_MEU14THSTNTTR.SIKCD);
    }

    /**
     * SIKCD��ݒ肷��
     * @param val SIKCD
     */
    public void setSikCd(String val) {
        set(TBRCMN_MEU14THSTNTTR.SIKCD, val);
    }

    /**
     * SINCD���擾����
     * @return SINCD
     */
    public String getSinCd() {
        return (String) get(TBRCMN_MEU16SKUKJK.SINCD);
    }

    /**
     * SINCD��ݒ肷��
     * @param val SINCD
     */
    public void setSinCd(String val) {
        set(TBRCMN_MEU16SKUKJK.SINCD, val);
    }

    /**
     * THSKGYDISPKJ���擾����
     * @return THSKGYDISPKJ
     */
    public String getThskgyDispKj() {
        return (String) get(TBRCMN_MEU12THSKGY.THSKGYDISPKJ);
    }

    /**
     * THSKGYDISPKJ��ݒ肷��
     * @param val THSKGYDISPKJ
     */
    public void setThskgyDispKj(String val) {
        set(TBRCMN_MEU12THSKGY.THSKGYDISPKJ, val);
    }

    /**
     * SUBMEI���擾����
     * @return SUBMEI
     */
    public String getSubMei() {
        return (String) get(TBRCMN_MEU13THSKGYBMON.SUBMEI);
    }

    /**
     * SUBMEI��ݒ肷��
     * @param val SUBMEI
     */
    public void setSubMei(String val) {
        set(TBRCMN_MEU13THSKGYBMON.SUBMEI, val);
    }

    /**
     * SIKCDKYK���擾����
     * @return SIKCDKYK
     */
    public String getSikcdKyk() {
        return (String) get(TBRCMN_MEU07SIKKRSPRD.SIKCDKYK);
    }

    /**
     * SIKCDKYK��ݒ肷��
     * @param val SIKCDKYK
     */
    public void setSikcdKyk(String val) {
        set(TBRCMN_MEU07SIKKRSPRD.SIKCDKYK, val);
    }

    /**
     * SIKCDBU���擾����
     * @return SIKCDBU
     */
    public String getSikCdBu() {
        return (String) get(TBRCMN_MEU07SIKKRSPRD.SIKCDBU);
    }

    /**
     * SIKCDBU��ݒ肷��
     * @param val SIKCDBU
     */
    public void setSikCdBu(String val) {
        set(TBRCMN_MEU07SIKKRSPRD.SIKCDBU, val);
    }

    /**
     * BUHYOJIKJ���擾����
     * @return BUHYOJIKJ
     */
    public String getBuHyojiKj() {
        return (String) get(TBRCMN_MEU07SIKKRSPRD.BUHYOJIKJ);
    }

    /**
     * BUHYOJIKJ��ݒ肷��
     * @param val BUHYOJIKJ
     */
    public void setBuHyojiKj(String val) {
        set(TBRCMN_MEU07SIKKRSPRD.BUHYOJIKJ, val);
    }

}

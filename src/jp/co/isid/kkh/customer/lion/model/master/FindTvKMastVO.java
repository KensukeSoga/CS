package jp.co.isid.kkh.customer.lion.model.master;

import java.util.Date;

import jp.co.isid.kkh.integ.tbl.TBTHB11WLTVK;
import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * TV��VO
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/02/20 JSE A.Naito)<BR>
 * </P>
 * @author JSE A.Naito
 */
public class FindTvKMastVO extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     */
    public FindTvKMastVO() {
    }

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     *
     * @return �V�K�C���X�^���X
     */
    public Object newInstance() {
        return new FindTvMastVO();
    }

     /**
      * �o�^�^�C���X�^���v��ݒ肵�܂��B
      * @param val String �o�^�^�C��
      */
     public void setTrktimstmp(Date val) {
         set(TBTHB11WLTVK.TRKTIMSTMP, val);
     }

     /**
      * �o�^�^�C���X�^���v��Ԃ��܂��B
      * @return String �o�^�^�C��
      */
     public Date getTrktimstmp() {
         return (Date) get(TBTHB11WLTVK.TRKTIMSTMP);
     }

    /**
     * �o�^�A�v���h�c��ݒ肵�܂��B
     * @param val String �o�^�A�v���h�c
     */
    public void setTrkpl(String val) {
        set(TBTHB11WLTVK.TRKPL, val);
    }

    /**
     * �o�^�A�v���h�c��Ԃ��܂��B
     * @return String �o�^�A�v���h�c
     */
    public String getTrkpl() {
        return (String) get(TBTHB11WLTVK.TRKPL);
    }

    /**
     * �o�^�S����ݒ肵�܂��B
     * @param val String �o�^�S��
     */
    public void setTrktnt(String val) {
        set(TBTHB11WLTVK.TRKTNT, val);
    }

    /**
     * �o�^�S����Ԃ��܂��B
     * @return String �o�^�S��
     */
    public String getTrktnt() {
        return (String) get(TBTHB11WLTVK.TRKTNT);
    }

    /**
     * �X�V�^�C���X�^���v��ݒ肵�܂��B
     * @param val String �X�V�S��
     */
    public void setUpdtimstmp(Date val) {
        set(TBTHB11WLTVK.UPDTIMSTMP, val);
    }

    /**
     * �X�V�^�C���X�^���v��Ԃ��܂��B
     * @return String �X�V�S��
     */
    public Date getUpdtimstmp() {
        return (Date) get(TBTHB11WLTVK.UPDTIMSTMP);
    }

    /**
     * �X�V�A�v����ݒ肵�܂��B
     * @param val String �X�V�A�v��
     */
    public void setUpdakpl(String val) {
        set(TBTHB11WLTVK.UPDAPL, val);
    }

    /**
     * �X�V�A�v����Ԃ��܂��B
     * @return String �X�V�A�v��
     */
    public String getUpdakpl() {
        return (String) get(TBTHB11WLTVK.UPDAPL);
    }

    /**
     * �X�V�S����ݒ肵�܂��B
     * @param val String �X�V�S��
     */
    public void setUpdtnt(String val) {
        set(TBTHB11WLTVK.UPDTNT, val);
    }

    /**
     * �X�V�S����Ԃ��܂��B
     * @return String �X�V�S��
     */
    public String getUpdtnt() {
        return (String) get(TBTHB11WLTVK.UPDTNT);
    }

    /**
     * �c�Ƃ�����ݒ肵�܂��B
     * @param val String �c�Ƃ���
     */
    public void setEgcd(String val) {
        set(TBTHB11WLTVK.EGCD, val);
    }

    /**
     * �c�Ƃ�����Ԃ��܂��B
     * @return String �c�Ƃ���
     */
    public String getEgcd() {
        return (String) get(TBTHB11WLTVK.EGCD);
    }

    /**
     * ���Ӑ��ݒ肵�܂��B
     * @param val String ���Ӑ�
     */
    public void setTkskgycd(String val) {
        set(TBTHB11WLTVK.TKSKGYCD, val);
    }

    /**
     * ���Ӑ��Ԃ��܂��B
     * @return String ���Ӑ�
     */
    public String getTkskgycd() {
        return (String) get(TBTHB11WLTVK.TKSKGYCD);
    }

    /**
     * �����ݒ肵�܂��B
     * @param val String ����
     */
    public void setTksbmnseqno(String val) {
        set(TBTHB11WLTVK.TKSBMNSEQNO, val);
    }

    /**
     * �����Ԃ��܂��B
     * @return String ����
     */
    public String getTksbmnseqno() {
        return (String) get(TBTHB11WLTVK.TKSBMNSEQNO);
    }

    /**
     * �S����ݒ肵�܂��B
     * @param val String �S��
     */
    public void setTkstntseqno(String val) {
        set(TBTHB11WLTVK.TKSTNTSEQNO, val);
    }

    /**
     * �S����Ԃ��܂��B
     * @return String �S��
     */
    public String getTkstntseqno() {
        return (String) get(TBTHB11WLTVK.TKSTNTSEQNO);
    }

    /**
     * �����ǃR�[�h��ݒ肵�܂��B
     * @param val String KYOKUCD
     */
    public void setKyokuCd(String val) {
        set(TBTHB11WLTVK.KYOKUCD, val);
    }

    /**
     * �����ǃR�[�h��Ԃ��܂��B
     * @return String KYOKUCD
     */
    public String getKyokuCd() {
        return (String) get(TBTHB11WLTVK.KYOKUCD);
    }

    /**
     * �����ǖ���ݒ肵�܂��B
     * @param val String KYOKUNAME
     */
    public void setKyokuName(String val) {
        set(TBTHB11WLTVK.KYOKUNAME, val);
    }

    /**
     * �����ǖ���Ԃ��܂��B
     * @return String KYOKUNAME
     */
    public String getKyokuName() {
        return (String) get(TBTHB11WLTVK.KYOKUNAME);
    }

    /**
     * �L���i�����ǃR�[�h�j��ݒ肵�܂��B
     * @param val String KIGOU
     */
    public void setKigou(String val) {
        set(TBTHB11WLTVK.KIGOU, val);
    }

    /**
     * �L���i�����ǃR�[�h�j��Ԃ��܂��B
     * @return String KIGOU
     */
    public String getKigou() {
        return (String) get(TBTHB11WLTVK.KIGOU);
    }

    /**
     * �n���ݒ肵�܂��B
     * @param val String KEIRETSU
     */
    public void setKeiretsu(String val) {
        set(TBTHB11WLTVK.KEIRETSU, val);
    }

    /**
     * �n���Ԃ��܂��B
     * @return String KEIRETSU
     */
    public String getKeiretsu() {
        return (String) get(TBTHB11WLTVK.KEIRETSU);
    }

    /**
     * �n���ݒ肵�܂��B
     * @param val String TIKU
     */
    public void setTiku(String val) {
        set(TBTHB11WLTVK.TIKU, val);
    }

    /**
     * �n���Ԃ��܂��B
     * @return String TIKU
     */
    public String getTiku() {
        return (String) get(TBTHB11WLTVK.TIKU);
    }

    /**
     * �n��\������ݒ肵�܂��B
     * @param val String THYOJIJYUN
     */
    public void setTHyojiJyun(String val) {
        set(TBTHB11WLTVK.THYOJIJYUN, val);
    }

    /**
     * �n��\������Ԃ��܂��B
     * @return String THYOJIJYUN
     */
    public String getTHyojiJyun() {
        return (String) get(TBTHB11WLTVK.THYOJIJYUN);
    }

    /**
     * �\������ݒ肵�܂��B
     * @param val String HYOJIJYUN
     */
    public void setHyojijyun(String val) {
        set(TBTHB11WLTVK.HYOJIJYUN, val);
    }

    /**
     * �\������Ԃ��܂��B
     * @return String HYOJIJYUN
     */
    public String getHyojijyun() {
        return (String) get(TBTHB11WLTVK.HYOJIJYUN);
    }

}

package jp.co.isid.kkh.customer.lion.model.master;

import java.math.BigDecimal;
import java.util.Date;

import jp.co.isid.kkh.integ.tbl.TBTHB9WLTVB;
import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * TV�ԑgVO
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2011/12/27 JSE KT)<BR>
 * </P>
 * @author
 */
public class FindTvMastVO extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     */
    public FindTvMastVO() {
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
         set(TBTHB9WLTVB.TRKTIMSTMP, val);
     }

     /**
      * �o�^�^�C���X�^���v��Ԃ��܂��B
      * @return String �o�^�^�C��
      */
     public Date getTrktimstmp() {
         return (Date) get(TBTHB9WLTVB.TRKTIMSTMP);
     }

    /**
     * �o�^�A�v���h�c��ݒ肵�܂��B
     * @param val String �o�^�A�v���h�c
     */
    public void setTrkpl(String val) {
        set(TBTHB9WLTVB.TRKPL, val);
    }

    /**
     * �o�^�A�v���h�c��Ԃ��܂��B
     * @return String �o�^�A�v���h�c
     */
    public String getTrkpl() {
        return (String) get(TBTHB9WLTVB.TRKPL);
    }

    /**
     * �o�^�S����ݒ肵�܂��B
     * @param val String �o�^�S��
     */
    public void setTrktnt(String val) {
        set(TBTHB9WLTVB.TRKTNT, val);
    }

    /**
     * �o�^�S����Ԃ��܂��B
     * @return String �o�^�S��
     */
    public String getTrktnt() {
        return (String) get(TBTHB9WLTVB.TRKTNT);
    }

    /**
     * �X�V�^�C���X�^���v��ݒ肵�܂��B
     * @param val String �X�V�S��
     */
    public void setUpdtimstmp(Date val) {
        set(TBTHB9WLTVB.UPDTIMSTMP, val);
    }

    /**
     * �X�V�^�C���X�^���v��Ԃ��܂��B
     * @return String �X�V�S��
     */
    public Date getUpdtimstmp() {
        return (Date) get(TBTHB9WLTVB.UPDTIMSTMP);
    }

    /**
     * �X�V�A�v����ݒ肵�܂��B
     * @param val String �X�V�A�v��
     */
    public void setUpdakpl(String val) {
        set(TBTHB9WLTVB.UPDAPL, val);
    }

    /**
     * �X�V�A�v����Ԃ��܂��B
     * @return String �X�V�A�v��
     */
    public String getUpdakpl() {
        return (String) get(TBTHB9WLTVB.UPDAPL);
    }

    /**
     * �X�V�S����ݒ肵�܂��B
     * @param val String �X�V�S��
     */
    public void setUpdtnt(String val) {
        set(TBTHB9WLTVB.UPDTNT, val);
    }

    /**
     * �X�V�S����Ԃ��܂��B
     * @return String �X�V�S��
     */
    public String getUpdtnt() {
        return (String) get(TBTHB9WLTVB.UPDTNT);
    }

    /**
     * �c�Ƃ�����ݒ肵�܂��B
     * @param val String �c�Ƃ���
     */
    public void setEgcd(String val) {
        set(TBTHB9WLTVB.EGCD, val);
    }

    /**
     * �c�Ƃ�����Ԃ��܂��B
     * @return String �c�Ƃ���
     */
    public String getEgcd() {
        return (String) get(TBTHB9WLTVB.EGCD);
    }

    /**
     * ���Ӑ��ݒ肵�܂��B
     * @param val String ���Ӑ�
     */
    public void setTkskgycd(String val) {
        set(TBTHB9WLTVB.TKSKGYCD, val);
    }

    /**
     * ���Ӑ��Ԃ��܂��B
     * @return String ���Ӑ�
     */
    public String getTkskgycd() {
        return (String) get(TBTHB9WLTVB.TKSKGYCD);
    }

    /**
     * �����ݒ肵�܂��B
     * @param val String ����
     */
    public void setTksbmnseqno(String val) {
        set(TBTHB9WLTVB.TKSBMNSEQNO, val);
    }

    /**
     * �����Ԃ��܂��B
     * @return String ����
     */
    public String getTksbmnseqno() {
        return (String) get(TBTHB9WLTVB.TKSBMNSEQNO);
    }

    /**
     * �S����ݒ肵�܂��B
     * @param val String �S��
     */
    public void setTkstntseqno(String val) {
        set(TBTHB9WLTVB.TKSTNTSEQNO, val);
    }

    /**
     * �S����Ԃ��܂��B
     * @return String �S��
     */
    public String getTkstntseqno() {
        return (String) get(TBTHB9WLTVB.TKSTNTSEQNO);
    }

    /**
     * BANCD��ݒ肵�܂��B
     * @param val String BANCD
     */
    public void setBancd(String val) {
        set(TBTHB9WLTVB.BANCD, val);
    }

    /**
     * BANCD��Ԃ��܂��B
     * @return String BANCD
     */
    public String getBancd() {
        return (String) get(TBTHB9WLTVB.BANCD);
    }

    /**
     * BANNAME��ݒ肵�܂��B
     * @param val String BANNAME
     */
    public void setBanname(String val) {
        set(TBTHB9WLTVB.BANNAME, val);
    }

    /**
     * BANNAME��Ԃ��܂��B
     * @return String BANNAME
     */
    public String getBanname() {
        return (String) get(TBTHB9WLTVB.BANNAME);
    }
    /**
     * HKYOKUCD��ݒ肵�܂��B
     * @param val String HKYOKUCD
     */
    public void setHkyokucd(String val) {
        set(TBTHB9WLTVB.HKYOKUCD, val);
    }

    /**
     * HKYOKUCD��Ԃ��܂��B
     * @return String HKYOKUCD
     */
    public String getHkyokucd() {
        return (String) get(TBTHB9WLTVB.HKYOKUCD);
    }

    /**
     * ���z��ݒ肵�܂��B
     * @param val BigDecimal ���z
     */
    public void setSeisakuhi(BigDecimal val) {
        set(TBTHB9WLTVB.SEISAKUHI, val);
    }

    /**
     * ���z��Ԃ��܂��B
     * @return BigDecimal ���z
     */
    public BigDecimal getSeisakuhi() {
        return (BigDecimal) get(TBTHB9WLTVB.SEISAKUHI);
    }

    /**
     * HYOJIJYUN��ݒ肵�܂��B
     * @param val String HYOJIJYUN
     */
    public void setHyojijyun(String val) {
        set(TBTHB9WLTVB.HYOJIJYUN, val);
    }

    /**
     * HYOJIJYUN��Ԃ��܂��B
     * @return String HYOJIJYUN
     */
    public String getHyojijyun() {
        return (String) get(TBTHB9WLTVB.HYOJIJYUN);
    }

    /**
     * TANKA��ݒ肵�܂��B
     * @param val String TANKA
     */
    public void setTanka(String val) {
        set(TBTHB9WLTVB.TANKA, val);
    }

    /**
     * TANKA��Ԃ��܂��B
     * @return String TANKA
     */
    public String getTanka() {
        return (String) get(TBTHB9WLTVB.TANKA);
    }

    /**
     * TYPE2��ݒ肵�܂��B
     * @param val String TYPE2
     */
    public void setType2(String val) {
        set(TBTHB9WLTVB.TYPE2, val);
    }

    /**
     * TYPE2��Ԃ��܂��B
     * @return String TYPE2
     */
    public String getType2() {
        return (String) get(TBTHB9WLTVB.TYPE2);
    }

}

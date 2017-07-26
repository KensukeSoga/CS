package jp.co.isid.kkh.customer.lion.model.master;

import java.math.BigDecimal;
import java.util.Date;

import jp.co.isid.kkh.integ.tbl.TBTHB10WLRDB;
import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * ���W�I�ԑgVO
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/02/17 JSE A.Naito)<BR>
 * </P>
 * @author  JSE A.Naito
 */
public class FindRdMastVO extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     */
    public FindRdMastVO() {
    }

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     *
     * @return �V�K�C���X�^���X
     */
    public Object newInstance() {
        return new FindRdMastVO();
    }

     /**
      * �o�^�^�C���X�^���v��ݒ肵�܂��B
      * @param val String �o�^�^�C��
      */
     public void setTrktimstmp(Date val) {
         set(TBTHB10WLRDB.TRKTIMSTMP, val);
     }

     /**
      * �o�^�^�C���X�^���v��Ԃ��܂��B
      * @return String �o�^�^�C��
      */
     public Date getTrktimstmp() {
         return (Date) get(TBTHB10WLRDB.TRKTIMSTMP);
     }

    /**
     * �o�^�A�v���h�c��ݒ肵�܂��B
     * @param val String �o�^�A�v���h�c
     */
    public void setTrkpl(String val) {
        set(TBTHB10WLRDB.TRKPL, val);
    }

    /**
     * �o�^�A�v���h�c��Ԃ��܂��B
     * @return String �o�^�A�v���h�c
     */
    public String getTrkpl() {
        return (String) get(TBTHB10WLRDB.TRKPL);
    }

    /**
     * �o�^�S����ݒ肵�܂��B
     * @param val String �o�^�S��
     */
    public void setTrktnt(String val) {
        set(TBTHB10WLRDB.TRKTNT, val);
    }

    /**
     * �o�^�S����Ԃ��܂��B
     * @return String �o�^�S��
     */
    public String getTrktnt() {
        return (String) get(TBTHB10WLRDB.TRKTNT);
    }

    /**
     * �X�V�^�C���X�^���v��ݒ肵�܂��B
     * @param val String �X�V�S��
     */
    public void setUpdtimstmp(Date val) {
        set(TBTHB10WLRDB.UPDTIMSTMP, val);
    }

    /**
     * �X�V�^�C���X�^���v��Ԃ��܂��B
     * @return String �X�V�S��
     */
    public Date getUpdtimstmp() {
        return (Date) get(TBTHB10WLRDB.UPDTIMSTMP);
    }

    /**
     * �X�V�A�v����ݒ肵�܂��B
     * @param val String �X�V�A�v��
     */
    public void setUpdakpl(String val) {
        set(TBTHB10WLRDB.UPDAPL, val);
    }

    /**
     * �X�V�A�v����Ԃ��܂��B
     * @return String �X�V�A�v��
     */
    public String getUpdakpl() {
        return (String) get(TBTHB10WLRDB.UPDAPL);
    }

    /**
     * �X�V�S����ݒ肵�܂��B
     * @param val String �X�V�S��
     */
    public void setUpdtnt(String val) {
        set(TBTHB10WLRDB.UPDTNT, val);
    }

    /**
     * �X�V�S����Ԃ��܂��B
     * @return String �X�V�S��
     */
    public String getUpdtnt() {
        return (String) get(TBTHB10WLRDB.UPDTNT);
    }

    /**
     * �c�Ƃ�����ݒ肵�܂��B
     * @param val String �c�Ƃ���
     */
    public void setEgcd(String val) {
        set(TBTHB10WLRDB.EGCD, val);
    }

    /**
     * �c�Ƃ�����Ԃ��܂��B
     * @return String �c�Ƃ���
     */
    public String getEgcd() {
        return (String) get(TBTHB10WLRDB.EGCD);
    }

    /**
     * ���Ӑ��ݒ肵�܂��B
     * @param val String ���Ӑ�
     */
    public void setTkskgycd(String val) {
        set(TBTHB10WLRDB.TKSKGYCD, val);
    }

    /**
     * ���Ӑ��Ԃ��܂��B
     * @return String ���Ӑ�
     */
    public String getTkskgycd() {
        return (String) get(TBTHB10WLRDB.TKSKGYCD);
    }

    /**
     * �����ݒ肵�܂��B
     * @param val String ����
     */
    public void setTksbmnseqno(String val) {
        set(TBTHB10WLRDB.TKSBMNSEQNO, val);
    }

    /**
     * �����Ԃ��܂��B
     * @return String ����
     */
    public String getTksbmnseqno() {
        return (String) get(TBTHB10WLRDB.TKSBMNSEQNO);
    }

    /**
     * �S����ݒ肵�܂��B
     * @param val String �S��
     */
    public void setTkstntseqno(String val) {
        set(TBTHB10WLRDB.TKSTNTSEQNO, val);
    }

    /**
     * �S����Ԃ��܂��B
     * @return String �S��
     */
    public String getTkstntseqno() {
        return (String) get(TBTHB10WLRDB.TKSTNTSEQNO);
    }

    /**
     * BANCD��ݒ肵�܂��B
     * @param val String BANCD
     */
    public void setBancd(String val) {
        set(TBTHB10WLRDB.BANCD, val);
    }

    /**
     * BANCD��Ԃ��܂��B
     * @return String BANCD
     */
    public String getBancd() {
        return (String) get(TBTHB10WLRDB.BANCD);
    }

    /**
     * BANNAME��ݒ肵�܂��B
     * @param val String BANNAME
     */
    public void setBanname(String val) {
        set(TBTHB10WLRDB.BANNAME, val);
    }

    /**
     * BANNAME��Ԃ��܂��B
     * @return String BANNAME
     */
    public String getBanname() {
        return (String) get(TBTHB10WLRDB.BANNAME);
    }
    /**
     * HKYOKUCD��ݒ肵�܂��B
     * @param val String HKYOKUCD
     */
    public void setHkyokucd(String val) {
        set(TBTHB10WLRDB.HKYOKUCD, val);
    }

    /**
     * HKYOKUCD��Ԃ��܂��B
     * @return String HKYOKUCD
     */
    public String getHkyokucd() {
        return (String) get(TBTHB10WLRDB.HKYOKUCD);
    }

    /**
     * ���z��ݒ肵�܂��B
     * @param val BigDecimal ���z
     */
    public void setSeisakuhi(BigDecimal val) {
        set(TBTHB10WLRDB.SEISAKUHI, val);
    }

    /**
     * ���z��Ԃ��܂��B
     * @return BigDecimal ���z
     */
    public BigDecimal getSeisakuhi() {
      return (BigDecimal) get(TBTHB10WLRDB.SEISAKUHI);
    }

    /**
     * HYOJIJYUN��ݒ肵�܂��B
     * @param val String HYOJIJYUN
     */
    public void setHyojijyun(String val) {
        set(TBTHB10WLRDB.HYOJIJYUN, val);
    }

    /**
     * HYOJIJYUN��Ԃ��܂��B
     * @return String HYOJIJYUN
     */
    public String getHyojijyun() {
        return (String) get(TBTHB10WLRDB.HYOJIJYUN);
    }

    /**
     * TANKA��ݒ肵�܂��B
     * @param val String TANKA
     */
    public void setTanka(String val) {
        set(TBTHB10WLRDB.TANKA, val);
    }

    /**
     * TANKA��Ԃ��܂��B
     * @return String TANKA
     */
    public String getTanka() {
        return (String) get(TBTHB10WLRDB.TANKA);
    }

    /**
     * TYPE2��ݒ肵�܂��B
     * @param val String TYPE2
     */
    public void setType2(String val) {
        set(TBTHB10WLRDB.TYPE2, val);
    }

    /**
     * TYPE2��Ԃ��܂��B
     * @return String TYPE2
     */
    public String getType2() {
        return (String) get(TBTHB10WLRDB.TYPE2);
    }

}

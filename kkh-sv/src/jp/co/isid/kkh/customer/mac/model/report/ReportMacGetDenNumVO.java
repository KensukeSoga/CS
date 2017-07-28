package jp.co.isid.kkh.customer.mac.model.report;

import java.math.BigDecimal;

import jp.co.isid.kkh.integ.tbl.TBTHBAMST;
import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * ���[�iMAC)VO
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2011/12/27 JSE KT)<BR>
 * </P>
 * @author
 */
public class ReportMacGetDenNumVO extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     */
    public ReportMacGetDenNumVO() {
    }

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     *
     * @return �V�K�C���X�^���X
     */
    public Object newInstance() {
        return new ReportMacGetDenNumVO();
    }

     /**
      * �`�[�ԍ���ݒ肵�܂��B
      * @param val String �`�[�ԍ�
      */
     public void setDenNum(String val) {
         set(TBTHBAMST.FIELD1, val);
     }

     /**
      * �`�[�ԍ���Ԃ��܂��B
      * @return String �`�[�ԍ�
      */
     public String getDenNum() {
         return (String) get(TBTHBAMST.FIELD1);
     }

     /**
      * �`�[�ԍ������ݒ肵�܂��B
      * @param val String �`�[�ԍ����
      */
     public void setDenNumMax(String val) {
         set(TBTHBAMST.FIELD2, val);
     }

     /**
      * �`�[�ԍ������Ԃ��܂��B
      * @return String �`�[�ԍ����
      */
     public String getDenNumMax() {
         return (String) get(TBTHBAMST.FIELD2);
     }

     /**
      * �����R�[�h��ݒ肵�܂��B
      * @param val String �����R�[�h
      */
     public void setTrhskCd(String val) {
         set(TBTHBAMST.FIELD3, val);
     }

     /**
      * �����R�[�h��Ԃ��܂��B
      * @return String �����R�[�h
      */
     public String getTrhskCd() {
         return (String) get(TBTHBAMST.FIELD3);
     }

     /**
      *
      * �d�b�ԍ���ݒ肵�܂��B
      * @param val String �d�b�ԍ�
      */
     public void setTelNo(String val) {
         set(TBTHBAMST.FIELD4, val);
     }

     /**
      * �d�b�ԍ���Ԃ��܂��B
      * @return String �d�b�ԍ�
      */
     public String getTelNo() {
         return (String) get(TBTHBAMST.FIELD4);
     }

     /**
      * �A����Z����ݒ肵�܂��B
      * @param val String �A����Z��
      */
     public void setAddress(String val) {
         set(TBTHBAMST.FIELD5, val);
     }

     /**
      * �A����Z����Ԃ��܂��B
      * @return String �A����Z��
      */
     public String getAddress() {
         return (String) get(TBTHBAMST.FIELD5);
     }

     /**
      * �`�[�����l��ݒ肵�܂��B
      * @param val String �`�[�����l
      */
     public void setSetDenpyo(String val) {
         set(TBTHBAMST.FIELD6, val);
     }

     /**
      * �`�[�����l��Ԃ��܂��B
      * @return String �`�[�����l
      */
     public String getSetDenpyo() {
         return (String) get(TBTHBAMST.FIELD6);
     }

     /**
      * ���x�������l��ݒ肵�܂��B
      * @param val String ���x�������l
      */
     public void setSetLabel(String val) {
         set(TBTHBAMST.FIELD7, val);
     }

     /**
      * ���x�������l��Ԃ��܂��B
      * @return String ���x�������l
      */
     public String getSetLabel() {
         return (String) get(TBTHBAMST.FIELD7);
     }

     /**
      * ����ł�ݒ肵�܂��B
      * @param val String �����
      */
     public void setComTax(BigDecimal val) {
         set(TBTHBAMST.INTVALUE2, val);
     }

     /**
      * ����ł�Ԃ��܂��B
      * @return String �����
      */
     public BigDecimal getComTax() {
         return (BigDecimal) get(TBTHBAMST.INTVALUE2);
     }

}

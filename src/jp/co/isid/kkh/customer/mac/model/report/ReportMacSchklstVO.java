package jp.co.isid.kkh.customer.mac.model.report;

import java.math.BigDecimal;

import jp.co.isid.kkh.integ.tbl.TBTHB2KMEI;
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
public class ReportMacSchklstVO extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     */
    public ReportMacSchklstVO() {
    }

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     *
     * @return �V�K�C���X�^���X
     */
    public Object newInstance() {
        return new ReportMacSchklstVO();
    }

    /**
     * ������ݒ肵�܂��B
     * @param val String ����
     */
    public void setSeiGak(BigDecimal val) {
        set(TBTHB2KMEI.SEIGAK, val);
    }

    /**
     * ������Ԃ��܂��B
     * @return String ����
     */
    public BigDecimal getSeiGak() {
        return (BigDecimal) get(TBTHB2KMEI.SEIGAK);
    }


    /**
     * CODE2��ݒ肵�܂��B
     * @param val String CODE2
     */
    public void setCode2(String val) {
        set(TBTHB2KMEI.CODE2, val);
    }

    /**
     * CODE2��Ԃ��܂��B
     * @return String CODE2
     */
    public String getCode2() {
        return (String) get(TBTHB2KMEI.CODE2);
    }

    /**
     * CODE4��ݒ肵�܂��B
     * @param val String CODE4
     */
    public void setCode4(String val) {
        set(TBTHB2KMEI.CODE4, val);
    }

    /**
     * CODE4��Ԃ��܂��B
     * @return String CODE4
     */
    public String getCode4() {
        return (String) get(TBTHB2KMEI.CODE4);
    }

    /**
     * NAME1��ݒ肵�܂��B
     * @param val String NAME1
     */
    public void setName1(String val) {
        set(TBTHB2KMEI.NAME1, val);
    }

    /**
     * NAME1��Ԃ��܂��B
     * @return String NAME1
     */
    public String getName1() {
        return (String) get(TBTHB2KMEI.NAME1);
    }

    /**
     * NAME2��ݒ肵�܂��B
     * @param val String NAME2
     */
    public void setName2(String val) {
        set(TBTHB2KMEI.NAME2, val);
    }

    /**
     * NAME2��Ԃ��܂��B
     * @return String NAME2
     */
    public String getName2() {
        return (String) get(TBTHB2KMEI.NAME2);
    }

    /**
     * NAME5��ݒ肵�܂��B
     * @param val String NAME5
     */
    public void setName5(String val) {
        set(TBTHB2KMEI.NAME5, val);
    }

    /**
     * NAME5��Ԃ��܂��B
     * @return String NAME5
     */
    public String getName5() {
        return (String) get(TBTHB2KMEI.NAME5);
    }

    /**
     * NAME4��ݒ肵�܂��B
     * @param val String NAME5
     */
    public void setName4(String val) {
        set(TBTHB2KMEI.NAME4, val);
    }

    /**
     * NAME4��Ԃ��܂��B
     * @return String NAME5
     */
    public String getName4() {
        return (String) get(TBTHB2KMEI.NAME4);
    }

     /**
      * ��NO��ݒ肵�܂��B
      * @param val String ��NO
      */
     public void setJyutNo(String val) {
         set(TBTHB2KMEI.JYUTNO, val);
     }

     /**
      * ��NO��Ԃ��܂��B
      * @return String ��NO
      */
     public String getJyutNo() {
         return (String) get(TBTHB2KMEI.JYUTNO);
     }

    /**
     * �󒍖���NO��ݒ肵�܂��B
     * @param val String �󒍖���NO
     */
    public void setJyMeiNo(String val) {
        set(TBTHB2KMEI.JYMEINO, val);
    }

    /**
     * �󒍖���NO��Ԃ��܂��B
     * @return String �󒍖���NO
     */
    public String getJyMeiNo() {
        return (String) get(TBTHB2KMEI.JYMEINO);
    }

    /**
     * ���㖾��NO��ݒ肵�܂��B
     * @param val String ���㖾��NO
     */
    public void setUrMeiNo(String val) {
        set(TBTHB2KMEI.URMEINO, val);
    }

    /**
     * ���㖾��NO��Ԃ��܂��B
     * @return String ���㖾��NO
     */
    public String getUrMeiNo() {
        return (String) get(TBTHB2KMEI.URMEINO);
    }

}

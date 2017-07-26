package jp.co.isid.kkh.customer.toh.model.report;

import java.math.BigDecimal;

import jp.co.isid.kkh.integ.tbl.TBTHB2KMEI;
import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * ���[�iTOH)VO
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/02/22 JSE T.Kobayashi)<BR>
 * </P>
 * @author
 */
public class ReportTohTotalVO extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     */
    public ReportTohTotalVO() {
    }

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     *
     * @return �V�K�C���X�^���X
     */
    public Object newInstance() {
        return new ReportTohTotalVO();
    }

    /**
     * �N����ݒ肵�܂��B
     * @param val String ��NO
     */
    public void setYYMM(String val) {
        set(TBTHB2KMEI.YYMM, val);
    }

    /**
     * �N����Ԃ��܂��B
     * @return String ��NO
     */
    public String getYYMM() {
        return (String) get(TBTHB2KMEI.YYMM);
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
     * �}�̖���ݒ肵�܂��B
     * @param val String �}�̖�
     */
    public void setName2(String val) {
        set(TBTHB2KMEI.NAME2, val);
    }

    /**
     * �}�̖���Ԃ��܂��B
     * @return String �}�̖�
     */
    public String getName2() {
        return (String) get(TBTHB2KMEI.NAME2);
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
     * �X�y�[�X2��ݒ肵�܂��B
     * @param val String �X�y�[�X2
     */
    public void setName11(String val) {
        set(TBTHB2KMEI.NAME11, val);
    }

    /**
     * �X�y�[�X2��Ԃ��܂��B
     * @return String �X�y�[�X2
     */
    public String getName11() {
        return (String) get(TBTHB2KMEI.NAME11);
    }

    /**
     * �X�y�[�X2�i�g�j��ݒ肵�܂��B
     * @param val String �X�y�[�X2�i�g�j
     */
    public void setName11wak(String val) {
        set("HB2_NAME11WAK", val);
    }

    /**
     * �X�y�[�X2�i�g�j��Ԃ��܂��B
     * @return String �X�y�[�X2�i�g�j
     */
    public String getName11wak() {
        return (String) get("HB2_NAME11WAK");
    }

    /**
     * �g�t���O��ݒ肵�܂��B
     * @param val String �g�t���O
     */
     public void setName12(String val) {
         set(TBTHB2KMEI.NAME12, val);
     }

     /**
      * �g�t���O��Ԃ��܂��B
      * @return String �g�t���O
      */
     public String getName12() {
         return (String) get(TBTHB2KMEI.NAME12);
     }

}

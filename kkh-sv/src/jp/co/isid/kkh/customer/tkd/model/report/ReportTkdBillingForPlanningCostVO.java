package jp.co.isid.kkh.customer.tkd.model.report;

import java.math.BigDecimal;

import jp.co.isid.kkh.integ.tbl.TBTHB1DOWN;
import jp.co.isid.kkh.integ.tbl.TBTHB2KMEI;
import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * ���c�������ׁi����j�擾VO
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/01/23 JSE Hitoshi Sasaki)<BR>
 * </P>
 *
 * @author JSE Hitoshi Sasaki
 */
public class ReportTkdBillingForPlanningCostVO extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /** �i�ڃR�[�h */
    public static final String SCD = "SCD";

    /** �i�ږ� */
    public static final String SNM = "SNM";

    /** �c�[���� */
    public static final String TEKIYO = "TEKIYO";

    /** �敪 */
    public static final String KBN = "KBN";

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     */
    public ReportTkdBillingForPlanningCostVO() {
    }

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     *
     * @return �V�K�C���X�^���X
     */
    public Object newInstance() {
        return new ReportTkdBillingForPlanningCostVO();
    }

    /**
     * JYUT�ԍ���ݒ肷��
     *
     * @param val
     *            JYUT�ԍ�
     */
    public void setJYUTNO(String val) {
        set(TBTHB2KMEI.JYUTNO, val);
    }

    /**
     * JYUT�ԍ����擾����
     *
     * @return JYUT�ԍ�
     */
    public String getJYUTNO() {
        return (String) get(TBTHB2KMEI.JYUTNO);
    }

    /**
     * JYMEI�ԍ���ݒ肷��
     *
     * @param val
     *            JYMEI�ԍ�
     */
    public void setJYMEINO(String val) {
        set(TBTHB2KMEI.JYMEINO, val);
    }

    /**
     * JYMEI�ԍ����擾����
     *
     * @return JYMEI�ԍ�
     */
    public String getJYMEINO() {
        return (String) get(TBTHB2KMEI.JYMEINO);
    }

    /**
     * URMEI�ԍ���ݒ肷��
     *
     * @param val
     *            URMEI�ԍ�
     */
    public void setURMEINO(String val) {
        set(TBTHB2KMEI.URMEINO, val);
    }

    /**
     * URMEI�ԍ����擾����
     *
     * @return URMEI�ԍ�
     */
    public String getURMEINO() {
        return (String) get(TBTHB2KMEI.URMEINO);
    }

    /**
     * ���z��ݒ肷��
     *
     * @param val
     *            ���z
     */
    public void setKNGK1(BigDecimal val) {
        set(TBTHB2KMEI.KNGK1, val);
    }

    /**
     * ���z���擾����
     *
     * @return ���z
     */
    public BigDecimal getKNGK1() {
        return (BigDecimal) get(TBTHB2KMEI.KNGK1);
    }

    /**
     * �i�ڃR�[�h��ݒ肷��
     *
     * @param val
     *            �i�ڃR�[�h
     */
    public void setSCD(String val) {
        set(SCD, val);
    }

    /**
     * �i�ڃR�[�h���擾����
     *
     * @return �i�ڃR�[�h
     */
    public String getSCD() {
        return (String) get(SCD);
    }

    /**
     * �i�ږ���ݒ肷��
     *
     * @param val
     *            �i�ږ�
     */
    public void setSNM(String val) {
        set(SNM, val);
    }

    /**
     * �i�ږ����擾����
     *
     * @return �i�ږ�
     */
    public String getSNM() {
        return (String) get(SNM);
    }

    /**
     * �c�[������ݒ肷��
     *
     * @param val
     *            �c�[����
     */
    public void setTEKIYO(String val) {
        set(TEKIYO, val);
    }

    /**
     * �c�[�������擾����
     *
     * @return �c�[����
     */
    public String getTEKIYO() {
        return (String) get(TEKIYO);
    }

    /**
     * �敪��ݒ肷��
     *
     * @param val
     *            �敪
     */
    public void setKBN(String val) {
        set(KBN, val);
    }

    /**
     * �敪���擾����
     *
     * @return �敪
     */
    public String getKBN() {
        return (String) get(KBN);
    }

    /**
     * �{�̊z��ݒ肷��
     *
     * @param val
     *            �{�̊z
     */
    public void setSEIGAK(BigDecimal val) {
        set(TBTHB2KMEI.SEIGAK, val);
    }

    /**
     * �{�̊z���擾����
     *
     * @return �{�̊z
     */
    public BigDecimal getSEIGAK() {
        return (BigDecimal) get(TBTHB2KMEI.SEIGAK);
    }

    /**
     * ����ŗ���ݒ肷��
     *
     * @param val
     *            ����ŗ�
     */
    public void setSZEIRITU(BigDecimal val) {
        set(TBTHB1DOWN.SZEIRITU, val);
    }

    /**
     * ����ŗ����擾����
     *
     * @return ����ŗ�
     */
    public BigDecimal getSZEIRITU() {
        return (BigDecimal) get(TBTHB1DOWN.SZEIRITU);
    }

}

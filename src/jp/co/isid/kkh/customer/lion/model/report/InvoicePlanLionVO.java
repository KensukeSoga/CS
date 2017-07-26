package jp.co.isid.kkh.customer.lion.model.report;

import java.math.BigDecimal;

import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * ���C�I���������\��\��������VO
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2014/07/31 HLC S.Fujimoto)<BR>
 * </P>
 *
 * @author HLC S.Fujimoto
 */
public class InvoicePlanLionVO extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /** ��No */
    public static final String JYUTNO = "JYUTNO";
    /** �󒍖���No */
    public static final String JYMEINO = "JYMEINO";
    /** ���㖾��No */
    public static final String URMEINO = "URMEINO";
    /** �u�����h�R�[�h */
    public static final String BRDCD = "BRDCD";
    /** �u�����h�� */
    public static final String BRDNM = "BRDNM";
    /** ���� */
    public static final String KENNM = "KENNM";
    /** �������z */
    public static final String SEIGAK = "SEIGAK";
    /** �}�̋敪�R�[�h */
    public static final String BAITAIKBN = "BAITAIKBN";
    /** �}�̋敪�� */
    public static final String BAITAINM = "BAITAINM";

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     */
    public InvoicePlanLionVO() {
    }

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     * @return �V�K�C���X�^���X
     */
    public Object newInstance() {
        return new InvoicePlanLionVO();
    }

    /** ��No���擾����
     * @return ��No
     */
    public String getJyutno() {
        return (String) get(JYUTNO);
    }

    /**
     * ��No��ݒ肷��
     * @param val String ��No
     */
    public void setJyutno(String val) {
        set(JYUTNO, val);
    }

    /**
     * �󒍖���No���擾����
     * @return �󒍖���No
     */
    public String getJymeino() {
        return (String) get(JYMEINO);
    }

    /**
     * �󒍖���No��ݒ肷��
     * @param val String �󒍖���No
     */
    public void setJymeino(String val) {
        set(JYMEINO, val);
    }

    /**
     * ���㖾��No���擾����
     * @return ���㖾��No
     */
    public String getUrmeino() {
        return (String) get(URMEINO);
    }

    /**
     * ���㖾��No��ݒ肷��
     * @param val String ���㖾��No
     */
    public void setUrmeino(String val) {
        set(URMEINO, val);
    }

    /**
     * �u�����h�R�[�h���擾����
     * @return �u�����h�R�[�h
     */
    public String getBrdCd() {
        return (String) get(BRDCD);
    }

    /**
     * �u�����h�R�[�h��ݒ肷��
     * @param val String �u�����h�R�[�h
     */
    public void setBrdCd(String val) {
        set(BRDCD, val);
    }

    /**
     * �u�����h�����擾����
     * @return �u�����h��
     */
    public String getBrdNm() {
        return (String) get(BRDNM);
    }

    /**
     * �u�����h����ݒ肷��
     * @param val String �u�����h��
     */
    public void setBrdNm(String val) {
        set(BRDNM, val);
    }

    /**
     * �������擾����
     * @return ����
     */
    public String getKenNm() {
        return (String) get(KENNM);
    }

    /**
     * ������ݒ肷��
     * @param val String ����
     */
    public void setKenNm(String val) {
        set(KENNM, val);
    }

    /**
     * �������z���擾����
     * @return �������z
     */
    public BigDecimal getSeigak() {
        return (BigDecimal) get(SEIGAK);
    }

    /**
     * �������z��ݒ肷��
     * @param val BigDecimal �������z
     */
    public void setSeigak(BigDecimal val) {
        set(SEIGAK, val);
    }

    /**
     * �}�̋敪�R�[�h���擾����
     * @return �}�̋敪
     */
    public String getBaitaiKbn() {
        return (String) get(BAITAIKBN);
    }

    /**
     * �}�̋敪�R�[�h��ݒ肷��
     * @param val String �}�̋敪
     */
    public void setBaitaiKbn(String val) {
        set(BAITAIKBN, val);
    }

    /**
     * �}�̋敪�����擾����
     * @return �}�̋敪��
     */
    public String getBaitaiNm() {
        return (String) get(BAITAINM);
    }

    /**
     * �}�̋敪����ݒ肷��
     * @param val String �}�̋敪��
     */
    public void setBaitaiNm(String val) {
        set(BAITAINM, val);
    }

}
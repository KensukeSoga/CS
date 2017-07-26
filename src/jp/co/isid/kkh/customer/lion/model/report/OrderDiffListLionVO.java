package jp.co.isid.kkh.customer.lion.model.report;

import java.math.BigDecimal;

import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * ���C�I���󒍍��وꗗ��������VO
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2014/11/10 HLC S.Fujimoto)<BR>
 * </P>
 *
 * @author HLC S.Fujimoto
 */
public class OrderDiffListLionVO extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /** ��No */
    public static final String JYUTNO = "JYUTNO";
    /** �󒍖���No */
    public static final String JYMEINO = "JYMEINO";
    /** ���㖾��No */
    public static final String URMEINO = "URMEINO";
    /** ���� */
    public static final String KKNAMEKJ = "KKNAMEKJ";
    /** �Ɩ��敪�R�[�h */
    public static final String GYOMKBN = "GYOMKBN";
    /** �Ɩ��敪�� */
    public static final String GYOMKBNKJ = "GYOMKBNKJ";
    /** ��ڃR�[�h */
    public static final String HIMKCD = "HIMKCD";
    /** ��ږ��� */
    public static final String HIMKNMKJ = "HIMKNMKJ";
    /** �}�̋敪 */
    public static final String BAITAIKBN = "BAITAIKBN";
    /** �u�����h�R�[�h */
    public static final String BRANDCD = "BRANDCD";
    /** �u�����h���� */
    public static final String BRANDNM = "BRANDNM";
    /** �旿�� */
    public static final String TORIGAK = "TORIGAK";
    /** �l�����z */
    public static final String NEBIGAK = "NEBIGAK";
    /** �������z */
    public static final String SEIGAK = "SEIGAK";
    /** ����Ŋz */
    public static final String SZEIGAK = "SZEIGAK";
    /** ���׍��v�������z */
    public static final String SEIGAK2 = "SEIGAK2";
    /** ���׍��v����Ŋz */
    public static final String SZEIGAK2 = "SZEIGAK2";
    /** SEQ */
    public static final String SEQ = "SEQ";

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     */
    public OrderDiffListLionVO() {
    }

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     * @return �V�K�C���X�^���X
     */
    public Object newInstance() {
        return new OrderDiffListLionVO();
    }

    /** ��No���擾����
     * @return String ��No
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
     * @return String �󒍖���No
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
     * @return String ���㖾��No
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
     * �������擾����
     * @return String ����
     */
    public String getKknamekj() {
        return (String) get(KKNAMEKJ);
    }

    /**
     * ������ݒ肷��
     * @param val String ����
     */
    public void setKknamekj(String val) {
        set(KKNAMEKJ, val);
    }

    /**
     * �Ɩ��敪�R�[�h���擾����
     * @return String �Ɩ��敪�R�[�h
     */
    public String getGyomkbn() {
        return (String) get(GYOMKBN);
    }

    /**
     * �Ɩ��敪�R�[�h��ݒ肷��
     * @param val String �Ɩ��敪�R�[�h
     */
    public void setGyomkbn(String val) {
        set(GYOMKBN, val);
    }

    /**
     * �Ɩ��敪���̂��擾����
     * @return String �Ɩ��敪����
     */
    public String getGyomkbnkj() {
        return (String) get(GYOMKBNKJ);
    }

    /**
     * �Ɩ��敪���̂�ݒ肷��
     * @param val String �Ɩ��敪����
     */
    public void setGyomkbnkj(String val) {
        set(GYOMKBNKJ, val);
    }

    /**
     * ��ڃR�[�h���擾����
     * @return String ��ڃR�[�h
     */
    public String getHimkcd() {
        return (String) get(HIMKCD);
    }

    /**
     * ��ڃR�[�h��ݒ肷��
     * @param val String ��ڃR�[�h
     */
    public void setHimkcd(String val) {
        set(HIMKCD, val);
    }

    /**
     * ��ږ��̂��擾����
     * @return String ��ږ���
     */
    public String getHimknmkj() {
        return (String) get(HIMKNMKJ);
    }

    /**
     * ��ږ��̂�ݒ肷��
     * @param val String ��ږ���
     */
    public void setHimknmkj(String val) {
        set(HIMKNMKJ, val);
    }

    /**
     * �}�̋敪���擾����
     * @return String �}�̋敪
     */
    public String getBaitaikbn() {
        return (String) get(BAITAIKBN);
    }

    /**
     * �}�̋敪��ݒ肷��
     * @param val String �}�̋敪
     */
    public void setBaitaikbn(String val) {
        set(BAITAIKBN, val);
    }

    /**
     * �u�����h�R�[�h���擾����
     * @return String �u�����h�R�[�h
     */
    public String getBrandcd() {
        return (String) get(BRANDCD);
    }

    /**
     * �u�����h�R�[�h��ݒ肷��
     * @param val String �u�����h�R�[�h
     */
    public void setBrandcd(String val) {
        set(BRANDCD, val);
    }

    /**
     * �u�����h���̂��擾����
     * @return String �u�����h����
     */
    public String getBrandnm() {
        return (String) get(BRANDNM);
    }

    /**
     * �u�����h���̂�ݒ肷��
     * @param val String �u�����h����
     */
    public void setBrandnm(String val) {
        set(BRANDNM, val);
    }

    /**
     * �旿�����擾����
     * @return BigDecimal �旿��
     */
    public BigDecimal getTorigak() {
        return (BigDecimal) get(TORIGAK);
    }

    /**
     * �旿����ݒ肷��
     * @param val BigDecimal �旿��
     */
    public void setTorigak(BigDecimal val) {
        set(TORIGAK, val);
    }

    /**
     * �l�����z���擾����
     * @return BigDecimal �l�����z
     */
    public BigDecimal getNebigak() {
        return (BigDecimal) get(NEBIGAK);
    }

    /**
     * �l�����z��ݒ肷��
     * @param val BigDecimal �l�����z
     */
    public void setNebigak(BigDecimal val) {
        set(NEBIGAK, val);
    }

    /**
     * �������z���擾����
     * @return BigDecimal �������z
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
     * ����Ŋz���擾����
     * @return BigDecimal ����Ŋz
     */
    public BigDecimal getSzeigak() {
        return (BigDecimal) get(SZEIGAK);
    }

    /**
     * ����Ŋz��ݒ肷��
     * @param val BigDecimal ����Ŋz
     */
    public void setSzeigak(BigDecimal val) {
        set(SZEIGAK, val);
    }

    /**
     * ���׍��v�������z���擾����
     * @return BigDecimal ���׍��v�������z
     */
    public BigDecimal getSeigak2() {
        return (BigDecimal) get(SEIGAK2);
    }

    /**
     * ���׍��v�������z��ݒ肷��
     * @param val BigDecimal ���׍��v�������z
     */
    public void setSeigak2(BigDecimal val) {
        set(SEIGAK2, val);
    }

    /**
     * ���׍��v����Ŋz���擾����
     * @return BigDecimal ���׍��v����Ŋz
     */
    public BigDecimal getSzeigak2() {
        return (BigDecimal) get(SZEIGAK2);
    }

    /**
     * ���׍��v����Ŋz��ݒ肷��
     * @param val BigDecimal ���׍��v����Ŋz
     */
    public void setSzeigak2(BigDecimal val) {
        set(SZEIGAK2, val);
    }

    /**
     * SEQ���擾����
     * @return String SEQ
     */
    public String getSeq() {
        return (String) get(SEQ);
    }

    /**
     * SEQ��ݒ肷��
     * @param val String SEQ
     */
    public void setSeq(String val) {
        set(SEQ, val);
    }

}

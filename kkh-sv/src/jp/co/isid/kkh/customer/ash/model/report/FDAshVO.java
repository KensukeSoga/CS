package jp.co.isid.kkh.customer.ash.model.report;

import java.math.BigDecimal;





import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * �����f�[�^�ꗗVO
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * </P>
 * @author
 */
public class FDAshVO extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     */
    public FDAshVO() {
    }

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     * @return �V�K�C���X�^���X
     */
    public Object newInstance() {
        return new FDAshVO();
    }

    /**
     * �������ԍ����擾����
     * @return �������ԍ�
     */
    public String getSeikyuno() {
        return (String) get("SEIKYUNO");
    }

    /**
     * �������ԍ���ݒ肷��
     * @param val String �������ԍ�
     */
    public void setSeikyuno(String val) {
        set("SEIKYUNO", val);
    }

    /**
     * �}�̃R�[�h���擾����
     * @return �}�̃R�[�h
     */
    public String getBaitaicd() {
        return (String) get("BAITAICD");
    }

    /**
     * �}�̃R�[�h��ݒ肷��
     * @param val String �}�̃R�[�h
     */
    public void setBaitaicd(String val) {
        set("BAITAICD", val);
    }

    /**
     * �������z�i����ł���j���擾����
     * @return �������z�i����ł���j
     */
    public BigDecimal getSeikyukinzeiari() {
        return (BigDecimal) get("SEIKYUKINZEIARI");
    }

    /**
     * �������z�i����ł���j��ݒ肷��
     * @param val BigDecimal �������z�i����ł���j
     */
    public void setSeikyukinzeiari(BigDecimal val) {
        set("SEIKYUKINZEIARI", val);
    }

    /**
     * �������z�i����łȂ��j���擾����
     * @return �������z�i����łȂ��j
     */
    public BigDecimal getSeikyukinzeinashi() {
        return (BigDecimal) get("SEIKYUKINZEINASHI");
    }

    /**
     * �������z�i����łȂ��j��ݒ肷��
     * @param val BigDecimal �������z�i����łȂ��j
     */
    public void setSeikyukinzeinashi(BigDecimal val) {
        set("SEIKYUKINZEINASHI", val);
    }

    /**
     * �ǃR�[�h���擾����
     * @return �ǃR�[�h
     */
    public String getKyokucd() {
        return (String) get("KYOKUCD");
    }

    /**
     * �ǃR�[�h��ݒ肷��
     * @param val String �ǃR�[�h
     */
    public void setKyokucd(String val) {
        set("KYOKUCD", val);
    }

    /**
     * �i��R�[�h���擾����
     * @return �i��R�[�h
     */
    public String getHinsyucd() {
        return (String) get("HINSYUCD");
    }

    /**
     * �i��R�[�h��ݒ肷��
     * @param val String �i��R�[�h
     */
    public void setHinsyucd(String val) {
        set("HINSYUCD", val);
    }

    /**
     * �㗝�X�R�[�h���擾����
     * @return �㗝�X�R�[�h
     */
    public String getDairitencd() {
        return (String) get("DAIRITENCD");
    }

    /**
     * �㗝�X�R�[�h��ݒ肷��
     * @param val String �㗝�X�R�[�h
     */
    public void setDairitencd(String val) {
        set("DAIRITENCD", val);
    }

    /**
     * �ԑg�R�[�h���擾����
     * @return �ԑg�R�[�h
     */
    public String getBangumicd() {
        return (String) get("BANGUMICD");
    }

    /**
     * �ԑg�R�[�h��ݒ肷��
     * @param val String �ԑg�R�[�h
     */
    public void setBangumicd(String val) {
        set("BANGUMICD", val);
    }

    /**
     * �������擾����
     * @return ����
     */
    public String getKenmei() {
        return (String) get("KENMEI");
    }

    /**
     * ������ݒ肷��
     * @param val String ����
     */
    public void setKenmei(String val) {
        set("KENMEI", val);
    }

    /**
     * �������z���擾����
     * @return �������z
     */
    public BigDecimal getSeikyukin() {
        return (BigDecimal) get("SEIKYUKIN");
    }

    /**
     * �������z��ݒ肷��
     * @param val BigDecimcal �������z
     */
    public void setSeikyukin(BigDecimal val) {
        set("SEIKYUKIN", val);
    }

    /**
     * ����ŗ����擾����
     * @return ����ŗ�
     */
    public BigDecimal getShohizeiritu() {
        return (BigDecimal) get("SHOHIZEIRITU");
    }

    /**
     * ����ŗ���ݒ肷��
     * @param val BigDecimal ����ŗ�
     */
    public void setShohizeiritu(BigDecimal val) {
        set("SHOHIZEIRITU", val);
    }

}
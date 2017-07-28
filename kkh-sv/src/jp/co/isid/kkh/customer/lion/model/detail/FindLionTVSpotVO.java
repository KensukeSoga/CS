package jp.co.isid.kkh.customer.lion.model.detail;

import java.math.BigDecimal;
import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * ���C�I��TVSpot�f�[�^�擾VO
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/03/05 JSE Hitoshi Sasaki)<BR>
 * </P>
 *
 * @author JSE Hitoshi Sasaki
 */
public class FindLionTVSpotVO extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /** �W���u�ԍ� */
    public static final String JOB_NO = "JOB_NO";

    /** �_�� */
    public static final String CONTRA_NAM = "CONTRA_NAM";

    /** �������ԊJ�n */
    public static final String HK_SDT = "HK_SDT";

    /** �������ԏI�� */
    public static final String HK_EDT = "HK_EDT";

    /** Climax�X�|�b�g����NO */
    public static final String SHK_NO = "SHK_NO";

    /** �����ǃR�[�h */
    public static final String KYK_CD = "KYK_CD";

    /** �ǈ�NO */
    public static final String KYKAN_NO = "KYKAN_NO";

    /** �����ǃR�[�h */
    public static final String KYOKUCD = "KYOKUCD";

    /** �����ǖ��� */
    public static final String KYOKUNAME = "KYOKUNAME";

    /** ���� */
    public static final String K_HKGAK_HAT = "K_HKGAK_HAT";

    /** �b�� */
    public static final String CM_SEC = "CM_SEC";

    /** �n��R�[�h */
    public static final String TIKU = "TIKU";

    /** ������ */
    public static final String ONA_DT = "ONA_DT";

    /** �J�n���� */
    public static final String KYKAN_STM = "KYKAN_STM";

    /** �I������ */
    public static final String KYKAN_ETM = "KYKAN_ETM";

    /** �L����R�[�h */
    public static final String AC_CD = "AC_CD";

    /** �f�ދ��ʃR�[�h�敪 */
    public static final String SZIKYTU_KB = "SZIKYTU_KB";

    /** �f�ދ��ʃR�[�h */
    public static final String SZIKYTU_CD = "SZIKYTU_CD";

    /** �����Ǒf�ޗ��� */
    public static final String K_SZI_RYKG = "K_SZI_RYKG";

    /** �n��\���� */
    public static final String THYOJIJYUN = "THYOJIJYUN";

    /** �\���� */
    public static final String HYOJIJYUN = "HYOJIJYUN";

    /** ���ԘgNO */
    public static final String JWK_NO = "JWK_NO";

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     */
    public FindLionTVSpotVO() {
    }

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     *
     * @return �V�K�C���X�^���X
     */
    public Object newInstance() {
        return new FindLionTVSpotVO();
    }

    public String getJOB_NO() {
        return (String) get(JOB_NO);
    }

    public void setJOB_NO(String val) {
        set(JOB_NO, val);
    }

    public String getCONTRA_NAM() {
        return (String) get(CONTRA_NAM);
    }

    public void setCONTRA_NAM(String val) {
        set(CONTRA_NAM, val);
    }

    public String getHK_SDT() {
        return (String) get(HK_SDT);
    }

    public void setHK_SDT(String val) {
        set(HK_SDT, val);
    }

    public String getHK_EDT() {
        return (String) get(HK_EDT);
    }

    public void setHK_EDT(String val) {
        set(HK_EDT, val);
    }

    public String getSHK_NO() {
        return (String) get(SHK_NO);
    }

    public void setSHK_NO(String val) {
        set(SHK_NO, val);
    }

    public String getKYK_CD() {
        return (String) get(KYK_CD);
    }

    public void setKYK_CD(String val) {
        set(KYK_CD, val);
    }

    public String getKYKAN_NO() {
        return (String) get(KYKAN_NO);
    }

    public void setKYKAN_NO(String val) {
        set(KYKAN_NO, val);
    }

    public String getKYOKUCD() {
        return (String) get(KYOKUCD);
    }

    public void setKYOKUCD(String val) {
        set(KYOKUCD, val);
    }

    public String getKYOKUNAME() {
        return (String) get(KYOKUNAME);
    }

    public void setKYOKUNAME(String val) {
        set(KYOKUNAME, val);
    }

    public BigDecimal getK_HKGAK_HAT() {
        return (BigDecimal) get(K_HKGAK_HAT);
    }

    public void setK_HKGAK_HAT(BigDecimal val) {
        set(K_HKGAK_HAT, val);
    }

    public BigDecimal getCM_SEC() {
        return (BigDecimal) get(CM_SEC);
    }

    public void setCM_SEC(BigDecimal val) {
        set(CM_SEC, val);
    }

    public String getTIKU() {
        return (String) get(TIKU);
    }

    public void setTIKU(String val) {
        set(TIKU, val);
    }

    public String getONA_DT() {
        return (String) get(ONA_DT);
    }

    public void setONA_DT(String val) {
        set(ONA_DT, val);
    }

    public String getKYKAN_STM() {
        return (String) get(KYKAN_STM);
    }

    public void setKYKAN_STM(String val) {
        set(KYKAN_STM, val);
    }

    public String getKYKAN_ETM() {
        return (String) get(KYKAN_ETM);
    }

    public void setKYKAN_ETM(String val) {
        set(KYKAN_ETM, val);
    }

    public String getAC_CD() {
        return (String) get(AC_CD);
    }

    public void setAC_CD(String val) {
        set(AC_CD, val);
    }

    public String getSZIKYTU_KB() {
        return (String) get(SZIKYTU_KB);
    }

    public void setSZIKYTU_KB(String val) {
        set(SZIKYTU_KB, val);
    }

    public String getSZIKYTU_CD() {
        return (String) get(SZIKYTU_CD);
    }

    public void setSZIKYTU_CD(String val) {
        set(SZIKYTU_CD, val);
    }

    public String getK_SZI_RYKG() {
        return (String) get(K_SZI_RYKG);
    }

    public void setK_SZI_RYKG(String val) {
        set(K_SZI_RYKG, val);
    }

    public String getTHYOJIJYUN() {
        return (String) get(THYOJIJYUN);
    }

    public void setTHYOJIJYUN(String val) {
        set(THYOJIJYUN, val);
    }

    public String getHYOJIJYUN() {
        return (String) get(HYOJIJYUN);
    }

    public void setHYOJIJYUN(String val) {
        set(HYOJIJYUN, val);
    }

    public String getJWK_NO() {
        return (String) get(JWK_NO);
    }

    public void setJWK_NO(String val) {
        set(JWK_NO, val);
    }

}
package jp.co.isid.kkh.customer.lion.model.report;

import java.math.BigDecimal;

import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * ���C�I�����[(���쎺���X�g)��������VO
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2014/07/31 HLC S.Fujimoto)<BR>
 * </P>
 *
 * @author HLC S.Fujimoto
 */
public class AddChangeReportLionSeisakuVO extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /** �c�Ə�(��)�R�[�h */
    public static final String EGCD = "EGCD";
    /** ���Ӑ��ƃR�[�h */
    public static final String TKSKGYCD = "TKSKGYCD";
    /** ���Ӑ敔��SEQNO */
    public static final String TKSBMNSEQNO = "TKSBMNSEQNO";
    /** ���Ӑ�S��SEQNO */
    public static final String TKSTNTSEQNO = "TKSTNTSEQNO";

    /** �����^�C���X�^���v */
    public static final String RRKTIMSTMP = "RRKTIMSTMP";

    /** ��No */
    public static final String JYUTNO = "JYUTNO";
    /** �󒍖���No */
    public static final String JYMEINO = "JYMEINO";
    /** ���㖾��No */
    public static final String URMEINO = "URMEINO";
    /** AD1�}�̋敪�R�[�h */
    public static final String BAITAIKBN = "BAITAIKBN";
    /** AD1�}�̋敪�� */
    public static final String BAITAINM = "BAITAINM";
    /** AD1�u�����h�R�[�h */
    public static final String BRDCD = "BRDCD";
    /** AD1�u�����h�� */
    public static final String BRDNM = "BRDNM";
    /** AD1�W�������R�[�h */
    public static final String JUNLECD = "JUNLECD";   //SQL�݂̂Ŏg�p���邽�߁Agetter/setter�Ȃ�
    /** AD1���� */
    public static final String KENNM = "KENNM";
    /** AD1�������z */
    public static final String SEIGAK = "SEIGAK";
    /** AD1����Ŋz */
    public static final String TAXAMT = "TAXAMT";
    /** AD1�}�̋敪�R�[�h */
    public static final String AD1BAITAIKBN = "AD1BAITAIKBN";
    /** AD1�}�̋敪�� */
    public static final String AD1BAITAINM = "AD1BAITAINM";
    /** AD1�u�����h�R�[�h */
    public static final String AD1BRDCD = "AD1BRDCD";
    /** AD1�u�����h�� */
    public static final String AD1BRDNM = "AD1BRDNM";
    /** AD1�W�������R�[�h */
    public static final String AD1JUNLECD = "AD1JUNLECD";   //SQL�݂̂Ŏg�p���邽�߁Agetter/setter�Ȃ�
    /** AD1���� */
    public static final String AD1KENNM = "AD1KENNM";
    /** AD1�������z */
    public static final String AD1SEIGAK = "AD1SEIGAK";
    /** AD1����Ŋz */
    public static final String AD1TAXAMT = "AD1TAXAMT";
    /** AD2�}�̋敪�R�[�h */
    public static final String AD2BAITAIKBN = "AD2BAITAIKBN";
    /** AD2�}�̋敪�� */
    public static final String AD2BAITAINM = "AD2BAITAINM";
    /** AD2�u�����h�R�[�h */
    public static final String AD2BRDCD = "AD2BRDCD";
    /** AD2�u�����h�� */
    public static final String AD2BRDNM = "AD2BRDNM";
    /** AD2�W�������R�[�h */
    public static final String AD2JUNLECD = "AD2JUNLECD";   //SQL�݂̂Ŏg�p���邽�߁Agetter/setter�Ȃ�
    /** AD2���� */
    public static final String AD2KENNM = "AD2KENNM";
    /** AD2�������z */
    public static final String AD2SEIGAK = "AD2SEIGAK";
    /** AD2����Ŋz */
    public static final String AD2TAXAMT = "AD2TAXAMT";
    /** �ύX�_ */
    public static final String CHGPNT = "CHGPNT";
    /** SEQ(�ǉ�:1�A�폜:2�A�ύX:3) */
    public static final String SEQ = "SEQ";

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     */
    public AddChangeReportLionSeisakuVO() {
    }

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     * @return �V�K�C���X�^���X
     */
    public Object newInstance() {
        return new AddChangeReportLionSeisakuVO();
    }

    /**
     * �c�Ə�(��)�R�[�h���擾����
     * @return �c�Ə�(��)�R�[�h
     */
    public String getEgcd() {
        return (String) get(EGCD);
    }

    /**
     * �c�Ə�(��)�R�[�h��ݒ肷��
     * @param val String �c�Ə�(��)�R�[�h
     */
    public void setEgcd(String val) {
        set(EGCD, val);
    }

    /**
     * ���Ӑ��ƃR�[�h���擾����
     * @return ���Ӑ��ƃR�[�h
     */
    public String getTksKgyCd() {
        return (String) get(TKSKGYCD);
    }

    /**
     * ���Ӑ��ƃR�[�h��ݒ肷��
     * @param val String ���Ӑ��ƃR�[�h
     */
    public void setTksKgyCd(String val) {
        set(TKSKGYCD, val);
    }

    /**
     * ���Ӑ敔��SEQNO���擾����
     * @return ���Ӑ敔��SEQNO
     */
    public String getTksBmnSeqNo() {
        return (String) get(TKSBMNSEQNO);
    }

    /**
     * ���Ӑ敔��SEQNO��ݒ肷��
     * @param val String ���Ӑ敔��SEQNO
     */
    public void setTksBmnSeqNo(String val) {
        set(TKSBMNSEQNO, val);
    }

    /**
     * ���Ӑ�S��SEQNO���擾����
     * @return ���Ӑ�S��SEQNO
     */
    public String getTksTntSeqNo() {
        return (String) get(TKSTNTSEQNO);
    }

    /**
     * ���Ӑ�S��SEQNO��ݒ肷��
     * @param val String ���Ӑ�S��SEQNO
     */
    public void setTksTntSeqNo(String val) {
        set(TKSTNTSEQNO, val);
    }

    /**
     * �����^�C���X�^���v���擾����
     * @return �����^�C���X�^���v
     */
    public String getRrkTimStmp() {
        return (String) get(RRKTIMSTMP);
    }

    /**
     * �����^�C���X�^���v��ݒ肷��
     * @param val String �����^�C���X�^���v
     */
    public void setRrkTimStmp(String val) {
        set(RRKTIMSTMP, val);
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
     * ����Ŋz���擾����
     * @return ����Ŋz
     */
    public BigDecimal getTaxAmt() {
        return (BigDecimal) get(TAXAMT);
    }

    /**
     * ����Ŋz��ݒ肷��
     * @param val BigDecimal ����Ŋz
     */
    public void setTaxAmt(BigDecimal val) {
        set(TAXAMT, val);
    }

    /**
     * AD1�}�̋敪�R�[�h���擾����
     * @return AD1�}�̋敪
     */
    public String getAD1BaitaiKbn() {
        return (String) get(AD1BAITAIKBN);
    }

    /**
     * AD1�}�̋敪�R�[�h��ݒ肷��
     * @param val String AD1�}�̋敪
     */
    public void setAD1BaitaiKbn(String val) {
        set(AD1BAITAIKBN, val);
    }

    /**
     * AD1�}�̋敪�����擾����
     * @return AD1�}�̋敪��
     */
    public String getAD1BaitaiNm() {
        return (String) get(AD1BAITAINM);
    }

    /**
     * AD1�}�̋敪����ݒ肷��
     * @param val String AD1�}�̋敪��
     */
    public void setAD1BaitaiNm(String val) {
        set(AD1BAITAINM, val);
    }

    /**
     * AD1�u�����h�R�[�h���擾����
     * @return AD1�u�����h�R�[�h
     */
    public String getAD1BrdCd() {
        return (String) get(AD1BRDCD);
    }

    /**
     * AD1�u�����h�R�[�h��ݒ肷��
     * @param val String AD1�u�����h�R�[�h
     */
    public void setAD1BrdCd(String val) {
        set(AD1BRDCD, val);
    }

    /**
     * AD1�u�����h�����擾����
     * @return AD1�u�����h��
     */
    public String getAD1BrdNm() {
        return (String) get(AD1BRDNM);
    }

    /**
     * AD1�u�����h����ݒ肷��
     * @param val String AD1�u�����h��
     */
    public void setAD1BrdNm(String val) {
        set(AD1BRDNM, val);
    }

    /**
     * AD1�������擾����
     * @return AD1����
     */
    public String getAD1KenNm() {
        return (String) get(AD1KENNM);
    }

    /**
     * AD1������ݒ肷��
     * @param val String AD1����
     */
    public void setAD1KenNm(String val) {
        set(AD1KENNM, val);
    }

    /**
     * AD1�������z���擾����
     * @return AD1�������z
     */
    public BigDecimal getAD1Seigak() {
        return (BigDecimal) get(AD1SEIGAK);
    }

    /**
     * AD1�������z��ݒ肷��
     * @param val BigDecimal AD1�������z
     */
    public void setAD1Seigak(BigDecimal val) {
        set(AD1SEIGAK, val);
    }

    /**
     * AD1����Ŋz���擾����
     * @return AD1����Ŋz
     */
    public BigDecimal getAD1TaxAmt() {
        return (BigDecimal) get(AD1TAXAMT);
    }

    /**
     * AD1����Ŋz��ݒ肷��
     * @param val BigDecimal AD1����Ŋz
     */
    public void setAD1TaxAmt(BigDecimal val) {
        set(AD1TAXAMT, val);
    }

    /**
     * AD2�}�̋敪�R�[�h���擾����
     * @return AD2�}�̋敪
     */
    public String getAD2BaitaiKbn() {
        return (String) get(AD2BAITAIKBN);
    }

    /**
     * AD2�}�̋敪�R�[�h��ݒ肷��
     * @param val String AD2�}�̋敪
     */
    public void setAD2BaitaiKbn(String val) {
        set(AD2BAITAIKBN, val);
    }

    /**
     * AD2�}�̋敪�����擾����
     * @return AD2�}�̋敪��
     */
    public String getAD2BaitaiNm() {
        return (String) get(AD2BAITAINM);
    }

    /**
     * AD2�}�̋敪����ݒ肷��
     * @param val String AD2�}�̋敪��
     */
    public void setAD2BaitaiNm(String val) {
        set(AD2BAITAINM, val);
    }

    /**
     * AD2�u�����h�R�[�h���擾����
     * @return AD2�u�����h�R�[�h
     */
    public String getAD2BrdCd() {
        return (String) get(AD2BRDCD);
    }

    /**
     * AD2�u�����h�R�[�h��ݒ肷��
     * @param val String AD2�u�����h�R�[�h
     */
    public void setAD2BrdCd(String val) {
        set(AD2BRDCD, val);
    }

    /**
     * AD2�u�����h�����擾����
     * @return AD2�u�����h��
     */
    public String getAD2BrdNm() {
        return (String) get(AD2BRDNM);
    }

    /**
     * AD2�u�����h����ݒ肷��
     * @param val String AD2�u�����h��
     */
    public void setAD2BrdNm(String val) {
        set(AD2BRDNM, val);
    }

    /**
     * AD2�������擾����
     * @return AD2����
     */
    public String getAD2KenNm() {
        return (String) get(AD2KENNM);
    }

    /**
     * AD2������ݒ肷��
     * @param val String AD2����
     */
    public void setAD2KenNm(String val) {
        set(AD2KENNM, val);
    }

    /**
     * AD2�������z���擾����
     * @return AD2�������z
     */
    public BigDecimal getAD2Seigak() {
        return (BigDecimal) get(AD2SEIGAK);
    }

    /**
     * AD2�������z��ݒ肷��
     * @param val BigDecimal AD2�������z
     */
    public void setAD2Seigak(BigDecimal val) {
        set(AD2SEIGAK, val);
    }

    /**
     * AD2����Ŋz���擾����
     * @return AD2����Ŋz
     */
    public BigDecimal getAD2TaxAmt() {
        return (BigDecimal) get(AD2TAXAMT);
    }

    /**
     * AD2����Ŋz��ݒ肷��
     * @param val BigDecimal AD2����Ŋz
     */
    public void setAD2TaxAmt(BigDecimal val) {
        set(AD2TAXAMT, val);
    }

    /**
     * �ύX�_���擾����
     * @return �ύX�_
     */
    public String getChgPnt() {
        return ((String) get(CHGPNT));
    }

    /**
     * �ύX�_��ݒ肷��
     * @param val String �ύX�_
     */
    public void setChgPnt(String val) {
        set(CHGPNT, val);
    }

    /**
     * SEQ���擾����
     * @return SEQ
     */
    public String getSEQ() {
        return ((String) get(SEQ));
    }

    /**
     * SEQ��ݒ肷��
     * @param val String SEQ
     */
    public void setSEQ(String val) {
        set(SEQ, val);
    }

}
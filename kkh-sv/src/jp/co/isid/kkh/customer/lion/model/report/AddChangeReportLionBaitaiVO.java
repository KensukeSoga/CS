package jp.co.isid.kkh.customer.lion.model.report;

import java.math.BigDecimal;

import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * ���C�I�����[(�ǉ��ύX���X�g)��������VO
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2014/07/31 HLC S.Fujimoto)<BR>
 * </P>
 *
 * @author HLC S.Fujimoto
 */
public class AddChangeReportLionBaitaiVO extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /** �����^�C���X�^���v */
    public static final String RRKTIMSTMP = "RRKTIMSTMP";

    /** ��No */
    public static final String JYUTNO = "JYUTNO";
    /** �󒍖���No */
    public static final String JYMEINO = "JYMEINO";
    /** ���㖾��No */
    public static final String URMEINO = "URMEINO";
    /** �A�� */
    public static final String RENBN = "RENBN";
    /** �}�̋敪�R�[�h */
    public static final String BAITAIKBN = "BAITAIKBN";
    /** �}�̋敪���� */
    public static final String BAITAINM = "BAITAINM";
    /** �}�̋敪�\�[�g�� */
    public static final String BAITAISORTNO = "BAITAISORTNO";
    /** ���� */
    public static final String KENNM = "KENNM";
    /** �������z */
    public static final String SEIGAK = "SEIGAK";
    /** �ǎ��R�[�h */
    public static final String KYKSHCD = "KYKSHCD";
    /** �ǃR�[�h */
    public static final String KYKCD = "KYKCD";
    /** �ǖ� */
    public static final String KYKNM = "KYKNM";
    /** CM�b�� */
    public static final String BYOSU = "BYOSU";
    /** CM�{�� */
    public static final String HONSU = "HONSU";
    /** �X�y�[�X */
    public static final String SPACE = "SPACE";
    /** �f�ړ��E���E�� */
    public static final String KEISAIBI = "KEISAIBI";
    /** ���� */
    public static final String TERM = "TERM";
    /** �ύX�敪 */
    public static final String ADDCHGKBN = "ADDCHGKBN";
    /** SEQ(�ǉ�:1�A�폜:2�A�ύX:3) */
    public static final String SEQ = "SEQ";
    /** �\�[�g��(AD1:1�AAD2:2) */
    public static final String ORDERSEQ = "ORDERSEQ";

    /** AD1��No */
    public static final String AD1JYUTNO = "AD1JYUTNO";
    /** AD1�󒍖���No */
    public static final String AD1JYMEINO = "AD1JYMEINO";
    /** AD1���㖾��No */
    public static final String AD1URMEINO = "AD1URMEINO";
    /** AD1�A�� */
    public static final String AD1RENBN = "AD1RENBN";
    /** AD1�}�̋敪�R�[�h */
    public static final String AD1BAITAIKBN = "AD1BAITAIKBN";
    /** AD1�}�̋敪�� */
    public static final String AD1BAITAINM = "AD1BAITAINM";
    /** AD1�}�̋敪�\�[�g�� */
    public static final String AD1BAITAISORTNO = "AD1BAITAISORTNO";
    /** AD1���� */
    public static final String AD1KENNM = "AD1KENNM";
    /** AD1�������z */
    public static final String AD1SEIGAK = "AD1SEIGAK";
    /** AD1CM�{�� */
    public static final String AD1HONSU = "AD1HONSU";
    /** AD1CM�b�� */
    public static final String AD1BYOSU = "AD1BYOSU";
    /** AD1�X�y�[�X */
    public static final String AD1SPACE = "AD1SPACE";
    /** AD1���� */
    public static final String AD1TERM = "AD1TERM";
    /** AD1�ǎ��R�[�h */
    public static final String AD1KYKSHCD = "AD1KYKSHCD";
    /** AD1�ǃR�[�h */
    public static final String AD1KYKCD = "AD1KYKCD";
    /** AD1�ǖ� */
    public static final String AD1KYKNM = "AD1KYKNM";
    /** AD1�f�ړ� */
    public static final String AD1KEISAIBI = "AD1KEISAIBI";
    /** AD1�u�����h�R�[�h */
    public static final String AD1BRDCD = "AD1BRDCD";

    /** AD2��No */
    public static final String AD2JYUTNO = "AD2JYUTNO";
    /** AD2�󒍖���No */
    public static final String AD2JYMEINO = "AD2JYMEINO";
    /** AD2���㖾��No */
    public static final String AD2URMEINO = "AD2URMEINO";
    /** AD2�A�� */
    public static final String AD2RENBN = "AD2RENBN";
    /** AD2�}�̋敪�R�[�h */
    public static final String AD2BAITAIKBN = "AD2BAITAIKBN";
    /** AD2�}�̋敪�� */
    public static final String AD2BAITAINM = "AD2BAITAINM";
    /** AD2�}�̋敪�\�[�g�� */
    public static final String AD2BAITAISORTNO = "AD2BAITAISORTNO";
    /** AD2���� */
    public static final String AD2KENNM = "AD2KENNM";
    /** AD2�������z */
    public static final String AD2SEIGAK = "AD2SEIGAK";
    /** AD2CM�{�� */
    public static final String AD2HONSU = "AD2HONSU";
    /** AD2CM�b�� */
    public static final String AD2BYOSU = "AD2BYOSU";
    /** AD2�X�y�[�X */
    public static final String AD2SPACE = "AD2SPACE";
    /** AD2���� */
    public static final String AD2TERM = "AD2TERM";
    /** AD2�ǎ��R�[�h */
    public static final String AD2KYKSHCD = "AD2KYKSHCD";
    /** AD2�ǃR�[�h */
    public static final String AD2KYKCD = "AD2KYKCD";
    /** AD2�ǖ� */
    public static final String AD2KYKNM = "AD2KYKNM";
    /** AD2�f�ړ� */
    public static final String AD2KEISAIBI = "AD2KEISAIBI";
    /** AD2�u�����h�R�[�h */
    public static final String AD2BRDCD = "AD2BRDCD";

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     */
    public AddChangeReportLionBaitaiVO() {
    }

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     * @return �V�K�C���X�^���X
     */
    public Object newInstance() {
        return new AddChangeReportLionBaitaiVO();
    }

    /**
     * �����^�C���X�^���v���擾����
     * @return String �����^�C���X�^���v
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

    /**
     * ��No���擾����
     * @return String ��No
     */
    public String getJyutNo() {
        return (String) get(JYUTNO);
    }

    /**
     * ��No��ݒ肷��
     * @param val String ��No
     */
    public void setJyutNo(String val) {
        set(JYUTNO, val);
    }

    /**
     * �󒍖���No���擾����
     * @return String �󒍖���No
     */
    public String getJymeiNo() {
        return (String) get(JYMEINO);
    }

    /**
     * �󒍖���No��ݒ肷��
     * @param val String �󒍖���No
     */
    public void setJymeiNo(String val) {
        set(JYMEINO, val);
    }

    /**
     * ���㖾��No���擾����
     * @return String ���㖾��No
     */
    public String getUrmeiNo() {
        return (String) get(URMEINO);
    }

    /**
     * ���㖾��No��ݒ肷��
     * @param val String ���㖾��No
     */
    public void setUrmeiNo(String val) {
        set(URMEINO, val);
    }

    /**
     * �A�Ԃ��擾����
     * @return String �A��
     */
    public String getRenbn() {
        return (String) get(RENBN);
    }

    /**
     * �A�Ԃ�ݒ肷��
     * @param val String �A��
     */
    public void setRenbn(String val) {
        set(RENBN, val);
    }

    /**
     * �}�̋敪�R�[�h���擾����
     * @return String �}�̋敪�R�[�h
     */
    public String getBaitaiKbn() {
        return (String) get(BAITAIKBN);
    }

    /**
     * �}�̋敪�R�[�h��ݒ肷��
     * @param val String �}�̋敪�R�[�h
     */
    public void setBaitaiKbn(String val) {
        set(BAITAIKBN, val);
    }

    /**
     * �}�̋敪���̂��擾����
     * @return String �}�̋敪����
     */
    public String getBaitaiNm() {
        return (String) get(BAITAINM);
    }

    /**
     * �}�̋敪���̂�ݒ肷��
     * @param val String �}�̋敪����
     */
    public void setBaitaiNm(String val) {
        set(BAITAINM, val);
    }

    /**
     * �}�̋敪�\�[�g�����擾����
     * @return Integer �}�̋敪�\�[�g��
     */
    public Integer getBaitaiSortNo() {
        return (Integer) get(BAITAISORTNO);
    }

    /**
     * �}�̋敪�\�[�g����ݒ肷��
     * @param val Integer �}�̋敪�\�[�g��
     */
    public void setBaitaiSortNo(Integer val) {
        set(BAITAISORTNO, val);
    }

    /**
     * �������擾����
     * @return String ����
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
     * �ǎ��R�[�h���擾����
     * @return String �ǎ��R�[�h
     */
    public String getKykshCd() {
        return (String) get(KYKSHCD);
    }

    /**
     * �ǎ��R�[�h��ݒ肷��
     * @param val String �ǎ��R�[�h
     */
    public void setKykshCd(String val) {
        set(KYKSHCD, val);
    }

    /**
     * �ǃR�[�h���擾����
     * @return String �ǃR�[�h
     */
    public String getKykCd() {
        return (String) get(KYKCD);
    }

    /**
     * �ǃR�[�h��ݒ肷��
     * @param val String �ǃR�[�h
     */
    public void setKykCd(String val) {
        set(KYKCD, val);
    }

    /**
     * �ǖ����擾����
     * @return String �ǖ�
     */
    public String getKykNm() {
        return (String) get(KYKNM);
    }

    /**
     * �ǖ���ݒ肷��
     * @param val String �ǖ�
     */
    public void setKykNm(String val) {
        set(KYKNM, val);
    }

    /**
     * CM�b�����擾����
     * @return BigDecimal CM�b��
     */
    public BigDecimal getByosu() {
        return (BigDecimal) get(BYOSU);
    }

    /**
     * CM�b����ݒ肷��
     * @param val BigDecimal CM�b��
     */
    public void setByosu(BigDecimal val) {
        set(BYOSU, val);
    }

    /**
     * CM�{�����擾����
     * @return BigDecimal CM�{��
     */
    public BigDecimal getHonsu() {
        return (BigDecimal) get(HONSU);
    }

    /**
     * CM�{����ݒ肷��
     * @param val BigDecimal CM�{��
     */
    public void setHonsu(BigDecimal val) {
        set(HONSU, val);
    }

    /**
     * �X�y�[�X���擾����
     * @return String �X�y�[�X
     */
    public String getSpace() {
        return (String) get(SPACE);
    }

    /**
     * �X�y�[�X��ݒ肷��
     * @param val String �X�y�[�X
     */
    public void setSpace(String val) {
        set(SPACE, val);
    }

    /**
     * �f�ړ��E���E�����擾����
     * @return String �f�ړ��E���E��
     */
    public String getKeisaibi() {
        return (String) get(KEISAIBI);
    }

    /**
     * �f�ړ��E���E����ݒ肷��
     * @param val String �f�ړ��E���E��
     */
    public void setKeisaibi(String val) {
        set(KEISAIBI, val);
    }

    /**
     * ���Ԃ��擾����
     * @return String ����
     */
    public String getTerm() {
        return (String) get(TERM);
    }

    /**
     * ���Ԃ�ݒ肷��
     * @param val String ����
     */
    public void setTerm(String val) {
        set(TERM, val);
    }

    /**
     * �ύX�敪���擾����
     * @return String �ύX�敪
     */
    public String getAddChgKbn() {
        return ((String) get(ADDCHGKBN));
    }

    /**
     * �ύX�敪��ݒ肷��
     * @param val String �ύX�敪
     */
    public void setAddChgKbn(String val) {
        set(ADDCHGKBN, val);
    }

    /**
     * SEQ���擾����
     * @return String SEQ
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

    /**
     * �\�[�g�����擾����
     * @return String �\�[�g��
     */
    public String getORDERSEQ() {
        return ((String) get(ORDERSEQ));
    }

    /**
     * �\�[�g����ݒ肷��
     * @param val String �\�[�g��
     */
    public void setORDERSEQ(String val) {
        set(ORDERSEQ, val);
    }

    /**
     * AD1�������z���擾����
     * @return BigDecimal AD1�������z
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
     * AD2�������z���擾����
     * @return BigDecimal AD2�������z
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

//    /** AD1��No���擾����
//     * @return String AD1��No
//     */
//    public String getAD1Jyutno() {
//        return (String) get(AD1JYUTNO);
//    }
//
//    /**
//     * AD1��No��ݒ肷��
//     * @param val String AD1��No
//     */
//    public void setAD1Jyutno(String val) {
//        set(AD1JYUTNO, val);
//    }
//
//    /**
//     * AD1�󒍖���No���擾����
//     * @return String AD1�󒍖���No
//     */
//    public String getAD1Jymeino() {
//        return (String) get(AD1JYMEINO);
//    }
//
//    /**
//     * AD1�󒍖���No��ݒ肷��
//     * @param val String AD1�󒍖���No
//     */
//    public void setAD1Jymeino(String val) {
//        set(AD1JYMEINO, val);
//    }
//
//    /**
//     * ���㖾��No���擾����
//     * @return String ���㖾��No
//     */
//    public String getAD1Urmeino() {
//        return (String) get(AD1URMEINO);
//    }
//
//    /**
//     * ���㖾��No��ݒ肷��
//     * @param val String ���㖾��No
//     */
//    public void setAD1Urmeino(String val) {
//        set(AD1URMEINO, val);
//    }
//
//    /**
//     * AD1�A�Ԃ��擾����
//     * @return String AD1�A��
//     */
//    public String getAD1Renbn() {
//        return (String) get(AD1RENBN);
//    }
//
//    /**
//     * AD1�A�Ԃ�ݒ肷��
//     * @param val String AD1�A��
//     */
//    public void setAD1Renbn(String val) {
//        set(AD1RENBN, val);
//    }
//
//    /**
//     * AD1�}�̋敪�R�[�h���擾����
//     * @return String AD1�}�̋敪
//     */
//    public String getAD1BaitaiKbn() {
//        return (String) get(AD1BAITAIKBN);
//    }
//
//    /**
//     * AD1�}�̋敪�R�[�h��ݒ肷��
//     * @param val String AD1�}�̋敪
//     */
//    public void setAD1BaitaiKbn(String val) {
//        set(AD1BAITAIKBN, val);
//    }
//
//    /**
//     * AD1�}�̋敪�����擾����
//     * @return String AD1�}�̋敪��
//     */
//    public String getAD1BaitaiNm() {
//        return (String) get(AD1BAITAINM);
//    }
//
//    /**
//     * AD1�}�̋敪����ݒ肷��
//     * @param val String AD1�}�̋敪��
//     */
//    public void setAD1BaitaiNm(String val) {
//        set(AD1BAITAINM, val);
//    }
//
//    /**
//     * AD1�������擾����
//     * @return String AD1����
//     */
//    public String getAD1KenNm() {
//        return (String) get(AD1KENNM);
//    }
//
//    /**
//     * AD1������ݒ肷��
//     * @param val String AD1����
//     */
//    public void setAD1KenNm(String val) {
//        set(AD1KENNM, val);
//    }
//
//    /**
//     * AD1�{�����擾����
//     * @return BigDecimal AD1�{��
//     */
//    public BigDecimal getAD1Honsu() {
//        return (BigDecimal) get(AD1HONSU);
//    }
//
//    /**
//     * AD1�{����ݒ肷��
//     * @param val BigDecimal AD1�{��
//     */
//    public void setAD1Honsu(BigDecimal val) {
//        set(AD1HONSU, val);
//    }
//
//    /**
//     * AD1�b�����擾����
//     * @return BigDecimal AD1�b��
//     */
//    public BigDecimal getAD1Byosu() {
//        return (BigDecimal) get(AD1BYOSU);
//    }
//
//    /**
//     * AD1�b����ݒ肷��
//     * @param val BigDecimal AD1�b��
//     */
//    public void setAD1Byosu(BigDecimal val) {
//        set(AD1BYOSU, val);
//    }
//
//    /**
//     * �X�y�[�X���擾����
//     * @return String �X�y�[�X
//     */
//    public String getAD1Space() {
//        return (String) get(AD1SPACE);
//    }
//
//    /**
//     * AD1�X�y�[�X��ݒ肷��
//     * @param val String AD1�X�y�[�X
//     */
//    public void setAD1Space(String val) {
//        set(AD1SPACE, val);
//    }
//
//    /**
//     * AD1���Ԃ��擾����
//     * @return String AD1����
//     */
//    public String getAD1Term() {
//        return (String) get(AD1TERM);
//    }
//
//    /**
//     * AD1���Ԃ�ݒ肷��
//     * @param val String AD1����
//     */
//    public void setAD1Term(String val) {
//        set(AD1TERM, val);
//    }
//
//    /**
//     * AD1�ǎ��R�[�h���擾����
//     * @return String AD1�ǎ��R�[�h
//     */
//    public String getAD1KykshCd() {
//        return (String) get(AD1KYKSHCD);
//    }
//
//    /**
//     * AD1�ǎ��R�[�h��ݒ肷��
//     * @param val String AD1�ǎ��R�[�h
//     */
//    public void setAD1KykshCd(String val) {
//        set(AD1KYKSHCD, val);
//    }
//
//    /**
//     * AD1�ǃR�[�h���擾����
//     * @return String AD1�ǃR�[�h
//     */
//    public String getAD1KykCd() {
//        return (String) get(AD1KYKCD);
//    }
//
//    /**
//     * AD1�ǃR�[�h��ݒ肷��
//     * @param val String AD1�ǃR�[�h
//     */
//    public void setAD1KykCd(String val) {
//        set(AD1KYKCD, val);
//    }
//
//    /**
//     * AD1�ǖ����擾����
//     * @return String AD1�ǖ�
//     */
//    public String getAD1KykNm() {
//        return (String) get(AD1KYKNM);
//    }
//
//    /**
//     * AD1�ǖ���ݒ肷��
//     * @param val String AD1�ǖ�
//     */
//    public void setAD1KykNm(String val) {
//        set(AD1KYKNM, val);
//    }
//
//    /**
//     * AD1�f�ړ����擾����
//     * @return String AD1�f�ړ�
//     */
//    public String getAD1Keisaibi() {
//        return (String) get(AD1KEISAIBI);
//    }
//
//    /**
//     * AD1�f�ړ���ݒ肷��
//     * @param val String AD1�f�ړ�
//     */
//    public void setAD1Keisaibi(String val) {
//        set(AD1KEISAIBI, val);
//    }
//
//    /** AD2��No���擾����
//     * @return String AD2��No
//     */
//    public String getAD2Jyutno() {
//        return (String) get(AD2JYUTNO);
//    }
//
//    /**
//     * AD2��No��ݒ肷��
//     * @param val String AD2��No
//     */
//    public void setAD2Jyutno(String val) {
//        set(AD2JYUTNO, val);
//    }
//
//    /**
//     * AD2�󒍖���No���擾����
//     * @return String AD2�󒍖���No
//     */
//    public String getAD2Jymeino() {
//        return (String) get(AD2JYMEINO);
//    }
//
//    /**
//     * AD2�󒍖���No��ݒ肷��
//     * @param val String AD2�󒍖���No
//     */
//    public void setAD2Jymeino(String val) {
//        set(AD2JYMEINO, val);
//    }
//
//    /**
//     * AD2���㖾��No���擾����
//     * @return String AD2���㖾��No
//     */
//    public String getAD2Urmeino() {
//        return (String) get(AD2URMEINO);
//    }
//
//    /**
//     * AD2���㖾��No��ݒ肷��
//     * @param val String AD2���㖾��No
//     */
//    public void setAD2Urmeino(String val) {
//        set(AD2URMEINO, val);
//    }
//
//    /**
//     * AD2�A�Ԃ��擾����
//     * @return String AD2�A��
//     */
//    public String getAD2Renbn() {
//        return (String) get(AD2RENBN);
//    }
//
//    /**
//     * AD2�A�Ԃ�ݒ肷��
//     * @param val String AD2�A��
//     */
//    public void setAD2Renbn(String val) {
//        set(AD2RENBN, val);
//    }
//
//    /**
//     * AD2�}�̋敪�R�[�h���擾����
//     * @return String AD2�}�̋敪
//     */
//    public String getAD2BaitaiKbn() {
//        return (String) get(AD2BAITAIKBN);
//    }
//
//    /**
//     * AD2�}�̋敪�R�[�h��ݒ肷��
//     * @param val String AD2�}�̋敪
//     */
//    public void setAD2BaitaiKbn(String val) {
//        set(AD2BAITAIKBN, val);
//    }
//
//    /**
//     * AD2�}�̋敪�����擾����
//     * @return String AD2�}�̋敪��
//     */
//    public String getAD2BaitaiNm() {
//        return (String) get(AD2BAITAINM);
//    }
//
//    /**
//     * AD2�}�̋敪����ݒ肷��
//     * @param val String AD2�}�̋敪��
//     */
//    public void setAD2BaitaiNm(String val) {
//        set(AD2BAITAINM, val);
//    }
//
//    /**
//     * AD2�������擾����
//     * @return String AD2����
//     */
//    public String getAD2KenNm() {
//        return (String) get(AD2KENNM);
//    }
//
//    /**
//     * AD2������ݒ肷��
//     * @param val String AD2����
//     */
//    public void setAD2KenNm(String val) {
//        set(AD2KENNM, val);
//    }
//
//    /**
//     * AD2�{�����擾����
//     * @return BigDecimal AD2�{��
//     */
//    public BigDecimal getAD2Honsu() {
//        return (BigDecimal) get(AD2HONSU);
//    }
//
//    /**
//     * AD2�{����ݒ肷��
//     * @param val BigDecimal AD2�{��
//     */
//    public void setAD2Honsu(BigDecimal val) {
//        set(AD2HONSU, val);
//    }
//
//    /**
//     * AD2�b�����擾����
//     * @return BigDecimal AD2�b��
//     */
//    public BigDecimal getAD2Byosu() {
//        return (BigDecimal) get(AD2BYOSU);
//    }
//
//    /**
//     * AD2�b����ݒ肷��
//     * @param val BigDecimal AD2�b��
//     */
//    public void setAD2Byosu(BigDecimal val) {
//        set(AD2BYOSU, val);
//    }
//
//    /**
//     * AD2�X�y�[�X���擾����
//     * @return String AD2�X�y�[�X
//     */
//    public String getAD2Space() {
//        return (String) get(AD2SPACE);
//    }
//
//    /**
//     * AD2�X�y�[�X��ݒ肷��
//     * @param val String AD2�X�y�[�X
//     */
//    public void setAD2Space(String val) {
//        set(AD2SPACE, val);
//    }
//
//    /**
//     * AD2���Ԃ��擾����
//     * @return String AD2����
//     */
//    public String getAD2Term() {
//        return (String) get(AD2TERM);
//    }
//
//    /**
//     * AD2���Ԃ�ݒ肷��
//     * @param val String AD2����
//     */
//    public void setAD2Term(String val) {
//        set(AD2TERM, val);
//    }
//
//    /**
//     * AD2�ǎ��R�[�h���擾����
//     * @return String AD2�ǎ��R�[�h
//     */
//    public String getAD2KykshCd() {
//        return (String) get(AD2KYKSHCD);
//    }
//
//    /**
//     * AD2�ǎ��R�[�h��ݒ肷��
//     * @param val String AD2�ǎ��R�[�h
//     */
//    public void setAD2KykshCd(String val) {
//        set(AD2KYKSHCD, val);
//    }
//
//    /**
//     * AD2�ǃR�[�h���擾����
//     * @return String AD2�ǃR�[�h
//     */
//    public String getAD2KykCd() {
//        return (String) get(AD2KYKCD);
//    }
//
//    /**
//     * AD2�ǃR�[�h��ݒ肷��
//     * @param val String AD2�ǃR�[�h
//     */
//    public void setAD2KykCd(String val) {
//        set(AD2KYKCD, val);
//    }
//
//    /**
//     * AD2�ǖ����擾����
//     * @return String AD2�ǖ�
//     */
//    public String getAD2KykNm() {
//        return (String) get(AD2KYKNM);
//    }
//
//    /**
//     * AD2�ǖ���ݒ肷��
//     * @param val String AD2�ǖ�
//     */
//    public void setAD2KykNm(String val) {
//        set(AD2KYKNM, val);
//    }
//
//    /**
//     * AD2�f�ړ����擾����
//     * @return String AD2�f�ړ�
//     */
//    public String getAD2Keisaibi() {
//        return (String) get(AD2KEISAIBI);
//    }
//
//    /**
//     * AD2�f�ړ���ݒ肷��
//     * @param val String AD2�f�ړ�
//     */
//    public void setAD2Keisaibi(String val) {
//        set(AD2KEISAIBI, val);
//    }

}
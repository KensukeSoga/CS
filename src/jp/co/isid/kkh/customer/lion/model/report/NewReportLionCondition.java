package jp.co.isid.kkh.customer.lion.model.report;

import java.io.Serializable;

/**
 * <P>
 * ���C�I�����[(���Ϗ�)��������
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬<BR>
 * </BR>
 *
 * @author
 *
 */
public class NewReportLionCondition implements Serializable {

    private static final long serialVersionUID = 1L;

    /** ���O�C���S����ESQID */
    private String _esqId;

    /** �c�Ə�(��)�R�[�h(�K�{) */
    private String _egCd;

    /** ���Ӑ��ƃR�[�h(�K�{) */
    private String _tksKgyCd;

    /** ���Ӑ敔��SEQNO(�K�{) */
    private String _tksBmnSeqNo;

    /** ���Ӑ�S��SEQNO(�K�{) */
    private String _tksTntSeqNo;

    /** �N��(�K�{)*/
    private String _yymm;

    /**�}�̃R�[�h(�K�{)*/
    private String _baitaiCd;

    /**
     * ���O�C���S����ESQ-ID���擾����
     * @return ���O�C���S����ESQID
     */
    public String getEsqId() {
        return _esqId;
    }

    /**
     * ESQ-ID��ݒ肷��
     * @param val String ���O�C���S����ESQID
     */
    public void setEsqId(String val) {
        _esqId = val;
    }

    /**
     * �c�Ə�(��)�R�[�h���擾����
     * @return �c�Ə�(��)�R�[�h
     */
    public String getEgCd() {
        return _egCd;
    }

    /**
     * �c�Ə�(��)�R�[�h��ݒ肷��
     * @param val String �c�Ə�(��)�R�[�h
     */
    public void setEgCd(String val) {
        _egCd = val;
    }

    /**
     * ���Ӑ��ƃR�[�h���擾����
     * @return ���Ӑ��ƃR�[�h
     */
    public String getTksKgyCd() {
        return _tksKgyCd;
    }

    /**
     * ���Ӑ��ƃR�[�h��ݒ肷��
     * @param val String ���Ӑ��ƃR�[�h
     */
    public void setTksKgyCd(String val) {
        _tksKgyCd = val;
    }

    /**
     * ���Ӑ敔��SEQNO���擾����
     * @return ���Ӑ敔��SEQNO
     */
    public String getTksBmnSeqNo() {
        return _tksBmnSeqNo;
    }

    /**
     * ���Ӑ敔��SEQNO��ݒ肷��
     * @param val String ���Ӑ敔��SEQNO
     */
    public void setTksBmnSeqNo(String val) {
        _tksBmnSeqNo = val;
    }

    /**
     * ���Ӑ�S��SEQNO���擾����
     * @return ���Ӑ�S��SEQNO
     */
    public String getTksTntSeqNo() {
        return _tksTntSeqNo;
    }

    /**
     * ���Ӑ�S��SEQNO��ݒ肷��
     * @param val String ���Ӑ�S��SEQNO
     */
    public void setTksTntSeqNo(String val) {
        _tksTntSeqNo = val;
    }

    /**
     * �N�����擾����
     * @return _yymm
     */
    public String getYymm() {
        return _yymm;
    }

    /**
     * �N����ݒ肷��
     * @param val String �N��
     */
    public void setYymm(String val) {
        _yymm = val;
    }

    /**
     * �}�̃R�[�h���擾����
     * @return �}�̃R�[�h
     */
    public String getBaitaiCd() {
        return _baitaiCd;
    }

    /**
     * �}�̃R�[�h��ݒ肷��
     * @param val String �}�̃R�[�h
     */
    public void setBaitaiCd(String val) {
        _baitaiCd = val;
    }

}

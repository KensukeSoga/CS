package jp.co.isid.kkh.customer.lion.model.report;

import java.io.Serializable;

/**
 * <P>
 * ���C�I����������
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2014/07/31 HLC S.Fujimoto)<BR>
 * </BR>
 *
 * @author HLC S.Fujimoto
 *
 */
public class LionHistoryCondition implements Serializable {

    private static final long serialVersionUID = 1L;

    /** ESQ-ID */
    private String _esqId = null;

    /** �c�Ə�(��)�R�[�h */
    private String _egCd = null;

    /** ���Ӑ��ƃR�[�h */
    private String _tksKgyCd = null;

    /** ���Ӑ敔��SEQNO */
    private String _tksBmnSeqNo = null;

    /** ���Ӑ�S��SEQNO */
    private String _tksTntSeqNo = null;

    /** �N�� */
    private String _yymm = null;

    /** �����^�C���X�^���v */
    private String _rrkTimStmp = null;

    /** �����쐬���I��}�� */
    private String _rrkGetBaitai = null;

    /**
     * ESQ-ID���擾����
     * @return ESQ-ID
     */
    public String getEsqId() {
        return _esqId;
    }

    /**
     * ESQ-ID��ݒ肷��
     * @param val String ESQ-ID
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
     * �����^�C���X�^���v���擾����
     * @return �����^�C���X�^���v
     */
    public String getRrkTimStmp() {
        return _rrkTimStmp;
    }

    /**
     * �����^�C���X�^���v��ݒ肷��
     * @param val Date �����^�C���X�^���v
     */
    public void setRrkTimStmp(String val) {
        _rrkTimStmp = val;
    }

    /**
     * �����쐬���I��}�̂��擾����
     * @return �����쐬���I��}��
     */
    public String getRrkGetBaitai() {
        return _rrkGetBaitai;
    }

    /**
     * �����쐬���I��}�̂�ݒ肷��
     * @param val String �����쐬���I��}��
     */
    public void setRrkGetBaitai(String val) {
        _rrkGetBaitai = val;
    }

}
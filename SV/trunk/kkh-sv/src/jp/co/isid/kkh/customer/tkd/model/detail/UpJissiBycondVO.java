package jp.co.isid.kkh.customer.tkd.model.detail;

import java.io.Serializable;

public class UpJissiBycondVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /** esqId */
    private String _esqId = null;

    /** aplId */
    private String _aplId = null;

    /** �c�Ə��i��j�R�[�h */
    private String _egCd = null;

    /** ���Ӑ��ƃR�[�h */
    private String _tksKgyCd = null;

    /** ���Ӑ敔��SEQNO */
    private String _tksBmnSeqNo = null;

    /** ���Ӑ�S��SEQNO */
    private String _tksTntSeqNo = null;

    /** �ϓ��l */
    private String _atnum = null;

    /** �N�� */
    private String _YYMM = null;

    /** �_�~�[�v���p�e�B */
    private String _dummy = null;

    /**
     * esqId��Ԃ��܂�
     * @return esqId
     */
    public String getEsqId() {
        return _esqId;
    }

    /**
     * esqId��ݒ肷��
     * @param esqId
     */
    public void setEsqId(String esqId) {
        this._esqId = esqId;
    }

    /**
     * aplId��Ԃ��܂�
     * @return aplId
     */
    public String get_aplId() {
        return _aplId;
    }

    /**
     * aplId��ݒ肷��
     * @param aplId
     */
    public void set_aplId(String aplId) {
        _aplId = aplId;
    }

    /**
     * �c�Ə��i��j�R�[�h��Ԃ��܂�
     * @return egCd
     */
    public String get_egCd() {
        return _egCd;
    }

    /**
     * �c�Ə��i��j�R�[�h��ݒ肷��
     * @param egCd
     */
    public void set_egCd(String egCd) {
        _egCd = egCd;
    }

    /**
     * ���Ӑ��ƃR�[�h��Ԃ��܂�
     * @return tksKgyCd
     */
    public String get_tksKgyCd() {
        return _tksKgyCd;
    }

    /**
     * ���Ӑ��ƃR�[�h��ݒ肷��
     * @param tksKgyCd
     */
    public void set_tksKgyCd(String tksKgyCd) {
        _tksKgyCd = tksKgyCd;
    }

    /**
     * ���Ӑ敔��SEQNO��Ԃ��܂�
     * @return tksBmnSeqNo
     */
    public String get_tksBmnSeqNo() {
        return _tksBmnSeqNo;
    }

    /**
     * ���Ӑ敔��SEQNO��ݒ肷��
     * @param tksBmnSeqNo
     */
    public void set_tksBmnSeqNo(String tksBmnSeqNo) {
        _tksBmnSeqNo = tksBmnSeqNo;
    }

    /**
     * ���Ӑ�S��SEQNO��Ԃ��܂�
     * @return tksTntSeqNo
     */
    public String get_TksTntSeqNo() {
        return _tksTntSeqNo;
    }

    /**
     * ���Ӑ�S��SEQNO��ݒ肷��
     * @param tksTntSeqNo
     */
    public void set_TksTntSeqNo(String tksTntSeqNo) {
        this._tksTntSeqNo = tksTntSeqNo;
    }

    /**
     * �ϓ��l��Ԃ��܂�
     * @return atnum
     */
    public String get_atnum() {
        return _atnum;
    }

    /**
     * �ϓ��l��ݒ肷��
     * @param atnum
     */
    public void set_atnum(String atnum) {
        _atnum = atnum;
    }

    /**
     * �N����Ԃ��܂�
     * @return yymm
     */
    public String get_YYMM() {
        return _YYMM;
    }

    /**
     * �N����ݒ肷��
     * @param yymm
     */
    public void set_YYMM(String yymm) {
        _YYMM = yymm;
    }

    /**
     * �_�~�[�v���p�e�B���擾����
     * @return �_�~�[�v���p�e�B
     */
    public String getDummy() {
        return _dummy;
    }

    /**
     * �_�~�[�v���p�e�B��ݒ肷��
     * @param dummy �_�~�[�v���p�e�B
     */
    public void setDummy(String dummy) {
        this._dummy = dummy;
    }

}

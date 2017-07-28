package jp.co.isid.kkh.customer.acom.model.detail;

import java.io.Serializable;

public class FindSyohinNameGetCond implements Serializable {

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

    /** ���i�敪 */
    private String _syohinKbn = null;

    /** �_�~�[�v���p�e�B */
    private String _dummy = null;

    /**
     * esqId��Ԃ��܂�
     * @return yymm
     */
    public String get_esqId() {
        return _esqId;
    }

    /**
     * esqId��ݒ肷��
     * @param esqId
     */
    public void set_esqId(String esqId) {
        _esqId = esqId;
    }

    /**
     * aplId��Ԃ��܂�
     * @return yymm
     */
    public String get_aplId() {
        return _aplId;
    }

    /**
     * aplId��ݒ肷��
     * @param esqId
     */
    public void set_aplId(String aplId) {
        _aplId = aplId;
    }

    /**
     * �c�Ə��i��j�R�[�h��Ԃ��܂�
     * @return yymm
     */
    public String get_egCd() {
        return _egCd;
    }

    /**
     * �c�Ə��i��j�R�[�h��ݒ肷��
     * @param esqId
     */
    public void set_egCd(String egCd) {
        _egCd = egCd;
    }

    /**
     * ���Ӑ��ƃR�[�h��Ԃ��܂�
     * @return yymm
     */
    public String get_tksKgyCd() {
        return _tksKgyCd;
    }

    /**
     * ���Ӑ��ƃR�[�h��ݒ肷��
     * @param esqId
     */
    public void set_tksKgyCd(String tksKgyCd) {
        _tksKgyCd = tksKgyCd;
    }

    /**
     * ���Ӑ敔��SEQNO��Ԃ��܂�
     * @return yymm
     */
    public String get_tksBmnSeqNo() {
        return _tksBmnSeqNo;
    }

    /**
     * ���Ӑ敔��SEQNO��ݒ肷��
     * @param esqId
     */
    public void set_tksBmnSeqNo(String tksBmnSeqNo) {
        _tksBmnSeqNo = tksBmnSeqNo;
    }

    /**
     * ���Ӑ�S��SEQNO��Ԃ��܂�
     * @return yymm
     */
    public String get_tksTntSeqNo() {
        return _tksTntSeqNo;
    }

    /**
     * ���Ӑ�S��SEQNO��ݒ肷��
     * @param esqId
     */
    public void set_tksTntSeqNo(String tksTntSeqNo) {
        _tksTntSeqNo = tksTntSeqNo;
    }

    /**
     * ���i�敪��Ԃ��܂�
     * @return _Irban
     */
    public String get_syohinKbn() {
        return _syohinKbn;
    }
    /**
     * ���i�敪��ݒ肷��
     * @param esqId
     */
    public void set_syohinKbn(String syohinKbn) {
        _syohinKbn = syohinKbn;
    }

    /**
     * �_�~�[�v���p�e�B��Ԃ��܂�
     * @return yymm
     */
    public String get_dummy() {
        return _dummy;
    }

    /**
     * �_�~�[�v���p�e�B��ݒ肷��
     * @param esqId
     */
    public void set_dummy(String dummy) {
        _dummy = dummy;
    }

}

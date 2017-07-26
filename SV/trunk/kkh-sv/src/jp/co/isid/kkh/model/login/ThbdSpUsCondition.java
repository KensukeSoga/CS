package jp.co.isid.kkh.model.login;

import java.io.Serializable;

public class ThbdSpUsCondition implements Serializable {

    private static final long serialVersionUID = 1L;

    /** ���Ӑ��ƃR�[�h */
    private String _tksKgyCd = null;

    /** ���Ӑ敔��SEQNO */
    private String _tksBmnSeqNo = null;

    /** ���Ӑ�S��SEQNO */
    private String _tksTntSeqNo = null;

    /** �g�D�R�[�h */
    private String _sikCd = null;

    /** ���[�U�[ID */
    private String _userId = null;

    /**
     * ���Ӑ��ƃR�[�h���擾����
     * @return ���Ӑ��ƃR�[�h
     */
    public String getTksKgyCd() {
        return _tksKgyCd;
    }

    /**
     * ���Ӑ��ƃR�[�h��ݒ肷��
     * @param tksKgyCd ���Ӑ��ƃR�[�h
     */
    public void setTksKgyCd(String tksKgyCd) {
        this._tksKgyCd = tksKgyCd;
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
     * @param tksBmnSeqNo ���Ӑ敔��SEQNO
     */
    public void setTksBmnSeqNo(String tksBmnSeqNo) {
        this._tksBmnSeqNo = tksBmnSeqNo;
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
     * @param tksTntSeqNo ���Ӑ�S��SEQNO
     */
    public void setTksTntSeqNo(String tksTntSeqNo) {
        this._tksTntSeqNo = tksTntSeqNo;
    }

    /**
     * �g�D�R�[�h���擾����
     * @return �g�D�R�[�h
     */
    public String getSikCd() {
        return _sikCd;
    }

    /**
     * �g�D�R�[�h��ݒ肷��
     * @param sikCd �g�D�R�[�h
     */
    public void setSikCd(String sikCd) {
        this._sikCd = sikCd;
    }

    /**
     * ���[�U�[ID���擾����
     * @return ���[�U�[ID
     */
    public String getUserId() {
        return _userId;
    }

    /**
     * ���[�U�[ID��ݒ肷��
     * @param userId ���[�U�[ID
     */
    public void setUserId(String userId) {
        this._userId = userId;
    }

}

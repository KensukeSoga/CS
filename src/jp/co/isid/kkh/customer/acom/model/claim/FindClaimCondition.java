package jp.co.isid.kkh.customer.acom.model.claim;

import java.io.Serializable;

public class FindClaimCondition implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /** ���O�C���S����ESQID */
    private String _esqId;
    /** �c�Ə��i��j�R�[�h */
    private String _egCd;
    /** ���Ӑ��ƃR�[�h */
    private String _tksKgyCd;
    /** ���Ӑ敔��SEQNO */
    private String _tksBmnSeqNo;
    /** ���Ӑ�S��SEQNO */
    private String _tksTntSeqNo;
    /** �N�� */
    private String _yymm;
    /** ��� */
    private String _sybt;
    /** �f�ړ� */
    private String _keisaiDay;

    /**
     * ���O�C���S����ESQID��Ԃ��܂��B
     *
     * @return esqId
     */
    public String getEsqId() {
        return _esqId;
    }

    /**
     * ���O�C���S����ESQID��ݒ肵�܂��B
     *
     * @param esqId
     */
    public void setEsqId(String esqId) {
        this._esqId = esqId;
    }

    /**
     * �c�Ə��i��j�R�[�h��Ԃ��܂��B
     *
     * @return egCd
     */
    public String getEgCd() {
        return _egCd;
    }

    /**
     * �c�Ə��i��j�R�[�h��ݒ肵�܂��B
     *
     * @param egCd
     */
    public void setEgCd(String egCd) {
        this._egCd = egCd;
    }

    /**
     * ���Ӑ��ƃR�[�h��Ԃ��܂��B
     *
     * @return tksKgyCd
     */
    public String getTksKgyCd() {
        return _tksKgyCd;
    }

    /**
     * ���Ӑ��ƃR�[�h��ݒ肵�܂��B
     *
     * @param tksKgyCd
     */
    public void setTksKgyCd(String tksKgyCd) {
        this._tksKgyCd = tksKgyCd;
    }

    /**
     * ���Ӑ敔��SEQNO��Ԃ��܂��B
     *
     * @return tksBmnSeqNo
     */
    public String getTksBmnSeqNo() {
        return _tksBmnSeqNo;
    }

    /**
     * ���Ӑ敔��SEQNO��ݒ肵�܂��B
     *
     * @param tksBmnSeqNo
     */
    public void setTksBmnSeqNo(String tksBmnSeqNo) {
        this._tksBmnSeqNo = tksBmnSeqNo;
    }

    /**
     * ���Ӑ�S��SEQNO��Ԃ��܂��B
     *
     * @return tksTntSeqNo
     */
    public String getTksTntSeqNo() {
        return _tksTntSeqNo;
    }

    /**
     * ���Ӑ�S��SEQNO��ݒ肵�܂��B
     *
     * * @param tksTntSeqNo
     */
    public void setTksTntSeqNo(String tksTntSeqNo) {
        this._tksTntSeqNo = tksTntSeqNo;
    }

    /**
     * �N����Ԃ��܂��B
     *
     * @return yymm
     */
    public String getYymm() {
        return _yymm;
    }

    /**
     * �N����ݒ肵�܂��B
     *
     * @param yymm
     */
    public void setYymm(String yymm) {
        this._yymm = yymm;
    }

    /**
     * ��ʂ�Ԃ��܂��B
     *
     * @return sybt
     */
    public String getSybt() {
        return _sybt;
    }

    /**
     * ��ʂ�ݒ肵�܂��B
     *
     * @param sybt
     */
    public void setSybt(String sybt) {
        this._sybt = sybt;
    }

    /**
     * �f�ړ���Ԃ��܂��B
     *
     * @return keisaiDay
     */
    public String getKeisaiDay() {
        return _keisaiDay;
    }

    /**
     * �f�ړ���ݒ肵�܂��B
     *
     * @param keisaiDay
     */
    public void setKeisaiDay(String keisaiDay) {
        this._keisaiDay = keisaiDay;
    }
}

package jp.co.isid.kkh.model.common;

import java.io.Serializable;

public class CommonCondition implements Serializable {

    private static final long serialVersionUID = 1L;

    /** ���O�C���S����ESQID */
    private String _esqId;
    /** �c�Ə��i��j�R�[�h(�K�{) */
    private String _egCd;
    /** ���Ӑ��ƃR�[�h(�K�{) */
    private String _tksKgyCd;
    /** ���Ӑ敔��SEQNO(�K�{) */
    private String _tksBmnSeqNo;
    /** ���Ӑ�S��SEQNO(�K�{) */
    private String _tksTntSeqNo;
    /** �}�X�^���  */
    private String _sybt;
    /** �}�X�^��� */
    private String _field1;

    /**
     * @return esqId
     */
    public String getEsqId() {
        return _esqId;
    }

    /**
     * @param esqId �Z�b�g���� esqId
     */
    public void setEsqId(String esqId) {
        this._esqId = esqId;
    }

    /**
     * @return egCd
     */
    public String getEgCd() {
        return _egCd;
    }

    /**
     * @param egCd �Z�b�g���� egCd
     */
    public void setEgCd(String egCd) {
        this._egCd = egCd;
    }

    /**
     * @return tksKgyCd
     */
    public String getTksKgyCd() {
        return _tksKgyCd;
    }

    /**
     * @param tksKgyCd �Z�b�g���� tksKgyCd
     */
    public void setTksKgyCd(String tksKgyCd) {
        this._tksKgyCd = tksKgyCd;
    }

    /**
     * @return tksBmnSeqNo
     */
    public String getTksBmnSeqNo() {
        return _tksBmnSeqNo;
    }

    /**
     * @param tksBmnSeqNo �Z�b�g���� tksBmnSeqNo
     */
    public void setTksBmnSeqNo(String tksBmnSeqNo) {
        this._tksBmnSeqNo = tksBmnSeqNo;
    }

    /**
     * @return tksTntSeqNo
     */
    public String getTksTntSeqNo() {
        return _tksTntSeqNo;
    }

    /**
     * @param tksTntSeqNo �Z�b�g���� tksTntSeqNo
     */
    public void setTksTntSeqNo(String tksTntSeqNo) {
        this._tksTntSeqNo = tksTntSeqNo;
    }

    /**
     * @return sybt
     */
    public String getSybt() {
        return _sybt;
    }

    /**
     * @param sybt �Z�b�g���� sybt
     */
    public void setSybt(String sybt) {
        this._sybt = sybt;
    }

    /**
     * @return field1
     */
    public String getfield1() {
        return _field1;
    }

    /**
     * @param field1 �Z�b�g���� field1
     */
    public void setfield1(String field1) {
        this._field1 = field1;
    }

}

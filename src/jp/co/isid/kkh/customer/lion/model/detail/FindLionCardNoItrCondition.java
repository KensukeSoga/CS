package jp.co.isid.kkh.customer.lion.model.detail;

import java.io.Serializable;

public class FindLionCardNoItrCondition implements Serializable {

    private static final long serialVersionUID = 1L;

    /** ���O�C���S����ESQID */
    private String _esqId;
    /** �c�Ə��i��j�R�[�h(�K�{) */
    private String _egCd;
    /** ���Ӑ��ƃR�[�h(�K�{) */
    private String _tksKgyCd;
    /** ���Ӑ敔��SEQNO(�K�{) */
    private String _tksbmnseqno;
    /** ���Ӑ�S��SEQNO(�K�{) */
    private String _tkstntseqno;
    /** ��� */
    private String _sybt;
    /** �R�[�h */
    private String _field1;
    /** ���� */
    private String _field2;
    /** �J�[�hNO */
    private String _code;

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
     * @return tksbmnseqno
     */
    public String getTksBmnSeqNo() {
        return _tksbmnseqno;
    }

    /**
     * @param tksbmnseqno �Z�b�g���� tksbmnseqno
     */
    public void setTksBmnSeqNo(String tksbmnseqno) {
        this._tksbmnseqno = tksbmnseqno;
    }

    /**
     * @return tkstntseqno
     */
    public String getTksTntSeqNo() {
        return _tkstntseqno;
    }

    /**
     * @param tkstntseqno �Z�b�g���� tkstntseqno
     */
    public void setTksTntSeqNo(String tkstntseqno) {
        this._tkstntseqno = tkstntseqno;
    }

    /**
     * @return sybt
     */
    public String getSybt() {
        return _sybt;
    }

    /**
     * @param kyokucd �Z�b�g���� sybt
     */
    public void setSybt(String sybt) {
        this._sybt = sybt;
    }

    /**
     * @return field1
     */
    public String getField1() {
        return _field1;
    }

    /**
     * @param field1 �Z�b�g���� field1
     */
    public void setField1(String field1) {
        this._field1 = field1;
    }

    /**
     * @return field2
     */
    public String getField2() {
        return _field2;
    }

    /**
     * @param field2 �Z�b�g���� field2
     */
    public void setField2(String field2) {
        this._field2 = field2;
    }

    /**
     * @return code
     */
    public String getCode() {
        return _code;
    }

    /**
     * @param code �Z�b�g���� code
     */
    public void setCode(String code) {
        this._code = code;
    }

}
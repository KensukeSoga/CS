package jp.co.isid.kkh.customer.lion.model.detail;

import java.io.Serializable;

public class FindLionCodeItrCondition implements Serializable {

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
    /** ���*/
    private String _cdNo;
    /** �}�̃R�[�h*/
    private String _btCd;

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
     * @return cdNo
     */
    public String getCdNo() {
        return _cdNo;
    }

    /**
     * @param cdNo �Z�b�g���� cdNo
     */
    public void setCdNo(String cdNo) {
        this._cdNo = cdNo;
    }

    /**
     * @return btCd
     */
    public String getBtCd() {
        return _btCd;
    }

    /**
     * @param btCd �Z�b�g���� btCd
     */
    public void setBtCd(String btCd) {
        this._btCd = btCd;
    }

}
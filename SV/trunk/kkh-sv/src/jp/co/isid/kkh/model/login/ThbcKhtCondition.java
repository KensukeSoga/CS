package jp.co.isid.kkh.model.login;

import java.io.Serializable;

public class ThbcKhtCondition implements Serializable {

    private static final long serialVersionUID = 1L;

    /** �c�Ə��R�[�h */
    private String _egCd = null;

    /** ���Ӑ��ƃR�[�h */
    private String _kgyCd = null;

    /** ���Ӑ敔��SEQNO */
    private String _bmnSeqNo = null;

    /** ���Ӑ�S��SEQNO */
    private String _tntSeqNo = null;

    /**
     * �c�Ə��R�[�h���擾����
     * @return �c�Ə��R�[�h
     */
    public String getEgCd() {
        return _egCd;
    }

    /**
     * �c�Ə��R�[�h��ݒ肷��
     * @param egCd �c�Ə��R�[�h
     */
    public void setEgCd(String egCd) {
        this._egCd = egCd;
    }

    /**
     * ���Ӑ��ƃR�[�h���擾����
     * @return ���Ӑ��ƃR�[�h
     */
    public String getKgyCd() {
        return _kgyCd;
    }

    /**
     * ���Ӑ��ƃR�[�h��ݒ肷��
     * @param kgyCd ���Ӑ��ƃR�[�h
     */
    public void setKgyCd(String kgyCd) {
        this._kgyCd = kgyCd;
    }

    /**
     * ���Ӑ敔��SEQNO���擾����
     * @return ���Ӑ敔��SEQNO
     */
    public String getBmnSeqNo() {
        return _bmnSeqNo;
    }

    /**
     * ���Ӑ敔��SEQNO��ݒ肷��
     * @param bmnSeqNo ���Ӑ敔��SEQNO
     */
    public void setBmnSeqNo(String bmnSeqNo) {
        this._bmnSeqNo = bmnSeqNo;
    }

    /**
     * ���Ӑ�S��SEQNO���擾����
     * @return ���Ӑ�S��SEQNO
     */
    public String getTntSeqNo() {
        return _tntSeqNo;
    }

    /**
     * ���Ӑ�S��SEQNO��ݒ肷��
     * @param tntSeqNo ���Ӑ�S��SEQNO
     */
    public void setTntSeqNo(String tntSeqNo) {
        this._tntSeqNo = tntSeqNo;
    }

}

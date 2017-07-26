package jp.co.isid.kkh.customer.mac.model.report;

import java.io.Serializable;

public class ReportMacGetDenNumCondition implements Serializable {

    private static final long serialVersionUID = 1L;

    /** ���O�C���S����ESQID */
    private String _esqId;
    /** �c�Ə��i��j�R�[�h(�K�{) */
    private String _egCd;
    /** ���Ӑ��ƃR�[�h(�K�{) */
    private String _tksKgyCd;
    /** ���Ӑ敔��R�[�h(�K�{) */
    private String _bmncd;
    /** ���Ӑ�S���R�[�h(�K�{) */
    private String _tntcd;

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
     * @return egCd
     */
    public String getBmncd() {
        return _bmncd;
    }
    /**
     * @param egCd �Z�b�g���� egCd
     */
    public void setBmncd(String bmncd) {
        this._bmncd = bmncd;
    }

    /**
     * @return egCd
     */
    public String getTntcd() {
        return _tntcd;
    }
    /**
     * @param egCd �Z�b�g���� egCd
     */
    public void setTntcd(String tntcd) {
        this._tntcd = tntcd;
    }

}

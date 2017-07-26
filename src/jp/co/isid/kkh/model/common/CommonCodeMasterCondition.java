package jp.co.isid.kkh.model.common;

import java.io.Serializable;

public class CommonCodeMasterCondition implements Serializable {

    private static final long serialVersionUID = 1L;

    /** ���O�C���S����ESQID */
    private String _esqId;
    /** KYCDKND */
    private String _kyCdKnd;
    /** ��� */
    private String _kijyunYmd;

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
     * @return _kyCdKnd
     */
    public String getKyCdKnd() {
        return _kyCdKnd;
    }

    /**
     * @param kyCdKnd �Z�b�g���� _kyCdKnd
     */
    public void setKyCdKnd(String kyCdKnd) {
        _kyCdKnd = kyCdKnd;
    }

    /**
     * @return _kijyunYmd
     */
    public String getKijyunYmd() {
        return _kijyunYmd;
    }

    /**
     * @param kijyunYmd �Z�b�g���� _kijyunYmd
     */
    public void setKijyunYmd(String kijyunYmd) {
        _kijyunYmd = kijyunYmd;
    }

}

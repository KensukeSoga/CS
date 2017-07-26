package jp.co.isid.kkh.model.history;

import java.io.Serializable;

public class HistoryJyutDownCondition implements Serializable {

    private static final long serialVersionUID = 1L;

    /** ���O�C���S����ESQID */
    private String _esqId;
    /** �c�Ə��i��j�R�[�h(�K�{) */
    private String _egCd;
    /** ���Ӑ��ƃR�[�h(�K�{) */
    private String _tksKgyCd;
    /** ���Ӑ敔��R�[�h(�K�{) */
    private String _tksBmnSeqNo;
    /** ���Ӑ�S���R�[�h(�K�{) */
    private String _tksTntSeqNo;
    /** �N��*/
    private String _yymm;

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
     * @return �N����Ԃ��܂�
     */
    public String get_yymm() {
        return _yymm;
    }
    /**
     * @param  �N�����Z�b�g���܂�
     */
    public void set_yymm(String yymm) {
        _yymm = yymm;
    }
    /**
     * @return �S���ҕ����Ԃ��܂�
     */
    public String get_tksBmnSeqNo() {
        return _tksBmnSeqNo;
    }
    /**
     * @param  �S���ҕ�����Z�b�g���܂�
     */
    public void set_tksBmnSeqNo(String tksBmnSeqNo) {
        _tksBmnSeqNo = tksBmnSeqNo;
    }
    /**
     * @return �S���҂�Ԃ��܂�
     */
    public String get_tksTntSeqNo() {
        return _tksTntSeqNo;
    }
    /**
     * @param  �S���҂��Z�b�g���܂�
     */
    public void set_tksTntSeqNo(String tksTntSeqNo) {
        _tksTntSeqNo = tksTntSeqNo;
    }

}

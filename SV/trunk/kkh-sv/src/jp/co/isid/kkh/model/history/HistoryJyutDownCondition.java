package jp.co.isid.kkh.model.history;

import java.io.Serializable;

public class HistoryJyutDownCondition implements Serializable {

    private static final long serialVersionUID = 1L;

    /** ログイン担当者ESQID */
    private String _esqId;
    /** 営業所（取）コード(必須) */
    private String _egCd;
    /** 得意先企業コード(必須) */
    private String _tksKgyCd;
    /** 得意先部門コード(必須) */
    private String _tksBmnSeqNo;
    /** 得意先担当コード(必須) */
    private String _tksTntSeqNo;
    /** 年月*/
    private String _yymm;

    /**
     * @return esqId
     */
    public String getEsqId() {
        return _esqId;
    }
    /**
     * @param esqId セットする esqId
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
     * @param egCd セットする egCd
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
     * @param tksKgyCd セットする tksKgyCd
     */
    public void setTksKgyCd(String tksKgyCd) {
        this._tksKgyCd = tksKgyCd;
    }

    /**
     * @return 年月を返します
     */
    public String get_yymm() {
        return _yymm;
    }
    /**
     * @param  年月をセットします
     */
    public void set_yymm(String yymm) {
        _yymm = yymm;
    }
    /**
     * @return 担当者部門を返します
     */
    public String get_tksBmnSeqNo() {
        return _tksBmnSeqNo;
    }
    /**
     * @param  担当者部門をセットします
     */
    public void set_tksBmnSeqNo(String tksBmnSeqNo) {
        _tksBmnSeqNo = tksBmnSeqNo;
    }
    /**
     * @return 担当者を返します
     */
    public String get_tksTntSeqNo() {
        return _tksTntSeqNo;
    }
    /**
     * @param  担当者をセットします
     */
    public void set_tksTntSeqNo(String tksTntSeqNo) {
        _tksTntSeqNo = tksTntSeqNo;
    }

}

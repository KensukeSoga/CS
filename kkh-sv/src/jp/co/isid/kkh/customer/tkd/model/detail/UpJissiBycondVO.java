package jp.co.isid.kkh.customer.tkd.model.detail;

import java.io.Serializable;

public class UpJissiBycondVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /** esqId */
    private String _esqId = null;

    /** aplId */
    private String _aplId = null;

    /** 営業所（取）コード */
    private String _egCd = null;

    /** 得意先企業コード */
    private String _tksKgyCd = null;

    /** 得意先部門SEQNO */
    private String _tksBmnSeqNo = null;

    /** 得意先担当SEQNO */
    private String _tksTntSeqNo = null;

    /** 変動値 */
    private String _atnum = null;

    /** 年月 */
    private String _YYMM = null;

    /** ダミープロパティ */
    private String _dummy = null;

    /**
     * esqIdを返します
     * @return esqId
     */
    public String getEsqId() {
        return _esqId;
    }

    /**
     * esqIdを設定する
     * @param esqId
     */
    public void setEsqId(String esqId) {
        this._esqId = esqId;
    }

    /**
     * aplIdを返します
     * @return aplId
     */
    public String get_aplId() {
        return _aplId;
    }

    /**
     * aplIdを設定する
     * @param aplId
     */
    public void set_aplId(String aplId) {
        _aplId = aplId;
    }

    /**
     * 営業所（取）コードを返します
     * @return egCd
     */
    public String get_egCd() {
        return _egCd;
    }

    /**
     * 営業所（取）コードを設定する
     * @param egCd
     */
    public void set_egCd(String egCd) {
        _egCd = egCd;
    }

    /**
     * 得意先企業コードを返します
     * @return tksKgyCd
     */
    public String get_tksKgyCd() {
        return _tksKgyCd;
    }

    /**
     * 得意先企業コードを設定する
     * @param tksKgyCd
     */
    public void set_tksKgyCd(String tksKgyCd) {
        _tksKgyCd = tksKgyCd;
    }

    /**
     * 得意先部門SEQNOを返します
     * @return tksBmnSeqNo
     */
    public String get_tksBmnSeqNo() {
        return _tksBmnSeqNo;
    }

    /**
     * 得意先部門SEQNOを設定する
     * @param tksBmnSeqNo
     */
    public void set_tksBmnSeqNo(String tksBmnSeqNo) {
        _tksBmnSeqNo = tksBmnSeqNo;
    }

    /**
     * 得意先担当SEQNOを返します
     * @return tksTntSeqNo
     */
    public String get_TksTntSeqNo() {
        return _tksTntSeqNo;
    }

    /**
     * 得意先担当SEQNOを設定する
     * @param tksTntSeqNo
     */
    public void set_TksTntSeqNo(String tksTntSeqNo) {
        this._tksTntSeqNo = tksTntSeqNo;
    }

    /**
     * 変動値を返します
     * @return atnum
     */
    public String get_atnum() {
        return _atnum;
    }

    /**
     * 変動値を設定する
     * @param atnum
     */
    public void set_atnum(String atnum) {
        _atnum = atnum;
    }

    /**
     * 年月を返します
     * @return yymm
     */
    public String get_YYMM() {
        return _YYMM;
    }

    /**
     * 年月を設定する
     * @param yymm
     */
    public void set_YYMM(String yymm) {
        _YYMM = yymm;
    }

    /**
     * ダミープロパティを取得する
     * @return ダミープロパティ
     */
    public String getDummy() {
        return _dummy;
    }

    /**
     * ダミープロパティを設定する
     * @param dummy ダミープロパティ
     */
    public void setDummy(String dummy) {
        this._dummy = dummy;
    }

}

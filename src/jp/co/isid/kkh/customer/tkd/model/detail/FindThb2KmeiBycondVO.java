package jp.co.isid.kkh.customer.tkd.model.detail;

import java.io.Serializable;

public class FindThb2KmeiBycondVO implements Serializable {

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

    /** 年月 */
    private String _YYMM = null;

    /** クリエーティブフラグ */
    private String creativeFlg = null;

    /** ダミープロパティ */
    private String _dummy = null;

    /**
     * esqIdを返します
     * @return yymm
     */
    public String get_esqId() {
        return _esqId;
    }

    /**
     * esqIdを設定する
     * @param esqId
     */
    public void set_esqId(String esqId) {
        _esqId = esqId;
    }

    /**
     * aplIdを返します
     * @return yymm
     */
    public String get_aplId() {
        return _aplId;
    }

    /**
     * aplIdを設定する
     * @param esqId
     */
    public void set_aplId(String aplId) {
        _aplId = aplId;
    }

    /**
     * 営業所（取）コードを返します
     * @return yymm
     */
    public String get_egCd() {
        return _egCd;
    }

    /**
     * 営業所（取）コードを設定する
     * @param esqId
     */
    public void set_egCd(String egCd) {
        _egCd = egCd;
    }

    /**
     * 得意先企業コードを返します
     * @return yymm
     */
    public String get_tksKgyCd() {
        return _tksKgyCd;
    }

    /**
     * 得意先企業コードを設定する
     * @param esqId
     */
    public void set_tksKgyCd(String tksKgyCd) {
        _tksKgyCd = tksKgyCd;
    }

    /**
     * 得意先部門SEQNOを返します
     * @return yymm
     */
    public String get_tksBmnSeqNo() {
        return _tksBmnSeqNo;
    }

    /**
     * 得意先部門SEQNOを設定する
     * @param esqId
     */
    public void set_tksBmnSeqNo(String tksBmnSeqNo) {
        _tksBmnSeqNo = tksBmnSeqNo;
    }

    /**
     * 得意先担当SEQNOを返します
     * @return yymm
     */
    public String get_tksTntSeqNo() {
        return _tksTntSeqNo;
    }

    /**
     * 得意先担当SEQNOを設定する
     * @param esqId
     */
    public void set_tksTntSeqNo(String tksTntSeqNo) {
        _tksTntSeqNo = tksTntSeqNo;
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
     * クリエーティブフラグを返します
     * @return yymm
     */
    public String getCreativeFlg() {
        return creativeFlg;
    }

    /**
     * クリエーティブフラグを設定する
     * @param esqId
     */
    public void setCreativeFlg(String val) {
        creativeFlg = val;
    }

    /**
     * ダミープロパティを返します
     * @return yymm
     */
    public String get_dummy() {
        return _dummy;
    }

    /**
     * ダミープロパティを設定する
     * @param esqId
     */
    public void set_dummy(String dummy) {
        _dummy = dummy;
    }

}

package jp.co.isid.kkh.customer.acom.model.detail;

import java.io.Serializable;

public class FindHatyuNumByCondVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**esqId*/
    private String _esqId = null;

    /**aplId*/
    private String _aplId = null;

    /**営業所（取）コード*/
    private String _egCd = null;

    /**得意先企業コード*/
    private String _tksKgyCd = null;

    /**得意先部門SEQNO*/
    private String _tksBmnSeqNo = null;

    /**得意先担当SEQNO*/
    private String _tksTntSeqNo = null;

    /**依頼番号*/
    private String _Irban = null;

    /**依頼行番号*/
    private String _Irrowban = null;

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
     * 依頼番号を返します
     * @return _Irban
     */
    public String get_Irban() {
        return _Irban;
    }

    /**
     * 依頼番号を設定する
     * @param esqId
     */
    public void set_Irban(String irban) {
        _Irban = irban;
    }

    /**
     * 依頼行番号を返します
     * @return _Irrowban
     */
    public String get_Irrowban() {
        return _Irrowban;
    }

    /**
     * 依頼行番号を設定する
     * @param esqId
     */
    public void set_Irrowban(String irrowban) {
        _Irrowban = irrowban;
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

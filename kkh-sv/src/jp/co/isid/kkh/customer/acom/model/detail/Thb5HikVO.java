package jp.co.isid.kkh.customer.acom.model.detail;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(namespace = "http://detail.model.kkh.isid.co.jp/")
@XmlType(namespace = "http://detail.model.kkh.isid.co.jp/")
public class Thb5HikVO implements Serializable {

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

    /** 依頼番号 */
    private String _irban = null;

    /** 依頼行番号 */
    private String _irGyoBan = null;

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
     * @return _aplId
     */
    public String get_aplId() {
        return _aplId;
    }

    /**
     * aplIdを設定する
     * @param _aplId
     */
    public void set_aplId(String aplId) {
        _aplId = aplId;
    }

    /**
     * 営業所（取）コードを返します
     * @return _egCd
     */
    public String get_egCd() {
        return _egCd;
    }

    /**
     * 営業所（取）コードを設定する
     * @param _egCd
     */
    public void set_egCd(String egCd) {
        _egCd = egCd;
    }

    /**
     * 得意先企業コードを返します
     * @return _tksKgyCd
     */
    public String get_tksKgyCd() {
        return _tksKgyCd;
    }

    /**
     * 得意先企業コードを設定する
     * @param _tksKgyCd
     */
    public void set_tksKgyCd(String tksKgyCd) {
        _tksKgyCd = tksKgyCd;
    }

    /**
     * 得意先部門SEQNOを返します
     * @return _tksBmnSeqNo
     */
    public String get_tksBmnSeqNo() {
        return _tksBmnSeqNo;
    }

    /**
     * 得意先部門SEQNOを設定する
     * @param _tksBmnSeqNo
     */
    public void set_tksBmnSeqNo(String tksBmnSeqNo) {
        _tksBmnSeqNo = tksBmnSeqNo;
    }

    /**
     * 得意先担当SEQNOを返します
     * @return _tksTntSeqNo
     */
    public String get_tksTntSeqNo() {
        return _tksTntSeqNo;
    }

    /**
     * 得意先担当SEQNOを設定する
     * @param _tksTntSeqNo
     */
    public void set_tksTntSeqNo(String tksTntSeqNo) {
        _tksTntSeqNo = tksTntSeqNo;
    }

    /**
     * 依頼番号を返します
     * @return _irban
     */
    public String get_irban() {
        return _irban;
    }

    /**
     * 依頼番号を設定する
     * @param _irban
     */
    public void set_irban(String irban) {
        _irban = irban;
    }

    /**
     * 依頼行番号を返します
     * @return _irban
     */
    public String get_irGyoBan() {
        return _irGyoBan;
    }

    /**
     * 依頼行番号を設定する
     * @param _irban
     */
    public void set_irGyoBan(String irGyoBan) {
        _irGyoBan = irGyoBan;
    }

}

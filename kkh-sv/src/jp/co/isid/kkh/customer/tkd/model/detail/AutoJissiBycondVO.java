package jp.co.isid.kkh.customer.tkd.model.detail;

import java.io.Serializable;

public class AutoJissiBycondVO implements Serializable {

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

    /** 受注No */
    private String[] _jyutNo;

    /** 受注明細No */
    private String[] _jyMeiNo;

    /** 売上明細No */
    private String[] _urMeiNo;

    /** 変動値 */
    private String fuyoOrUpdown;

    /** 配分率 */
    private String[] _haibun;

    /** 媒体コード */
    private String[] _baitaiCd;

    /** 実施No */
    private String[] _jissiNo;

    /** ダミープロパティ */
    private String _dummy = null;

    /** 連番 */
    private String[] _Renban = null;

    private int num = 0;
    private int num2 = 0;

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
     * @param esqId
     */
    public void set_YYMM(String yymm) {
        _YYMM = yymm;
    }

    /**
     * 受注Noを返します
     * @return yymm
     */
    public String[] get_jyutNo() {
        return _jyutNo;
    }

    /**
     * 受注Noを設定する
     * @param _jyutNo
     */
    public void set_jyutNo(String[] jyutNo) {
        _jyutNo = jyutNo;
    }

    /**
     * 受注明細Noを返します
     * @return _jyMeiNo
     */
    public String[] get_jyMeiNo() {
        return _jyMeiNo;
    }

    /**
     * 受注明細Noを設定する
     * @param _jyMeiNo
     */
    public void set_jyMeiNo(String[] jyMeiNo) {
        _jyMeiNo = jyMeiNo;
    }

    /**
     * 売上明細Noを返します
     * @return _urMeiNo
     */
    public String[] get_urMeiNo() {
        return _urMeiNo;
    }

    /**
     * 売上明細Noを設定する
     * @param _urMeiNo
     */
    public void set_urMeiNo(String[] urMeiNo) {
        _urMeiNo = urMeiNo;
    }

    /**
     * 変動値を返します
     * @return fuyoOrUpdown
     */
    public String getFuyoOrUpdown() {
        return fuyoOrUpdown;
    }

    /** 変動値を設定する
     * @param fuyoOrUpdown
     */
    public void setFuyoOrUpdown(String fuyoOrUpdown) {
        this.fuyoOrUpdown = fuyoOrUpdown;
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

    /**
     * 値を返します
     * @return num
     */
    public int getNum() {
        return num;
    }

    /**
     * 値を設定する
     * @param num
     */
    public void setNum(int num) {
        this.num = num;
    }

    /**
     * 配分率を返します
     * @return haibun
     */
    public String[] get_haibun() {
        return _haibun;
    }

    /**
     * 配分率を設定する
     * @param haibun
     */
    public void set_haibun(String[] haibun) {
        _haibun = haibun;
    }

    /**
     * 媒体コードを返します
     * @return baitaiCd
     */
    public String[] get_BaitaiCd() {
        return _baitaiCd;
    }

    /**
     * 媒体コードを設定する
     * @param baitaiCd
     */
    public void set_BaitaiCd(String[] baitaiCd) {
        _baitaiCd = baitaiCd;
    }

    /**
     * 実施Noを返します
     * @return jissiNo
     */
    public String[] get_JissiNo() {
        return _jissiNo;
    }

    /**
     * 実施Noを設定する
     * @param baitaiCd
     */
    public void set_JissiNo(String[] jissiNo) {
        _jissiNo = jissiNo;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public String[] get_Renban() {
        return _Renban;
    }

    public void set_Renban(String[] renban) {
        _Renban = renban;
    }

}

package jp.co.isid.kkh.model.detail;

import java.io.Serializable;

public class JyutNoTouInsVO implements Serializable {

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

    /** 統合受注No */
    private String _keyJyutno = null;

    /** 統合受注明細No */
    private String _keyJyMeiNo = null;

    /** 統合売上明細No */
    private String _keyUriMeiNo = null;

    /** 費目コード */
    private String _himkCd = null;

    /** 業務区分 */
    private String _gyomKbn = null;

    /** 国際マス正味区分 */
    private String _msKbn = null;

    /** タイムスポット区分 */
    private String _tmsKbn = null;

    /** 国際区分 */
    private String _kokKbn = null;

    /** 請求区分 */
    private String _seiKbn = null;

    /** 商品No */
    private String _syoNo = null;

    /** 件名 */
    private String _kknameKj = null;

    /** 営業画面タイプ */
    private String _egGamenType = null;

    /** 企画・製版区分 */
    private String _kkakShanKbn = null;

    /** 取り料金 */
    private String _toriRyouKin = null;

    /** 請求金額 */
    private String _seikyuKin = null;

    /** 値引率 */
    private String _nebikiRitu = null;

    /** 値引額 */
    private String _nebikiGaku = null;

    /** 消費税区分 */
    private String _szeiKbn = null;

    /** 消費税率 */
    private String _szeiRitu = null;

    /** 消費税額 */
    private String _szeiGaku = null;

    /** 費目名 */
    private String _himkNmkj = null;
    /** フィールド1 */
    private String _field1 = null;
    /** フィールド2 */
    private String _field2 = null;
    /** フィールド3 */
    private String _field3 = null;
    /** フィールド4 */
    private String _field4 = null;
    /** フィールド5 */
    private String _field5 = null;
    /** フィールド6 */
    private String _field6 = null;
    /** フィールド7 */
    private String _field7 = null;
    /** フィールド8 */
    private String _field8 = null;
    /** フィールド9 */
    private String _field9 = null;
    /** フィールド10 */
    private String _field10 = null;
    /** フィールド11 */
    private String _field11 = null;
    /** フィールド12 */
    private String _field12 = null;
    /** ダウンロードファイルタイムスタンプ */
    private String _fileTimStmp = null;
    /** 明細登録日時 */
    private String _meiTimStmp = null;
    /** 受注削除フラグ */
    private String _jyutDelFlg = null;
    /**  ダミープロパティ */
    private String _dummy = null;

    /**
     * esqIdを返します
     * @return String ESQ-ID
     */
    public String get_esqId() {
        return _esqId;
    }

    /**
     * esqIdを設定する
     * @param esqid String ESQ-ID
     */
    public void set_esqId(String esqId) {
        _esqId = esqId;
    }

    /**
     * aplIdを返します
     * @return String アプリID
     */
    public String get_aplId() {
        return _aplId;
    }

    /**
     * aplIdを設定する
     * @param aplId String アプリID
     */
    public void set_aplId(String aplId) {
        _aplId = aplId;
    }

    /**
     * 営業所コードを返します
     * @return String 営業所コード
     */
    public String get_egCd() {
        return _egCd;
    }

    /**
     * 営業所コードを設定する
     * @param egCd String 営業所コード
     */
    public void set_egCd(String egCd) {
        _egCd = egCd;
    }

    /**
     * 得意先企業コードを返します
     * @return String 得意先企業コード
     */
    public String get_tksKgyCd() {
        return _tksKgyCd;
    }

    /**
     * 得意先企業コードを設定する
     * @param tkskgycd String 得意先企業コード
     */
    public void set_tksKgyCd(String tksKgyCd) {
        _tksKgyCd = tksKgyCd;
    }

    /**
     * 得意先部門SEQNOを返します
     * @return String 得意先部門SEQNO
     */
    public String get_tksBmnSeqNo() {
        return _tksBmnSeqNo;
    }

    /**
     * 得意先部門SEQNOを設定する
     * @param tksBmnSeqNo String 得意先部門SEQNO
     */
    public void set_tksBmnSeqNo(String tksBmnSeqNo) {
        _tksBmnSeqNo = tksBmnSeqNo;
    }

    /**
     * 得意先担当SEQNOを返します
     * @return String 得意先担当SEQNO
     */
    public String get_tksTntSeqNo() {
        return _tksTntSeqNo;
    }

    /**
     * 得意先担当SEQNOを設定する
     * @param tkstntseqno String 得意先担当SEQNO
     */
    public void set_tksTntSeqNo(String tksTntSeqNo) {
        _tksTntSeqNo = tksTntSeqNo;
    }

    /**
     * 年月を返します
     * @return String 年月
     */
    public String get_YYMM() {
        return _YYMM;
    }

    /**
     * 年月を設定する
     * @param yymm String 年月
     */
    public void set_YYMM(String yymm) {
        _YYMM = yymm;
    }
    /**
     * 統合受注Noを返します
     * @return String 統合受注No
     */
    public String get_keyJyutno() {
        return _keyJyutno;
    }
    /**
     * 統合受注Noを設定する
     * @param keyJyutno String 統合受注No
     */
    public void set_keyJyutno(String keyJyutno) {
        _keyJyutno = keyJyutno;
    }

    /**
     * 統合受注明細Noを返します
     * @return String 統合受注明細No
     */
    public String get_keyJyMeiNo() {
        return _keyJyMeiNo;
    }

    /**
     * 統合受注明細Noを設定する
     * @param keyJyMeiNo String 統合受注明細No
     */
    public void set_keyJyMeiNo(String keyJyMeiNo) {
        _keyJyMeiNo = keyJyMeiNo;
    }

    /**
     * 統合売上明細Noを返します
     * @return String 統合売上明細No
     */
    public String get_keyUriMeiNo() {
        return _keyUriMeiNo;
    }

    /**
     * 統合売上明細Noを設定する
     * @param _keyUriMeiNo String 統合売上明細No
     */
    public void set_keyUriMeiNo(String keyUriMeiNo) {
        _keyUriMeiNo = keyUriMeiNo;
    }

    /**
     * 費目コードを返します
     * @return String 費目コード
     */
    public String get_himkCd() {
        return _himkCd;
    }
    /**
     * 費目コードを設定する
     * @param _himkCd String 費目コード
     */
    public void set_himkCd(String himkCd) {
        _himkCd = himkCd;
    }

    /**
     * 業務区分を返します
     * @return String 業務区分
     */
    public String get_gyomKbn() {
        return _gyomKbn;
    }

    /**
     * 業務区分を設定する
     * @param gyomKbn String 業務区分
     */
    public void set_gyomKbn(String gyomKbn) {
        _gyomKbn = gyomKbn;
    }

    /**
     * 国際マス正味区分を返します
     * @return String 国際マス正味区分
     */
    public String get_msKbn() {
        return _msKbn;
    }

    /**
     * 国際マス正味区分を設定する
     * @param msKbn String 国際マス正味区分
     */
    public void set_msKbn(String msKbn) {
        _msKbn = msKbn;
    }

    /**
     * タイムスポット区分を返します
     * @return String タイムスポット区分
     */
    public String get_tmsKbn() {
        return _tmsKbn;
    }

    /**
     * タイムスポット区分を設定する
     * @param tmsKbn String タイムスポット区分
     */
    public void set_tmsKbn(String tmsKbn) {
        _tmsKbn = tmsKbn;
    }

    /**
     * 国際区分を返します
     * @return String 国際区分
     */
    public String get_kokKbn() {
        return _kokKbn;
    }

    /**
     * 国際区分を設定する
     * @param kokKbn String 国際区分
     */
    public void set_kokKbn(String kokKbn) {
        _kokKbn = kokKbn;
    }

    /**
     * 請求区分を返します
     * @return String 請求区分
     */
    public String get_seiKbn() {
        return _seiKbn;
    }

    /**
     * 請求区分を設定する
     * @param seiKbn String 請求区分
     */
    public void set_seiKbn(String seiKbn) {
        _seiKbn = seiKbn;
    }

    /**
     * 商品Noを返します
     * @return String 商品No
     */
    public String get_syoNo() {
        return _syoNo;
    }

    /**
     * 商品Noを設定する
     * @param syoNo String 商品No
     */
    public void set_syoNo(String syoNo) {
        _syoNo = syoNo;
    }

    /**
     * 件名を返します
     * @return String 件名
     */
    public String get_kknameKj() {
        return _kknameKj;
    }

    /**
     * 件名を設定する
     * @param _kknameKj
     */
    public void set_kknameKj(String kknameKj) {
        _kknameKj = kknameKj;
    }

    /**
     * 営業画面タイプを返します
     * @return _egGamenType
     */
    public String get_egGamenType() {
        return _egGamenType;
    }

    /**
     * 営業画面タイプを設定する
     * @param _egGamenType
     */
    public void set_egGamenType(String egGamenType) {
        _egGamenType = egGamenType;
    }

    /**
     * 企画・製版区分を返します
     * @return _kkakShanKbn
     */
    public String get_kkakShanKbn() {
        return _kkakShanKbn;
    }

    /**
     * 企画・製版区分を設定する
     * @param _kkakShanKbn
     */
    public void set_kkakShanKbn(String kkakShanKbn) {
        _kkakShanKbn = kkakShanKbn;
    }

    /**
     * 取り料金を返します
     * @return _toriRyouKin
     */
    public String get_toriRyouKin() {
        return _toriRyouKin;
    }

    /**
     * 取り料金を設定する
     * @param _toriRyouKin
     */
    public void set_toriRyouKin(String toriRyouKin) {
        _toriRyouKin = toriRyouKin;
    }

    /**
     * 請求金額を返します
     * @return _seikyuKin
     */
    public String get_seikyuKin() {
        return _seikyuKin;
    }

    /**
     * 請求金額を設定する
     * @param _seikyuKin
     */
    public void set_seikyuKin(String seikyuKin) {
        _seikyuKin = seikyuKin;
    }

    /**
     * 値引率を返します
     * @return _nebikiRitu
     */
    public String get_nebikiRitu() {
        return _nebikiRitu;
    }

    /**
     * 値引率を設定する
     * @param _nebikiRitu
     */
    public void set_nebikiRitu(String nebikiRitu) {
        _nebikiRitu = nebikiRitu;
    }

    /**
     * 値引額を返します
     * @return _nebikiGaku
     */
    public String get_nebikiGaku() {
        return _nebikiGaku;
    }

    /**
     * 値引額を設定する
     * @param _nebikiGaku
     */
    public void set_nebikiGaku(String nebikiGaku) {
        _nebikiGaku = nebikiGaku;
    }

    /**
     * 消費税区分を返します
     * @return _szeiKbn
     */
    public String get_szeiKbn() {
        return _szeiKbn;
    }

    /**
     * 消費税区分を設定する
     * @param _szeiKbn
     */
    public void set_szeiKbn(String szeiKbn) {
        _szeiKbn = szeiKbn;
    }

    /**
     * 消費税率を返します
     * @return _szeiRitu
     */
    public String get_szeiRitu() {
        return _szeiRitu;
    }

    /**
     * 消費税率を設定する
     * @param _szeiRitu
     */
    public void set_szeiRitu(String szeiRitu) {
        _szeiRitu = szeiRitu;
    }

    /**
     * 消費税額を返します
     * @return _szeiGaku
     */
    public String get_szeiGaku() {
        return _szeiGaku;
    }

    /**
     * 消費税額を設定する
     * @param _szeiGaku
     */
    public void set_szeiGaku(String szeiGaku) {
        _szeiGaku = szeiGaku;
    }

    /**
     * 費目名を返します
     * @return _himkNmkj
     */
    public String get_himkNmkj() {
        return _himkNmkj;
    }

    /**
     * 費目名を設定する
     * @param _himkNmkj
     */
    public void set_himkNmkj(String himkNmkj) {
        _himkNmkj = himkNmkj;
    }

    /**
     * フィールド1を返します
     * @return _field1
     */
    public String get_field1() {
        return _field1;
    }

    /**
     * フィールド1を設定する
     * @param _field1
     */
    public void set_field1(String field1) {
        _field1 = field1;
    }

    public String get_field2() {
        return _field2;
    }

    public void set_field2(String field2) {
        _field2 = field2;
    }

    public String get_field3() {
        return _field3;
    }

    public void set_field3(String field3) {
        _field3 = field3;
    }

    public String get_field4() {
        return _field4;
    }

    public void set_field4(String field4) {
        _field4 = field4;
    }

    public String get_field5() {
        return _field5;
    }

    public void set_field5(String field5) {
        _field5 = field5;
    }

    public String get_field6() {
        return _field6;
    }

    public void set_field6(String field6) {
        _field6 = field6;
    }

    public String get_field7() {
        return _field7;
    }

    public void set_field7(String field7) {
        _field7 = field7;
    }

    public String get_field8() {
        return _field8;
    }

    public void set_field8(String field8) {
        _field8 = field8;
    }

    public String get_field9() {
        return _field9;
    }

    public void set_field9(String field9) {
        _field9 = field9;
    }

    public String get_field10() {
        return _field10;
    }

    public void set_field10(String field10) {
        _field10 = field10;
    }

    public String get_field11() {
        return _field11;
    }

    public void set_field11(String field11) {
        _field11 = field11;
    }

    public String get_field12() {
        return _field12;
    }

    public void set_field12(String field12) {
        _field12 = field12;
    }

    public String get_fileTimStmp() {
        return _fileTimStmp;
    }

    public void set_fileTimStmp(String fileTimStmp) {
        _fileTimStmp = fileTimStmp;
    }

    public String get_meiTimStmp() {
        return _meiTimStmp;
    }

    public void set_meiTimStmp(String meiTimStmp) {
        _meiTimStmp = meiTimStmp;
    }

    public String get_jyutDelFlg() {
        return _jyutDelFlg;
    }

    public void set_jyutDelFlg(String jyutDelFlg) {
        _jyutDelFlg = jyutDelFlg;
    }

    /**
     * ダミープロパティを返します
     * @return _dummy
     */
    public String get_dummy() {
        return _dummy;
    }

    /**
     * ダミープロパティを設定する
     * @param _dummy
     */
    public void set_dummy(String dummy) {
        _dummy = dummy;
    }

}

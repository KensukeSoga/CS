package jp.co.isid.kkh.model.detail;

import java.io.Serializable;

public class JyutNoTouUpdateVO implements Serializable {

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

    /**年月*/
    private String _YYMM = null;

    /**受注No*/
//	private String[] _jyutNo;

    /**受注明細No*/
//	private String[] _jyMeiNo;

    /**売上明細No*/
//	private String[] _urMeiNo;

    /**統合受注No*/
    private String _keyJyutno = null;

    /**統合受注明細No*/
    private String _keyJyMeiNo = null;

    /**統合売上明細No*/
    private String _keyUriMeiNo = null;

    /**複数Updateの為の変数*/
    private int Num = 0;

    /**業務区分*/
    private String _Gyomkbn = null;
    /**タイムスポット区分*/
    private String _Tmspkbn = null;

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
     * 業務区分を返します
     * @return yymm
     */
    public String get_Gyomkbn() {
        return _Gyomkbn;
    }

    /**
     * 業務区分を設定する
     * @param esqId
     */
    public void set_Gyomkbn(String Gyomkbn) {
        _Gyomkbn = Gyomkbn;
    }

    /**
     * タイムスポット区分を返します
     * @return yymm
     */
    public String get_Tmspkbn() {
        return _Tmspkbn;
    }

    /**
     * タイムスポット区分を設定する
     * @param esqId
     */
    public void set_Tmspkbn(String Tmspkbn) {
        _Tmspkbn = Tmspkbn;
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
     *統合受注Noを返します
     * @return _keyJyutno
     */
    public String get_keyJyutno() {
        return _keyJyutno;
    }

    /**
     * 統合受注Noを設定する
     * @param _keyJyutno
     */
    public void set_keyJyutno(String keyJyutno) {
        _keyJyutno = keyJyutno;
    }

    /**
     * 統合受注明細Noを返します
     * @return _keyJyMeiNo
     */
    public String get_keyJyMeiNo() {
        return _keyJyMeiNo;
    }

    /**
     * 統合受注明細Noを設定する
     * @param _keyJyMeiNo
     */
    public void set_keyJyMeiNo(String keyJyMeiNo) {
        _keyJyMeiNo = keyJyMeiNo;
    }

    /**
     * 統合売上明細Noを返します
     * @return _keyUriMeiNo
     */
    public String get_keyUriMeiNo() {
        return _keyUriMeiNo;
    }

    /**
     * 統合売上明細Noを設定する
     * @param _keyUriMeiNo
     */
    public void set_keyUriMeiNo(String keyUriMeiNo) {
        _keyUriMeiNo = keyUriMeiNo;
    }

    public int getNum() {
        return Num;
    }

    public void setNum(int num) {
        Num = num;
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

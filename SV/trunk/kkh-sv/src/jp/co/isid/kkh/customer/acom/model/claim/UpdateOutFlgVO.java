package jp.co.isid.kkh.customer.acom.model.claim;

import jp.co.isid.kkh.model.detail.Thb2KmeiVO;

/**
 * <P>
 * 送信フラグ更新情報VO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/2/20 JSE Y.Sato)<BR>
 * </P>
 *
 * @author JSE Y.Sato
 */
public class UpdateOutFlgVO extends Thb2KmeiVO {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * 新規インスタンスを構築します。
     */
    public UpdateOutFlgVO() {
        super();
    }

    /**
     * 新規インスタンスを構築します。
     *
     * @return 新規インスタンス
     */
    public Object newInstance() {
        return new UpdateOutFlgVO();
    }

    /** ログイン担当者ESQID */
    private String _esqId = null;
    /** アプリID */
    private String _aplId = null;
    /** 営業所（取）コード */
    private String _egCd = null;
    /** 得意先企業コード */
    private String _tksKgyCd = null;
    /** 得意先部門SEQNO */
    private String _tksBmnSeqNo = null;
    /** 得意先担当SEQNO */
    private String _tksTntSeqNo = null;
    /** 受注No */
    private String[] _jyutNo = null;
    /** 受注明細No */
    private String[] _jyMeiNo = null;
    /** 売上明細No */
    private String[] _urMeiNo = null;
    /** 連番 */
    private String[] _renban = null;
    /** 送信フラグ */
    private String _outFlg = null;
    /** 出力日時 */
    private String _outDate = null;
    /** 請求書No */
    private String[] _seiNo = null;
    /** 請求書行No */
    private String[] _seiGyoNo = null;
    /** 請求年月日 */
    private String[] _seiYymm = null;
    /** ダミープロパティ */
    private String _dummy = null;

    /**
     * ログイン担当者ESQIDを取得する
     * @return ログイン担当者ESQID
     */
    public String getEsqId() {
        return _esqId;
    }

    /**
     * ログイン担当者ESQIDを設定する
     * @param esqId ログイン担当者ESQID
     */
    public void setEsqId(String esqId) {
        this._esqId = esqId;
    }

    /**
     * アプリIDを取得する
     * @return アプリID
     */
    public String getAplId() {
        return _aplId;
    }

    /**
     * アプリIDを設定する
     * @param aplId アプリID
     */
    public void setAplId(String aplId) {
        this._aplId = aplId;
    }

    /**
     * 営業所（取）コードを取得する
     * @return 営業所（取）コード
     */
    public String getEgCd() {
        return _egCd;
    }

    /**
     * 営業所（取）コードを設定する
     * @param egCd 営業所（取）コード
     */
    public void setEgCd(String egCd) {
        this._egCd = egCd;
    }

    /**
     * 得意先企業コードを取得する
     * @return 得意先企業コード
     */
    public String getTksKgyCd() {
        return _tksKgyCd;
    }

    /**
     * 得意先企業コードを設定する
     * @param tksKgyCd 得意先企業コード
     */
    public void setTksKgyCd(String tksKgyCd) {
        this._tksKgyCd = tksKgyCd;
    }

    /**
     * 得意先部門SEQNOを取得する
     * @return 得意先部門SEQNO
     */
    public String getTksBmnSeqNo() {
        return _tksBmnSeqNo;
    }

    /**
     * 得意先部門SEQNOを設定する
     * @param tksBmnSeqNo 得意先部門SEQNO
     */
    public void setTksBmnSeqNo(String tksBmnSeqNo) {
        this._tksBmnSeqNo = tksBmnSeqNo;
    }

    /**
     * 得意先担当SEQNOを取得する
     * @return 得意先担当SEQNO
     */
    public String getTksTntSeqNo() {
        return _tksTntSeqNo;
    }

    /**
     * 得意先担当SEQNOを設定する
     * @param tksTntSeqNo 得意先担当SEQNO
     */
    public void setTksTntSeqNo(String tksTntSeqNo) {
        this._tksTntSeqNo = tksTntSeqNo;
    }

    /**
     * 受注Noを取得する
     * @return 受注No
     */
    public String[] getJyutNo() {
        return _jyutNo;
    }

    /**
     * 受注Noを設定する
     * @param jyutNo 受注No
     */
    public void setJyutNo(String[] jyutNo) {
        _jyutNo = jyutNo;
    }

    /**
     * 受注明細Noを取得する
     * @return _jyMeiNo 受注明細No
     */
    public String[] getJyMeiNo() {
        return _jyMeiNo;
    }

    /**
     * 受注明細Noを設定する
     * @param jyMeiNo 受注明細No
     */
    public void setJyMeiNo(String[] jyMeiNo) {
        _jyMeiNo = jyMeiNo;
    }

    /**
     * 売上明細Noを取得する
     * @return _urMeiNo
     */
    public String[] getUrMeiNo() {
        return _urMeiNo;
    }

    /**
     * 売上明細Noを設定する
     * @param urMeiNo 売上明細No
     */
    public void setUrMeiNo(String[] urMeiNo) {
        _urMeiNo = urMeiNo;
    }

    /**
     * 出力日時を取得する
     * @return _outFlg 出力日時
     */
    public String getOutDate() {
        return _outDate;
    }

    /**
     * 出力日時を設定する
     * @param outFlg 出力日時
     */
    public void setOutDate(String outDate) {
        _outDate = outDate;
    }

    /**
     * 送信フラグを取得する
     * @return _outFlg 送信フラグ
     */
    public String getOutFlg() {
        return _outFlg;
    }

    /**
     * 送信フラグを設定する
     * @param outFlg 送信フラグ
     */
    public void setOutFlg(String outFlg) {
        _outFlg = outFlg;
    }

    /**
     * 連番を取得する
     * @return _renban 連番
     */
    public String[] getRenban() {
        return _renban;
    }

    /**
     * 連番を設定する
     * @param renban 連番
     */
    public void setRenban(String[] renban) {
        _renban = renban;
    }

    /**
     * 請求書Noを取得する
     * @return _seiNo 請求書No
     */
    public String[] getSeiNo() {
        return _seiNo;
    }

    /**
     * 請求書Noを設定する
     * @param seiNo 請求書No
     */
    public void setSeiNo(String[] seiNo) {
        _seiNo = seiNo;
    }

    /**
     * 請求書行Noを取得する
     * @return _seiGyoNo 請求書行No
     */
    public String[] getSeiGyoNo() {
        return _seiGyoNo;
    }

    /**
     * 請求書行Noを設定する
     * @param seiGyoNo 請求書行No
     */
    public void setSeiGyoNo(String[] seiGyoNo) {
        _seiGyoNo = seiGyoNo;
    }

    /**
     * 請求年月日を取得する
     * @return _seiYymm 請求年月日
     */
    public String[] getSeiYymm() {
        return _seiYymm;
    }

    /**
     * 請求年月日を設定する
     * @param seiYymm 請求年月日
     */
    public void setSeiYymm(String[] seiYymm) {
        _seiYymm = seiYymm;
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

package jp.co.isid.kkh.model.detail;

import java.io.Serializable;

public class Thb8DownRCondition implements Serializable {

    private static final long serialVersionUID = 1L;

    /** ログイン担当者ESQID */
    private String _esqId = null;

    /** 営業所（取）コード */
    private String _egCd = null;

    /** 得意先企業コード */
    private String _tksKgyCd = null;

    /** 得意先部門SEQNO */
    private String _tksBmnSeqNo = null;

    /** 得意先担当SEQNO */
    private String _tksTntSeqNo = null;

    /** 年月 */
    private String _yymm = null;

    /** 受注No */
    private String _jyutNo = null;

    /** 受注明細No */
    private String _jyMeiNo = null;

    /** 売上明細No */
    private String _urMeiNo = null;

    /** 統合フラグ */
    private String _touFlg = null;

    /** ファイルタイムスタンプ */
    private String _fileTimStmp = null;

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
     * 年月を取得する
     * @return 年月
     */
    public String getYymm() {
        return _yymm;
    }

    /**
     * 年月を設定する
     * @param yymm 年月
     */
    public void setYymm(String yymm) {
        this._yymm = yymm;
    }

    /**
     * 受注Noを取得する
     * @return 受注No
     */
    public String getJyutNo() {
        return _jyutNo;
    }

    /**
     * 受注Noを設定する
     * @param jyutNo 受注No
     */
    public void setJyutNo(String jyutNo) {
        this._jyutNo = jyutNo;
    }

    /**
     * 受注明細Noを取得する
     * @return 受注明細No
     */
    public String getJyMeiNo() {
        return _jyMeiNo;
    }

    /**
     * 受注明細Noを設定する
     * @param jyMeiNo 受注明細No
     */
    public void setJyMeiNo(String jyMeiNo) {
        this._jyMeiNo = jyMeiNo;
    }

    /**
     * 売上明細Noを取得する
     * @return 売上明細No
     */
    public String getUrMeiNo() {
        return _urMeiNo;
    }

    /**
     * 売上明細Noを設定する
     * @param urMeiNo 売上明細No
     */
    public void setUrMeiNo(String urMeiNo) {
        this._urMeiNo = urMeiNo;
    }

    /**
     * 統合フラグを取得する
     * @return 統合フラグ
     */
    public String getTouFlg() {
        return _touFlg;
    }

    /**
     * 統合フラグを設定する
     * @param urMeiNo 統合フラグ
     */
    public void setTouFlg(String touFlg) {
        this._touFlg = touFlg;
    }

    /**
     * ファイルタイムスタンプを取得する
     * @return ファイルタイムスタンプ
     */
    public String getFileTimStmp() {
        return _fileTimStmp;
    }

    /**
     * ファイルタイムスタンプを設定する
     * @param fileTimStmp ファイルタイムスタンプ
     */
    public void setFileTimStmp(String fileTimStmp) {
        this._fileTimStmp = fileTimStmp;
    }

}

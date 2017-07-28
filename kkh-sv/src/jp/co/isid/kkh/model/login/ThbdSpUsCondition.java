package jp.co.isid.kkh.model.login;

import java.io.Serializable;

public class ThbdSpUsCondition implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 得意先企業コード */
    private String _tksKgyCd = null;

    /** 得意先部門SEQNO */
    private String _tksBmnSeqNo = null;

    /** 得意先担当SEQNO */
    private String _tksTntSeqNo = null;

    /** 組織コード */
    private String _sikCd = null;

    /** ユーザーID */
    private String _userId = null;

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
     * 組織コードを取得する
     * @return 組織コード
     */
    public String getSikCd() {
        return _sikCd;
    }

    /**
     * 組織コードを設定する
     * @param sikCd 組織コード
     */
    public void setSikCd(String sikCd) {
        this._sikCd = sikCd;
    }

    /**
     * ユーザーIDを取得する
     * @return ユーザーID
     */
    public String getUserId() {
        return _userId;
    }

    /**
     * ユーザーIDを設定する
     * @param userId ユーザーID
     */
    public void setUserId(String userId) {
        this._userId = userId;
    }

}

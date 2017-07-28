package jp.co.isid.kkh.model.login;

import java.io.Serializable;

public class ThbcKhtCondition implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 営業所コード */
    private String _egCd = null;

    /** 得意先企業コード */
    private String _kgyCd = null;

    /** 得意先部門SEQNO */
    private String _bmnSeqNo = null;

    /** 得意先担当SEQNO */
    private String _tntSeqNo = null;

    /**
     * 営業所コードを取得する
     * @return 営業所コード
     */
    public String getEgCd() {
        return _egCd;
    }

    /**
     * 営業所コードを設定する
     * @param egCd 営業所コード
     */
    public void setEgCd(String egCd) {
        this._egCd = egCd;
    }

    /**
     * 得意先企業コードを取得する
     * @return 得意先企業コード
     */
    public String getKgyCd() {
        return _kgyCd;
    }

    /**
     * 得意先企業コードを設定する
     * @param kgyCd 得意先企業コード
     */
    public void setKgyCd(String kgyCd) {
        this._kgyCd = kgyCd;
    }

    /**
     * 得意先部門SEQNOを取得する
     * @return 得意先部門SEQNO
     */
    public String getBmnSeqNo() {
        return _bmnSeqNo;
    }

    /**
     * 得意先部門SEQNOを設定する
     * @param bmnSeqNo 得意先部門SEQNO
     */
    public void setBmnSeqNo(String bmnSeqNo) {
        this._bmnSeqNo = bmnSeqNo;
    }

    /**
     * 得意先担当SEQNOを取得する
     * @return 得意先担当SEQNO
     */
    public String getTntSeqNo() {
        return _tntSeqNo;
    }

    /**
     * 得意先担当SEQNOを設定する
     * @param tntSeqNo 得意先担当SEQNO
     */
    public void setTntSeqNo(String tntSeqNo) {
        this._tntSeqNo = tntSeqNo;
    }

}

package jp.co.isid.kkh.customer.acom.model.claim;

import java.io.Serializable;

public class FindClaimCondition implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /** ログイン担当者ESQID */
    private String _esqId;
    /** 営業所（取）コード */
    private String _egCd;
    /** 得意先企業コード */
    private String _tksKgyCd;
    /** 得意先部門SEQNO */
    private String _tksBmnSeqNo;
    /** 得意先担当SEQNO */
    private String _tksTntSeqNo;
    /** 年月 */
    private String _yymm;
    /** 種別 */
    private String _sybt;
    /** 掲載日 */
    private String _keisaiDay;

    /**
     * ログイン担当者ESQIDを返します。
     *
     * @return esqId
     */
    public String getEsqId() {
        return _esqId;
    }

    /**
     * ログイン担当者ESQIDを設定します。
     *
     * @param esqId
     */
    public void setEsqId(String esqId) {
        this._esqId = esqId;
    }

    /**
     * 営業所（取）コードを返します。
     *
     * @return egCd
     */
    public String getEgCd() {
        return _egCd;
    }

    /**
     * 営業所（取）コードを設定します。
     *
     * @param egCd
     */
    public void setEgCd(String egCd) {
        this._egCd = egCd;
    }

    /**
     * 得意先企業コードを返します。
     *
     * @return tksKgyCd
     */
    public String getTksKgyCd() {
        return _tksKgyCd;
    }

    /**
     * 得意先企業コードを設定します。
     *
     * @param tksKgyCd
     */
    public void setTksKgyCd(String tksKgyCd) {
        this._tksKgyCd = tksKgyCd;
    }

    /**
     * 得意先部門SEQNOを返します。
     *
     * @return tksBmnSeqNo
     */
    public String getTksBmnSeqNo() {
        return _tksBmnSeqNo;
    }

    /**
     * 得意先部門SEQNOを設定します。
     *
     * @param tksBmnSeqNo
     */
    public void setTksBmnSeqNo(String tksBmnSeqNo) {
        this._tksBmnSeqNo = tksBmnSeqNo;
    }

    /**
     * 得意先担当SEQNOを返します。
     *
     * @return tksTntSeqNo
     */
    public String getTksTntSeqNo() {
        return _tksTntSeqNo;
    }

    /**
     * 得意先担当SEQNOを設定します。
     *
     * * @param tksTntSeqNo
     */
    public void setTksTntSeqNo(String tksTntSeqNo) {
        this._tksTntSeqNo = tksTntSeqNo;
    }

    /**
     * 年月を返します。
     *
     * @return yymm
     */
    public String getYymm() {
        return _yymm;
    }

    /**
     * 年月を設定します。
     *
     * @param yymm
     */
    public void setYymm(String yymm) {
        this._yymm = yymm;
    }

    /**
     * 種別を返します。
     *
     * @return sybt
     */
    public String getSybt() {
        return _sybt;
    }

    /**
     * 種別を設定します。
     *
     * @param sybt
     */
    public void setSybt(String sybt) {
        this._sybt = sybt;
    }

    /**
     * 掲載日を返します。
     *
     * @return keisaiDay
     */
    public String getKeisaiDay() {
        return _keisaiDay;
    }

    /**
     * 掲載日を設定します。
     *
     * @param keisaiDay
     */
    public void setKeisaiDay(String keisaiDay) {
        this._keisaiDay = keisaiDay;
    }
}

package jp.co.isid.kkh.customer.lion.model.report;

import java.io.Serializable;

/**
 * <P>
 * ライオン帳票(見積書)検索条件
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成<BR>
 * </BR>
 *
 * @author
 *
 */
public class NewReportLionCondition implements Serializable {

    private static final long serialVersionUID = 1L;

    /** ログイン担当者ESQID */
    private String _esqId;

    /** 営業所(取)コード(必須) */
    private String _egCd;

    /** 得意先企業コード(必須) */
    private String _tksKgyCd;

    /** 得意先部門SEQNO(必須) */
    private String _tksBmnSeqNo;

    /** 得意先担当SEQNO(必須) */
    private String _tksTntSeqNo;

    /** 年月(必須)*/
    private String _yymm;

    /**媒体コード(必須)*/
    private String _baitaiCd;

    /**
     * ログイン担当者ESQ-IDを取得する
     * @return ログイン担当者ESQID
     */
    public String getEsqId() {
        return _esqId;
    }

    /**
     * ESQ-IDを設定する
     * @param val String ログイン担当者ESQID
     */
    public void setEsqId(String val) {
        _esqId = val;
    }

    /**
     * 営業所(取)コードを取得する
     * @return 営業所(取)コード
     */
    public String getEgCd() {
        return _egCd;
    }

    /**
     * 営業所(取)コードを設定する
     * @param val String 営業所(取)コード
     */
    public void setEgCd(String val) {
        _egCd = val;
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
     * @param val String 得意先企業コード
     */
    public void setTksKgyCd(String val) {
        _tksKgyCd = val;
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
     * @param val String 得意先部門SEQNO
     */
    public void setTksBmnSeqNo(String val) {
        _tksBmnSeqNo = val;
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
     * @param val String 得意先担当SEQNO
     */
    public void setTksTntSeqNo(String val) {
        _tksTntSeqNo = val;
    }

    /**
     * 年月を取得する
     * @return _yymm
     */
    public String getYymm() {
        return _yymm;
    }

    /**
     * 年月を設定する
     * @param val String 年月
     */
    public void setYymm(String val) {
        _yymm = val;
    }

    /**
     * 媒体コードを取得する
     * @return 媒体コード
     */
    public String getBaitaiCd() {
        return _baitaiCd;
    }

    /**
     * 媒体コードを設定する
     * @param val String 媒体コード
     */
    public void setBaitaiCd(String val) {
        _baitaiCd = val;
    }

}

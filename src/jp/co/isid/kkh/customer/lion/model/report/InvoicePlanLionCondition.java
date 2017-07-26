package jp.co.isid.kkh.customer.lion.model.report;

import java.io.Serializable;

/**
 * <P>
 * ライオン制作費請求予定表検索条件
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2014/07/31 HLC S.Fujimoto)<BR>
 * </BR>
 *
 * @author HLC S.Fujimoto
 *
 */
public class InvoicePlanLionCondition implements Serializable {

    private static final long serialVersionUID = 1L;

    /** ESQ-ID */
    private String _esqId = null;

    /** 営業所(取)コード */
    private String _egCd = null;

    /** 得意先企業コード */
    private String _tksKgyCd = null;

    /** 得意先部門SEQNO */
    private String _tksBmnSeqNo = null;

    /** 得意先担当SEQNO */
    private String _tksTntSeqNo = null;

    /** 年月 */
    private String _yymm = null;

    /** 事業部 */
    private String _division = null;

    /**
     * ESQ-IDを取得する
     * @return ESQ-ID
     */
    public String getEsqId() {
        return _esqId;
    }

    /**
     * ESQ-IDを設定する
     * @param val String ESQ-ID
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
     * 事業部を取得する
     * @return 事業部
     */
    public String getDivision() {
        return _division;
    }

    /**
     * 事業部を設定する
     * @param val String 事業部
     */
    public void setDivision(String val) {
        _division = val;
    }

}
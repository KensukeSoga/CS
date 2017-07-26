package jp.co.isid.kkh.customer.lion.model.report;

import java.io.Serializable;

/**
 * <P>
 * ライオン履歴条件
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2014/07/31 HLC S.Fujimoto)<BR>
 * </BR>
 *
 * @author HLC S.Fujimoto
 *
 */
public class LionHistoryCondition implements Serializable {

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

    /** 履歴タイムスタンプ */
    private String _rrkTimStmp = null;

    /** 履歴作成時選択媒体 */
    private String _rrkGetBaitai = null;

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
     * 履歴タイムスタンプを取得する
     * @return 履歴タイムスタンプ
     */
    public String getRrkTimStmp() {
        return _rrkTimStmp;
    }

    /**
     * 履歴タイムスタンプを設定する
     * @param val Date 履歴タイムスタンプ
     */
    public void setRrkTimStmp(String val) {
        _rrkTimStmp = val;
    }

    /**
     * 履歴作成時選択媒体を取得する
     * @return 履歴作成時選択媒体
     */
    public String getRrkGetBaitai() {
        return _rrkGetBaitai;
    }

    /**
     * 履歴作成時選択媒体を設定する
     * @param val String 履歴作成時選択媒体
     */
    public void setRrkGetBaitai(String val) {
        _rrkGetBaitai = val;
    }

}
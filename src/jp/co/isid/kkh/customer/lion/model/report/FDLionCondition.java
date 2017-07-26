package jp.co.isid.kkh.customer.lion.model.report;

import java.io.Serializable;

/**
 * <P>
 * ライオンFD出力データ取得条件
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/01/23 JSE Hitoshi Sasaki)<BR>
 * </P>
 *
 * @author JSE Hitoshi Sasaki
 */
public class FDLionCondition implements Serializable {

    private static final long serialVersionUID = 1L;

    /** ログイン担当者ESQID */
    private String _esqId;

    /** 営業所（取）コード(必須) */
    private String _egCd;

    /** 得意先企業コード(必須) */
    private String _tksKgyCd;

    /** 得意先部門SEQNO(必須) */
    private String _bmncd;

    /** 得意先担当SEQNO(必須) */
    private String _tntcd;

    /** 年月 */
    private String _ym;

    /** 区分 */
    private String _kbn;

    /**
     * ログイン担当者ESQIDを取得する
     * @return ログイン担当者ESQID
     */
    public String getEsqId() {
        return _esqId;
    }

    /**
     * ログイン担当者ESQIDを設定する
     * @param val String ログイン担当者ESQID
     */
    public void setEsqId(String val) {
        _esqId = val;
    }

    /**
     * 営業所コードを取得する
     * @return 営業所コード
     */
    public String getEgCd() {
        return _egCd;
    }

    /**
     * 営業所コードを取得する
     * @param val String 営業所コード
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
     * 得意先企業コードを設定する￥
     * @param val String 得意先企業コード
     */
    public void setTksKgyCd(String val) {
        _tksKgyCd = val;
    }

    /**
     * 得意先部門SEQNOを取得する
     * @return 得意先部門コード
     */
    public String getBmncd() {
        return _bmncd;
    }

    /**
     * 得意先部門SEQNOを設定する
     * @param val String 得意先部門SEQNO
     */
    public void setBmncd(String val) {
        _bmncd = val;
    }

    /**
     * 得意先担当SEQNOを取得する
     * @return 得意先担当SEQNO
     */
    public String getTntcd() {
        return _tntcd;
    }

    /**
     * 得意先担当SEQNOを設定する
     * @param val String 得意先担当SEQNO
     */
    public void setTntcd(String val) {
        _tntcd = val;
    }

    /**
     * 年月を取得する
     * @return 年月
     */
    public String getYM() {
        return _ym;
    }

    /**
     * 年月を設定する
     * @param val String 年月
     */
    public void setYM(String val) {
        _ym = val;
    }

    /**
     * 区分を取得する
     * @return 区分
     */
    public String getKbn() {
        return _kbn;
    }

    /**
     * 区分を設定する
     * @param val String 区分
     */
    public void setKbn(String val) {
        _kbn = val;
    }

}

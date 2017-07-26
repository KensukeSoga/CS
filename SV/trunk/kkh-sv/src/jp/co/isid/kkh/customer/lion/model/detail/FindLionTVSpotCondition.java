package jp.co.isid.kkh.customer.lion.model.detail;

import java.io.Serializable;

/**
 * <P>
 * ライオンTVSpotデータ取得条件
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/03/05 JSE Hitoshi Sasaki)<BR>
 * </P>
 *
 * @author JSE Hitoshi Sasaki
 */
public class FindLionTVSpotCondition implements Serializable {

    private static final long serialVersionUID = 1L;

    /** ログイン担当者ESQID */
    private String _esqId;

    /** 営業所（取）コード(必須) */
    private String _egCd;

    /** 得意先企業コード(必須) */
    private String _tksKgyCd;

    /** 得意先部門コード(必須) */
    private String _bmncd;

    /** 得意先担当コード(必須) */
    private String _tntcd;

    /** ジョブ番号 */
    private String _jobNo;

    /** 年月 */
    private String _ym;

    /**
     * @return esqId
     */
    public String getEsqId() {
        return _esqId;
    }

    /**
     * @param esqId
     *            セットする esqId
     */
    public void setEsqId(String esqId) {
        this._esqId = esqId;
    }

    /**
     * @return egCd
     */
    public String getEgCd() {
        return _egCd;
    }

    /**
     * @param egCd
     *            セットする egCd
     */
    public void setEgCd(String egCd) {
        this._egCd = egCd;
    }

    /**
     * @return tksKgyCd
     */
    public String getTksKgyCd() {
        return _tksKgyCd;
    }

    /**
     * @param tksKgyCd
     *            セットする tksKgyCd
     */
    public void setTksKgyCd(String tksKgyCd) {
        this._tksKgyCd = tksKgyCd;
    }

    /**
     * @return egCd
     */
    public String getBmncd() {
        return _bmncd;
    }

    /**
     * @param egCd
     *            セットする egCd
     */
    public void setBmncd(String bmncd) {
        this._bmncd = bmncd;
    }

    /**
     * @return egCd
     */
    public String getTntcd() {
        return _tntcd;
    }

    /**
     * @param egCd
     *            セットする egCd
     */
    public void setTntcd(String tntcd) {
        this._tntcd = tntcd;
    }

    /**
     * @return jobNo
     */
    public String getJobNo() {
        return _jobNo;
    }

    /**
     * @param ym
     *            セットする jobNo
     */
    public void setJobNo(String jobNo) {
        this._jobNo = jobNo;
    }

    /**
     * @return _ym
     */
    public String getYM() {
        return _ym;
    }

    /**
     * @param ym
     *            セットする ym
     */
    public void setYM(String ym) {
        this._ym = ym;
    }

}

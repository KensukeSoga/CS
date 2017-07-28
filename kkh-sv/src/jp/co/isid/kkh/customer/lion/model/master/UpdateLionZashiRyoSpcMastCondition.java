package jp.co.isid.kkh.customer.lion.model.master;

import java.io.Serializable;

public class UpdateLionZashiRyoSpcMastCondition implements Serializable {

    private static final long serialVersionUID = 1L;

    /** ログイン担当者ESQID */
    private String _esqId;
    /** 営業所（取）コード(必須) */
    private String _egCd;
    /** 得意先企業コード(必須) */
    private String _tksKgyCd;
    /** 得意先部門SEQNO(必須) */
    private String _tksBmnSeqNo;
    /** 得意先担当SEQNO(必須) */
    private String _tksTntSeqNo;
    /** 種別 */
    private String _sybt;
    /** 雑誌コード */
    private String _zashiCd;
//	/** マスタキー (任意：マスタ項目設定の検索にのみ使用)*/
//	private String _masterKey;
//	/** フィルタキー */
//	private String  _filterKey;
//	/** フィルターバリュー */
//	private String _filterValue;

    /**
     * @return esqId
     */
    public String getEsqId() {
        return _esqId;
    }

    /**
     * @param esqId セットする esqId
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
     * @param egCd セットする egCd
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
     * @param tksKgyCd セットする tksKgyCd
     */
    public void setTksKgyCd(String tksKgyCd) {
        this._tksKgyCd = tksKgyCd;
    }

    /**
     * @return tksBmnSeqNo
     */
    public String getTksBmnSeqNo() {
        return _tksBmnSeqNo;
    }

    /**
     * @param tksBmnSeqNo セットする tksBmnSeqNo
     */
    public void setTksBmnSeqNo(String tksBmnSeqNo) {
        this._tksBmnSeqNo = tksBmnSeqNo;
    }

    /**
     * @return tksTntSeqNo
     */
    public String getTksTntSeqNo() {
        return _tksTntSeqNo;
    }

    /**
     * @param tksTntSeqNo セットする tksTntSeqNo
     */
    public void setTksTntSeqNo(String tksTntSeqNo) {
        this._tksTntSeqNo = tksTntSeqNo;
    }

    /**
     * @return sybt
     */
    public String getSybt() {
        return _sybt;
    }

    /**
     * @param sybt セットする sybt
     */
    public void setSybt(String sybt) {
        this._sybt = sybt;
    }

    /**
     * @return zashiCd
     */
    public String getZashiCd() {
        return _zashiCd;
    }

    /**
     * @param zashiCd セットする zashiCd
     */
    public void setZashiCd(String zashiCd) {
        this._zashiCd = zashiCd;
    }

    /**
//	 * @return masterKey
//	 */
//	public String getMasterKey() {
//		return _masterKey;
//	}
//	/**
//	 * @param masterKey セットする masterKey
//	 */
//	public void setMasterKey(String masterKey) {
//		this._masterKey = masterKey;
//	}
//	/**
//	 * @return filterKey
//	 */
//	public String getFilterKey() {
//		return _filterKey;
//	}
//	/**
//	 * @param filterKey セットする filterKey
//	 */
//	public void setFilterKey(String filterKey) {
//		this._filterKey = filterKey;
//	}
//
//	public String getFilterValue() {
//		return _filterValue;
//	}
//	public void setFilterValue(String filterValue) {
//		_filterValue = filterValue;
//	}

}

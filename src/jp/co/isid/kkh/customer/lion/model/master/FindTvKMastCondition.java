package jp.co.isid.kkh.customer.lion.model.master;

import jp.co.isid.kkh.model.AbstractServiceCondition;

public class FindTvKMastCondition extends AbstractServiceCondition {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/** 放送局コード*/
	private String _kyokucd;
	/** 記号*/
	private String _kigou;
	/** 系列*/
	private String _keiretsu;
	/** 地区*/
	private String _tiku;

	/**
	 * @return kyokucd
	 */
	public String getKyokucd() {
		return _kyokucd;
	}
	/**
	 * @param kyokucd セットする kyokucd
	 */
	public void setKyokucd(String kyokucd) {
		this._kyokucd = kyokucd;
	}

	/**
	 * @return kigou
	 */
	public String getKigou() {
		return _kigou;
	}
	/**
	 * @param kigou セットする kigou
	 */
	public void setKigou(String kigou) {
		this._kigou = kigou;
	}

	/**
	 * @return keiretsu
	 */
	public String getKeiretsu() {
		return _keiretsu;
	}
	/**
	 * @param keiretsu セットする keiretsu
	 */
	public void setKeiretsu(String keiretsu) {
		this._keiretsu = keiretsu;
	}

	/**
	 * @return tiku
	 */
	public String getTiku() {
		return _tiku;
	}
	/**
	 * @param tiku セットする tiku
	 */
	public void setTiku(String tiku) {
		this._tiku = tiku;
	}
}
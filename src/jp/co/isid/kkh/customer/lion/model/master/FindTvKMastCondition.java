package jp.co.isid.kkh.customer.lion.model.master;

import jp.co.isid.kkh.model.AbstractServiceCondition;

public class FindTvKMastCondition extends AbstractServiceCondition {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/** �����ǃR�[�h*/
	private String _kyokucd;
	/** �L��*/
	private String _kigou;
	/** �n��*/
	private String _keiretsu;
	/** �n��*/
	private String _tiku;

	/**
	 * @return kyokucd
	 */
	public String getKyokucd() {
		return _kyokucd;
	}
	/**
	 * @param kyokucd �Z�b�g���� kyokucd
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
	 * @param kigou �Z�b�g���� kigou
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
	 * @param keiretsu �Z�b�g���� keiretsu
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
	 * @param tiku �Z�b�g���� tiku
	 */
	public void setTiku(String tiku) {
		this._tiku = tiku;
	}
}
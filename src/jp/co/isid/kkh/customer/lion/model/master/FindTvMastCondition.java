package jp.co.isid.kkh.customer.lion.model.master;

import jp.co.isid.kkh.model.AbstractServiceCondition;

public class FindTvMastCondition extends AbstractServiceCondition {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/** 番組コード*/
	private String _bancd;
	/** 番組名称*/
	private String _banname;
	/** 局誌ＣＤ*/
	private String _hkyokucd;
	/** 単価*/
	private String _tanka;
	/** TYPE2*/
	private String _type2;

	/**
	 * @return bancd
	 */
	public String getBancd() {
		return _bancd;
	}
	/**
	 * @param bancd セットする bancd
	 */
	public void setBancd(String bancd) {
		this._bancd = bancd;
	}

	/**
	 * @return banname
	 */
	public String getBanname() {
		return _banname;
	}
	/**
	 * @param banname セットする banname
	 */
	public void setBanname(String banname) {
		this._banname = banname;
	}

	/**
	 * @return _hkyokucd
	 */
	public String getHkyokucd() {
		return _hkyokucd;
	}
	/**
	 * @param _hkyokucd セットする _hkyokucd
	 */
	public void setHkyokucd(String hkyokucd) {
		this._hkyokucd = hkyokucd;
	}

	/**
	 * @return _tanka
	 */
	public String getTanka() {
		return _tanka;
	}
	/**
	 * @param _tanka セットする _tanka
	 */
	public void setTanka(String tanka) {
		this._tanka = tanka;
	}

	/**
	 * @return _type2
	 */
	public String getType2() {
		return _type2;
	}
	/**
	 * @param _type2 セットする _type2
	 */
	public void setType2(String type2) {
		this._type2 = type2;
	}

}
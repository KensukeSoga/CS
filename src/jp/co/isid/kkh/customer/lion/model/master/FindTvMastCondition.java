package jp.co.isid.kkh.customer.lion.model.master;

import jp.co.isid.kkh.model.AbstractServiceCondition;

public class FindTvMastCondition extends AbstractServiceCondition {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/** �ԑg�R�[�h*/
	private String _bancd;
	/** �ԑg����*/
	private String _banname;
	/** �ǎ��b�c*/
	private String _hkyokucd;
	/** �P��*/
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
	 * @param bancd �Z�b�g���� bancd
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
	 * @param banname �Z�b�g���� banname
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
	 * @param _hkyokucd �Z�b�g���� _hkyokucd
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
	 * @param _tanka �Z�b�g���� _tanka
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
	 * @param _type2 �Z�b�g���� _type2
	 */
	public void setType2(String type2) {
		this._type2 = type2;
	}

}
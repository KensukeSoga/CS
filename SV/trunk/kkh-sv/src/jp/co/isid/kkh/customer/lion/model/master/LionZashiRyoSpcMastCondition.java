package jp.co.isid.kkh.customer.lion.model.master;

import jp.co.isid.kkh.model.AbstractServiceCondition;

public class LionZashiRyoSpcMastCondition extends AbstractServiceCondition {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	/** 雑誌コード*/
	private String _cd;
	/** 雑誌名称*/
	private String _name;


	/**
	 * @return cd
	 */
	public String getCd() {
		return _cd;
	}
	/**
	 * @param cd セットする cd
	 */
	public void setCd(String cd) {
		this._cd = cd;
	}

	/**
	 * @return name
	 */
	public String getName() {
		return _name;
	}
	/**
	 * @param name セットする name
	 */
	public void setName(String name) {
		this._name = name;
	}
}
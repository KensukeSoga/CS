package jp.co.isid.kkh.customer.lion.model.master;

import jp.co.isid.kkh.model.AbstractServiceCondition;

public class LionZashiRyoSpcMastCondition extends AbstractServiceCondition {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	/** �G���R�[�h*/
	private String _cd;
	/** �G������*/
	private String _name;


	/**
	 * @return cd
	 */
	public String getCd() {
		return _cd;
	}
	/**
	 * @param cd �Z�b�g���� cd
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
	 * @param name �Z�b�g���� name
	 */
	public void setName(String name) {
		this._name = name;
	}
}
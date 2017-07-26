package jp.co.isid.kkh.customer.lion.model.master;

import jp.co.isid.kkh.model.AbstractServiceCondition;

public class LionCondition extends AbstractServiceCondition {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/** �}�X�^���(�C�ӁF�����Ώۂ̃}�X�^���w��) */
	private String _sybt;
	/** �}�X�^�L�[ (�C�ӁF�}�X�^���ڐݒ�̌����ɂ̂ݎg�p)*/
	private String _masterKey;

	/** �t�B���^�L�[ */
	private String  _filterKey;

	/** �t�B���^�[�o�����[ */
	private String _filterValue;

	/**
	 * @return sybt
	 */
	public String getSybt() {
		return _sybt;
	}
	/**
	 * @param sybt �Z�b�g���� sybt
	 */
	public void setSybt(String sybt) {
		this._sybt = sybt;
	}
	/**
	 * @return masterKey
	 */
	public String getMasterKey() {
		return _masterKey;
	}
	/**
	 * @param masterKey �Z�b�g���� masterKey
	 */
	public void setMasterKey(String masterKey) {
		this._masterKey = masterKey;
	}
	/**
	 * @return filterKey
	 */
	public String getFilterKey() {
		return _filterKey;
	}
	/**
	 * @param filterKey �Z�b�g���� filterKey
	 */
	public void setFilterKey(String filterKey) {
		this._filterKey = filterKey;
	}

	public String getFilterValue() {
		return _filterValue;
	}
	public void setFilterValue(String filterValue) {
		_filterValue = filterValue;
	}

}

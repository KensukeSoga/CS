package jp.co.isid.kkh.customer.lion.model.master;

import jp.co.isid.kkh.model.AbstractServiceCondition;

public class LionCondition extends AbstractServiceCondition {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/** マスタ種別(任意：検索対象のマスタを指定) */
	private String _sybt;
	/** マスタキー (任意：マスタ項目設定の検索にのみ使用)*/
	private String _masterKey;

	/** フィルタキー */
	private String  _filterKey;

	/** フィルターバリュー */
	private String _filterValue;

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
	 * @return masterKey
	 */
	public String getMasterKey() {
		return _masterKey;
	}
	/**
	 * @param masterKey セットする masterKey
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
	 * @param filterKey セットする filterKey
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

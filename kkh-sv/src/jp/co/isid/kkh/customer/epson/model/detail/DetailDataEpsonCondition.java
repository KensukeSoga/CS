package jp.co.isid.kkh.customer.epson.model.detail;

import jp.co.isid.kkh.model.AbstractServiceCondition;

public class DetailDataEpsonCondition extends AbstractServiceCondition {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/** �敪 */
	private String _kbn;

	/**
	 * @return _kbn
	 */
	public String getKbn() {
		return _kbn;
	}

	/**
	 * @param kbn
	 *            �Z�b�g���� kbn
	 */
	public void setKbn(String kbn) {
		this._kbn = kbn;
	}
}

package jp.co.isid.kkh.customer.epson.model.detail;

import jp.co.isid.kkh.model.AbstractServiceCondition;

public class DetailDataEpsonCondition extends AbstractServiceCondition {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/** ‹æ•ª */
	private String _kbn;

	/**
	 * @return _kbn
	 */
	public String getKbn() {
		return _kbn;
	}

	/**
	 * @param kbn
	 *            ƒZƒbƒg‚·‚é kbn
	 */
	public void setKbn(String kbn) {
		this._kbn = kbn;
	}
}

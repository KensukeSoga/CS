package jp.co.isid.kkh.customer.toh.model.report;

import jp.co.isid.kkh.model.AbstractServiceCondition;

public class ReportTohTotalCondition extends AbstractServiceCondition {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/** �N�x*/
	private String _year;

	/** �[�i�敪 */
	private String _nohinKbn;

    /**
     * �N�x���擾����
     @return �N�x
     */
	public String getYear() {
		return _year;
	}

    /**
     * �N�x��ݒ肷��
     @param year �N�x
     */
	public void setYear(String year) {
		this._year = year;
	}

    /**
     * �[�i�敪���擾����
     @return �[�i�敪
     */
	public String getNohinKbn() {
		return _nohinKbn;
	}

    /**
     * �[�i�敪��ݒ肷��
     @param year �[�i�敪
     */
	public void setNohinKbn(String val) {
		this._nohinKbn = val;
	}
}

package jp.co.isid.kkh.customer.toh.model.report;

import jp.co.isid.kkh.model.AbstractServiceCondition;

public class ReportTohTotalCondition extends AbstractServiceCondition {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/** 年度*/
	private String _year;

	/** 納品区分 */
	private String _nohinKbn;

    /**
     * 年度を取得する
     @return 年度
     */
	public String getYear() {
		return _year;
	}

    /**
     * 年度を設定する
     @param year 年度
     */
	public void setYear(String year) {
		this._year = year;
	}

    /**
     * 納品区分を取得する
     @return 納品区分
     */
	public String getNohinKbn() {
		return _nohinKbn;
	}

    /**
     * 納品区分を設定する
     @param year 納品区分
     */
	public void setNohinKbn(String val) {
		this._nohinKbn = val;
	}
}

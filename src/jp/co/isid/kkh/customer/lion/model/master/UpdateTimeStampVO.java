package jp.co.isid.kkh.customer.lion.model.master;

public class UpdateTimeStampVO {

	/**タイムスタンプ*/
	private String _timeStamp = null;

	/**営業所(取)コード*/
	private String _egCd = null;

	/**得意先企業コード*/
	private String _tksKgyCd = null;

	/**得意先部門SQLNO*/
	private String _tksBmnSeqNo = null;

	/**得意先担当SQLNO*/
	private String _tksTntSeqNo = null;

	/**種別*/
	private String _syBt = null;

	/**FILED1*/
	private String _field1 = null;

	/**mstkbn*/
	private String _mstkbn = null;

	/**
	 * _timeStampを返す
	 * @return esqId
	 */
	public String gettimeStamp() {
		return _timeStamp;
	}

	/**
	 * _timeStampを設定する
	 * @param esqId
	 */
	public void settimeStamp(String timeStamp) {
		this._timeStamp = timeStamp;
	}

	/**
	 * 営業所（取）コードを設定する
	 * @param egCd
	 */
	public void set_egCd(String egCd) {
		_egCd = egCd;
	}

	/**
	 * 営業所（取）コードを返す
	 * @return egCd
	 */
	public String get_egCd() {
		return _egCd;
	}


	/**
	 * 得意先企業コードを設定する
	 * @param tksKgyCd
	 */
	public void set_tksKgyCd(String tksKgyCd) {
		_tksKgyCd = tksKgyCd;
	}

	/**
	 * 得意先企業コードを返す
	 * @return tksKgyCd
	 */
	public String get_tksKgyCd() {
		return _tksKgyCd;
	}

	/**
	 * 得意先部門SEQNOを設定する
	 * @param tksBmnSeqNo
	 */
	public void set_tksBmnSeqNo(String tksBmnSeqNo) {
		_tksBmnSeqNo = tksBmnSeqNo;
	}

	/**
	 * 得意先部門SEQNOを返します
	 * @return tksBmnSeqNo
	 */
	public String get_tksBmnSeqNo() {
		return _tksBmnSeqNo;
	}

	/**
	 * 得意先担当SEQNOを設定する
	 * @param tksTntSeqNo
	 */
	public void set_TksTntSeqNo(String tksTntSeqNo) {
		_tksTntSeqNo = tksTntSeqNo;
	}
	/**
	 * 得意先担当SEQNOを返します
	 * @return tksTntSeqNo
	 */
	public String get_TksTntSeqNo() {
		return _tksTntSeqNo;
	}


	/**
	 * _syBtを設定する
	 * @param syBt
	 */
	public void set_syBt(String syBt) {
		_syBt = syBt;
	}
	/**
	 * _syBtを返します
	 * @return syBt
	 */
	public String get_syBt() {
		return _syBt;
	}

	/**
	 * _field1を設定する
	 * @param _field1
	 */
	public void set_field1(String field1) {
		_field1 = field1;
	}
	/**
	 * _field1を返します
	 * @return _field1
	 */
	public String get_field1() {
		return _field1;
	}

	/**
	 * mstkbnを設定する
	 * @param mstkbn
	 */
	public void set_mstkbn(String mstkbn) {
		_mstkbn = mstkbn;
	}
	/**
	 * mstkbnを返します
	 * @return mstkbn
	 */
	public String get_mstkbn() {
		return _mstkbn;
	}
}

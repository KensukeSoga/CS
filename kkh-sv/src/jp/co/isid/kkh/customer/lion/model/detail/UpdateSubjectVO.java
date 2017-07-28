package jp.co.isid.kkh.customer.lion.model.detail;

public class UpdateSubjectVO {
	/**esqId*/
	private String _esqId = null;

	/**aplId*/
	private String _aplId = null;

	/**件名*/
	private String _kkNameKJ = null;

	/**営業所(取)コード*/
	private String _egCd = null;

	/**得意先企業コード*/
	private String _tksKgyCd = null;

	/**得意先部門SQLNO*/
	private String _tksBmnSeqNo = null;

	/**得意先担当SQLNO*/
	private String _tksTntSeqNo = null;

	/**年月*/
	private String _YYMM = null;

	/**受注No.*/
	private String _jyutNo = null;

	/**受注明細No.*/
	private String _jyMeiNo = null;

	/**売上明細No.*/
	private String _urMeiNo = null;


	/**
	 * esqIdを返す
	 * @return esqId
	 */
	public String getEsqId() {
		return _esqId;
	}

	/**
	 * esqIdを設定する
	 * @param esqId
	 */
	public void setEsqId(String esqId) {
		this._esqId = esqId;
	}

	/**
	 * aplIdを返す
	 * @return aplId
	 */
	public String get_aplId() {
		return _aplId;
	}

	/**
	 * aplIdを設定する
	 * @param aplId
	 */
	public void set_aplId(String aplId) {
		_aplId = aplId;
	}

	/**
	 * 件名をを設定する
	 * @return kkNameKJ
	 */
	public void set_kkNameKJ(String kkNameKJ) {
		_kkNameKJ = kkNameKJ;
	}

	/**
	 * 件名を返す
	 * @param _kkNameKJ
	 */
	public String get_kkNameKJ() {
		return _kkNameKJ;
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
	 * 年月を設定する
	 * @param yymm
	 */
	public void set_YYMM(String yymm) {
		_YYMM = yymm;
	}

	/**
	 * 年月を返す
	 * @return _YYMM
	 */
	public String get_YYMM() {
		return _YYMM;
	}

	/**
	 * 受注No.を設定する
	 * @return jyutNo
	 */
	public void set_jyutNo(String jyutNo) {
		_jyutNo = jyutNo;
	}

	/**
	 * 受注No.を返す
	 * @param _jyutNo
	 */
	public String get_jyutNo() {
		return _jyutNo;
	}

	/**
	 * 受注明細No.を設定する
	 * @return jyMeiNo
	 */
	public void set_jyMeiNo(String jyMeiNo) {
		_jyMeiNo = jyMeiNo;
	}

	/**
	 * 受注明細No.を返す
	 * @param _jyMeiNo
	 */
	public String get_jyMeiNo() {
		return _jyMeiNo;
	}

	/**
	 * 売上明細No.を設定する
	 * @return URMEINO
	 */
	public void set_lUrmeino(String urMeiNo) {
		_urMeiNo = urMeiNo;
	}

	/**
	 * 売上明細No.を返す
	 * @param _urMeiNo
	 */
	public String get_lUrmeino() {
		return _urMeiNo;
	}
}

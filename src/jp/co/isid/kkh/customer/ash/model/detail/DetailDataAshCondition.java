package jp.co.isid.kkh.customer.ash.model.detail;

import javax.xml.bind.annotation.XmlTransient;

import jp.co.isid.kkh.model.AbstractServiceCondition;

public class DetailDataAshCondition extends AbstractServiceCondition {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/** 受注No */
	private String _jyutNo = null;

	/** 受注明細No */
	private String _jyMeiNo = null;

	/** 売上明細No */
	private String _urMeiNo = null;

	/** 業務区分 **/
	private String _gyoumuKbn = null;

	/** タイムスポット区分 */
	private String _tmSpKbn = null;

	/** 国際区分 */
	private String _kokKbn = null;

	/** 請求区分 */
	private String _seiKbn = null;

//	/** 選択受注登録内容データ */
//	private Thb1DownVO _thb1Down = null;

	/** マスタ種別コード */
	private String _mstSybt = null;

	/** 対象媒体コード */
	private String _targetBaitaiCd;



	/**
	 * 受注Noを取得する
	 * @return 受注No
	 */
	public String getJyutNo() {
	    return _jyutNo;
	}

	/**
	 * 受注Noを設定する
	 * @param jyutNo 受注No
	 */
	public void setJyutNo(String jyutNo) {
	    this._jyutNo = jyutNo;
	}

	/**
	 * 受注明細Noを取得する
	 * @return 受注明細No
	 */
	public String getJyMeiNo() {
	    return _jyMeiNo;
	}

	/**
	 * 受注明細Noを設定する
	 * @param jyMeiNo 受注明細No
	 */
	public void setJyMeiNo(String jyMeiNo) {
	    this._jyMeiNo = jyMeiNo;
	}

	/**
	 * 売上明細Noを取得する
	 * @return 売上明細No
	 */
	public String getUrMeiNo() {
	    return _urMeiNo;
	}

	/**
	 * 売上明細Noを設定する
	 * @param urMeiNo 売上明細No
	 */
	public void setUrMeiNo(String urMeiNo) {
	    this._urMeiNo = urMeiNo;
	}


//	/**
//	 * 受注登録内容データを取得する
//	 * @return 選択受注登録内容データ
//	 */
//	public Thb1DownVO getThb1Down() {
//		return _thb1Down;
//	}
//
//	/**
//	 * 受注登録内容データを設定する
//	 * @param thb1Down 選択受注登録内容データ
//	 */
//	public void setThb1Down(Thb1DownVO thb1Down) {
//		this._thb1Down = thb1Down;
//	}

	/**
	 * @return _GyoumuKbn
	 */
	public String getGyoumuKbn() {
		return _gyoumuKbn;
	}

	/**
	 * @param gyoumuKbn セットする _GyoumuKbn
	 */
	public void setGyoumuKbn(String gyoumuKbn) {
		_gyoumuKbn = gyoumuKbn;
	}

	/**
	 * @return _TmSpKbn
	 */
	public String getTmSpKbn() {
		return _tmSpKbn;
	}

	/**
	 * @param tmSpKbn セットする _TmSpKbn
	 */
	public void setTmSpKbn(String tmSpKbn) {
		_tmSpKbn = tmSpKbn;
	}

	/**
	 * @return _KokKbn
	 */
	public String getKokKbn() {
		return _kokKbn;
	}

	/**
	 * @param kokKbn セットする _KokKbn
	 */
	public void setKokKbn(String kokKbn) {
		_kokKbn = kokKbn;
	}

	/**
	 * @return _SeiKbn
	 */
	public String getSeiKbn() {
		return _seiKbn;
	}

	/**
	 * @param seiKbn セットする _SeiKbn
	 */
	public void setSeiKbn(String seiKbn) {
		_seiKbn = seiKbn;
	}

	/**
	 * マスタ種別を取得する
	 * @return マスタ種別
	 */
	@XmlTransient
	public String getMstSybt() {
		return _mstSybt;
	}

	/**
	 * マスタ種別を設定する
	 * @param thb1Down マスタ種別
	 */
	public void setMstSybt(String mstSybt) {
		this._mstSybt = mstSybt;
	}

	/**
	 * 対象媒体コードを取得します。
	 * @return
	 */
	@XmlTransient
	public String getTargetBaitaiCd() {
		return _targetBaitaiCd;
	}

	/**
	 * 対象媒体コードを設定します。
	 * @param targetBaitaiCd
	 */
	public void setTargetBaitaiCd(String targetBaitaiCd) {
		this._targetBaitaiCd = targetBaitaiCd;
	}


}

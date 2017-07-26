package jp.co.isid.kkh.customer.ash.model.detail;

import javax.xml.bind.annotation.XmlTransient;

import jp.co.isid.kkh.model.AbstractServiceCondition;

public class DetailDataAshCondition extends AbstractServiceCondition {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/** ��No */
	private String _jyutNo = null;

	/** �󒍖���No */
	private String _jyMeiNo = null;

	/** ���㖾��No */
	private String _urMeiNo = null;

	/** �Ɩ��敪 **/
	private String _gyoumuKbn = null;

	/** �^�C���X�|�b�g�敪 */
	private String _tmSpKbn = null;

	/** ���ۋ敪 */
	private String _kokKbn = null;

	/** �����敪 */
	private String _seiKbn = null;

//	/** �I���󒍓o�^���e�f�[�^ */
//	private Thb1DownVO _thb1Down = null;

	/** �}�X�^��ʃR�[�h */
	private String _mstSybt = null;

	/** �Ώ۔}�̃R�[�h */
	private String _targetBaitaiCd;



	/**
	 * ��No���擾����
	 * @return ��No
	 */
	public String getJyutNo() {
	    return _jyutNo;
	}

	/**
	 * ��No��ݒ肷��
	 * @param jyutNo ��No
	 */
	public void setJyutNo(String jyutNo) {
	    this._jyutNo = jyutNo;
	}

	/**
	 * �󒍖���No���擾����
	 * @return �󒍖���No
	 */
	public String getJyMeiNo() {
	    return _jyMeiNo;
	}

	/**
	 * �󒍖���No��ݒ肷��
	 * @param jyMeiNo �󒍖���No
	 */
	public void setJyMeiNo(String jyMeiNo) {
	    this._jyMeiNo = jyMeiNo;
	}

	/**
	 * ���㖾��No���擾����
	 * @return ���㖾��No
	 */
	public String getUrMeiNo() {
	    return _urMeiNo;
	}

	/**
	 * ���㖾��No��ݒ肷��
	 * @param urMeiNo ���㖾��No
	 */
	public void setUrMeiNo(String urMeiNo) {
	    this._urMeiNo = urMeiNo;
	}


//	/**
//	 * �󒍓o�^���e�f�[�^���擾����
//	 * @return �I���󒍓o�^���e�f�[�^
//	 */
//	public Thb1DownVO getThb1Down() {
//		return _thb1Down;
//	}
//
//	/**
//	 * �󒍓o�^���e�f�[�^��ݒ肷��
//	 * @param thb1Down �I���󒍓o�^���e�f�[�^
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
	 * @param gyoumuKbn �Z�b�g���� _GyoumuKbn
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
	 * @param tmSpKbn �Z�b�g���� _TmSpKbn
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
	 * @param kokKbn �Z�b�g���� _KokKbn
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
	 * @param seiKbn �Z�b�g���� _SeiKbn
	 */
	public void setSeiKbn(String seiKbn) {
		_seiKbn = seiKbn;
	}

	/**
	 * �}�X�^��ʂ��擾����
	 * @return �}�X�^���
	 */
	@XmlTransient
	public String getMstSybt() {
		return _mstSybt;
	}

	/**
	 * �}�X�^��ʂ�ݒ肷��
	 * @param thb1Down �}�X�^���
	 */
	public void setMstSybt(String mstSybt) {
		this._mstSybt = mstSybt;
	}

	/**
	 * �Ώ۔}�̃R�[�h���擾���܂��B
	 * @return
	 */
	@XmlTransient
	public String getTargetBaitaiCd() {
		return _targetBaitaiCd;
	}

	/**
	 * �Ώ۔}�̃R�[�h��ݒ肵�܂��B
	 * @param targetBaitaiCd
	 */
	public void setTargetBaitaiCd(String targetBaitaiCd) {
		this._targetBaitaiCd = targetBaitaiCd;
	}


}

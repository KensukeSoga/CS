package jp.co.isid.kkh.customer.ash.model.detail;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import jp.co.isid.kkh.model.AbstractServiceResult;
import jp.co.isid.kkh.model.detail.Thb1DownVO;
import jp.co.isid.kkh.model.detail.Thb2KmeiVO;

/**
*
* <P>
* �󒍓����̏������ʂ�ێ�����B
* </P>
* <P>
* <B>�C������</B><BR>
* �E�V�K�쐬(2011/12/05 JSE K.Fukuda)<BR>
* </P>
* @author
*/
@XmlRootElement(namespace = "http://detail.model.ash.customer.kkh.isid.co.jp/")
@XmlType(namespace = "http://detail.model.ash.customer.kkh.isid.co.jp/")
public class DetailDataAshMergeResult extends AbstractServiceResult {

	/** �_�E�����[�h�e�[�u�� */
	private List<Thb1DownVO> _thb1DownList = null;

	/** ���׃e�[�u�� */
	private List<Thb2KmeiVO> _thb2KmeiList = null;

	/** �_�~�[�v���p�e�B */
	private String _dummy = null;

	/**
	 * �_�E�����[�h�e�[�u�����擾����
	 * @return �_�E�����[�h�e�[�u��
	 */
	public List<Thb1DownVO> getThb1DownList() {
	    return _thb1DownList;
	}

	/**
	 * �_�E�����[�h�e�[�u����ݒ肷��
	 * @param thb1Down �_�E�����[�h�e�[�u��
	 */
	public void setThb1DownList(List<Thb1DownVO> thb1DownList) {
	    this._thb1DownList = thb1DownList;
	}

	/**
	 * ���׃e�[�u�����擾����
	 * @return ���׃e�[�u��
	 */
	public List<Thb2KmeiVO> getThb2KmeiList() {
	    return _thb2KmeiList;
	}

	/**
	 * ���׃e�[�u����ݒ肷��
	 * @param thb2Kmei ���׃e�[�u��
	 */
	public void setThb2KmeiList(List<Thb2KmeiVO> thb2KmeiList) {
	    this._thb2KmeiList = thb2KmeiList;
	}

	/**
	 * �_�~�[�v���p�e�B���擾����
	 * @return �_�~�[�v���p�e�B
	 */
	public String getDummy() {
	    return _dummy;
	}

	/**
	 * �_�~�[�v���p�e�B��ݒ肷��
	 * @param dummy �_�~�[�v���p�e�B
	 */
	public void setDummy(String dummy) {
	    this._dummy = dummy;
	}
}

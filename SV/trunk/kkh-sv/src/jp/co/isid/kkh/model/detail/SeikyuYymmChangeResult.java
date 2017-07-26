package jp.co.isid.kkh.model.detail;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import jp.co.isid.kkh.model.AbstractServiceResult;

/**
*
* <P>
* �����N���ύX�̏������ʂ�ێ�����B
* </P>
* <P>
* <B>�C������</B><BR>
* �E�V�K�쐬(2011/12/05 JSE K.Fukuda)<BR>
* </P>
* @author
*/
@XmlRootElement(namespace = "http://detail.model.kkh.isid.co.jp/")
@XmlType(namespace = "http://detail.model.kkh.isid.co.jp/")
public class SeikyuYymmChangeResult extends AbstractServiceResult {
	/** �_�E�����[�h�e�[�u�� */
	private List<Thb1DownVO> _thb1DownList = null;

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
}

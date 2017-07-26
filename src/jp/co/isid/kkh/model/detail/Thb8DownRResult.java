package jp.co.isid.kkh.model.detail;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import jp.co.isid.kkh.model.AbstractServiceResult;

/**
*
* <P>
* �󒍃_�E�����[�h�����f�[�^�������ʂ�ێ�����B
* </P>
* <P>
* <B>�C������</B><BR>
* �E�V�K�쐬(2011/11/24 JSE K.Fukuda)<BR>
* </P>
* @author
*/
@XmlRootElement(namespace = "http://detail.model.kkh.isid.co.jp/")
@XmlType(namespace = "http://detail.model.kkh.isid.co.jp/")
public class Thb8DownRResult extends AbstractServiceResult {

	/** �󒍃_�E�����[�h�����e�[�u��(THB8DOWNR)VO���X�g */
	private List<Thb8DownRVO> _thb8DownRList;

	/**
	 * �󒍃_�E�����[�h�����e�[�u��(THB8DOWNR)VO���X�g���擾���܂��B
	 * @return _thb2KmeiList
	 */
	public List<Thb8DownRVO> getThb8DownRList() {
		return _thb8DownRList;
	}

	/**
	 * �󒍃_�E�����[�h�����e�[�u��(THB8DOWNR)VO���X�g��ݒ肵�܂��B
	 * @param thb8DownRList
	 */
	public void setThb8DownRList(List<Thb8DownRVO> thb8DownRList) {
		_thb8DownRList = thb8DownRList;
	}

}

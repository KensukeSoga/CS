package jp.co.isid.kkh.model.detail;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import jp.co.isid.kkh.model.AbstractServiceResult;

/**
*
* <P>
* �\���f�[�^�o�^���ʂ�ێ�����B
* </P>
* <P>
* <B>�C������</B><BR>
* �E�V�K�쐬(2011/11/04 JSE K.Fukuda)<BR>
* </P>
* @author
*/
@XmlRootElement(namespace = "http://detail.model.kkh.isid.co.jp/")
@XmlType(namespace = "http://detail.model.kkh.isid.co.jp/")
public class DetailUpdateDataResult extends AbstractServiceResult {
	/** �_�E�����[�h�e�[�u�� */
	private Thb1DownVO _thb1Down = null;

	/** �L����׃e�[�u�����X�g */
	private List<Thb2KmeiVO> _thb2Kmei = null;

	/**
	 * �_�E�����[�h�e�[�u�����擾����
	 * @return �_�E�����[�h�e�[�u��
	 */
	public Thb1DownVO getThb1Down() {
	    return _thb1Down;
	}

	/**
	 * �_�E�����[�h�e�[�u����ݒ肷��
	 * @param thb1Down �_�E�����[�h�e�[�u��
	 */
	public void setThb1Down(Thb1DownVO thb1Down) {
	    this._thb1Down = thb1Down;
	}

	/**
	 * �L����׃e�[�u�����X�g���擾����
	 * @return �L����׃e�[�u�����X�g
	 */
	public List<Thb2KmeiVO> getThb2Kmei() {
	    return _thb2Kmei;
	}

	/**
	 * �L����׃e�[�u�����X�g��ݒ肷��
	 * @param thb2Kmei �L����׃e�[�u�����X�g
	 */
	public void setThb2Kmei(List<Thb2KmeiVO> thb2Kmei) {
	    this._thb2Kmei = thb2Kmei;
	}
}

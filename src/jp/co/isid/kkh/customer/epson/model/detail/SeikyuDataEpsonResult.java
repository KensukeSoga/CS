package jp.co.isid.kkh.customer.epson.model.detail;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import jp.co.isid.kkh.model.AbstractServiceResult;
import jp.co.isid.kkh.customer.epson.model.detail.Thb14skdownVO;

/**
*
* <P>
* ��������f�[�^�������ʂ�ێ�����B
* </P>
* <P>
* <B>�C������</B><BR>
* �E�V�K�쐬(2012/04/25 JSE.Yuguchi)<BR>
* </P>
* @author
*/
@XmlRootElement(namespace = "http://detail.model.epson.kkh.isid.co.jp/")
@XmlType(namespace = "http://detail.model.epson.kkh.isid.co.jp/")
public class SeikyuDataEpsonResult extends AbstractServiceResult {


	/** ��������f�[�^VO���X�g */
	private List<Thb14skdownVO> _seikyuData;


	/**
	 * ��������_�E�����[�h�e�[�u��(Thb14skdown)VO���X�g���擾���܂��B
	 * @return _Thb14skdownList
	 */
	public List<Thb14skdownVO> getSeikyuData() {
		return _seikyuData;
	}

	/**
	 * ��������_�E�����[�h�e�[�u��(Thb14skdown)VO���X�g��ݒ肵�܂��B
	 * @param Thb14skdownList
	 */
	public void setSeikyuData(List<Thb14skdownVO> seikyuData) {
		_seikyuData = seikyuData;
	}

}

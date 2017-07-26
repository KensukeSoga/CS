package jp.co.isid.kkh.customer.acom.model.detail;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import jp.co.isid.kkh.model.AbstractServiceResult;
import jp.co.isid.kkh.model.detail.Thb2KmeiVO;

/**
*
* <P>
* �L����׃f�[�^�������ʂ�ێ�����B
* </P>
* <P>
* <B>�C������</B><BR>
* �E�V�K�쐬(2011/11/24 JSE K.Fukuda)<BR>
* </P>
* @author
*/
@XmlRootElement(namespace = "http://detail.model.kkh.isid.co.jp/")
@XmlType(namespace = "http://detail.model.kkh.isid.co.jp/")
public class FindMeisaiDataResult extends AbstractServiceResult {

	/** �L����׃e�[�u��(THB2KMEI)VO���X�g */
	private List<Thb2KmeiVO> _thb2KmeiList;

	/**
	 * �L����׃e�[�u��(THB2KMEI)VO���X�g���擾���܂��B
	 * @return _thb2KmeiList
	 */
	public List<Thb2KmeiVO> getThb2KmeiList() {
		return _thb2KmeiList;
	}

	/**
	 * �L����׃e�[�u��(THB2KMEI)VO���X�g��ݒ肵�܂��B
	 * @param thb2KmeiList
	 */
	public void setThb2KmeiList(List<Thb2KmeiVO> thb2KmeiList) {
		_thb2KmeiList = thb2KmeiList;
	}

}

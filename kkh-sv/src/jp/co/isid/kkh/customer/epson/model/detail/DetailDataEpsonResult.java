package jp.co.isid.kkh.customer.epson.model.detail;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import jp.co.isid.kkh.model.AbstractServiceResult;

/**
*
* <P>
* �L����׃f�[�^�������ʂ�ێ�����B
* </P>
* <P>
* <B>�C������</B><BR>
* �E�V�K�쐬(2012/3/5 IP.Shimizu)<BR>
* </P>
* @author
*/
@XmlRootElement(namespace = "http://detail.model.epson.kkh.isid.co.jp/")
@XmlType(namespace = "http://detail.model.epson.kkh.isid.co.jp/")
public class DetailDataEpsonResult extends AbstractServiceResult {

	/** �Ώ۔}�̃R�[�h */
	private String _targetBaitaiCd;

	/** �L����׃f�[�^VO���X�g */
	private List<DetailDataFindEpsonVO> _detailData;

	/**
	 * �Ώ۔}�̃R�[�h���擾���܂��B
	 * @return
	 */
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

	/**
	 * �L����׃e�[�u��(THB2KMEI)VO���X�g���擾���܂��B
	 * @return _thb2KmeiList
	 */
	public List<DetailDataFindEpsonVO> getDetailData() {
		return _detailData;
	}

	/**
	 * �L����׃e�[�u��(THB2KMEI)VO���X�g��ݒ肵�܂��B
	 * @param thb2KmeiList
	 */
	public void setDetailData(List<DetailDataFindEpsonVO> detailData) {
		_detailData = detailData;
	}

}

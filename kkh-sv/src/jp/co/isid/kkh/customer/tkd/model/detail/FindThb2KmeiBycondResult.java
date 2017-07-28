package jp.co.isid.kkh.customer.tkd.model.detail;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import jp.co.isid.kkh.model.AbstractServiceResult;
import jp.co.isid.kkh.model.detail.Thb2KmeiVO;

/**
*
* <P>
* ���{No�����t�^�̌��ʂ�ێ�����B
* </P>
* <P>
* <B>�C������</B><BR>
* �E�V�K�쐬(2011/12/6 H.izawa)<BR>
* </P>
* @author
*/
@XmlRootElement(namespace = "http://detail.model.tkd.customer.kkh.isid.co.jp/")
@XmlType(namespace = "http://detail.model.tkd.customer.kkh.isid.co.jp/")
public class FindThb2KmeiBycondResult extends AbstractServiceResult {

	/** �L����׃e�[�u��(THB2KMEI)VO���X�g */
	private List<Thb2KmeiVO> _thb2KmeiList;


	/**
	 * �L����׃e�[�u��(THB2KMEI)VO���X�g��ݒ肵�܂��B
	 * @param thb2KmeiList
	 */
	public List<Thb2KmeiVO> get_thb2KmeiList() {
		return _thb2KmeiList;
	}

	/**
	 * �L����׃e�[�u��(THB2KMEI)VO���X�g��ݒ肵�܂��B
	 * @param thb2KmeiList
	 */
	public void set_thb2KmeiList(List<Thb2KmeiVO> thb2KmeiList) {
		_thb2KmeiList = thb2KmeiList;
	}
	/** List�����ł�Web�T�[�r�X�Ɍ��J����Ȃ��̂Ń_�~�[�v���p�e�B��ǉ� */
    private String _dummy;

    /**
     * List�����ł�Web�T�[�r�X�Ɍ��J����Ȃ��̂Ń_�~�[�v���p�e�B��ǉ����擾���܂��B
     * @return String �_�~�[�v���p�e�B
     */
    public String getDummy() {
        return _dummy;
    }

    /**
     * List�����ł�Web�T�[�r�X�Ɍ��J����Ȃ��̂Ń_�~�[�v���p�e�B��ǉ���ݒ肵�܂��B
     * @param dummy �_�~�[�v���p�e�B
     */
    public void setDummy(String dummy) {
        this._dummy = dummy;
    }

}

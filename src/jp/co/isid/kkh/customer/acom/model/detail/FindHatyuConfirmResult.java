package jp.co.isid.kkh.customer.acom.model.detail;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import jp.co.isid.kkh.model.AbstractServiceResult;

/**
*
* <P>
* ���{No�����t�^�̌��ʂ�ێ�����B
* </P>
* <P>
* <B>�C������</B><BR>
* �E�V�K�쐬(2011/12/22 H.izawa)<BR>
* </P>
* @author
*/
@XmlRootElement(namespace = "http://detail.model.kkh.isid.co.jp/")
@XmlType(namespace = "http://detail.model.kkh.isid.co.jp/")
public class FindHatyuConfirmResult extends AbstractServiceResult {

    /** �L����׃e�[�u��(Thb5Hik)VO���X�g */
    private List<HikVO> _thb5HikList;

    /**
     * �L����׃e�[�u��(Thb5Hik)VO���X�g��ݒ肵�܂��B
     * @param thb5HikList
     */
    public List<HikVO> get_thb5HikList() {
        return _thb5HikList;
    }

    /**
     * �L����׃e�[�u��(Thb5Hik)VO���X�g��ݒ肵�܂��B
     * @param thb5HikList
     */
    public void set_thb5HikList(List<HikVO> thb5HikList) {
        _thb5HikList = thb5HikList;
    }

    //	/**
//	 * �L����׃e�[�u��(Thb5Hik)VO���X�g��ݒ肵�܂��B
//	 * @param thb5HikList
//	 */
//	public List<Thb5HikVO> get_thb5HikList() {
//		return _thb5HikList;
//	}
//
//	/**
//	 * �L����׃e�[�u��(THB2KMEI)VO���X�g��ݒ肵�܂��B
//	 * @param thb2KmeiList
//	 */
//	public void set_thb5HikList(List<Thb2KmeiVO> thb2KmeiList) {
//		_thb2KmeiList = thb2KmeiList;
//	}
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

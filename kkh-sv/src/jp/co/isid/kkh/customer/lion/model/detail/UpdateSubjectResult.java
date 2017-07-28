package jp.co.isid.kkh.customer.lion.model.detail;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import jp.co.isid.kkh.model.AbstractServiceResult;
import jp.co.isid.kkh.model.detail.Thb1DownVO;

/**
 * @param args
 */
@XmlRootElement(namespace = "http://detail.model.lion.customer.kkh.isid.co.jp/")
@XmlType(namespace = "http://detail.model.lion.customer.kkh.isid.co.jp/")
public class UpdateSubjectResult extends AbstractServiceResult {

	/** �L����׃e�[�u��(Thb1Down)VO���X�g */
	private List<Thb1DownVO> _thb1DownList;


	/**
	 * �L����׃e�[�u��(Thb1Down)VO���X�g��ݒ肵�܂��B
	 * @param thb2KmeiList
	 */
	public List<Thb1DownVO> get_thb1DownList() {
		return _thb1DownList;
	}

	/**
	 * �L����׃e�[�u��(Thb1Down)VO���X�g��ݒ肵�܂��B
	 * @param thb2KmeiList
	 */
	public void set_thb1DownList(List<Thb1DownVO> thb1DownList) {
		_thb1DownList = thb1DownList;
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
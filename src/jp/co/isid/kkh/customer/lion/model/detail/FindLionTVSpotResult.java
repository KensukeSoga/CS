package jp.co.isid.kkh.customer.lion.model.detail;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import jp.co.isid.kkh.customer.lion.model.detail.FindLionTVSpotVO;
import jp.co.isid.kkh.model.AbstractServiceResult;

/**
 * <P>
 * ���C�I��TVSpot�f�[�^�擾����
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/03/05 JSE Hitoshi Sasaki)<BR>
 * </P>
 *
 * @author JSE Hitoshi Sasaki
 */
@XmlRootElement(namespace = "http://detail.model.lion.customer.kkh.isid.co.jp/")
@XmlType(namespace = "http://detail.model.lion.customer.kkh.isid.co.jp/")
public class FindLionTVSpotResult extends AbstractServiceResult {

	/** ���C�I��TVSpot�f�[�^�擾VO���X�g */
	private List<FindLionTVSpotVO> _Rep;

	/**
	 * ���C�I��TVSpot�f�[�^�擾VO���X�g���擾���܂��B
	 *
	 * @return _masterItem
	 */
	public List<FindLionTVSpotVO> getFindLionTVSpot() {
		return _Rep;
	}

	/**
	 * ���C�I��TVSpot�f�[�^�擾VO���X�g��ݒ肵�܂��B
	 *
	 * @param masterItem
	 *            �Z�b�g���� _masterItem
	 */
	public void setFindLionTVSpot(List<FindLionTVSpotVO> rep) {
		_Rep = rep;
	}

	/** List�����ł�Web�T�[�r�X�Ɍ��J����Ȃ��̂Ń_�~�[�v���p�e�B��ǉ� */
	private String _dummy;

	/**
	 * List�����ł�Web�T�[�r�X�Ɍ��J����Ȃ��̂Ń_�~�[�v���p�e�B��ǉ����擾���܂��B
	 *
	 * @return String �_�~�[�v���p�e�B
	 */
	public String getDummy() {
		return _dummy;
	}

	/**
	 * List�����ł�Web�T�[�r�X�Ɍ��J����Ȃ��̂Ń_�~�[�v���p�e�B��ǉ���ݒ肵�܂��B
	 *
	 * @param dummy
	 *            �_�~�[�v���p�e�B
	 */
	public void setDummy(String dummy) {
		this._dummy = dummy;
	}
}

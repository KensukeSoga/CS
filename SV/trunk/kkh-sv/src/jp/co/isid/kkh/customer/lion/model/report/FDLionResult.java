package jp.co.isid.kkh.customer.lion.model.report;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import jp.co.isid.kkh.model.AbstractServiceResult;

/**
 * <P>
 * ���C�I��FD�o�̓f�[�^�擾����
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/01/23 JSE Hitoshi Sasaki)<BR>
 * </P>
 *
 * @author JSE Hitoshi Sasaki
 */
@XmlRootElement(namespace = "http://fd.model.lion.customer.kkh.isid.co.jp/")
@XmlType(namespace = "http://fd.model.lion.customer.kkh.isid.co.jp/")
public class FDLionResult extends AbstractServiceResult {

	/** ���C�I��FD�o�̓f�[�^�擾VO���X�g */
	private List<FDLionVO> _Rep;

	/**
	 * ���C�I��FD�o�̓f�[�^�擾VO���X�g���擾���܂��B
	 *
	 * @return _masterItem
	 */
	public List<FDLionVO> getFDLion() {
		return _Rep;
	}

	/**
	 * ���C�I��FD�o�̓f�[�^�擾VO���X�g��ݒ肵�܂��B
	 *
	 * @param masterItem
	 *            �Z�b�g���� _masterItem
	 */
	public void setFDLion(List<FDLionVO> rep) {
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

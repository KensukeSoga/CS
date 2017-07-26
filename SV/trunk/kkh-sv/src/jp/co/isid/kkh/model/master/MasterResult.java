package jp.co.isid.kkh.model.master;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import jp.co.isid.kkh.model.AbstractServiceResult;

/**
*
* <P>
* �ėp�}�X�^�f�[�^��ێ�����B
* </P>
* <P>
* <B>�C������</B><BR>
* �E�V�K�쐬(2011/11/04 JSE K.Fukuda)<BR>
* </P>
* @author HLC K.Honma
*/
@XmlRootElement(namespace = "http://master.model.kkh.isid.co.jp/")
@XmlType(namespace = "http://master.model.kkh.isid.co.jp/")
public class MasterResult extends AbstractServiceResult {
	/** �}�X�^��ސݒ�VO���X�g */
	private List<MasterVO> _masterKind;

	/** �}�X�^����VO���X�g */
	private List<MasterVO> _masterItem;

	/** �}�X�^�f�[�^VO���X�g */
	private List<MasterDataVO> _masterData;

	/**
	 * �}�X�^��ސݒ�VO���X�g���擾���܂��B
	 * @return _masterKind
	 */
	public List<MasterVO> getMasterKind() {
		return _masterKind;
	}

	/**
	 * �}�X�^��ސݒ�VO���X�g��ݒ肵�܂��B
	 * @param masterKind �Z�b�g���� _masterKind
	 */
	public void setMasterKind(List<MasterVO> masterKind) {
		_masterKind = masterKind;
	}

	/**
	 * �}�X�^���ڐݒ�VO���X�g���擾���܂��B
	 * @return _masterItem
	 */
	public List<MasterVO> getMasterItem() {
		return _masterItem;
	}

	/**
	 * �}�X�^���ڐݒ�VO���X�g��ݒ肵�܂��B
	 * @param masterItem �Z�b�g���� _masterItem
	 */
	public void setMasterItem(List<MasterVO> masterItem) {
		_masterItem = masterItem;
	}

	/**
	 * �}�X�^�f�[�^VO���X�g���擾���܂��B
	 * @return _masterData
	 */
	public List<MasterDataVO> getMasterData() {
		return _masterData;
	}

	/**
	 * �}�X�^�f�[�^VO���X�g��ݒ肵�܂��B
	 * @param masterData �Z�b�g���� _masterData
	 */
	public void setMasterData(List<MasterDataVO> masterData) {
		_masterData = masterData;
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

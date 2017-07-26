package jp.co.isid.kkh.model.common;

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
@XmlRootElement(namespace = "http://common.model.kkh.isid.co.jp/")
@XmlType(namespace = "http://common.model.kkh.isid.co.jp/")
public class CommonCodeMasterResult extends AbstractServiceResult {
	/** CommonCodeMasterVO���X�g */
	private List<CommonCodeMasterVO> _rcmnMeu29CC;

	/**
	 * �}�X�^��ސݒ�VO���X�g���擾���܂��B
	 * @return _masterKind
	 */
	public List<CommonCodeMasterVO> getCommonCodeMaster() {
		return _rcmnMeu29CC;
	}

	/**
	 * �}�X�^��ސݒ�VO���X�g��ݒ肵�܂��B
	 * @param masterKind �Z�b�g���� _masterKind
	 */
	public void setCommonCodeMaster(List<CommonCodeMasterVO> rcmnMeu29CC) {
		_rcmnMeu29CC = rcmnMeu29CC;
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

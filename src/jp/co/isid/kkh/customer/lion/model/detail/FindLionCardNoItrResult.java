package jp.co.isid.kkh.customer.lion.model.detail;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import jp.co.isid.kkh.model.AbstractServiceResult;


/**
*
* <P>
* �J�[�hNO���Ƃ̔}�̋敪�����f�[�^��ێ�����B
* </P>
* <P>
* <B>�C������</B><BR>
* �E�V�K�쐬(2012/02/21 JSE A.Naito)<BR>
* </P>
* @author JSE A.Naito
*/
@XmlRootElement(namespace = "http://detail.model.lion.customer.kkh.isid.co.jp/")
@XmlType(namespace = "http://detail.model.lion.customer.kkh.isid.co.jp/")
public class FindLionCardNoItrResult extends AbstractServiceResult {
	/** �}�X�^��ސݒ�VO���X�g */
	private List<FindLionCardNoItrVO> _Rep;

	/**
	 * �}�X�^���ڐݒ�VO���X�g���擾���܂��B
	 * @return _masterItem
	 */
	public List<FindLionCardNoItrVO> getFindLionCardNoItr() {
		return _Rep;
	}

	/**
	 * �}�X�^���ڐݒ�VO���X�g��ݒ肵�܂��B
	 * @param masterItem �Z�b�g���� _masterItem
	 */
	public void setFindLionCardNoItr(List<FindLionCardNoItrVO> rep) {
		_Rep = rep;
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

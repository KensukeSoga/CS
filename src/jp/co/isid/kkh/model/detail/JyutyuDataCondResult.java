package jp.co.isid.kkh.model.detail;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import jp.co.isid.kkh.model.AbstractServiceResult;

/**
*
* <P>
* �󒍃f�[�^��ێ�����B
* </P>
* <P>
* <B>�C������</B><BR>
* �E�V�K�쐬(2011/11/04 JSE K.Fukuda)<BR>
* </P>
* @author
*/
@XmlRootElement(namespace = "http://detail.model.kkh.isid.co.jp/")
@XmlType(namespace = "http://detail.model.kkh.isid.co.jp/")
public class JyutyuDataCondResult extends AbstractServiceResult {
	/** �󒍃f�[�^VO���X�g */
	private List<JyutyuDataVO> _jutyuData;


	/**
	 * �󒍃f�[�^VO���X�g���擾���܂��B
	 * @return _jutyuData
	 */
	public List<JyutyuDataVO> getJutyuData() {
		return _jutyuData;
	}

	/**
	 * �󒍃f�[�^VO���X�g��ݒ肵�܂��B
	 * @param jutyuData
	 */
	public void setJutyuData(List<JyutyuDataVO> jutyuData) {
		_jutyuData = jutyuData;
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

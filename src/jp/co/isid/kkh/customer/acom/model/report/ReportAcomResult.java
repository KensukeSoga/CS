package jp.co.isid.kkh.customer.acom.model.report;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import jp.co.isid.kkh.customer.acom.model.report.ReportAcomVO;
import jp.co.isid.kkh.model.AbstractServiceResult;

/**
*
* <P>
* �A�R���f�[�^��ێ�����B
* </P>
* <P>
* <B>�C������</B><BR>
* �E�V�K�쐬(2012/01/11)<BR>
* </P>
* @author
*/
@XmlRootElement(namespace = "http://report.model.acom.customer.kkh.isid.co.jp/")
@XmlType(namespace = "http://report.model.acom.customer.kkh.isid.co.jp/")
public class ReportAcomResult extends AbstractServiceResult{

	/** �}�X�^��ސݒ�VO���X�g */
	private List<ReportAcomVO> _Rep;

	/**
	 * �}�X�^���ڐݒ�VO���X�g���擾���܂��B
	 * @return _masterItem
	 */
	public List<ReportAcomVO> getReportAcom() {
		return _Rep;
	}

	/**
	 * �}�X�^���ڐݒ�VO���X�g��ݒ肵�܂��B
	 * @param masterItem �Z�b�g���� _masterItem
	 */
	public void setReportAcom(List<ReportAcomVO> rep) {
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

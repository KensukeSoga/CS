package jp.co.isid.kkh.customer.ash.model.report;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import jp.co.isid.kkh.model.AbstractServiceResult;


/**
*
* <P>
* MAC�f�[�^��ێ�����B
* </P>
* <P>
* <B>�C������</B><BR>
* �E�V�K�쐬(2011/1/20 fourm h.izawa)<BR>
* </P>
* @author HLC K.Honma
*/
@XmlRootElement(namespace = "http://report.model.ash.customer.kkh.isid.co.jp/")
@XmlType(namespace = "http://report.model.ash.customer.kkh.isid.co.jp/")
public class ReportAshMediaCodeResult extends AbstractServiceResult {
	/** �}�X�^��ސݒ�VO���X�g */
	private List<ReportAshMediaCodeVO> _Rep;
	private List<ReportAshMediaCodeVO> _Rep1;
	private List<ReportAshOldKyokuVO>  _Rep2;
	private List<ReportAshBangumiDataVO> _Rep3;


	public List<ReportAshBangumiDataVO> getReportAshBangumiData() {
		return _Rep3;
	}

	public void setReportAshBangumiData(List<ReportAshBangumiDataVO> rep3) {
		_Rep3 = rep3;
	}

	public List<ReportAshOldKyokuVO> getReportAshOldKyoku() {
		return _Rep2;
	}

	public void setReportAshOldKyoku(List<ReportAshOldKyokuVO> rep2) {
		_Rep2 = rep2;
	}

	/**
	 * �}�X�^���ڐݒ�VO���X�g���擾���܂��B
	 * @return _masterItem
	 */
	public List<ReportAshMediaCodeVO> getReportAshCode() {
		return _Rep;
	}

	/**
	 * �}�X�^���ڐݒ�VO���X�g��ݒ肵�܂��B
	 * @param masterItem �Z�b�g���� _masterItem
	 */
	public void setReportAshCode(List<ReportAshMediaCodeVO> rep) {
		_Rep = rep;
	}
	/**
	 *���i�R�[�h��VO���X�g���擾
	 * @return
	 */
	public List<ReportAshMediaCodeVO> getSyohinCode() {
		return _Rep1;
	}
	/**
	 * ���i�R�[�h��VO���X�g��ݒ�
	 * @param rep
	 */
	public void setSyohinCode(List<ReportAshMediaCodeVO> rep1) {
		_Rep1 = rep1;
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

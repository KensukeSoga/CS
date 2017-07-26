package jp.co.isid.kkh.customer.tkd.model.report;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import jp.co.isid.kkh.model.AbstractServiceResult;

/**
 * <P>
 * ���c�������ׁi�i�ڕʁj�擾����
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/01/23 JSE Hitoshi Sasaki)<BR>
 * </P>
 *
 * @author JSE Hitoshi Sasaki
 */

@XmlRootElement(namespace = "http://report.model.tkd.customer.kkh.isid.co.jp/")
@XmlType(namespace = "http://report.model.tkd.customer.kkh.isid.co.jp/")
public class ReportTkdBillingByItemResult extends AbstractServiceResult {
	/** �}�X�^��ސݒ�VO���X�g */
	private List<ReportTkdBillingByItemVO> _Rep;

	/**
	 * �}�X�^���ڐݒ�VO���X�g���擾���܂��B
	 *
	 * @return _masterItem
	 */
	public List<ReportTkdBillingByItemVO> getReportTkdBilling() {
		return _Rep;
	}

	/**
	 * �}�X�^���ڐݒ�VO���X�g��ݒ肵�܂��B
	 *
	 * @param masterItem
	 *            �Z�b�g���� _masterItem
	 */
	public void setReportTkdBilling(List<ReportTkdBillingByItemVO> rep) {
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

package jp.co.isid.kkh.customer.lion.model.report;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import jp.co.isid.kkh.customer.lion.model.report.DetailListLionVO;
import jp.co.isid.kkh.model.AbstractServiceResult;

/**
*
* <P>
* ���C�I���f�[�^��ێ�����B
* </P>
* <P>
* <B>�C������</B><BR>
* �E�V�K�쐬(2013/02/07)<BR>
* </P>
* @author
*/
@XmlRootElement(namespace = "http://report.model.lion.customer.kkh.isid.co.jp/")
@XmlType(namespace = "http://report.model.lion.customer.kkh.isid.co.jp/")
public class DetailListLionResult extends AbstractServiceResult{

	/** ���׈ꗗVO���X�g */
	private List<DetailListLionVO> _Rep;

	private List<DetailListLionVO> _Rep1;

	private List<DetailListLionVO> _Rep2;

	/**
	 * ���׈ꗗVO���X�g���擾���܂��B
	 * @return _Rep
	 */
	public List<DetailListLionVO> getDetailListLion() {
		return _Rep;
	}

	/**
	 * ���׈ꗗVO���X�g��ݒ肵�܂��B
	 * @param rep �Z�b�g���� _Rep
	 */
	public void setDetailListLion(List<DetailListLionVO> rep) {
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

    /**
     * �S�}�̂̏���ł��擾
     * @return _Rep
     */
	public List<DetailListLionVO> getDetailListLionSyohiZei() {
		return _Rep1;
	}

	/**
	 * �S�}�̂̏���ł�ݒ�
     * @param rep �Z�b�g���� _Rep
	 */
	public void setDetailListLionSyohiZei(List<DetailListLionVO> rep1) {
		_Rep1 = rep1;
	}




	public List<DetailListLionVO> getBaitaiCdName() {
		return _Rep2;
	}

	public void setBaitaiCdName(List<DetailListLionVO> rep2) {
		_Rep2 = rep2;
	}

}

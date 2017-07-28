package jp.co.isid.kkh.customer.epson.model.report;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import jp.co.isid.kkh.model.AbstractServiceResult;

/**
*
* <P>
* ��o���[�f�[�^��ێ�����B
* </P>
* <P>
* <B>�C������</B><BR>
* �E�V�K�쐬(2012/3/5 JSE YS)<BR>
* </P>
* @author
*/
@XmlRootElement(namespace = "http://report.model.kkh.isid.co.jp/")
@XmlType(namespace = "http://report.model.kkh.isid.co.jp/")
public class ReportEpsonSubMissionResult extends AbstractServiceResult {

    /** ��o���[�i�G�v�\��)VO���X�g */
    private List<ReportEpsonSubMissionVO> _rep;

    /**
     * ��o���[�i�G�v�\��)VO���X�g���擾���܂��B
     * @return _rep
     */
    public List<ReportEpsonSubMissionVO> getReportEpsonSubMission() {
        return _rep;
    }

    /**
     * ��o���[�i�G�v�\��)VO���X�g��ݒ肵�܂��B
     * @param rep �Z�b�g���� _rep
     */
    public void setReportEpsonSubMission(List<ReportEpsonSubMissionVO> rep) {
        _rep = rep;
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

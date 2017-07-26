package jp.co.isid.kkh.customer.lion.model.report;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import jp.co.isid.kkh.model.AbstractServiceResult;

/**
*
* <P>
* ���C�I�����[(���쎺���X�g)�������ʕێ��N���X
* </P>
* <P>
* <B>�C������</B><BR>
* �E�V�K�쐬(2014/07/31 HLC S.Fujimoto)<BR>
* </P>
*
* @author HLC S.Fujimoto
*/
@XmlRootElement(namespace = "http://report.model.lion.customer.kkh.isid.co.jp/")
@XmlType(namespace = "http://report.model.lion.customer.kkh.isid.co.jp/")
public class AddChangeReportLionSeisakuResult extends AbstractServiceResult{

    /** ���C�I�����쎺���X�g�f�[�^��������VO���X�g */
    /** �����^�C���X�^���v */
    private List<AddChangeReportLionSeisakuVO> _vo1;
    /** ���쎺���X�g(AD1) */
    private List<AddChangeReportLionSeisakuVO> _vo2;
    /** ���쎺���X�g(AD2) */
    private List<AddChangeReportLionSeisakuVO> _vo3;
    /** ���쎺���X�g(AD1/AD2����) */
    private List<AddChangeReportLionSeisakuVO> _vo4;

    /**
     * �����^�C���X�^���v���擾
     * @return �����^�C���X�^���v
     */
    public List<AddChangeReportLionSeisakuVO> getRrkTimStmpInfo() {
        return _vo1;
    }

    /**
     * �����^�C���X�^���v��ݒ�
     * @param val List<AddChangeReportVO> �����^�C���X�^���v
     */
    public void setRrkTimStmpInfo(List<AddChangeReportLionSeisakuVO> val) {
        _vo1 = val;
    }

    /**
     * ���쎺���X�g(AD1)���擾
     * @return ���쎺���X�g(AD1)
     */
    public List<AddChangeReportLionSeisakuVO> getSeisakuAD1Info() {
        return _vo2;
    }

    /**
     * ���쎺���X�g(AD1)��ݒ�
     * @param val List<AddChangeReportVO> ���쎺���X�g(AD1)
     */
    public void setSeisakuAD1Info(List<AddChangeReportLionSeisakuVO> val) {
        _vo2 = val;
    }

    /**
     * ���쎺���X�g(AD2)���擾
     * @return ���쎺���X�g(AD2)
     */
    public List<AddChangeReportLionSeisakuVO> getSeisakuAD2Info() {
        return _vo3;
    }

    /**
     * ���쎺���X�g(AD2)��ݒ�
     * @param val List<AddChangeReportVO> ���쎺���X�g(AD2)
     */
    public void setSeisakuAD2Info(List<AddChangeReportLionSeisakuVO> val) {
        _vo3 = val;
    }

    /**
     * ���쎺���X�g(AD1/AD2����)���擾
     * @return ���쎺���X�g(AD1/AD2����)
     */
    public List<AddChangeReportLionSeisakuVO> getSeisakuDiffInfo() {
        return _vo4;
    }

    /**
     * ���쎺���X�g(AD1/AD2����)��ݒ�
     * @param val List<AddChangeReportVO> ���쎺���X�g(AD1/AD2����)
     */
    public void setSeisakuDiffInfo(List<AddChangeReportLionSeisakuVO> val) {
        _vo4 = val;
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
    public void setDummy(String val) {
        _dummy = val;
    }

}

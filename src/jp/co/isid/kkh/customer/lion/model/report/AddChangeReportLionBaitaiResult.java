package jp.co.isid.kkh.customer.lion.model.report;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import jp.co.isid.kkh.model.AbstractServiceResult;

/**
*
* <P>
* ���C�I�����[(�ǉ��ύX���X�g)�������ʕێ��N���X
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
public class AddChangeReportLionBaitaiResult extends AbstractServiceResult{

    /** ���C�I���ǉ��ύX���X�g�f�[�^��������VO���X�g */
    /** �����^�C���X�^���v */
    private List<AddChangeReportLionBaitaiVO> _vo1;
    /** �ǉ��ύX���X�g(AD1) */
    private List<AddChangeReportLionBaitaiVO> _vo2;
    /** �ǉ��ύX���X�g(AD2) */
    private List<AddChangeReportLionBaitaiVO> _vo3;
    /** �ǉ��ύX���X�g(AD1/AD2�����A��������) */
    private List<AddChangeReportLionBaitaiVO> _vo4;
    /** �ǉ��ύX���X�g(AD1/AD2����) */
    private List<AddChangeReportLionBaitaiVO> _vo5;

    /**
     * �����^�C���X�^���v���擾
     * @return �����^�C���X�^���v
     */
    public List<AddChangeReportLionBaitaiVO> getRrkTimStmpInfo() {
        return _vo1;
    }

    /**
     * �����^�C���X�^���v��ݒ�
     * @param val List<AddChangeReportLionBaitaiVO> �����^�C���X�^���v
     */
    public void setRrkTimStmpInfo(List<AddChangeReportLionBaitaiVO> val) {
        _vo1 = val;
    }

    /**
     * �ǉ��ύX���X�g(AD1)���擾
     * @return �ǉ��ύX���X�g(AD1)
     */
    public List<AddChangeReportLionBaitaiVO> getBaitaiAD1Info() {
        return _vo2;
    }

    /**
     * �ǉ��ύX���X�g(AD1)��ݒ�
     * @param val List<AddChangeReportLionBaitaiVO> �ǉ��ύX���X�g(AD1)
     */
    public void setBaitaiAD1Info(List<AddChangeReportLionBaitaiVO> val) {
        _vo2 = val;
    }

    /**
     * �ǉ��ύX���X�g(AD2)���擾
     * @return �ǉ��ύX���X�g(AD2)
     */
    public List<AddChangeReportLionBaitaiVO> getBaitaiAD2Info() {
        return _vo3;
    }

    /**
     * �ǉ��ύX���X�g(AD2)��ݒ�
     * @param val List<AddChangeReportLionBaitaiVO> �ǉ��ύX���X�g(AD2)
     */
    public void setBaitaiAD2Info(List<AddChangeReportLionBaitaiVO> val) {
        _vo3 = val;
    }

    /**
     * �ǉ��ύX���X�g(AD1/AD2�����A��������)���擾
     * @return �ǉ��ύX���X�g(AD1/AD2�����A��������)
     */
    public List<AddChangeReportLionBaitaiVO> getBaitaiDiffInfoInternal() {
        return _vo4;
    }

    /**
     * �ǉ��ύX���X�g(AD1/AD2�����A��������)��ݒ�
     * @param val List<AddChangeReportLionBaitaiVO> �ǉ��ύX���X�g(AD1/AD2�����A��������)
     */
    public void setBaitaiDiffInfoInternal(List<AddChangeReportLionBaitaiVO> val) {
        _vo4 = val;
    }

    /**
     * �ǉ��ύX���X�g(AD1/AD2����)���擾
     * @return
     */
    public List<AddChangeReportLionBaitaiVO> getBaitaiDiffInfoExternal() {
        return _vo5;
    }

    /**
     * �ǉ��ύX���X�g(AD1/AD2����)��ݒ�
     * @param val
     */
    public void setBaitaiDiffInfoExternal(List<AddChangeReportLionBaitaiVO> val) {
        _vo5 = val;
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

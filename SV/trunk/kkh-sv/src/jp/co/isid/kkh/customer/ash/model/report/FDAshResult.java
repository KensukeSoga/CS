package jp.co.isid.kkh.customer.ash.model.report;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import jp.co.isid.kkh.model.AbstractServiceResult;

/**
*
* <P>
* �����f�[�^�ꗗ�iAsh�j�f�[�^��������
* </P>
* <P>
* <B>�C������</B><BR>
* </P>
*/
@XmlRootElement(namespace = "http://report.model.ash.customer.kkh.isid.co.jp/")
@XmlType(namespace = "http://report.model.ash.customer.kkh.isid.co.jp/")
public class FDAshResult extends AbstractServiceResult {

    /** �����f�[�^�ꗗVO���X�g */
    private List<FDAshVO> _Rep;

    /**
     * �����f�[�^�ꗗVO���X�g���擾���܂��B
     * @return �����f�[�^�ꗗ
     */
    public List<FDAshVO> getFDAsh() {
        return _Rep;
    }

    /**
     * �����f�[�^�ꗗVO���X�g��ݒ肵�܂��B
     * @param rep List<FDAshVO> �����f�[�^�ꗗ
     */
    public void setFDAsh(List<FDAshVO> rep) {
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
        _dummy = dummy;
    }

}

package jp.co.isid.kkh.customer.acom.model.input;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import jp.co.isid.kkh.model.AbstractServiceResult;


/**
 *
 * <P>
 * �����f�[�^��ێ�����B
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2011/11/08 HLC J.Morobayashi)<BR>
 * </P>
 * @author HLC J.Morobayashi
 */
@XmlRootElement(namespace = "http://input.model.kkh.isid.co.jp/")
@XmlType(namespace = "http://input.model.kkh.isid.co.jp/")
public class HikRegistResult extends AbstractServiceResult {

    /** �����f�[�^VO���X�g */
    private List<HikRegistVOList> _hikUpdataVOList;

    /** List�����ł�Web�T�[�r�X�Ɍ��J����Ȃ��̂Ń_�~�[�v���p�e�B��ǉ� */
    private String _dummy;


    /**
     * �����f�[�^VO���X�g���擾���܂��B
     *
     * @return List<HikUpdataVO> �����f�[�^VO���X�g���̃��X�g
     */
    public List<HikRegistVOList> getHikVOList() {
        return _hikUpdataVOList;
    }

    /**
     * �����f�[�^VO���X�g��ݒ肵�܂��B
     * @param hikVOList List<HikUpdataVO> �����f�[�^VO���X�g
     */
    public void setHikVOList(List<HikRegistVOList> hikUpdataVOList) {
    	_hikUpdataVOList = hikUpdataVOList;
    }

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

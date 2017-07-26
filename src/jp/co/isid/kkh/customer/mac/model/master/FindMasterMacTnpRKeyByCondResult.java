package jp.co.isid.kkh.customer.mac.model.master;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import jp.co.isid.kkh.model.AbstractServiceResult;

/**
 *
 * <P>
 * �}�N�h�i���h�X�܃}�X�^�����e�[�u���L�[���ڂ�ێ�����B
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2013/02/01 JSE H.Okazaki)<BR>
 * </P>
 *
 * @author
 */
@XmlRootElement(namespace = "http://master.model.mac.customer.kkh.isid.co.jp/")
@XmlType(namespace = "http://master.model.mac.customer.kkh.isid.co.jp/")
public class FindMasterMacTnpRKeyByCondResult extends AbstractServiceResult {

    /** �}�N�h�i���h�X�܃}�X�^�����e�[�u��(THB17RMTNP)VO���X�g */
    private List<FindMasterMacTnpRKeyByCondVO> _thb17RmtnpList;

    /**
     * �}�N�h�i���h�X�܃}�X�^�����e�[�u��(THB17RMTNP)VO���X�g��ݒ肵�܂��B
     * @param thb17RmtnpList
     */
    public List<FindMasterMacTnpRKeyByCondVO> get_thb17RmtnpList() {
        return _thb17RmtnpList;
    }

    /**
     * �}�N�h�i���h�X�܃}�X�^�����e�[�u��(THB17RMTNP)VO���X�g��ݒ肵�܂��B
     * @param thb17RmtnpList
     */
    public void set_thb17RmtnpList(List<FindMasterMacTnpRKeyByCondVO> thb17RmtnpList) {
        _thb17RmtnpList = thb17RmtnpList;
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

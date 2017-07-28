package jp.co.isid.kkh.model.login;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import jp.co.isid.kkh.model.AbstractServiceResult;

/**
*
* <P>
* ���O�C������ێ�����B
* </P>
* <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/02/13 JSE H.Abe)<BR>
 * </P>
 * @author JSE H.Abe
*/
@XmlRootElement(namespace = "http://login.model.kkh.isid.co.jp/")
@XmlType(namespace = "http://login.model.kkh.isid.co.jp/")
public class LoginResult extends AbstractServiceResult {

    /** �c�Ə��i��j�R�[�h */
    private String _egCd = null;

    /** ���[�U�[�� */
    private String _userName = null;

    /** ���O�C�����Ӑ��񃊃X�g */
    private List<LoginCustomerInfoVO> _loginCustomerInfoVOList = null;

    private String _SystemAdministerFlg = null;

    /**
     * �c�Ə��i��j�R�[�h���擾����
     * @return �c�Ə��i��j�R�[�h
     */
    public String getEgCd() {
        return _egCd;
    }

    /**
     * �c�Ə��i��j�R�[�h��ݒ肷��
     * @param egCd �c�Ə��i��j�R�[�h
     */
    public void setEgCd(String egCd) {
        this._egCd = egCd;
    }

    /**
     * ���[�U�[�����擾����
     * @return ���[�U�[��
     */
    public String getUserName() {
        return _userName;
    }

    /**
     * ���[�U�[����ݒ肷��
     * @param userName ���[�U�[��
     */
    public void setUserName(String userName) {
        this._userName = userName;
    }

    /**
     * ���O�C�����Ӑ��񃊃X�g���擾����
     * @return ���O�C�����Ӑ��񃊃X�g
     */
    public List<LoginCustomerInfoVO> getLoginCustomerInfoVOList() {
        return _loginCustomerInfoVOList;
    }

    /**
     * ���O�C�����Ӑ��񃊃X�g��ݒ肷��
     * @param loginCustomerInfoVOList ���O�C�����Ӑ��񃊃X�g
     */
    public void setLoginCustomerInfoVOList(List<LoginCustomerInfoVO> loginCustomerInfoVOList) {
        this._loginCustomerInfoVOList = loginCustomerInfoVOList;
    }

    /**
     * �V�X�e���Ǘ��҃t���O
     * @return �V�X�e���Ǘ��҃t���O
     */
    public String get_SystemAdministerFlg() {
        return _SystemAdministerFlg;
    }

    /**
     * �V�X�e���Ǘ��҃t���O
     * @param _SystemAdministerFlg
     */
    public void set_SystemAdministerFlg(String SystemAdministerFlg) {
        this._SystemAdministerFlg = SystemAdministerFlg;
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

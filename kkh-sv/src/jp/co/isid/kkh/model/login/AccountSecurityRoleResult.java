package jp.co.isid.kkh.model.login;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import jp.co.isid.kkh.model.AbstractServiceResult;

/**
*
* <P>
* �Ɩ���v�Z�L�����e�B���[����ێ�����B
* </P>
* <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/02/13 JSE H.Abe)<BR>
 * </P>
 * @author JSE H.Abe
*/
@XmlRootElement(namespace = "http://login.model.kkh.isid.co.jp/")
@XmlType(namespace = "http://login.model.kkh.isid.co.jp/")
public class AccountSecurityRoleResult extends AbstractServiceResult {

    /** ���Ό��� */
    private String _relativeAuthority = null;

    /** �Z�L�����e�B���[���擾�ΏۊO�t���O */
    private boolean _notSecurityRoleFlag = false;

    /**
     * ���Ό������擾����
     * @return ���Ό���
     */
    public String getRelativeAuthority() {
        return _relativeAuthority;
    }

    /**
     * ���Ό�����ݒ肷��
     * @param relativeAuthority ���Ό���
     */
    public void setRelativeAuthority(String relativeAuthority) {
        this._relativeAuthority = relativeAuthority;
    }

    /**
     * �Z�L�����e�B���[���擾�ΏۊO�t���O���擾����
     * @return �Z�L�����e�B���[���擾�ΏۊO�t���O
     */
    @XmlElement(required = true)
    public boolean getNotSecurityRoleFlag() {
        return _notSecurityRoleFlag;
    }

    /**
     * �Z�L�����e�B���[���擾�ΏۊO�t���O��ݒ肷��
     * @param notSecurityRoleFlag �Z�L�����e�B���[���擾�ΏۊO�t���O
     */
    public void setNotSecurityRoleFlag(boolean notSecurityRoleFlag) {
        this._notSecurityRoleFlag = notSecurityRoleFlag;
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

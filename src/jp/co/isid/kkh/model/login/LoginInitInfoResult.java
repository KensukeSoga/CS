package jp.co.isid.kkh.model.login;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import jp.co.isid.kkh.model.AbstractServiceResult;

/**
*
* <P>
* ���O�C����������ێ�����B
* </P>
* <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/02/13 JSE H.Abe)<BR>
 * </P>
 * @author JSE H.Abe
*/
@XmlRootElement(namespace = "http://login.model.kkh.isid.co.jp/")
@XmlType(namespace = "http://login.model.kkh.isid.co.jp/")
public class LoginInitInfoResult extends AbstractServiceResult {

    /** �z�X�g�c�Ɠ� */
    private String _eigyoBi = null;

    /** �Ɩ���v�ғ��� */
    private boolean _accountOperationStatus = false;

    /** �S���ҏ����g�D�R�[�h */
    private String _organizationCode = null;

    /**
     * �z�X�g�c�Ɠ����擾����
     * @return �z�X�g�c�Ɠ�
     */
    public String getEigyoBi() {
        return _eigyoBi;
    }

    /**
     * �z�X�g�c�Ɠ���ݒ肷��
     * @param eigyoBi �z�X�g�c�Ɠ�
     */
    public void setEigyoBi(String eigyoBi) {
        this._eigyoBi = eigyoBi;
    }

    /**
     * �Ɩ���v�ғ��󋵂��擾����
     * @return �Ɩ���v�ғ���
     */
    @XmlElement(required = true)
    public boolean getAccountOperationStatus() {
        return _accountOperationStatus;
    }

    /**
     * �Ɩ���v�ғ��󋵂�ݒ肷��
     * @param accountOperationStatus �Ɩ���v�ғ���
     */
    public void setAccountOperationStatus(boolean accountOperationStatus) {
        this._accountOperationStatus = accountOperationStatus;
    }

    /**
     * �S���ҏ����g�D�R�[�h���擾����
     * @return �S���ҏ����g�D�R�[�h
     */
    public String getOrganizationCode() {
        return _organizationCode;
    }

    /**
     * �S���ҏ����g�D�R�[�h��ݒ肷��
     * @param organizationCode �S���ҏ����g�D�R�[�h
     */
    public void setOrganizationCode(String organizationCode) {
        this._organizationCode = organizationCode;
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

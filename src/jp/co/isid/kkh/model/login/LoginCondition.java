package jp.co.isid.kkh.model.login;

import java.io.Serializable;

public class LoginCondition implements Serializable {

    private static final long serialVersionUID = 1L;

    /** ���O�C���S����ESQID */
    private String _esqId = null;

    /** �^�pNo. */
    private String _operationNo = null;

    /** ���[�U�[ID */
    private String _userId = null;

    /** �p�X���[�h */
    private String _password = null;

    /** ���Ӑ�R�[�h */
    private String _customerCode = null;

    /** �ʏ탆�[�U�[�t���O */
    private String _normalUserFlag = null;

    /** ���Ό��� */
    private String _relativeAuthority = null;

    /** �S���ҏ����g�D�R�[�h */
    private String _organizationCode = null;

    /** �z�X�g�c�Ɠ� */
    private String _eigyoBi = null;

    /**
     * ���O�C���S����ESQID���擾����
     * @return ���O�C���S����ESQID
     */
    public String getEsqId() {
        return _esqId;
    }

    /**
     * ���O�C���S����ESQID��ݒ肷��
     * @param esqId ���O�C���S����ESQID
     */
    public void setEsqId(String esqId) {
        this._esqId = esqId;
    }

    /**
     * �^�pNo.���擾����
     * @return �^�pNo.
     */
    public String getOperationNo() {
        return _operationNo;
    }

    /**
     * �^�pNo.��ݒ肷��
     * @param operationNo �^�pNo.
     */
    public void setOperationNo(String operationNo) {
        this._operationNo = operationNo;
    }

    /**
     * ���[�U�[ID���擾����
     * @return ���[�U�[ID
     */
    public String getUserId() {
        return _userId;
    }

    /**
     * ���[�U�[ID��ݒ肷��
     * @param userId ���[�U�[ID
     */
    public void setUserId(String userId) {
        this._userId = userId;
    }

    /**
     * �p�X���[�h���擾����
     * @return �p�X���[�h
     */
    public String getPassword() {
        return _password;
    }

    /**
     * �p�X���[�h��ݒ肷��
     * @param password �p�X���[�h
     */
    public void setPassword(String password) {
        this._password = password;
    }

    /**
     * ���Ӑ�R�[�h���擾����
     * @return ���Ӑ�R�[�h
     */
    public String getCustomerCode() {
        return _customerCode;
    }

    /**
     * ���Ӑ�R�[�h��ݒ肷��
     * @param customerCode ���Ӑ�R�[�h
     */
    public void setCustomerCode(String customerCode) {
        this._customerCode = customerCode;
    }

    /**
     * �ʏ탆�[�U�[�t���O���擾����
     * @return �ʏ탆�[�U�[�t���O
     */
    public String getNormalUserFlag() {
        return _normalUserFlag;
    }

    /**
     * �ʏ탆�[�U�[�t���O��ݒ肷��
     * @param normalUserFlag �ʏ탆�[�U�[�t���O
     */
    public void setNormalUserFlag(String normalUserFlag) {
        this._normalUserFlag = normalUserFlag;
    }

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

}

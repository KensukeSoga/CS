package jp.co.isid.kkh.model.login;

import java.io.Serializable;

public class Tcm01KkhCondition implements Serializable {

    private static final long serialVersionUID = 1L;

    /** ��ʑg�D�R�[�h */
    private String _higherOrganizationCode = null;

    /** �^�pNo. */
    private String _operationNo = null;

    /** �E�ʃO���[�v�R�[�h�i�����j */
    private String _groupCd = null;

    /** �S���҃R�[�h */
    private String _tntCd = null;

    /** ���Ӑ�R�[�h */
    private String _customerCode = null;

    /** �z�X�g�c�Ɠ� */
    private String _eigyoBi = null;

    /** ���� */
    private String _termBegin = null;

    /** ���� */
    private String _termEnd = null;

    /**
     * ��ʑg�D�R�[�h���擾����
     * @return ��ʑg�D�R�[�h
     */
    public String getHigherOrganizationCode() {
        return _higherOrganizationCode;
    }

    /**
     * ��ʑg�D�R�[�h��ݒ肷��
     * @param higherOrganizationCode ��ʑg�D�R�[�h
     */
    public void setHigherOrganizationCode(String higherOrganizationCode) {
        this._higherOrganizationCode = higherOrganizationCode;
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
     * �E�ʃO���[�v�R�[�h�i�����j���擾����
     * @return �E�ʃO���[�v�R�[�h�i�����j
     */
    public String getGroupCd() {
        return _groupCd;
    }

    /**
     * �E�ʃO���[�v�R�[�h�i�����j��ݒ肷��
     * @param groupCd �E�ʃO���[�v�R�[�h�i�����j
     */
    public void setGroupCd(String groupCd) {
        this._groupCd = groupCd;
    }

    /**
     * �S���҃R�[�h���擾����
     * @return �S���҃R�[�h
     */
    public String getTntCd() {
        return _tntCd;
    }

    /**
     * �S���҃R�[�h��ݒ肷��
     * @param tntCd �S���҃R�[�h
     */
    public void setTntCd(String tntCd) {
        this._tntCd = tntCd;
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
     * ������擾����
     * @return ����
     */
    public String getTermBegin() {
        return _termBegin;
    }

    /**
     * �����ݒ肷��
     * @param termBegin ����
     */
    public void setTermBegin(String termBegin) {
        this._termBegin = termBegin;
    }

    /**
     * �������擾����
     * @return ����
     */
    public String getTermEnd() {
        return _termEnd;
    }

    /**
     * ������ݒ肷��
     * @param termEnd ����
     */
    public void setTermEnd(String termEnd) {
        this._termEnd = termEnd;
    }

}

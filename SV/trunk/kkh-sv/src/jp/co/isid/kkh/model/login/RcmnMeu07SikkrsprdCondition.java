package jp.co.isid.kkh.model.login;

import java.io.Serializable;

public class RcmnMeu07SikkrsprdCondition implements Serializable {

    private static final long serialVersionUID = 1L;

    /** ��ʑg�D�R�[�h */
    private String _higherOrganizationCode = null;

    /** �c�Ə��R�[�h */
    private String _egCd = null;

    /** �z�X�g�c�Ɠ� */
    private String _eigyoBi = null;

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
     * �c�Ə��R�[�h���擾����
     * @return �c�Ə��R�[�h
     */
    public String getEgCd() {
        return _egCd;
    }

    /**
     * �c�Ə��R�[�h��ݒ肷��
     * @param egCd �c�Ə��R�[�h
     */
    public void setEgCd(String egCd) {
        this._egCd = egCd;
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

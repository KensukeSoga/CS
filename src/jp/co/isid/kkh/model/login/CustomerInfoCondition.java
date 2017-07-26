package jp.co.isid.kkh.model.login;

import java.io.Serializable;

public class CustomerInfoCondition implements Serializable {

    private static final long serialVersionUID = 1L;

    /** ���O�C���S����ESQID */
    private String _esqId = null;

    /** ���Ӑ�R�[�h */
    private String _customerCode = null;

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

}

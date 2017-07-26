package jp.co.isid.kkh.model.login;

import java.io.Serializable;

public class LoginInitInfoCondition implements Serializable {

    private static final long serialVersionUID = 1L;

    /** ���O�C���S����ESQID */
    private String _esqId = null;

    /** �^�pNo. */
    private String _operationNo = null;

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

}

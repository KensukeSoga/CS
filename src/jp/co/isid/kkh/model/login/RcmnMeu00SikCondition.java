package jp.co.isid.kkh.model.login;

import java.io.Serializable;

public class RcmnMeu00SikCondition implements Serializable {

    private static final long serialVersionUID = 1L;

    /** �^�pNo. */
    private String _operationNo = null;

    /** �z�X�g�c�Ɠ� */
    private String _eigyoBi = null;

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

package jp.co.isid.kkh.model.common;

import java.io.Serializable;

public class EigyoBiCondition implements Serializable {

    private static final long serialVersionUID = 1L;

    /** ���O�C���S����ESQID */
    private String _esqId;

    /**
     * @return esqId
     */
    public String getEsqId() {
        return _esqId;
    }
    /**
     * @param esqId �Z�b�g���� esqId
     */
    public void setEsqId(String esqId) {
        this._esqId = esqId;
    }

}

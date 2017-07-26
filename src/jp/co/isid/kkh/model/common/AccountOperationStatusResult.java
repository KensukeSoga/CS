package jp.co.isid.kkh.model.common;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import jp.co.isid.kkh.model.AbstractServiceResult;

/**
 *
 * <P>
 * �Ɩ���v�ғ��󋵂�ێ�����B
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/02/09 JSE H.Abe)<BR>
 * </P>
 *
 * @author JSE H.Abe
 */
@XmlRootElement(namespace = "http://common.model.kkh.isid.co.jp/")
@XmlType(namespace = "http://common.model.kkh.isid.co.jp/")
public class AccountOperationStatusResult extends AbstractServiceResult {

    /** �Ɩ���v�ғ��� */
    private boolean _accountOperationStatus = false;

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

}

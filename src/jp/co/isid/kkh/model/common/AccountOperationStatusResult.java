package jp.co.isid.kkh.model.common;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import jp.co.isid.kkh.model.AbstractServiceResult;

/**
 *
 * <P>
 * 業務会計稼働状況を保持する。
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/02/09 JSE H.Abe)<BR>
 * </P>
 *
 * @author JSE H.Abe
 */
@XmlRootElement(namespace = "http://common.model.kkh.isid.co.jp/")
@XmlType(namespace = "http://common.model.kkh.isid.co.jp/")
public class AccountOperationStatusResult extends AbstractServiceResult {

    /** 業務会計稼働状況 */
    private boolean _accountOperationStatus = false;

    /**
     * 業務会計稼働状況を取得する
     * @return 業務会計稼働状況
     */
    @XmlElement(required = true)
    public boolean getAccountOperationStatus() {
        return _accountOperationStatus;
    }

    /**
     * 業務会計稼働状況を設定する
     * @param accountOperationStatus 業務会計稼働状況
     */
    public void setAccountOperationStatus(boolean accountOperationStatus) {
        this._accountOperationStatus = accountOperationStatus;
    }

}

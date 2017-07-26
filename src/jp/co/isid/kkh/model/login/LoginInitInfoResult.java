package jp.co.isid.kkh.model.login;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import jp.co.isid.kkh.model.AbstractServiceResult;

/**
*
* <P>
* ログイン初期情報を保持する。
* </P>
* <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/02/13 JSE H.Abe)<BR>
 * </P>
 * @author JSE H.Abe
*/
@XmlRootElement(namespace = "http://login.model.kkh.isid.co.jp/")
@XmlType(namespace = "http://login.model.kkh.isid.co.jp/")
public class LoginInitInfoResult extends AbstractServiceResult {

    /** ホスト営業日 */
    private String _eigyoBi = null;

    /** 業務会計稼働状況 */
    private boolean _accountOperationStatus = false;

    /** 担当者所属組織コード */
    private String _organizationCode = null;

    /**
     * ホスト営業日を取得する
     * @return ホスト営業日
     */
    public String getEigyoBi() {
        return _eigyoBi;
    }

    /**
     * ホスト営業日を設定する
     * @param eigyoBi ホスト営業日
     */
    public void setEigyoBi(String eigyoBi) {
        this._eigyoBi = eigyoBi;
    }

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

    /**
     * 担当者所属組織コードを取得する
     * @return 担当者所属組織コード
     */
    public String getOrganizationCode() {
        return _organizationCode;
    }

    /**
     * 担当者所属組織コードを設定する
     * @param organizationCode 担当者所属組織コード
     */
    public void setOrganizationCode(String organizationCode) {
        this._organizationCode = organizationCode;
    }

    /** ListだけではWebサービスに公開されないのでダミープロパティを追加 */
    private String _dummy;

    /**
     * ListだけではWebサービスに公開されないのでダミープロパティを追加を取得します。
     * @return String ダミープロパティ
     */
    public String getDummy() {
        return _dummy;
    }

    /**
     * ListだけではWebサービスに公開されないのでダミープロパティを追加を設定します。
     * @param dummy ダミープロパティ
     */
    public void setDummy(String dummy) {
        this._dummy = dummy;
    }

}

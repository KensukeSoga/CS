package jp.co.isid.kkh.model.login;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import jp.co.isid.kkh.model.AbstractServiceResult;

/**
*
* <P>
* 業務会計セキュリティロールを保持する。
* </P>
* <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/02/13 JSE H.Abe)<BR>
 * </P>
 * @author JSE H.Abe
*/
@XmlRootElement(namespace = "http://login.model.kkh.isid.co.jp/")
@XmlType(namespace = "http://login.model.kkh.isid.co.jp/")
public class AccountSecurityRoleResult extends AbstractServiceResult {

    /** 相対権限 */
    private String _relativeAuthority = null;

    /** セキュリティロール取得対象外フラグ */
    private boolean _notSecurityRoleFlag = false;

    /**
     * 相対権限を取得する
     * @return 相対権限
     */
    public String getRelativeAuthority() {
        return _relativeAuthority;
    }

    /**
     * 相対権限を設定する
     * @param relativeAuthority 相対権限
     */
    public void setRelativeAuthority(String relativeAuthority) {
        this._relativeAuthority = relativeAuthority;
    }

    /**
     * セキュリティロール取得対象外フラグを取得する
     * @return セキュリティロール取得対象外フラグ
     */
    @XmlElement(required = true)
    public boolean getNotSecurityRoleFlag() {
        return _notSecurityRoleFlag;
    }

    /**
     * セキュリティロール取得対象外フラグを設定する
     * @param notSecurityRoleFlag セキュリティロール取得対象外フラグ
     */
    public void setNotSecurityRoleFlag(boolean notSecurityRoleFlag) {
        this._notSecurityRoleFlag = notSecurityRoleFlag;
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

package jp.co.isid.kkh.model.login;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import jp.co.isid.kkh.model.AbstractServiceResult;

/**
*
* <P>
* ログイン情報を保持する。
* </P>
* <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/02/13 JSE H.Abe)<BR>
 * </P>
 * @author JSE H.Abe
*/
@XmlRootElement(namespace = "http://login.model.kkh.isid.co.jp/")
@XmlType(namespace = "http://login.model.kkh.isid.co.jp/")
public class LoginResult extends AbstractServiceResult {

    /** 営業所（取）コード */
    private String _egCd = null;

    /** ユーザー名 */
    private String _userName = null;

    /** ログイン得意先情報リスト */
    private List<LoginCustomerInfoVO> _loginCustomerInfoVOList = null;

    private String _SystemAdministerFlg = null;

    /**
     * 営業所（取）コードを取得する
     * @return 営業所（取）コード
     */
    public String getEgCd() {
        return _egCd;
    }

    /**
     * 営業所（取）コードを設定する
     * @param egCd 営業所（取）コード
     */
    public void setEgCd(String egCd) {
        this._egCd = egCd;
    }

    /**
     * ユーザー名を取得する
     * @return ユーザー名
     */
    public String getUserName() {
        return _userName;
    }

    /**
     * ユーザー名を設定する
     * @param userName ユーザー名
     */
    public void setUserName(String userName) {
        this._userName = userName;
    }

    /**
     * ログイン得意先情報リストを取得する
     * @return ログイン得意先情報リスト
     */
    public List<LoginCustomerInfoVO> getLoginCustomerInfoVOList() {
        return _loginCustomerInfoVOList;
    }

    /**
     * ログイン得意先情報リストを設定する
     * @param loginCustomerInfoVOList ログイン得意先情報リスト
     */
    public void setLoginCustomerInfoVOList(List<LoginCustomerInfoVO> loginCustomerInfoVOList) {
        this._loginCustomerInfoVOList = loginCustomerInfoVOList;
    }

    /**
     * システム管理者フラグ
     * @return システム管理者フラグ
     */
    public String get_SystemAdministerFlg() {
        return _SystemAdministerFlg;
    }

    /**
     * システム管理者フラグ
     * @param _SystemAdministerFlg
     */
    public void set_SystemAdministerFlg(String SystemAdministerFlg) {
        this._SystemAdministerFlg = SystemAdministerFlg;
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

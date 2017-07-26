package jp.co.isid.kkh.model.login;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import jp.co.isid.kkh.model.AbstractServiceResult;

/**
*
* <P>
* 得意先情報を保持する。
* </P>
* <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/02/13 JSE H.Abe)<BR>
 * </P>
 * @author JSE H.Abe
*/
@XmlRootElement(namespace = "http://login.model.kkh.isid.co.jp/")
@XmlType(namespace = "http://login.model.kkh.isid.co.jp/")
public class CustomerInfoResult extends AbstractServiceResult {

    /** 得意先名称 */
    private String _customerName = null;

    /**
     * 得意先名称を取得する
     * @return 得意先名称
     */
    public String getCustomerName() {
        return _customerName;
    }

    /**
     * 得意先名称を設定する
     * @param customerName 得意先名称
     */
    public void setCustomerName(String customerName) {
        this._customerName = customerName;
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

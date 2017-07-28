package jp.co.isid.kkh.model.login;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import jp.co.isid.kkh.model.AbstractServiceResult;

/**
*
* <P>
* 開放得意先情報を保持する。
* </P>
* <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/02/13 JSE H.Abe)<BR>
 * </P>
 * @author JSE H.Abe
*/
@XmlRootElement(namespace = "http://login.model.kkh.isid.co.jp/")
@XmlType(namespace = "http://login.model.kkh.isid.co.jp/")
public class OpenCustomerInfoResult extends AbstractServiceResult {

    /** 画面表示フラグ */
    private String _disFlg = null;

    /**
     * 画面表示フラグを取得する
     * @return 画面表示フラグ
     */
    public String getDisFlg() {
        return _disFlg;
    }

    /**
     * 画面表示フラグを設定する
     * @param disFlg 画面表示フラグ
     */
    public void setDisFlg(String disFlg) {
        this._disFlg = disFlg;
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

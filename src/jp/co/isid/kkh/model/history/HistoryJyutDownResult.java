package jp.co.isid.kkh.model.history;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import jp.co.isid.kkh.model.AbstractServiceResult;


/**
*
* <P>
* Lionデータを保持する。
* </P>
* <P>
* <B>修正履歴</B><BR>
* ・新規作成(2011/2/1 fourm h.izawa)<BR>
* </P>
* @author HLC K.Honma
*/
@XmlRootElement(namespace = "http://history.model.lion.customer.kkh.isid.co.jp/")
@XmlType(namespace = "http://history.model.lion.customer.kkh.isid.co.jp/")
public class HistoryJyutDownResult extends AbstractServiceResult {
	/** マスタ種類設定VOリスト */
	private List<HistoryJyutDownVO> _Rep;

	/**
	 * マスタ項目設定VOリストを取得します。
	 * @return _masterItem
	 */
	public List<HistoryJyutDownVO> getReportAsh() {
		return _Rep;
	}

	/**
	 * マスタ項目設定VOリストを設定します。
	 * @param masterItem セットする _masterItem
	 */
	public void setReportAsh(List<HistoryJyutDownVO> rep) {
		_Rep = rep;
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

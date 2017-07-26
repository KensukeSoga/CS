package jp.co.isid.kkh.customer.tkd.model.detail;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import jp.co.isid.kkh.model.AbstractServiceResult;
import jp.co.isid.kkh.model.detail.Thb2KmeiVO;

/**
*
* <P>
* 実施No自動付与の結果を保持する。
* </P>
* <P>
* <B>修正履歴</B><BR>
* ・新規作成(2011/12/6 H.izawa)<BR>
* </P>
* @author
*/
@XmlRootElement(namespace = "http://detail.model.tkd.customer.kkh.isid.co.jp/")
@XmlType(namespace = "http://detail.model.tkd.customer.kkh.isid.co.jp/")
public class FindThb2KmeiBycondResult extends AbstractServiceResult {

	/** 広告費明細テーブル(THB2KMEI)VOリスト */
	private List<Thb2KmeiVO> _thb2KmeiList;


	/**
	 * 広告費明細テーブル(THB2KMEI)VOリストを設定します。
	 * @param thb2KmeiList
	 */
	public List<Thb2KmeiVO> get_thb2KmeiList() {
		return _thb2KmeiList;
	}

	/**
	 * 広告費明細テーブル(THB2KMEI)VOリストを設定します。
	 * @param thb2KmeiList
	 */
	public void set_thb2KmeiList(List<Thb2KmeiVO> thb2KmeiList) {
		_thb2KmeiList = thb2KmeiList;
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

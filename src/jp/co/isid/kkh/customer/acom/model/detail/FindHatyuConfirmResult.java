package jp.co.isid.kkh.customer.acom.model.detail;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import jp.co.isid.kkh.model.AbstractServiceResult;

/**
*
* <P>
* 実施No自動付与の結果を保持する。
* </P>
* <P>
* <B>修正履歴</B><BR>
* ・新規作成(2011/12/22 H.izawa)<BR>
* </P>
* @author
*/
@XmlRootElement(namespace = "http://detail.model.kkh.isid.co.jp/")
@XmlType(namespace = "http://detail.model.kkh.isid.co.jp/")
public class FindHatyuConfirmResult extends AbstractServiceResult {

    /** 広告費明細テーブル(Thb5Hik)VOリスト */
    private List<HikVO> _thb5HikList;

    /**
     * 広告費明細テーブル(Thb5Hik)VOリストを設定します。
     * @param thb5HikList
     */
    public List<HikVO> get_thb5HikList() {
        return _thb5HikList;
    }

    /**
     * 広告費明細テーブル(Thb5Hik)VOリストを設定します。
     * @param thb5HikList
     */
    public void set_thb5HikList(List<HikVO> thb5HikList) {
        _thb5HikList = thb5HikList;
    }

    //	/**
//	 * 広告費明細テーブル(Thb5Hik)VOリストを設定します。
//	 * @param thb5HikList
//	 */
//	public List<Thb5HikVO> get_thb5HikList() {
//		return _thb5HikList;
//	}
//
//	/**
//	 * 広告費明細テーブル(THB2KMEI)VOリストを設定します。
//	 * @param thb2KmeiList
//	 */
//	public void set_thb5HikList(List<Thb2KmeiVO> thb2KmeiList) {
//		_thb2KmeiList = thb2KmeiList;
//	}
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

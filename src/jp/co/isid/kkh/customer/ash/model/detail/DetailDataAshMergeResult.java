package jp.co.isid.kkh.customer.ash.model.detail;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import jp.co.isid.kkh.model.AbstractServiceResult;
import jp.co.isid.kkh.model.detail.Thb1DownVO;
import jp.co.isid.kkh.model.detail.Thb2KmeiVO;

/**
*
* <P>
* 受注統合の処理結果を保持する。
* </P>
* <P>
* <B>修正履歴</B><BR>
* ・新規作成(2011/12/05 JSE K.Fukuda)<BR>
* </P>
* @author
*/
@XmlRootElement(namespace = "http://detail.model.ash.customer.kkh.isid.co.jp/")
@XmlType(namespace = "http://detail.model.ash.customer.kkh.isid.co.jp/")
public class DetailDataAshMergeResult extends AbstractServiceResult {

	/** ダウンロードテーブル */
	private List<Thb1DownVO> _thb1DownList = null;

	/** 明細テーブル */
	private List<Thb2KmeiVO> _thb2KmeiList = null;

	/** ダミープロパティ */
	private String _dummy = null;

	/**
	 * ダウンロードテーブルを取得する
	 * @return ダウンロードテーブル
	 */
	public List<Thb1DownVO> getThb1DownList() {
	    return _thb1DownList;
	}

	/**
	 * ダウンロードテーブルを設定する
	 * @param thb1Down ダウンロードテーブル
	 */
	public void setThb1DownList(List<Thb1DownVO> thb1DownList) {
	    this._thb1DownList = thb1DownList;
	}

	/**
	 * 明細テーブルを取得する
	 * @return 明細テーブル
	 */
	public List<Thb2KmeiVO> getThb2KmeiList() {
	    return _thb2KmeiList;
	}

	/**
	 * 明細テーブルを設定する
	 * @param thb2Kmei 明細テーブル
	 */
	public void setThb2KmeiList(List<Thb2KmeiVO> thb2KmeiList) {
	    this._thb2KmeiList = thb2KmeiList;
	}

	/**
	 * ダミープロパティを取得する
	 * @return ダミープロパティ
	 */
	public String getDummy() {
	    return _dummy;
	}

	/**
	 * ダミープロパティを設定する
	 * @param dummy ダミープロパティ
	 */
	public void setDummy(String dummy) {
	    this._dummy = dummy;
	}
}

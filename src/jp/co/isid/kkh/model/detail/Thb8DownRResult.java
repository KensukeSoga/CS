package jp.co.isid.kkh.model.detail;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import jp.co.isid.kkh.model.AbstractServiceResult;

/**
*
* <P>
* 受注ダウンロード履歴データ検索結果を保持する。
* </P>
* <P>
* <B>修正履歴</B><BR>
* ・新規作成(2011/11/24 JSE K.Fukuda)<BR>
* </P>
* @author
*/
@XmlRootElement(namespace = "http://detail.model.kkh.isid.co.jp/")
@XmlType(namespace = "http://detail.model.kkh.isid.co.jp/")
public class Thb8DownRResult extends AbstractServiceResult {

	/** 受注ダウンロード履歴テーブル(THB8DOWNR)VOリスト */
	private List<Thb8DownRVO> _thb8DownRList;

	/**
	 * 受注ダウンロード履歴テーブル(THB8DOWNR)VOリストを取得します。
	 * @return _thb2KmeiList
	 */
	public List<Thb8DownRVO> getThb8DownRList() {
		return _thb8DownRList;
	}

	/**
	 * 受注ダウンロード履歴テーブル(THB8DOWNR)VOリストを設定します。
	 * @param thb8DownRList
	 */
	public void setThb8DownRList(List<Thb8DownRVO> thb8DownRList) {
		_thb8DownRList = thb8DownRList;
	}

}

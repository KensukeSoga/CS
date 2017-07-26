package jp.co.isid.kkh.model.detail;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import jp.co.isid.kkh.model.AbstractServiceResult;

/**
*
* <P>
* 表示データ登録結果を保持する。
* </P>
* <P>
* <B>修正履歴</B><BR>
* ・新規作成(2011/11/04 JSE K.Fukuda)<BR>
* </P>
* @author
*/
@XmlRootElement(namespace = "http://detail.model.kkh.isid.co.jp/")
@XmlType(namespace = "http://detail.model.kkh.isid.co.jp/")
public class DetailUpdateDataResult extends AbstractServiceResult {
	/** ダウンロードテーブル */
	private Thb1DownVO _thb1Down = null;

	/** 広告費明細テーブルリスト */
	private List<Thb2KmeiVO> _thb2Kmei = null;

	/**
	 * ダウンロードテーブルを取得する
	 * @return ダウンロードテーブル
	 */
	public Thb1DownVO getThb1Down() {
	    return _thb1Down;
	}

	/**
	 * ダウンロードテーブルを設定する
	 * @param thb1Down ダウンロードテーブル
	 */
	public void setThb1Down(Thb1DownVO thb1Down) {
	    this._thb1Down = thb1Down;
	}

	/**
	 * 広告費明細テーブルリストを取得する
	 * @return 広告費明細テーブルリスト
	 */
	public List<Thb2KmeiVO> getThb2Kmei() {
	    return _thb2Kmei;
	}

	/**
	 * 広告費明細テーブルリストを設定する
	 * @param thb2Kmei 広告費明細テーブルリスト
	 */
	public void setThb2Kmei(List<Thb2KmeiVO> thb2Kmei) {
	    this._thb2Kmei = thb2Kmei;
	}
}

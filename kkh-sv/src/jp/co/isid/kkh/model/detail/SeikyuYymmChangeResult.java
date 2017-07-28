package jp.co.isid.kkh.model.detail;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import jp.co.isid.kkh.model.AbstractServiceResult;

/**
*
* <P>
* 請求年月変更の処理結果を保持する。
* </P>
* <P>
* <B>修正履歴</B><BR>
* ・新規作成(2011/12/05 JSE K.Fukuda)<BR>
* </P>
* @author
*/
@XmlRootElement(namespace = "http://detail.model.kkh.isid.co.jp/")
@XmlType(namespace = "http://detail.model.kkh.isid.co.jp/")
public class SeikyuYymmChangeResult extends AbstractServiceResult {
	/** ダウンロードテーブル */
	private List<Thb1DownVO> _thb1DownList = null;

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
}

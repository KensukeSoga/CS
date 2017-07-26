package jp.co.isid.kkh.customer.epson.model.detail;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import jp.co.isid.kkh.model.AbstractServiceResult;
import jp.co.isid.kkh.customer.epson.model.detail.Thb14skdownVO;

/**
*
* <P>
* 請求回収データ検索結果を保持する。
* </P>
* <P>
* <B>修正履歴</B><BR>
* ・新規作成(2012/04/25 JSE.Yuguchi)<BR>
* </P>
* @author
*/
@XmlRootElement(namespace = "http://detail.model.epson.kkh.isid.co.jp/")
@XmlType(namespace = "http://detail.model.epson.kkh.isid.co.jp/")
public class SeikyuDataEpsonResult extends AbstractServiceResult {


	/** 請求回収データVOリスト */
	private List<Thb14skdownVO> _seikyuData;


	/**
	 * 請求回収ダウンロードテーブル(Thb14skdown)VOリストを取得します。
	 * @return _Thb14skdownList
	 */
	public List<Thb14skdownVO> getSeikyuData() {
		return _seikyuData;
	}

	/**
	 * 請求回収ダウンロードテーブル(Thb14skdown)VOリストを設定します。
	 * @param Thb14skdownList
	 */
	public void setSeikyuData(List<Thb14skdownVO> seikyuData) {
		_seikyuData = seikyuData;
	}

}

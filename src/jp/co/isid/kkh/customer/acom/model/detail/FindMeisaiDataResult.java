package jp.co.isid.kkh.customer.acom.model.detail;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import jp.co.isid.kkh.model.AbstractServiceResult;
import jp.co.isid.kkh.model.detail.Thb2KmeiVO;

/**
*
* <P>
* 広告費明細データ検索結果を保持する。
* </P>
* <P>
* <B>修正履歴</B><BR>
* ・新規作成(2011/11/24 JSE K.Fukuda)<BR>
* </P>
* @author
*/
@XmlRootElement(namespace = "http://detail.model.kkh.isid.co.jp/")
@XmlType(namespace = "http://detail.model.kkh.isid.co.jp/")
public class FindMeisaiDataResult extends AbstractServiceResult {

	/** 広告費明細テーブル(THB2KMEI)VOリスト */
	private List<Thb2KmeiVO> _thb2KmeiList;

	/**
	 * 広告費明細テーブル(THB2KMEI)VOリストを取得します。
	 * @return _thb2KmeiList
	 */
	public List<Thb2KmeiVO> getThb2KmeiList() {
		return _thb2KmeiList;
	}

	/**
	 * 広告費明細テーブル(THB2KMEI)VOリストを設定します。
	 * @param thb2KmeiList
	 */
	public void setThb2KmeiList(List<Thb2KmeiVO> thb2KmeiList) {
		_thb2KmeiList = thb2KmeiList;
	}

}

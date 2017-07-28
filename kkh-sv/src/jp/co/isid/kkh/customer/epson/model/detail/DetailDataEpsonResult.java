package jp.co.isid.kkh.customer.epson.model.detail;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import jp.co.isid.kkh.model.AbstractServiceResult;

/**
*
* <P>
* 広告費明細データ検索結果を保持する。
* </P>
* <P>
* <B>修正履歴</B><BR>
* ・新規作成(2012/3/5 IP.Shimizu)<BR>
* </P>
* @author
*/
@XmlRootElement(namespace = "http://detail.model.epson.kkh.isid.co.jp/")
@XmlType(namespace = "http://detail.model.epson.kkh.isid.co.jp/")
public class DetailDataEpsonResult extends AbstractServiceResult {

	/** 対象媒体コード */
	private String _targetBaitaiCd;

	/** 広告費明細データVOリスト */
	private List<DetailDataFindEpsonVO> _detailData;

	/**
	 * 対象媒体コードを取得します。
	 * @return
	 */
	public String getTargetBaitaiCd() {
		return _targetBaitaiCd;
	}

	/**
	 * 対象媒体コードを設定します。
	 * @param targetBaitaiCd
	 */
	public void setTargetBaitaiCd(String targetBaitaiCd) {
		this._targetBaitaiCd = targetBaitaiCd;
	}

	/**
	 * 広告費明細テーブル(THB2KMEI)VOリストを取得します。
	 * @return _thb2KmeiList
	 */
	public List<DetailDataFindEpsonVO> getDetailData() {
		return _detailData;
	}

	/**
	 * 広告費明細テーブル(THB2KMEI)VOリストを設定します。
	 * @param thb2KmeiList
	 */
	public void setDetailData(List<DetailDataFindEpsonVO> detailData) {
		_detailData = detailData;
	}

}

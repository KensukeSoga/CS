package jp.co.isid.kkh.customer.lion.model.detail;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import jp.co.isid.kkh.customer.lion.model.detail.FindLionTVSpotVO;
import jp.co.isid.kkh.model.AbstractServiceResult;

/**
 * <P>
 * ライオンTVSpotデータ取得結果
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/03/05 JSE Hitoshi Sasaki)<BR>
 * </P>
 *
 * @author JSE Hitoshi Sasaki
 */
@XmlRootElement(namespace = "http://detail.model.lion.customer.kkh.isid.co.jp/")
@XmlType(namespace = "http://detail.model.lion.customer.kkh.isid.co.jp/")
public class FindLionTVSpotResult extends AbstractServiceResult {

	/** ライオンTVSpotデータ取得VOリスト */
	private List<FindLionTVSpotVO> _Rep;

	/**
	 * ライオンTVSpotデータ取得VOリストを取得します。
	 *
	 * @return _masterItem
	 */
	public List<FindLionTVSpotVO> getFindLionTVSpot() {
		return _Rep;
	}

	/**
	 * ライオンTVSpotデータ取得VOリストを設定します。
	 *
	 * @param masterItem
	 *            セットする _masterItem
	 */
	public void setFindLionTVSpot(List<FindLionTVSpotVO> rep) {
		_Rep = rep;
	}

	/** ListだけではWebサービスに公開されないのでダミープロパティを追加 */
	private String _dummy;

	/**
	 * ListだけではWebサービスに公開されないのでダミープロパティを追加を取得します。
	 *
	 * @return String ダミープロパティ
	 */
	public String getDummy() {
		return _dummy;
	}

	/**
	 * ListだけではWebサービスに公開されないのでダミープロパティを追加を設定します。
	 *
	 * @param dummy
	 *            ダミープロパティ
	 */
	public void setDummy(String dummy) {
		this._dummy = dummy;
	}
}

package jp.co.isid.kkh.customer.tkd.model.report;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import jp.co.isid.kkh.model.AbstractServiceResult;

/**
 * <P>
 * 武田請求明細（品目別）取得結果
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/01/23 JSE Hitoshi Sasaki)<BR>
 * </P>
 *
 * @author JSE Hitoshi Sasaki
 */

@XmlRootElement(namespace = "http://report.model.tkd.customer.kkh.isid.co.jp/")
@XmlType(namespace = "http://report.model.tkd.customer.kkh.isid.co.jp/")
public class ReportTkdBillingByItemResult extends AbstractServiceResult {
	/** マスタ種類設定VOリスト */
	private List<ReportTkdBillingByItemVO> _Rep;

	/**
	 * マスタ項目設定VOリストを取得します。
	 *
	 * @return _masterItem
	 */
	public List<ReportTkdBillingByItemVO> getReportTkdBilling() {
		return _Rep;
	}

	/**
	 * マスタ項目設定VOリストを設定します。
	 *
	 * @param masterItem
	 *            セットする _masterItem
	 */
	public void setReportTkdBilling(List<ReportTkdBillingByItemVO> rep) {
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

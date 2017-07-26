package jp.co.isid.kkh.customer.mac.model.report;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import jp.co.isid.kkh.model.AbstractServiceResult;


/**
*
* <P>
* MACデータを保持する。
* </P>
* <P>
* <B>修正履歴</B><BR>
* ・新規作成(2011/11/04 JSE KT)<BR>
* </P>
* @author HLC K.Honma
*/
@XmlRootElement(namespace = "http://report.model.mac.customer.kkh.isid.co.jp/")
@XmlType(namespace = "http://report.model.mac.customer.kkh.isid.co.jp/")
public class ReportMacRequestResult extends AbstractServiceResult {
	/** マスタ種類設定VOリスト */
	private List<ReportMacRequestVO> _Rep;

	/**
	 * マスタ項目設定VOリストを取得します。
	 * @return _masterItem
	 */
	public List<ReportMacRequestVO> getReportMacRequest() {
		return _Rep;
	}

	/**
	 * マスタ項目設定VOリストを設定します。
	 * @param masterItem セットする _masterItem
	 */
	public void setReportMacRequest(List<ReportMacRequestVO> rep) {
		_Rep = rep;
	}


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

package jp.co.isid.kkh.customer.ash.model.report;

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
* ・新規作成(2011/1/20 fourm h.izawa)<BR>
* </P>
* @author HLC K.Honma
*/
@XmlRootElement(namespace = "http://report.model.ash.customer.kkh.isid.co.jp/")
@XmlType(namespace = "http://report.model.ash.customer.kkh.isid.co.jp/")
public class ReportAshMediaResult extends AbstractServiceResult {
	/** マスタ種類設定VOリスト */
	private List<ReportAshMediaVO> _Rep;

    /** マスタ種類設定VOリスト */
    private List<ReportAshMediaVO> _RepB;

	/**
	 * マスタ項目設定VOリストを取得します。
	 * @return _masterItem
	 */
	public List<ReportAshMediaVO> getReportAsh() {
		return _Rep;
	}

	/**
	 * マスタ項目設定VOリストを設定します。
	 * @param masterItem セットする _masterItem
	 */
	public void setReportAsh(List<ReportAshMediaVO> rep) {
		_Rep = rep;
	}

    /**
     * 画面表示用VOリストを取得
     * @return _masterItem
     */
    public List<ReportAshMediaVO> getReportAshALL() {
        return _RepB;
    }

    /**
     * 画面表示用VOリストを設定
     * @param masterItem セットする _masterItem
     */
    public void setReportAshALL(List<ReportAshMediaVO> repB) {
        _RepB = repB;
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

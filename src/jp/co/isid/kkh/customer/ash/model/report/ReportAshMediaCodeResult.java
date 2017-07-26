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
public class ReportAshMediaCodeResult extends AbstractServiceResult {
	/** マスタ種類設定VOリスト */
	private List<ReportAshMediaCodeVO> _Rep;
	private List<ReportAshMediaCodeVO> _Rep1;
	private List<ReportAshOldKyokuVO>  _Rep2;
	private List<ReportAshBangumiDataVO> _Rep3;


	public List<ReportAshBangumiDataVO> getReportAshBangumiData() {
		return _Rep3;
	}

	public void setReportAshBangumiData(List<ReportAshBangumiDataVO> rep3) {
		_Rep3 = rep3;
	}

	public List<ReportAshOldKyokuVO> getReportAshOldKyoku() {
		return _Rep2;
	}

	public void setReportAshOldKyoku(List<ReportAshOldKyokuVO> rep2) {
		_Rep2 = rep2;
	}

	/**
	 * マスタ項目設定VOリストを取得します。
	 * @return _masterItem
	 */
	public List<ReportAshMediaCodeVO> getReportAshCode() {
		return _Rep;
	}

	/**
	 * マスタ項目設定VOリストを設定します。
	 * @param masterItem セットする _masterItem
	 */
	public void setReportAshCode(List<ReportAshMediaCodeVO> rep) {
		_Rep = rep;
	}
	/**
	 *商品コードのVOリストを取得
	 * @return
	 */
	public List<ReportAshMediaCodeVO> getSyohinCode() {
		return _Rep1;
	}
	/**
	 * 商品コードのVOリストを設定
	 * @param rep
	 */
	public void setSyohinCode(List<ReportAshMediaCodeVO> rep1) {
		_Rep1 = rep1;
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

package jp.co.isid.kkh.customer.lion.model.report;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import jp.co.isid.kkh.customer.lion.model.report.ReportLionVO;
import jp.co.isid.kkh.model.AbstractServiceResult;

/**
*
* <P>
* アコムデータを保持する。
* </P>
* <P>
* <B>修正履歴</B><BR>
* ・新規作成(2012/01/11)<BR>
* </P>
* @author
*/
@XmlRootElement(namespace = "http://report.model.lion.customer.kkh.isid.co.jp/")
@XmlType(namespace = "http://report.model.lion.customer.kkh.isid.co.jp/")
public class ReportLionResult extends AbstractServiceResult{

	/** マスタ種類設定VOリスト */
	private List<ReportLionVO> _Rep;

	private List<ReportLionVO> _Rep1;

	private List<ReportLionVO> _Rep2;
	/**
	 * マスタ項目設定VOリストを取得します。
	 * @return _masterItem
	 */
	public List<ReportLionVO> getReportLion() {
		return _Rep;
	}

	/**
	 * マスタ項目設定VOリストを設定します。
	 * @param masterItem セットする _masterItem
	 */
	public void setReportLion(List<ReportLionVO> rep) {
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

    /**
     * 全媒体の消費税を取得
     * @return
     */
	public List<ReportLionVO> getReportLionSyohiZei() {
		return _Rep1;
	}

	/**
	 * 全媒体の消費税を設定
	 * @param rep1
	 */
	public void setReportLionSyohiZei(List<ReportLionVO> rep1) {
		_Rep1 = rep1;
	}


	public List<ReportLionVO> getBaitaiCdName() {
		return _Rep2;
	}

	public void setBaitaiCdName(List<ReportLionVO> rep2) {
		_Rep2 = rep2;
	}

}

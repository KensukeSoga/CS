package jp.co.isid.kkh.customer.lion.model.report;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import jp.co.isid.kkh.customer.lion.model.report.DetailListLionVO;
import jp.co.isid.kkh.model.AbstractServiceResult;

/**
*
* <P>
* ライオンデータを保持する。
* </P>
* <P>
* <B>修正履歴</B><BR>
* ・新規作成(2013/02/07)<BR>
* </P>
* @author
*/
@XmlRootElement(namespace = "http://report.model.lion.customer.kkh.isid.co.jp/")
@XmlType(namespace = "http://report.model.lion.customer.kkh.isid.co.jp/")
public class DetailListLionResult extends AbstractServiceResult{

	/** 明細一覧VOリスト */
	private List<DetailListLionVO> _Rep;

	private List<DetailListLionVO> _Rep1;

	private List<DetailListLionVO> _Rep2;

	/**
	 * 明細一覧VOリストを取得します。
	 * @return _Rep
	 */
	public List<DetailListLionVO> getDetailListLion() {
		return _Rep;
	}

	/**
	 * 明細一覧VOリストを設定します。
	 * @param rep セットする _Rep
	 */
	public void setDetailListLion(List<DetailListLionVO> rep) {
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
     * @return _Rep
     */
	public List<DetailListLionVO> getDetailListLionSyohiZei() {
		return _Rep1;
	}

	/**
	 * 全媒体の消費税を設定
     * @param rep セットする _Rep
	 */
	public void setDetailListLionSyohiZei(List<DetailListLionVO> rep1) {
		_Rep1 = rep1;
	}




	public List<DetailListLionVO> getBaitaiCdName() {
		return _Rep2;
	}

	public void setBaitaiCdName(List<DetailListLionVO> rep2) {
		_Rep2 = rep2;
	}

}

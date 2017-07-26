package jp.co.isid.kkh.model.detail;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import jp.co.isid.kkh.model.AbstractServiceResult;

/**
*
* <P>
* 受注データを保持する。
* </P>
* <P>
* <B>修正履歴</B><BR>
* ・新規作成(2011/11/04 JSE K.Fukuda)<BR>
* </P>
* @author
*/
@XmlRootElement(namespace = "http://detail.model.kkh.isid.co.jp/")
@XmlType(namespace = "http://detail.model.kkh.isid.co.jp/")
public class JyutyuDataCondResult extends AbstractServiceResult {
	/** 受注データVOリスト */
	private List<JyutyuDataVO> _jutyuData;


	/**
	 * 受注データVOリストを取得します。
	 * @return _jutyuData
	 */
	public List<JyutyuDataVO> getJutyuData() {
		return _jutyuData;
	}

	/**
	 * 受注データVOリストを設定します。
	 * @param jutyuData
	 */
	public void setJutyuData(List<JyutyuDataVO> jutyuData) {
		_jutyuData = jutyuData;
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

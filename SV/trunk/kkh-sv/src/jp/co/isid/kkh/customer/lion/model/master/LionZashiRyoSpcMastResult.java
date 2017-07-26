package jp.co.isid.kkh.customer.lion.model.master;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import jp.co.isid.kkh.model.AbstractServiceResult;


/**
*
* <P>
* 雑誌料金スペースデータを保持する。
* </P>
* <P>
* <B>修正履歴</B><BR>
* ・新規作成(2012/03/02 JSE A.Naito)<BR>
* </P>
* @author JSE A.Naito
*/
@XmlRootElement(namespace = "http://master.model.lion.customer.kkh.isid.co.jp/")
@XmlType(namespace = "http://master.model.lion.customer.kkh.isid.co.jp/")
public class LionZashiRyoSpcMastResult extends AbstractServiceResult {
	/** マスタ種類設定VOリスト */
	private List<LionZashiRyoSpcMastVO> _Rep;

	/**
	 * マスタ項目設定VOリストを取得します。
	 * @return _masterItem
	 */
	public List<LionZashiRyoSpcMastVO> getLionZashiRyoSpcMast() {
		return _Rep;
	}

	/**
	 * マスタ項目設定VOリストを設定します。
	 * @param masterItem セットする _masterItem
	 */
	public void setLionZashiRyoSpcMast(List<LionZashiRyoSpcMastVO> rep) {
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

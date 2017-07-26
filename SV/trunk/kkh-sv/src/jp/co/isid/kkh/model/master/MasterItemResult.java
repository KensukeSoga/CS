package jp.co.isid.kkh.model.master;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import jp.co.isid.kkh.model.AbstractServiceResult;

/**
*
* <P>
* 汎用マスタデータを保持する。
* </P>
* <P>
* <B>修正履歴</B><BR>
* ・新規作成(2012/2/03 Fourm H.izawa)<BR>
* </P>
* @author HLC K.Honma
*/
@XmlRootElement(namespace = "http://master.model.kkh.isid.co.jp/")
@XmlType(namespace = "http://master.model.kkh.isid.co.jp/")
public class MasterItemResult extends AbstractServiceResult {


	/** マスタ項目VOリスト */
	private List<MasterVO> _masterItem;


	/**
	 * マスタ項目設定VOリストを取得します。
	 * @return _masterItem
	 */
	public List<MasterVO> getMasterItem() {
		return _masterItem;
	}

	/**
	 * マスタ項目設定VOリストを設定します。
	 * @param masterItem セットする _masterItem
	 */
	public void setMasterItem(List<MasterVO> masterItem) {
		_masterItem = masterItem;
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

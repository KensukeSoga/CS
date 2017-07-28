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
* ・新規作成(2011/11/04 JSE K.Fukuda)<BR>
* </P>
* @author HLC K.Honma
*/
@XmlRootElement(namespace = "http://master.model.kkh.isid.co.jp/")
@XmlType(namespace = "http://master.model.kkh.isid.co.jp/")
public class MasterResult extends AbstractServiceResult {
	/** マスタ種類設定VOリスト */
	private List<MasterVO> _masterKind;

	/** マスタ項目VOリスト */
	private List<MasterVO> _masterItem;

	/** マスタデータVOリスト */
	private List<MasterDataVO> _masterData;

	/**
	 * マスタ種類設定VOリストを取得します。
	 * @return _masterKind
	 */
	public List<MasterVO> getMasterKind() {
		return _masterKind;
	}

	/**
	 * マスタ種類設定VOリストを設定します。
	 * @param masterKind セットする _masterKind
	 */
	public void setMasterKind(List<MasterVO> masterKind) {
		_masterKind = masterKind;
	}

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

	/**
	 * マスタデータVOリストを取得します。
	 * @return _masterData
	 */
	public List<MasterDataVO> getMasterData() {
		return _masterData;
	}

	/**
	 * マスタデータVOリストを設定します。
	 * @param masterData セットする _masterData
	 */
	public void setMasterData(List<MasterDataVO> masterData) {
		_masterData = masterData;
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

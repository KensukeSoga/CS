package jp.co.isid.kkh.model.common;

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
@XmlRootElement(namespace = "http://common.model.kkh.isid.co.jp/")
@XmlType(namespace = "http://common.model.kkh.isid.co.jp/")
public class CommonCodeMasterResult extends AbstractServiceResult {
	/** CommonCodeMasterVOリスト */
	private List<CommonCodeMasterVO> _rcmnMeu29CC;

	/**
	 * マスタ種類設定VOリストを取得します。
	 * @return _masterKind
	 */
	public List<CommonCodeMasterVO> getCommonCodeMaster() {
		return _rcmnMeu29CC;
	}

	/**
	 * マスタ種類設定VOリストを設定します。
	 * @param masterKind セットする _masterKind
	 */
	public void setCommonCodeMaster(List<CommonCodeMasterVO> rcmnMeu29CC) {
		_rcmnMeu29CC = rcmnMeu29CC;
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

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
* ・新規作成(2011/11/11 IP H.Shimizu)<BR>
* </P>
* @author IP H.Shimizu
*/
@XmlRootElement(namespace = "http://common.model.kkh.isid.co.jp/")
@XmlType(namespace = "http://common.model.kkh.isid.co.jp/")
public class CommonResult extends AbstractServiceResult {
	/** マスタ種類設定VOリスト */
	private List<CommonVO> _common;

	/**
	 * マスタ項目設定VOリストを取得します。
	 * @return _masterItem
	 */
	public List<CommonVO> getCommon() {
		return _common;
	}

	/**
	 * マスタ項目設定VOリストを設定します。
	 * @param masterItem セットする _masterItem
	 */
	public void setCommon(List<CommonVO> common) {
		_common = common;
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

package jp.co.isid.kkh.customer.lion.model.detail;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import jp.co.isid.kkh.model.AbstractServiceResult;


/**
*
* <P>
* データを保持する。
* </P>
* <P>
* <B>修正履歴</B><BR>
* ・新規作成(2012/02/17 JSE A.Naito)<BR>
* </P>
* @author JSE A.Naito
*/
@XmlRootElement(namespace = "http://detail.model.lion.customer.kkh.isid.co.jp/")
@XmlType(namespace = "http://detail.model.lion.customer.kkh.isid.co.jp/")
public class FindLionCardNoGetResult extends AbstractServiceResult {
	/** マスタ種類設定VOリスト */
	private List<FindLionCardNoGetVO> _Rep;

	/**
	 * マスタ項目設定VOリストを取得します。
	 * @return _masterItem
	 */
	public List<FindLionCardNoGetVO> getFindLionCardNoGet() {
		return _Rep;
	}

	/**
	 * マスタ項目設定VOリストを設定します。
	 * @param masterItem セットする _masterItem
	 */
	public void setFindLionCardNoGet(List<FindLionCardNoGetVO> rep) {
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

package jp.co.isid.kkh.customer.lion.model.detail;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import jp.co.isid.kkh.model.AbstractServiceResult;
import jp.co.isid.kkh.model.detail.Thb1DownVO;

/**
 * @param args
 */
@XmlRootElement(namespace = "http://detail.model.lion.customer.kkh.isid.co.jp/")
@XmlType(namespace = "http://detail.model.lion.customer.kkh.isid.co.jp/")
public class UpdateSubjectResult extends AbstractServiceResult {

	/** 広告費明細テーブル(Thb1Down)VOリスト */
	private List<Thb1DownVO> _thb1DownList;


	/**
	 * 広告費明細テーブル(Thb1Down)VOリストを設定します。
	 * @param thb2KmeiList
	 */
	public List<Thb1DownVO> get_thb1DownList() {
		return _thb1DownList;
	}

	/**
	 * 広告費明細テーブル(Thb1Down)VOリストを設定します。
	 * @param thb2KmeiList
	 */
	public void set_thb1DownList(List<Thb1DownVO> thb1DownList) {
		_thb1DownList = thb1DownList;
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
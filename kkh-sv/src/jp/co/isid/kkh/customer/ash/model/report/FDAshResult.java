package jp.co.isid.kkh.customer.ash.model.report;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import jp.co.isid.kkh.model.AbstractServiceResult;

/**
*
* <P>
* 請求データ一覧（Ash）データ検索結果
* </P>
* <P>
* <B>修正履歴</B><BR>
* </P>
*/
@XmlRootElement(namespace = "http://report.model.ash.customer.kkh.isid.co.jp/")
@XmlType(namespace = "http://report.model.ash.customer.kkh.isid.co.jp/")
public class FDAshResult extends AbstractServiceResult {

    /** 請求データ一覧VOリスト */
    private List<FDAshVO> _Rep;

    /**
     * 請求データ一覧VOリストを取得します。
     * @return 請求データ一覧
     */
    public List<FDAshVO> getFDAsh() {
        return _Rep;
    }

    /**
     * 請求データ一覧VOリストを設定します。
     * @param rep List<FDAshVO> 請求データ一覧
     */
    public void setFDAsh(List<FDAshVO> rep) {
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
        _dummy = dummy;
    }

}

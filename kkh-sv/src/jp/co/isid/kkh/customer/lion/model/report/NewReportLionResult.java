package jp.co.isid.kkh.customer.lion.model.report;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import jp.co.isid.kkh.model.AbstractServiceResult;

/**
*
* <P>
* 新帳票結果を保持する。
* </P>
* <P>
* <B>修正履歴</B><BR>
* ・新規作成(2012/03/06)<BR>
* </P>
* @author
*/
@XmlRootElement(namespace = "http://report.model.lion.customer.kkh.isid.co.jp/")
@XmlType(namespace = "http://report.model.lion.customer.kkh.isid.co.jp/")
public class NewReportLionResult extends AbstractServiceResult{

    /** マスタ種類設定VOリスト */
    private List<NewReportLionVO> _Rep;

    /**
     * マスタ項目設定VOリストを取得します。
     * @return _masterItem
     */
    public List<NewReportLionVO> getReportLion() {
        return _Rep;
    }

    /**
     * マスタ項目設定VOリストを設定します。
     * @param masterItem セットする _masterItem
     */
    public void setReportLion(List<NewReportLionVO> rep) {
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

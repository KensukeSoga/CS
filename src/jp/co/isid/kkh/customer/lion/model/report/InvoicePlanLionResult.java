package jp.co.isid.kkh.customer.lion.model.report;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import jp.co.isid.kkh.model.AbstractServiceResult;

/**
*
* <P>
* ライオン制作費請求予定表検索結果保持クラス
* </P>
* <P>
* <B>修正履歴</B><BR>
* ・新規作成(2014/07/31 HLC S.Fujimoto)<BR>
* </P>
*
* @author HLC S.Fujimoto
*/
@XmlRootElement(namespace = "http://report.model.lion.customer.kkh.isid.co.jp/")
@XmlType(namespace = "http://report.model.lion.customer.kkh.isid.co.jp/")
public class InvoicePlanLionResult extends AbstractServiceResult{

    /** ライオン請求予定表検索結果VOリスト */
    private List<InvoicePlanLionVO> _vo;

    /**
     * ライオン請求予定表データを取得する
     * @return ライオン請求予定表データ
     */
    public List<InvoicePlanLionVO> getInvoicePlanInfo() {
        return _vo;
    }

    /**
     * ライオン請求予定表データを設定する
     * @param val List<InvoicePlanLionVO> ライオン請求予定表データ
     */
    public void setInvoicePlanInfo(List<InvoicePlanLionVO> val) {
        _vo = val;
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
    public void setDummy(String val) {
        _dummy = val;
    }

}

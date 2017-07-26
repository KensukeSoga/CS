package jp.co.isid.kkh.customer.lion.model.report;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import jp.co.isid.kkh.model.AbstractServiceResult;

/**
*
* <P>
* ライオン受注差異一覧検索結果保持クラス
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
public class OrderDiffListLionResult extends AbstractServiceResult{

    /** ライオン受注差異一覧検索結果VOリスト */
    private List<OrderDiffListLionVO> _vo;
    /** ライオン新規受注一覧検索結果VOリスト */
    private List<OrderDiffListLionVO> _vo2;
    /** ライオン受注金額差異一覧検索結果VOリスト */
    private List<OrderDiffListLionVO> _vo3;

    /**
     * ライオン受注差異一覧データを取得する
     * @return List<OrderDiffListLionVO> ライオン受注差異一覧データ
     */
    public List<OrderDiffListLionVO> getOrderDiffListInfo() {
        return _vo;
    }

    /**
     * ライオン受注差異一覧データを設定する
     * @param val List<OrderDiffListLionVO> ライオン受注差異一覧データ
     */
    public void setOrderDiffListInfo(List<OrderDiffListLionVO> val) {
        _vo = val;
    }

    /**
     * ライオン新規受注一覧データを取得する
     * @return List<OrderDiffListLionVO> ライオン新規受注一覧データ
     */
    public List<OrderDiffListLionVO> getNewOrderListInfo() {
        return _vo2;
    }

    /**
     * ライオン新規受注一覧データを設定する
     * @param val List<OrderDiffListLionVO> ライオン新規受注一覧データ
     */
    public void setNewOrderListInfo(List<OrderDiffListLionVO> val) {
        _vo2 = val;
    }

    /**
     * ライオン受注金額差異一覧データを取得する
     * @return List<OrderDiffListLionVO> ライオン受注金額差異一覧データ
     */
    public List<OrderDiffListLionVO> getOrderAmountDiffListInfo() {
        return _vo3;
    }

    /**
     * ライオン受注金額差異一覧を設定する
     * @param val List<OrderDiffListLionVO> ライオン受注金額差異一覧データ
     */
    public void setOrderAmountDiffListInfo(List<OrderDiffListLionVO> val) {
        _vo3 = val;
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

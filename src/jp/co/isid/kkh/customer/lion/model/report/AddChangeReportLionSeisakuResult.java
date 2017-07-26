package jp.co.isid.kkh.customer.lion.model.report;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import jp.co.isid.kkh.model.AbstractServiceResult;

/**
*
* <P>
* ライオン帳票(制作室リスト)検索結果保持クラス
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
public class AddChangeReportLionSeisakuResult extends AbstractServiceResult{

    /** ライオン制作室リストデータ検索結果VOリスト */
    /** 履歴タイムスタンプ */
    private List<AddChangeReportLionSeisakuVO> _vo1;
    /** 制作室リスト(AD1) */
    private List<AddChangeReportLionSeisakuVO> _vo2;
    /** 制作室リスト(AD2) */
    private List<AddChangeReportLionSeisakuVO> _vo3;
    /** 制作室リスト(AD1/AD2差分) */
    private List<AddChangeReportLionSeisakuVO> _vo4;

    /**
     * 履歴タイムスタンプを取得
     * @return 履歴タイムスタンプ
     */
    public List<AddChangeReportLionSeisakuVO> getRrkTimStmpInfo() {
        return _vo1;
    }

    /**
     * 履歴タイムスタンプを設定
     * @param val List<AddChangeReportVO> 履歴タイムスタンプ
     */
    public void setRrkTimStmpInfo(List<AddChangeReportLionSeisakuVO> val) {
        _vo1 = val;
    }

    /**
     * 制作室リスト(AD1)を取得
     * @return 制作室リスト(AD1)
     */
    public List<AddChangeReportLionSeisakuVO> getSeisakuAD1Info() {
        return _vo2;
    }

    /**
     * 制作室リスト(AD1)を設定
     * @param val List<AddChangeReportVO> 制作室リスト(AD1)
     */
    public void setSeisakuAD1Info(List<AddChangeReportLionSeisakuVO> val) {
        _vo2 = val;
    }

    /**
     * 制作室リスト(AD2)を取得
     * @return 制作室リスト(AD2)
     */
    public List<AddChangeReportLionSeisakuVO> getSeisakuAD2Info() {
        return _vo3;
    }

    /**
     * 制作室リスト(AD2)を設定
     * @param val List<AddChangeReportVO> 制作室リスト(AD2)
     */
    public void setSeisakuAD2Info(List<AddChangeReportLionSeisakuVO> val) {
        _vo3 = val;
    }

    /**
     * 制作室リスト(AD1/AD2差分)を取得
     * @return 制作室リスト(AD1/AD2差分)
     */
    public List<AddChangeReportLionSeisakuVO> getSeisakuDiffInfo() {
        return _vo4;
    }

    /**
     * 制作室リスト(AD1/AD2差分)を設定
     * @param val List<AddChangeReportVO> 制作室リスト(AD1/AD2差分)
     */
    public void setSeisakuDiffInfo(List<AddChangeReportLionSeisakuVO> val) {
        _vo4 = val;
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

package jp.co.isid.kkh.customer.lion.model.report;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import jp.co.isid.kkh.model.AbstractServiceResult;

/**
*
* <P>
* ライオン帳票(追加変更リスト)検索結果保持クラス
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
public class AddChangeReportLionBaitaiResult extends AbstractServiceResult{

    /** ライオン追加変更リストデータ検索結果VOリスト */
    /** 履歴タイムスタンプ */
    private List<AddChangeReportLionBaitaiVO> _vo1;
    /** 追加変更リスト(AD1) */
    private List<AddChangeReportLionBaitaiVO> _vo2;
    /** 追加変更リスト(AD2) */
    private List<AddChangeReportLionBaitaiVO> _vo3;
    /** 追加変更リスト(AD1/AD2差分、内部資料) */
    private List<AddChangeReportLionBaitaiVO> _vo4;
    /** 追加変更リスト(AD1/AD2差分) */
    private List<AddChangeReportLionBaitaiVO> _vo5;

    /**
     * 履歴タイムスタンプを取得
     * @return 履歴タイムスタンプ
     */
    public List<AddChangeReportLionBaitaiVO> getRrkTimStmpInfo() {
        return _vo1;
    }

    /**
     * 履歴タイムスタンプを設定
     * @param val List<AddChangeReportLionBaitaiVO> 履歴タイムスタンプ
     */
    public void setRrkTimStmpInfo(List<AddChangeReportLionBaitaiVO> val) {
        _vo1 = val;
    }

    /**
     * 追加変更リスト(AD1)を取得
     * @return 追加変更リスト(AD1)
     */
    public List<AddChangeReportLionBaitaiVO> getBaitaiAD1Info() {
        return _vo2;
    }

    /**
     * 追加変更リスト(AD1)を設定
     * @param val List<AddChangeReportLionBaitaiVO> 追加変更リスト(AD1)
     */
    public void setBaitaiAD1Info(List<AddChangeReportLionBaitaiVO> val) {
        _vo2 = val;
    }

    /**
     * 追加変更リスト(AD2)を取得
     * @return 追加変更リスト(AD2)
     */
    public List<AddChangeReportLionBaitaiVO> getBaitaiAD2Info() {
        return _vo3;
    }

    /**
     * 追加変更リスト(AD2)を設定
     * @param val List<AddChangeReportLionBaitaiVO> 追加変更リスト(AD2)
     */
    public void setBaitaiAD2Info(List<AddChangeReportLionBaitaiVO> val) {
        _vo3 = val;
    }

    /**
     * 追加変更リスト(AD1/AD2差分、内部資料)を取得
     * @return 追加変更リスト(AD1/AD2差分、内部資料)
     */
    public List<AddChangeReportLionBaitaiVO> getBaitaiDiffInfoInternal() {
        return _vo4;
    }

    /**
     * 追加変更リスト(AD1/AD2差分、内部資料)を設定
     * @param val List<AddChangeReportLionBaitaiVO> 追加変更リスト(AD1/AD2差分、内部資料)
     */
    public void setBaitaiDiffInfoInternal(List<AddChangeReportLionBaitaiVO> val) {
        _vo4 = val;
    }

    /**
     * 追加変更リスト(AD1/AD2差分)を取得
     * @return
     */
    public List<AddChangeReportLionBaitaiVO> getBaitaiDiffInfoExternal() {
        return _vo5;
    }

    /**
     * 追加変更リスト(AD1/AD2差分)を設定
     * @param val
     */
    public void setBaitaiDiffInfoExternal(List<AddChangeReportLionBaitaiVO> val) {
        _vo5 = val;
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

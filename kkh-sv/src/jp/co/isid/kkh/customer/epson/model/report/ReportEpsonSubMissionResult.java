package jp.co.isid.kkh.customer.epson.model.report;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import jp.co.isid.kkh.model.AbstractServiceResult;

/**
*
* <P>
* 提出帳票データを保持する。
* </P>
* <P>
* <B>修正履歴</B><BR>
* ・新規作成(2012/3/5 JSE YS)<BR>
* </P>
* @author
*/
@XmlRootElement(namespace = "http://report.model.kkh.isid.co.jp/")
@XmlType(namespace = "http://report.model.kkh.isid.co.jp/")
public class ReportEpsonSubMissionResult extends AbstractServiceResult {

    /** 提出帳票（エプソン)VOリスト */
    private List<ReportEpsonSubMissionVO> _rep;

    /**
     * 提出帳票（エプソン)VOリストを取得します。
     * @return _rep
     */
    public List<ReportEpsonSubMissionVO> getReportEpsonSubMission() {
        return _rep;
    }

    /**
     * 提出帳票（エプソン)VOリストを設定します。
     * @param rep セットする _rep
     */
    public void setReportEpsonSubMission(List<ReportEpsonSubMissionVO> rep) {
        _rep = rep;
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

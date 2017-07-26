package jp.co.isid.kkh.customer.ash.model.report;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import jp.co.isid.kkh.model.AbstractServiceResult;

/**
*
* <P>
* 広告費明細書（Ash）データ検索結果
* </P>
* <P>
* <B>修正履歴</B><BR>
* ・新規作成(2011/2/13 fourm h.izawa)<BR>
* </P>
* @author HLC K.Honma
*/
@XmlRootElement(namespace = "http://report.model.ash.customer.kkh.isid.co.jp/")
@XmlType(namespace = "http://report.model.ash.customer.kkh.isid.co.jp/")
public class ReportAshKoukokuHiResult extends AbstractServiceResult {
    /** マスタ種類設定VOリスト */
    private List<ReportAshKoukokuHiVO> _Rep;
    private List<ReportAshTvAndRadioKingakVO> _Rep4;

    public List<ReportAshTvAndRadioKingakVO> getReportAshTvAndRadio() {
        return _Rep4;
    }

    public void setReportAshTvAndRadio(List<ReportAshTvAndRadioKingakVO> rep4) {
        _Rep4 = rep4;
    }
    /**
     * マスタ項目設定VOリストを取得します。
     * @return _masterItem
     */
    public List<ReportAshKoukokuHiVO> getReportAsh() {
        return _Rep;
    }

    /**
     * マスタ項目設定VOリストを設定します。
     * @param masterItem セットする _masterItem
     */
    public void setReportAsh(List<ReportAshKoukokuHiVO> rep) {
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

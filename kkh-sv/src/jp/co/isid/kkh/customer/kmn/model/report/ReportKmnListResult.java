package jp.co.isid.kkh.customer.kmn.model.report;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import jp.co.isid.kkh.model.AbstractServiceResult;

/**
 *
 * <P>
 * 帳票（公文_請求一覧）データを保持する。
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2013/1/31 JSE A.Naito)<BR>
 * </P>
 *
 * @author JSE A.Naito
 */
@XmlRootElement(namespace = "http://report.model.kmn.customer.kkh.isid.co.jp/")
@XmlType(namespace = "http://report.model.kmn.customer.kkh.isid.co.jp/")
public class ReportKmnListResult extends AbstractServiceResult {

    /** 帳票（公文_請求一覧）データVOリスト */
    private List<ReportKmnListVO> _rptList;

    /**
     * 帳票（公文_請求一覧）データVOリストを取得します。
     *
     * @return _rptList
     */
    public List<ReportKmnListVO> getRptList() {
        return _rptList;
    }

    /**
     * 帳票（公文_請求一覧）データVOリストを設定します。
     *
     * @param meisai
     */
    public void setRptList(List<ReportKmnListVO> rptList) {
        _rptList = rptList;
    }
}

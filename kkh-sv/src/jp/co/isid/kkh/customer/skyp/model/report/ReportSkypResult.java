package jp.co.isid.kkh.customer.skyp.model.report;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import jp.co.isid.kkh.model.AbstractServiceResult;

/**
 *
 * <P>
 * 帳票（スカパー_納品／請求書）データを保持する。
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/1/16 JSE Y.Sato)<BR>
 * </P>
 *
 * @author JSE Y.Sato
 */
@XmlRootElement(namespace = "http://report.model.skyp.customer.kkh.isid.co.jp/")
@XmlType(namespace = "http://report.model.skyp.customer.kkh.isid.co.jp/")
public class ReportSkypResult extends AbstractServiceResult {

    /** 帳票（スカパー_納品／請求書）データVOリスト */
    private List<ReportSkypVO> _reportSkyp;

    /**
     * 帳票（スカパー_納品／請求書）データVOリストを取得します。
     *
     * @return _reportSkyp
     */
    public List<ReportSkypVO> getReportSkyp() {
        return _reportSkyp;
    }

    /**
     * 帳票（スカパー_納品／請求書）データVOリストを設定します。
     *
     * @param reportSkyp
     */
    public void setReportSkyp(List<ReportSkypVO> reportSkyp) {
        _reportSkyp = reportSkyp;
    }

}

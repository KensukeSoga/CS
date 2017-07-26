package jp.co.isid.kkh.customer.kmn.model.report;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import jp.co.isid.kkh.model.AbstractServiceResult;

/**
 *
 * <P>
 * シークエンスNoの最大値を保持する。
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2013/2/25 JSE A.Naito)<BR>
 * </P>
 *
 * @author JSE A.Naito
 */
@XmlRootElement(namespace = "http://report.model.kmn.customer.kkh.isid.co.jp/")
@XmlType(namespace = "http://report.model.kmn.customer.kkh.isid.co.jp/")
public class MaxSeqNoResult extends AbstractServiceResult {

    /** シークエンスNoの最大値 */
    private List<MaxSeqNoVO> _maxSeqNo = null;

    /**
     * シークエンスNoの最大値を取得します。
     *
     * @return maxSeqNo
     */
    public List<MaxSeqNoVO> getMaxSeqNo() {
        return _maxSeqNo;
    }

    /**
     * シークエンスNoの最大値を設定します。
     *
     * @param maxSeqNo
     */
    public void setMaxSeqNo(List<MaxSeqNoVO> maxSeqNo) {
        _maxSeqNo = maxSeqNo;
    }
}

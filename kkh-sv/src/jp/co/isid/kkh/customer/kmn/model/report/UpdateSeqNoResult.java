package jp.co.isid.kkh.customer.kmn.model.report;

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
public class UpdateSeqNoResult extends AbstractServiceResult {
}
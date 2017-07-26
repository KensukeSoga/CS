package jp.co.isid.kkh.customer.mac.model.report;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import jp.co.isid.kkh.model.AbstractServiceResult;

/**
 *
 * <P>
 * データ更新(請求書)の処理結果クラス
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2011/12/27 IP Shimizu)<BR>
 * </P>
 *
 * @author IP Shimizu
 */
@XmlRootElement(namespace = "http://report.model.mac.customer.kkh.isid.co.jp/")
@XmlType(namespace = "http://report.model.mac.customer.kkh.isid.co.jp/")
public class UpdateReportMacReqResult extends AbstractServiceResult {
}

package jp.co.isid.kkh.customer.mac.model.report;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import jp.co.isid.kkh.model.AbstractServiceResult;

/**
 *
 * <P>
 * データ更新(購入伝票)の処理結果クラス
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/1/17 IP Shimizu)<BR>
 * </P>
 *
 * @author IP Shimizu
 */
@XmlRootElement(namespace = "http://report.model.mac.customer.kkh.isid.co.jp/")
@XmlType(namespace = "http://report.model.mac.customer.kkh.isid.co.jp/")
public class UpdateReportMacPurResult extends AbstractServiceResult {
}

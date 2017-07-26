package jp.co.isid.kkh.customer.epson.model.detail;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import jp.co.isid.kkh.model.AbstractServiceResult;

/**
 *
 * <P>
 * 一括統合の処理結果クラス
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2011/11/24 JSE H.Abe)<BR>
 * </P>
 *
 * @author JSE H.Abe
 */
@XmlRootElement(namespace = "http://detail.model.epson.customer.kkh.isid.co.jp/")
@XmlType(namespace = "http://detail.model.epson.customer.kkh.isid.co.jp/")
public class BulkJyutyuDataEpsonMergeResult extends AbstractServiceResult {
}

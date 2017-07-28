package jp.co.isid.kkh.customer.mac.model.master;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import jp.co.isid.kkh.model.AbstractServiceResult;

/**
 *
 * <P>
 * マスタデータ登録の処理結果クラス
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2011/12/27 IP Shimizu)<BR>
 * </P>
 *
 * @author IP Shimizu
 */
@XmlRootElement(namespace = "http://master.model.mac.customer.kkh.isid.co.jp/")
@XmlType(namespace = "http://master.model.mac.customer.kkh.isid.co.jp/")
public class MasterMacRegisterResult extends AbstractServiceResult {
}

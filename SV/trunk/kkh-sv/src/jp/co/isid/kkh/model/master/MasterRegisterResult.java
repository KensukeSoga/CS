package jp.co.isid.kkh.model.master;

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
 * ・新規作成(2011/11/11 JSE H.Abe)<BR>
 * </P>
 *
 * @author JSE H.Abe
 */
@XmlRootElement(namespace = "http://master.model.kkh.isid.co.jp/")
@XmlType(namespace = "http://master.model.kkh.isid.co.jp/")
public class MasterRegisterResult extends AbstractServiceResult {
}

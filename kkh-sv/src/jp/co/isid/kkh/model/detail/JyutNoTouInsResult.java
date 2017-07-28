package jp.co.isid.kkh.model.detail;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import jp.co.isid.kkh.model.AbstractServiceResult;

/**
*
* <P>
* 統合受注内容のの結果を保持する。
* </P>
* <P>
* <B>修正履歴</B><BR>
* ・新規作成(2011/12/28 H.izawa)<BR>
* </P>
* @author
*/
@XmlRootElement(namespace = "http://detail.model.kkh.isid.co.jp/")
@XmlType(namespace = "http://detail.model.kkh.isid.co.jp/")
public class JyutNoTouInsResult extends AbstractServiceResult {

}

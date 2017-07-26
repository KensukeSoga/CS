package jp.co.isid.kkh.customer.ash.model.detail;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import jp.co.isid.kkh.model.AbstractServiceResult;

/**
*
* <P>
* 広告費明細データ検索結果を保持する。
* </P>
* <P>
* <B>修正履歴</B><BR>
* ・新規作成(2011/12/27 JSE K.Fukuda)<BR>
* </P>
* @author
*/
@XmlRootElement(namespace = "http://detail.model.ash.customer.kkh.isid.co.jp/")
@XmlType(namespace = "http://detail.model.ash.customer.kkh.isid.co.jp/")
public class GetFDSeqResult extends AbstractServiceResult {

    /** FD SEQ */
    private String _fdSeq;

    /**
     * FD SEQを取得します。
     * @return
     */
    public String getFdSeq() {
        return _fdSeq;
    }

    /**
     * FD SEQを設定します。
     * @param fdSeq
     */
    public void setFdSeq(String fdSeq) {
        this._fdSeq = fdSeq;
    }

}

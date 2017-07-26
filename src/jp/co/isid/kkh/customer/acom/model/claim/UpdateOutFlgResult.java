package jp.co.isid.kkh.customer.acom.model.claim;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import jp.co.isid.kkh.model.AbstractServiceResult;

/**
 *
 * <P>
 * 送信フラグ更新結果を保持する。
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/2/20 JSE Y.Sato)<BR>
 * </P>
 *
 * @author JSE Y.Sato
 */
@XmlRootElement(namespace = "http://claim.model.acom.customer.kkh.isid.co.jp/")
@XmlType(namespace = "http://claim.model.acom.customer.kkh.isid.co.jp/")
public class UpdateOutFlgResult extends AbstractServiceResult {

    /** 更新件数 */
    private int _count;

    /**
     * 更新件数を取得します。
     *
     * @return _count
     */
    public int getCount() {
        return _count;
    }

    /**
     * 送信フラグ情報VOリストを設定します。
     *
     * @param count
     */
    public void setCount(int count) {
        _count = count;
    }

}

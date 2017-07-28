package jp.co.isid.kkh.customer.skyp.model.detail;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import jp.co.isid.kkh.model.AbstractServiceResult;

/**
 *
 * <P>
 * 並び順更新結果を保持する。
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2011/12/22 JSE Y.Sato)<BR>
 * </P>
 *
 * @author JSE Y.Sato
 */
@XmlRootElement(namespace = "http://detail.model.skyp.customer.kkh.isid.co.jp/")
@XmlType(namespace = "http://detail.model.skyp.customer.kkh.isid.co.jp/")
public class UpdateOrderResult extends AbstractServiceResult {

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
     * 並び順情報VOリストを設定します。
     *
     * @param count
     */
    public void setCount(int count) {
        _count = count;
    }

}

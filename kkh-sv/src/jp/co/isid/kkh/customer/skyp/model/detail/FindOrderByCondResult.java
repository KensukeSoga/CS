package jp.co.isid.kkh.customer.skyp.model.detail;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import jp.co.isid.kkh.model.AbstractServiceResult;

/**
 *
 * <P>
 * 並び順情報を保持する。
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2011/12/21 JSE Y.Sato)<BR>
 * </P>
 *
 * @author JSE Y.Sato
 */
@XmlRootElement(namespace = "http://detail.model.skyp.customer.kkh.isid.co.jp/")
@XmlType(namespace = "http://detail.model.skyp.customer.kkh.isid.co.jp/")
public class FindOrderByCondResult extends AbstractServiceResult {

    /** 並び順情報VOリスト */
    private List<FindOrderCondVO> _orderList;

    /**
     * 並び順情報VOリストを取得します。
     *
     * @return _orderList
     */
    public List<FindOrderCondVO> getOrderList() {
        return _orderList;
    }

    /**
     * 並び順情報VOリストを設定します。
     *
     * @param orderList
     */
    public void setOrderList(List<FindOrderCondVO> orderList) {
        _orderList = orderList;
    }

}

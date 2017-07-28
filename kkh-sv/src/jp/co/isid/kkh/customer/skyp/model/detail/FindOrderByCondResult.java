package jp.co.isid.kkh.customer.skyp.model.detail;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import jp.co.isid.kkh.model.AbstractServiceResult;

/**
 *
 * <P>
 * ���я�����ێ�����B
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2011/12/21 JSE Y.Sato)<BR>
 * </P>
 *
 * @author JSE Y.Sato
 */
@XmlRootElement(namespace = "http://detail.model.skyp.customer.kkh.isid.co.jp/")
@XmlType(namespace = "http://detail.model.skyp.customer.kkh.isid.co.jp/")
public class FindOrderByCondResult extends AbstractServiceResult {

    /** ���я����VO���X�g */
    private List<FindOrderCondVO> _orderList;

    /**
     * ���я����VO���X�g���擾���܂��B
     *
     * @return _orderList
     */
    public List<FindOrderCondVO> getOrderList() {
        return _orderList;
    }

    /**
     * ���я����VO���X�g��ݒ肵�܂��B
     *
     * @param orderList
     */
    public void setOrderList(List<FindOrderCondVO> orderList) {
        _orderList = orderList;
    }

}

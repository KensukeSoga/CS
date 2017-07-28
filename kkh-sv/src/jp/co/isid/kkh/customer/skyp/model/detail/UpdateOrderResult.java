package jp.co.isid.kkh.customer.skyp.model.detail;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import jp.co.isid.kkh.model.AbstractServiceResult;

/**
 *
 * <P>
 * ���я��X�V���ʂ�ێ�����B
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2011/12/22 JSE Y.Sato)<BR>
 * </P>
 *
 * @author JSE Y.Sato
 */
@XmlRootElement(namespace = "http://detail.model.skyp.customer.kkh.isid.co.jp/")
@XmlType(namespace = "http://detail.model.skyp.customer.kkh.isid.co.jp/")
public class UpdateOrderResult extends AbstractServiceResult {

    /** �X�V���� */
    private int _count;

    /**
     * �X�V�������擾���܂��B
     *
     * @return _count
     */
    public int getCount() {
        return _count;
    }

    /**
     * ���я����VO���X�g��ݒ肵�܂��B
     *
     * @param count
     */
    public void setCount(int count) {
        _count = count;
    }

}

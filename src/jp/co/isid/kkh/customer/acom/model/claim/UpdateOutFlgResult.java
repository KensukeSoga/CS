package jp.co.isid.kkh.customer.acom.model.claim;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import jp.co.isid.kkh.model.AbstractServiceResult;

/**
 *
 * <P>
 * ���M�t���O�X�V���ʂ�ێ�����B
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/2/20 JSE Y.Sato)<BR>
 * </P>
 *
 * @author JSE Y.Sato
 */
@XmlRootElement(namespace = "http://claim.model.acom.customer.kkh.isid.co.jp/")
@XmlType(namespace = "http://claim.model.acom.customer.kkh.isid.co.jp/")
public class UpdateOutFlgResult extends AbstractServiceResult {

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
     * ���M�t���O���VO���X�g��ݒ肵�܂��B
     *
     * @param count
     */
    public void setCount(int count) {
        _count = count;
    }

}

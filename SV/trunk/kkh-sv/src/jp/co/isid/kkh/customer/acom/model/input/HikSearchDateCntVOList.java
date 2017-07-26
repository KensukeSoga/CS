package jp.co.isid.kkh.customer.acom.model.input;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * ���t�f�[�^�����pVO
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2011/12/05 HLC J.Morobayashi)<BR>
 * </P>
 * @author HLC J.Morobayashi
 */
@XmlRootElement(namespace = "http://input.model.kkh.isid.co.jp/")
@XmlType(namespace = "http://input.model.kkh.isid.co.jp/")
public class HikSearchDateCntVOList extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     */
    public HikSearchDateCntVOList() {
    }

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     *
     * @return �V�K�C���X�^���X
     */
    public Object newInstance() {
        return new HikSearchDateCntVOList();
    }

    /** �����o�^���VO **/
    private List<HikSearchDateCntVO> _VOList;

    /**
     * �����f�[�^VO��ݒ肵�܂��B
     * @param VOList List<HikSearchDateCntVOList>
     */
    public void setHikSearchDateCntVOList(List<HikSearchDateCntVO> VOList) {
        _VOList = VOList;
    }

    /**
     * �����f�[�^VO��Ԃ��܂��B
     * @return List<HikSearchDateCntVOList>
     */
    public List<HikSearchDateCntVO> getHikSearchDateCntVOList() {
        return _VOList;
    }

}

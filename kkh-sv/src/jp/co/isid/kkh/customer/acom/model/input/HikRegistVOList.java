package jp.co.isid.kkh.customer.acom.model.input;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * �����f�[�^VO
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2011/11/14 HLC J.Morobayashi)<BR>
 * </P>
 * @author HLC J.Morobayashi
 */
@XmlRootElement(namespace = "http://input.model.kkh.isid.co.jp/")
@XmlType(namespace = "http://input.model.kkh.isid.co.jp/")
public class HikRegistVOList extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /** �����o�^���VO **/
    private List<HikVO> _VOList;

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     */
    public HikRegistVOList() {
    }

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     *
     * @return �V�K�C���X�^���X
     */
    public Object newInstance() {
        return new HikRegistVOList();
    }

    /**
     * �����f�[�^VO��ݒ肵�܂��B
     * @param VOList List<HikRegistVO> �����o�^���VO
     */
    public void setHikRegistVOList(List<HikVO> VOList) {
        _VOList = VOList;
    }

    /**
     * �����f�[�^VO��Ԃ��܂��B
     * @return List<HikRegistVO> �����o�^���VO
     */
    public List<HikVO> getHikRegistVOList() {
        return _VOList;
    }

}

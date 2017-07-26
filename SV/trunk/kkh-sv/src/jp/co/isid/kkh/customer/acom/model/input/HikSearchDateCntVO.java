package jp.co.isid.kkh.customer.acom.model.input;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import jp.co.isid.kkh.integ.tbl.TBTHB5HIK;
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
public class HikSearchDateCntVO extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     */
    public HikSearchDateCntVO() {
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
    private List<HikSearchDateCntVOList> _VOList;


    /**
     * �����f�[�^VO��ݒ肵�܂��B
     * @param VOList List<HikSearchDateCntVOList>
     */
    public void setHikSearchDateCntVOList(List<HikSearchDateCntVOList> VOList) {
        _VOList = VOList;
    }

    /**
     * �����f�[�^VO��Ԃ��܂��B
     * @return List<HikSearchDateCntVOList>
     */
    public List<HikSearchDateCntVOList> getHikSearchDateCntVOList() {
        return _VOList;
    }

    /**
     * ���Ӑ��ƃR�[�h��ݒ肵�܂��B
     * @param val String ���Ӑ��ƃR�[�h
     */
    public void setTksKgyCd(String val) {
        set(TBTHB5HIK.TKSKGYCD, val);
    }

    /**
     * ���Ӑ��ƃR�[�h��Ԃ��܂��B
     * @return String ���Ӑ��ƃR�[�h
     */
    public String getTksKgyCd() {
        return (String) get(TBTHB5HIK.TKSKGYCD);
    }

    /**
     * ���Ӑ敔��SEQNO��ݒ肵�܂��B
     * @param val String ���Ӑ敔��SEQNO
     */
    public void setTksBmnSeqNo(String val) {
        set(TBTHB5HIK.TKSBMNSEQNO, val);
    }

    /**
     * ���Ӑ敔��SEQNO��Ԃ��܂��B
     * @return String ���Ӑ敔��SEQNO
     */
    public String getTksBmnSeqNo() {
        return (String) get(TBTHB5HIK.TKSBMNSEQNO);
    }

    /**
     * ���Ӑ�S��SEQNO��ݒ肵�܂��B
     * @param val String ���Ӑ�S��SEQNO
     */
    public void setTksTntSeqNo(String val) {
        set(TBTHB5HIK.TKSTNTSEQNO, val);
    }

    /**
     * ���Ӑ�S��SEQNO��Ԃ��܂��B
     * @return String ���Ӑ�S��SEQNO
     */
    public String getTksTntSeqNo() {
        return (String) get(TBTHB5HIK.TKSTNTSEQNO);
    }

    /**
     * ��ʂ�ݒ肵�܂��B
     * @param val String ���
     */
    public void setSybt(String val) {
        set(TBTHB5HIK.SYBT, val);
    }

    /**
     * ��ʂ�Ԃ��܂��B
     * @return String ���
     */
    public String getSybt() {
        return (String) get(TBTHB5HIK.SYBT);
    }

    /**
     * ���R�[�h��ʂ�ݒ肵�܂��B
     * @param val String ���R�[�h���
     */
    public void setRecCd(String val) {
        set(TBTHB5HIK.RECCD, val);
    }

    /**
     * ���R�[�h��ʂ�Ԃ��܂��B
     * @return String ���R�[�h���
     */
    public String getRecCd() {
        return (String) get(TBTHB5HIK.RECCD);
    }

    /**
     * �˗��ԍ���ݒ肵�܂��B
     * @param val String �˗��ԍ�
     */
    public void setIrban(String val) {
        set(TBTHB5HIK.IRBAN, val);
    }

    /**
     * �˗��ԍ���Ԃ��܂��B
     * @return String �˗��ԍ�
     */
    public String getIrban() {
        return (String) get(TBTHB5HIK.IRBAN);
    }

    /**
     * �˗��s�ԍ���ݒ肵�܂��B
     * @param val String �˗��s�ԍ�
     */
    public void setIrrowban(String val) {
        set(TBTHB5HIK.IRROWBAN, val);
    }

    /**
     * �˗��s�ԍ���Ԃ��܂��B
     * @return String �˗��s�ԍ�
     */
    public String getIrrowban() {
        return (String) get(TBTHB5HIK.IRROWBAN);
    }

}

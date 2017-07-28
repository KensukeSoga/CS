package jp.co.isid.kkh.customer.ash.model.report;

import java.math.BigDecimal;

import jp.co.isid.kkh.integ.tbl.TBTHB2KMEI;
import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * �L����׏��iAsh�j�^�C�����׋��zVO
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/1/23 fourm h.izawa)<BR>
 * </P>
 * @author
 */
public class ReportAshTvAndRadioKingakVO extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     */
    public ReportAshTvAndRadioKingakVO() {
    }

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     *
     * @return �V�K�C���X�^���X
     */
    public Object newInstance() {
        return new ReportAshTvAndRadioKingakVO();
    }

    /**
     * ��NO��ݒ肵�܂��B
     * @param val String ��NO
     */
    public void setJyutNo(String val) {
        set(TBTHB2KMEI.JYUTNO, val);
    }

    /**
     * ��NO���擾���܂�
     * @return ��NO
     */
    public String getJyutNo() {
        return (String) get(TBTHB2KMEI.JYUTNO);
    }

    /**
     * �󒍖���NO��ݒ肵�܂��B
     * @param val Strng �󒍖���NO
     */
    public void setJyMeiNo(String val) {
        set(TBTHB2KMEI.JYMEINO, val);
    }

    /**
     * �󒍖���NO���擾���܂��B
     * @return �󒍖���NO
     */
    public String getJyMeiNo() {
        return (String) get(TBTHB2KMEI.JYMEINO);
    }

    /**
     * ���㖾��NO��ݒ肵�܂��B
     * @param val String
     */
    public void setUrMeiNo(String val) {
        set(TBTHB2KMEI.URMEINO, val);
    }

    /**
     * ���㖾��NO���擾���܂�
     * @return ���㖾��NO
     */
    public String getUrMeiNo() {
        return (String) get(TBTHB2KMEI.URMEINO);
    }

    /**
     * �i��R�[�h��ݒ肵�܂��B
     * @param val String �i��R�[�h
     */
    public void setHinsyuCD(String val) {
        set("HINSYUCD", val);
    }

    /**
     * �i��R�[�h���擾���܂��B
     * @return �i��R�[�h
     */
    public String getHinsyuCD() {
        return (String) get("HINSYUCD");
    }

    /**
     * �}�̃R�[�h��ݒ肵�܂��B
     * @param val String �}�̃R�[�h
     */
    public void setBaitaiCD(String val) {
        set("BAITAICD", val);
    }

    /**
     * �}�̃R�[�h���擾���܂�
     * @return �}�̃R�[�h
     */
    public String getBaitaiCD() {
        return (String) get("BAITAICD");
    }

    /**
     * �������z��ݒ肵�܂��B
     * @param val BigDecimal �������z
     */
    public void setSeiGak(BigDecimal val) {
        set("SEIGAK", val);
    }

    /**
     * �������z���擾���܂��B
     * @return �������z
     */
    public BigDecimal getSeiGak() {
        return (BigDecimal) get("SEIGAK");
    }

}

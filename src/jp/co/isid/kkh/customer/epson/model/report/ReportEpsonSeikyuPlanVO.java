package jp.co.isid.kkh.customer.epson.model.report;

import java.math.BigDecimal;

import jp.co.isid.kkh.integ.tbl.TBTHB2KMEI;
import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * �����\��ꗗ�i�G�v�\��)VO
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/3/9 IP JK)<BR>
 * </P>
 * @author
 */
public class ReportEpsonSeikyuPlanVO extends AbstractModel {

    /** */
    private static final long serialVersionUID = 1L;

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     */
    public ReportEpsonSeikyuPlanVO() {
    }

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     *
     * @return �V�K�C���X�^���X
     */
    public Object newInstance() {
        return new ReportEpsonSeikyuPlanVO();
    }

    /**
     * �擪����擾����
     * @return �擪��
     */
    public String getFirstCol() {
        return (String) get("FIRSTCOL");
    }

    /**
     * �擪���ݒ肷��
     * @param val �擪��
     */
    public void setFirstCol(String val) {
        set("FIRSTCOL", val);
    }

    // 2015/04/06 �G�v�\�������g���Ή� Fujisaki Cng Start
//    /**
//     * �L���������擾����
//     * @return �L������
//     */
//    public String getNAME8() {
//        return (String) get(TBTHB2KMEI.NAME8);
//    }
//
//    /**
//     * �L��������ݒ肷��
//     * @param val �L������
//     */
//    public void setNAME8(String val) {
//        set(TBTHB2KMEI.NAME8, val);
//    }

    /**
     * �L������(�g���Ή�)���擾����
     * @return �L������(�g���Ή�)
     */
    public String getNAME11() {
        return (String) get(TBTHB2KMEI.NAME11);
    }

    /**
     * �L������(�g���Ή�)��ݒ肷��
     * @param val �L������(�g���Ή�)
     */
    public void setNAME11(String val) {
        set(TBTHB2KMEI.NAME11, val);
    }
    // 2015/04/06 �G�v�\�������g���Ή� Fujisaki Cng End

    /**
     * ���S�����擾����
     * @return ���S��
     */
    public String getNAME3() {
        return (String) get(TBTHB2KMEI.NAME3);
    }

    /**
     * ���S����ݒ肷��
     * @param val ���S��
     */
    public void setNAME3(String val) {
        set(TBTHB2KMEI.NAME3, val);
    }

    /**
     * �������擾����
     * @return ����
     */
    public String getNAME10() {
        return (String) get(TBTHB2KMEI.NAME10);
    }

    /**
     * ������ݒ肷��
     * @param val ����
     */
    public void setNAME10(String val) {
        set(TBTHB2KMEI.NAME10, val);
    }

    /**
     * ������ʃR�[�h���擾����
     * @return ������ʃR�[�h
     */
    public String getCODE4() {
        return (String) get(TBTHB2KMEI.CODE4);
    }

    /**
     * ������ʃR�[�h��ݒ肷��
     * @param val ������ʃR�[�h
     */
    public void setCODE4(String val) {
        set(TBTHB2KMEI.CODE4, val);
    }

    /**
     * ���O���擾����
     * @return ���O
     */
    public BigDecimal getKNGK2() {
        return (BigDecimal) get(TBTHB2KMEI.KNGK2);
    }

    /**
     * ���O��ݒ肷��
     * @param val ���O
     */
    public void setKNGK2(BigDecimal val) {
        set(TBTHB2KMEI.KNGK2, val);
    }

    /**
     * ������擾����
     * @return ����
     */
    public BigDecimal getSEIGAK() {
        return (BigDecimal) get(TBTHB2KMEI.SEIGAK);
    }

    /**
     * �����ݒ肷��
     * @param val ����
     */
    public void setSEIGAK(BigDecimal val) {
        set(TBTHB2KMEI.SEIGAK, val);
    }

    /**
     * �ŏI����擾����
     * @return �ŏI��
     */
    public String getLastCol() {
        return (String) get("LASTCOLN");
    }

    /**
     * �ŏI���ݒ肷��
     * @param val �ŏI��
     */
    public void setLastCol(String val) {
        set("LASTCOLN", val);
    }

}
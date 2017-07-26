package jp.co.isid.kkh.customer.kmn.model.report;

import java.math.BigDecimal;

import jp.co.isid.kkh.integ.tbl.TBTHB2KMEI;
import jp.co.isid.nj.model.AbstractModel;


/**
 * <P>
 * ���[�i����_�`�[�j�f�[�^VO
 * ���׃f�[�^�̂�
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2013/01/30 JSE M.Naito)<BR>
 * </P>
 *
 * @author JSE M.Naito
 */
public class ReportKmnMeisaiVO extends AbstractModel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     */
    public ReportKmnMeisaiVO() {
    }

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     *
     * @return �V�K�C���X�^���X
     */
    public Object newInstance() {
        return new ReportKmnMeisaiVO();
    }

    /**
     * ��No���擾����
     * @return ��No
     */
    public String getJyutyuNo() {
        return (String) get(TBTHB2KMEI.JYUTNO);
    }

    /**
     * ��No��ݒ肷��
     * @param val ��No
     */
    public void setJyutyuNo(String val) {
        set(TBTHB2KMEI.JYUTNO, val);
    }

    /**
     * �󒍖���No���擾����
     * @return �󒍖���No
     */
    public String getJyuMeiNo() {
        return (String) get(TBTHB2KMEI.JYMEINO);
    }

    /**
     * �󒍖���No��ݒ肷��
     * @param val �󒍖���No
     */
    public void setJyuMeiNo(String val) {
        set(TBTHB2KMEI.JYMEINO, val);
    }

    /**
     * ���㖾��No���擾����
     * @return ���㖾��No
     */
    public String getUriMeiNo() {
        return (String) get(TBTHB2KMEI.URMEINO);
    }

    /**
     * ���㖾��No��ݒ肷��
     * @param val ���㖾��No
     */
    public void setUriMeiNo(String val) {
        set(TBTHB2KMEI.URMEINO, val);
    }

    /**
     * ����R�[�h���擾����
     * @return �R�[�h1
     */
    public String getBumonCd() {
        return (String) get(TBTHB2KMEI.CODE1);
    }

    /**
     * ����R�[�h��ݒ肷��
     * @param val �R�[�h1
     */
    public void setBumonCd(String val) {
        set(TBTHB2KMEI.CODE1, val);
    }

    /**
     * �o��No���擾����
     * @return �R�[�h2
     */
    public String getOutputNo() {
        return (String) get(TBTHB2KMEI.CODE2);
    }

    /**
     * �o��No��ݒ肷��
     * @param val �R�[�h2
     */
    public void setOutputNo(String val) {
        set(TBTHB2KMEI.CODE2, val);
    }

    //--�����N���\�����@�C���Ή� 2013/07/18 HLC H.Watabe start
    /**
     * �i�ڂP���擾����
     * @return ����9(����)
     */
    public String getHinmoku1() {
        //return (String) get(TBTHB2KMEI.NAME9);
        return (String) get(TBTHB2KMEI.NAME8);
    }

    /**
     * �i�ڂP��ݒ肷��
     * @param val ����9(����)
     */
    public void setHinmoku1(String val) {
        //set(TBTHB2KMEI.NAME9, val);
        set(TBTHB2KMEI.NAME8, val);
    }

    /**
     * �i�ڂQ���擾����
     * @return ����4(����)
     */
    public String getHinmoku2() {
        //return (String) get(TBTHB2KMEI.NAME4);
        return (String) get(TBTHB2KMEI.NAME3);
    }

    /**
     * �i�ڂQ��ݒ肷��
     * @param val ����4(����)
     */
    public void setHinmoku2(String val) {
        //set(TBTHB2KMEI.NAME4, val);
        set(TBTHB2KMEI.NAME3, val);
    }

    /**
     * �i�ڂR���擾����
     * @return ����5(����)
     */
    public String getHinmoku3() {
        //return (String) get(TBTHB2KMEI.NAME5);
        return (String) get(TBTHB2KMEI.NAME4);
    }

    /**
     * �i�ڂR��ݒ肷��
     * @param val ����5(����)
     */
    public void setHinmoku3(String val) {
        //set(TBTHB2KMEI.NAME5, val);
        set(TBTHB2KMEI.NAME4, val);
    }

    /**
     * ���嗪�̂��擾����
     * @return ����6(����)
     */
    public String getBumonNm() {
        //return (String) get(TBTHB2KMEI.NAME6);
        return (String) get(TBTHB2KMEI.NAME5);
    }

    /**
     * ���嗪�̂�ݒ肷��
     * @param val ����6(����)
     */
    public void setBumonNm(String val) {
        //set(TBTHB2KMEI.NAME6, val);
        set(TBTHB2KMEI.NAME5, val);
    }

    /**
     * �������擾����
     * @return ����16(����)
     */
    public String getAtenaNm() {
        return (String) get(TBTHB2KMEI.NAME16);
    }

    /**
     * ������ݒ肷��
     * @param val ����16(����)
     */
    public void setAtenaNm(String val) {
        set(TBTHB2KMEI.NAME16, val);
    }

    /**
     * ����ŋ��z���擾����
     * @return ���z3
     */
    public BigDecimal getSZeiGak() {
        return (BigDecimal) get(TBTHB2KMEI.KNGK3);
    }

    /**
     * ����ŋ��z��ݒ肷��
     * @param val ���z3
     */
    public void setSZeiGak(BigDecimal val) {
        set(TBTHB2KMEI.KNGK3, val);
    }


    /**
     * ���z���擾����
     * @return ���z1
     */
    public BigDecimal getKingaku() {
        return (BigDecimal) get(TBTHB2KMEI.KNGK1);
    }

    /**
     * ���z��ݒ肷��
     * @param val ���z1
     */
    public void setKingaku(BigDecimal val) {
        set(TBTHB2KMEI.KNGK1, val);
    }

    /**
     * �N�����擾����
     * @return �N��
     */
    public String getYyyymm() {
        return (String) get(TBTHB2KMEI.YYMM);
    }

    /**
     * �N����ݒ肷��
     * @param val �N��
     */
    public void setYyyymm(String val) {
        set(TBTHB2KMEI.YYMM, val);
    }

    /**
     * �����N�����擾����
     * @return �����N��
     */
    public String getSeikyuYM() {
        return (String) get(TBTHB2KMEI.NAME6);
    }

    /**
     * �����N����ݒ肷��
     * @param val �����N��
     */
    public void setSeikyuYM(String val) {
        set(TBTHB2KMEI.NAME6, val);
    }
    //--�����N���\�����@�C���Ή� 2013/07/18 HLC H.Watabe end

    /**
     * �����ς݃X�e�[�^�X���擾����
     * @return �����ς݃X�e�[�^�X
     */
    public String getSeiZumi() {
        return (String) get("SEIZUMI");
    }

    /**
     * �����ς݃X�e�[�^�X��ݒ肷��
     * @param val �����ς݃X�e�[�^�X
     */
    public void setSeiZumi(String val) {
        set("SEIZUMI", val);
    }

}
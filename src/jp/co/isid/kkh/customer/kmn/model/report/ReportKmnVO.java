package jp.co.isid.kkh.customer.kmn.model.report;

import java.math.BigDecimal;

import jp.co.isid.kkh.integ.tbl.TBTHB14SKDOWN;
import jp.co.isid.kkh.integ.tbl.TBTHB1DOWN;
import jp.co.isid.kkh.integ.tbl.TBTHB2KMEI;
import jp.co.isid.nj.model.AbstractModel;


/**
 * <P>
 * ���[�i����_�`�[�j�f�[�^VO
 *
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2013/01/30 JSE M.Naito)<BR>
 * </P>
 *
 * @author JSE M.Naito
 */
public class ReportKmnVO extends AbstractModel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     */
    public ReportKmnVO() {
    }

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     *
     * @return �V�K�C���X�^���X
     */
    public Object newInstance() {
        return new ReportKmnJyutyuVO();
    }

    /**
     * ��No���擾����
     * @return ��No
     */
    public String getHb2JyutNo() {
        return (String) get(TBTHB2KMEI.JYUTNO);
    }

    /**
     * ��No��ݒ肷��
     * @param val ��No
     */
    public void setHb2JyutNo(String val) {
        set(TBTHB2KMEI.JYUTNO, val);
    }

    /**
     * �󒍖���No���擾����
     * @return �󒍖���No
     */
    public String getHb2JymeiNo() {
        return (String) get(TBTHB2KMEI.JYMEINO);
    }

    /**
     * �󒍖���No��ݒ肷��
     * @param val �󒍖���No
     */
    public void setHb2JymeiNo(String val) {
        set(TBTHB2KMEI.JYMEINO, val);
    }

    /**
     * ���㖾��No���擾����
     * @return ���㖾��No
     */
    public String getHb2UrmeiNo() {
        return (String) get(TBTHB2KMEI.URMEINO);
    }

    /**
     * ���㖾��No��ݒ肷��
     * @param val ���㖾��No
     */
    public void setHb2UrmeiNo(String val) {
        set(TBTHB2KMEI.URMEINO, val);
    }

    /**
     * ����R�[�h���擾����
     * @return �R�[�h1
     */
    public String getHb2Code1() {
        return (String) get(TBTHB2KMEI.CODE1);
    }

    /**
     * ����R�[�h��ݒ肷��
     * @param val �R�[�h1
     */
    public void setHb2Code1(String val) {
        set(TBTHB2KMEI.CODE1, val);
    }

    /**
     * �o��No���擾����
     * @return �R�[�h2
     */
    public String getHb2Code2() {
        return (String) get(TBTHB2KMEI.CODE2);
    }

    /**
     * �o��No��ݒ肷��
     * @param val �R�[�h2
     */
    public void setHb2Code2(String val) {
        set(TBTHB2KMEI.CODE2, val);
    }

    /**
     * �i�ڂP���擾����
     * @return ����8(����)
     */
    public String getHb2Name8() {
        return (String) get(TBTHB2KMEI.NAME8);
    }

    /**
     * �i�ڂP��ݒ肷��
     * @param val ����8(����)
     */
    public void setHb2Name8(String val) {
        set(TBTHB2KMEI.NAME8, val);
    }

    /**
     * �i�ڂQ���擾����
     * @return ����3(����)
     */
    public String getHb2Name3() {
        return (String) get(TBTHB2KMEI.NAME3);
    }

    /**
     * �i�ڂQ��ݒ肷��
     * @param val ����3(����)
     */
    public void setHb2Name3(String val) {
        set(TBTHB2KMEI.NAME3, val);
    }

    /**
     * �i�ڂR���擾����
     * @return ����4(����)
     */
    public String getHb2Name4() {
        return (String) get(TBTHB2KMEI.NAME4);
    }

    /**
     * �i�ڂR��ݒ肷��
     * @param val ����4(����)
     */
    public void setHb2Name4(String val) {
        set(TBTHB2KMEI.NAME4, val);
    }

    /**
     * ���嗪�̂��擾����
     * @return ����5(����)
     */
    public String getHb2Name5() {
        return (String) get(TBTHB2KMEI.NAME5);
    }

    /**
     * ���嗪�̂�ݒ肷��
     * @param val ����5(����)
     */
    public void setHb2Name5(String val) {
        set(TBTHB2KMEI.NAME5, val);
    }

    /**
     * ������擾����
     * @return ����16(����)
     */
    public String getHb2Name16() {
        return (String) get(TBTHB2KMEI.NAME16);
    }

    /**
     * �����ݒ肷��
     * @param val ����16(����)
     */
    public void setHb2Name16(String val) {
        set(TBTHB2KMEI.NAME16, val);
    }

    /**
     * ���v����Ŋz���擾����
     * @return ���z3
     */
    public BigDecimal getHb2Kngk3() {
        return (BigDecimal) get(TBTHB2KMEI.KNGK3);
    }

    /**
     * ���v����Ŋz��ݒ肷��
     * @param val ���z3
     */
    public void setHb2Kngk3(BigDecimal val) {
        set(TBTHB2KMEI.KNGK3, val);
    }

    /**
     * ���v���z���擾����
     * @return �������z
     */
    public BigDecimal getHb2Seigak() {
        return (BigDecimal) get(TBTHB2KMEI.SEIGAK);
    }

    /**
     * ���v���z��ݒ肷��
     * @param val �������z
     */
    public void setHb2Seigak(BigDecimal val) {
        set(TBTHB2KMEI.SEIGAK, val);
    }

    /**
     * �N�����擾����
     * @return �N��
     */
    public String getHb2Yymm() {
        return (String) get(TBTHB2KMEI.YYMM);
    }

    /**
     * �N����ݒ肷��
     * @param val �N��
     */
    public void setHb2Yymm(String val) {
        set(TBTHB2KMEI.YYMM, val);
    }

    /**
     * �����N�����擾����
     * @return �����N��
     */
    public String getHb2Name6() {
        return (String) get(TBTHB2KMEI.NAME6);
    }

    /**
     * �����N����ݒ肷��
     * @param val �����N��
     */
    public void setHb2Name6(String val) {
        set(TBTHB2KMEI.NAME6, val);
    }

    /**
     * ��No���擾����
     * @return ��No
     */
    public String getHb14JyutNo() {
        return (String) get(TBTHB14SKDOWN.JYUTNO);
    }

    /**
     * ��No��ݒ肷��
     * @param val ��No
     */
    public void setHb14JyutNo(String val) {
        set(TBTHB14SKDOWN.JYUTNO, val);
    }

    /**
     * �e�q�t���O���擾����
     * @return �e�q�t���O
     */
    public String getOyako() {
        return (String) get("OYAKOFLG");
    }

    /**
     * �e�q�t���O��ݒ肷��
     * @param val �e�q�t���O
     */
    public void setOyako(String val) {
        set("OYAKOFLG", val);
    }

    /**
     * ��No���擾����
     * @return ��No
     */
    public String getHb1JyutNo() {
        return (String) get(TBTHB1DOWN.JYUTNO);
    }

    /**
     * ��No��ݒ肷��
     * @param val ��No
     */
    public void setHb1JyutNo(String val) {
        set(TBTHB1DOWN.JYUTNO, val);
    }

    /**
     * �������No���擾����
     * @return �������No
     */
    public String getHb1TJyutNo() {
        return (String) get(TBTHB1DOWN.TJYUTNO);
    }

    /**
     * �������No��ݒ肷��
     * @param val �������No
     */
    public void setHb1TJyutNo(String val) {
        set(TBTHB1DOWN.TJYUTNO, val);
    }
}
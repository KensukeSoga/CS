package jp.co.isid.kkh.customer.tkd.model.report;

import java.math.BigDecimal;

import jp.co.isid.kkh.integ.tbl.TBTHB2KMEI;
import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * ���c�������ׁi�����ޕʁj�擾VO
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/01/23 JSE Hitoshi Sasaki)<BR>
 * </P>
 *
 * @author JSE Hitoshi Sasaki
 */
public class ReportTkdBillingByMiddleClassificationVO extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /** SQL�ԍ� */
    public static final String SQLNO = "SQLNO";

    /** �}�̒����ޔԍ� */
    public static final String CYBNO = "CYBNO";

    /** �ʔ}�̔ԍ� */
    public static final String BAINO = "BAINO";

    /** ��A�ԍ� */
    public static final String RENNO = "RENNO";

    /** �i�ڔԍ� */
    public static final String HINNO = "HINNO";

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     */
    public ReportTkdBillingByMiddleClassificationVO() {
    }

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     *
     * @return �V�K�C���X�^���X
     */
    public Object newInstance() {
        return new ReportTkdBillingByMiddleClassificationVO();
    }

    /**
     * SQL�ԍ���ݒ肷��
     *
     * @param val
     *            SQL�ԍ�
     */
    public void setSQLNO(BigDecimal val) {
        set(SQLNO, val);
    }

    /**
     * SQL�ԍ����擾����
     *
     * @return SQL�ԍ�
     */
    public BigDecimal getSQLNO() {
        return (BigDecimal) get(SQLNO);
    }

    /**
     * �㗝�X�R�[�h��ݒ肷��
     *
     * @param val
     *            �㗝�X�R�[�h
     */
    public void setStrDairitenCD(String val) {
        set(TBTHB2KMEI.CODE1, val);
    }

    /**
     * �㗝�X�R�[�h���擾����
     *
     * @return �㗝�X�R�[�h
     */
    public String getStrDairitenCD() {
        return (String) get(TBTHB2KMEI.CODE1);
    }

    /**
     * ���{�N����ݒ肷��
     *
     * @param val
     *            ���{�N��
     */
    public void setStrYM(String val) {
        set(TBTHB2KMEI.DATE1, val);
    }

    /**
     * ���{�N�����擾����
     *
     * @return ���{�N��
     */
    public String getStrYM() {
        return (String) get(TBTHB2KMEI.DATE1);
    }

    /**
     * �}�̒����ރR�[�h��ݒ肷��
     *
     * @param val
     *            �}�̒����ރR�[�h
     */
    public void setStrCYBNCD(String val) {
        set(TBTHB2KMEI.CODE5, val);
    }

    /**
     * �}�̒����ރR�[�h���擾����
     *
     * @return �}�̒����ރR�[�h
     */
    public String getStrCYBNCD() {
        return (String) get(TBTHB2KMEI.CODE5);
    }

    /**
     * �}�̒����ޖ���ݒ肷��
     *
     * @param val
     *            �}�̒����ޖ�
     */
    public void setStrCYBNNM(String val) {
        set(TBTHB2KMEI.NAME4, val);
    }

    /**
     * �}�̒����ޖ����擾����
     *
     * @return �}�̒����ޖ�
     */
    public String getStrCYBNNM() {
        return (String) get(TBTHB2KMEI.NAME4);
    }

    /**
     * �}�̒����ޔԍ���ݒ肷��
     *
     * @param val
     *            �}�̒����ޔԍ�
     */
    public void setCYBNO(BigDecimal val) {
        set(CYBNO, val);
    }

    /**
     * �}�̒����ޔԍ����擾����
     *
     * @return �}�̒����ޔԍ�
     */
    public BigDecimal getCYBNO() {
        return (BigDecimal) get(CYBNO);
    }

    /**
     * �ʔ}�̖���ݒ肷��
     *
     * @param val
     *            �ʔ}�̖�
     */
    public void setStrKBTNM(String val) {
        set(TBTHB2KMEI.NAME10, val);
    }

    /**
     * �ʔ}�̖����擾����
     *
     * @return �ʔ}�̖�
     */
    public String getStrKBTNM() {
        return (String) get(TBTHB2KMEI.NAME10);
    }

    /**
     * �ʔ}�̃R�[�h��ݒ肷��
     *
     * @param val
     *            �ʔ}�̃R�[�h
     */
    public void setStrKBTCD(String val) {
        set(TBTHB2KMEI.CODE2, val);
    }

    /**
     * �ʔ}�̃R�[�h���擾����
     *
     * @return �ʔ}�̃R�[�h
     */
    public String getStrKBTCD() {
        return (String) get(TBTHB2KMEI.CODE2);
    }

    /**
     * �ʔ}�̔ԍ���ݒ肷��
     *
     * @param val
     *            �ʔ}�̔ԍ�
     */
    public void setBAINO(BigDecimal val) {
        set(BAINO, val);
    }

    /**
     * �ʔ}�̔ԍ����擾����
     *
     * @return �ʔ}�̔ԍ�
     */
    public BigDecimal getBAINO() {
        return (BigDecimal) get(BAINO);
    }

    /**
     * ��A�ԍ���ݒ肷��
     *
     * @param val
     *            ��A�ԍ�
     */
    public void setRENNO(String val) {
        set(RENNO, val);
    }

    /**
     * ��A�ԍ����擾����
     *
     * @return ��A�ԍ�
     */
    public String getRENNO() {
        return (String) get(RENNO);
    }

    /**
     * �i�ږ���ݒ肷��
     *
     * @param val
     *            �i�ږ�
     */
    public void setStrHinmokuNM(String val) {
        set(TBTHB2KMEI.NAME2, val);
    }

    /**
     * �i�ږ����擾����
     *
     * @return �i�ږ�
     */
    public String getStrHinmokuNM() {
        return (String) get(TBTHB2KMEI.NAME2);
    }

    /**
     * �i�ڃR�[�h��ݒ肷��
     *
     * @param val
     *            �i�ڃR�[�h
     */
    public void setStrHinmokuCD(String val) {
        set(TBTHB2KMEI.CODE3, val);
    }

    /**
     * �i�ڃR�[�h���擾����
     *
     * @return �i�ڃR�[�h
     */
    public String getStrHinmokuCD() {
        return (String) get(TBTHB2KMEI.CODE3);
    }

    /**
     * �i�ڔԍ���ݒ肷��
     *
     * @param val
     *            �i�ڔԍ�
     */
    public void setHINNO(BigDecimal val) {
        set(HINNO, val);
    }

    /**
     * �i�ڔԍ����擾����
     *
     * @return �i�ڔԍ�
     */
    public BigDecimal getHINNO() {
        return (BigDecimal) get(HINNO);
    }

    /**
     * �Ǘ��敪��ݒ肷��
     *
     * @param val
     *            �Ǘ��敪
     */
    public void setStrKanriKBN(String val) {
        set(TBTHB2KMEI.KBN2, val);
    }

    /**
     * �Ǘ��敪���擾����
     *
     * @return �Ǘ��敪
     */
    public String getStrKanriKBN() {
        return (String) get(TBTHB2KMEI.KBN2);
    }

    /**
     * �z���䗦��ݒ肷��
     *
     * @param val
     *            �z���䗦
     */
    public void setIntHaibunHiritsu(BigDecimal val) {
        set(TBTHB2KMEI.RITU1, val);
    }

    /**
     * �z���䗦���擾����
     *
     * @return �z���䗦
     */
    public BigDecimal getIntHaibunHiritsu() {
        return (BigDecimal) get(TBTHB2KMEI.RITU1);
    }

    /**
     * �z�t�z��ݒ肷��
     *
     * @param val
     *            �z�t�z
     */
    public void setCurHaifugaku(BigDecimal val) {
        set(TBTHB2KMEI.SEIGAK, val);
    }

    /**
     * �z�t�z���擾����
     *
     * @return �z�t�z
     */
    public BigDecimal getCurHaifugaku() {
        return (BigDecimal) get(TBTHB2KMEI.SEIGAK);
    }

    /**
     * �T�C�g��ݒ肷��
     *
     * @param val
     *            �T�C�g
     */
    public void setStrSite(String val) {
        set(TBTHB2KMEI.CODE4, val);
    }

    /**
     * �T�C�g���擾����
     *
     * @return �T�C�g
     */
    public String getStrSite() {
        return (String) get(TBTHB2KMEI.CODE4);
    }

    /**
     * ���l��ݒ肷��
     *
     * @param val
     *            ���l
     */
    public void setStrBiko(String val) {
        set(TBTHB2KMEI.NAME8, val);
    }

    /**
     * ���l���擾����
     *
     * @return ���l
     */
    public String getStrBiko() {
        return (String) get(TBTHB2KMEI.NAME8);
    }

}

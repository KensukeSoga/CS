package jp.co.isid.kkh.customer.tkd.model.report;

import java.math.BigDecimal;

import jp.co.isid.kkh.integ.tbl.TBTHB2KMEI;
import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * ���c�������ׁi�i�ڕʁj�擾VO
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/01/23 JSE Hitoshi Sasaki)<BR>
 * </P>
 *
 * @author JSE Hitoshi Sasaki
 */
public class ReportTkdBillingByItemVO extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /** SQL�ԍ� */
    public static final String SQLNO = "SQLNO";

    /** �T�C�g */
    public static final String SITE = "SITE";

    /** �}�̒����ޔԍ� */
    public static final String CYBNO = "CYBNO";

    /** �i�ڔԍ� */
    public static final String HNMKCD = "HNMKCD";

    /** �Ǘ��敪 */
    public static final String KNRKBN = "KNRKBN";

    /** �t�B�[�R�[�h */
    public static final String FEECD = "FEECD";

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     */
    public ReportTkdBillingByItemVO() {
    }

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     *
     * @return �V�K�C���X�^���X
     */
    public Object newInstance() {
        return new ReportTkdBillingByItemVO();
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
     * �T�C�g��ݒ肷��
     *
     * @param val
     *            �T�C�g
     */
    public void setSITE(String val) {
        set(SITE, val);
    }

    /**
     * �T�C�g���擾����
     *
     * @return �T�C�g
     */
    public String getSITE() {
        return (String) get(SITE);
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
    public void setHNMKCD(BigDecimal val) {
        set(HNMKCD, val);
    }

    /**
     * �i�ڔԍ����擾����
     *
     * @return �i�ڔԍ�
     */
    public BigDecimal getHNMKCD() {
        return (BigDecimal) get(HNMKCD);
    }

    /**
     * �Ǘ��敪��ݒ肷��
     *
     * @param val
     *            �Ǘ��敪
     */
    public void setKNRKBN(String val) {
        set(KNRKBN, val);
    }

    /**
     * �Ǘ��敪���擾����
     *
     * @return �Ǘ��敪
     */
    public String getKNRKBN() {
        return (String) get(KNRKBN);
    }

    /**
     * ���z��ݒ肷��
     *
     * @param val
     *            ���z
     */
    public void setCurKingaku(BigDecimal val) {
        set(TBTHB2KMEI.SEIGAK, val);
    }

    /**
     * ���z���擾����
     *
     * @return ���z
     */
    public BigDecimal getCurKingaku() {
        return (BigDecimal) get(TBTHB2KMEI.SEIGAK);
    }

    /**
     * �t�B�[�R�[�h��ݒ肷��
     *
     * @param val
     *            �t�B�[�R�[�h
     */
    public void setFEECD(String val) {
        set(FEECD, val);
    }

    /**
     * �t�B�[�R�[�h���擾����
     *
     * @return �t�B�[�R�[�h
     */
    public String getFEECD() {
        return (String) get(FEECD);
    }

}

package jp.co.isid.kkh.customer.skyp.model.report;

import java.math.BigDecimal;

import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * ���[�i�X�J�p�[_�[�i�^�������j�f�[�^VO
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/1/16 JSE Y.Sato)<BR>
 * </P>
 *
 * @author JSE Y.Sato
 */
public class ReportSkypVO extends AbstractModel {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
     * �V�K�C���X�^���X���\�z���܂��B
     */
    public ReportSkypVO() {
    }

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     *
     * @return �V�K�C���X�^���X
     */
    public Object newInstance() {
        return new ReportSkypVO();
    }

    /**
     * �}�̋敪��ݒ肵�܂��B
     *
     * @param val
     *            String �}�̋敪
     */
    public void setBaitaiKbn(String val) {
        set("BAITAI_KBN", val);
    }

    /**
     * �}�̋敪��Ԃ��܂��B
     *
     * @return String �}�̋敪
     */
    public String getBaitaiKbn() {
        return (String) get("BAITAI_KBN");
    }

    /**
     * �}�̖��̂�ݒ肵�܂��B
     *
     * @param val
     *            String �}�̖���
     */
    public void setBaitaiMeisyo(String val) {
        set("BAITAI_MEISYO", val);
    }

    /**
     * �}�̖��̂�Ԃ��܂��B
     *
     * @return String �}�̖���
     */
    public String getBaitaiMeisyo() {
        return (String) get("BAITAI_MEISYO");
    }

    /**
     * ���s���Ԃ�ݒ肵�܂��B
     *
     * @param val
     *            String ���s����
     */
    public void setHakkoKikan(String val) {
        set("HAKKO_KIKAN", val);
    }

    /**
     * ���s���Ԃ�Ԃ��܂��B
     *
     * @return String ���s����
     */
    public String getHakkoKikan() {
        return (String) get("HAKKO_KIKAN");
    }

    /**
     * ���z��ݒ肵�܂��B
     *
     * @param val
     *            BigDecimal ���z
     */
    public void setKingaku(BigDecimal val) {
        set("KINGAKU", val);
    }

    /**
     * ���z��Ԃ��܂��B
     *
     * @return BigDecimal ���z
     */
    public BigDecimal getKingaku() {
        return (BigDecimal) get("KINGAKU");
    }

    /**
     * ����Ŋz��ݒ肵�܂��B
     *
     * @param val
     *            BigDecimal ����Ŋz
     */
    public void setSyohizeiGaku(BigDecimal val) {
        set("SYOHIZEIGAKU", val);
    }

    /**
     * ����Ŋz��Ԃ��܂��B
     *
     * @return BigDecimal ����Ŋz
     */
    public BigDecimal getSyohizeiGaku() {
        return (BigDecimal) get("SYOHIZEIGAKU");
    }

    /**
     * �������z��ݒ肵�܂��B
     *
     * @param val
     *            BigDecimal �������z
     */
    public void setSeikyuKingaku(BigDecimal val) {
        set("SEIKYU_KINGAKU", val);
    }

    /**
     * �������z��Ԃ��܂��B
     *
     * @return BigDecimal �������z
     */
    public BigDecimal getSeikyuKingaku() {
        return (BigDecimal) get("SEIKYU_KINGAKU");
    }

    /**
     * ���я���ݒ肵�܂��B
     *
     * @param val
     *            String ���я�
     */
    public void setNarabiJun(String val) {
        set("NARABI_JUN", val);
    }

    /**
     * ���я���Ԃ��܂��B
     *
     * @return String ���я�
     */
    public String getNarabiJun() {
        return (String) get("NARABI_JUN");
    }
}
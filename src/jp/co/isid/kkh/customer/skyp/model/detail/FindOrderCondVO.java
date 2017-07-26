package jp.co.isid.kkh.customer.skyp.model.detail;

import java.math.BigDecimal;

import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * ���я����VO
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2011/12/21 JSE Y.Sato)<BR>
 * </P>
 *
 * @author JSE Y.Sato
 */
public class FindOrderCondVO extends AbstractModel {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
     * �V�K�C���X�^���X���\�z���܂��B
     */
    public FindOrderCondVO() {
    }

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     *
     * @return �V�K�C���X�^���X
     */
    public Object newInstance() {
        return new FindOrderCondVO();
    }

    /**
     * �}�̋敪��ݒ肵�܂��B
     *
     * @param val
     *            String �}�̋敪
     */
    public void setBaitaiKbn(String val) {
        set(FindOrderByCondDAO.BAITAI_KBN, val);
    }

    /**
     * �}�̋敪��Ԃ��܂��B
     *
     * @return String �}�̋敪
     */
    public String getBaitaiKbn() {
        return (String) get(FindOrderByCondDAO.BAITAI_KBN);
    }

    /**
     * �}�̖��̂�ݒ肵�܂��B
     *
     * @param val
     *            String �}�̖���
     */
    public void setBaitaiMeisyo(String val) {
        set(FindOrderByCondDAO.BAITAI_MEISYO, val);
    }

    /**
     * �}�̖��̂�Ԃ��܂��B
     *
     * @return String �}�̖���
     */
    public String getBaitaiMeisyo() {
        return (String) get(FindOrderByCondDAO.BAITAI_MEISYO);
    }

    /**
     * ���s���Ԃ�ݒ肵�܂��B
     *
     * @param val
     *            String ���s����
     */
    public void setHakkoKikan(String val) {
        set(FindOrderByCondDAO.HAKKO_KIKAN, val);
    }

    /**
     * ���s���Ԃ�Ԃ��܂��B
     *
     * @return String ���s����
     */
    public String getHakkoKikan() {
        return (String) get(FindOrderByCondDAO.HAKKO_KIKAN);
    }

    /**
     * ���z��ݒ肵�܂��B
     *
     * @param val
     *            BigDecimal ���z
     */
    public void setKingaku(BigDecimal val) {
        set(FindOrderByCondDAO.KINGAKU, val);
    }

    /**
     * ���z��Ԃ��܂��B
     *
     * @return BigDecimal ���z
     */
    public BigDecimal getKingaku() {
        return (BigDecimal) get(FindOrderByCondDAO.KINGAKU);
    }

    /**
     * ����Ŋz��ݒ肵�܂��B
     *
     * @param val
     *            BigDecimal ����Ŋz
     */
    public void setSyohizeiGaku(BigDecimal val) {
        set(FindOrderByCondDAO.SYOHIZEIGAKU, val);
    }

    /**
     * ����Ŋz��Ԃ��܂��B
     *
     * @return BigDecimal ����Ŋz
     */
    public BigDecimal getSyohizeiGaku() {
        return (BigDecimal) get(FindOrderByCondDAO.SYOHIZEIGAKU);
    }

    /**
     * �������z��ݒ肵�܂��B
     *
     * @param val
     *            BigDecimal �������z
     */
    public void setSeikyuKingaku(BigDecimal val) {
        set(FindOrderByCondDAO.SEIKYU_KINGAKU, val);
    }

    /**
     * �������z��Ԃ��܂��B
     *
     * @return BigDecimal �������z
     */
    public BigDecimal getSeikyuKingaku() {
        return (BigDecimal) get(FindOrderByCondDAO.SEIKYU_KINGAKU);
    }

    /**
     * ���я���ݒ肵�܂��B
     *
     * @param val
     *            String ���я�
     */
    public void setNarabiJun(String val) {
        set(FindOrderByCondDAO.NARABI_JUN, val);
    }

    /**
     * ���я���Ԃ��܂��B
     *
     * @return String ���я�
     */
    public String getNarabiJun() {
        return (String) get(FindOrderByCondDAO.NARABI_JUN);
    }


}
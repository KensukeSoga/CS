package jp.co.isid.kkh.customer.skyp.model.detail;

import java.math.BigDecimal;

import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * 並び順情報VO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2011/12/21 JSE Y.Sato)<BR>
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
     * 新規インスタンスを構築します。
     */
    public FindOrderCondVO() {
    }

    /**
     * 新規インスタンスを構築します。
     *
     * @return 新規インスタンス
     */
    public Object newInstance() {
        return new FindOrderCondVO();
    }

    /**
     * 媒体区分を設定します。
     *
     * @param val
     *            String 媒体区分
     */
    public void setBaitaiKbn(String val) {
        set(FindOrderByCondDAO.BAITAI_KBN, val);
    }

    /**
     * 媒体区分を返します。
     *
     * @return String 媒体区分
     */
    public String getBaitaiKbn() {
        return (String) get(FindOrderByCondDAO.BAITAI_KBN);
    }

    /**
     * 媒体名称を設定します。
     *
     * @param val
     *            String 媒体名称
     */
    public void setBaitaiMeisyo(String val) {
        set(FindOrderByCondDAO.BAITAI_MEISYO, val);
    }

    /**
     * 媒体名称を返します。
     *
     * @return String 媒体名称
     */
    public String getBaitaiMeisyo() {
        return (String) get(FindOrderByCondDAO.BAITAI_MEISYO);
    }

    /**
     * 発行期間を設定します。
     *
     * @param val
     *            String 発行期間
     */
    public void setHakkoKikan(String val) {
        set(FindOrderByCondDAO.HAKKO_KIKAN, val);
    }

    /**
     * 発行期間を返します。
     *
     * @return String 発行期間
     */
    public String getHakkoKikan() {
        return (String) get(FindOrderByCondDAO.HAKKO_KIKAN);
    }

    /**
     * 金額を設定します。
     *
     * @param val
     *            BigDecimal 金額
     */
    public void setKingaku(BigDecimal val) {
        set(FindOrderByCondDAO.KINGAKU, val);
    }

    /**
     * 金額を返します。
     *
     * @return BigDecimal 金額
     */
    public BigDecimal getKingaku() {
        return (BigDecimal) get(FindOrderByCondDAO.KINGAKU);
    }

    /**
     * 消費税額を設定します。
     *
     * @param val
     *            BigDecimal 消費税額
     */
    public void setSyohizeiGaku(BigDecimal val) {
        set(FindOrderByCondDAO.SYOHIZEIGAKU, val);
    }

    /**
     * 消費税額を返します。
     *
     * @return BigDecimal 消費税額
     */
    public BigDecimal getSyohizeiGaku() {
        return (BigDecimal) get(FindOrderByCondDAO.SYOHIZEIGAKU);
    }

    /**
     * 請求金額を設定します。
     *
     * @param val
     *            BigDecimal 請求金額
     */
    public void setSeikyuKingaku(BigDecimal val) {
        set(FindOrderByCondDAO.SEIKYU_KINGAKU, val);
    }

    /**
     * 請求金額を返します。
     *
     * @return BigDecimal 請求金額
     */
    public BigDecimal getSeikyuKingaku() {
        return (BigDecimal) get(FindOrderByCondDAO.SEIKYU_KINGAKU);
    }

    /**
     * 並び順を設定します。
     *
     * @param val
     *            String 並び順
     */
    public void setNarabiJun(String val) {
        set(FindOrderByCondDAO.NARABI_JUN, val);
    }

    /**
     * 並び順を返します。
     *
     * @return String 並び順
     */
    public String getNarabiJun() {
        return (String) get(FindOrderByCondDAO.NARABI_JUN);
    }


}
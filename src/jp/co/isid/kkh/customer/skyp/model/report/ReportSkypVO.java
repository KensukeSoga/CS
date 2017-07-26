package jp.co.isid.kkh.customer.skyp.model.report;

import java.math.BigDecimal;

import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * 帳票（スカパー_納品／請求書）データVO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/1/16 JSE Y.Sato)<BR>
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
     * 新規インスタンスを構築します。
     */
    public ReportSkypVO() {
    }

    /**
     * 新規インスタンスを構築します。
     *
     * @return 新規インスタンス
     */
    public Object newInstance() {
        return new ReportSkypVO();
    }

    /**
     * 媒体区分を設定します。
     *
     * @param val
     *            String 媒体区分
     */
    public void setBaitaiKbn(String val) {
        set("BAITAI_KBN", val);
    }

    /**
     * 媒体区分を返します。
     *
     * @return String 媒体区分
     */
    public String getBaitaiKbn() {
        return (String) get("BAITAI_KBN");
    }

    /**
     * 媒体名称を設定します。
     *
     * @param val
     *            String 媒体名称
     */
    public void setBaitaiMeisyo(String val) {
        set("BAITAI_MEISYO", val);
    }

    /**
     * 媒体名称を返します。
     *
     * @return String 媒体名称
     */
    public String getBaitaiMeisyo() {
        return (String) get("BAITAI_MEISYO");
    }

    /**
     * 発行期間を設定します。
     *
     * @param val
     *            String 発行期間
     */
    public void setHakkoKikan(String val) {
        set("HAKKO_KIKAN", val);
    }

    /**
     * 発行期間を返します。
     *
     * @return String 発行期間
     */
    public String getHakkoKikan() {
        return (String) get("HAKKO_KIKAN");
    }

    /**
     * 金額を設定します。
     *
     * @param val
     *            BigDecimal 金額
     */
    public void setKingaku(BigDecimal val) {
        set("KINGAKU", val);
    }

    /**
     * 金額を返します。
     *
     * @return BigDecimal 金額
     */
    public BigDecimal getKingaku() {
        return (BigDecimal) get("KINGAKU");
    }

    /**
     * 消費税額を設定します。
     *
     * @param val
     *            BigDecimal 消費税額
     */
    public void setSyohizeiGaku(BigDecimal val) {
        set("SYOHIZEIGAKU", val);
    }

    /**
     * 消費税額を返します。
     *
     * @return BigDecimal 消費税額
     */
    public BigDecimal getSyohizeiGaku() {
        return (BigDecimal) get("SYOHIZEIGAKU");
    }

    /**
     * 請求金額を設定します。
     *
     * @param val
     *            BigDecimal 請求金額
     */
    public void setSeikyuKingaku(BigDecimal val) {
        set("SEIKYU_KINGAKU", val);
    }

    /**
     * 請求金額を返します。
     *
     * @return BigDecimal 請求金額
     */
    public BigDecimal getSeikyuKingaku() {
        return (BigDecimal) get("SEIKYU_KINGAKU");
    }

    /**
     * 並び順を設定します。
     *
     * @param val
     *            String 並び順
     */
    public void setNarabiJun(String val) {
        set("NARABI_JUN", val);
    }

    /**
     * 並び順を返します。
     *
     * @return String 並び順
     */
    public String getNarabiJun() {
        return (String) get("NARABI_JUN");
    }
}
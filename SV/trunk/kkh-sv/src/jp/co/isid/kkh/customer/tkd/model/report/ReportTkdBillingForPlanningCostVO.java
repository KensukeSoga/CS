package jp.co.isid.kkh.customer.tkd.model.report;

import java.math.BigDecimal;

import jp.co.isid.kkh.integ.tbl.TBTHB1DOWN;
import jp.co.isid.kkh.integ.tbl.TBTHB2KMEI;
import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * 武田請求明細（企画費）取得VO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/01/23 JSE Hitoshi Sasaki)<BR>
 * </P>
 *
 * @author JSE Hitoshi Sasaki
 */
public class ReportTkdBillingForPlanningCostVO extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /** 品目コード */
    public static final String SCD = "SCD";

    /** 品目名 */
    public static final String SNM = "SNM";

    /** ツール名 */
    public static final String TEKIYO = "TEKIYO";

    /** 区分 */
    public static final String KBN = "KBN";

    /**
     * 新規インスタンスを構築します。
     */
    public ReportTkdBillingForPlanningCostVO() {
    }

    /**
     * 新規インスタンスを構築します。
     *
     * @return 新規インスタンス
     */
    public Object newInstance() {
        return new ReportTkdBillingForPlanningCostVO();
    }

    /**
     * JYUT番号を設定する
     *
     * @param val
     *            JYUT番号
     */
    public void setJYUTNO(String val) {
        set(TBTHB2KMEI.JYUTNO, val);
    }

    /**
     * JYUT番号を取得する
     *
     * @return JYUT番号
     */
    public String getJYUTNO() {
        return (String) get(TBTHB2KMEI.JYUTNO);
    }

    /**
     * JYMEI番号を設定する
     *
     * @param val
     *            JYMEI番号
     */
    public void setJYMEINO(String val) {
        set(TBTHB2KMEI.JYMEINO, val);
    }

    /**
     * JYMEI番号を取得する
     *
     * @return JYMEI番号
     */
    public String getJYMEINO() {
        return (String) get(TBTHB2KMEI.JYMEINO);
    }

    /**
     * URMEI番号を設定する
     *
     * @param val
     *            URMEI番号
     */
    public void setURMEINO(String val) {
        set(TBTHB2KMEI.URMEINO, val);
    }

    /**
     * URMEI番号を取得する
     *
     * @return URMEI番号
     */
    public String getURMEINO() {
        return (String) get(TBTHB2KMEI.URMEINO);
    }

    /**
     * 金額を設定する
     *
     * @param val
     *            金額
     */
    public void setKNGK1(BigDecimal val) {
        set(TBTHB2KMEI.KNGK1, val);
    }

    /**
     * 金額を取得する
     *
     * @return 金額
     */
    public BigDecimal getKNGK1() {
        return (BigDecimal) get(TBTHB2KMEI.KNGK1);
    }

    /**
     * 品目コードを設定する
     *
     * @param val
     *            品目コード
     */
    public void setSCD(String val) {
        set(SCD, val);
    }

    /**
     * 品目コードを取得する
     *
     * @return 品目コード
     */
    public String getSCD() {
        return (String) get(SCD);
    }

    /**
     * 品目名を設定する
     *
     * @param val
     *            品目名
     */
    public void setSNM(String val) {
        set(SNM, val);
    }

    /**
     * 品目名を取得する
     *
     * @return 品目名
     */
    public String getSNM() {
        return (String) get(SNM);
    }

    /**
     * ツール名を設定する
     *
     * @param val
     *            ツール名
     */
    public void setTEKIYO(String val) {
        set(TEKIYO, val);
    }

    /**
     * ツール名を取得する
     *
     * @return ツール名
     */
    public String getTEKIYO() {
        return (String) get(TEKIYO);
    }

    /**
     * 区分を設定する
     *
     * @param val
     *            区分
     */
    public void setKBN(String val) {
        set(KBN, val);
    }

    /**
     * 区分を取得する
     *
     * @return 区分
     */
    public String getKBN() {
        return (String) get(KBN);
    }

    /**
     * 本体額を設定する
     *
     * @param val
     *            本体額
     */
    public void setSEIGAK(BigDecimal val) {
        set(TBTHB2KMEI.SEIGAK, val);
    }

    /**
     * 本体額を取得する
     *
     * @return 本体額
     */
    public BigDecimal getSEIGAK() {
        return (BigDecimal) get(TBTHB2KMEI.SEIGAK);
    }

    /**
     * 消費税率を設定する
     *
     * @param val
     *            消費税率
     */
    public void setSZEIRITU(BigDecimal val) {
        set(TBTHB1DOWN.SZEIRITU, val);
    }

    /**
     * 消費税率を取得する
     *
     * @return 消費税率
     */
    public BigDecimal getSZEIRITU() {
        return (BigDecimal) get(TBTHB1DOWN.SZEIRITU);
    }

}

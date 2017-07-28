package jp.co.isid.kkh.customer.ash.model.report;

import java.math.BigDecimal;

import jp.co.isid.kkh.integ.tbl.TBTHB2KMEI;
import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * 広告費明細書（Ash）タイム明細金額VO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/1/23 fourm h.izawa)<BR>
 * </P>
 * @author
 */
public class ReportAshTvAndRadioKingakVO extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /**
     * 新規インスタンスを構築します。
     */
    public ReportAshTvAndRadioKingakVO() {
    }

    /**
     * 新規インスタンスを構築します。
     *
     * @return 新規インスタンス
     */
    public Object newInstance() {
        return new ReportAshTvAndRadioKingakVO();
    }

    /**
     * 受注NOを設定します。
     * @param val String 受注NO
     */
    public void setJyutNo(String val) {
        set(TBTHB2KMEI.JYUTNO, val);
    }

    /**
     * 受注NOを取得します
     * @return 受注NO
     */
    public String getJyutNo() {
        return (String) get(TBTHB2KMEI.JYUTNO);
    }

    /**
     * 受注明細NOを設定します。
     * @param val Strng 受注明細NO
     */
    public void setJyMeiNo(String val) {
        set(TBTHB2KMEI.JYMEINO, val);
    }

    /**
     * 受注明細NOを取得します。
     * @return 受注明細NO
     */
    public String getJyMeiNo() {
        return (String) get(TBTHB2KMEI.JYMEINO);
    }

    /**
     * 売上明細NOを設定します。
     * @param val String
     */
    public void setUrMeiNo(String val) {
        set(TBTHB2KMEI.URMEINO, val);
    }

    /**
     * 売上明細NOを取得します
     * @return 売上明細NO
     */
    public String getUrMeiNo() {
        return (String) get(TBTHB2KMEI.URMEINO);
    }

    /**
     * 品種コードを設定します。
     * @param val String 品種コード
     */
    public void setHinsyuCD(String val) {
        set("HINSYUCD", val);
    }

    /**
     * 品種コードを取得します。
     * @return 品種コード
     */
    public String getHinsyuCD() {
        return (String) get("HINSYUCD");
    }

    /**
     * 媒体コードを設定します。
     * @param val String 媒体コード
     */
    public void setBaitaiCD(String val) {
        set("BAITAICD", val);
    }

    /**
     * 媒体コードを取得します
     * @return 媒体コード
     */
    public String getBaitaiCD() {
        return (String) get("BAITAICD");
    }

    /**
     * 請求金額を設定します。
     * @param val BigDecimal 請求金額
     */
    public void setSeiGak(BigDecimal val) {
        set("SEIGAK", val);
    }

    /**
     * 請求金額を取得します。
     * @return 請求金額
     */
    public BigDecimal getSeiGak() {
        return (BigDecimal) get("SEIGAK");
    }

}

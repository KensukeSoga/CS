package jp.co.isid.kkh.customer.tkd.model.report;

import java.math.BigDecimal;

import jp.co.isid.kkh.integ.tbl.TBTHB2KMEI;
import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * 武田請求明細（品目別）取得VO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/01/23 JSE Hitoshi Sasaki)<BR>
 * </P>
 *
 * @author JSE Hitoshi Sasaki
 */
public class ReportTkdBillingByItemVO extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /** SQL番号 */
    public static final String SQLNO = "SQLNO";

    /** サイト */
    public static final String SITE = "SITE";

    /** 媒体中分類番号 */
    public static final String CYBNO = "CYBNO";

    /** 品目番号 */
    public static final String HNMKCD = "HNMKCD";

    /** 管理区分 */
    public static final String KNRKBN = "KNRKBN";

    /** フィーコード */
    public static final String FEECD = "FEECD";

    /**
     * 新規インスタンスを構築します。
     */
    public ReportTkdBillingByItemVO() {
    }

    /**
     * 新規インスタンスを構築します。
     *
     * @return 新規インスタンス
     */
    public Object newInstance() {
        return new ReportTkdBillingByItemVO();
    }

    /**
     * SQL番号を設定する
     *
     * @param val
     *            SQL番号
     */
    public void setSQLNO(BigDecimal val) {
        set(SQLNO, val);
    }

    /**
     * SQL番号を取得する
     *
     * @return SQL番号
     */
    public BigDecimal getSQLNO() {
        return (BigDecimal) get(SQLNO);
    }

    /**
     * サイトを設定する
     *
     * @param val
     *            サイト
     */
    public void setSITE(String val) {
        set(SITE, val);
    }

    /**
     * サイトを取得する
     *
     * @return サイト
     */
    public String getSITE() {
        return (String) get(SITE);
    }

    /**
     * 代理店コードを設定する
     *
     * @param val
     *            代理店コード
     */
    public void setStrDairitenCD(String val) {
        set(TBTHB2KMEI.CODE1, val);
    }

    /**
     * 代理店コードを取得する
     *
     * @return 代理店コード
     */
    public String getStrDairitenCD() {
        return (String) get(TBTHB2KMEI.CODE1);
    }

    /**
     * 実施年月を設定する
     *
     * @param val
     *            実施年月
     */
    public void setStrYM(String val) {
        set(TBTHB2KMEI.DATE1, val);
    }

    /**
     * 実施年月を取得する
     *
     * @return 実施年月
     */
    public String getStrYM() {
        return (String) get(TBTHB2KMEI.DATE1);
    }

    /**
     * 媒体中分類コードを設定する
     *
     * @param val
     *            媒体中分類コード
     */
    public void setStrCYBNCD(String val) {
        set(TBTHB2KMEI.CODE5, val);
    }

    /**
     * 媒体中分類コードを取得する
     *
     * @return 媒体中分類コード
     */
    public String getStrCYBNCD() {
        return (String) get(TBTHB2KMEI.CODE5);
    }

    /**
     * 媒体中分類番号を設定する
     *
     * @param val
     *            媒体中分類番号
     */
    public void setCYBNO(BigDecimal val) {
        set(CYBNO, val);
    }

    /**
     * 媒体中分類番号を取得する
     *
     * @return 媒体中分類番号
     */
    public BigDecimal getCYBNO() {
        return (BigDecimal) get(CYBNO);
    }

    /**
     * 媒体中分類名を設定する
     *
     * @param val
     *            媒体中分類名
     */
    public void setStrCYBNNM(String val) {
        set(TBTHB2KMEI.NAME4, val);
    }

    /**
     * 媒体中分類名を取得する
     *
     * @return 媒体中分類名
     */
    public String getStrCYBNNM() {
        return (String) get(TBTHB2KMEI.NAME4);
    }

    /**
     * 品目名を設定する
     *
     * @param val
     *            品目名
     */
    public void setStrHinmokuNM(String val) {
        set(TBTHB2KMEI.NAME2, val);
    }

    /**
     * 品目名を取得する
     *
     * @return 品目名
     */
    public String getStrHinmokuNM() {
        return (String) get(TBTHB2KMEI.NAME2);
    }

    /**
     * 品目コードを設定する
     *
     * @param val
     *            品目コード
     */
    public void setStrHinmokuCD(String val) {
        set(TBTHB2KMEI.CODE3, val);
    }

    /**
     * 品目コードを取得する
     *
     * @return 品目コード
     */
    public String getStrHinmokuCD() {
        return (String) get(TBTHB2KMEI.CODE3);
    }

    /**
     * 品目番号を設定する
     *
     * @param val
     *            品目番号
     */
    public void setHNMKCD(BigDecimal val) {
        set(HNMKCD, val);
    }

    /**
     * 品目番号を取得する
     *
     * @return 品目番号
     */
    public BigDecimal getHNMKCD() {
        return (BigDecimal) get(HNMKCD);
    }

    /**
     * 管理区分を設定する
     *
     * @param val
     *            管理区分
     */
    public void setKNRKBN(String val) {
        set(KNRKBN, val);
    }

    /**
     * 管理区分を取得する
     *
     * @return 管理区分
     */
    public String getKNRKBN() {
        return (String) get(KNRKBN);
    }

    /**
     * 金額を設定する
     *
     * @param val
     *            金額
     */
    public void setCurKingaku(BigDecimal val) {
        set(TBTHB2KMEI.SEIGAK, val);
    }

    /**
     * 金額を取得する
     *
     * @return 金額
     */
    public BigDecimal getCurKingaku() {
        return (BigDecimal) get(TBTHB2KMEI.SEIGAK);
    }

    /**
     * フィーコードを設定する
     *
     * @param val
     *            フィーコード
     */
    public void setFEECD(String val) {
        set(FEECD, val);
    }

    /**
     * フィーコードを取得する
     *
     * @return フィーコード
     */
    public String getFEECD() {
        return (String) get(FEECD);
    }

}

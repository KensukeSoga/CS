package jp.co.isid.kkh.customer.tkd.model.report;

import java.math.BigDecimal;

import jp.co.isid.kkh.integ.tbl.TBTHB2KMEI;
import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * 武田請求明細（中分類別）取得VO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/01/23 JSE Hitoshi Sasaki)<BR>
 * </P>
 *
 * @author JSE Hitoshi Sasaki
 */
public class ReportTkdBillingByMiddleClassificationVO extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /** SQL番号 */
    public static final String SQLNO = "SQLNO";

    /** 媒体中分類番号 */
    public static final String CYBNO = "CYBNO";

    /** 個別媒体番号 */
    public static final String BAINO = "BAINO";

    /** 一連番号 */
    public static final String RENNO = "RENNO";

    /** 品目番号 */
    public static final String HINNO = "HINNO";

    /**
     * 新規インスタンスを構築します。
     */
    public ReportTkdBillingByMiddleClassificationVO() {
    }

    /**
     * 新規インスタンスを構築します。
     *
     * @return 新規インスタンス
     */
    public Object newInstance() {
        return new ReportTkdBillingByMiddleClassificationVO();
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
     * 個別媒体名を設定する
     *
     * @param val
     *            個別媒体名
     */
    public void setStrKBTNM(String val) {
        set(TBTHB2KMEI.NAME10, val);
    }

    /**
     * 個別媒体名を取得する
     *
     * @return 個別媒体名
     */
    public String getStrKBTNM() {
        return (String) get(TBTHB2KMEI.NAME10);
    }

    /**
     * 個別媒体コードを設定する
     *
     * @param val
     *            個別媒体コード
     */
    public void setStrKBTCD(String val) {
        set(TBTHB2KMEI.CODE2, val);
    }

    /**
     * 個別媒体コードを取得する
     *
     * @return 個別媒体コード
     */
    public String getStrKBTCD() {
        return (String) get(TBTHB2KMEI.CODE2);
    }

    /**
     * 個別媒体番号を設定する
     *
     * @param val
     *            個別媒体番号
     */
    public void setBAINO(BigDecimal val) {
        set(BAINO, val);
    }

    /**
     * 個別媒体番号を取得する
     *
     * @return 個別媒体番号
     */
    public BigDecimal getBAINO() {
        return (BigDecimal) get(BAINO);
    }

    /**
     * 一連番号を設定する
     *
     * @param val
     *            一連番号
     */
    public void setRENNO(String val) {
        set(RENNO, val);
    }

    /**
     * 一連番号を取得する
     *
     * @return 一連番号
     */
    public String getRENNO() {
        return (String) get(RENNO);
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
    public void setHINNO(BigDecimal val) {
        set(HINNO, val);
    }

    /**
     * 品目番号を取得する
     *
     * @return 品目番号
     */
    public BigDecimal getHINNO() {
        return (BigDecimal) get(HINNO);
    }

    /**
     * 管理区分を設定する
     *
     * @param val
     *            管理区分
     */
    public void setStrKanriKBN(String val) {
        set(TBTHB2KMEI.KBN2, val);
    }

    /**
     * 管理区分を取得する
     *
     * @return 管理区分
     */
    public String getStrKanriKBN() {
        return (String) get(TBTHB2KMEI.KBN2);
    }

    /**
     * 配分比率を設定する
     *
     * @param val
     *            配分比率
     */
    public void setIntHaibunHiritsu(BigDecimal val) {
        set(TBTHB2KMEI.RITU1, val);
    }

    /**
     * 配分比率を取得する
     *
     * @return 配分比率
     */
    public BigDecimal getIntHaibunHiritsu() {
        return (BigDecimal) get(TBTHB2KMEI.RITU1);
    }

    /**
     * 配付額を設定する
     *
     * @param val
     *            配付額
     */
    public void setCurHaifugaku(BigDecimal val) {
        set(TBTHB2KMEI.SEIGAK, val);
    }

    /**
     * 配付額を取得する
     *
     * @return 配付額
     */
    public BigDecimal getCurHaifugaku() {
        return (BigDecimal) get(TBTHB2KMEI.SEIGAK);
    }

    /**
     * サイトを設定する
     *
     * @param val
     *            サイト
     */
    public void setStrSite(String val) {
        set(TBTHB2KMEI.CODE4, val);
    }

    /**
     * サイトを取得する
     *
     * @return サイト
     */
    public String getStrSite() {
        return (String) get(TBTHB2KMEI.CODE4);
    }

    /**
     * 備考を設定する
     *
     * @param val
     *            備考
     */
    public void setStrBiko(String val) {
        set(TBTHB2KMEI.NAME8, val);
    }

    /**
     * 備考を取得する
     *
     * @return 備考
     */
    public String getStrBiko() {
        return (String) get(TBTHB2KMEI.NAME8);
    }

}

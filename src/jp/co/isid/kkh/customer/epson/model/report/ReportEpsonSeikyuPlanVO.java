package jp.co.isid.kkh.customer.epson.model.report;

import java.math.BigDecimal;

import jp.co.isid.kkh.integ.tbl.TBTHB2KMEI;
import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * 請求予定一覧（エプソン)VO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/3/9 IP JK)<BR>
 * </P>
 * @author
 */
public class ReportEpsonSeikyuPlanVO extends AbstractModel {

    /** */
    private static final long serialVersionUID = 1L;

    /**
     * 新規インスタンスを構築します。
     */
    public ReportEpsonSeikyuPlanVO() {
    }

    /**
     * 新規インスタンスを構築します。
     *
     * @return 新規インスタンス
     */
    public Object newInstance() {
        return new ReportEpsonSeikyuPlanVO();
    }

    /**
     * 先頭列を取得する
     * @return 先頭列
     */
    public String getFirstCol() {
        return (String) get("FIRSTCOL");
    }

    /**
     * 先頭列を設定する
     * @param val 先頭列
     */
    public void setFirstCol(String val) {
        set("FIRSTCOL", val);
    }

    // 2015/04/06 エプソン件名拡張対応 Fujisaki Cng Start
//    /**
//     * 広告件名を取得する
//     * @return 広告件名
//     */
//    public String getNAME8() {
//        return (String) get(TBTHB2KMEI.NAME8);
//    }
//
//    /**
//     * 広告件名を設定する
//     * @param val 広告件名
//     */
//    public void setNAME8(String val) {
//        set(TBTHB2KMEI.NAME8, val);
//    }

    /**
     * 広告件名(拡張対応)を取得する
     * @return 広告件名(拡張対応)
     */
    public String getNAME11() {
        return (String) get(TBTHB2KMEI.NAME11);
    }

    /**
     * 広告件名(拡張対応)を設定する
     * @param val 広告件名(拡張対応)
     */
    public void setNAME11(String val) {
        set(TBTHB2KMEI.NAME11, val);
    }
    // 2015/04/06 エプソン件名拡張対応 Fujisaki Cng End

    /**
     * ご担当を取得する
     * @return ご担当
     */
    public String getNAME3() {
        return (String) get(TBTHB2KMEI.NAME3);
    }

    /**
     * ご担当を設定する
     * @param val ご担当
     */
    public void setNAME3(String val) {
        set(TBTHB2KMEI.NAME3, val);
    }

    /**
     * 件名を取得する
     * @return 件名
     */
    public String getNAME10() {
        return (String) get(TBTHB2KMEI.NAME10);
    }

    /**
     * 件名を設定する
     * @param val 件名
     */
    public void setNAME10(String val) {
        set(TBTHB2KMEI.NAME10, val);
    }

    /**
     * 取引識別コードを取得する
     * @return 取引識別コード
     */
    public String getCODE4() {
        return (String) get(TBTHB2KMEI.CODE4);
    }

    /**
     * 取引識別コードを設定する
     * @param val 取引識別コード
     */
    public void setCODE4(String val) {
        set(TBTHB2KMEI.CODE4, val);
    }

    /**
     * 事前を取得する
     * @return 事前
     */
    public BigDecimal getKNGK2() {
        return (BigDecimal) get(TBTHB2KMEI.KNGK2);
    }

    /**
     * 事前を設定する
     * @param val 事前
     */
    public void setKNGK2(BigDecimal val) {
        set(TBTHB2KMEI.KNGK2, val);
    }

    /**
     * 事後を取得する
     * @return 事後
     */
    public BigDecimal getSEIGAK() {
        return (BigDecimal) get(TBTHB2KMEI.SEIGAK);
    }

    /**
     * 事後を設定する
     * @param val 事後
     */
    public void setSEIGAK(BigDecimal val) {
        set(TBTHB2KMEI.SEIGAK, val);
    }

    /**
     * 最終列を取得する
     * @return 最終列
     */
    public String getLastCol() {
        return (String) get("LASTCOLN");
    }

    /**
     * 最終列を設定する
     * @param val 最終列
     */
    public void setLastCol(String val) {
        set("LASTCOLN", val);
    }

}
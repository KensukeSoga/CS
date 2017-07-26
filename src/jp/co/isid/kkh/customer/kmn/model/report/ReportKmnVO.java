package jp.co.isid.kkh.customer.kmn.model.report;

import java.math.BigDecimal;

import jp.co.isid.kkh.integ.tbl.TBTHB14SKDOWN;
import jp.co.isid.kkh.integ.tbl.TBTHB1DOWN;
import jp.co.isid.kkh.integ.tbl.TBTHB2KMEI;
import jp.co.isid.nj.model.AbstractModel;


/**
 * <P>
 * 帳票（公文_伝票）データVO
 *
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2013/01/30 JSE M.Naito)<BR>
 * </P>
 *
 * @author JSE M.Naito
 */
public class ReportKmnVO extends AbstractModel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * 新規インスタンスを構築します。
     */
    public ReportKmnVO() {
    }

    /**
     * 新規インスタンスを構築します。
     *
     * @return 新規インスタンス
     */
    public Object newInstance() {
        return new ReportKmnJyutyuVO();
    }

    /**
     * 受注Noを取得する
     * @return 受注No
     */
    public String getHb2JyutNo() {
        return (String) get(TBTHB2KMEI.JYUTNO);
    }

    /**
     * 受注Noを設定する
     * @param val 受注No
     */
    public void setHb2JyutNo(String val) {
        set(TBTHB2KMEI.JYUTNO, val);
    }

    /**
     * 受注明細Noを取得する
     * @return 受注明細No
     */
    public String getHb2JymeiNo() {
        return (String) get(TBTHB2KMEI.JYMEINO);
    }

    /**
     * 受注明細Noを設定する
     * @param val 受注明細No
     */
    public void setHb2JymeiNo(String val) {
        set(TBTHB2KMEI.JYMEINO, val);
    }

    /**
     * 売上明細Noを取得する
     * @return 売上明細No
     */
    public String getHb2UrmeiNo() {
        return (String) get(TBTHB2KMEI.URMEINO);
    }

    /**
     * 売上明細Noを設定する
     * @param val 売上明細No
     */
    public void setHb2UrmeiNo(String val) {
        set(TBTHB2KMEI.URMEINO, val);
    }

    /**
     * 部門コードを取得する
     * @return コード1
     */
    public String getHb2Code1() {
        return (String) get(TBTHB2KMEI.CODE1);
    }

    /**
     * 部門コードを設定する
     * @param val コード1
     */
    public void setHb2Code1(String val) {
        set(TBTHB2KMEI.CODE1, val);
    }

    /**
     * 出力Noを取得する
     * @return コード2
     */
    public String getHb2Code2() {
        return (String) get(TBTHB2KMEI.CODE2);
    }

    /**
     * 出力Noを設定する
     * @param val コード2
     */
    public void setHb2Code2(String val) {
        set(TBTHB2KMEI.CODE2, val);
    }

    /**
     * 品目１を取得する
     * @return 名称8(漢字)
     */
    public String getHb2Name8() {
        return (String) get(TBTHB2KMEI.NAME8);
    }

    /**
     * 品目１を設定する
     * @param val 名称8(漢字)
     */
    public void setHb2Name8(String val) {
        set(TBTHB2KMEI.NAME8, val);
    }

    /**
     * 品目２を取得する
     * @return 名称3(漢字)
     */
    public String getHb2Name3() {
        return (String) get(TBTHB2KMEI.NAME3);
    }

    /**
     * 品目２を設定する
     * @param val 名称3(漢字)
     */
    public void setHb2Name3(String val) {
        set(TBTHB2KMEI.NAME3, val);
    }

    /**
     * 品目３を取得する
     * @return 名称4(漢字)
     */
    public String getHb2Name4() {
        return (String) get(TBTHB2KMEI.NAME4);
    }

    /**
     * 品目３を設定する
     * @param val 名称4(漢字)
     */
    public void setHb2Name4(String val) {
        set(TBTHB2KMEI.NAME4, val);
    }

    /**
     * 部門略称を取得する
     * @return 名称5(漢字)
     */
    public String getHb2Name5() {
        return (String) get(TBTHB2KMEI.NAME5);
    }

    /**
     * 部門略称を設定する
     * @param val 名称5(漢字)
     */
    public void setHb2Name5(String val) {
        set(TBTHB2KMEI.NAME5, val);
    }

    /**
     * 宛先を取得する
     * @return 名称16(漢字)
     */
    public String getHb2Name16() {
        return (String) get(TBTHB2KMEI.NAME16);
    }

    /**
     * 宛先を設定する
     * @param val 名称16(漢字)
     */
    public void setHb2Name16(String val) {
        set(TBTHB2KMEI.NAME16, val);
    }

    /**
     * 合計消費税額を取得する
     * @return 金額3
     */
    public BigDecimal getHb2Kngk3() {
        return (BigDecimal) get(TBTHB2KMEI.KNGK3);
    }

    /**
     * 合計消費税額を設定する
     * @param val 金額3
     */
    public void setHb2Kngk3(BigDecimal val) {
        set(TBTHB2KMEI.KNGK3, val);
    }

    /**
     * 合計金額を取得する
     * @return 請求金額
     */
    public BigDecimal getHb2Seigak() {
        return (BigDecimal) get(TBTHB2KMEI.SEIGAK);
    }

    /**
     * 合計金額を設定する
     * @param val 請求金額
     */
    public void setHb2Seigak(BigDecimal val) {
        set(TBTHB2KMEI.SEIGAK, val);
    }

    /**
     * 年月を取得する
     * @return 年月
     */
    public String getHb2Yymm() {
        return (String) get(TBTHB2KMEI.YYMM);
    }

    /**
     * 年月を設定する
     * @param val 年月
     */
    public void setHb2Yymm(String val) {
        set(TBTHB2KMEI.YYMM, val);
    }

    /**
     * 請求年月を取得する
     * @return 請求年月
     */
    public String getHb2Name6() {
        return (String) get(TBTHB2KMEI.NAME6);
    }

    /**
     * 請求年月を設定する
     * @param val 請求年月
     */
    public void setHb2Name6(String val) {
        set(TBTHB2KMEI.NAME6, val);
    }

    /**
     * 受注Noを取得する
     * @return 受注No
     */
    public String getHb14JyutNo() {
        return (String) get(TBTHB14SKDOWN.JYUTNO);
    }

    /**
     * 受注Noを設定する
     * @param val 受注No
     */
    public void setHb14JyutNo(String val) {
        set(TBTHB14SKDOWN.JYUTNO, val);
    }

    /**
     * 親子フラグを取得する
     * @return 親子フラグ
     */
    public String getOyako() {
        return (String) get("OYAKOFLG");
    }

    /**
     * 親子フラグを設定する
     * @param val 親子フラグ
     */
    public void setOyako(String val) {
        set("OYAKOFLG", val);
    }

    /**
     * 受注Noを取得する
     * @return 受注No
     */
    public String getHb1JyutNo() {
        return (String) get(TBTHB1DOWN.JYUTNO);
    }

    /**
     * 受注Noを設定する
     * @param val 受注No
     */
    public void setHb1JyutNo(String val) {
        set(TBTHB1DOWN.JYUTNO, val);
    }

    /**
     * 統合先受注Noを取得する
     * @return 統合先受注No
     */
    public String getHb1TJyutNo() {
        return (String) get(TBTHB1DOWN.TJYUTNO);
    }

    /**
     * 統合先受注Noを設定する
     * @param val 統合先受注No
     */
    public void setHb1TJyutNo(String val) {
        set(TBTHB1DOWN.TJYUTNO, val);
    }
}
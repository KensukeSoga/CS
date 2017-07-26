package jp.co.isid.kkh.customer.kmn.model.report;

import java.math.BigDecimal;

import jp.co.isid.kkh.integ.tbl.TBTHB2KMEI;
import jp.co.isid.nj.model.AbstractModel;


/**
 * <P>
 * 帳票（公文_伝票）データVO
 * 明細データのみ
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2013/01/30 JSE M.Naito)<BR>
 * </P>
 *
 * @author JSE M.Naito
 */
public class ReportKmnMeisaiVO extends AbstractModel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * 新規インスタンスを構築します。
     */
    public ReportKmnMeisaiVO() {
    }

    /**
     * 新規インスタンスを構築します。
     *
     * @return 新規インスタンス
     */
    public Object newInstance() {
        return new ReportKmnMeisaiVO();
    }

    /**
     * 受注Noを取得する
     * @return 受注No
     */
    public String getJyutyuNo() {
        return (String) get(TBTHB2KMEI.JYUTNO);
    }

    /**
     * 受注Noを設定する
     * @param val 受注No
     */
    public void setJyutyuNo(String val) {
        set(TBTHB2KMEI.JYUTNO, val);
    }

    /**
     * 受注明細Noを取得する
     * @return 受注明細No
     */
    public String getJyuMeiNo() {
        return (String) get(TBTHB2KMEI.JYMEINO);
    }

    /**
     * 受注明細Noを設定する
     * @param val 受注明細No
     */
    public void setJyuMeiNo(String val) {
        set(TBTHB2KMEI.JYMEINO, val);
    }

    /**
     * 売上明細Noを取得する
     * @return 売上明細No
     */
    public String getUriMeiNo() {
        return (String) get(TBTHB2KMEI.URMEINO);
    }

    /**
     * 売上明細Noを設定する
     * @param val 売上明細No
     */
    public void setUriMeiNo(String val) {
        set(TBTHB2KMEI.URMEINO, val);
    }

    /**
     * 部門コードを取得する
     * @return コード1
     */
    public String getBumonCd() {
        return (String) get(TBTHB2KMEI.CODE1);
    }

    /**
     * 部門コードを設定する
     * @param val コード1
     */
    public void setBumonCd(String val) {
        set(TBTHB2KMEI.CODE1, val);
    }

    /**
     * 出力Noを取得する
     * @return コード2
     */
    public String getOutputNo() {
        return (String) get(TBTHB2KMEI.CODE2);
    }

    /**
     * 出力Noを設定する
     * @param val コード2
     */
    public void setOutputNo(String val) {
        set(TBTHB2KMEI.CODE2, val);
    }

    //--請求年月表示方法修正対応 2013/07/18 HLC H.Watabe start
    /**
     * 品目１を取得する
     * @return 名称9(漢字)
     */
    public String getHinmoku1() {
        //return (String) get(TBTHB2KMEI.NAME9);
        return (String) get(TBTHB2KMEI.NAME8);
    }

    /**
     * 品目１を設定する
     * @param val 名称9(漢字)
     */
    public void setHinmoku1(String val) {
        //set(TBTHB2KMEI.NAME9, val);
        set(TBTHB2KMEI.NAME8, val);
    }

    /**
     * 品目２を取得する
     * @return 名称4(漢字)
     */
    public String getHinmoku2() {
        //return (String) get(TBTHB2KMEI.NAME4);
        return (String) get(TBTHB2KMEI.NAME3);
    }

    /**
     * 品目２を設定する
     * @param val 名称4(漢字)
     */
    public void setHinmoku2(String val) {
        //set(TBTHB2KMEI.NAME4, val);
        set(TBTHB2KMEI.NAME3, val);
    }

    /**
     * 品目３を取得する
     * @return 名称5(漢字)
     */
    public String getHinmoku3() {
        //return (String) get(TBTHB2KMEI.NAME5);
        return (String) get(TBTHB2KMEI.NAME4);
    }

    /**
     * 品目３を設定する
     * @param val 名称5(漢字)
     */
    public void setHinmoku3(String val) {
        //set(TBTHB2KMEI.NAME5, val);
        set(TBTHB2KMEI.NAME4, val);
    }

    /**
     * 部門略称を取得する
     * @return 名称6(漢字)
     */
    public String getBumonNm() {
        //return (String) get(TBTHB2KMEI.NAME6);
        return (String) get(TBTHB2KMEI.NAME5);
    }

    /**
     * 部門略称を設定する
     * @param val 名称6(漢字)
     */
    public void setBumonNm(String val) {
        //set(TBTHB2KMEI.NAME6, val);
        set(TBTHB2KMEI.NAME5, val);
    }

    /**
     * 宛名を取得する
     * @return 名称16(漢字)
     */
    public String getAtenaNm() {
        return (String) get(TBTHB2KMEI.NAME16);
    }

    /**
     * 宛名を設定する
     * @param val 名称16(漢字)
     */
    public void setAtenaNm(String val) {
        set(TBTHB2KMEI.NAME16, val);
    }

    /**
     * 消費税金額を取得する
     * @return 金額3
     */
    public BigDecimal getSZeiGak() {
        return (BigDecimal) get(TBTHB2KMEI.KNGK3);
    }

    /**
     * 消費税金額を設定する
     * @param val 金額3
     */
    public void setSZeiGak(BigDecimal val) {
        set(TBTHB2KMEI.KNGK3, val);
    }


    /**
     * 金額を取得する
     * @return 金額1
     */
    public BigDecimal getKingaku() {
        return (BigDecimal) get(TBTHB2KMEI.KNGK1);
    }

    /**
     * 金額を設定する
     * @param val 金額1
     */
    public void setKingaku(BigDecimal val) {
        set(TBTHB2KMEI.KNGK1, val);
    }

    /**
     * 年月を取得する
     * @return 年月
     */
    public String getYyyymm() {
        return (String) get(TBTHB2KMEI.YYMM);
    }

    /**
     * 年月を設定する
     * @param val 年月
     */
    public void setYyyymm(String val) {
        set(TBTHB2KMEI.YYMM, val);
    }

    /**
     * 請求年月を取得する
     * @return 請求年月
     */
    public String getSeikyuYM() {
        return (String) get(TBTHB2KMEI.NAME6);
    }

    /**
     * 請求年月を設定する
     * @param val 請求年月
     */
    public void setSeikyuYM(String val) {
        set(TBTHB2KMEI.NAME6, val);
    }
    //--請求年月表示方法修正対応 2013/07/18 HLC H.Watabe end

    /**
     * 請求済みステータスを取得する
     * @return 請求済みステータス
     */
    public String getSeiZumi() {
        return (String) get("SEIZUMI");
    }

    /**
     * 請求済みステータスを設定する
     * @param val 請求済みステータス
     */
    public void setSeiZumi(String val) {
        set("SEIZUMI", val);
    }

}
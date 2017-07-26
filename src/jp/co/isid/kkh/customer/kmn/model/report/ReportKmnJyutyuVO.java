package jp.co.isid.kkh.customer.kmn.model.report;

import java.math.BigDecimal;

import jp.co.isid.kkh.integ.tbl.TBTHB1DOWN;
import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * 帳票（公文_伝票）データVO
 * 受注データのみ
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2013/01/30 JSE M.Naito)<BR>
 * </P>
 *
 * @author JSE M.Naito
 */
public class ReportKmnJyutyuVO extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /**
     * 新規インスタンスを構築します。
     */
    public ReportKmnJyutyuVO() {
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
    public String getJYUTNO() {
        return (String) get(TBTHB1DOWN.JYUTNO);
    }

    /**
     * 受注Noを設定する
     * @param val 受注No
     */
    public void setJYUTNO(String val) {
        set(TBTHB1DOWN.JYUTNO, val);
    }

    /**
     * 受注明細Noを取得する
     * @return 受注明細No
     */
    public String getJYMEINO() {
        return (String) get(TBTHB1DOWN.JYMEINO);
    }

    /**
     * 受注明細Noを設定する
     * @param val 受注明細No
     */
    public void setJYMEINO(String val) {
        set(TBTHB1DOWN.JYMEINO, val);
    }

    /**
     * 売上明細Noを取得する
     * @return 売上明細No
     */
    public String getURMEINO() {
        return (String) get(TBTHB1DOWN.URMEINO);
    }

    /**
     * 売上明細Noを設定する
     * @param val 売上明細No
     */
    public void setURMEINO(String val) {
        set(TBTHB1DOWN.URMEINO, val);
    }

    /**
     * 請求原票Noを取得する
     * @return 請求原票No
     */
    public String getGPYNO() {
        return (String) get(TBTHB1DOWN.GPYNO);
    }

    /**
     * 請求原票Noを設定する
     * @param val 請求原票No
     */
    public void setGPYNO(String val) {
        set(TBTHB1DOWN.GPYNO, val);
    }

    /**
     * 請求Noを取得する
     * @return 請求No
     */
    public String getSEINO() {
        return (String) get(TBTHB1DOWN.SEINO);
    }

    /**
     * 請求Noを設定する
     * @param val 請求No
     */
    public void setSEINO(String val) {
        set(TBTHB1DOWN.SEINO, val);
    }

    /**
     * 費目コードを取得する
     * @return 費目コード
     */
    public String getHIMKCD() {
        return (String) get(TBTHB1DOWN.HIMKCD);
    }

    /**
     * 費目コードを設定する
     * @param val 費目コード
     */
    public void setHIMKCD(String val) {
        set(TBTHB1DOWN.HIMKCD, val);
    }

    /**
     * 統合フラグを取得する
     * @return 統合フラグ
     */
    public String getTOUFLG() {
        return (String) get(TBTHB1DOWN.TOUFLG);
    }

    /**
     * 統合フラグを設定する
     * @param val 統合フラグ
     */
    public void setTOUFLG(String val) {
        set(TBTHB1DOWN.TOUFLG, val);
    }

    /**
     * 年月を取得する
     * @return 年月
     */
    public String getYYMM() {
        return (String) get(TBTHB1DOWN.YYMM);
    }

    /**
     * 年月を設定する
     * @param val 年月
     */
    public void setYYMM(String val) {
        set(TBTHB1DOWN.YYMM, val);
    }

    /**
     * 業務区分を取得する
     * @return 業務区分
     */
    public String getGYOMKBN() {
        return (String) get(TBTHB1DOWN.GYOMKBN);
    }

    /**
     * 業務区分を設定する
     * @param val 業務区分
     */
    public void setGYOMKBN(String val) {
        set(TBTHB1DOWN.GYOMKBN, val);
    }

    /**
     * マス正味区分を取得する
     * @return マス正味区分
     */
    public String getMSKBN() {
        return (String) get(TBTHB1DOWN.MSKBN);
    }

    /**
     * マス正味区分を設定する
     * @param val マス正味区分
     */
    public void setMSKBN(String val) {
        set(TBTHB1DOWN.MSKBN, val);
    }

    /**
     * タイムスポット区分を取得する
     * @return タイムスポット区分
     */
    public String getTMSPKBN() {
        return (String) get(TBTHB1DOWN.TMSPKBN);
    }

    /**
     * タイムスポット区分を設定する
     * @param val タイムスポット区分
     */
    public void setTMSPKBN(String val) {
        set(TBTHB1DOWN.TMSPKBN, val);
    }

    /**
     * 国際区分を取得する
     * @return 国際区分
     */
    public String getKOKKBN() {
        return (String) get(TBTHB1DOWN.KOKKBN);
    }

    /**
     * 国際区分を設定する
     * @param val 国際区分
     */
    public void setKOKKBN(String val) {
        set(TBTHB1DOWN.KOKKBN, val);
    }

    /**
     * 請求区分を取得する
     * @return 請求区分
     */
    public String getSEIKBN() {
        return (String) get(TBTHB1DOWN.SEIKBN);
    }

    /**
     * 請求区分を設定する
     * @param val 請求区分
     */
    public void setSEIKBN(String val) {
        set(TBTHB1DOWN.SEIKBN, val);
    }

    /**
     * 商品NOを取得する
     * @return 商品NO
     */
    public String getSYONO() {
        return (String) get(TBTHB1DOWN.SYONO);
    }

    /**
     * 商品NOを設定する
     * @param val 商品NO
     */
    public void setSYONO(String val) {
        set(TBTHB1DOWN.SYONO, val);
    }

    /**
     * 件名(漢字)を取得する
     * @return 件名(漢字)
     */
    public String getKKNAMEKJ() {
        return (String) get(TBTHB1DOWN.KKNAMEKJ);
    }

    /**
     * 件名(漢字)を設定する
     * @param val 件名(漢字)
     */
    public void setKKNAMEKJ(String val) {
        set(TBTHB1DOWN.KKNAMEKJ, val);
    }

    /**
     * 取料金を取得する
     * @return 取料金
     */
    public BigDecimal getTORIGAK() {
        return (BigDecimal) get(TBTHB1DOWN.TORIGAK);
    }

    /**
     * 取料金を設定する
     * @param val 取料金
     */
    public void setTORIGAK(BigDecimal val) {
        set(TBTHB1DOWN.TORIGAK, val);
    }

    /**
     * 請求単価を取得する
     * @return 請求単価
     */
    public BigDecimal getSEITNKA() {
        return (BigDecimal) get(TBTHB1DOWN.SEITNKA);
    }

    /**
     * 請求単価を設定する
     * @param val 請求単価
     */
    public void setSEITNKA(BigDecimal val) {
        set(TBTHB1DOWN.SEITNKA, val);
    }

    /**
     * 請求金額を取得する
     * @return 請求金額
     */
    public BigDecimal getSEIGAK() {
        return (BigDecimal) get(TBTHB1DOWN.SEIGAK);
    }

    /**
     * 請求金額を設定する
     * @param val 請求金額
     */
    public void setSEIGAK(BigDecimal val) {
        set(TBTHB1DOWN.SEIGAK, val);
    }

    /**
     * 値引率を取得する
     * @return 値引率
     */
    public BigDecimal getNEBIRITU() {
        return (BigDecimal) get(TBTHB1DOWN.NEBIRITU);
    }

    /**
     * 値引率を設定する
     * @param val 値引率
     */
    public void setNEBIRITU(BigDecimal val) {
        set(TBTHB1DOWN.NEBIRITU, val);
    }

    /**
     * 値引額を取得する
     * @return 値引額
     */
    public BigDecimal getNEBIGAK() {
        return (BigDecimal) get(TBTHB1DOWN.NEBIGAK);
    }

    /**
     * 値引額を設定する
     * @param val 値引額
     */
    public void setNEBIGAK(BigDecimal val) {
        set(TBTHB1DOWN.NEBIGAK, val);
    }

    /**
     * 消費税区分を取得する
     * @return 消費税区分
     */
    public String getSZEIKBN() {
        return (String) get(TBTHB1DOWN.SZEIKBN);
    }

    /**
     * 消費税区分を設定する
     * @param val 消費税区分
     */
    public void setSZEIKBN(String val) {
        set(TBTHB1DOWN.SZEIKBN, val);
    }

    /**
     * 消費税率を取得する
     * @return 消費税率
     */
    public BigDecimal getSZEIRITU() {
        return (BigDecimal) get(TBTHB1DOWN.SZEIRITU);
    }

    /**
     * 消費税率を設定する
     * @param val 消費税率
     */
    public void setSZEIRITU(BigDecimal val) {
        set(TBTHB1DOWN.SZEIRITU, val);
    }

    /**
     * 消費税額を取得する
     * @return 消費税額
     */
    public BigDecimal getSZEIGAK() {
        return (BigDecimal) get(TBTHB1DOWN.SZEIGAK);
    }

    /**
     * 消費税額を設定する
     * @param val 消費税額
     */
    public void setSZEIGAK(BigDecimal val) {
        set(TBTHB1DOWN.SZEIGAK, val);
    }

    /**
     * 費目名(漢字)を取得する
     * @return 費目名(漢字)
     */
    public String getHIMKNMKJ() {
        return (String) get(TBTHB1DOWN.HIMKNMKJ);
    }

    /**
     * 費目名(漢字)を設定する
     * @param val 費目名(漢字)
     */
    public void setHIMKNMKJ(String val) {
        set(TBTHB1DOWN.HIMKNMKJ, val);
    }

    /**
     * 費目名(カナ)を取得する
     * @return 費目名(カナ)
     */
    public String getHIMKNMKN() {
        return (String) get(TBTHB1DOWN.HIMKNMKN);
    }

    /**
     * 費目名(カナ)を設定する
     * @param val 費目名(カナ)
     */
    public void setHIMKNMKN(String val) {
        set(TBTHB1DOWN.HIMKNMKN, val);
    }

    /**
     * 統合先受注Noを取得する
     * @return 統合先受注No
     */
    public String getTJYUTNO() {
        return (String) get(TBTHB1DOWN.TJYUTNO);
    }

    /**
     * 統合先受注Noを設定する
     * @param val 統合先受注No
     */
    public void setTJYUTNO(String val) {
        set(TBTHB1DOWN.TJYUTNO, val);
    }

    /**
     * 統合先受注明細Noを取得する
     * @return 統合先受注明細No
     */
    public String getTJYMEINO() {
        return (String) get(TBTHB1DOWN.TJYMEINO);
    }

    /**
     * 統合先受注明細Noを設定する
     * @param val 統合先受注明細No
     */
    public void setTJYMEINO(String val) {
        set(TBTHB1DOWN.TJYMEINO, val);
    }

    /**
     * 統合先売上明細Noを取得する
     * @return 統合先売上明細No
     */
    public String getTURMEINO() {
        return (String) get(TBTHB1DOWN.TURMEINO);
    }

    /**
     * 統合先売上明細Noを設定する
     * @param val 統合先売上明細No
     */
    public void setTURMEINO(String val) {
        set(TBTHB1DOWN.TURMEINO, val);
    }

    /**
     * フィールド1を取得する
     * @return フィールド1
     */
    public String getFIELD1() {
        return (String) get(TBTHB1DOWN.FIELD1);
    }

    /**
     * フィールド1を設定する
     * @param val フィールド1
     */
    public void setFIELD1(String val) {
        set(TBTHB1DOWN.FIELD1, val);
    }

    /**
     * フィールド２を取得する
     * @return フィールド２
     */
    public String getFIELD2() {
        return (String) get(TBTHB1DOWN.FIELD2);
    }

    /**
     * フィールド２を設定する
     * @param val フィールド２
     */
    public void setFIELD2(String val) {
        set(TBTHB1DOWN.FIELD2, val);
    }

    /**
     * フィールド３を取得する
     * @return フィールド３
     */
    public String getFIELD3() {
        return (String) get(TBTHB1DOWN.FIELD3);
    }

    /**
     * フィールド３を設定する
     * @param val フィールド３
     */
    public void setFIELD3(String val) {
        set(TBTHB1DOWN.FIELD3, val);
    }

    /**
     * フィールド４を取得する
     * @return フィールド４
     */
    public String getFIELD4() {
        return (String) get(TBTHB1DOWN.FIELD4);
    }

    /**
     * フィールド４を設定する
     * @param val フィールド４
     */
    public void setFIELD4(String val) {
        set(TBTHB1DOWN.FIELD4, val);
    }

    /**
     * フィールド５を取得する
     * @return フィールド５
     */
    public String getFIELD5() {
        return (String) get(TBTHB1DOWN.FIELD5);
    }

    /**
     * フィールド５を設定する
     * @param val フィールド５
     */
    public void setFIELD5(String val) {
        set(TBTHB1DOWN.FIELD5, val);
    }

    /**
     * フィールド６を取得する
     * @return フィールド６
     */
    public String getFIELD6() {
        return (String) get(TBTHB1DOWN.FIELD6);
    }

    /**
     * フィールド６を設定する
     * @param val フィールド６
     */
    public void setFIELD6(String val) {
        set(TBTHB1DOWN.FIELD6, val);
    }

    /**
     * フィールド７を取得する
     * @return フィールド７
     */
    public String getFIELD7() {
        return (String) get(TBTHB1DOWN.FIELD7);
    }

    /**
     * フィールド７を設定する
     * @param val フィールド７
     */
    public void setFIELD7(String val) {
        set(TBTHB1DOWN.FIELD7, val);
    }

    /**
     * フィールド８を取得する
     * @return フィールド８
     */
    public String getFIELD8() {
        return (String) get(TBTHB1DOWN.FIELD8);
    }

    /**
     * フィールド８を設定する
     * @param val フィールド８
     */
    public void setFIELD8(String val) {
        set(TBTHB1DOWN.FIELD8, val);
    }

    /**
     * フィールド９を取得する
     * @return フィールド９
     */
    public String getFIELD9() {
        return (String) get(TBTHB1DOWN.FIELD9);
    }

    /**
     * フィールド９を設定する
     * @param val フィールド９
     */
    public void setFIELD9(String val) {
        set(TBTHB1DOWN.FIELD9, val);
    }

    /**
     * フィールド１０を取得する
     * @return フィールド１０
     */
    public String getFIELD10() {
        return (String) get(TBTHB1DOWN.FIELD10);
    }

    /**
     * フィールド１０を設定する
     * @param val フィールド１０
     */
    public void setFIELD10(String val) {
        set(TBTHB1DOWN.FIELD10, val);
    }

    /**
     * フィールド１１を取得する
     * @return フィールド１１
     */
    public String getFIELD11() {
        return (String) get(TBTHB1DOWN.FIELD11);
    }

    /**
     * フィールド１１を設定する
     * @param val フィールド１１
     */
    public void setFIELD11(String val) {
        set(TBTHB1DOWN.FIELD11, val);
    }

    /**
     * フィールド１２を取得する
     * @return フィールド１２
     */
    public String getFIELD12() {
        return (String) get(TBTHB1DOWN.FIELD12);
    }

    /**
     * フィールド１２を設定する
     * @param val フィールド１２
     */
    public void setFIELD12(String val) {
        set(TBTHB1DOWN.FIELD12, val);
    }

}

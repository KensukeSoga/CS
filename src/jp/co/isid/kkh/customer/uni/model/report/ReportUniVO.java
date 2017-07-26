package jp.co.isid.kkh.customer.uni.model.report;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlElement;

import jp.co.isid.kkh.integ.tbl.TBTHB1DOWN;
import jp.co.isid.kkh.integ.tbl.TBTHB2KMEI;
import jp.co.isid.nj.model.AbstractModel;


/**
 * <P>
 * 帳票（ユニチャーム_広告費明細表）データVO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/1/23 JSE Y.Sato)<BR>
 * </P>
 *
 * @author JSE Y.Sato
 */
public class ReportUniVO extends AbstractModel {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
     * 新規インスタンスを構築します。
     */
    public ReportUniVO() {
    }

    /**
     * 新規インスタンスを構築します。
     *
     * @return 新規インスタンス
     */
    public Object newInstance() {
        return new ReportUniVO();
    }

    /**
     * 受注Noを設定します。
     * @param val String 受注No
     */
    public void setHb1JyutNo(String val) {
        set(TBTHB1DOWN.JYUTNO, val);
    }

    /**
     * 受注Noを返します。
     * @return String 受注No
     */
    public String getHb1JyutNo() {
        return (String) get(TBTHB1DOWN.JYUTNO);
    }

     /**
     * 受注明細Noを設定します。
     * @param val String 受注明細No
     */
    public void setHb1JyMeiNo(String val) {
        set(TBTHB1DOWN.JYMEINO, val);
    }

    /**
     * 受注明細Noを返します。
     * @return String 受注明細No
     */
    public String getHb1JyMeiNo() {
        return (String) get(TBTHB1DOWN.JYMEINO);
    }

     /**
     * 売上明細Noを設定します。
     * @param val String 売上明細No
     */
    public void setHb1UrMeiNo(String val) {
        set(TBTHB1DOWN.URMEINO, val);
    }

    /**
     * 売上明細Noを返します。
     * @return String 売上明細No
     */
    public String getHb1UrMeiNo() {
        return (String) get(TBTHB1DOWN.URMEINO);
    }

     /**
     * 請求原票Noを設定します。
     * @param val String 請求原票No
     */
    public void setHb1GpyNo(String val) {
        set(TBTHB1DOWN.GPYNO, val);
    }

    /**
     * 請求原票Noを返します。
     * @return String 請求原票No
     */
    public String getHb1GpyNo() {
        return (String) get(TBTHB1DOWN.GPYNO);
    }

     /**
     * 請求Noを設定します。
     * @param val String 請求No
     */
    public void setHb1SeiNo(String val) {
        set(TBTHB1DOWN.SEINO, val);
    }

    /**
     * 請求Noを返します。
     * @return String 請求No
     */
    public String getHb1SeiNo() {
        return (String) get(TBTHB1DOWN.SEINO);
    }

     /**
     * 業務区分を設定します。
     * @param val String 業務区分
     */
    public void setHb1GyomKbn(String val) {
        set(TBTHB1DOWN.GYOMKBN, val);
    }

    /**
     * 業務区分を返します。
     * @return String 業務区分
     */
    public String getHb1GyomKbn() {
        return (String) get(TBTHB1DOWN.GYOMKBN);
    }

     /**
     * 請求区分を設定します。
     * @param val String 請求区分
     */
    public void setHb1SeiKbn(String val) {
        set(TBTHB1DOWN.SEIKBN, val);
    }

    /**
     * 請求区分を返します。
     * @return String 請求区分
     */
    public String getHb1SeiKbn() {
        return (String) get(TBTHB1DOWN.SEIKBN);
    }

     /**
     * 件名(漢字)を設定します。
     * @param val String 件名(漢字)
     */
    public void setHb1KKNameKJ(String val) {
        set(TBTHB1DOWN.KKNAMEKJ, val);
    }

    /**
     * 件名(漢字)を返します。
     * @return String 件名(漢字)
     */
    public String getHb1KKNameKJ() {
        return (String) get(TBTHB1DOWN.KKNAMEKJ);
    }

     /**
     * 請求単価を設定します。
     * @param val BigDecimal 請求単価
     */
    public void setHb1SeiTnka(BigDecimal val) {
        set(TBTHB1DOWN.SEITNKA, val);
    }

    /**
     * 請求単価を返します。
     * @return BigDecimal 請求単価
     */
    @XmlElement(required = true)
    public BigDecimal getHb1SeiTnka() {
        return (BigDecimal) get(TBTHB1DOWN.SEITNKA);
    }

     /**
     * 請求金額を設定します。
     * @param val BigDecimal 請求金額
     */
    public void setHb1SeiGak(BigDecimal val) {
        set(TBTHB1DOWN.SEIGAK, val);
    }

    /**
     * 請求金額を返します。
     * @return BigDecimal 請求金額
     */
    @XmlElement(required = true)
    public BigDecimal getHb1SeiGak() {
        return (BigDecimal) get(TBTHB1DOWN.SEIGAK);
    }

     /**
     * 消費税額を設定します。
     * @param val BigDecimal 消費税額
     */
    public void setHb1SzeiGak(BigDecimal val) {
        set(TBTHB1DOWN.SZEIGAK, val);
    }

    /**
     * 消費税額を返します。
     * @return BigDecimal 消費税額
     */
    @XmlElement(required = true)
    public BigDecimal getHb1SzeiGak() {
        return (BigDecimal) get(TBTHB1DOWN.SZEIGAK);
    }

     /**
     * 費目名(漢字)を設定します。
     * @param val String 費目名(漢字)
     */
    public void setHb1HimkNmKJ(String val) {
        set(TBTHB1DOWN.HIMKNMKJ, val);
    }

    /**
     * 費目名(漢字)を返します。
     * @return String 費目名(漢字)
     */
    public String getHb1HimkNmKJ() {
        return (String) get(TBTHB1DOWN.HIMKNMKJ);
    }

     /**
     * フィールド1を設定します。
     * @param val String フィールド1
     */
    public void setHb1Field1(String val) {
        set(TBTHB1DOWN.FIELD1, val);
    }

    /**
     * フィールド1を返します。
     * @return String フィールド1
     */
    public String getHb1Field1() {
        return (String) get(TBTHB1DOWN.FIELD1);
    }

    // 2013/01/09 JSE M.Naito add start
    /**
     * 統合フラグを設定します。
     * @param val String 統合フラグ
     */
    public void setHb1TouFlg(String val) {
        set(TBTHB1DOWN.TOUFLG, val);
    }

    /**
     * 統合フラグを返します。
     * @return String 統合フラグ
     */
    public String getHb1TouFlg() {
        return (String) get(TBTHB1DOWN.TOUFLG);
    }

    /**
     * 統合先受注Noを設定します。
     * @param val String 統合先受注No
     */
    public void setHb1TJyutNo(String val) {
        set(TBTHB1DOWN.TJYUTNO, val);
    }

    /**
     * 統合先受注Noを返します。
     * @return String 統合先受注No
     */
    public String getHb1TJyutNo() {
        return (String) get(TBTHB1DOWN.TJYUTNO);
    }

    /**
     * 統合先受注明細Noを設定します。
     * @param val String 統合先受注明細No
     */
    public void setHb1TJymeiNo(String val) {
        set(TBTHB1DOWN.TJYMEINO, val);
    }

    /**
     * 統合先受注明細Noを返します。
     * @return String 統合先受注明細No
     */
    public String getHb1TJymeiNo() {
        return (String) get(TBTHB1DOWN.TJYMEINO);
    }

    /**
     * 統合先売上明細Noを設定します。
     * @param val String 統合先売上明細No
     */
    public void setHb1TUrmeiNo(String val) {
        set(TBTHB1DOWN.TURMEINO, val);
    }

    /**
     * 統合先売上明細Noを返します。
     * @return String 統合先売上明細No
     */
    public String getHb1TUrmeiNo() {
        return (String) get(TBTHB1DOWN.TURMEINO);
    }
    // 2013/01/09 JSE M.Naito add end

     /**
     * フィールド２を設定します。
     * @param val String フィールド２
     */
    public void setHb1Field2(String val) {
        set(TBTHB1DOWN.FIELD2, val);
    }

    /**
     * フィールド２を返します。
     * @return String フィールド２
     */
    public String getHb1Field2() {
        return (String) get(TBTHB1DOWN.FIELD2);
    }

     /**
     * フィールド３を設定します。
     * @param val String フィールド３
     */
    public void setHb1Field3(String val) {
        set(TBTHB1DOWN.FIELD3, val);
    }

    /**
     * フィールド３を返します。
     * @return String フィールド３
     */
    public String getHb1Field3() {
        return (String) get(TBTHB1DOWN.FIELD3);
    }

     /**
     * フィールド４を設定します。
     * @param val String フィールド４
     */
    public void setHb1Field4(String val) {
        set(TBTHB1DOWN.FIELD4, val);
    }

    /**
     * フィールド４を返します。
     * @return String フィールド４
     */
    public String getHb1Field4() {
        return (String) get(TBTHB1DOWN.FIELD4);
    }

     /**
     * フィールド５を設定します。
     * @param val String フィールド５
     */
    public void setHb1Field5(String val) {
        set(TBTHB1DOWN.FIELD5, val);
    }

    /**
     * フィールド５を返します。
     * @return String フィールド５
     */
    public String getHb1Field5() {
        return (String) get(TBTHB1DOWN.FIELD5);
    }

     /**
     * フィールド６を設定します。
     * @param val String フィールド６
     */
    public void setHb1Field6(String val) {
        set(TBTHB1DOWN.FIELD6, val);
    }

    /**
     * フィールド６を返します。
     * @return String フィールド６
     */
    public String getHb1Field6() {
        return (String) get(TBTHB1DOWN.FIELD6);
    }

     /**
     * フィールド７を設定します。
     * @param val String フィールド７
     */
    public void setHb1Field7(String val) {
        set(TBTHB1DOWN.FIELD7, val);
    }

    /**
     * フィールド７を返します。
     * @return String フィールド７
     */
    public String getHb1Field7() {
        return (String) get(TBTHB1DOWN.FIELD7);
    }

     /**
     * フィールド８を設定します。
     * @param val String フィールド８
     */
    public void setHb1Field8(String val) {
        set(TBTHB1DOWN.FIELD8, val);
    }

    /**
     * フィールド８を返します。
     * @return String フィールド８
     */
    public String getHb1Field8() {
        return (String) get(TBTHB1DOWN.FIELD8);
    }

     /**
     * フィールド９を設定します。
     * @param val String フィールド９
     */
    public void setHb1Field9(String val) {
        set(TBTHB1DOWN.FIELD9, val);
    }

    /**
     * フィールド９を返します。
     * @return String フィールド９
     */
    public String getHb1Field9() {
        return (String) get(TBTHB1DOWN.FIELD9);
    }

     /**
     * フィールド１０を設定します。
     * @param val String フィールド１０
     */
    public void setHb1Field10(String val) {
        set(TBTHB1DOWN.FIELD10, val);
    }

    /**
     * フィールド１０を返します。
     * @return String フィールド１０
     */
    public String getHb1Field10() {
        return (String) get(TBTHB1DOWN.FIELD10);
    }

     /**
     * フィールド１１を設定します。
     * @param val String フィールド１１
     */
    public void setHb1Field11(String val) {
        set(TBTHB1DOWN.FIELD11, val);
    }

    /**
     * フィールド１１を返します。
     * @return String フィールド１１
     */
    public String getHb1Field11() {
        return (String) get(TBTHB1DOWN.FIELD11);
    }

     /**
     * フィールド１２を設定します。
     * @param val String フィールド１２
     */
    public void setHb1Field12(String val) {
        set(TBTHB1DOWN.FIELD12, val);
    }

    /**
     * フィールド１２を返します。
     * @return String フィールド１２
     */
    public String getHb1Field12() {
        return (String) get(TBTHB1DOWN.FIELD12);
    }


    /**
     * 受注Noを設定します。
     * @param val String 受注No
     */
    public void setHb2JyutNo(String val) {
        set(TBTHB2KMEI.JYUTNO, val);
    }

    /**
     * 受注Noを返します。
     * @return String 受注No
     */
    public String getHb2JyutNo() {
        return (String) get(TBTHB2KMEI.JYUTNO);
    }

    /**
     * 受注明細Noを設定します。
     * @param val String 受注明細No
     */
    public void setHb2JyMeiNo(String val) {
        set(TBTHB2KMEI.JYMEINO, val);
    }

    /**
     * 受注明細Noを返します。
     * @return String 受注明細No
     */
    public String getHb2JyMeiNo() {
        return (String) get(TBTHB2KMEI.JYMEINO);
    }

    /**
     * 売上明細Noを設定します。
     * @param val String 売上明細No
     */
    public void setHb2UrMeiNo(String val) {
        set(TBTHB2KMEI.URMEINO, val);
    }

    /**
     * 売上明細Noを返します。
     * @return String 売上明細No
     */
    public String getHb2UrMeiNo() {
        return (String) get(TBTHB2KMEI.URMEINO);
    }

    /**
     * 請求金額を設定します。
     * @param val BigDecimal 請求金額
     */
    public void setHb2SeiGak(BigDecimal val) {
        set(TBTHB2KMEI.SEIGAK, val);
    }

    /**
     * 請求金額を返します。
     * @return BigDecimal 請求金額
     */
    @XmlElement(required = true)
    public BigDecimal getHb2SeiGak() {
        return (BigDecimal) get(TBTHB2KMEI.SEIGAK);
    }

    /**
     * コード1を設定します。
     * @param val String コード1
     */
    public void setHb2Code1(String val) {
        set(TBTHB2KMEI.CODE1, val);
    }

    /**
     * コード1を返します。
     * @return String コード1
     */
    public String getHb2Code1() {
        return (String) get(TBTHB2KMEI.CODE1);
    }

    /**
     * 名称1(漢字)を設定します。
     * @param val String 名称1(漢字)
     */
    public void setHb2Name1(String val) {
        set(TBTHB2KMEI.NAME1, val);
    }

    /**
     * 名称1(漢字)を返します。
     * @return String 名称1(漢字)
     */
    public String getHb2Name1() {
        return (String) get(TBTHB2KMEI.NAME1);
    }

    /**
     * 名称2(漢字)を設定します。
     * @param val String 名称2(漢字)
     */
    public void setHb2Name2(String val) {
        set(TBTHB2KMEI.NAME2, val);
    }

    /**
     * 名称2(漢字)を返します。
     * @return String 名称2(漢字)
     */
    public String getHb2Name2() {
        return (String) get(TBTHB2KMEI.NAME2);
    }

    /**
     * 名称3(漢字)を設定します。
     * @param val String 名称3(漢字)
     */
    public void setHb2Name3(String val) {
        set(TBTHB2KMEI.NAME3, val);
    }

    /**
     * 名称3(漢字)を返します。
     * @return String 名称3(漢字)
     */
    public String getHb2Name3() {
        return (String) get(TBTHB2KMEI.NAME3);
    }

    /**
     * 名称4(漢字)を設定します。
     * @param val String 名称4(漢字)
     */
    public void setHb2Name4(String val) {
        set(TBTHB2KMEI.NAME4, val);
    }

    /**
     * 名称4(漢字)を返します。
     * @return String 名称4(漢字)
     */
    public String getHb2Name4() {
        return (String) get(TBTHB2KMEI.NAME4);
    }

    /**
     * 名称5(漢字)を設定します。
     * @param val String 名称5(漢字)
     */
    public void setHb2Name5(String val) {
        set(TBTHB2KMEI.NAME5, val);
    }

    /**
     * 名称5(漢字)を返します。
     * @return String 名称5(漢字)
     */
    public String getHb2Name5() {
        return (String) get(TBTHB2KMEI.NAME5);
    }

    /**
     * 名称6(漢字)を設定します。
     * @param val String 名称6(漢字)
     */
    public void setHb2Name6(String val) {
        set(TBTHB2KMEI.NAME6, val);
    }

    /**
     * 名称6(漢字)を返します。
     * @return String 名称6(漢字)
     */
    public String getHb2Name6() {
        return (String) get(TBTHB2KMEI.NAME6);
    }

    /**
     * 名称7(漢字)を設定します。
     * @param val String 名称7(漢字)
     */
    public void setHb2Name7(String val) {
        set(TBTHB2KMEI.NAME7, val);
    }

    /**
     * 名称7(漢字)を返します。
     * @return String 名称7(漢字)
     */
    public String getHb2Name7() {
        return (String) get(TBTHB2KMEI.NAME7);
    }

    /**
     * 名称8(漢字)を設定します。
     * @param val String 名称8(漢字)
     */
    public void setHb2Name8(String val) {
        set(TBTHB2KMEI.NAME8, val);
    }

    /**
     * 名称8(漢字)を返します。
     * @return String 名称8(漢字)
     */
    public String getHb2Name8() {
        return (String) get(TBTHB2KMEI.NAME8);
    }

    /**
     * 名称9(漢字)を設定します。
     * @param val String 名称9(漢字)
     */
    public void setHb2Name9(String val) {
        set(TBTHB2KMEI.NAME9, val);
    }

    /**
     * 名称9(漢字)を返します。
     * @return String 名称9(漢字)
     */
    public String getHb2Name9() {
        return (String) get(TBTHB2KMEI.NAME9);
    }

    /**
     * 名称11(漢字)を設定します。
     * @param val String 名称11(漢字)
     */
    public void setHb2Name11(String val) {
        set(TBTHB2KMEI.NAME11, val);
    }

    /**
     * 名称11(漢字)を返します。
     * @return String 名称11(漢字)
     */
    public String getHb2Name11() {
        return (String) get(TBTHB2KMEI.NAME11);
    }

    /**
     * 金額1を設定します。
     * @param val BigDecimal 金額1
     */
    public void setHb2Kngk1(BigDecimal val) {
        set(TBTHB2KMEI.KNGK1, val);
    }

    /**
     * 金額1を返します。
     * @return BigDecimal 金額1
     */
    @XmlElement(required = true)
    public BigDecimal getHb2Kngk1() {
        return (BigDecimal) get(TBTHB2KMEI.KNGK1);
    }

    /**
     * 金額2を設定します。
     * @param val BigDecimal 金額2
     */
    public void setHb2Kngk2(BigDecimal val) {
        set(TBTHB2KMEI.KNGK2, val);
    }

    /**
     * 金額2を返します。
     * @return BigDecimal 金額2
     */
    @XmlElement(required = true)
    public BigDecimal getHb2Kngk2() {
        return (BigDecimal) get(TBTHB2KMEI.KNGK2);
    }

    /**
     * その他1を設定します。
     * @param val String その他1
     */
    public void setHb2Sonota1(String val) {
        set(TBTHB2KMEI.SONOTA1, val);
    }

    /**
     * その他1を返します。
     * @return String その他1
     */
    public String getHb2Sonota1() {
        return (String) get(TBTHB2KMEI.SONOTA1);
    }

    /**
     * その他2を設定します。
     * @param val String その他2
     */
    public void setHb2Sonota2(String val) {
        set(TBTHB2KMEI.SONOTA2, val);
    }

    /**
     * その他2を返します。
     * @return String その他2
     */
    public String getHb2Sonota2() {
        return (String) get(TBTHB2KMEI.SONOTA2);
    }

    /**
     * その他3を設定します。
     * @param val String その他3
     */
    public void setHb2Sonota3(String val) {
        set(TBTHB2KMEI.SONOTA3, val);
    }

    /**
     * その他3を返します。
     * @return String その他3
     */
    public String getHb2Sonota3() {
        return (String) get(TBTHB2KMEI.SONOTA3);
    }

    /**
     * その他4を設定します。
     * @param val String その他4
     */
    public void setHb2Sonota4(String val) {
        set(TBTHB2KMEI.SONOTA4, val);
    }

    /**
     * その他4を返します。
     * @return String その他4
     */
    public String getHb2Sonota4() {
        return (String) get(TBTHB2KMEI.SONOTA4);
    }

    /**
     * その他5を設定します。
     * @param val String その他5
     */
    public void setHb2Sonota5(String val) {
        set(TBTHB2KMEI.SONOTA5, val);
    }

    /**
     * その他5を返します。
     * @return String その他5
     */
    public String getHb2Sonota5() {
        return (String) get(TBTHB2KMEI.SONOTA5);
    }

    /**
     * 種別コードを設定します。
     * @param val String 種別コード
     */
    public void setShubetsuCd(String val) {
        set("SHOWNUM", val);
    }

    /**
     * 種別コードを返します。
     * @return String 種別コード
     */
    public String getShubetsuCd() {
        return (String) get("SHOWNUM");
    }

    /**
     * 種別名称を設定します。
     * @param val String 種別名称
     */
    public void setShubetsuNm(String val) {
        set("SHUBETSUNM", val);
    }

    /**
     * 種別名称を返します。
     * @return String 種別名称
     */
    public String getShubetsuNm() {
        return (String) get("SHUBETSUNM");
    }

}
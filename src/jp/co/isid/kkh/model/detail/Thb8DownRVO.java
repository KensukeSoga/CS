package jp.co.isid.kkh.model.detail;

import java.math.BigDecimal;
import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import jp.co.isid.kkh.integ.tbl.TBTHB8DOWNR;
import jp.co.isid.nj.model.AbstractModel;

@XmlRootElement(namespace = "http://detail.model.kkh.isid.co.jp/")
@XmlType(namespace = "http://detail.model.kkh.isid.co.jp/")
public class Thb8DownRVO extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /**
     * 新規インスタンスを構築します。
     */
    public Thb8DownRVO() {
    }

    /**
     * 新規インスタンスを構築します。
     *
     * @return 新規インスタンス
     */
    public Object newInstance() {
        return new Thb8DownRVO();
    }

    /**
     * タイムスタンプを設定します。
     * @param val Date タイムスタンプ
     */
    public void setHb8TimStmp(Date val) {
        set(TBTHB8DOWNR.TIMSTMP, val);
    }

    /**
     * タイムスタンプを返します。
     * @return Date タイムスタンプ
     */
    @XmlElement(required = true)
    public Date getHb8TimStmp() {
        return (Date) get(TBTHB8DOWNR.TIMSTMP);
    }

//    /**
//     * タイムスタンプを設定します。
//     * @param val Date タイムスタンプ
//     */
//    public void setHb8TimStmp(String val) {
//        set(TBTHB8DOWNR.TIMSTMP, val);
//    }
//
//    /**
//     * タイムスタンプを返します。
//     * @return Date タイムスタンプ
//     */
//    public String getHb8TimStmp() {
//        return (String) get(TBTHB8DOWNR.TIMSTMP);
//    }

     /**
     * 更新プログラムを設定します。
     * @param val String 更新プログラム
     */
    public void setHb8UpdApl(String val) {
        set(TBTHB8DOWNR.UPDAPL, val);
    }

    /**
     * 更新プログラムを返します。
     * @return String 更新プログラム
     */
    public String getHb8UpdApl() {
        return (String) get(TBTHB8DOWNR.UPDAPL);
    }

     /**
     * 更新担当者を設定します。
     * @param val String 更新担当者
     */
    public void setHb8UpdTnt(String val) {
        set(TBTHB8DOWNR.UPDTNT, val);
    }

    /**
     * 更新担当者を返します。
     * @return String 更新担当者
     */
    public String getHb8UpdTnt() {
        return (String) get(TBTHB8DOWNR.UPDTNT);
    }

     /**
     * 営業所（扱）コードを設定します。
     * @param val String 営業所（扱）コード
     */
    public void setHb8AtuEgCd(String val) {
        set(TBTHB8DOWNR.ATUEGCD, val);
    }

    /**
     * 営業所（扱）コードを返します。
     * @return String 営業所（扱）コード
     */
    public String getHb8AtuEgCd() {
        return (String) get(TBTHB8DOWNR.ATUEGCD);
    }

     /**
     * 営業所（取）コードを設定します。
     * @param val String 営業所（取）コード
     */
    public void setHb8EgCd(String val) {
        set(TBTHB8DOWNR.EGCD, val);
    }

    /**
     * 営業所（取）コードを返します。
     * @return String 営業所（取）コード
     */
    public String getHb8EgCd() {
        return (String) get(TBTHB8DOWNR.EGCD);
    }

     /**
     * 得意先企業コードを設定します。
     * @param val String 得意先企業コード
     */
    public void setHb8TksKgyCd(String val) {
        set(TBTHB8DOWNR.TKSKGYCD, val);
    }

    /**
     * 得意先企業コードを返します。
     * @return String 得意先企業コード
     */
    public String getHb8TksKgyCd() {
        return (String) get(TBTHB8DOWNR.TKSKGYCD);
    }

     /**
     * 得意先部門SEQNOを設定します。
     * @param val String 得意先部門SEQNO
     */
    public void setHb8TksBmnSeqNo(String val) {
        set(TBTHB8DOWNR.TKSBMNSEQNO, val);
    }

    /**
     * 得意先部門SEQNOを返します。
     * @return String 得意先部門SEQNO
     */
    public String getHb8TksBmnSeqNo() {
        return (String) get(TBTHB8DOWNR.TKSBMNSEQNO);
    }

     /**
     * 得意先担当SEQNOを設定します。
     * @param val String 得意先担当SEQNO
     */
    public void setHb8TksTntSeqNo(String val) {
        set(TBTHB8DOWNR.TKSTNTSEQNO, val);
    }

    /**
     * 得意先担当SEQNOを返します。
     * @return String 得意先担当SEQNO
     */
    public String getHb8TksTntSeqNo() {
        return (String) get(TBTHB8DOWNR.TKSTNTSEQNO);
    }

     /**
     * 受注Noを設定します。
     * @param val String 受注No
     */
    public void setHb8JyutNo(String val) {
        set(TBTHB8DOWNR.JYUTNO, val);
    }

    /**
     * 受注Noを返します。
     * @return String 受注No
     */
    public String getHb8JyutNo() {
        return (String) get(TBTHB8DOWNR.JYUTNO);
    }

     /**
     * 受注明細Noを設定します。
     * @param val String 受注明細No
     */
    public void setHb8JyMeiNo(String val) {
        set(TBTHB8DOWNR.JYMEINO, val);
    }

    /**
     * 受注明細Noを返します。
     * @return String 受注明細No
     */
    public String getHb8JyMeiNo() {
        return (String) get(TBTHB8DOWNR.JYMEINO);
    }

     /**
     * 売上明細Noを設定します。
     * @param val String 売上明細No
     */
    public void setHb8UrMeiNo(String val) {
        set(TBTHB8DOWNR.URMEINO, val);
    }

    /**
     * 売上明細Noを返します。
     * @return String 売上明細No
     */
    public String getHb8UrMeiNo() {
        return (String) get(TBTHB8DOWNR.URMEINO);
    }

     /**
     * 請求原票Noを設定します。
     * @param val String 請求原票No
     */
    public void setHb8GpyNo(String val) {
        set(TBTHB8DOWNR.GPYNO, val);
    }

    /**
     * 請求原票Noを返します。
     * @return String 請求原票No
     */
    public String getHb8GpyNo() {
        return (String) get(TBTHB8DOWNR.GPYNO);
    }

     /**
     * ページNoを設定します。
     * @param val String ページNo
     */
    public void setHb8GpyoPag(String val) {
        set(TBTHB8DOWNR.GPYOPAG, val);
    }

    /**
     * ページNoを返します。
     * @return String ページNo
     */
    public String getHb8GpyoPag() {
        return (String) get(TBTHB8DOWNR.GPYOPAG);
    }

     /**
     * 請求Noを設定します。
     * @param val String 請求No
     */
    public void setHb8SeiNo(String val) {
        set(TBTHB8DOWNR.SEINO, val);
    }

    /**
     * 請求Noを返します。
     * @return String 請求No
     */
    public String getHb8SeiNo() {
        return (String) get(TBTHB8DOWNR.SEINO);
    }

     /**
     * 費目コードを設定します。
     * @param val String 費目コード
     */
    public void setHb8HimkCd(String val) {
        set(TBTHB8DOWNR.HIMKCD, val);
    }

    /**
     * 費目コードを返します。
     * @return String 費目コード
     */
    public String getHb8HimkCd() {
        return (String) get(TBTHB8DOWNR.HIMKCD);
    }

     /**
     * 統合フラグを設定します。
     * @param val String 統合フラグ
     */
    public void setHb8TouFlg(String val) {
        set(TBTHB8DOWNR.TOUFLG, val);
    }

    /**
     * 統合フラグを返します。
     * @return String 統合フラグ
     */
    public String getHb8TouFlg() {
        return (String) get(TBTHB8DOWNR.TOUFLG);
    }

     /**
     * 年月を設定します。
     * @param val String 年月
     */
    public void setHb8Yymm(String val) {
        set(TBTHB8DOWNR.YYMM, val);
    }

    /**
     * 年月を返します。
     * @return String 年月
     */
    public String getHb8Yymm() {
        return (String) get(TBTHB8DOWNR.YYMM);
    }

     /**
     * 業務区分を設定します。
     * @param val String 業務区分
     */
    public void setHb8GyomKbn(String val) {
        set(TBTHB8DOWNR.GYOMKBN, val);
    }

    /**
     * 業務区分を返します。
     * @return String 業務区分
     */
    public String getHb8GyomKbn() {
        return (String) get(TBTHB8DOWNR.GYOMKBN);
    }

     /**
     * マス正味区分を設定します。
     * @param val String マス正味区分
     */
    public void setHb8MsKbn(String val) {
        set(TBTHB8DOWNR.MSKBN, val);
    }

    /**
     * マス正味区分を返します。
     * @return String マス正味区分
     */
    public String getHb8MsKbn() {
        return (String) get(TBTHB8DOWNR.MSKBN);
    }

     /**
     * タイムスポット区分を設定します。
     * @param val String タイムスポット区分
     */
    public void setHb8TmspKbn(String val) {
        set(TBTHB8DOWNR.TMSPKBN, val);
    }

    /**
     * タイムスポット区分を返します。
     * @return String タイムスポット区分
     */
    public String getHb8TmspKbn() {
        return (String) get(TBTHB8DOWNR.TMSPKBN);
    }

     /**
     * 国際区分を設定します。
     * @param val String 国際区分
     */
    public void setHb8KokKbn(String val) {
        set(TBTHB8DOWNR.KOKKBN, val);
    }

    /**
     * 国際区分を返します。
     * @return String 国際区分
     */
    public String getHb8KokKbn() {
        return (String) get(TBTHB8DOWNR.KOKKBN);
    }

     /**
     * 請求区分を設定します。
     * @param val String 請求区分
     */
    public void setHb8SeiKbn(String val) {
        set(TBTHB8DOWNR.SEIKBN, val);
    }

    /**
     * 請求区分を返します。
     * @return String 請求区分
     */
    public String getHb8SeiKbn() {
        return (String) get(TBTHB8DOWNR.SEIKBN);
    }

     /**
     * 商品NOを設定します。
     * @param val String 商品NO
     */
    public void setHb8SyoNo(String val) {
        set(TBTHB8DOWNR.SYONO, val);
    }

    /**
     * 商品NOを返します。
     * @return String 商品NO
     */
    public String getHb8SyoNo() {
        return (String) get(TBTHB8DOWNR.SYONO);
    }

     /**
     * 件名(漢字)を設定します。
     * @param val String 件名(漢字)
     */
    public void setHb8KKNameKJ(String val) {
        set(TBTHB8DOWNR.KKNAMEKJ, val);
    }

    /**
     * 件名(漢字)を返します。
     * @return String 件名(漢字)
     */
    public String getHb8KKNameKJ() {
        return (String) get(TBTHB8DOWNR.KKNAMEKJ);
    }

     /**
     * 営業画面タイプを設定します。
     * @param val String 営業画面タイプ
     */
    public void setHb8EgGamenType(String val) {
        set(TBTHB8DOWNR.EGGAMENTYPE, val);
    }

    /**
     * 営業画面タイプを返します。
     * @return String 営業画面タイプ
     */
    public String getHb8EgGamenType() {
        return (String) get(TBTHB8DOWNR.EGGAMENTYPE);
    }

     /**
     * 企画・製版区分を設定します。
     * @param val String 企画・製版区分
     */
    public void setHb8KkakShanKbn(String val) {
        set(TBTHB8DOWNR.KKAKSHANKBN, val);
    }

    /**
     * 企画・製版区分を返します。
     * @return String 企画・製版区分
     */
    public String getHb8KkakShanKbn() {
        return (String) get(TBTHB8DOWNR.KKAKSHANKBN);
    }

     /**
     * 取料金を設定します。
     * @param val BigDecimal 取料金
     */
    public void setHb8ToriGak(BigDecimal val) {
        set(TBTHB8DOWNR.TORIGAK, val);
    }

    /**
     * 取料金を返します。
     * @return BigDecimal 取料金
     */
    @XmlElement(required = true)
    public BigDecimal getHb8ToriGak() {
        return (BigDecimal) get(TBTHB8DOWNR.TORIGAK);
    }

     /**
     * 請求単価を設定します。
     * @param val BigDecimal 請求単価
     */
    public void setHb8SeiTnka(BigDecimal val) {
        set(TBTHB8DOWNR.SEITNKA, val);
    }

    /**
     * 請求単価を返します。
     * @return BigDecimal 請求単価
     */
    @XmlElement(required = true)
    public BigDecimal getHb8SeiTnka() {
        return (BigDecimal) get(TBTHB8DOWNR.SEITNKA);
    }

     /**
     * 請求金額を設定します。
     * @param val BigDecimal 請求金額
     */
    public void setHb8SeiGak(BigDecimal val) {
        set(TBTHB8DOWNR.SEIGAK, val);
    }

    /**
     * 請求金額を返します。
     * @return BigDecimal 請求金額
     */
    @XmlElement(required = true)
    public BigDecimal getHb8SeiGak() {
        return (BigDecimal) get(TBTHB8DOWNR.SEIGAK);
    }

     /**
     * 値引率を設定します。
     * @param val BigDecimal 値引率
     */
    public void setHb8NeviRitu(BigDecimal val) {
        set(TBTHB8DOWNR.NEBIRITU, val);
    }

    /**
     * 値引率を返します。
     * @return BigDecimal 値引率
     */
    @XmlElement(required = true)
    public BigDecimal getHb8NeviRitu() {
        return (BigDecimal) get(TBTHB8DOWNR.NEBIRITU);
    }

     /**
     * 値引額を設定します。
     * @param val BigDecimal 値引額
     */
    public void setHb8NeviGak(BigDecimal val) {
        set(TBTHB8DOWNR.NEBIGAK, val);
    }

    /**
     * 値引額を返します。
     * @return BigDecimal 値引額
     */
    @XmlElement(required = true)
    public BigDecimal getHb8NeviGak() {
        return (BigDecimal) get(TBTHB8DOWNR.NEBIGAK);
    }

     /**
     * 消費税区分を設定します。
     * @param val String 消費税区分
     */
    public void setHb8SzeiKbn(String val) {
        set(TBTHB8DOWNR.SZEIKBN, val);
    }

    /**
     * 消費税区分を返します。
     * @return String 消費税区分
     */
    public String getHb8SzeiKbn() {
        return (String) get(TBTHB8DOWNR.SZEIKBN);
    }

     /**
     * 消費税率を設定します。
     * @param val BigDecimal 消費税率
     */
    public void setHb8SzeiRitu(BigDecimal val) {
        set(TBTHB8DOWNR.SZEIRITU, val);
    }

    /**
     * 消費税率を返します。
     * @return BigDecimal 消費税率
     */
    @XmlElement(required = true)
    public BigDecimal getHb8SzeiRitu() {
        return (BigDecimal) get(TBTHB8DOWNR.SZEIRITU);
    }

     /**
     * 消費税額を設定します。
     * @param val BigDecimal 消費税額
     */
    public void setHb8SzeiGak(BigDecimal val) {
        set(TBTHB8DOWNR.SZEIGAK, val);
    }

    /**
     * 消費税額を返します。
     * @return BigDecimal 消費税額
     */
    @XmlElement(required = true)
    public BigDecimal getHb8SzeiGak() {
        return (BigDecimal) get(TBTHB8DOWNR.SZEIGAK);
    }

     /**
     * 費目名(漢字)を設定します。
     * @param val String 費目名(漢字)
     */
    public void setHb8HimkNmKJ(String val) {
        set(TBTHB8DOWNR.HIMKNMKJ, val);
    }

    /**
     * 費目名(漢字)を返します。
     * @return String 費目名(漢字)
     */
    public String getHb8HimkNmKJ() {
        return (String) get(TBTHB8DOWNR.HIMKNMKJ);
    }

     /**
     * 費目名(カナ)を設定します。
     * @param val String 費目名(カナ)
     */
    public void setHb8HimkNmKN(String val) {
        set(TBTHB8DOWNR.HIMKNMKN, val);
    }

    /**
     * 費目名(カナ)を返します。
     * @return String 費目名(カナ)
     */
    public String getHb8HimkNmKN() {
        return (String) get(TBTHB8DOWNR.HIMKNMKN);
    }

     /**
     * 統合先受注Noを設定します。
     * @param val String 統合先受注No
     */
    public void setHb8TJyutNo(String val) {
        set(TBTHB8DOWNR.TJYUTNO, val);
    }

    /**
     * 統合先受注Noを返します。
     * @return String 統合先受注No
     */
    public String getHb8TJyutNo() {
        return (String) get(TBTHB8DOWNR.TJYUTNO);
    }

     /**
     * 統合先受注明細Noを設定します。
     * @param val String 統合先受注明細No
     */
    public void setHb8TJyMeiNo(String val) {
        set(TBTHB8DOWNR.TJYMEINO, val);
    }

    /**
     * 統合先受注明細Noを返します。
     * @return String 統合先受注明細No
     */
    public String getHb8TJyMeiNo() {
        return (String) get(TBTHB8DOWNR.TJYMEINO);
    }

     /**
     * 統合先売上明細Noを設定します。
     * @param val String 統合先売上明細No
     */
    public void setHb8TUrMeiNo(String val) {
        set(TBTHB8DOWNR.TURMEINO, val);
    }

    /**
     * 統合先売上明細Noを返します。
     * @return String 統合先売上明細No
     */
    public String getHb8TUrMeiNo() {
        return (String) get(TBTHB8DOWNR.TURMEINO);
    }

     /**
     * 未請求フラグを設定します。
     * @param val String 未請求フラグ
     */
    public void setHb8MSeiFlg(String val) {
        set(TBTHB8DOWNR.MSEIFLG, val);
    }

    /**
     * 未請求フラグを返します。
     * @return String 未請求フラグ
     */
    public String getHb8MSeiFlg() {
        return (String) get(TBTHB8DOWNR.MSEIFLG);
    }

     /**
     * 変更前年月を設定します。
     * @param val String 変更前年月
     */
    public void setHb8YymmOld(String val) {
        set(TBTHB8DOWNR.YYMMOLD, val);
    }

    /**
     * 変更前年月を返します。
     * @return String 変更前年月
     */
    public String getHb8YymmOld() {
        return (String) get(TBTHB8DOWNR.YYMMOLD);
    }

     /**
     * フィールド1を設定します。
     * @param val String フィールド1
     */
    public void setHb8Field1(String val) {
        set(TBTHB8DOWNR.FIELD1, val);
    }

    /**
     * フィールド1を返します。
     * @return String フィールド1
     */
    public String getHb8Field1() {
        return (String) get(TBTHB8DOWNR.FIELD1);
    }

     /**
     * フィールド２を設定します。
     * @param val String フィールド２
     */
    public void setHb8Field2(String val) {
        set(TBTHB8DOWNR.FIELD2, val);
    }

    /**
     * フィールド２を返します。
     * @return String フィールド２
     */
    public String getHb8Field2() {
        return (String) get(TBTHB8DOWNR.FIELD2);
    }

     /**
     * フィールド３を設定します。
     * @param val String フィールド３
     */
    public void setHb8Field3(String val) {
        set(TBTHB8DOWNR.FIELD3, val);
    }

    /**
     * フィールド３を返します。
     * @return String フィールド３
     */
    public String getHb8Field3() {
        return (String) get(TBTHB8DOWNR.FIELD3);
    }

     /**
     * フィールド４を設定します。
     * @param val String フィールド４
     */
    public void setHb8Field4(String val) {
        set(TBTHB8DOWNR.FIELD4, val);
    }

    /**
     * フィールド４を返します。
     * @return String フィールド４
     */
    public String getHb8Field4() {
        return (String) get(TBTHB8DOWNR.FIELD4);
    }

     /**
     * フィールド５を設定します。
     * @param val String フィールド５
     */
    public void setHb8Field5(String val) {
        set(TBTHB8DOWNR.FIELD5, val);
    }

    /**
     * フィールド５を返します。
     * @return String フィールド５
     */
    public String getHb8Field5() {
        return (String) get(TBTHB8DOWNR.FIELD5);
    }

     /**
     * フィールド６を設定します。
     * @param val String フィールド６
     */
    public void setHb8Field6(String val) {
        set(TBTHB8DOWNR.FIELD6, val);
    }

    /**
     * フィールド６を返します。
     * @return String フィールド６
     */
    public String getHb8Field6() {
        return (String) get(TBTHB8DOWNR.FIELD6);
    }

     /**
     * フィールド７を設定します。
     * @param val String フィールド７
     */
    public void setHb8Field7(String val) {
        set(TBTHB8DOWNR.FIELD7, val);
    }

    /**
     * フィールド７を返します。
     * @return String フィールド７
     */
    public String getHb8Field7() {
        return (String) get(TBTHB8DOWNR.FIELD7);
    }

     /**
     * フィールド８を設定します。
     * @param val String フィールド８
     */
    public void setHb8Field8(String val) {
        set(TBTHB8DOWNR.FIELD8, val);
    }

    /**
     * フィールド８を返します。
     * @return String フィールド８
     */
    public String getHb8Field8() {
        return (String) get(TBTHB8DOWNR.FIELD8);
    }

     /**
     * フィールド９を設定します。
     * @param val String フィールド９
     */
    public void setHb8Field9(String val) {
        set(TBTHB8DOWNR.FIELD9, val);
    }

    /**
     * フィールド９を返します。
     * @return String フィールド９
     */
    public String getHb8Field9() {
        return (String) get(TBTHB8DOWNR.FIELD9);
    }

     /**
     * フィールド１０を設定します。
     * @param val String フィールド１０
     */
    public void setHb8Field10(String val) {
        set(TBTHB8DOWNR.FIELD10, val);
    }

    /**
     * フィールド１０を返します。
     * @return String フィールド１０
     */
    public String getHb8Field10() {
        return (String) get(TBTHB8DOWNR.FIELD10);
    }

     /**
     * フィールド１１を設定します。
     * @param val String フィールド１１
     */
    public void setHb8Field11(String val) {
        set(TBTHB8DOWNR.FIELD11, val);
    }

    /**
     * フィールド１１を返します。
     * @return String フィールド１１
     */
    public String getHb8Field11() {
        return (String) get(TBTHB8DOWNR.FIELD11);
    }

     /**
     * フィールド１２を設定します。
     * @param val String フィールド１２
     */
    public void setHb8Field12(String val) {
        set(TBTHB8DOWNR.FIELD12, val);
    }

    /**
     * フィールド１２を返します。
     * @return String フィールド１２
     */
    public String getHb8Field12() {
        return (String) get(TBTHB8DOWNR.FIELD12);
    }

    /**
    * ダウンロードファイルタイムスタンプを設定します。
    * @param val String ダウンロードファイルタイムスタンプ
    */
    public void setHb8FileTimStmp(String val) {
        set(TBTHB8DOWNR.FILETIMSTMP, val);
    }

    /**
    * ダウンロードファイルタイムスタンプを返します。
    * @return String ダウンロードファイルタイムスタンプ
    */
    public String getHb8FileTimStmp() {
        return (String) get(TBTHB8DOWNR.FILETIMSTMP);
    }

    /**
    * 明細登録日時を設定します。
    * @param val String 明細登録日時
    */
    public void setHb8MeiTimStmp(String val) {
        set(TBTHB8DOWNR.MEITIMSTMP, val);
    }

    /**
     * 明細登録日時を返します。
     * @return String 明細登録日時
     */
    public String getHb8MeiTimStmp() {
        return (String) get(TBTHB8DOWNR.MEITIMSTMP);
    }

}

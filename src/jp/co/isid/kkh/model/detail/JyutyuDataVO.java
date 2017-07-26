package jp.co.isid.kkh.model.detail;

import java.math.BigDecimal;
import java.util.Date;

import javax.xml.bind.annotation.XmlElement;

import jp.co.isid.kkh.integ.tbl.TBTHB1DOWN;
import jp.co.isid.kkh.integ.tbl.TBTHB2KMEI;
import jp.co.isid.kkh.integ.tbl.TBTHB8DOWNR;
import jp.co.isid.kkh.integ.tbl.TBTHBAMST;
import jp.co.isid.kkh.integ.tbl.VWTHB_ADMURIAGEM;
import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * 受注一覧VO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2011/11/14 JSE K.Fukuda)<BR>
 * </P>
 * @author
 */
public class JyutyuDataVO extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /** ダミープロパティ */
    private String _dummy = null;

    /**
     * 新規インスタンスを構築します。
     */
    public JyutyuDataVO() {
    }

    /**
     * 新規インスタンスを構築します。
     *
     * @return 新規インスタンス
     */
    public Object newInstance() {
        return new JyutyuDataVO();
    }

    /**
     * ROWNUMを設定します。
     * @param val Date タイムスタンプ
     */
    public void setRowNum(int val) {
        set("ROWNUM", val);
    }

    /**
     * ROWNUMを返します。
     * @return int ROWNUM
     */
    public int getRowNum() {
        return (Integer) get("ROWNUM");
    }
    /**
     * 登録タイムスタンプを設定します。
     * @param val Date タイムスタンプ
     */
    public void setHb1TrkTimStmp(Date val) {
        set(TBTHB1DOWN.TRKTIMSTMP, val);
    }

    /**
     * 登録タイムスタンプを返します。
     * @return Date タイムスタンプ
     */
    public Date getHb1TrkTimStmp() {
        return (Date) get(TBTHB1DOWN.TRKTIMSTMP);
    }

     /**
     * 登録プログラムを設定します。
     * @param val String 更新プログラム
     */
    public void setHb1TrkApl(String val) {
        set(TBTHB1DOWN.TRKAPL, val);
    }

    /**
     * 登録プログラムを返します。
     * @return String 更新プログラム
     */
    public String getHb1TrkApl() {
        return (String) get(TBTHB1DOWN.TRKAPL);
    }

     /**
     * 登録担当者を設定します。
     * @param val String 登録担当者
     */
    public void setHb1TrkTnt(String val) {
        set(TBTHB1DOWN.TRKTNT, val);
    }

    /**
     * 登録担当者を返します。
     * @return String 登録担当者
     */
    public String getHb1TrkTnt() {
        return (String) get(TBTHB1DOWN.TRKTNT);
    }

   /**
    * タイムスタンプを設定します。
    * @param val Date タイムスタンプ
    */
   public void setHb1TimStmp(Date val) {
       set(TBTHB1DOWN.TIMSTMP, val);
   }

   /**
    * タイムスタンプを返します。
    * @return Date タイムスタンプ
    */
   public Date getHb1TimStmp() {
       return (Date) get(TBTHB1DOWN.TIMSTMP);
   }

    /**
    * 更新プログラムを設定します。
    * @param val String 更新プログラム
    */
   public void setHb1UpdApl(String val) {
       set(TBTHB1DOWN.UPDAPL, val);
   }

   /**
    * 更新プログラムを返します。
    * @return String 更新プログラム
    */
   public String getHb1UpdApl() {
       return (String) get(TBTHB1DOWN.UPDAPL);
   }

    /**
    * 更新担当者を設定します。
    * @param val String 更新担当者
    */
   public void setHb1UpdTnt(String val) {
       set(TBTHB1DOWN.UPDTNT, val);
   }

   /**
    * 更新担当者を返します。
    * @return String 更新担当者
    */
   public String getHb1UpdTnt() {
       return (String) get(TBTHB1DOWN.UPDTNT);
   }

    /**
    * 営業所（扱）コードを設定します。
    * @param val String 営業所（扱）コード
    */
   public void setHb1AtuEgCd(String val) {
       set(TBTHB1DOWN.ATUEGCD, val);
   }

   /**
    * 営業所（扱）コードを返します。
    * @return String 営業所（扱）コード
    */
   public String getHb1AtuEgCd() {
       return (String) get(TBTHB1DOWN.ATUEGCD);
   }

    /**
    * 営業所（取）コードを設定します。
    * @param val String 営業所（取）コード
    */
   public void setHb1EgCd(String val) {
       set(TBTHB1DOWN.EGCD, val);
   }

   /**
    * 営業所（取）コードを返します。
    * @return String 営業所（取）コード
    */
   public String getHb1EgCd() {
       return (String) get(TBTHB1DOWN.EGCD);
   }

    /**
    * 得意先企業コードを設定します。
    * @param val String 得意先企業コード
    */
   public void setHb1TksKgyCd(String val) {
       set(TBTHB1DOWN.TKSKGYCD, val);
   }

   /**
    * 得意先企業コードを返します。
    * @return String 得意先企業コード
    */
   public String getHb1TksKgyCd() {
       return (String) get(TBTHB1DOWN.TKSKGYCD);
   }

    /**
    * 得意先部門SEQNOを設定します。
    * @param val String 得意先部門SEQNO
    */
   public void setHb1TksBmnSeqNo(String val) {
       set(TBTHB1DOWN.TKSBMNSEQNO, val);
   }

   /**
    * 得意先部門SEQNOを返します。
    * @return String 得意先部門SEQNO
    */
   public String getHb1TksBmnSeqNo() {
       return (String) get(TBTHB1DOWN.TKSBMNSEQNO);
   }

    /**
    * 得意先担当SEQNOを設定します。
    * @param val String 得意先担当SEQNO
    */
   public void setHb1TksTntSeqNo(String val) {
       set(TBTHB1DOWN.TKSTNTSEQNO, val);
   }

   /**
    * 得意先担当SEQNOを返します。
    * @return String 得意先担当SEQNO
    */
   public String getHb1TksTntSeqNo() {
       return (String) get(TBTHB1DOWN.TKSTNTSEQNO);
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
    * ページNoを設定します。
    * @param val String ページNo
    */
   public void setHb1GpyoPag(String val) {
       set(TBTHB1DOWN.GPYOPAG, val);
   }

   /**
    * ページNoを返します。
    * @return String ページNo
    */
   public String getHb1GpyoPag() {
       return (String) get(TBTHB1DOWN.GPYOPAG);
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
    * 費目コードを設定します。
    * @param val String 費目コード
    */
   public void setHb1HimkCd(String val) {
       set(TBTHB1DOWN.HIMKCD, val);
   }

   /**
    * 費目コードを返します。
    * @return String 費目コード
    */
   public String getHb1HimkCd() {
       return (String) get(TBTHB1DOWN.HIMKCD);
   }

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
    * 年月を設定します。
    * @param val String 年月
    */
   public void setHb1Yymm(String val) {
       set(TBTHB1DOWN.YYMM, val);
   }

   /**
    * 年月を返します。
    * @return String 年月
    */
   public String getHb1Yymm() {
       return (String) get(TBTHB1DOWN.YYMM);
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
    * マス正味区分を設定します。
    * @param val String マス正味区分
    */
   public void setHb1MsKbn(String val) {
       set(TBTHB1DOWN.MSKBN, val);
   }

   /**
    * マス正味区分を返します。
    * @return String マス正味区分
    */
   public String getHb1MsKbn() {
       return (String) get(TBTHB1DOWN.MSKBN);
   }

    /**
    * タイムスポット区分を設定します。
    * @param val String タイムスポット区分
    */
   public void setHb1TmspKbn(String val) {
       set(TBTHB1DOWN.TMSPKBN, val);
   }

   /**
    * タイムスポット区分を返します。
    * @return String タイムスポット区分
    */
   public String getHb1TmspKbn() {
       return (String) get(TBTHB1DOWN.TMSPKBN);
   }

    /**
    * 国際区分を設定します。
    * @param val String 国際区分
    */
   public void setHb1KokKbn(String val) {
       set(TBTHB1DOWN.KOKKBN, val);
   }

   /**
    * 国際区分を返します。
    * @return String 国際区分
    */
   public String getHb1KokKbn() {
       return (String) get(TBTHB1DOWN.KOKKBN);
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
    * 商品NOを設定します。
    * @param val String 商品NO
    */
   public void setHb1SyoNo(String val) {
       set(TBTHB1DOWN.SYONO, val);
   }

   /**
    * 商品NOを返します。
    * @return String 商品NO
    */
   public String getHb1SyoNo() {
       return (String) get(TBTHB1DOWN.SYONO);
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
    * 営業画面タイプを設定します。
    * @param val String 営業画面タイプ
    */
   public void setHb1EgGamenType(String val) {
       set(TBTHB1DOWN.EGGAMENTYPE, val);
   }

   /**
    * 営業画面タイプを返します。
    * @return String 営業画面タイプ
    */
   public String getHb1EgGamenType() {
       return (String) get(TBTHB1DOWN.EGGAMENTYPE);
   }

    /**
    * 企画・製版区分を設定します。
    * @param val String 企画・製版区分
    */
   public void setHb1KkakShanKbn(String val) {
       set(TBTHB1DOWN.KKAKSHANKBN, val);
   }

   /**
    * 企画・製版区分を返します。
    * @return String 企画・製版区分
    */
   public String getHb1KkakShanKbn() {
       return (String) get(TBTHB1DOWN.KKAKSHANKBN);
   }

    /**
    * 取料金を設定します。
    * @param val BigDecimal 取料金
    */
   public void setHb1ToriGak(BigDecimal val) {
       set(TBTHB1DOWN.TORIGAK, val);
   }

   /**
    * 取料金を返します。
    * @return BigDecimal 取料金
    */
   public BigDecimal getHb1ToriGak() {
       return (BigDecimal) get(TBTHB1DOWN.TORIGAK);
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
   public BigDecimal getHb1SeiGak() {
       return (BigDecimal) get(TBTHB1DOWN.SEIGAK);
   }

    /**
    * 値引率を設定します。
    * @param val BigDecimal 値引率
    */
   public void setHb1NeviRitu(BigDecimal val) {
       set(TBTHB1DOWN.NEBIRITU, val);
   }

   /**
    * 値引率を返します。
    * @return BigDecimal 値引率
    */
   public BigDecimal getHb1NeviRitu() {
       return (BigDecimal) get(TBTHB1DOWN.NEBIRITU);
   }

    /**
    * 値引額を設定します。
    * @param val BigDecimal 値引額
    */
   public void setHb1NeviGak(BigDecimal val) {
       set(TBTHB1DOWN.NEBIGAK, val);
   }

   /**
    * 値引額を返します。
    * @return BigDecimal 値引額
    */
   public BigDecimal getHb1NeviGak() {
       return (BigDecimal) get(TBTHB1DOWN.NEBIGAK);
   }

    /**
    * 消費税区分を設定します。
    * @param val String 消費税区分
    */
   public void setHb1SzeiKbn(String val) {
       set(TBTHB1DOWN.SZEIKBN, val);
   }

   /**
    * 消費税区分を返します。
    * @return String 消費税区分
    */
   public String getHb1SzeiKbn() {
       return (String) get(TBTHB1DOWN.SZEIKBN);
   }

    /**
    * 消費税率を設定します。
    * @param val BigDecimal 消費税率
    */
   public void setHb1SzeiRitu(BigDecimal val) {
       set(TBTHB1DOWN.SZEIRITU, val);
   }

   /**
    * 消費税率を返します。
    * @return BigDecimal 消費税率
    */
   public BigDecimal getHb1SzeiRitu() {
       return (BigDecimal) get(TBTHB1DOWN.SZEIRITU);
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
    * 費目名(カナ)を設定します。
    * @param val String 費目名(カナ)
    */
   public void setHb1HimkNmKN(String val) {
       set(TBTHB1DOWN.HIMKNMKN, val);
   }

   /**
    * 費目名(カナ)を返します。
    * @return String 費目名(カナ)
    */
   public String getHb1HimkNmKN() {
       return (String) get(TBTHB1DOWN.HIMKNMKN);
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
   public void setHb1TJyMeiNo(String val) {
       set(TBTHB1DOWN.TJYMEINO, val);
   }

   /**
    * 統合先受注明細Noを返します。
    * @return String 統合先受注明細No
    */
   public String getHb1TJyMeiNo() {
       return (String) get(TBTHB1DOWN.TJYMEINO);
   }

    /**
    * 統合先売上明細Noを設定します。
    * @param val String 統合先売上明細No
    */
   public void setHb1TUrMeiNo(String val) {
       set(TBTHB1DOWN.TURMEINO, val);
   }

   /**
    * 統合先売上明細Noを返します。
    * @return String 統合先売上明細No
    */
   public String getHb1TUrMeiNo() {
       return (String) get(TBTHB1DOWN.TURMEINO);
   }

    /**
    * 未請求フラグを設定します。
    * @param val String 未請求フラグ
    */
   public void setHb1MSeiFlg(String val) {
       set(TBTHB1DOWN.MSEIFLG, val);
   }

   /**
    * 未請求フラグを返します。
    * @return String 未請求フラグ
    */
   public String getHb1MSeiFlg() {
       return (String) get(TBTHB1DOWN.MSEIFLG);
   }

    /**
    * 変更前年月を設定します。
    * @param val String 変更前年月
    */
   public void setHb1YymmOld(String val) {
       set(TBTHB1DOWN.YYMMOLD, val);
   }

   /**
    * 変更前年月を返します。
    * @return String 変更前年月
    */
   public String getHb1YymmOld() {
       return (String) get(TBTHB1DOWN.YYMMOLD);
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
    * hb2JyutNoを設定します。
    * @param val String hb2JyutNo
    */
   public void setHb2JyutNo(String val) {
       set(TBTHB2KMEI.JYUTNO, val);
   }

   /**
    * hb2JyutNoを返します。
    * @return String hb2JyutNo
    */
   public String getHb2JyutNo() {
       return (String) get(TBTHB2KMEI.JYUTNO);
   }

    /**
    * hb2SeiGakを設定します。
    * @param val BigDecimal hb2SeiGak
    */
   public void setHb2SeiGak(BigDecimal val) {
       set(TBTHB2KMEI.SEIGAK, val);
   }

   /**
    * hb2SeiGakを返します。
    * @return BigDecimal hb2SeiGak
    */
   public BigDecimal getHb2SeiGak() {
       return (BigDecimal) get(TBTHB2KMEI.SEIGAK);
   }

    /**
    * gyomBanを設定します。
    * @param val String gyomBan
    */
   public void setGyomBan(String val) {
       set("GYOMBAN", val);
   }

   /**
    * gyomBanを返します。
    * @return String gyomBan
    */
   public String getGyomBan() {
       return (String) get("GYOMBAN");
   }

   /**
    * detailCntを設定します。
    * @param val BigDecimal detailCnt
    */
   public void setDetailCnt(BigDecimal val) {
       set("DETAILCNT", val);
   }

   /**
    * detailCntを返します。
    * @return Decimal detailCnt
    */
   @XmlElement(required = true)
   public BigDecimal getDetailCnt() {
       return (BigDecimal) get("DETAILCNT");
   }

   /**
    * ダウンロードファイルタイムスタンプを設定します。
    * @param val String ダウンロードファイルタイムスタンプ
    */
    public void setHb1FileTimStmp(String val) {
        set(TBTHB1DOWN.FILETIMSTMP, val);
    }

    /**
    * ダウンロードファイルタイムスタンプを返します。
    * @return String ダウンロードファイルタイムスタンプ
    */
    public String getHb1FileTimStmp() {
        return (String) get(TBTHB1DOWN.FILETIMSTMP);
    }

   /**
    * 明細登録日時(履歴)を設定します。
    * @param val String RMeiTimStmp
    */
   public void setRMeiTimStmp(String val) {
       set(TBTHB8DOWNR.MEITIMSTMP, val);
   }

   /**
    * 明細登録日時(履歴)を返します。
    * @return String RMeiTimStmp
    */
   public String getRMeiTimStmp() {
       return (String) get(TBTHB8DOWNR.MEITIMSTMP);
   }

   /**
    * 受注削除フラグを取得する
    * @return 受注削除フラグ
    */
   public String getJyutDelFlg() {
       return (String) get(TBTHB1DOWN.JYUTDELFLG);
   }

   /**
    * 受注削除フラグを設定する
    * @param val 受注削除フラグ
    */
   public void setJyutDelFlg(String val) {
       set(TBTHB1DOWN.JYUTDELFLG, val);
   }

   /**
    * 請求状態を取得する
    * @return 請求状態
    */
   public String getSeikJtai() {
       return (String) get(VWTHB_ADMURIAGEM.SEIKJTAI);
   }

   /**
    * 請求状態を設定する
    * @param val 請求状態
    */
   public void setSeikJtai(String val) {
       set(VWTHB_ADMURIAGEM.SEIKJTAI, val);
   }

   /**
    * 請求作業ステータスを取得する
    * @return 請求作業ステータス
    */
   public String getSeiSagSts() {
       return (String) get(VWTHB_ADMURIAGEM.SEISAGSTS);
   }

   /**
    * 請求作業ステータスを設定する
    * @param val 請求作業ステータス
    */
   public void setSeiSagSts(String val) {
       set(VWTHB_ADMURIAGEM.SEISAGSTS, val);
   }

   /**
    * 中止区分を取得する
    * @return 中止区分
    */
   public String getStpKbn() {
       return (String) get(VWTHB_ADMURIAGEM.STPKBN);
   }

   /**
    * 中止区分を設定する
    * @param val 中止区分
    */
   public void setStpKbn(String val) {
       set(VWTHB_ADMURIAGEM.STPKBN, val);
   }

   /**
    * 登録担当者名を返します
    * @return String 登録担当者名
    */
   public String getHb1TrkTntNm() {
       return (String) get(TBTHB1DOWN.TRKTNTNM);
   }

   /**
    * 登録担当者名設定します
    * @param val 登録担当者
    */
   public void setHb1TrkTntNm(String val) {
       set(TBTHB1DOWN.TRKTNTNM, val);
   }

   /**
    * 明細更新タイムスタンプを返します
    * @return String 登録担当者名
    */
   @XmlElement(required = true)
   public Date getHb1KsnTimStmp() {
       return (Date) get(TBTHB1DOWN.KSNTIMSTMP);
   }

   /**
    * 明細更新タイムスタンプを設定します
    * @param val 登録担当者
    */
   public void setHb1KsnTimStmp(Date val) {
       set(TBTHB1DOWN.KSNTIMSTMP, val);
   }

   /**
    * 明細更新者を返します
    * @return String 明細更新者
    */
   public String getHb1KsnTnt() {
       return (String) get(TBTHB1DOWN.KSNTNT);
   }

   /**
    * 明細更新者を設定します
    * @param val 明細更新者
    */
   public void setHb1KsnTnt(String val) {
       set(TBTHB1DOWN.KSNTNT, val);
   }

   /**
    * 明細更新者名を返します
    * @return String 明細更新者名
    */
   public String getHb1KsnTntNm() {
       return (String) get(TBTHB1DOWN.KSNTNTNM);
   }

   /**
    * 明細更新者名を設定します
    * @param val 明細更新者名
    */
   public void setHb1KsnTntNm(String val) {
       set(TBTHB1DOWN.KSNTNTNM, val);
   }

   /**
    * スペース２を返します
    * @return String 明細更新者名
    */
   public String getSpace2() {
       return (String) get(TBTHBAMST.FIELD2);
   }

   /**
    * スペース２を設定します
    * @param val 明細更新者名
    */
   public void setSpace2(String val) {
       set(TBTHBAMST.FIELD2, val);
   }

   //2013/03/06 jse okazaki 公文対応　Start
   /**
    * 請求回収ステータスを返します
    * @return String 請求回収ステータス
    */
   public String getSeikyu() {
       return (String) get("SEIKYU");
   }

   /**
    * 請求回収ステータスを設定します
    * @param val 請求回収ステータス
    */
   public void setSeikyu(String val) {
       set("SEIKYU", val);
   }
   //2013/03/06 jse okazaki 公文対応　End

   /**
    * ダミープロパティを取得する
    * @return ダミープロパティ
    */
   public String getDummy() {
       return _dummy;
   }

   /**
    * ダミープロパティを設定する
    * @param dummy ダミープロパティ
    */
   public void setDummy(String dummy) {
       this._dummy = dummy;
   }

}

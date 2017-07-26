package jp.co.isid.kkh.customer.lion.model.report;

import java.math.BigDecimal;

import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * ライオン帳票(制作室リスト)検索結果VO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2014/07/31 HLC S.Fujimoto)<BR>
 * </P>
 *
 * @author HLC S.Fujimoto
 */
public class AddChangeReportLionSeisakuVO extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /** 営業所(取)コード */
    public static final String EGCD = "EGCD";
    /** 得意先企業コード */
    public static final String TKSKGYCD = "TKSKGYCD";
    /** 得意先部門SEQNO */
    public static final String TKSBMNSEQNO = "TKSBMNSEQNO";
    /** 得意先担当SEQNO */
    public static final String TKSTNTSEQNO = "TKSTNTSEQNO";

    /** 履歴タイムスタンプ */
    public static final String RRKTIMSTMP = "RRKTIMSTMP";

    /** 受注No */
    public static final String JYUTNO = "JYUTNO";
    /** 受注明細No */
    public static final String JYMEINO = "JYMEINO";
    /** 売上明細No */
    public static final String URMEINO = "URMEINO";
    /** AD1媒体区分コード */
    public static final String BAITAIKBN = "BAITAIKBN";
    /** AD1媒体区分名 */
    public static final String BAITAINM = "BAITAINM";
    /** AD1ブランドコード */
    public static final String BRDCD = "BRDCD";
    /** AD1ブランド名 */
    public static final String BRDNM = "BRDNM";
    /** AD1ジャンルコード */
    public static final String JUNLECD = "JUNLECD";   //SQLのみで使用するため、getter/setterなし
    /** AD1件名 */
    public static final String KENNM = "KENNM";
    /** AD1請求金額 */
    public static final String SEIGAK = "SEIGAK";
    /** AD1消費税額 */
    public static final String TAXAMT = "TAXAMT";
    /** AD1媒体区分コード */
    public static final String AD1BAITAIKBN = "AD1BAITAIKBN";
    /** AD1媒体区分名 */
    public static final String AD1BAITAINM = "AD1BAITAINM";
    /** AD1ブランドコード */
    public static final String AD1BRDCD = "AD1BRDCD";
    /** AD1ブランド名 */
    public static final String AD1BRDNM = "AD1BRDNM";
    /** AD1ジャンルコード */
    public static final String AD1JUNLECD = "AD1JUNLECD";   //SQLのみで使用するため、getter/setterなし
    /** AD1件名 */
    public static final String AD1KENNM = "AD1KENNM";
    /** AD1請求金額 */
    public static final String AD1SEIGAK = "AD1SEIGAK";
    /** AD1消費税額 */
    public static final String AD1TAXAMT = "AD1TAXAMT";
    /** AD2媒体区分コード */
    public static final String AD2BAITAIKBN = "AD2BAITAIKBN";
    /** AD2媒体区分名 */
    public static final String AD2BAITAINM = "AD2BAITAINM";
    /** AD2ブランドコード */
    public static final String AD2BRDCD = "AD2BRDCD";
    /** AD2ブランド名 */
    public static final String AD2BRDNM = "AD2BRDNM";
    /** AD2ジャンルコード */
    public static final String AD2JUNLECD = "AD2JUNLECD";   //SQLのみで使用するため、getter/setterなし
    /** AD2件名 */
    public static final String AD2KENNM = "AD2KENNM";
    /** AD2請求金額 */
    public static final String AD2SEIGAK = "AD2SEIGAK";
    /** AD2消費税額 */
    public static final String AD2TAXAMT = "AD2TAXAMT";
    /** 変更点 */
    public static final String CHGPNT = "CHGPNT";
    /** SEQ(追加:1、削除:2、変更:3) */
    public static final String SEQ = "SEQ";

    /**
     * 新規インスタンスを構築します。
     */
    public AddChangeReportLionSeisakuVO() {
    }

    /**
     * 新規インスタンスを構築します。
     * @return 新規インスタンス
     */
    public Object newInstance() {
        return new AddChangeReportLionSeisakuVO();
    }

    /**
     * 営業所(取)コードを取得する
     * @return 営業所(取)コード
     */
    public String getEgcd() {
        return (String) get(EGCD);
    }

    /**
     * 営業所(取)コードを設定する
     * @param val String 営業所(取)コード
     */
    public void setEgcd(String val) {
        set(EGCD, val);
    }

    /**
     * 得意先企業コードを取得する
     * @return 得意先企業コード
     */
    public String getTksKgyCd() {
        return (String) get(TKSKGYCD);
    }

    /**
     * 得意先企業コードを設定する
     * @param val String 得意先企業コード
     */
    public void setTksKgyCd(String val) {
        set(TKSKGYCD, val);
    }

    /**
     * 得意先部門SEQNOを取得する
     * @return 得意先部門SEQNO
     */
    public String getTksBmnSeqNo() {
        return (String) get(TKSBMNSEQNO);
    }

    /**
     * 得意先部門SEQNOを設定する
     * @param val String 得意先部門SEQNO
     */
    public void setTksBmnSeqNo(String val) {
        set(TKSBMNSEQNO, val);
    }

    /**
     * 得意先担当SEQNOを取得する
     * @return 得意先担当SEQNO
     */
    public String getTksTntSeqNo() {
        return (String) get(TKSTNTSEQNO);
    }

    /**
     * 得意先担当SEQNOを設定する
     * @param val String 得意先担当SEQNO
     */
    public void setTksTntSeqNo(String val) {
        set(TKSTNTSEQNO, val);
    }

    /**
     * 履歴タイムスタンプを取得する
     * @return 履歴タイムスタンプ
     */
    public String getRrkTimStmp() {
        return (String) get(RRKTIMSTMP);
    }

    /**
     * 履歴タイムスタンプを設定する
     * @param val String 履歴タイムスタンプ
     */
    public void setRrkTimStmp(String val) {
        set(RRKTIMSTMP, val);
    }

    /** 受注Noを取得する
     * @return 受注No
     */
    public String getJyutno() {
        return (String) get(JYUTNO);
    }

    /**
     * 受注Noを設定する
     * @param val String 受注No
     */
    public void setJyutno(String val) {
        set(JYUTNO, val);
    }

    /**
     * 受注明細Noを取得する
     * @return 受注明細No
     */
    public String getJymeino() {
        return (String) get(JYMEINO);
    }

    /**
     * 受注明細Noを設定する
     * @param val String 受注明細No
     */
    public void setJymeino(String val) {
        set(JYMEINO, val);
    }

    /**
     * 売上明細Noを取得する
     * @return 売上明細No
     */
    public String getUrmeino() {
        return (String) get(URMEINO);
    }

    /**
     * 売上明細Noを設定する
     * @param val String 売上明細No
     */
    public void setUrmeino(String val) {
        set(URMEINO, val);
    }

    /**
     * 媒体区分コードを取得する
     * @return 媒体区分
     */
    public String getBaitaiKbn() {
        return (String) get(BAITAIKBN);
    }

    /**
     * 媒体区分コードを設定する
     * @param val String 媒体区分
     */
    public void setBaitaiKbn(String val) {
        set(BAITAIKBN, val);
    }

    /**
     * 媒体区分名を取得する
     * @return 媒体区分名
     */
    public String getBaitaiNm() {
        return (String) get(BAITAINM);
    }

    /**
     * 媒体区分名を設定する
     * @param val String 媒体区分名
     */
    public void setBaitaiNm(String val) {
        set(BAITAINM, val);
    }

    /**
     * ブランドコードを取得する
     * @return ブランドコード
     */
    public String getBrdCd() {
        return (String) get(BRDCD);
    }

    /**
     * ブランドコードを設定する
     * @param val String ブランドコード
     */
    public void setBrdCd(String val) {
        set(BRDCD, val);
    }

    /**
     * ブランド名を取得する
     * @return ブランド名
     */
    public String getBrdNm() {
        return (String) get(BRDNM);
    }

    /**
     * ブランド名を設定する
     * @param val String ブランド名
     */
    public void setBrdNm(String val) {
        set(BRDNM, val);
    }

    /**
     * 件名を取得する
     * @return 件名
     */
    public String getKenNm() {
        return (String) get(KENNM);
    }

    /**
     * 件名を設定する
     * @param val String 件名
     */
    public void setKenNm(String val) {
        set(KENNM, val);
    }

    /**
     * 請求金額を取得する
     * @return 請求金額
     */
    public BigDecimal getSeigak() {
        return (BigDecimal) get(SEIGAK);
    }

    /**
     * 請求金額を設定する
     * @param val BigDecimal 請求金額
     */
    public void setSeigak(BigDecimal val) {
        set(SEIGAK, val);
    }

    /**
     * 消費税額を取得する
     * @return 消費税額
     */
    public BigDecimal getTaxAmt() {
        return (BigDecimal) get(TAXAMT);
    }

    /**
     * 消費税額を設定する
     * @param val BigDecimal 消費税額
     */
    public void setTaxAmt(BigDecimal val) {
        set(TAXAMT, val);
    }

    /**
     * AD1媒体区分コードを取得する
     * @return AD1媒体区分
     */
    public String getAD1BaitaiKbn() {
        return (String) get(AD1BAITAIKBN);
    }

    /**
     * AD1媒体区分コードを設定する
     * @param val String AD1媒体区分
     */
    public void setAD1BaitaiKbn(String val) {
        set(AD1BAITAIKBN, val);
    }

    /**
     * AD1媒体区分名を取得する
     * @return AD1媒体区分名
     */
    public String getAD1BaitaiNm() {
        return (String) get(AD1BAITAINM);
    }

    /**
     * AD1媒体区分名を設定する
     * @param val String AD1媒体区分名
     */
    public void setAD1BaitaiNm(String val) {
        set(AD1BAITAINM, val);
    }

    /**
     * AD1ブランドコードを取得する
     * @return AD1ブランドコード
     */
    public String getAD1BrdCd() {
        return (String) get(AD1BRDCD);
    }

    /**
     * AD1ブランドコードを設定する
     * @param val String AD1ブランドコード
     */
    public void setAD1BrdCd(String val) {
        set(AD1BRDCD, val);
    }

    /**
     * AD1ブランド名を取得する
     * @return AD1ブランド名
     */
    public String getAD1BrdNm() {
        return (String) get(AD1BRDNM);
    }

    /**
     * AD1ブランド名を設定する
     * @param val String AD1ブランド名
     */
    public void setAD1BrdNm(String val) {
        set(AD1BRDNM, val);
    }

    /**
     * AD1件名を取得する
     * @return AD1件名
     */
    public String getAD1KenNm() {
        return (String) get(AD1KENNM);
    }

    /**
     * AD1件名を設定する
     * @param val String AD1件名
     */
    public void setAD1KenNm(String val) {
        set(AD1KENNM, val);
    }

    /**
     * AD1請求金額を取得する
     * @return AD1請求金額
     */
    public BigDecimal getAD1Seigak() {
        return (BigDecimal) get(AD1SEIGAK);
    }

    /**
     * AD1請求金額を設定する
     * @param val BigDecimal AD1請求金額
     */
    public void setAD1Seigak(BigDecimal val) {
        set(AD1SEIGAK, val);
    }

    /**
     * AD1消費税額を取得する
     * @return AD1消費税額
     */
    public BigDecimal getAD1TaxAmt() {
        return (BigDecimal) get(AD1TAXAMT);
    }

    /**
     * AD1消費税額を設定する
     * @param val BigDecimal AD1消費税額
     */
    public void setAD1TaxAmt(BigDecimal val) {
        set(AD1TAXAMT, val);
    }

    /**
     * AD2媒体区分コードを取得する
     * @return AD2媒体区分
     */
    public String getAD2BaitaiKbn() {
        return (String) get(AD2BAITAIKBN);
    }

    /**
     * AD2媒体区分コードを設定する
     * @param val String AD2媒体区分
     */
    public void setAD2BaitaiKbn(String val) {
        set(AD2BAITAIKBN, val);
    }

    /**
     * AD2媒体区分名を取得する
     * @return AD2媒体区分名
     */
    public String getAD2BaitaiNm() {
        return (String) get(AD2BAITAINM);
    }

    /**
     * AD2媒体区分名を設定する
     * @param val String AD2媒体区分名
     */
    public void setAD2BaitaiNm(String val) {
        set(AD2BAITAINM, val);
    }

    /**
     * AD2ブランドコードを取得する
     * @return AD2ブランドコード
     */
    public String getAD2BrdCd() {
        return (String) get(AD2BRDCD);
    }

    /**
     * AD2ブランドコードを設定する
     * @param val String AD2ブランドコード
     */
    public void setAD2BrdCd(String val) {
        set(AD2BRDCD, val);
    }

    /**
     * AD2ブランド名を取得する
     * @return AD2ブランド名
     */
    public String getAD2BrdNm() {
        return (String) get(AD2BRDNM);
    }

    /**
     * AD2ブランド名を設定する
     * @param val String AD2ブランド名
     */
    public void setAD2BrdNm(String val) {
        set(AD2BRDNM, val);
    }

    /**
     * AD2件名を取得する
     * @return AD2件名
     */
    public String getAD2KenNm() {
        return (String) get(AD2KENNM);
    }

    /**
     * AD2件名を設定する
     * @param val String AD2件名
     */
    public void setAD2KenNm(String val) {
        set(AD2KENNM, val);
    }

    /**
     * AD2請求金額を取得する
     * @return AD2請求金額
     */
    public BigDecimal getAD2Seigak() {
        return (BigDecimal) get(AD2SEIGAK);
    }

    /**
     * AD2請求金額を設定する
     * @param val BigDecimal AD2請求金額
     */
    public void setAD2Seigak(BigDecimal val) {
        set(AD2SEIGAK, val);
    }

    /**
     * AD2消費税額を取得する
     * @return AD2消費税額
     */
    public BigDecimal getAD2TaxAmt() {
        return (BigDecimal) get(AD2TAXAMT);
    }

    /**
     * AD2消費税額を設定する
     * @param val BigDecimal AD2消費税額
     */
    public void setAD2TaxAmt(BigDecimal val) {
        set(AD2TAXAMT, val);
    }

    /**
     * 変更点を取得する
     * @return 変更点
     */
    public String getChgPnt() {
        return ((String) get(CHGPNT));
    }

    /**
     * 変更点を設定する
     * @param val String 変更点
     */
    public void setChgPnt(String val) {
        set(CHGPNT, val);
    }

    /**
     * SEQを取得する
     * @return SEQ
     */
    public String getSEQ() {
        return ((String) get(SEQ));
    }

    /**
     * SEQを設定する
     * @param val String SEQ
     */
    public void setSEQ(String val) {
        set(SEQ, val);
    }

}